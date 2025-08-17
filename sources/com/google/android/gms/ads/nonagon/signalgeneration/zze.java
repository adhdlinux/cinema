package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzdpv;
import com.google.android.gms.internal.ads.zzdqf;

public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ zzdqf zza;
    public final /* synthetic */ zzdpv zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ Pair[] zzd;

    public /* synthetic */ zze(zzdqf zzdqf, zzdpv zzdpv, String str, Pair[] pairArr) {
        this.zza = zzdqf;
        this.zzb = zzdpv;
        this.zzc = str;
        this.zzd = pairArr;
    }

    public final void run() {
        zzf.zzd(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
