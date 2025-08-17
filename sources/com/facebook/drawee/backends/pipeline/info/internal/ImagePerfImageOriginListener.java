package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ImagePerfImageOriginListener implements ImageOriginListener {
    private final ImagePerfMonitor mImagePerfMonitor;
    private final ImagePerfState mImagePerfState;

    public ImagePerfImageOriginListener(ImagePerfState imagePerfState, ImagePerfMonitor imagePerfMonitor) {
        this.mImagePerfState = imagePerfState;
        this.mImagePerfMonitor = imagePerfMonitor;
    }

    public void onImageLoaded(String str, int i2, boolean z2, String str2) {
        this.mImagePerfState.setImageOrigin(i2);
        this.mImagePerfState.setUltimateProducerName(str2);
        this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 1);
    }
}
