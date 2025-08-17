package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzzj implements Runnable {
    public final /* synthetic */ zzzq zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzzj(zzzq zzzq, long j2, int i2) {
        this.zza = zzzq;
        this.zzb = j2;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc);
    }
}
