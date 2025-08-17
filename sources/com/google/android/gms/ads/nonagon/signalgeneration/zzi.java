package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdpv;

public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ zzaa zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzdpv zzd;

    public /* synthetic */ zzi(zzaa zzaa, String str, String str2, zzdpv zzdpv) {
        this.zza = zzaa;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzdpv;
    }

    public final void run() {
        this.zza.zzI(this.zzb, this.zzc, this.zzd);
    }
}
