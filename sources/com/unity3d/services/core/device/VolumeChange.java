package com.unity3d.services.core.device;

public interface VolumeChange {
    void clearAllListeners();

    void registerListener(VolumeChangeListener volumeChangeListener);

    void startObserving();

    void stopObserving();

    void unregisterListener(VolumeChangeListener volumeChangeListener);
}
