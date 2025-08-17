package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzzm implements Runnable {
    public final /* synthetic */ zzzq zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzzm(zzzq zzzq, String str, long j2, long j3) {
        this.zza = zzzq;
        this.zzb = str;
        this.zzc = j2;
        this.zzd = j3;
    }

    public final void run() {
        this.zza.zzg(this.zzb, this.zzc, this.zzd);
    }
}
