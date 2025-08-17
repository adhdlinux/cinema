package com.unity3d.services.core.device;

public interface VolumeChangeListener {
    int getStreamType();

    void onVolumeChanged(int i2);
}
