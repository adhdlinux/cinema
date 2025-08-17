package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdrt implements Runnable {
    public final /* synthetic */ zzdsc zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ zzcaj zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ long zze;
    public final /* synthetic */ zzffn zzf;

    public /* synthetic */ zzdrt(zzdsc zzdsc, Object obj, zzcaj zzcaj, String str, long j2, zzffn zzffn) {
        this.zza = zzdsc;
        this.zzb = obj;
        this.zzc = zzcaj;
        this.zzd = str;
        this.zze = j2;
        this.zzf = zzffn;
    }

    public final void run() {
        this.zza.zzq(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
