package com.startapp;

import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

public class t6 implements AdEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u6 f36570a;

    public t6(u6 u6Var) {
        this.f36570a = u6Var;
    }

    public void onFailedToReceiveAd(Ad ad) {
    }

    public void onReceiveAd(Ad ad) {
        if (this.f36570a.f36649e.showAd()) {
            u6 u6Var = this.f36570a;
            u6Var.getClass();
            u6Var.f36647c = System.currentTimeMillis();
            u6Var.f36648d = 0;
        }
    }
}
