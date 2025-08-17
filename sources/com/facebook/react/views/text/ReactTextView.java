package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewBackgroundManager;

public class ReactTextView extends AppCompatTextView implements ReactCompoundView {
    private static final ViewGroup.LayoutParams EMPTY_LAYOUT_PARAMS = new ViewGroup.LayoutParams(0, 0);
    private boolean mAdjustsFontSizeToFit = false;
    private boolean mContainsImages;
    private int mDefaultGravityHorizontal = (getGravity() & 8388615);
    private int mDefaultGravityVertical = (getGravity() & 112);
    private TextUtils.TruncateAt mEllipsizeLocation = TextUtils.TruncateAt.END;
    private int mLinkifyMaskType = 0;
    private boolean mNotifyOnInlineViewLayout;
    private int mNumberOfLines = Integer.MAX_VALUE;
    private ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
    private Spannable mSpanned;
    private int mTextAlign = 0;
    private boolean mTextIsSelectable = false;

    public ReactTextView(Context context) {
        super(context);
    }

    private ReactContext getReactContext() {
        Context context = getContext();
        if (context instanceof TintContextWrapper) {
            return (ReactContext) ((TintContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    private static WritableMap inlineViewJson(int i2, int i3, int i4, int i5, int i6, int i7) {
        WritableMap createMap = Arguments.createMap();
        if (i2 == 8) {
            createMap.putString("visibility", "gone");
            createMap.putInt("index", i3);
        } else if (i2 == 0) {
            createMap.putString("visibility", ViewProps.VISIBLE);
            createMap.putInt("index", i3);
            createMap.putDouble(ViewProps.LEFT, (double) PixelUtil.toDIPFromPixel((float) i4));
            createMap.putDouble(ViewProps.TOP, (double) PixelUtil.toDIPFromPixel((float) i5));
            createMap.putDouble(ViewProps.RIGHT, (double) PixelUtil.toDIPFromPixel((float) i6));
            createMap.putDouble(ViewProps.BOTTOM, (double) PixelUtil.toDIPFromPixel((float) i7));
        } else {
            createMap.putString("visibility", "unknown");
            createMap.putInt("index", i3);
        }
        return createMap;
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (ViewCompat.P(this)) {
            AccessibilityDelegateCompat n2 = ViewCompat.n(this);
            if (n2 instanceof ExploreByTouchHelper) {
                if (((ExploreByTouchHelper) n2).dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
                    return true;
                }
                return false;
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public Spannable getSpanned() {
        return this.mSpanned;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setTextIsSelectable(this.mTextIsSelectable);
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onAttachedToWindow : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onAttachedToWindow.onAttachedToWindow();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onDetachedFromWindow : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onDetachedFromWindow.onDetachedFromWindow();
            }
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onFinishTemporaryDetach : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onFinishTemporaryDetach.onFinishTemporaryDetach();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e1, code lost:
        if (r5 != false) goto L_0x00e3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            r22 = this;
            r0 = r22
            int r1 = r22.getId()
            java.lang.CharSequence r2 = r22.getText()
            boolean r2 = r2 instanceof android.text.Spanned
            if (r2 == 0) goto L_0x018d
            int r2 = com.facebook.react.uimanager.common.ViewUtil.getUIManagerType(r1)
            r3 = 2
            if (r2 != r3) goto L_0x0017
            goto L_0x018d
        L_0x0017:
            com.facebook.react.bridge.ReactContext r2 = r22.getReactContext()
            java.lang.Class<com.facebook.react.uimanager.UIManagerModule> r3 = com.facebook.react.uimanager.UIManagerModule.class
            com.facebook.react.bridge.NativeModule r2 = r2.getNativeModule(r3)
            com.facebook.react.uimanager.UIManagerModule r2 = (com.facebook.react.uimanager.UIManagerModule) r2
            java.lang.Object r2 = com.facebook.infer.annotation.Assertions.assertNotNull(r2)
            com.facebook.react.uimanager.UIManagerModule r2 = (com.facebook.react.uimanager.UIManagerModule) r2
            java.lang.CharSequence r3 = r22.getText()
            android.text.Spanned r3 = (android.text.Spanned) r3
            android.text.Layout r4 = r22.getLayout()
            if (r4 != 0) goto L_0x0036
            return
        L_0x0036:
            int r5 = r3.length()
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r6 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            r7 = 0
            java.lang.Object[] r5 = r3.getSpans(r7, r5, r6)
            com.facebook.react.views.text.TextInlineViewPlaceholderSpan[] r5 = (com.facebook.react.views.text.TextInlineViewPlaceholderSpan[]) r5
            boolean r6 = r0.mNotifyOnInlineViewLayout
            if (r6 == 0) goto L_0x004e
            java.util.ArrayList r6 = new java.util.ArrayList
            int r8 = r5.length
            r6.<init>(r8)
            goto L_0x004f
        L_0x004e:
            r6 = 0
        L_0x004f:
            int r8 = r26 - r24
            int r9 = r27 - r25
            int r10 = r5.length
            r11 = 0
        L_0x0055:
            if (r11 >= r10) goto L_0x0155
            r12 = r5[r11]
            int r13 = r12.getReactTag()
            android.view.View r13 = r2.resolveView(r13)
            int r15 = r3.getSpanStart(r12)
            int r14 = r4.getLineForOffset(r15)
            int r16 = r4.getEllipsisCount(r14)
            r17 = 1
            if (r16 <= 0) goto L_0x0074
            r16 = 1
            goto L_0x0076
        L_0x0074:
            r16 = 0
        L_0x0076:
            if (r16 == 0) goto L_0x0084
            int r16 = r4.getLineStart(r14)
            int r18 = r4.getEllipsisStart(r14)
            int r7 = r16 + r18
            if (r15 >= r7) goto L_0x012a
        L_0x0084:
            int r7 = r0.mNumberOfLines
            if (r14 >= r7) goto L_0x012a
            int r7 = r4.getLineEnd(r14)
            if (r15 < r7) goto L_0x0090
            goto L_0x012a
        L_0x0090:
            int r7 = r12.getWidth()
            int r12 = r12.getHeight()
            r20 = r5
            boolean r5 = r4.isRtlCharAt(r15)
            r27 = r10
            int r10 = r4.getParagraphDirection(r14)
            r21 = r1
            r1 = -1
            if (r10 != r1) goto L_0x00ab
            r1 = 1
            goto L_0x00ac
        L_0x00ab:
            r1 = 0
        L_0x00ac:
            int r10 = r3.length()
            int r10 = r10 + -1
            if (r15 != r10) goto L_0x00c4
            if (r1 == 0) goto L_0x00be
            float r1 = r4.getLineWidth(r14)
            int r1 = (int) r1
            int r1 = r8 - r1
            goto L_0x00e4
        L_0x00be:
            float r1 = r4.getLineRight(r14)
            int r1 = (int) r1
            goto L_0x00e3
        L_0x00c4:
            if (r1 != r5) goto L_0x00c8
            r10 = 1
            goto L_0x00c9
        L_0x00c8:
            r10 = 0
        L_0x00c9:
            if (r10 == 0) goto L_0x00d0
            float r10 = r4.getPrimaryHorizontal(r15)
            goto L_0x00d4
        L_0x00d0:
            float r10 = r4.getSecondaryHorizontal(r15)
        L_0x00d4:
            int r10 = (int) r10
            if (r1 == 0) goto L_0x00e0
            float r1 = r4.getLineRight(r14)
            int r1 = (int) r1
            int r1 = r1 - r10
            int r1 = r8 - r1
            goto L_0x00e1
        L_0x00e0:
            r1 = r10
        L_0x00e1:
            if (r5 == 0) goto L_0x00e4
        L_0x00e3:
            int r1 = r1 - r7
        L_0x00e4:
            if (r5 == 0) goto L_0x00eb
            int r5 = r22.getTotalPaddingRight()
            goto L_0x00ef
        L_0x00eb:
            int r5 = r22.getTotalPaddingLeft()
        L_0x00ef:
            int r1 = r1 + r5
            int r5 = r24 + r1
            int r10 = r22.getTotalPaddingTop()
            int r14 = r4.getLineBaseline(r14)
            int r10 = r10 + r14
            int r10 = r10 - r12
            int r14 = r25 + r10
            if (r8 <= r1) goto L_0x0105
            if (r9 > r10) goto L_0x0103
            goto L_0x0105
        L_0x0103:
            r17 = 0
        L_0x0105:
            if (r17 == 0) goto L_0x010a
            r1 = 8
            goto L_0x010b
        L_0x010a:
            r1 = 0
        L_0x010b:
            int r7 = r7 + r5
            int r10 = r14 + r12
            r13.setVisibility(r1)
            r13.layout(r5, r14, r7, r10)
            boolean r12 = r0.mNotifyOnInlineViewLayout
            if (r12 == 0) goto L_0x014a
            r12 = r14
            r14 = r1
            r16 = r5
            r17 = r12
            r18 = r7
            r19 = r10
            com.facebook.react.bridge.WritableMap r1 = inlineViewJson(r14, r15, r16, r17, r18, r19)
            r6.add(r1)
            goto L_0x014a
        L_0x012a:
            r21 = r1
            r20 = r5
            r27 = r10
            r1 = 8
            r13.setVisibility(r1)
            boolean r1 = r0.mNotifyOnInlineViewLayout
            if (r1 == 0) goto L_0x014a
            r14 = 8
            r16 = -1
            r17 = -1
            r18 = -1
            r19 = -1
            com.facebook.react.bridge.WritableMap r1 = inlineViewJson(r14, r15, r16, r17, r18, r19)
            r6.add(r1)
        L_0x014a:
            int r11 = r11 + 1
            r10 = r27
            r5 = r20
            r1 = r21
            r7 = 0
            goto L_0x0055
        L_0x0155:
            r21 = r1
            boolean r1 = r0.mNotifyOnInlineViewLayout
            if (r1 == 0) goto L_0x018d
            com.facebook.react.views.text.ReactTextView$1 r1 = new com.facebook.react.views.text.ReactTextView$1
            r1.<init>()
            java.util.Collections.sort(r6, r1)
            com.facebook.react.bridge.WritableArray r1 = com.facebook.react.bridge.Arguments.createArray()
            java.util.Iterator r3 = r6.iterator()
        L_0x016b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x017b
            java.lang.Object r4 = r3.next()
            com.facebook.react.bridge.WritableMap r4 = (com.facebook.react.bridge.WritableMap) r4
            r1.pushMap(r4)
            goto L_0x016b
        L_0x017b:
            com.facebook.react.bridge.WritableMap r3 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String r4 = "inlineViews"
            r3.putArray(r4, r1)
            if (r2 == 0) goto L_0x018d
            java.lang.String r1 = "topInlineViewLayout"
            r4 = r21
            r2.receiveEvent(r4, r1, r3)
        L_0x018d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextView.onLayout(boolean, int, int, int, int):void");
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onStartTemporaryDetach : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onStartTemporaryDetach.onStartTemporaryDetach();
            }
        }
    }

    public int reactTagForTouch(float f2, float f3) {
        int i2;
        CharSequence text = getText();
        int id = getId();
        int i3 = (int) f2;
        int i4 = (int) f3;
        Layout layout = getLayout();
        if (layout == null) {
            return id;
        }
        int lineForVertical = layout.getLineForVertical(i4);
        int lineLeft = (int) layout.getLineLeft(lineForVertical);
        int lineRight = (int) layout.getLineRight(lineForVertical);
        if ((text instanceof Spanned) && i3 >= lineLeft && i3 <= lineRight) {
            Spanned spanned = (Spanned) text;
            try {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, (float) i3);
                ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactTagSpan.class);
                if (reactTagSpanArr != null) {
                    int length = text.length();
                    for (int i5 = 0; i5 < reactTagSpanArr.length; i5++) {
                        int spanStart = spanned.getSpanStart(reactTagSpanArr[i5]);
                        int spanEnd = spanned.getSpanEnd(reactTagSpanArr[i5]);
                        if (spanEnd >= offsetForHorizontal && (i2 = spanEnd - spanStart) <= length) {
                            id = reactTagSpanArr[i5].getReactTag();
                            length = i2;
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                FLog.e(ReactConstants.TAG, "Crash in HorizontalMeasurementProvider: " + e2.getMessage());
            }
        }
        return id;
    }

    public void setAdjustFontSizeToFit(boolean z2) {
        this.mAdjustsFontSizeToFit = z2;
    }

    public void setBackgroundColor(int i2) {
        this.mReactBackgroundManager.setBackgroundColor(i2);
    }

    public void setBorderColor(int i2, float f2, float f3) {
        this.mReactBackgroundManager.setBorderColor(i2, f2, f3);
    }

    public void setBorderRadius(float f2) {
        this.mReactBackgroundManager.setBorderRadius(f2);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }

    public void setBorderWidth(int i2, float f2) {
        this.mReactBackgroundManager.setBorderWidth(i2, f2);
    }

    public void setEllipsizeLocation(TextUtils.TruncateAt truncateAt) {
        this.mEllipsizeLocation = truncateAt;
    }

    /* access modifiers changed from: package-private */
    public void setGravityHorizontal(int i2) {
        if (i2 == 0) {
            i2 = this.mDefaultGravityHorizontal;
        }
        setGravity(i2 | (getGravity() & -8 & -8388616));
    }

    /* access modifiers changed from: package-private */
    public void setGravityVertical(int i2) {
        if (i2 == 0) {
            i2 = this.mDefaultGravityVertical;
        }
        setGravity(i2 | (getGravity() & -113));
    }

    public void setLinkifyMask(int i2) {
        this.mLinkifyMaskType = i2;
    }

    public void setNotifyOnInlineViewLayout(boolean z2) {
        this.mNotifyOnInlineViewLayout = z2;
    }

    public void setNumberOfLines(int i2) {
        if (i2 == 0) {
            i2 = Integer.MAX_VALUE;
        }
        this.mNumberOfLines = i2;
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        setSingleLine(z2);
        setMaxLines(this.mNumberOfLines);
    }

    public void setSpanned(Spannable spannable) {
        this.mSpanned = spannable;
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        int i2;
        this.mContainsImages = reactTextUpdate.containsImages();
        if (getLayoutParams() == null) {
            setLayoutParams(EMPTY_LAYOUT_PARAMS);
        }
        Spannable text = reactTextUpdate.getText();
        int i3 = this.mLinkifyMaskType;
        if (i3 > 0) {
            Linkify.addLinks(text, i3);
            setMovementMethod(LinkMovementMethod.getInstance());
        }
        setText(text);
        float paddingLeft = reactTextUpdate.getPaddingLeft();
        float paddingTop = reactTextUpdate.getPaddingTop();
        float paddingRight = reactTextUpdate.getPaddingRight();
        float paddingBottom = reactTextUpdate.getPaddingBottom();
        if (!(paddingLeft == -1.0f || paddingBottom == -1.0f || paddingRight == -1.0f || i2 == 0)) {
            setPadding((int) Math.floor((double) paddingLeft), (int) Math.floor((double) paddingTop), (int) Math.floor((double) paddingRight), (int) Math.floor((double) paddingBottom));
        }
        int textAlign = reactTextUpdate.getTextAlign();
        if (this.mTextAlign != textAlign) {
            this.mTextAlign = textAlign;
        }
        setGravityHorizontal(this.mTextAlign);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23 && getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
            setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
        }
        if (i4 >= 26 && getJustificationMode() != reactTextUpdate.getJustificationMode()) {
            setJustificationMode(reactTextUpdate.getJustificationMode());
        }
        requestLayout();
    }

    public void setTextIsSelectable(boolean z2) {
        this.mTextIsSelectable = z2;
        super.setTextIsSelectable(z2);
    }

    public void updateView() {
        TextUtils.TruncateAt truncateAt;
        if (this.mNumberOfLines == Integer.MAX_VALUE || this.mAdjustsFontSizeToFit) {
            truncateAt = null;
        } else {
            truncateAt = this.mEllipsizeLocation;
        }
        setEllipsize(truncateAt);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void setBorderRadius(float f2, int i2) {
        this.mReactBackgroundManager.setBorderRadius(f2, i2);
    }
}
