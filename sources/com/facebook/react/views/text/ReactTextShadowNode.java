package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaBaselineFunction;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;
import java.util.ArrayList;
import java.util.Map;

@TargetApi(23)
public class ReactTextShadowNode extends ReactBaseTextShadowNode {
    /* access modifiers changed from: private */
    public static final TextPaint sTextPaintInstance = new TextPaint(1);
    /* access modifiers changed from: private */
    public Spannable mPreparedSpannableText;
    /* access modifiers changed from: private */
    public boolean mShouldNotifyOnTextLayout;
    private final YogaBaselineFunction mTextBaselineFunction;
    private final YogaMeasureFunction mTextMeasureFunction;

    public ReactTextShadowNode() {
        this((ReactTextViewManagerCallback) null);
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

    private void initMeasureFunction() {
        if (!isVirtual()) {
            setMeasureFunction(this.mTextMeasureFunction);
            setBaselineFunction(this.mTextBaselineFunction);
        }
    }

    /* access modifiers changed from: private */
    public Layout measureSpannedText(Spannable spannable, float f2, YogaMeasureMode yogaMeasureMode) {
        float f3;
        boolean z2;
        TextPaint textPaint = sTextPaintInstance;
        textPaint.setTextSize((float) this.mTextAttributes.getEffectiveFontSize());
        BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannable, textPaint);
        if (isBoring == null) {
            f3 = Layout.getDesiredWidth(spannable, textPaint);
        } else {
            f3 = Float.NaN;
        }
        if (yogaMeasureMode == YogaMeasureMode.UNDEFINED || f2 < 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        int textAlign = getTextAlign();
        if (textAlign == 1) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (textAlign == 3) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else if (textAlign == 5) {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        Layout.Alignment alignment2 = alignment;
        if (isBoring == null && (z2 || (!YogaConstants.isUndefined(f3) && f3 <= f2))) {
            int ceil = (int) Math.ceil((double) f3);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 23) {
                return new StaticLayout(spannable, textPaint, ceil, alignment2, 1.0f, 0.0f, this.mIncludeFontPadding);
            }
            StaticLayout.Builder a2 = StaticLayout.Builder.obtain(spannable, 0, spannable.length(), textPaint, ceil).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(this.mIncludeFontPadding).setBreakStrategy(this.mTextBreakStrategy).setHyphenationFrequency(this.mHyphenationFrequency);
            if (i2 >= 26) {
                StaticLayout.Builder unused = a2.setJustificationMode(this.mJustificationMode);
            }
            if (i2 >= 28) {
                StaticLayout.Builder unused2 = a2.setUseLineSpacingFromFallbacks(true);
            }
            return a2.build();
        } else if (isBoring == null || (!z2 && ((float) isBoring.width) > f2)) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 23) {
                return new StaticLayout(spannable, textPaint, (int) f2, alignment2, 1.0f, 0.0f, this.mIncludeFontPadding);
            }
            StaticLayout.Builder a3 = StaticLayout.Builder.obtain(spannable, 0, spannable.length(), textPaint, (int) f2).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(this.mIncludeFontPadding).setBreakStrategy(this.mTextBreakStrategy).setHyphenationFrequency(this.mHyphenationFrequency);
            if (i3 >= 28) {
                StaticLayout.Builder unused3 = a3.setUseLineSpacingFromFallbacks(true);
            }
            return a3.build();
        } else {
            return BoringLayout.make(spannable, textPaint, Math.max(isBoring.width, 0), alignment2, 1.0f, 0.0f, isBoring, this.mIncludeFontPadding);
        }
    }

    public Iterable<? extends ReactShadowNode> calculateLayoutOnChildren() {
        Map<Integer, ReactShadowNode> map = this.mInlineViews;
        if (map == null || map.isEmpty()) {
            return null;
        }
        Spanned spanned = (Spanned) Assertions.assertNotNull(this.mPreparedSpannableText, "Spannable element has not been prepared in onBeforeLayout");
        TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr = (TextInlineViewPlaceholderSpan[]) spanned.getSpans(0, spanned.length(), TextInlineViewPlaceholderSpan.class);
        ArrayList arrayList = new ArrayList(textInlineViewPlaceholderSpanArr.length);
        for (TextInlineViewPlaceholderSpan reactTag : textInlineViewPlaceholderSpanArr) {
            ReactShadowNode reactShadowNode = this.mInlineViews.get(Integer.valueOf(reactTag.getReactTag()));
            reactShadowNode.calculateLayout();
            arrayList.add(reactShadowNode);
        }
        return arrayList;
    }

    public boolean hoistNativeChildren() {
        return true;
    }

    public boolean isVirtualAnchor() {
        return false;
    }

    public void markUpdated() {
        super.markUpdated();
        super.dirty();
    }

    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        this.mPreparedSpannableText = spannedFromShadowNode(this, (String) null, true, nativeViewHierarchyOptimizer);
        markUpdated();
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        super.onCollectExtraUpdates(uIViewOperationQueue);
        Spannable spannable = this.mPreparedSpannableText;
        if (spannable != null) {
            uIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), new ReactTextUpdate(spannable, -1, this.mContainsImages, getPadding(4), getPadding(1), getPadding(5), getPadding(3), getTextAlign(), this.mTextBreakStrategy, this.mJustificationMode));
        }
    }

    @ReactProp(name = "onTextLayout")
    public void setShouldNotifyOnTextLayout(boolean z2) {
        this.mShouldNotifyOnTextLayout = z2;
    }

    public ReactTextShadowNode(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        super(reactTextViewManagerCallback);
        this.mTextMeasureFunction = new YogaMeasureFunction() {
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x014a, code lost:
                if (r2 > r21) goto L_0x014c;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public long measure(com.facebook.yoga.YogaNode r18, float r19, com.facebook.yoga.YogaMeasureMode r20, float r21, com.facebook.yoga.YogaMeasureMode r22) {
                /*
                    r17 = this;
                    r0 = r17
                    r1 = r19
                    r2 = r20
                    r3 = r22
                    com.facebook.react.views.text.ReactTextShadowNode r4 = com.facebook.react.views.text.ReactTextShadowNode.this
                    android.text.Spannable r4 = r4.mPreparedSpannableText
                    java.lang.String r5 = "Spannable element has not been prepared in onBeforeLayout"
                    java.lang.Object r4 = com.facebook.infer.annotation.Assertions.assertNotNull(r4, r5)
                    android.text.Spannable r4 = (android.text.Spannable) r4
                    com.facebook.react.views.text.ReactTextShadowNode r5 = com.facebook.react.views.text.ReactTextShadowNode.this
                    android.text.Layout r5 = r5.measureSpannedText(r4, r1, r2)
                    com.facebook.react.views.text.ReactTextShadowNode r6 = com.facebook.react.views.text.ReactTextShadowNode.this
                    boolean r7 = r6.mAdjustsFontSizeToFit
                    r8 = -1
                    r9 = 0
                    if (r7 == 0) goto L_0x00b5
                    com.facebook.react.views.text.TextAttributes r6 = r6.mTextAttributes
                    int r6 = r6.getEffectiveFontSize()
                    com.facebook.react.views.text.ReactTextShadowNode r7 = com.facebook.react.views.text.ReactTextShadowNode.this
                    com.facebook.react.views.text.TextAttributes r7 = r7.mTextAttributes
                    int r7 = r7.getEffectiveFontSize()
                    com.facebook.react.views.text.ReactTextShadowNode r10 = com.facebook.react.views.text.ReactTextShadowNode.this
                    float r10 = r10.mMinimumFontScale
                    float r6 = (float) r6
                    float r10 = r10 * r6
                    r11 = 1082130432(0x40800000, float:4.0)
                    float r11 = com.facebook.react.uimanager.PixelUtil.toPixelFromDIP((float) r11)
                    float r10 = java.lang.Math.max(r10, r11)
                    int r10 = (int) r10
                L_0x0044:
                    if (r7 <= r10) goto L_0x00b5
                    com.facebook.react.views.text.ReactTextShadowNode r11 = com.facebook.react.views.text.ReactTextShadowNode.this
                    int r11 = r11.mNumberOfLines
                    if (r11 == r8) goto L_0x0056
                    int r11 = r5.getLineCount()
                    com.facebook.react.views.text.ReactTextShadowNode r12 = com.facebook.react.views.text.ReactTextShadowNode.this
                    int r12 = r12.mNumberOfLines
                    if (r11 > r12) goto L_0x0063
                L_0x0056:
                    com.facebook.yoga.YogaMeasureMode r11 = com.facebook.yoga.YogaMeasureMode.UNDEFINED
                    if (r3 == r11) goto L_0x00b5
                    int r11 = r5.getHeight()
                    float r11 = (float) r11
                    int r11 = (r11 > r21 ? 1 : (r11 == r21 ? 0 : -1))
                    if (r11 <= 0) goto L_0x00b5
                L_0x0063:
                    r5 = 1065353216(0x3f800000, float:1.0)
                    float r5 = com.facebook.react.uimanager.PixelUtil.toPixelFromDIP((float) r5)
                    int r5 = (int) r5
                    int r7 = r7 - r5
                    float r5 = (float) r7
                    float r5 = r5 / r6
                    int r11 = r4.length()
                    java.lang.Class<com.facebook.react.views.text.ReactAbsoluteSizeSpan> r12 = com.facebook.react.views.text.ReactAbsoluteSizeSpan.class
                    java.lang.Object[] r11 = r4.getSpans(r9, r11, r12)
                    com.facebook.react.views.text.ReactAbsoluteSizeSpan[] r11 = (com.facebook.react.views.text.ReactAbsoluteSizeSpan[]) r11
                    int r12 = r11.length
                    r13 = 0
                L_0x007b:
                    if (r13 >= r12) goto L_0x00ac
                    r14 = r11[r13]
                    com.facebook.react.views.text.ReactAbsoluteSizeSpan r15 = new com.facebook.react.views.text.ReactAbsoluteSizeSpan
                    int r9 = r14.getSize()
                    float r9 = (float) r9
                    float r9 = r9 * r5
                    float r8 = (float) r10
                    float r8 = java.lang.Math.max(r9, r8)
                    int r8 = (int) r8
                    r15.<init>(r8)
                    int r8 = r4.getSpanStart(r14)
                    int r9 = r4.getSpanEnd(r14)
                    r16 = r5
                    int r5 = r4.getSpanFlags(r14)
                    r4.setSpan(r15, r8, r9, r5)
                    r4.removeSpan(r14)
                    int r13 = r13 + 1
                    r5 = r16
                    r8 = -1
                    r9 = 0
                    goto L_0x007b
                L_0x00ac:
                    com.facebook.react.views.text.ReactTextShadowNode r5 = com.facebook.react.views.text.ReactTextShadowNode.this
                    android.text.Layout r5 = r5.measureSpannedText(r4, r1, r2)
                    r8 = -1
                    r9 = 0
                    goto L_0x0044
                L_0x00b5:
                    com.facebook.react.views.text.ReactTextShadowNode r6 = com.facebook.react.views.text.ReactTextShadowNode.this
                    boolean r6 = r6.mShouldNotifyOnTextLayout
                    if (r6 == 0) goto L_0x00fa
                    com.facebook.react.views.text.ReactTextShadowNode r6 = com.facebook.react.views.text.ReactTextShadowNode.this
                    com.facebook.react.uimanager.ThemedReactContext r6 = r6.getThemedContext()
                    android.text.TextPaint r7 = com.facebook.react.views.text.ReactTextShadowNode.sTextPaintInstance
                    com.facebook.react.bridge.WritableArray r4 = com.facebook.react.views.text.FontMetricsUtil.getFontMetrics(r4, r5, r7, r6)
                    com.facebook.react.bridge.WritableMap r7 = com.facebook.react.bridge.Arguments.createMap()
                    java.lang.String r8 = "lines"
                    r7.putArray(r8, r4)
                    boolean r4 = r6.hasActiveReactInstance()
                    if (r4 == 0) goto L_0x00ee
                    java.lang.Class<com.facebook.react.uimanager.events.RCTEventEmitter> r4 = com.facebook.react.uimanager.events.RCTEventEmitter.class
                    com.facebook.react.bridge.JavaScriptModule r4 = r6.getJSModule(r4)
                    com.facebook.react.uimanager.events.RCTEventEmitter r4 = (com.facebook.react.uimanager.events.RCTEventEmitter) r4
                    com.facebook.react.views.text.ReactTextShadowNode r6 = com.facebook.react.views.text.ReactTextShadowNode.this
                    int r6 = r6.getReactTag()
                    java.lang.String r8 = "topTextLayout"
                    r4.receiveEvent(r6, r8, r7)
                    goto L_0x00fa
                L_0x00ee:
                    com.facebook.react.bridge.ReactNoCrashSoftException r4 = new com.facebook.react.bridge.ReactNoCrashSoftException
                    java.lang.String r6 = "Cannot get RCTEventEmitter, no CatalystInstance"
                    r4.<init>((java.lang.String) r6)
                    java.lang.String r6 = "ReactTextShadowNode"
                    com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r6, r4)
                L_0x00fa:
                    com.facebook.react.views.text.ReactTextShadowNode r4 = com.facebook.react.views.text.ReactTextShadowNode.this
                    int r4 = r4.mNumberOfLines
                    r6 = -1
                    if (r4 != r6) goto L_0x0106
                    int r4 = r5.getLineCount()
                    goto L_0x010e
                L_0x0106:
                    int r6 = r5.getLineCount()
                    int r4 = java.lang.Math.min(r4, r6)
                L_0x010e:
                    com.facebook.yoga.YogaMeasureMode r6 = com.facebook.yoga.YogaMeasureMode.EXACTLY
                    if (r2 != r6) goto L_0x0113
                    goto L_0x012d
                L_0x0113:
                    r6 = 0
                    r9 = 0
                L_0x0115:
                    if (r9 >= r4) goto L_0x0123
                    float r7 = r5.getLineWidth(r9)
                    int r8 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                    if (r8 <= 0) goto L_0x0120
                    r6 = r7
                L_0x0120:
                    int r9 = r9 + 1
                    goto L_0x0115
                L_0x0123:
                    com.facebook.yoga.YogaMeasureMode r7 = com.facebook.yoga.YogaMeasureMode.AT_MOST
                    if (r2 != r7) goto L_0x012c
                    int r2 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
                    if (r2 <= 0) goto L_0x012c
                    goto L_0x012d
                L_0x012c:
                    r1 = r6
                L_0x012d:
                    int r2 = android.os.Build.VERSION.SDK_INT
                    r6 = 29
                    if (r2 <= r6) goto L_0x0139
                    double r1 = (double) r1
                    double r1 = java.lang.Math.ceil(r1)
                    float r1 = (float) r1
                L_0x0139:
                    com.facebook.yoga.YogaMeasureMode r2 = com.facebook.yoga.YogaMeasureMode.EXACTLY
                    if (r3 == r2) goto L_0x014c
                    int r4 = r4 + -1
                    int r2 = r5.getLineBottom(r4)
                    float r2 = (float) r2
                    com.facebook.yoga.YogaMeasureMode r4 = com.facebook.yoga.YogaMeasureMode.AT_MOST
                    if (r3 != r4) goto L_0x014e
                    int r3 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
                    if (r3 <= 0) goto L_0x014e
                L_0x014c:
                    r2 = r21
                L_0x014e:
                    long r1 = com.facebook.yoga.YogaMeasureOutput.make((float) r1, (float) r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextShadowNode.AnonymousClass1.measure(com.facebook.yoga.YogaNode, float, com.facebook.yoga.YogaMeasureMode, float, com.facebook.yoga.YogaMeasureMode):long");
            }
        };
        this.mTextBaselineFunction = new YogaBaselineFunction() {
            public float baseline(YogaNode yogaNode, float f2, float f3) {
                Layout access$100 = ReactTextShadowNode.this.measureSpannedText((Spannable) Assertions.assertNotNull(ReactTextShadowNode.this.mPreparedSpannableText, "Spannable element has not been prepared in onBeforeLayout"), f2, YogaMeasureMode.EXACTLY);
                return (float) access$100.getLineBaseline(access$100.getLineCount() - 1);
            }
        };
        initMeasureFunction();
    }
}
