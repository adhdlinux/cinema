package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;

final class zze extends AdListener implements UnifiedNativeAd.OnUnifiedNativeAdLoadedListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener {

    /* renamed from: c  reason: collision with root package name */
    final AbstractAdViewAdapter f22256c;

    /* renamed from: d  reason: collision with root package name */
    final MediationNativeListener f22257d;

    public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
        this.f22256c = abstractAdViewAdapter;
        this.f22257d = mediationNativeListener;
    }

    public final void onAdClicked() {
        this.f22257d.onAdClicked(this.f22256c);
    }

    public final void onAdClosed() {
        this.f22257d.onAdClosed(this.f22256c);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.f22257d.onAdFailedToLoad((MediationNativeAdapter) this.f22256c, (AdError) loadAdError);
    }

    public final void onAdImpression() {
        this.f22257d.onAdImpression(this.f22256c);
    }

    public final void onAdLoaded() {
    }

    public final void onAdOpened() {
        this.f22257d.onAdOpened(this.f22256c);
    }

    public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        this.f22257d.zze(this.f22256c, nativeCustomTemplateAd, str);
    }

    public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
        this.f22257d.zzc(this.f22256c, nativeCustomTemplateAd);
    }

    public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
        this.f22257d.onAdLoaded(this.f22256c, new zza(unifiedNativeAd));
    }
}
