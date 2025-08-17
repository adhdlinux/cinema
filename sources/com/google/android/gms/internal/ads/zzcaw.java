package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

final class zzcaw implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcbe zzb;

    zzcaw(zzcbe zzcbe, MediaPlayer mediaPlayer) {
        this.zzb = zzcbe;
        this.zza = mediaPlayer;
    }

    public final void run() {
        zzcbe.zzl(this.zzb, this.zza);
        zzcbe zzcbe = this.zzb;
        if (zzcbe.zzq != null) {
            zzcbe.zzq.zzf();
        }
    }
}
