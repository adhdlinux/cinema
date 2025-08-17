package com.google.android.gms.internal.ads;

import java.util.List;

public final /* synthetic */ class zzdrx implements Runnable {
    public final /* synthetic */ zzdsc zza;
    public final /* synthetic */ zzfbd zzb;
    public final /* synthetic */ zzbkj zzc;
    public final /* synthetic */ List zzd;
    public final /* synthetic */ String zze;

    public /* synthetic */ zzdrx(zzdsc zzdsc, zzfbd zzfbd, zzbkj zzbkj, List list, String str) {
        this.zza = zzdsc;
        this.zzb = zzfbd;
        this.zzc = zzbkj;
        this.zzd = list;
        this.zze = str;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
