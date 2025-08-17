package com.facebook.react.views.text;

import android.os.Build;
import android.text.TextUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Iterator;

public class TextAttributeProps {
    private static final int DEFAULT_BREAK_STRATEGY;
    private static final int DEFAULT_HYPHENATION_FREQUENCY = 0;
    private static final int DEFAULT_JUSTIFICATION_MODE = 0;
    private static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
    private static final String PROP_SHADOW_COLOR = "textShadowColor";
    private static final String PROP_SHADOW_OFFSET = "textShadowOffset";
    private static final String PROP_SHADOW_OFFSET_HEIGHT = "height";
    private static final String PROP_SHADOW_OFFSET_WIDTH = "width";
    private static final String PROP_SHADOW_RADIUS = "textShadowRadius";
    private static final String PROP_TEXT_TRANSFORM = "textTransform";
    public static final short TA_KEY_ACCESSIBILITY_ROLE = 22;
    public static final short TA_KEY_ALIGNMENT = 12;
    public static final short TA_KEY_ALLOW_FONT_SCALING = 9;
    public static final short TA_KEY_BACKGROUND_COLOR = 1;
    public static final short TA_KEY_BEST_WRITING_DIRECTION = 13;
    public static final short TA_KEY_FONT_FAMILY = 3;
    public static final short TA_KEY_FONT_SIZE = 4;
    public static final short TA_KEY_FONT_SIZE_MULTIPLIER = 5;
    public static final short TA_KEY_FONT_STYLE = 7;
    public static final short TA_KEY_FONT_VARIANT = 8;
    public static final short TA_KEY_FONT_WEIGHT = 6;
    public static final short TA_KEY_FOREGROUND_COLOR = 0;
    public static final short TA_KEY_IS_HIGHLIGHTED = 20;
    public static final short TA_KEY_LAYOUT_DIRECTION = 21;
    public static final short TA_KEY_LETTER_SPACING = 10;
    public static final short TA_KEY_LINE_HEIGHT = 11;
    public static final short TA_KEY_OPACITY = 2;
    public static final short TA_KEY_TEXT_DECORATION_COLOR = 14;
    public static final short TA_KEY_TEXT_DECORATION_LINE = 15;
    public static final short TA_KEY_TEXT_DECORATION_STYLE = 16;
    public static final short TA_KEY_TEXT_SHADOW_COLOR = 19;
    public static final short TA_KEY_TEXT_SHADOW_RADIUS = 18;
    public static final int UNSET = -1;
    protected ReactAccessibilityDelegate.AccessibilityRole mAccessibilityRole = null;
    protected boolean mAllowFontScaling = true;
    protected int mBackgroundColor;
    protected int mColor;
    protected boolean mContainsImages = false;
    protected String mFontFamily = null;
    protected String mFontFeatureSettings = null;
    protected int mFontSize = -1;
    protected float mFontSizeInput = -1.0f;
    protected int mFontStyle = -1;
    protected int mFontWeight = -1;
    protected float mHeightOfTallestInlineImage = Float.NaN;
    protected boolean mIncludeFontPadding = true;
    protected boolean mIsAccessibilityLink = false;
    protected boolean mIsAccessibilityRoleSet = false;
    protected boolean mIsBackgroundColorSet = false;
    protected boolean mIsColorSet = false;
    protected boolean mIsLineThroughTextDecorationSet = false;
    protected boolean mIsUnderlineTextDecorationSet = false;
    protected int mLayoutDirection = -1;
    protected float mLetterSpacingInput = Float.NaN;
    protected float mLineHeight = Float.NaN;
    protected float mLineHeightInput = -1.0f;
    protected int mNumberOfLines = -1;
    protected int mTextAlign = 0;
    protected int mTextShadowColor = 1426063360;
    protected float mTextShadowOffsetDx = 0.0f;
    protected float mTextShadowOffsetDy = 0.0f;
    protected float mTextShadowRadius = 1.0f;
    protected TextTransform mTextTransform = TextTransform.NONE;

    static {
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 23) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        DEFAULT_BREAK_STRATEGY = i2;
    }

    private TextAttributeProps() {
    }

    public static TextAttributeProps fromMapBuffer(MapBuffer mapBuffer) {
        TextAttributeProps textAttributeProps = new TextAttributeProps();
        Iterator it2 = mapBuffer.iterator();
        while (it2.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it2.next();
            int key = entry.getKey();
            if (key == 0) {
                textAttributeProps.setColor(Integer.valueOf(entry.getIntValue()));
            } else if (key == 1) {
                textAttributeProps.setBackgroundColor(Integer.valueOf(entry.getIntValue()));
            } else if (key == 3) {
                textAttributeProps.setFontFamily(entry.getStringValue());
            } else if (key == 4) {
                textAttributeProps.setFontSize((float) entry.getDoubleValue());
            } else if (key == 15) {
                textAttributeProps.setTextDecorationLine(entry.getStringValue());
            } else if (key == 18) {
                textAttributeProps.setTextShadowRadius((float) entry.getDoubleValue());
            } else if (key == 19) {
                textAttributeProps.setTextShadowColor(entry.getIntValue());
            } else if (key == 21) {
                textAttributeProps.setLayoutDirection(entry.getStringValue());
            } else if (key != 22) {
                switch (key) {
                    case 6:
                        textAttributeProps.setFontWeight(entry.getStringValue());
                        break;
                    case 7:
                        textAttributeProps.setFontStyle(entry.getStringValue());
                        break;
                    case 8:
                        textAttributeProps.setFontVariant(entry.getMapBufferValue());
                        break;
                    case 9:
                        textAttributeProps.setAllowFontScaling(entry.getBooleanValue());
                        break;
                    case 10:
                        textAttributeProps.setLetterSpacing((float) entry.getDoubleValue());
                        break;
                    case 11:
                        textAttributeProps.setLineHeight((float) entry.getDoubleValue());
                        break;
                }
            } else {
                textAttributeProps.setAccessibilityRole(entry.getStringValue());
            }
        }
        return textAttributeProps;
    }

    public static TextAttributeProps fromReadableMap(ReactStylesDiffMap reactStylesDiffMap) {
        Integer num;
        Integer num2;
        Integer num3;
        TextAttributeProps textAttributeProps = new TextAttributeProps();
        textAttributeProps.setNumberOfLines(getIntProp(reactStylesDiffMap, ViewProps.NUMBER_OF_LINES, -1));
        textAttributeProps.setLineHeight(getFloatProp(reactStylesDiffMap, ViewProps.LINE_HEIGHT, -1.0f));
        textAttributeProps.setLetterSpacing(getFloatProp(reactStylesDiffMap, ViewProps.LETTER_SPACING, Float.NaN));
        textAttributeProps.setAllowFontScaling(getBooleanProp(reactStylesDiffMap, ViewProps.ALLOW_FONT_SCALING, true));
        textAttributeProps.setFontSize(getFloatProp(reactStylesDiffMap, ViewProps.FONT_SIZE, -1.0f));
        ReadableMap readableMap = null;
        if (reactStylesDiffMap.hasKey(ViewProps.COLOR)) {
            num = Integer.valueOf(reactStylesDiffMap.getInt(ViewProps.COLOR, 0));
        } else {
            num = null;
        }
        textAttributeProps.setColor(num);
        if (reactStylesDiffMap.hasKey(ViewProps.FOREGROUND_COLOR)) {
            num2 = Integer.valueOf(reactStylesDiffMap.getInt(ViewProps.FOREGROUND_COLOR, 0));
        } else {
            num2 = null;
        }
        textAttributeProps.setColor(num2);
        if (reactStylesDiffMap.hasKey(ViewProps.BACKGROUND_COLOR)) {
            num3 = Integer.valueOf(reactStylesDiffMap.getInt(ViewProps.BACKGROUND_COLOR, 0));
        } else {
            num3 = null;
        }
        textAttributeProps.setBackgroundColor(num3);
        textAttributeProps.setFontFamily(getStringProp(reactStylesDiffMap, ViewProps.FONT_FAMILY));
        textAttributeProps.setFontWeight(getStringProp(reactStylesDiffMap, ViewProps.FONT_WEIGHT));
        textAttributeProps.setFontStyle(getStringProp(reactStylesDiffMap, ViewProps.FONT_STYLE));
        textAttributeProps.setFontVariant(getArrayProp(reactStylesDiffMap, ViewProps.FONT_VARIANT));
        textAttributeProps.setIncludeFontPadding(getBooleanProp(reactStylesDiffMap, ViewProps.INCLUDE_FONT_PADDING, true));
        textAttributeProps.setTextDecorationLine(getStringProp(reactStylesDiffMap, ViewProps.TEXT_DECORATION_LINE));
        if (reactStylesDiffMap.hasKey("textShadowOffset")) {
            readableMap = reactStylesDiffMap.getMap("textShadowOffset");
        }
        textAttributeProps.setTextShadowOffset(readableMap);
        textAttributeProps.setTextShadowRadius(getFloatProp(reactStylesDiffMap, "textShadowRadius", 1.0f));
        textAttributeProps.setTextShadowColor(getIntProp(reactStylesDiffMap, "textShadowColor", 1426063360));
        textAttributeProps.setTextTransform(getStringProp(reactStylesDiffMap, "textTransform"));
        textAttributeProps.setLayoutDirection(getStringProp(reactStylesDiffMap, ViewProps.LAYOUT_DIRECTION));
        textAttributeProps.setAccessibilityRole(getStringProp(reactStylesDiffMap, ViewProps.ACCESSIBILITY_ROLE));
        return textAttributeProps;
    }

    private static ReadableArray getArrayProp(ReactStylesDiffMap reactStylesDiffMap, String str) {
        if (reactStylesDiffMap.hasKey(str)) {
            return reactStylesDiffMap.getArray(str);
        }
        return null;
    }

    private static boolean getBooleanProp(ReactStylesDiffMap reactStylesDiffMap, String str, boolean z2) {
        if (reactStylesDiffMap.hasKey(str)) {
            return reactStylesDiffMap.getBoolean(str, z2);
        }
        return z2;
    }

    private static float getFloatProp(ReactStylesDiffMap reactStylesDiffMap, String str, float f2) {
        if (reactStylesDiffMap.hasKey(str)) {
            return reactStylesDiffMap.getFloat(str, f2);
        }
        return f2;
    }

    public static int getHyphenationFrequency(String str) {
        int i2 = DEFAULT_HYPHENATION_FREQUENCY;
        if (str == null) {
            return i2;
        }
        if (str.equals("normal")) {
            return 1;
        }
        if (!str.equals("none")) {
            return 2;
        }
        return 0;
    }

    private static int getIntProp(ReactStylesDiffMap reactStylesDiffMap, String str, int i2) {
        if (reactStylesDiffMap.hasKey(str)) {
            return reactStylesDiffMap.getInt(str, i2);
        }
        return i2;
    }

    public static int getJustificationMode(ReactStylesDiffMap reactStylesDiffMap) {
        String str;
        if (reactStylesDiffMap.hasKey(ViewProps.TEXT_ALIGN)) {
            str = reactStylesDiffMap.getString(ViewProps.TEXT_ALIGN);
        } else {
            str = null;
        }
        if (!"justify".equals(str) || Build.VERSION.SDK_INT < 26) {
            return DEFAULT_JUSTIFICATION_MODE;
        }
        return 1;
    }

    public static int getLayoutDirection(String str) {
        if (str == null || "undefined".equals(str)) {
            return -1;
        }
        if ("rtl".equals(str)) {
            return 1;
        }
        if ("ltr".equals(str)) {
            return 0;
        }
        throw new JSApplicationIllegalArgumentException("Invalid layoutDirection: " + str);
    }

    private static String getStringProp(ReactStylesDiffMap reactStylesDiffMap, String str) {
        if (reactStylesDiffMap.hasKey(str)) {
            return reactStylesDiffMap.getString(str);
        }
        return null;
    }

    public static int getTextAlignment(ReactStylesDiffMap reactStylesDiffMap, boolean z2) {
        String str;
        if (reactStylesDiffMap.hasKey(ViewProps.TEXT_ALIGN)) {
            str = reactStylesDiffMap.getString(ViewProps.TEXT_ALIGN);
        } else {
            str = null;
        }
        if ("justify".equals(str)) {
            return 3;
        }
        if (str == null || "auto".equals(str)) {
            return 0;
        }
        if (ViewProps.LEFT.equals(str)) {
            if (z2) {
                return 5;
            }
            return 3;
        } else if (ViewProps.RIGHT.equals(str)) {
            if (z2) {
                return 3;
            }
        } else if ("center".equals(str)) {
            return 1;
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + str);
        }
        return 5;
    }

    public static int getTextBreakStrategy(String str) {
        int i2 = DEFAULT_BREAK_STRATEGY;
        if (str == null) {
            return i2;
        }
        if (str.equals("balanced")) {
            return 2;
        }
        if (!str.equals("simple")) {
            return 1;
        }
        return 0;
    }

    private void setAccessibilityRole(String str) {
        if (str != null) {
            this.mIsAccessibilityRoleSet = true;
            ReactAccessibilityDelegate.AccessibilityRole fromValue = ReactAccessibilityDelegate.AccessibilityRole.fromValue(str);
            this.mAccessibilityRole = fromValue;
            this.mIsAccessibilityLink = fromValue.equals(ReactAccessibilityDelegate.AccessibilityRole.LINK);
        }
    }

    private void setAllowFontScaling(boolean z2) {
        if (z2 != this.mAllowFontScaling) {
            this.mAllowFontScaling = z2;
            setFontSize(this.mFontSizeInput);
            setLineHeight(this.mLineHeightInput);
            setLetterSpacing(this.mLetterSpacingInput);
        }
    }

    private void setBackgroundColor(Integer num) {
        boolean z2;
        if (num != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mIsBackgroundColorSet = z2;
        if (z2) {
            this.mBackgroundColor = num.intValue();
        }
    }

    private void setColor(Integer num) {
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
    }

    private void setFontFamily(String str) {
        this.mFontFamily = str;
    }

    private void setFontSize(float f2) {
        double d2;
        this.mFontSizeInput = f2;
        if (f2 != -1.0f) {
            if (this.mAllowFontScaling) {
                d2 = Math.ceil((double) PixelUtil.toPixelFromSP(f2));
            } else {
                d2 = Math.ceil((double) PixelUtil.toPixelFromDIP(f2));
            }
            f2 = (float) d2;
        }
        this.mFontSize = (int) f2;
    }

    private void setFontStyle(String str) {
        this.mFontStyle = ReactTypefaceUtils.parseFontStyle(str);
    }

    private void setFontVariant(ReadableArray readableArray) {
        this.mFontFeatureSettings = ReactTypefaceUtils.parseFontVariant(readableArray);
    }

    private void setFontWeight(String str) {
        this.mFontWeight = ReactTypefaceUtils.parseFontWeight(str);
    }

    private void setIncludeFontPadding(boolean z2) {
        this.mIncludeFontPadding = z2;
    }

    private void setLayoutDirection(String str) {
        this.mLayoutDirection = getLayoutDirection(str);
    }

    private void setLetterSpacing(float f2) {
        this.mLetterSpacingInput = f2;
    }

    private void setLineHeight(float f2) {
        float f3;
        this.mLineHeightInput = f2;
        if (f2 == -1.0f) {
            this.mLineHeight = Float.NaN;
            return;
        }
        if (this.mAllowFontScaling) {
            f3 = PixelUtil.toPixelFromSP(f2);
        } else {
            f3 = PixelUtil.toPixelFromDIP(f2);
        }
        this.mLineHeight = f3;
    }

    private void setNumberOfLines(int i2) {
        if (i2 == 0) {
            i2 = -1;
        }
        this.mNumberOfLines = i2;
    }

    private void setTextDecorationLine(String str) {
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        if (str != null) {
            for (String str2 : str.split("-")) {
                if ("underline".equals(str2)) {
                    this.mIsUnderlineTextDecorationSet = true;
                } else if ("strikethrough".equals(str2)) {
                    this.mIsLineThroughTextDecorationSet = true;
                }
            }
        }
    }

    private void setTextShadowColor(int i2) {
        if (i2 != this.mTextShadowColor) {
            this.mTextShadowColor = i2;
        }
    }

    private void setTextShadowOffset(ReadableMap readableMap) {
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
    }

    private void setTextShadowRadius(float f2) {
        if (f2 != this.mTextShadowRadius) {
            this.mTextShadowRadius = f2;
        }
    }

    private void setTextTransform(String str) {
        if (str == null || "none".equals(str)) {
            this.mTextTransform = TextTransform.NONE;
        } else if ("uppercase".equals(str)) {
            this.mTextTransform = TextTransform.UPPERCASE;
        } else if ("lowercase".equals(str)) {
            this.mTextTransform = TextTransform.LOWERCASE;
        } else if ("capitalize".equals(str)) {
            this.mTextTransform = TextTransform.CAPITALIZE;
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textTransform: " + str);
        }
    }

    public float getEffectiveLineHeight() {
        boolean z2;
        if (Float.isNaN(this.mLineHeight) || Float.isNaN(this.mHeightOfTallestInlineImage) || this.mHeightOfTallestInlineImage <= this.mLineHeight) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return this.mHeightOfTallestInlineImage;
        }
        return this.mLineHeight;
    }

    public float getLetterSpacing() {
        float f2;
        if (this.mAllowFontScaling) {
            f2 = PixelUtil.toPixelFromSP(this.mLetterSpacingInput);
        } else {
            f2 = PixelUtil.toPixelFromDIP(this.mLetterSpacingInput);
        }
        int i2 = this.mFontSize;
        if (i2 > 0) {
            return f2 / ((float) i2);
        }
        throw new IllegalArgumentException("FontSize should be a positive value. Current value: " + this.mFontSize);
    }

    private void setFontVariant(MapBuffer mapBuffer) {
        if (mapBuffer == null || mapBuffer.getCount() == 0) {
            this.mFontFeatureSettings = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = mapBuffer.iterator();
        while (it2.hasNext()) {
            String stringValue = ((MapBuffer.Entry) it2.next()).getStringValue();
            if (stringValue != null) {
                char c2 = 65535;
                switch (stringValue.hashCode()) {
                    case -1195362251:
                        if (stringValue.equals("proportional-nums")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1061392823:
                        if (stringValue.equals("lining-nums")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -771984547:
                        if (stringValue.equals("tabular-nums")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -659678800:
                        if (stringValue.equals("oldstyle-nums")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1183323111:
                        if (stringValue.equals("small-caps")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        arrayList.add("'pnum'");
                        break;
                    case 1:
                        arrayList.add("'lnum'");
                        break;
                    case 2:
                        arrayList.add("'tnum'");
                        break;
                    case 3:
                        arrayList.add("'onum'");
                        break;
                    case 4:
                        arrayList.add("'smcp'");
                        break;
                }
            }
        }
        this.mFontFeatureSettings = TextUtils.join(", ", arrayList);
    }
}
