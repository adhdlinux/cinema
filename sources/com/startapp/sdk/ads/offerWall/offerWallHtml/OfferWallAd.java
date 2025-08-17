package com.startapp.sdk.ads.offerWall.offerWallHtml;

import android.content.Context;
import com.startapp.r4;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

public class OfferWallAd extends InterstitialAd {
    private static final long serialVersionUID = 1;

    public OfferWallAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_OFFER_WALL);
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new r4(this.f36173b, this, adPreferences, adEventListener).c();
    }
}
