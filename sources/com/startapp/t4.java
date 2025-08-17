package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.splash.SplashAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

public class t4 extends sd {
    public t4(Context context, SplashAd splashAd, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, splashAd, adPreferences, adEventListener, AdPreferences.Placement.INAPP_SPLASH, true);
    }

    public void a(boolean z2) {
        super.a(z2);
        c(z2);
    }
}
