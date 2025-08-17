package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzeu implements Runnable {
    public final /* synthetic */ zzey zza;
    public final /* synthetic */ zzxq zzb;

    public /* synthetic */ zzeu(zzey zzey, zzxq zzxq) {
        this.zza = zzey;
        this.zzb = zzxq;
    }

    public final void run() {
        zzey zzey = this.zza;
        zzxq zzxq = this.zzb;
        zzxq.zza.zzk(zzey.zza());
    }
}
