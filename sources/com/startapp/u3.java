package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

public class u3 extends sd {

    /* renamed from: m  reason: collision with root package name */
    public int f36641m;

    public u3(Context context, HtmlAd htmlAd, int i2, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, htmlAd, adPreferences, adEventListener, AdPreferences.Placement.INAPP_BANNER, false);
        this.f36641m = i2;
    }

    public void a(boolean z2) {
        super.a(z2);
        c(z2);
    }

    public GetAdRequest d() {
        BannerStandardAd bannerStandardAd = (BannerStandardAd) this.f35754b;
        l3 l3Var = new l3();
        a((GetAdRequest) l3Var);
        l3Var.M = bannerStandardAd.p();
        l3Var.N = bannerStandardAd.i();
        l3Var.f36351y0 = this.f36641m;
        l3Var.f36342p0 = BannerMetaData.f35889b.a().f();
        l3Var.S0 = bannerStandardAd.w();
        l3Var.T0 = bannerStandardAd.u();
        l3Var.f(this.f35753a);
        return l3Var;
    }
}
