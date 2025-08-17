package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.offerWall.offerWallJson.OfferWall3DAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import java.util.ArrayList;
import java.util.List;

public class s4 extends ie {
    public s4(Context context, OfferWall3DAd offerWall3DAd, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, offerWall3DAd, adPreferences, adEventListener, AdPreferences.Placement.INAPP_OFFER_WALL);
    }

    public void a(Ad ad) {
        OfferWall3DAd offerWall3DAd = (OfferWall3DAd) ad;
        List<AdDetails> g2 = offerWall3DAd.g();
        l4 a2 = m4.f34897a.a(offerWall3DAd.h());
        a2.getClass();
        a2.f34855b = new ArrayList();
        a2.f34856c = "";
        if (g2 != null) {
            for (AdDetails a3 : g2) {
                a2.a(a3);
            }
        }
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
