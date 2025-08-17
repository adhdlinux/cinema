package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

public final /* synthetic */ class zzdti implements NativeAd.OnNativeAdLoadedListener {
    public final /* synthetic */ zzdtr zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzdti(zzdtr zzdtr, String str, String str2) {
        this.zza = zzdtr;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void onNativeAdLoaded(NativeAd nativeAd) {
        this.zza.zzg(this.zzb, nativeAd, this.zzc);
    }
}
