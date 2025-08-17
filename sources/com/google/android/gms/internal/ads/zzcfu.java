package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcfu implements Runnable {
    public final /* synthetic */ zzcfv zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ boolean zze;

    public /* synthetic */ zzcfu(zzcfv zzcfv, int i2, int i3, boolean z2, boolean z3) {
        this.zza = zzcfv;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z2;
        this.zze = z3;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
