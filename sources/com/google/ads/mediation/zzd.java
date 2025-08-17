package com.google.ads.mediation;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

final class zzd extends FullScreenContentCallback {

    /* renamed from: a  reason: collision with root package name */
    final AbstractAdViewAdapter f22254a;

    /* renamed from: b  reason: collision with root package name */
    final MediationInterstitialListener f22255b;

    public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.f22254a = abstractAdViewAdapter;
        this.f22255b = mediationInterstitialListener;
    }

    public final void onAdDismissedFullScreenContent() {
        this.f22255b.onAdClosed(this.f22254a);
    }

    public final void onAdShowedFullScreenContent() {
        this.f22255b.onAdOpened(this.f22254a);
    }
}
