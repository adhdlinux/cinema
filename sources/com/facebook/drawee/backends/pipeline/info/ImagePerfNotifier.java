package com.facebook.drawee.backends.pipeline.info;

public interface ImagePerfNotifier {
    void notifyListenersOfVisibilityStateUpdate(ImagePerfState imagePerfState, int i2);

    void notifyStatusUpdated(ImagePerfState imagePerfState, int i2);
}
