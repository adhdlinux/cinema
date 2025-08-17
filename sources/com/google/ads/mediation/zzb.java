package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;

final class zzb extends AdListener implements AppEventListener, zza {

    /* renamed from: c  reason: collision with root package name */
    final AbstractAdViewAdapter f22250c;

    /* renamed from: d  reason: collision with root package name */
    final MediationBannerListener f22251d;

    public zzb(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
        this.f22250c = abstractAdViewAdapter;
        this.f22251d = mediationBannerListener;
    }

    public final void onAdClicked() {
        this.f22251d.onAdClicked(this.f22250c);
    }

    public final void onAdClosed() {
        this.f22251d.onAdClosed(this.f22250c);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.f22251d.onAdFailedToLoad((MediationBannerAdapter) this.f22250c, (AdError) loadAdError);
    }

    public final void onAdLoaded() {
        this.f22251d.onAdLoaded(this.f22250c);
    }

    public final void onAdOpened() {
        this.f22251d.onAdOpened(this.f22250c);
    }

    public final void onAppEvent(String str, String str2) {
        this.f22251d.zzd(this.f22250c, str, str2);
    }
}
