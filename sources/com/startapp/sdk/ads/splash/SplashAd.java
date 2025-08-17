package com.startapp.sdk.ads.splash;

import android.content.Context;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.t4;

public class SplashAd extends InterstitialAd {
    private static final long serialVersionUID = 1;

    public SplashAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_OVERLAY);
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new t4(this.f36173b, this, adPreferences, adEventListener).c();
    }

    @Deprecated
    public boolean load(AdPreferences adPreferences, AdEventListener adEventListener) {
        return super.load(adPreferences, adEventListener, false);
    }
}
