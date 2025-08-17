package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzoq implements Runnable {
    public final /* synthetic */ zzos zza;
    public final /* synthetic */ zzam zzb;
    public final /* synthetic */ zzia zzc;

    public /* synthetic */ zzoq(zzos zzos, zzam zzam, zzia zzia) {
        this.zza = zzos;
        this.zzb = zzam;
        this.zzc = zzia;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc);
    }
}
