package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzor implements Runnable {
    public final /* synthetic */ zzos zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzor(zzos zzos, int i2, long j2, long j3) {
        this.zza = zzos;
        this.zzb = i2;
        this.zzc = j2;
        this.zzd = j3;
    }

    public final void run() {
        this.zza.zzq(this.zzb, this.zzc, this.zzd);
    }
}
