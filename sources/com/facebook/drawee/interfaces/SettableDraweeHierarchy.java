package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;

public interface SettableDraweeHierarchy extends DraweeHierarchy {
    void reset();

    void setControllerOverlay(Drawable drawable);

    void setFailure(Throwable th);

    void setImage(Drawable drawable, float f2, boolean z2);

    void setProgress(float f2, boolean z2);

    void setRetry(Throwable th);
}
