package com.google.android.gms.ads.mediation.customevent;

import android.view.View;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.internal.ads.zzbzr;

final class zza implements CustomEventBannerListener {
    private final CustomEventAdapter zza;
    private final MediationBannerListener zzb;

    public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
        this.zza = customEventAdapter;
        this.zzb = mediationBannerListener;
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
        this.zzb.onAdFailedToLoad((MediationBannerAdapter) this.zza, i2);
    }

    public final void onAdLeftApplication() {
        zzbzr.zze("Custom event adapter called onAdLeftApplication.");
        this.zzb.onAdLeftApplication(this.zza);
    }

    public final void onAdLoaded(View view) {
        zzbzr.zze("Custom event adapter called onAdLoaded.");
        this.zza.zze = view;
        this.zzb.onAdLoaded(this.zza);
    }

    public final void onAdOpened() {
        zzbzr.zze("Custom event adapter called onAdOpened.");
        this.zzb.onAdOpened(this.zza);
    }

    public final void onAdFailedToLoad(AdError adError) {
        zzbzr.zze("Custom event adapter called onAdFailedToLoad.");
        this.zzb.onAdFailedToLoad((MediationBannerAdapter) this.zza, adError);
    }
}
