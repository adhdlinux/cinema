package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

public final class zzbri extends zzbge {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbri(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    public final void zze(zzbgo zzbgo) {
        this.zza.onNativeAdLoaded(new zzbrb(zzbgo));
    }
}
