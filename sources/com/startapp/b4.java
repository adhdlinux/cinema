package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

public class b4 extends sd {
    public b4(Context context, HtmlAd htmlAd, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, htmlAd, adPreferences, adEventListener, AdPreferences.Placement.INAPP_OVERLAY, true);
    }

    public void a(boolean z2) {
        super.a(z2);
        c(z2);
    }
}
