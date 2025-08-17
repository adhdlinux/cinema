package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@TargetApi(23)
public abstract class ReactBaseTextShadowNode extends LayoutShadowNode {
    public static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
    private static final String INLINE_VIEW_PLACEHOLDER = "0";
    public static final String PROP_SHADOW_COLOR = "textShadowColor";
    public static final String PROP_SHADOW_OFFSET = "textShadowOffset";
    public static final String PROP_SHADOW_OFFSET_HEIGHT = "height";
    public static final String PROP_SHADOW_OFFSET_WIDTH = "width";
    public static final String PROP_SHADOW_RADIUS = "textShadowRadius";
    public static final String PROP_TEXT_TRANSFORM = "textTransform";
    public static final int UNSET = -1;
    protected boolean mAdjustsFontSizeToFit;
    protected int mBackgroundColor;
    protected int mColor;
    protected boolean mContainsImages;
    protected String mFontFamily;
    protected String mFontFeatureSettings;
    protected int mFontStyle;
    protected int mFontWeight;
    protected int mHyphenationFrequency;
    protected boolean mIncludeFontPadding;
    protected Map<Integer, ReactShadowNode> mInlineViews;
    protected boolean mIsAccessibilityLink;
    protected boolean mIsBackgroundColorSet;
    protected boolean mIsColorSet;
    protected boolean mIsLineThroughTextDecorationSet;
    protected boolean mIsUnderlineTextDecorationSet;
    protected int mJustificationMode;
    protected float mMinimumFontScale;
    protected int mNumberOfLines;
    protected ReactTextViewManagerCallback mReactTextViewManagerCallback;
    protected int mTextAlign;
    protected TextAttributes mTextAttributes;
    protected int mTextBreakStrategy;
    protected int mTextShadowColor;
    protected float mTextShadowOffsetDx;
    protected float mTextShadowOffsetDy;
    protected float mTextShadowRadius;

    private static class SetSpanOperation {
        protected int end;
        protected int start;
        protected ReactSpan what;

        SetSpanOperation(int i2, int i3, ReactSpan reactSpan) {
            this.start = i2;
            this.end = i3;
            this.what = reactSpan;
        }

        public void execute(SpannableStringBuilder spannableStringBuilder, int i2) {
            int i3;
            int i4 = this.start;
            if (i4 == 0) {
                i3 = 18;
            } else {
                i3 = 34;
            }
            spannableStringBuilder.setSpan(this.what, i4, this.end, ((i2 << 16) & 16711680) | (i3 & -16711681));
        }
    }

    public ReactBaseTextShadowNode() {
        this((ReactTextViewManagerCallback) null);
    }

    private static void buildSpannedFromShadowNode(ReactBaseTextShadowNode reactBaseTextShadowNode, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list, TextAttributes textAttributes, boolean z2, Map<Integer, ReactShadowNode> map, int i2) {
        TextAttributes textAttributes2;
        float f2;
        float f3;
        ReactBaseTextShadowNode reactBaseTextShadowNode2 = reactBaseTextShadowNode;
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        List<SetSpanOperation> list2 = list;
        TextAttributes textAttributes3 = textAttributes;
        int i3 = i2;
        if (textAttributes3 != null) {
            textAttributes2 = textAttributes3.applyChild(reactBaseTextShadowNode2.mTextAttributes);
        } else {
            textAttributes2 = reactBaseTextShadowNode2.mTextAttributes;
        }
        TextAttributes textAttributes4 = textAttributes2;
        int childCount = reactBaseTextShadowNode.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            ReactShadowNodeImpl childAt = reactBaseTextShadowNode2.getChildAt(i4);
            if (childAt instanceof ReactRawTextShadowNode) {
                spannableStringBuilder2.append(TextTransform.apply(((ReactRawTextShadowNode) childAt).getText(), textAttributes4.getTextTransform()));
            } else if (childAt instanceof ReactBaseTextShadowNode) {
                buildSpannedFromShadowNode((ReactBaseTextShadowNode) childAt, spannableStringBuilder, list, textAttributes4, z2, map, spannableStringBuilder.length());
            } else if (childAt instanceof ReactTextInlineImageShadowNode) {
                spannableStringBuilder2.append(INLINE_VIEW_PLACEHOLDER);
                list2.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), ((ReactTextInlineImageShadowNode) childAt).buildInlineImageSpan()));
            } else if (z2) {
                int reactTag = childAt.getReactTag();
                YogaValue styleWidth = childAt.getStyleWidth();
                YogaValue styleHeight = childAt.getStyleHeight();
                YogaUnit yogaUnit = styleWidth.unit;
                YogaUnit yogaUnit2 = YogaUnit.POINT;
                if (yogaUnit == yogaUnit2 && styleHeight.unit == yogaUnit2) {
                    f3 = styleWidth.value;
                    f2 = styleHeight.value;
                } else {
                    childAt.calculateLayout();
                    f3 = childAt.getLayoutWidth();
                    f2 = childAt.getLayoutHeight();
                }
                spannableStringBuilder2.append(INLINE_VIEW_PLACEHOLDER);
                list2.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new TextInlineViewPlaceholderSpan(reactTag, (int) f3, (int) f2)));
                map.put(Integer.valueOf(reactTag), childAt);
                childAt.markUpdateSeen();
            } else {
                throw new IllegalViewOperationException("Unexpected view type nested under a <Text> or <TextInput> node: " + childAt.getClass());
            }
            Map<Integer, ReactShadowNode> map2 = map;
            childAt.markUpdateSeen();
        }
        int length = spannableStringBuilder.length();
        if (length >= i3) {
            if (reactBaseTextShadowNode2.mIsColorSet) {
                list2.add(new SetSpanOperation(i3, length, new ReactForegroundColorSpan(reactBaseTextShadowNode2.mColor)));
            }
            if (reactBaseTextShadowNode2.mIsBackgroundColorSet) {
                list2.add(new SetSpanOperation(i3, length, new ReactBackgroundColorSpan(reactBaseTextShadowNode2.mBackgroundColor)));
            }
            if (reactBaseTextShadowNode2.mIsAccessibilityLink) {
                list2.add(new SetSpanOperation(i3, length, new ReactClickableSpan(reactBaseTextShadowNode.getReactTag())));
            }
            float effectiveLetterSpacing = textAttributes4.getEffectiveLetterSpacing();
            if (!Float.isNaN(effectiveLetterSpacing) && (textAttributes3 == null || textAttributes.getEffectiveLetterSpacing() != effectiveLetterSpacing)) {
                list2.add(new SetSpanOperation(i3, length, new CustomLetterSpacingSpan(effectiveLetterSpacing)));
            }
            int effectiveFontSize = textAttributes4.getEffectiveFontSize();
            if (textAttributes3 == null || textAttributes.getEffectiveFontSize() != effectiveFontSize) {
                list2.add(new SetSpanOperation(i3, length, new ReactAbsoluteSizeSpan(effectiveFontSize)));
            }
            if (!(reactBaseTextShadowNode2.mFontStyle == -1 && reactBaseTextShadowNode2.mFontWeight == -1 && reactBaseTextShadowNode2.mFontFamily == null)) {
                list2.add(new SetSpanOperation(i3, length, new CustomStyleSpan(reactBaseTextShadowNode2.mFontStyle, reactBaseTextShadowNode2.mFontWeight, reactBaseTextShadowNode2.mFontFeatureSettings, reactBaseTextShadowNode2.mFontFamily, reactBaseTextShadowNode.getThemedContext().getAssets())));
            }
            if (reactBaseTextShadowNode2.mIsUnderlineTextDecorationSet) {
                list2.add(new SetSpanOperation(i3, length, new ReactUnderlineSpan()));
            }
            if (reactBaseTextShadowNode2.mIsLineThroughTextDecorationSet) {
                list2.add(new SetSpanOperation(i3, length, new ReactStrikethroughSpan()));
            }
            if (!((reactBaseTextShadowNode2.mTextShadowOffsetDx == 0.0f && reactBaseTextShadowNode2.mTextShadowOffsetDy == 0.0f && reactBaseTextShadowNode2.mTextShadowRadius == 0.0f) || Color.alpha(reactBaseTextShadowNode2.mTextShadowColor) == 0)) {
                list2.add(new SetSpanOperation(i3, length, new ShadowStyleSpan(reactBaseTextShadowNode2.mTextShadowOffsetDx, reactBaseTextShadowNode2.mTextShadowOffsetDy, reactBaseTextShadowNode2.mTextShadowRadius, reactBaseTextShadowNode2.mTextShadowColor)));
            }
            float effectiveLineHeight = textAttributes4.getEffectiveLineHeight();
            if (!Float.isNaN(effectiveLineHeight) && (textAttributes3 == null || textAttributes.getEffectiveLineHeight() != effectiveLineHeight)) {
                list2.add(new SetSpanOperation(i3, length, new CustomLineHeightSpan(effectiveLineHeight)));
            }
            list2.add(new SetSpanOperation(i3, length, new ReactTagSpan(reactBaseTextShadowNode.getReactTag())));
        }
    }

    private int getTextAlign() {
        int i2 = this.mTextAlign;
        if (getLayoutDirection() != YogaDirection.RTL) {
            return i2;
        }
        if (i2 == 5) {
            return 3;
        }
        if (i2 == 3) {
            return 5;
        }
        return i2;
    }

    @ReactProp(name = "adjustsFontSizeToFit")
    public void setAdjustFontSizeToFit(boolean z2) {
        if (z2 != this.mAdjustsFontSizeToFit) {
            this.mAdjustsFontSizeToFit = z2;
            markUpdated();
        }
    }

    @ReactProp(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(boolean z2) {
        if (z2 != this.mTextAttributes.getAllowFontScaling()) {
            this.mTextAttributes.setAllowFontScaling(z2);
            markUpdated();
        }
    }

    @ReactProp(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(Integer num) {
        boolean z2;
        if (isVirtual()) {
            if (num != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mIsBackgroundColorSet = z2;
            if (z2) {
                this.mBackgroundColor = num.intValue();
            }
            markUpdated();
        }
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(Integer num) {
        boolean z2;
        if (num != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mIsColorSet = z2;
        if (z2) {
            this.mColor = num.intValue();
        }
        markUpdated();
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(String str) {
        this.mFontFamily = str;
        markUpdated();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "fontSize")
    public void setFontSize(float f2) {
        this.mTextAttributes.setFontSize(f2);
        markUpdated();
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(String str) {
        int parseFontStyle = ReactTypefaceUtils.parseFontStyle(str);
        if (parseFontStyle != this.mFontStyle) {
            this.mFontStyle = parseFontStyle;
            markUpdated();
        }
    }

    @ReactProp(name = "fontVariant")
    public void setFontVariant(ReadableArray readableArray) {
        String parseFontVariant = ReactTypefaceUtils.parseFontVariant(readableArray);
        if (!TextUtils.equals(parseFontVariant, this.mFontFeatureSettings)) {
            this.mFontFeatureSettings = parseFontVariant;
            markUpdated();
        }
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(String str) {
        int parseFontWeight = ReactTypefaceUtils.parseFontWeight(str);
        if (parseFontWeight != this.mFontWeight) {
            this.mFontWeight = parseFontWeight;
            markUpdated();
        }
    }

    @ReactProp(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(boolean z2) {
        this.mIncludeFontPadding = z2;
    }

    @ReactProp(name = "accessibilityRole")
    public void setIsAccessibilityLink(String str) {
        if (isVirtual()) {
            this.mIsAccessibilityLink = Objects.equals(str, "link");
            markUpdated();
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "letterSpacing")
    public void setLetterSpacing(float f2) {
        this.mTextAttributes.setLetterSpacing(f2);
        markUpdated();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "lineHeight")
    public void setLineHeight(float f2) {
        this.mTextAttributes.setLineHeight(f2);
        markUpdated();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(float f2) {
        if (f2 != this.mTextAttributes.getMaxFontSizeMultiplier()) {
            this.mTextAttributes.setMaxFontSizeMultiplier(f2);
            markUpdated();
        }
    }

    @ReactProp(name = "minimumFontScale")
    public void setMinimumFontScale(float f2) {
        if (f2 != this.mMinimumFontScale) {
            this.mMinimumFontScale = f2;
            markUpdated();
        }
    }

    @ReactProp(defaultInt = -1, name = "numberOfLines")
    public void setNumberOfLines(int i2) {
        if (i2 == 0) {
            i2 = -1;
        }
        this.mNumberOfLines = i2;
        markUpdated();
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mJustificationMode = 1;
            }
            this.mTextAlign = 3;
        } else {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mJustificationMode = 0;
            }
            if (str == null || "auto".equals(str)) {
                this.mTextAlign = 0;
            } else if (ViewProps.LEFT.equals(str)) {
                this.mTextAlign = 3;
            } else if (ViewProps.RIGHT.equals(str)) {
                this.mTextAlign = 5;
            } else if ("center".equals(str)) {
                this.mTextAlign = 1;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + str);
            }
        }
        markUpdated();
    }

    @ReactProp(name = "textBreakStrategy")
    public void setTextBreakStrategy(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (str == null || "highQuality".equals(str)) {
                this.mTextBreakStrategy = 1;
            } else if ("simple".equals(str)) {
                this.mTextBreakStrategy = 0;
            } else if ("balanced".equals(str)) {
                this.mTextBreakStrategy = 2;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid textBreakStrategy: " + str);
            }
            markUpdated();
        }
    }

    @ReactProp(name = "textDecorationLine")
    public void setTextDecorationLine(String str) {
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        if (str != null) {
            for (String str2 : str.split(" ")) {
                if ("underline".equals(str2)) {
                    this.mIsUnderlineTextDecorationSet = true;
                } else if ("line-through".equals(str2)) {
                    this.mIsLineThroughTextDecorationSet = true;
                }
            }
        }
        markUpdated();
    }

    @ReactProp(customType = "Color", defaultInt = 1426063360, name = "textShadowColor")
    public void setTextShadowColor(int i2) {
        if (i2 != this.mTextShadowColor) {
            this.mTextShadowColor = i2;
            markUpdated();
        }
    }

    @ReactProp(name = "textShadowOffset")
    public void setTextShadowOffset(ReadableMap readableMap) {
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey("width") && !readableMap.isNull("width")) {
                this.mTextShadowOffsetDx = PixelUtil.toPixelFromDIP(readableMap.getDouble("width"));
            }
            if (readableMap.hasKey("height") && !readableMap.isNull("height")) {
                this.mTextShadowOffsetDy = PixelUtil.toPixelFromDIP(readableMap.getDouble("height"));
            }
        }
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "textShadowRadius")
    public void setTextShadowRadius(float f2) {
        if (f2 != this.mTextShadowRadius) {
            this.mTextShadowRadius = f2;
            markUpdated();
        }
    }

    @ReactProp(name = "textTransform")
    public void setTextTransform(String str) {
        if (str == null) {
            this.mTextAttributes.setTextTransform(TextTransform.UNSET);
        } else if ("none".equals(str)) {
            this.mTextAttributes.setTextTransform(TextTransform.NONE);
        } else if ("uppercase".equals(str)) {
            this.mTextAttributes.setTextTransform(TextTransform.UPPERCASE);
        } else if ("lowercase".equals(str)) {
            this.mTextAttributes.setTextTransform(TextTransform.LOWERCASE);
        } else if ("capitalize".equals(str)) {
            this.mTextAttributes.setTextTransform(TextTransform.CAPITALIZE);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textTransform: " + str);
        }
        markUpdated();
    }

    /* access modifiers changed from: protected */
    public Spannable spannedFromShadowNode(ReactBaseTextShadowNode reactBaseTextShadowNode, String str, boolean z2, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        boolean z3;
        HashMap hashMap;
        int i2;
        ReactBaseTextShadowNode reactBaseTextShadowNode2 = reactBaseTextShadowNode;
        String str2 = str;
        NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer2 = nativeViewHierarchyOptimizer;
        int i3 = 0;
        if (!z2 || nativeViewHierarchyOptimizer2 != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.assertCondition(z3, "nativeViewHierarchyOptimizer is required when inline views are supported");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<SetSpanOperation> arrayList = new ArrayList<>();
        if (z2) {
            hashMap = new HashMap();
        } else {
            hashMap = null;
        }
        HashMap hashMap2 = hashMap;
        if (str2 != null) {
            spannableStringBuilder.append(TextTransform.apply(str2, reactBaseTextShadowNode2.mTextAttributes.getTextTransform()));
        }
        buildSpannedFromShadowNode(reactBaseTextShadowNode, spannableStringBuilder, arrayList, (TextAttributes) null, z2, hashMap2, 0);
        reactBaseTextShadowNode2.mContainsImages = false;
        reactBaseTextShadowNode2.mInlineViews = hashMap2;
        float f2 = Float.NaN;
        for (SetSpanOperation setSpanOperation : arrayList) {
            ReactSpan reactSpan = setSpanOperation.what;
            boolean z4 = reactSpan instanceof TextInlineImageSpan;
            if (z4 || (reactSpan instanceof TextInlineViewPlaceholderSpan)) {
                if (z4) {
                    i2 = ((TextInlineImageSpan) reactSpan).getHeight();
                    reactBaseTextShadowNode2.mContainsImages = true;
                } else {
                    TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan = (TextInlineViewPlaceholderSpan) reactSpan;
                    int height = textInlineViewPlaceholderSpan.getHeight();
                    ReactShadowNode reactShadowNode = hashMap2.get(Integer.valueOf(textInlineViewPlaceholderSpan.getReactTag()));
                    nativeViewHierarchyOptimizer2.handleForceViewToBeNonLayoutOnly(reactShadowNode);
                    reactShadowNode.setLayoutParent(reactBaseTextShadowNode);
                    i2 = height;
                }
                if (Float.isNaN(f2) || ((float) i2) > f2) {
                    f2 = (float) i2;
                }
            }
            setSpanOperation.execute(spannableStringBuilder, i3);
            i3++;
        }
        reactBaseTextShadowNode2.mTextAttributes.setHeightOfTallestInlineViewOrImage(f2);
        ReactTextViewManagerCallback reactTextViewManagerCallback = this.mReactTextViewManagerCallback;
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.onPostProcessSpannable(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    public ReactBaseTextShadowNode(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        this.mIsColorSet = false;
        this.mIsBackgroundColorSet = false;
        this.mIsAccessibilityLink = false;
        this.mNumberOfLines = -1;
        this.mTextAlign = 0;
        this.mTextBreakStrategy = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        this.mHyphenationFrequency = 0;
        this.mJustificationMode = 0;
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        this.mTextShadowRadius = 0.0f;
        this.mTextShadowColor = DEFAULT_TEXT_SHADOW_COLOR;
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        this.mIncludeFontPadding = true;
        this.mAdjustsFontSizeToFit = false;
        this.mMinimumFontScale = 0.0f;
        this.mFontStyle = -1;
        this.mFontWeight = -1;
        this.mFontFamily = null;
        this.mFontFeatureSettings = null;
        this.mContainsImages = false;
        this.mTextAttributes = new TextAttributes();
        this.mReactTextViewManagerCallback = reactTextViewManagerCallback;
    }
}
