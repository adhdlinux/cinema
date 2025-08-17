package com.vungle.ads.internal.ui;

import android.webkit.WebView;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VungleWebClient f37922b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WebView f37923c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37924d;

    public /* synthetic */ c(VungleWebClient vungleWebClient, WebView webView, String str) {
        this.f37922b = vungleWebClient;
        this.f37923c = webView;
        this.f37924d = str;
    }

    public final void run() {
        VungleWebClient.m218shouldOverrideUrlLoading$lambda6$lambda1$lambda0(this.f37922b, this.f37923c, this.f37924d);
    }
}
