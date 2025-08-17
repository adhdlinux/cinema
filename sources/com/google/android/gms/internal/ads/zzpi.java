package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

public final /* synthetic */ class zzpi implements Runnable {
    public final /* synthetic */ AudioTrack zza;
    public final /* synthetic */ zzeb zzb;

    public /* synthetic */ zzpi(AudioTrack audioTrack, zzeb zzeb) {
        this.zza = audioTrack;
        this.zzb = zzeb;
    }

    public final void run() {
        zzpz.zzD(this.zza, this.zzb);
    }
}
