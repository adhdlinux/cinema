package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Arrays;

public abstract class RoundedDrawable extends Drawable implements Rounded, TransformAwareDrawable {
    final RectF mBitmapBounds = new RectF();
    protected int mBorderColor = 0;
    protected final Path mBorderPath = new Path();
    final float[] mBorderRadii = new float[8];
    protected float mBorderWidth = 0.0f;
    final Matrix mBoundsTransform = new Matrix();
    private final float[] mCornerRadii = new float[8];
    private final Drawable mDelegate;
    final RectF mDrawableBounds = new RectF();
    RectF mInsideBorderBounds;
    float[] mInsideBorderRadii;
    Matrix mInsideBorderTransform;
    final Matrix mInverseParentTransform = new Matrix();
    protected boolean mIsCircle = false;
    private boolean mIsPathDirty = true;
    protected boolean mIsShaderTransformDirty = true;
    private float mPadding = 0.0f;
    private boolean mPaintFilterBitmap = false;
    final Matrix mParentTransform = new Matrix();
    protected final Path mPath = new Path();
    final Matrix mPrevBoundsTransform = new Matrix();
    Matrix mPrevInsideBorderTransform;
    final Matrix mPrevParentTransform = new Matrix();
    final RectF mPrevRootBounds = new RectF();
    protected boolean mRadiiNonZero = false;
    final RectF mRootBounds = new RectF();
    private boolean mScaleDownInsideBorders = false;
    final Matrix mTransform = new Matrix();
    private TransformCallback mTransformCallback;

    RoundedDrawable(Drawable drawable) {
        this.mDelegate = drawable;
    }

    public void clearColorFilter() {
        this.mDelegate.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("RoundedDrawable#draw");
        }
        this.mDelegate.draw(canvas);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public int getAlpha() {
        return this.mDelegate.getAlpha();
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public ColorFilter getColorFilter() {
        return this.mDelegate.getColorFilter();
    }

    public int getIntrinsicHeight() {
        return this.mDelegate.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDelegate.getIntrinsicWidth();
    }

    public int getOpacity() {
        return this.mDelegate.getOpacity();
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean getPaintFilterBitmap() {
        return this.mPaintFilterBitmap;
    }

    public float[] getRadii() {
        return this.mCornerRadii;
    }

    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    public boolean isCircle() {
        return this.mIsCircle;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.mDelegate.setBounds(rect);
    }

    public void setAlpha(int i2) {
        this.mDelegate.setAlpha(i2);
    }

    public void setBorder(int i2, float f2) {
        if (this.mBorderColor != i2 || this.mBorderWidth != f2) {
            this.mBorderColor = i2;
            this.mBorderWidth = f2;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    public void setCircle(boolean z2) {
        this.mIsCircle = z2;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    public void setColorFilter(int i2, PorterDuff.Mode mode) {
        this.mDelegate.setColorFilter(i2, mode);
    }

    public void setPadding(float f2) {
        if (this.mPadding != f2) {
            this.mPadding = f2;
            this.mIsPathDirty = true;
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
        boolean z3;
        if (fArr == null) {
            Arrays.fill(this.mCornerRadii, 0.0f);
            this.mRadiiNonZero = false;
        } else {
            if (fArr.length == 8) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mCornerRadii, 0, 8);
            this.mRadiiNonZero = false;
            for (int i2 = 0; i2 < 8; i2++) {
                boolean z4 = this.mRadiiNonZero;
                if (fArr[i2] > 0.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.mRadiiNonZero = z4 | z3;
            }
        }
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    public void setRadius(float f2) {
        boolean z2;
        boolean z3 = false;
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        Arrays.fill(this.mCornerRadii, f2);
        if (i2 != 0) {
            z3 = true;
        }
        this.mRadiiNonZero = z3;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    public void setScaleDownInsideBorders(boolean z2) {
        if (this.mScaleDownInsideBorders != z2) {
            this.mScaleDownInsideBorders = z2;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    public void setTransformCallback(TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRound() {
        return this.mIsCircle || this.mRadiiNonZero || this.mBorderWidth > 0.0f;
    }

    /* access modifiers changed from: protected */
    public void updatePath() {
        float f2;
        float[] fArr;
        if (this.mIsPathDirty) {
            this.mBorderPath.reset();
            RectF rectF = this.mRootBounds;
            float f3 = this.mBorderWidth;
            rectF.inset(f3 / 2.0f, f3 / 2.0f);
            if (this.mIsCircle) {
                this.mBorderPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i2 = 0;
                while (true) {
                    fArr = this.mBorderRadii;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr[i2] = (this.mCornerRadii[i2] + this.mPadding) - (this.mBorderWidth / 2.0f);
                    i2++;
                }
                this.mBorderPath.addRoundRect(this.mRootBounds, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.mRootBounds;
            float f4 = this.mBorderWidth;
            rectF2.inset((-f4) / 2.0f, (-f4) / 2.0f);
            this.mPath.reset();
            float f5 = this.mPadding;
            if (this.mScaleDownInsideBorders) {
                f2 = this.mBorderWidth;
            } else {
                f2 = 0.0f;
            }
            float f6 = f5 + f2;
            this.mRootBounds.inset(f6, f6);
            if (this.mIsCircle) {
                this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mScaleDownInsideBorders) {
                if (this.mInsideBorderRadii == null) {
                    this.mInsideBorderRadii = new float[8];
                }
                for (int i3 = 0; i3 < this.mBorderRadii.length; i3++) {
                    this.mInsideBorderRadii[i3] = this.mCornerRadii[i3] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.mRootBounds, this.mInsideBorderRadii, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Path.Direction.CW);
            }
            float f7 = -f6;
            this.mRootBounds.inset(f7, f7);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mIsPathDirty = false;
        }
    }

    /* access modifiers changed from: protected */
    public void updateTransform() {
        Matrix matrix;
        TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getTransform(this.mParentTransform);
            this.mTransformCallback.getRootBounds(this.mRootBounds);
        } else {
            this.mParentTransform.reset();
            this.mRootBounds.set(getBounds());
        }
        this.mBitmapBounds.set(0.0f, 0.0f, (float) getIntrinsicWidth(), (float) getIntrinsicHeight());
        this.mDrawableBounds.set(this.mDelegate.getBounds());
        this.mBoundsTransform.setRectToRect(this.mBitmapBounds, this.mDrawableBounds, Matrix.ScaleToFit.FILL);
        if (this.mScaleDownInsideBorders) {
            RectF rectF = this.mInsideBorderBounds;
            if (rectF == null) {
                this.mInsideBorderBounds = new RectF(this.mRootBounds);
            } else {
                rectF.set(this.mRootBounds);
            }
            RectF rectF2 = this.mInsideBorderBounds;
            float f2 = this.mBorderWidth;
            rectF2.inset(f2, f2);
            if (this.mInsideBorderTransform == null) {
                this.mInsideBorderTransform = new Matrix();
            }
            this.mInsideBorderTransform.setRectToRect(this.mRootBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
        } else {
            Matrix matrix2 = this.mInsideBorderTransform;
            if (matrix2 != null) {
                matrix2.reset();
            }
        }
        if (!this.mParentTransform.equals(this.mPrevParentTransform) || !this.mBoundsTransform.equals(this.mPrevBoundsTransform) || ((matrix = this.mInsideBorderTransform) != null && !matrix.equals(this.mPrevInsideBorderTransform))) {
            this.mIsShaderTransformDirty = true;
            this.mParentTransform.invert(this.mInverseParentTransform);
            this.mTransform.set(this.mParentTransform);
            if (this.mScaleDownInsideBorders) {
                this.mTransform.postConcat(this.mInsideBorderTransform);
            }
            this.mTransform.preConcat(this.mBoundsTransform);
            this.mPrevParentTransform.set(this.mParentTransform);
            this.mPrevBoundsTransform.set(this.mBoundsTransform);
            if (this.mScaleDownInsideBorders) {
                Matrix matrix3 = this.mPrevInsideBorderTransform;
                if (matrix3 == null) {
                    this.mPrevInsideBorderTransform = new Matrix(this.mInsideBorderTransform);
                } else {
                    matrix3.set(this.mInsideBorderTransform);
                }
            } else {
                Matrix matrix4 = this.mPrevInsideBorderTransform;
                if (matrix4 != null) {
                    matrix4.reset();
                }
            }
        }
        if (!this.mRootBounds.equals(this.mPrevRootBounds)) {
            this.mIsPathDirty = true;
            this.mPrevRootBounds.set(this.mRootBounds);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDelegate.setColorFilter(colorFilter);
    }
}
