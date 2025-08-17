package com.adcolony.sdk;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;

public class AdColonyAdViewActivity extends b {

    /* renamed from: k  reason: collision with root package name */
    AdColonyAdView f12844k;

    public AdColonyAdViewActivity() {
        AdColonyAdView adColonyAdView;
        if (!a.i()) {
            adColonyAdView = null;
        } else {
            adColonyAdView = a.f().r0();
        }
        this.f12844k = adColonyAdView;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        ViewParent parent = this.f12948b.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f12948b);
        }
        this.f12844k.a();
        a.f().v((AdColonyAdView) null);
        finish();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.f12844k.b();
    }

    public void onBackPressed() {
        f();
    }

    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        AdColonyAdView adColonyAdView;
        if (!a.i() || (adColonyAdView = this.f12844k) == null) {
            a.f().v((AdColonyAdView) null);
            finish();
            return;
        }
        this.f12949c = adColonyAdView.getOrientation();
        super.onCreate(bundle);
        this.f12844k.b();
        AdColonyAdViewListener listener = this.f12844k.getListener();
        if (listener != null) {
            listener.g(this.f12844k);
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
