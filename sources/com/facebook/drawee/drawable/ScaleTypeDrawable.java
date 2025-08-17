package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ScalingUtils;

public class ScaleTypeDrawable extends ForwardingDrawable {
    Matrix mDrawMatrix;
    PointF mFocusPoint = null;
    ScalingUtils.ScaleType mScaleType;
    Object mScaleTypeState;
    private Matrix mTempMatrix = new Matrix();
    int mUnderlyingHeight = 0;
    int mUnderlyingWidth = 0;

    public ScaleTypeDrawable(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.mScaleType = scaleType;
    }

    private void configureBoundsIfUnderlyingChanged() {
        boolean z2;
        ScalingUtils.ScaleType scaleType = this.mScaleType;
        boolean z3 = true;
        if (scaleType instanceof ScalingUtils.StatefulScaleType) {
            Object state = ((ScalingUtils.StatefulScaleType) scaleType).getState();
            if (state == null || !state.equals(this.mScaleTypeState)) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mScaleTypeState = state;
        } else {
            z2 = false;
        }
        if (this.mUnderlyingWidth == getCurrent().getIntrinsicWidth() && this.mUnderlyingHeight == getCurrent().getIntrinsicHeight()) {
            z3 = false;
        }
        if (z3 || z2) {
            configureBounds();
        }
    }

    /* access modifiers changed from: package-private */
    public void configureBounds() {
        float f2;
        float f3;
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.mUnderlyingWidth = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mUnderlyingHeight = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.mScaleType == ScalingUtils.ScaleType.FIT_XY) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            ScalingUtils.ScaleType scaleType = this.mScaleType;
            Matrix matrix = this.mTempMatrix;
            PointF pointF = this.mFocusPoint;
            if (pointF != null) {
                f2 = pointF.x;
            } else {
                f2 = 0.5f;
            }
            if (pointF != null) {
                f3 = pointF.y;
            } else {
                f3 = 0.5f;
            }
            scaleType.getTransform(matrix, bounds, intrinsicWidth, intrinsicHeight, f2, f3);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    public void draw(Canvas canvas) {
        configureBoundsIfUnderlyingChanged();
        if (this.mDrawMatrix != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    public PointF getFocusPoint() {
        return this.mFocusPoint;
    }

    public ScalingUtils.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        configureBoundsIfUnderlyingChanged();
        Matrix matrix2 = this.mDrawMatrix;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        configureBounds();
    }

    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public void setFocusPoint(PointF pointF) {
        if (!Objects.equal(this.mFocusPoint, pointF)) {
            if (pointF == null) {
                this.mFocusPoint = null;
            } else {
                if (this.mFocusPoint == null) {
                    this.mFocusPoint = new PointF();
                }
                this.mFocusPoint.set(pointF);
            }
            configureBounds();
            invalidateSelf();
        }
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        if (!Objects.equal(this.mScaleType, scaleType)) {
            this.mScaleType = scaleType;
            this.mScaleTypeState = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public ScaleTypeDrawable(Drawable drawable, ScalingUtils.ScaleType scaleType, PointF pointF) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.mScaleType = scaleType;
        this.mFocusPoint = pointF;
    }
}
