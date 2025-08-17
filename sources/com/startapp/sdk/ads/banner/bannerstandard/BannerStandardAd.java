package com.startapp.sdk.ads.banner.bannerstandard;

import android.content.Context;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.u3;

public class BannerStandardAd extends HtmlAd {
    private static final long serialVersionUID = 1;
    private int bannerType;
    private boolean fixedSize;
    private int offset;

    public BannerStandardAd(Context context, int i2) {
        super(context, AdPreferences.Placement.INAPP_BANNER);
        this.offset = i2;
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new u3(this.f36173b, this, this.offset, adPreferences, adEventListener).c();
        this.offset++;
    }

    public void b(boolean z2) {
        this.fixedSize = z2;
    }

    public void c(int i2) {
        this.bannerType = i2;
    }

    public int u() {
        return this.bannerType;
    }

    public int v() {
        return this.offset;
    }

    public boolean w() {
        return this.fixedSize;
    }
}
