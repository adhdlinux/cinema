package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.internal.ads.zzbzr;

final class zzc implements CustomEventNativeListener {
    private final CustomEventAdapter zza;
    private final MediationNativeListener zzb;

    public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
        this.zza = customEventAdapter;
        this.zzb = mediationNativeListener;
    }

    public final void onAdClicked() {
        zzbzr.zze("Custom event adapter called onAdClicked.");
        this.zzb.onAdClicked(this.zza);
    }

    public final void onAdClosed() {
        zzbzr.zze("Custom event adapter called onAdClosed.");
        this.zzb.onAdClosed(this.zza);
    }

    public final void onAdFailedToLoad(int i2) {
        zzbzr.zze("Custom event adapter called onAdFailedToLoad.");
        this.zzb.onAdFailedToLoad((MediationNativeAdapter) this.zza, i2);
    }

    public final void onAdImpression() {
        zzbzr.zze("Custom event adapter called onAdImpression.");
        this.zzb.onAdImpression(this.zza);
    }

    public final void onAdLeftApplication() {
        zzbzr.zze("Custom event adapter called onAdLeftApplication.");
        this.zzb.onAdLeftApplication(this.zza);
    }

    public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        zzbzr.zze("Custom event adapter called onAdLoaded.");
        this.zzb.onAdLoaded(this.zza, unifiedNativeAdMapper);
    }

    public final void onAdOpened() {
        zzbzr.zze("Custom event adapter called onAdOpened.");
        this.zzb.onAdOpened(this.zza);
    }

    public final void onAdFailedToLoad(AdError adError) {
        zzbzr.zze("Custom event adapter called onAdFailedToLoad.");
        this.zzb.onAdFailedToLoad((MediationNativeAdapter) this.zza, adError);
    }
}
