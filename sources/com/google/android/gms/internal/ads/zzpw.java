package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

final class zzpw extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzpz zza;
    final /* synthetic */ zzpx zzb;

    zzpw(zzpx zzpx, zzpz zzpz) {
        this.zzb = zzpx;
        this.zza = zzpz;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i2) {
        if (audioTrack.equals(this.zzb.zza.zzt)) {
            zzpz zzpz = this.zzb.zza;
            if (zzpz.zzp != null && zzpz.zzQ) {
                zzpz.zzp.zzb();
            }
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        if (audioTrack.equals(this.zzb.zza.zzt)) {
            zzpz zzpz = this.zzb.zza;
            if (zzpz.zzp != null && zzpz.zzQ) {
                zzpz.zzp.zzb();
            }
        }
    }
}
