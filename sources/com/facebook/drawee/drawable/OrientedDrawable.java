package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.common.RotationOptions;

public class OrientedDrawable extends ForwardingDrawable {
    private int mExifOrientation;
    private int mRotationAngle;
    final Matrix mRotationMatrix;
    private final Matrix mTempMatrix;
    private final RectF mTempRectF;

    public OrientedDrawable(Drawable drawable, int i2) {
        this(drawable, i2, 0);
    }

    public void draw(Canvas canvas) {
        int i2;
        if (this.mRotationAngle > 0 || !((i2 = this.mExifOrientation) == 0 || i2 == 1)) {
            int save = canvas.save();
            canvas.concat(this.mRotationMatrix);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    public int getIntrinsicHeight() {
        int i2 = this.mExifOrientation;
        if (i2 == 5 || i2 == 7 || this.mRotationAngle % RotationOptions.ROTATE_180 != 0) {
            return super.getIntrinsicWidth();
        }
        return super.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        int i2 = this.mExifOrientation;
        if (i2 == 5 || i2 == 7 || this.mRotationAngle % RotationOptions.ROTATE_180 != 0) {
            return super.getIntrinsicHeight();
        }
        return super.getIntrinsicWidth();
    }

    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        if (!this.mRotationMatrix.isIdentity()) {
            matrix.preConcat(this.mRotationMatrix);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        int i2;
        Drawable current = getCurrent();
        int i3 = this.mRotationAngle;
        if (i3 > 0 || !((i2 = this.mExifOrientation) == 0 || i2 == 1)) {
            int i4 = this.mExifOrientation;
            if (i4 == 2) {
                this.mRotationMatrix.setScale(-1.0f, 1.0f);
            } else if (i4 == 7) {
                this.mRotationMatrix.setRotate(270.0f, (float) rect.centerX(), (float) rect.centerY());
                this.mRotationMatrix.postScale(-1.0f, 1.0f);
            } else if (i4 == 4) {
                this.mRotationMatrix.setScale(1.0f, -1.0f);
            } else if (i4 != 5) {
                this.mRotationMatrix.setRotate((float) i3, (float) rect.centerX(), (float) rect.centerY());
            } else {
                this.mRotationMatrix.setRotate(270.0f, (float) rect.centerX(), (float) rect.centerY());
                this.mRotationMatrix.postScale(1.0f, -1.0f);
            }
            this.mTempMatrix.reset();
            this.mRotationMatrix.invert(this.mTempMatrix);
            this.mTempRectF.set(rect);
            this.mTempMatrix.mapRect(this.mTempRectF);
            RectF rectF = this.mTempRectF;
            current.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            return;
        }
        current.setBounds(rect);
    }

    public OrientedDrawable(Drawable drawable, int i2, int i3) {
        super(drawable);
        this.mTempMatrix = new Matrix();
        this.mTempRectF = new RectF();
        this.mRotationMatrix = new Matrix();
        this.mRotationAngle = i2 - (i2 % 90);
        this.mExifOrientation = (i3 < 0 || i3 > 8) ? 0 : i3;
    }
}
