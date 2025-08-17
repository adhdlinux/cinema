package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.nativead.NativeAdPreferences;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

public class p4 extends ie {

    /* renamed from: i  reason: collision with root package name */
    public NativeAdPreferences f35603i;

    public p4(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, NativeAdPreferences nativeAdPreferences) {
        super(context, ad, adPreferences, adEventListener, AdPreferences.Placement.INAPP_NATIVE);
        this.f35603i = nativeAdPreferences;
    }

    public void a(Ad ad) {
    }

    public GetAdRequest d() {
        GetAdRequest d2 = super.d();
        if (d2 == null) {
            return null;
        }
        d2.f36342p0 = this.f35603i.getAdsNumber();
        if (this.f35603i.getImageSize() != null) {
            d2.M = this.f35603i.getImageSize().getWidth();
            d2.N = this.f35603i.getImageSize().getHeight();
        } else {
            int primaryImageSize = this.f35603i.getPrimaryImageSize();
            int i2 = 2;
            if (primaryImageSize == -1) {
                primaryImageSize = 2;
            }
            d2.J0 = Integer.toString(primaryImageSize);
            int secondaryImageSize = this.f35603i.getSecondaryImageSize();
            if (secondaryImageSize != -1) {
                i2 = secondaryImageSize;
            }
            d2.K0 = Integer.toString(i2);
        }
        if (this.f35603i.isContentAd()) {
            d2.L0 = this.f35603i.isContentAd();
        }
        return d2;
    }
}
