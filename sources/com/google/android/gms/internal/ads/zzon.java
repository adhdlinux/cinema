package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzon implements Runnable {
    public final /* synthetic */ zzos zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzon(zzos zzos, String str, long j2, long j3) {
        this.zza = zzos;
        this.zzb = str;
        this.zzc = j2;
        this.zzd = j3;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc, this.zzd);
    }
}
