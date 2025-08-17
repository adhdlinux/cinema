package com.chartboost.sdk.impl;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.google.android.gms.common.internal.ImagesContract;
import com.vungle.ads.internal.ui.AdActivity;
import kotlin.jvm.internal.Intrinsics;

public final class y1 extends e4 {

    /* renamed from: c  reason: collision with root package name */
    public final d7 f19029c;

    /* renamed from: d  reason: collision with root package name */
    public final ya f19030d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19031e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y1(d7 d7Var, ya yaVar, f4 f4Var, z4 z4Var) {
        super(f4Var, z4Var);
        Intrinsics.f(d7Var, "impressionInterface");
        Intrinsics.f(yaVar, "gestureDetector");
        Intrinsics.f(f4Var, "callback");
        Intrinsics.f(z4Var, "eventTracker");
        this.f19029c = d7Var;
        this.f19030d = yaVar;
    }

    public final ya a() {
        return this.f19030d;
    }

    public final boolean b(String str) {
        if (!this.f19031e) {
            w7.e("CustomWebViewClient", "Attempt to open " + str + " detected before WebView loading finished.");
            this.f19029c.d(new x2(str, Boolean.FALSE));
            return true;
        } else if (!this.f19030d.a()) {
            return false;
        } else {
            this.f19029c.c(new x2(str, Boolean.FALSE));
            this.f19030d.b();
            return true;
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f19031e = true;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Intrinsics.f(str, ImagesContract.URL);
        return b(str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Intrinsics.f(webView, "view");
        Intrinsics.f(webResourceRequest, AdActivity.REQUEST_KEY_EXTRA);
        String uri = webResourceRequest.getUrl().toString();
        Intrinsics.e(uri, "request.url.toString()");
        return b(uri);
    }
}
