package com.startapp;

import com.startapp.j8;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

public class h8 implements AdEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j8.a f34624a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f34625b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ j8 f34626c;

    public h8(j8 j8Var, j8.a aVar, boolean z2) {
        this.f34626c = j8Var;
        this.f34624a = aVar;
        this.f34625b = z2;
    }

    public void onFailedToReceiveAd(Ad ad) {
        j8 j8Var = this.f34626c;
        j8Var.f34747e = null;
        j8Var.a(this.f34625b);
    }

    public void onReceiveAd(Ad ad) {
        p.b(this.f34626c.f34744b, (AdEventListener) this.f34624a, ad);
    }
}
