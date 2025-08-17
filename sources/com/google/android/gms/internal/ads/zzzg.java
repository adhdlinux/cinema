package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzzg implements Runnable {
    public final /* synthetic */ zzzq zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzzg(zzzq zzzq, int i2, long j2) {
        this.zza = zzzq;
        this.zzb = i2;
        this.zzc = j2;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc);
    }
}
