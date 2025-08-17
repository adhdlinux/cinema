package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

final class zzdto extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdtr zzb;

    zzdto(zzdtr zzdtr, String str) {
        this.zzb = zzdtr;
        this.zza = str;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.zzm(zzdtr.zzl(loadAdError), this.zza);
    }
}
