package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.offerWall.offerWallHtml.OfferWallAd;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

public class r4 extends sd {
    public r4(Context context, OfferWallAd offerWallAd, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, offerWallAd, adPreferences, adEventListener, AdPreferences.Placement.INAPP_OFFER_WALL, true);
    }

    public void a(boolean z2) {
        super.a(z2);
        c(z2);
    }

    public GetAdRequest d() {
        GetAdRequest d2 = super.d();
        if (d2 == null) {
            return null;
        }
        d2.f36342p0 = AdsCommonMetaData.f36186h.t();
        return d2;
    }
}
