package com.unity3d.services.core.device;

import com.unity3d.services.core.webview.WebViewEventCategory;

public final class VolumeChangeMonitor$registerVolumeChangeListener$listener$1 implements VolumeChangeListener {
    final /* synthetic */ int $streamType;
    final /* synthetic */ VolumeChangeMonitor this$0;

    VolumeChangeMonitor$registerVolumeChangeListener$listener$1(VolumeChangeMonitor volumeChangeMonitor, int i2) {
        this.this$0 = volumeChangeMonitor;
        this.$streamType = i2;
    }

    public int getStreamType() {
        return this.$streamType;
    }

    public void onVolumeChanged(int i2) {
        this.this$0.eventSender.sendEvent(WebViewEventCategory.DEVICEINFO, DeviceInfoEvent.VOLUME_CHANGED, Integer.valueOf(getStreamType()), Integer.valueOf(i2), Integer.valueOf(Device.getStreamMaxVolume(this.$streamType)));
    }
}
