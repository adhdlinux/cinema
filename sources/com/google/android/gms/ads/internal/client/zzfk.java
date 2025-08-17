package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.VideoController;

public final class zzfk extends zzds {
    private final VideoController.VideoLifecycleCallbacks zza;

    public zzfk(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zza = videoLifecycleCallbacks;
    }

    public final void zze() {
        this.zza.onVideoEnd();
    }

    public final void zzf(boolean z2) {
        this.zza.onVideoMute(z2);
    }

    public final void zzg() {
        this.zza.onVideoPause();
    }

    public final void zzh() {
        this.zza.onVideoPlay();
    }

    public final void zzi() {
        this.zza.onVideoStart();
    }
}
