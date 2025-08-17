package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzzh implements Runnable {
    public final /* synthetic */ zzzq zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzzh(zzzq zzzq, Object obj, long j2) {
        this.zza = zzzq;
        this.zzb = obj;
        this.zzc = j2;
    }

    public final void run() {
        this.zza.zzm(this.zzb, this.zzc);
    }
}
