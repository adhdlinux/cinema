package com.adcolony.sdk;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class AdColonyInterstitialActivity extends b {

    /* renamed from: k  reason: collision with root package name */
    AdColonyInterstitial f12880k;

    /* renamed from: l  reason: collision with root package name */
    private i f12881l;

    public AdColonyInterstitialActivity() {
        AdColonyInterstitial adColonyInterstitial;
        if (!a.i()) {
            adColonyInterstitial = null;
        } else {
            adColonyInterstitial = a.f().q0();
        }
        this.f12880k = adColonyInterstitial;
    }

    /* access modifiers changed from: package-private */
    public void c(h0 h0Var) {
        String l2;
        super.c(h0Var);
        d T = a.f().T();
        f1 C = c0.C(h0Var.a(), "v4iap");
        e1 d2 = c0.d(C, "product_ids");
        AdColonyInterstitial adColonyInterstitial = this.f12880k;
        if (!(adColonyInterstitial == null || adColonyInterstitial.w() == null || (l2 = d2.l(0)) == null)) {
            this.f12880k.w().f(this.f12880k, l2, c0.A(C, "engagement_type"));
        }
        T.g(this.f12948b);
        if (this.f12880k != null) {
            T.z().remove(this.f12880k.j());
            if (this.f12880k.w() != null) {
                this.f12880k.w().d(this.f12880k);
                this.f12880k.e((c) null);
                this.f12880k.K((AdColonyInterstitialListener) null);
            }
            this.f12880k.F();
            this.f12880k = null;
        }
        i iVar = this.f12881l;
        if (iVar != null) {
            iVar.a();
            this.f12881l = null;
        }
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        int i2;
        AdColonyInterstitial adColonyInterstitial;
        AdColonyInterstitial adColonyInterstitial2 = this.f12880k;
        if (adColonyInterstitial2 == null) {
            i2 = -1;
        } else {
            i2 = adColonyInterstitial2.u();
        }
        this.f12949c = i2;
        super.onCreate(bundle);
        if (a.i() && (adColonyInterstitial = this.f12880k) != null) {
            p0 s2 = adColonyInterstitial.s();
            if (s2 != null) {
                s2.e(this.f12948b);
            }
            this.f12881l = new i(new Handler(Looper.getMainLooper()), this.f12880k);
            if (this.f12880k.w() != null) {
                this.f12880k.w().h(this.f12880k);
            }
        }
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }
}
