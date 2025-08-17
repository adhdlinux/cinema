package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageutils.JfifUtil;
import java.util.Arrays;

public class RoundedColorDrawable extends Drawable implements Rounded {
    private int mAlpha;
    private int mBorderColor;
    final Path mBorderPath;
    final float[] mBorderRadii;
    private float mBorderWidth;
    private int mColor;
    float[] mInsideBorderRadii;
    private boolean mIsCircle;
    private float mPadding;
    final Paint mPaint;
    private boolean mPaintFilterBitmap;
    final Path mPath;
    private final float[] mRadii;
    private boolean mScaleDownInsideBorders;
    private final RectF mTempRect;

    public RoundedColorDrawable(int i2) {
        this.mRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mPaint = new Paint(1);
        this.mIsCircle = false;
        this.mBorderWidth = 0.0f;
        this.mPadding = 0.0f;
        this.mBorderColor = 0;
        this.mScaleDownInsideBorders = false;
        this.mPaintFilterBitmap = false;
        this.mPath = new Path();
        this.mBorderPath = new Path();
        this.mColor = 0;
        this.mTempRect = new RectF();
        this.mAlpha = JfifUtil.MARKER_FIRST_BYTE;
        setColor(i2);
    }

    @TargetApi(11)
    public static RoundedColorDrawable fromColorDrawable(ColorDrawable colorDrawable) {
        return new RoundedColorDrawable(colorDrawable.getColor());
    }

    private void updatePath() {
        float f2;
        float[] fArr;
        float[] fArr2;
        this.mPath.reset();
        this.mBorderPath.reset();
        this.mTempRect.set(getBounds());
        RectF rectF = this.mTempRect;
        float f3 = this.mBorderWidth;
        rectF.inset(f3 / 2.0f, f3 / 2.0f);
        int i2 = 0;
        if (this.mIsCircle) {
            this.mBorderPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i3 = 0;
            while (true) {
                fArr2 = this.mBorderRadii;
                if (i3 >= fArr2.length) {
                    break;
                }
                fArr2[i3] = (this.mRadii[i3] + this.mPadding) - (this.mBorderWidth / 2.0f);
                i3++;
            }
            this.mBorderPath.addRoundRect(this.mTempRect, fArr2, Path.Direction.CW);
        }
        RectF rectF2 = this.mTempRect;
        float f4 = this.mBorderWidth;
        rectF2.inset((-f4) / 2.0f, (-f4) / 2.0f);
        float f5 = this.mPadding;
        if (this.mScaleDownInsideBorders) {
            f2 = this.mBorderWidth;
        } else {
            f2 = 0.0f;
        }
        float f6 = f5 + f2;
        this.mTempRect.inset(f6, f6);
        if (this.mIsCircle) {
            this.mPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f, Path.Direction.CW);
        } else if (this.mScaleDownInsideBorders) {
            if (this.mInsideBorderRadii == null) {
                this.mInsideBorderRadii = new float[8];
            }
            while (true) {
                fArr = this.mInsideBorderRadii;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = this.mRadii[i2] - this.mBorderWidth;
                i2++;
            }
            this.mPath.addRoundRect(this.mTempRect, fArr, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mTempRect, this.mRadii, Path.Direction.CW);
        }
        float f7 = -f6;
        this.mTempRect.inset(f7, f7);
    }

    public void draw(Canvas canvas) {
        this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setFilterBitmap(getPaintFilterBitmap());
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.mBorderPath, this.mPaint);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getOpacity() {
        return DrawableUtils.getOpacityFromColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean getPaintFilterBitmap() {
        return this.mPaintFilterBitmap;
    }

    public float[] getRadii() {
        return this.mRadii;
    }

    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    public boolean isCircle() {
        return this.mIsCircle;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updatePath();
    }

    public void setAlpha(int i2) {
        if (i2 != this.mAlpha) {
            this.mAlpha = i2;
            invalidateSelf();
        }
    }

    public void setBorder(int i2, float f2) {
        if (this.mBorderColor != i2) {
            this.mBorderColor = i2;
            invalidateSelf();
        }
        if (this.mBorderWidth != f2) {
            this.mBorderWidth = f2;
            updatePath();
            invalidateSelf();
        }
    }

    public void setCircle(boolean z2) {
        this.mIsCircle = z2;
        updatePath();
        invalidateSelf();
    }

    public void setColor(int i2) {
        if (this.mColor != i2) {
            this.mColor = i2;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setPadding(float f2) {
        if (this.mPadding != f2) {
            this.mPadding = f2;
            updatePath();
            invalidateSelf();
        }
    }

    public void setPaintFilterBitmap(boolean z2) {
        if (this.mPaintFilterBitmap != z2) {
            this.mPaintFilterBitmap = z2;
            invalidateSelf();
        }
    }

    public void setRadii(float[] fArr) {
        boolean z2;
        if (fArr == null) {
            Arrays.fill(this.mRadii, 0.0f);
        } else {
            if (fArr.length == 8) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mRadii, 0, 8);
        }
        updatePath();
        invalidateSelf();
    }

    public void setRadius(float f2) {
        boolean z2;
        if (f2 >= 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "radius should be non negative");
        Arrays.fill(this.mRadii, f2);
        updatePath();
        invalidateSelf();
    }

    public void setScaleDownInsideBorders(boolean z2) {
        if (this.mScaleDownInsideBorders != z2) {
            this.mScaleDownInsideBorders = z2;
            updatePath();
            invalidateSelf();
        }
    }

    public RoundedColorDrawable(float[] fArr, int i2) {
        this(i2);
        setRadii(fArr);
    }

    public RoundedColorDrawable(float f2, int i2) {
        this(i2);
        setRadius(f2);
    }
}
