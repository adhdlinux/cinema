package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;

final class zzpx {
    final /* synthetic */ zzpz zza;
    private final Handler zzb = new Handler(Looper.myLooper());
    private final AudioTrack.StreamEventCallback zzc;

    public zzpx(zzpz zzpz) {
        this.zza = zzpz;
        this.zzc = new zzpw(this, zzpz);
    }

    public final void zza(AudioTrack audioTrack) {
        audioTrack.registerStreamEventCallback(new zzpv(this.zzb), this.zzc);
    }

    public final void zzb(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.zzc);
        this.zzb.removeCallbacksAndMessages((Object) null);
    }
}
