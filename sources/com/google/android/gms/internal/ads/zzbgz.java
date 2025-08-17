package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public final class zzbgz extends zzbge {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zza;

    public zzbgz(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zza = onUnifiedNativeAdLoadedListener;
    }

    public final void zze(zzbgo zzbgo) {
        this.zza.onUnifiedNativeAdLoaded(new zzbgp(zzbgo));
    }
}
