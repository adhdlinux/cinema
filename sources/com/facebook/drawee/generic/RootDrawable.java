package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {
    Drawable mControllerOverlay = null;
    private VisibilityCallback mVisibilityCallback;

    public RootDrawable(Drawable drawable) {
        super(drawable);
    }

    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            VisibilityCallback visibilityCallback = this.mVisibilityCallback;
            if (visibilityCallback != null) {
                visibilityCallback.onDraw();
            }
            super.draw(canvas);
            Drawable drawable = this.mControllerOverlay;
            if (drawable != null) {
                drawable.setBounds(getBounds());
                this.mControllerOverlay.draw(canvas);
            }
        }
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public void setControllerOverlay(Drawable drawable) {
        this.mControllerOverlay = drawable;
        invalidateSelf();
    }

    public void setVisibilityCallback(VisibilityCallback visibilityCallback) {
        this.mVisibilityCallback = visibilityCallback;
    }

    public boolean setVisible(boolean z2, boolean z3) {
        VisibilityCallback visibilityCallback = this.mVisibilityCallback;
        if (visibilityCallback != null) {
            visibilityCallback.onVisibilityChange(z2);
        }
        return super.setVisible(z2, z3);
    }
}
