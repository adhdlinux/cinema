package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzxk implements Runnable {
    public final /* synthetic */ zzxl zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzxk(zzxl zzxl, int i2, long j2, long j3) {
        this.zza = zzxl;
        this.zzb = i2;
        this.zzc = j2;
        this.zzd = j3;
    }

    public final void run() {
        zzxl zzxl = this.zza;
        zzxl.zzb.zzV(this.zzb, this.zzc, this.zzd);
    }
}
