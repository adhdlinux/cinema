package com.startapp.sdk.ads.banner.banner3d;

import android.content.Context;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.t3;

public class Banner3DAd extends JsonAd {
    private static final long serialVersionUID = 1;
    private boolean fixedSize;
    private int offset;

    public Banner3DAd(Context context, int i2) {
        super(context, AdPreferences.Placement.INAPP_BANNER);
        this.offset = i2;
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new t3(this.f36173b, this, this.offset, adPreferences, adEventListener).c();
        this.offset++;
    }

    public void b(boolean z2) {
        this.fixedSize = z2;
    }

    public int h() {
        return this.offset;
    }

    public boolean i() {
        return this.fixedSize;
    }
}
