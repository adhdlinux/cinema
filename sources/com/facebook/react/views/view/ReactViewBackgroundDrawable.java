package com.facebook.react.views.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import java.util.Locale;

public class ReactViewBackgroundDrawable extends Drawable {
    private static final int ALL_BITS_SET = -1;
    private static final int ALL_BITS_UNSET = 0;
    private static final int DEFAULT_BORDER_ALPHA = 255;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final int DEFAULT_BORDER_RGB = 0;
    private int mAlpha = 255;
    private Spacing mBorderAlpha;
    private float[] mBorderCornerRadii;
    private Spacing mBorderRGB;
    private float mBorderRadius = Float.NaN;
    private BorderStyle mBorderStyle;
    private Spacing mBorderWidth;
    private Path mCenterDrawPath;
    private int mColor = 0;
    private final Context mContext;
    private PointF mInnerBottomLeftCorner;
    private PointF mInnerBottomRightCorner;
    private Path mInnerClipPathForBorderRadius;
    private RectF mInnerClipTempRectForBorderRadius;
    private PointF mInnerTopLeftCorner;
    private PointF mInnerTopRightCorner;
    private int mLayoutDirection;
    private boolean mNeedUpdatePathForBorderRadius = false;
    private Path mOuterClipPathForBorderRadius;
    private RectF mOuterClipTempRectForBorderRadius;
    private final Paint mPaint = new Paint(1);
    private Path mPathForBorder;
    private Path mPathForBorderRadiusOutline;
    private Path mPathForSingleBorder = new Path();
    private RectF mTempRectForBorderRadiusOutline;
    private RectF mTempRectForCenterDrawPath;

    /* renamed from: com.facebook.react.views.view.ReactViewBackgroundDrawable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle[] r0 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle = r0
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.SOLID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.DASHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.DOTTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewBackgroundDrawable.AnonymousClass1.<clinit>():void");
        }
    }

    public enum BorderRadiusLocation {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END
    }

    private enum BorderStyle {
        SOLID,
        DASHED,
        DOTTED;

        public static PathEffect getPathEffect(BorderStyle borderStyle, float f2) {
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle[borderStyle.ordinal()];
            if (i2 == 2) {
                float f3 = f2 * 3.0f;
                return new DashPathEffect(new float[]{f3, f3, f3, f3}, 0.0f);
            } else if (i2 != 3) {
                return null;
            } else {
                return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
            }
        }
    }

    public ReactViewBackgroundDrawable(Context context) {
        this.mContext = context;
    }

    private static int colorFromAlphaAndRGBComponents(float f2, float f3) {
        return ((((int) f2) << 24) & DEFAULT_BORDER_COLOR) | (((int) f3) & 16777215);
    }

    private void drawQuadrilateral(Canvas canvas, int i2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (i2 != 0) {
            if (this.mPathForBorder == null) {
                this.mPathForBorder = new Path();
            }
            this.mPaint.setColor(i2);
            this.mPathForBorder.reset();
            this.mPathForBorder.moveTo(f2, f3);
            this.mPathForBorder.lineTo(f4, f5);
            this.mPathForBorder.lineTo(f6, f7);
            this.mPathForBorder.lineTo(f8, f9);
            this.mPathForBorder.lineTo(f2, f3);
            canvas.drawPath(this.mPathForBorder, this.mPaint);
        }
    }

    private void drawRectangularBackgroundWithBorders(Canvas canvas) {
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z3;
        int i6;
        Canvas canvas2 = canvas;
        this.mPaint.setStyle(Paint.Style.FILL);
        int multiplyColorAlpha = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
        if (Color.alpha(multiplyColorAlpha) != 0) {
            this.mPaint.setColor(multiplyColorAlpha);
            canvas2.drawRect(getBounds(), this.mPaint);
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        int round = Math.round(directionAwareBorderInsets.left);
        int round2 = Math.round(directionAwareBorderInsets.top);
        int round3 = Math.round(directionAwareBorderInsets.right);
        int round4 = Math.round(directionAwareBorderInsets.bottom);
        if (round > 0 || round3 > 0 || round2 > 0 || round4 > 0) {
            Rect bounds = getBounds();
            int borderColor = getBorderColor(0);
            int borderColor2 = getBorderColor(1);
            int borderColor3 = getBorderColor(2);
            int borderColor4 = getBorderColor(3);
            if (getResolvedLayoutDirection() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            int borderColor5 = getBorderColor(4);
            int borderColor6 = getBorderColor(5);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (isBorderColorDefined(4)) {
                    borderColor = borderColor5;
                }
                if (isBorderColorDefined(5)) {
                    borderColor3 = borderColor6;
                }
                if (z2) {
                    i6 = borderColor3;
                } else {
                    i6 = borderColor;
                }
                if (!z2) {
                    borderColor = borderColor3;
                }
                i2 = borderColor;
                i3 = i6;
            } else {
                if (z2) {
                    i5 = borderColor6;
                } else {
                    i5 = borderColor5;
                }
                if (!z2) {
                    borderColor5 = borderColor6;
                }
                boolean isBorderColorDefined = isBorderColorDefined(4);
                boolean isBorderColorDefined2 = isBorderColorDefined(5);
                if (z2) {
                    z3 = isBorderColorDefined2;
                } else {
                    z3 = isBorderColorDefined;
                }
                if (!z2) {
                    isBorderColorDefined = isBorderColorDefined2;
                }
                if (z3) {
                    borderColor = i5;
                }
                i3 = borderColor;
                if (isBorderColorDefined) {
                    i2 = borderColor5;
                } else {
                    i2 = borderColor3;
                }
            }
            int i7 = bounds.left;
            int i8 = bounds.top;
            int i9 = round3;
            int i10 = i7;
            int fastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(round, round2, round3, round4, i3, borderColor2, i2, borderColor4);
            if (fastBorderCompatibleColorOrZero == 0) {
                this.mPaint.setAntiAlias(false);
                int width = bounds.width();
                int height = bounds.height();
                if (round > 0) {
                    float f2 = (float) i10;
                    float f3 = (float) (i10 + round);
                    int i11 = i8 + height;
                    Canvas canvas3 = canvas;
                    int i12 = i3;
                    float f4 = f2;
                    i4 = i8;
                    drawQuadrilateral(canvas3, i12, f4, (float) i8, f3, (float) (i8 + round2), f3, (float) (i11 - round4), f2, (float) i11);
                } else {
                    i4 = i8;
                }
                if (round2 > 0) {
                    float f5 = (float) i4;
                    float f6 = (float) (i4 + round2);
                    int i13 = i10 + width;
                    Canvas canvas4 = canvas;
                    int i14 = borderColor2;
                    float f7 = f5;
                    drawQuadrilateral(canvas4, i14, (float) i10, f7, (float) (i10 + round), f6, (float) (i13 - i9), f6, (float) i13, f5);
                }
                if (i9 > 0) {
                    int i15 = i10 + width;
                    float f8 = (float) i15;
                    int i16 = i4 + height;
                    float f9 = (float) (i15 - i9);
                    Canvas canvas5 = canvas;
                    int i17 = i2;
                    float f10 = f8;
                    float f11 = f9;
                    drawQuadrilateral(canvas5, i17, f10, (float) i4, f8, (float) i16, f11, (float) (i16 - round4), f9, (float) (i4 + round2));
                }
                if (round4 > 0) {
                    int i18 = i4 + height;
                    float f12 = (float) i18;
                    int i19 = i10 + width;
                    float f13 = (float) (i18 - round4);
                    drawQuadrilateral(canvas, borderColor4, (float) i10, f12, (float) i19, f12, (float) (i19 - i9), f13, (float) (i10 + round), f13);
                }
                this.mPaint.setAntiAlias(true);
            } else if (Color.alpha(fastBorderCompatibleColorOrZero) != 0) {
                int i20 = bounds.right;
                int i21 = bounds.bottom;
                this.mPaint.setColor(fastBorderCompatibleColorOrZero);
                this.mPaint.setStyle(Paint.Style.STROKE);
                if (round > 0) {
                    this.mPathForSingleBorder.reset();
                    int round5 = Math.round(directionAwareBorderInsets.left);
                    updatePathEffect(round5);
                    this.mPaint.setStrokeWidth((float) round5);
                    float f14 = (float) (i10 + (round5 / 2));
                    this.mPathForSingleBorder.moveTo(f14, (float) i8);
                    this.mPathForSingleBorder.lineTo(f14, (float) i21);
                    canvas2.drawPath(this.mPathForSingleBorder, this.mPaint);
                }
                if (round2 > 0) {
                    this.mPathForSingleBorder.reset();
                    int round6 = Math.round(directionAwareBorderInsets.top);
                    updatePathEffect(round6);
                    this.mPaint.setStrokeWidth((float) round6);
                    float f15 = (float) (i8 + (round6 / 2));
                    this.mPathForSingleBorder.moveTo((float) i10, f15);
                    this.mPathForSingleBorder.lineTo((float) i20, f15);
                    canvas2.drawPath(this.mPathForSingleBorder, this.mPaint);
                }
                if (i9 > 0) {
                    this.mPathForSingleBorder.reset();
                    int round7 = Math.round(directionAwareBorderInsets.right);
                    updatePathEffect(round7);
                    this.mPaint.setStrokeWidth((float) round7);
                    float f16 = (float) (i20 - (round7 / 2));
                    this.mPathForSingleBorder.moveTo(f16, (float) i8);
                    this.mPathForSingleBorder.lineTo(f16, (float) i21);
                    canvas2.drawPath(this.mPathForSingleBorder, this.mPaint);
                }
                if (round4 > 0) {
                    this.mPathForSingleBorder.reset();
                    int round8 = Math.round(directionAwareBorderInsets.bottom);
                    updatePathEffect(round8);
                    this.mPaint.setStrokeWidth((float) round8);
                    float f17 = (float) (i21 - (round8 / 2));
                    this.mPathForSingleBorder.moveTo((float) i10, f17);
                    this.mPathForSingleBorder.lineTo((float) i20, f17);
                    canvas2.drawPath(this.mPathForSingleBorder, this.mPaint);
                }
            }
        }
    }

    private void drawRoundedBackgroundWithBorders(Canvas canvas) {
        int i2;
        int i3;
        float f2;
        float f3;
        float f4;
        float f5;
        int i4;
        boolean z2;
        Canvas canvas2 = canvas;
        updatePath();
        canvas.save();
        int multiplyColorAlpha = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
        if (Color.alpha(multiplyColorAlpha) != 0) {
            this.mPaint.setColor(multiplyColorAlpha);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas2.drawPath(this.mInnerClipPathForBorderRadius, this.mPaint);
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        boolean z3 = false;
        int borderColor = getBorderColor(0);
        int borderColor2 = getBorderColor(1);
        int borderColor3 = getBorderColor(2);
        int borderColor4 = getBorderColor(3);
        if (directionAwareBorderInsets.top > 0.0f || directionAwareBorderInsets.bottom > 0.0f || directionAwareBorderInsets.left > 0.0f || directionAwareBorderInsets.right > 0.0f) {
            float fullBorderWidth = getFullBorderWidth();
            int borderColor5 = getBorderColor(8);
            if (directionAwareBorderInsets.top != fullBorderWidth || directionAwareBorderInsets.bottom != fullBorderWidth || directionAwareBorderInsets.left != fullBorderWidth || directionAwareBorderInsets.right != fullBorderWidth || borderColor != borderColor5 || borderColor2 != borderColor5 || borderColor3 != borderColor5 || borderColor4 != borderColor5) {
                this.mPaint.setStyle(Paint.Style.FILL);
                canvas2.clipPath(this.mOuterClipPathForBorderRadius, Region.Op.INTERSECT);
                canvas2.clipPath(this.mInnerClipPathForBorderRadius, Region.Op.DIFFERENCE);
                if (getResolvedLayoutDirection() == 1) {
                    z3 = true;
                }
                int borderColor6 = getBorderColor(4);
                int borderColor7 = getBorderColor(5);
                if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                    if (isBorderColorDefined(4)) {
                        borderColor = borderColor6;
                    }
                    if (isBorderColorDefined(5)) {
                        borderColor3 = borderColor7;
                    }
                    if (z3) {
                        i3 = borderColor3;
                    } else {
                        i3 = borderColor;
                    }
                    if (!z3) {
                        borderColor = borderColor3;
                    }
                    i2 = borderColor;
                } else {
                    if (z3) {
                        i4 = borderColor7;
                    } else {
                        i4 = borderColor6;
                    }
                    if (!z3) {
                        borderColor6 = borderColor7;
                    }
                    boolean isBorderColorDefined = isBorderColorDefined(4);
                    boolean isBorderColorDefined2 = isBorderColorDefined(5);
                    if (z3) {
                        z2 = isBorderColorDefined2;
                    } else {
                        z2 = isBorderColorDefined;
                    }
                    if (!z3) {
                        isBorderColorDefined = isBorderColorDefined2;
                    }
                    if (z2) {
                        borderColor = i4;
                    }
                    if (isBorderColorDefined) {
                        i3 = borderColor;
                        i2 = borderColor6;
                    } else {
                        i3 = borderColor;
                        i2 = borderColor3;
                    }
                }
                RectF rectF = this.mOuterClipTempRectForBorderRadius;
                float f6 = rectF.left;
                float f7 = rectF.right;
                float f8 = rectF.top;
                float f9 = rectF.bottom;
                if (directionAwareBorderInsets.left > 0.0f) {
                    PointF pointF = this.mInnerTopLeftCorner;
                    float f10 = pointF.x;
                    float f11 = pointF.y;
                    PointF pointF2 = this.mInnerBottomLeftCorner;
                    float f12 = pointF2.x;
                    float f13 = f12;
                    float f14 = f8;
                    f3 = f9;
                    float f15 = f13;
                    f4 = f8;
                    float f16 = pointF2.y;
                    f5 = f7;
                    f2 = f6;
                    drawQuadrilateral(canvas, i3, f6, f14, f10, f11, f15, f16, f6, f3);
                } else {
                    f3 = f9;
                    f4 = f8;
                    f5 = f7;
                    f2 = f6;
                }
                if (directionAwareBorderInsets.top > 0.0f) {
                    PointF pointF3 = this.mInnerTopLeftCorner;
                    float f17 = pointF3.x;
                    float f18 = pointF3.y;
                    PointF pointF4 = this.mInnerTopRightCorner;
                    drawQuadrilateral(canvas, borderColor2, f2, f4, f17, f18, pointF4.x, pointF4.y, f5, f4);
                }
                if (directionAwareBorderInsets.right > 0.0f) {
                    PointF pointF5 = this.mInnerTopRightCorner;
                    float f19 = pointF5.x;
                    float f20 = pointF5.y;
                    PointF pointF6 = this.mInnerBottomRightCorner;
                    drawQuadrilateral(canvas, i2, f5, f4, f19, f20, pointF6.x, pointF6.y, f5, f3);
                }
                if (directionAwareBorderInsets.bottom > 0.0f) {
                    PointF pointF7 = this.mInnerBottomLeftCorner;
                    float f21 = pointF7.x;
                    float f22 = pointF7.y;
                    PointF pointF8 = this.mInnerBottomRightCorner;
                    drawQuadrilateral(canvas, borderColor4, f2, f3, f21, f22, pointF8.x, pointF8.y, f5, f3);
                }
            } else if (fullBorderWidth > 0.0f) {
                this.mPaint.setColor(ColorUtil.multiplyColorAlpha(borderColor5, this.mAlpha));
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(fullBorderWidth);
                canvas2.drawPath(this.mCenterDrawPath, this.mPaint);
            }
        }
        canvas.restore();
    }

    private static int fastBorderCompatibleColorOrZero(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = -1;
        int i11 = (i2 > 0 ? i6 : -1) & (i3 > 0 ? i7 : -1) & (i4 > 0 ? i8 : -1);
        if (i5 > 0) {
            i10 = i9;
        }
        int i12 = i10 & i11;
        if (i2 <= 0) {
            i6 = 0;
        }
        if (i3 <= 0) {
            i7 = 0;
        }
        int i13 = i6 | i7;
        if (i4 <= 0) {
            i8 = 0;
        }
        int i14 = i13 | i8;
        if (i5 <= 0) {
            i9 = 0;
        }
        if (i12 == (i14 | i9)) {
            return i12;
        }
        return 0;
    }

    private int getBorderWidth(int i2) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return 0;
        }
        float f2 = spacing.get(i2);
        if (YogaConstants.isUndefined(f2)) {
            return -1;
        }
        return Math.round(f2);
    }

    private static void getEllipseIntersectionWithLine(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, PointF pointF) {
        PointF pointF2 = pointF;
        double d10 = (d2 + d4) / 2.0d;
        double d11 = (d3 + d5) / 2.0d;
        double d12 = d6 - d10;
        double d13 = d7 - d11;
        double abs = Math.abs(d4 - d2) / 2.0d;
        double abs2 = Math.abs(d5 - d3) / 2.0d;
        double d14 = ((d9 - d11) - d13) / ((d8 - d10) - d12);
        double d15 = d13 - (d12 * d14);
        double d16 = abs2 * abs2;
        double d17 = abs * abs;
        double d18 = d16 + (d17 * d14 * d14);
        double d19 = abs * 2.0d * abs * d15 * d14;
        double d20 = (-(d17 * ((d15 * d15) - d16))) / d18;
        double d21 = d18 * 2.0d;
        double sqrt = ((-d19) / d21) - Math.sqrt(d20 + Math.pow(d19 / d21, 2.0d));
        double d22 = (d14 * sqrt) + d15;
        double d23 = sqrt + d10;
        double d24 = d22 + d11;
        if (!Double.isNaN(d23) && !Double.isNaN(d24)) {
            PointF pointF3 = pointF;
            pointF3.x = (float) d23;
            pointF3.y = (float) d24;
        }
    }

    private boolean isBorderColorDefined(int i2) {
        float f2;
        Spacing spacing = this.mBorderRGB;
        float f3 = Float.NaN;
        if (spacing != null) {
            f2 = spacing.get(i2);
        } else {
            f2 = Float.NaN;
        }
        Spacing spacing2 = this.mBorderAlpha;
        if (spacing2 != null) {
            f3 = spacing2.get(i2);
        }
        if (YogaConstants.isUndefined(f2) || YogaConstants.isUndefined(f3)) {
            return false;
        }
        return true;
    }

    private void setBorderAlpha(int i2, float f2) {
        if (this.mBorderAlpha == null) {
            this.mBorderAlpha = new Spacing(255.0f);
        }
        if (!FloatUtil.floatsEqual(this.mBorderAlpha.getRaw(i2), f2)) {
            this.mBorderAlpha.set(i2, f2);
            invalidateSelf();
        }
    }

    private void setBorderRGB(int i2, float f2) {
        if (this.mBorderRGB == null) {
            this.mBorderRGB = new Spacing(0.0f);
        }
        if (!FloatUtil.floatsEqual(this.mBorderRGB.getRaw(i2), f2)) {
            this.mBorderRGB.set(i2, f2);
            invalidateSelf();
        }
    }

    private void updatePath() {
        boolean z2;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        if (this.mNeedUpdatePathForBorderRadius) {
            this.mNeedUpdatePathForBorderRadius = false;
            if (this.mInnerClipPathForBorderRadius == null) {
                this.mInnerClipPathForBorderRadius = new Path();
            }
            if (this.mOuterClipPathForBorderRadius == null) {
                this.mOuterClipPathForBorderRadius = new Path();
            }
            if (this.mPathForBorderRadiusOutline == null) {
                this.mPathForBorderRadiusOutline = new Path();
            }
            if (this.mCenterDrawPath == null) {
                this.mCenterDrawPath = new Path();
            }
            if (this.mInnerClipTempRectForBorderRadius == null) {
                this.mInnerClipTempRectForBorderRadius = new RectF();
            }
            if (this.mOuterClipTempRectForBorderRadius == null) {
                this.mOuterClipTempRectForBorderRadius = new RectF();
            }
            if (this.mTempRectForBorderRadiusOutline == null) {
                this.mTempRectForBorderRadiusOutline = new RectF();
            }
            if (this.mTempRectForCenterDrawPath == null) {
                this.mTempRectForCenterDrawPath = new RectF();
            }
            this.mInnerClipPathForBorderRadius.reset();
            this.mOuterClipPathForBorderRadius.reset();
            this.mPathForBorderRadiusOutline.reset();
            this.mCenterDrawPath.reset();
            this.mInnerClipTempRectForBorderRadius.set(getBounds());
            this.mOuterClipTempRectForBorderRadius.set(getBounds());
            this.mTempRectForBorderRadiusOutline.set(getBounds());
            this.mTempRectForCenterDrawPath.set(getBounds());
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            RectF rectF = this.mInnerClipTempRectForBorderRadius;
            rectF.top += directionAwareBorderInsets.top;
            rectF.bottom -= directionAwareBorderInsets.bottom;
            rectF.left += directionAwareBorderInsets.left;
            rectF.right -= directionAwareBorderInsets.right;
            RectF rectF2 = this.mTempRectForCenterDrawPath;
            rectF2.top += directionAwareBorderInsets.top * 0.5f;
            rectF2.bottom -= directionAwareBorderInsets.bottom * 0.5f;
            rectF2.left += directionAwareBorderInsets.left * 0.5f;
            rectF2.right -= directionAwareBorderInsets.right * 0.5f;
            float fullBorderRadius = getFullBorderRadius();
            float borderRadiusOrDefaultTo = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_LEFT);
            float borderRadiusOrDefaultTo2 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_RIGHT);
            float borderRadiusOrDefaultTo3 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_LEFT);
            float borderRadiusOrDefaultTo4 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_RIGHT);
            if (getResolvedLayoutDirection() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            float borderRadius = getBorderRadius(BorderRadiusLocation.TOP_START);
            float borderRadius2 = getBorderRadius(BorderRadiusLocation.TOP_END);
            float borderRadius3 = getBorderRadius(BorderRadiusLocation.BOTTOM_START);
            float borderRadius4 = getBorderRadius(BorderRadiusLocation.BOTTOM_END);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (!YogaConstants.isUndefined(borderRadius)) {
                    borderRadiusOrDefaultTo = borderRadius;
                }
                if (!YogaConstants.isUndefined(borderRadius2)) {
                    borderRadiusOrDefaultTo2 = borderRadius2;
                }
                if (!YogaConstants.isUndefined(borderRadius3)) {
                    borderRadiusOrDefaultTo3 = borderRadius3;
                }
                if (!YogaConstants.isUndefined(borderRadius4)) {
                    borderRadiusOrDefaultTo4 = borderRadius4;
                }
                if (z2) {
                    f2 = borderRadiusOrDefaultTo2;
                } else {
                    f2 = borderRadiusOrDefaultTo;
                }
                if (!z2) {
                    borderRadiusOrDefaultTo = borderRadiusOrDefaultTo2;
                }
                if (z2) {
                    f3 = borderRadiusOrDefaultTo4;
                } else {
                    f3 = borderRadiusOrDefaultTo3;
                }
                if (z2) {
                    borderRadiusOrDefaultTo4 = borderRadiusOrDefaultTo3;
                }
            } else {
                if (z2) {
                    f13 = borderRadius2;
                } else {
                    f13 = borderRadius;
                }
                if (!z2) {
                    borderRadius = borderRadius2;
                }
                if (z2) {
                    f14 = borderRadius4;
                } else {
                    f14 = borderRadius3;
                }
                if (!z2) {
                    borderRadius3 = borderRadius4;
                }
                if (!YogaConstants.isUndefined(f13)) {
                    borderRadiusOrDefaultTo = f13;
                }
                if (!YogaConstants.isUndefined(borderRadius)) {
                    borderRadiusOrDefaultTo2 = borderRadius;
                }
                if (!YogaConstants.isUndefined(f14)) {
                    borderRadiusOrDefaultTo3 = f14;
                }
                f2 = borderRadiusOrDefaultTo;
                borderRadiusOrDefaultTo = borderRadiusOrDefaultTo2;
                f3 = borderRadiusOrDefaultTo3;
                if (!YogaConstants.isUndefined(borderRadius3)) {
                    borderRadiusOrDefaultTo4 = borderRadius3;
                }
            }
            float max = Math.max(f2 - directionAwareBorderInsets.left, 0.0f);
            float max2 = Math.max(f2 - directionAwareBorderInsets.top, 0.0f);
            float max3 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.right, 0.0f);
            float max4 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.top, 0.0f);
            float max5 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.right, 0.0f);
            float max6 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.bottom, 0.0f);
            float max7 = Math.max(f3 - directionAwareBorderInsets.left, 0.0f);
            float max8 = Math.max(f3 - directionAwareBorderInsets.bottom, 0.0f);
            RectF rectF3 = directionAwareBorderInsets;
            float f15 = f3;
            this.mInnerClipPathForBorderRadius.addRoundRect(this.mInnerClipTempRectForBorderRadius, new float[]{max, max2, max3, max4, max5, max6, max7, max8}, Path.Direction.CW);
            this.mOuterClipPathForBorderRadius.addRoundRect(this.mOuterClipTempRectForBorderRadius, new float[]{f2, f2, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo4, borderRadiusOrDefaultTo4, f15, f15}, Path.Direction.CW);
            Spacing spacing = this.mBorderWidth;
            if (spacing != null) {
                f4 = spacing.get(8) / 2.0f;
            } else {
                f4 = 0.0f;
            }
            float f16 = max6;
            float f17 = f2 + f4;
            float f18 = borderRadiusOrDefaultTo + f4;
            float f19 = borderRadiusOrDefaultTo4 + f4;
            float f20 = f15 + f4;
            this.mPathForBorderRadiusOutline.addRoundRect(this.mTempRectForBorderRadiusOutline, new float[]{f17, f17, f18, f18, f19, f19, f20, f20}, Path.Direction.CW);
            Path path = this.mCenterDrawPath;
            RectF rectF4 = this.mTempRectForCenterDrawPath;
            float[] fArr = new float[8];
            RectF rectF5 = rectF3;
            float f21 = rectF5.left;
            float f22 = max5;
            float f23 = f2 - (f21 * 0.5f);
            if (f21 > 0.0f) {
                f5 = f2 / f21;
            } else {
                f5 = 0.0f;
            }
            fArr[0] = Math.max(f23, f5);
            float f24 = rectF5.top;
            float f25 = f2 - (f24 * 0.5f);
            if (f24 > 0.0f) {
                f6 = f2 / f24;
            } else {
                f6 = 0.0f;
            }
            fArr[1] = Math.max(f25, f6);
            float f26 = rectF5.right;
            float f27 = borderRadiusOrDefaultTo - (f26 * 0.5f);
            if (f26 > 0.0f) {
                f7 = borderRadiusOrDefaultTo / f26;
            } else {
                f7 = 0.0f;
            }
            fArr[2] = Math.max(f27, f7);
            float f28 = rectF5.top;
            float f29 = borderRadiusOrDefaultTo - (f28 * 0.5f);
            if (f28 > 0.0f) {
                f8 = borderRadiusOrDefaultTo / f28;
            } else {
                f8 = 0.0f;
            }
            fArr[3] = Math.max(f29, f8);
            float f30 = rectF5.right;
            float f31 = borderRadiusOrDefaultTo4 - (f30 * 0.5f);
            if (f30 > 0.0f) {
                f9 = borderRadiusOrDefaultTo4 / f30;
            } else {
                f9 = 0.0f;
            }
            fArr[4] = Math.max(f31, f9);
            float f32 = rectF5.bottom;
            float f33 = borderRadiusOrDefaultTo4 - (f32 * 0.5f);
            if (f32 > 0.0f) {
                f10 = borderRadiusOrDefaultTo4 / f32;
            } else {
                f10 = 0.0f;
            }
            fArr[5] = Math.max(f33, f10);
            float f34 = rectF5.left;
            float f35 = f15 - (f34 * 0.5f);
            if (f34 > 0.0f) {
                f11 = f15 / f34;
            } else {
                f11 = 0.0f;
            }
            fArr[6] = Math.max(f35, f11);
            float f36 = rectF5.bottom;
            float f37 = f15 - (f36 * 0.5f);
            if (f36 > 0.0f) {
                f12 = f15 / f36;
            } else {
                f12 = 0.0f;
            }
            fArr[7] = Math.max(f37, f12);
            path.addRoundRect(rectF4, fArr, Path.Direction.CW);
            if (this.mInnerTopLeftCorner == null) {
                this.mInnerTopLeftCorner = new PointF();
            }
            PointF pointF = this.mInnerTopLeftCorner;
            PointF pointF2 = pointF;
            RectF rectF6 = this.mInnerClipTempRectForBorderRadius;
            float f38 = rectF6.left;
            pointF.x = f38;
            float f39 = rectF6.top;
            pointF.y = f39;
            RectF rectF7 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine((double) f38, (double) f39, (double) ((max * 2.0f) + f38), (double) ((max2 * 2.0f) + f39), (double) rectF7.left, (double) rectF7.top, (double) f38, (double) f39, pointF2);
            if (this.mInnerBottomLeftCorner == null) {
                this.mInnerBottomLeftCorner = new PointF();
            }
            PointF pointF3 = this.mInnerBottomLeftCorner;
            PointF pointF4 = pointF3;
            RectF rectF8 = this.mInnerClipTempRectForBorderRadius;
            float f40 = rectF8.left;
            pointF3.x = f40;
            float f41 = rectF8.bottom;
            pointF3.y = f41;
            RectF rectF9 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine((double) f40, (double) (f41 - (max8 * 2.0f)), (double) ((max7 * 2.0f) + f40), (double) f41, (double) rectF9.left, (double) rectF9.bottom, (double) f40, (double) f41, pointF4);
            if (this.mInnerTopRightCorner == null) {
                this.mInnerTopRightCorner = new PointF();
            }
            PointF pointF5 = this.mInnerTopRightCorner;
            PointF pointF6 = pointF5;
            RectF rectF10 = this.mInnerClipTempRectForBorderRadius;
            float f42 = rectF10.right;
            pointF5.x = f42;
            float f43 = rectF10.top;
            pointF5.y = f43;
            RectF rectF11 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine((double) (f42 - (max3 * 2.0f)), (double) f43, (double) f42, (double) ((max4 * 2.0f) + f43), (double) rectF11.right, (double) rectF11.top, (double) f42, (double) f43, pointF6);
            if (this.mInnerBottomRightCorner == null) {
                this.mInnerBottomRightCorner = new PointF();
            }
            PointF pointF7 = this.mInnerBottomRightCorner;
            PointF pointF8 = pointF7;
            RectF rectF12 = this.mInnerClipTempRectForBorderRadius;
            float f44 = rectF12.right;
            pointF7.x = f44;
            float f45 = rectF12.bottom;
            pointF7.y = f45;
            RectF rectF13 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine((double) (f44 - (f22 * 2.0f)), (double) (f45 - (2.0f * f16)), (double) f44, (double) f45, (double) rectF13.right, (double) rectF13.bottom, (double) f44, (double) f45, pointF8);
        }
    }

    private void updatePathEffect() {
        BorderStyle borderStyle = this.mBorderStyle;
        this.mPaint.setPathEffect(borderStyle != null ? BorderStyle.getPathEffect(borderStyle, getFullBorderWidth()) : null);
    }

    public void draw(Canvas canvas) {
        updatePathEffect();
        if (!hasRoundedBorders()) {
            drawRectangularBackgroundWithBorders(canvas);
        } else {
            drawRoundedBackgroundWithBorders(canvas);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getBorderColor(int i2) {
        float f2;
        float f3;
        Spacing spacing = this.mBorderRGB;
        if (spacing != null) {
            f2 = spacing.get(i2);
        } else {
            f2 = 0.0f;
        }
        Spacing spacing2 = this.mBorderAlpha;
        if (spacing2 != null) {
            f3 = spacing2.get(i2);
        } else {
            f3 = 255.0f;
        }
        return colorFromAlphaAndRGBComponents(f3, f2);
    }

    public float getBorderRadius(BorderRadiusLocation borderRadiusLocation) {
        return getBorderRadiusOrDefaultTo(Float.NaN, borderRadiusLocation);
    }

    public float getBorderRadiusOrDefaultTo(float f2, BorderRadiusLocation borderRadiusLocation) {
        float[] fArr = this.mBorderCornerRadii;
        if (fArr == null) {
            return f2;
        }
        float f3 = fArr[borderRadiusLocation.ordinal()];
        if (YogaConstants.isUndefined(f3)) {
            return f2;
        }
        return f3;
    }

    public float getBorderWidthOrDefaultTo(float f2, int i2) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return f2;
        }
        float raw = spacing.getRaw(i2);
        if (YogaConstants.isUndefined(raw)) {
            return f2;
        }
        return raw;
    }

    @VisibleForTesting
    public int getColor() {
        return this.mColor;
    }

    @TargetApi(21)
    public RectF getDirectionAwareBorderInsets() {
        float f2;
        float f3;
        float borderWidthOrDefaultTo = getBorderWidthOrDefaultTo(0.0f, 8);
        boolean z2 = true;
        float borderWidthOrDefaultTo2 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 1);
        float borderWidthOrDefaultTo3 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 3);
        float borderWidthOrDefaultTo4 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 0);
        float borderWidthOrDefaultTo5 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 2);
        if (this.mBorderWidth != null) {
            if (getResolvedLayoutDirection() != 1) {
                z2 = false;
            }
            float raw = this.mBorderWidth.getRaw(4);
            float raw2 = this.mBorderWidth.getRaw(5);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (!YogaConstants.isUndefined(raw)) {
                    borderWidthOrDefaultTo4 = raw;
                }
                if (!YogaConstants.isUndefined(raw2)) {
                    borderWidthOrDefaultTo5 = raw2;
                }
                if (z2) {
                    f3 = borderWidthOrDefaultTo5;
                } else {
                    f3 = borderWidthOrDefaultTo4;
                }
                if (z2) {
                    borderWidthOrDefaultTo5 = borderWidthOrDefaultTo4;
                }
                borderWidthOrDefaultTo4 = f3;
            } else {
                if (z2) {
                    f2 = raw2;
                } else {
                    f2 = raw;
                }
                if (!z2) {
                    raw = raw2;
                }
                if (!YogaConstants.isUndefined(f2)) {
                    borderWidthOrDefaultTo4 = f2;
                }
                if (!YogaConstants.isUndefined(raw)) {
                    borderWidthOrDefaultTo5 = raw;
                }
            }
        }
        return new RectF(borderWidthOrDefaultTo4, borderWidthOrDefaultTo2, borderWidthOrDefaultTo5, borderWidthOrDefaultTo3);
    }

    public float getFullBorderRadius() {
        if (YogaConstants.isUndefined(this.mBorderRadius)) {
            return 0.0f;
        }
        return this.mBorderRadius;
    }

    public float getFullBorderWidth() {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null || YogaConstants.isUndefined(spacing.getRaw(8))) {
            return 0.0f;
        }
        return this.mBorderWidth.getRaw(8);
    }

    public int getOpacity() {
        return ColorUtil.getOpacityFromColor(ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha));
    }

    public void getOutline(Outline outline) {
        if ((YogaConstants.isUndefined(this.mBorderRadius) || this.mBorderRadius <= 0.0f) && this.mBorderCornerRadii == null) {
            outline.setRect(getBounds());
            return;
        }
        updatePath();
        outline.setConvexPath(this.mPathForBorderRadiusOutline);
    }

    public int getResolvedLayoutDirection() {
        return this.mLayoutDirection;
    }

    public boolean hasRoundedBorders() {
        if (!YogaConstants.isUndefined(this.mBorderRadius) && this.mBorderRadius > 0.0f) {
            return true;
        }
        float[] fArr = this.mBorderCornerRadii;
        if (fArr != null) {
            for (float f2 : fArr) {
                if (!YogaConstants.isUndefined(f2) && f2 > 0.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdatePathForBorderRadius = true;
    }

    public boolean onResolvedLayoutDirectionChanged(int i2) {
        return false;
    }

    public void setAlpha(int i2) {
        if (i2 != this.mAlpha) {
            this.mAlpha = i2;
            invalidateSelf();
        }
    }

    public void setBorderColor(int i2, float f2, float f3) {
        setBorderRGB(i2, f2);
        setBorderAlpha(i2, f3);
    }

    public void setBorderStyle(String str) {
        BorderStyle borderStyle;
        if (str == null) {
            borderStyle = null;
        } else {
            borderStyle = BorderStyle.valueOf(str.toUpperCase(Locale.US));
        }
        if (this.mBorderStyle != borderStyle) {
            this.mBorderStyle = borderStyle;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public void setBorderWidth(int i2, float f2) {
        if (this.mBorderWidth == null) {
            this.mBorderWidth = new Spacing();
        }
        if (!FloatUtil.floatsEqual(this.mBorderWidth.getRaw(i2), f2)) {
            this.mBorderWidth.set(i2, f2);
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) {
                this.mNeedUpdatePathForBorderRadius = true;
            }
            invalidateSelf();
        }
    }

    public void setColor(int i2) {
        this.mColor = i2;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setRadius(float f2) {
        if (!FloatUtil.floatsEqual(this.mBorderRadius, f2)) {
            this.mBorderRadius = f2;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public boolean setResolvedLayoutDirection(int i2) {
        if (this.mLayoutDirection == i2) {
            return false;
        }
        this.mLayoutDirection = i2;
        return onResolvedLayoutDirectionChanged(i2);
    }

    private void updatePathEffect(int i2) {
        BorderStyle borderStyle = this.mBorderStyle;
        this.mPaint.setPathEffect(borderStyle != null ? BorderStyle.getPathEffect(borderStyle, (float) i2) : null);
    }

    public void setRadius(float f2, int i2) {
        if (this.mBorderCornerRadii == null) {
            float[] fArr = new float[8];
            this.mBorderCornerRadii = fArr;
            Arrays.fill(fArr, Float.NaN);
        }
        if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[i2], f2)) {
            this.mBorderCornerRadii[i2] = f2;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }
}
