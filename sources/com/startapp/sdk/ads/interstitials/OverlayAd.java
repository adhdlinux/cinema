package com.startapp.sdk.ads.interstitials;

import android.content.Context;
import com.startapp.b4;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

public class OverlayAd extends InterstitialAd {
    private static final long serialVersionUID = 1;

    public OverlayAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_OVERLAY);
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new b4(this.f36173b, this, adPreferences, adEventListener).c();
    }
}
