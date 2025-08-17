package com.facebook.drawee.backends.pipeline.info;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Collection;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ForwardingImagePerfDataListener implements ImagePerfDataListener {
    private final Collection<ImagePerfDataListener> mListeners;

    public ForwardingImagePerfDataListener(Collection<ImagePerfDataListener> collection) {
        this.mListeners = collection;
    }

    public void onImageLoadStatusUpdated(ImagePerfData imagePerfData, int i2) {
        for (ImagePerfDataListener onImageLoadStatusUpdated : this.mListeners) {
            onImageLoadStatusUpdated.onImageLoadStatusUpdated(imagePerfData, i2);
        }
    }

    public void onImageVisibilityUpdated(ImagePerfData imagePerfData, int i2) {
        for (ImagePerfDataListener onImageVisibilityUpdated : this.mListeners) {
            onImageVisibilityUpdated.onImageVisibilityUpdated(imagePerfData, i2);
        }
    }
}
