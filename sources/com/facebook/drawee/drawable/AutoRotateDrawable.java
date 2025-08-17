package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;

public class AutoRotateDrawable extends ForwardingDrawable implements Runnable, CloneableDrawable {
    private static final int DEGREES_IN_FULL_ROTATION = 360;
    private static final int FRAME_INTERVAL_MS = 20;
    private boolean mClockwise;
    private int mInterval;
    private boolean mIsScheduled;
    float mRotationAngle;

    public AutoRotateDrawable(Drawable drawable, int i2) {
        this(drawable, i2, true);
    }

    private int getIncrement() {
        return (int) ((20.0f / ((float) this.mInterval)) * 360.0f);
    }

    private void scheduleNextFrame() {
        if (!this.mIsScheduled) {
            this.mIsScheduled = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i2 = bounds.right;
        int i3 = bounds.left;
        int i4 = i2 - i3;
        int i5 = bounds.bottom;
        int i6 = bounds.top;
        int i7 = i5 - i6;
        float f2 = this.mRotationAngle;
        if (!this.mClockwise) {
            f2 = 360.0f - f2;
        }
        canvas.rotate(f2, (float) (i3 + (i4 / 2)), (float) (i6 + (i7 / 2)));
        super.draw(canvas);
        canvas.restoreToCount(save);
        scheduleNextFrame();
    }

    public void reset() {
        this.mRotationAngle = 0.0f;
        this.mIsScheduled = false;
        unscheduleSelf(this);
        invalidateSelf();
    }

    public void run() {
        this.mIsScheduled = false;
        this.mRotationAngle += (float) getIncrement();
        invalidateSelf();
    }

    public void setClockwise(boolean z2) {
        this.mClockwise = z2;
    }

    public AutoRotateDrawable(Drawable drawable, int i2, boolean z2) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.mRotationAngle = 0.0f;
        this.mIsScheduled = false;
        this.mInterval = i2;
        this.mClockwise = z2;
    }

    public AutoRotateDrawable cloneDrawable() {
        return new AutoRotateDrawable(DrawableUtils.cloneDrawable(getDrawable()), this.mInterval, this.mClockwise);
    }
}
