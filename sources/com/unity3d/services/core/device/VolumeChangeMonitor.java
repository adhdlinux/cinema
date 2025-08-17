package com.unity3d.services.core.device;

import android.util.SparseArray;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.unity3d.services.core.webview.bridge.IEventSender;
import kotlin.jvm.internal.Intrinsics;

public final class VolumeChangeMonitor {
    /* access modifiers changed from: private */
    public final IEventSender eventSender;
    private final VolumeChange volumeChange;
    private final SparseArray<VolumeChangeListener> volumeChangeListeners = new SparseArray<>();

    public VolumeChangeMonitor(IEventSender iEventSender, VolumeChange volumeChange2) {
        Intrinsics.f(iEventSender, "eventSender");
        Intrinsics.f(volumeChange2, "volumeChange");
        this.eventSender = iEventSender;
        this.volumeChange = volumeChange2;
    }

    public final void registerVolumeChangeListener(int i2) {
        if (this.volumeChangeListeners.get(i2) == null) {
            VolumeChangeMonitor$registerVolumeChangeListener$listener$1 volumeChangeMonitor$registerVolumeChangeListener$listener$1 = new VolumeChangeMonitor$registerVolumeChangeListener$listener$1(this, i2);
            this.volumeChangeListeners.append(i2, volumeChangeMonitor$registerVolumeChangeListener$listener$1);
            this.volumeChange.registerListener(volumeChangeMonitor$registerVolumeChangeListener$listener$1);
        }
    }

    public final void unregisterVolumeChangeListener(int i2) {
        if (this.volumeChangeListeners.get(i2) != null) {
            VolumeChangeListener volumeChangeListener = this.volumeChangeListeners.get(i2);
            VolumeChange volumeChange2 = this.volumeChange;
            Intrinsics.e(volumeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            volumeChange2.unregisterListener(volumeChangeListener);
            this.volumeChangeListeners.remove(i2);
        }
    }
}
