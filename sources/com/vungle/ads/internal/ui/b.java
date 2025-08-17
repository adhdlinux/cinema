package com.vungle.ads.internal.ui;

import android.webkit.WebView;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VungleWebClient f37920b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WebView f37921c;

    public /* synthetic */ b(VungleWebClient vungleWebClient, WebView webView) {
        this.f37920b = vungleWebClient;
        this.f37921c = webView;
    }

    public final void run() {
        VungleWebClient.m220shouldOverrideUrlLoading$lambda6$lambda5$lambda4$lambda3(this.f37920b, this.f37921c);
    }
}
