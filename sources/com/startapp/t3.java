package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.banner.banner3d.Banner3DAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

public class t3 extends ie {

    /* renamed from: i  reason: collision with root package name */
    public int f36568i;

    public t3(Context context, Banner3DAd banner3DAd, int i2, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, banner3DAd, adPreferences, adEventListener, AdPreferences.Placement.INAPP_BANNER);
        this.f36568i = i2;
    }

    public void a(Ad ad) {
    }

    public GetAdRequest d() {
        l3 l3Var = new l3();
        a((GetAdRequest) l3Var);
        l3Var.f36342p0 = BannerMetaData.f35889b.a().a();
        l3Var.f36351y0 = this.f36568i;
        l3Var.S0 = ((Banner3DAd) this.f35754b).i();
        l3Var.f(this.f35753a);
        return l3Var;
    }
}
