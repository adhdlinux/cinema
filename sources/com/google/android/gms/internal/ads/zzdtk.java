package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

final class zzdtk extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ AdView zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzdtr zzd;

    zzdtk(zzdtr zzdtr, String str, AdView adView, String str2) {
        this.zzd = zzdtr;
        this.zza = str;
        this.zzb = adView;
        this.zzc = str2;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzd.zzm(zzdtr.zzl(loadAdError), this.zzc);
    }

    public final void onAdLoaded() {
        this.zzd.zzg(this.zza, this.zzb, this.zzc);
    }
}
