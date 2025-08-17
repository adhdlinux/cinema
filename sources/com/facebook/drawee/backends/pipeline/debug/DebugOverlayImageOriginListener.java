package com.facebook.drawee.backends.pipeline.debug;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class DebugOverlayImageOriginListener implements ImageOriginListener {
    private int mImageOrigin = 1;

    public int getImageOrigin() {
        return this.mImageOrigin;
    }

    public void onImageLoaded(String str, int i2, boolean z2, String str2) {
        this.mImageOrigin = i2;
    }
}
