package com.vungle.ads.internal.ui;

import android.os.Handler;
import android.webkit.WebView;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VungleWebClient f37925b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Handler f37926c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ WebView f37927d;

    public /* synthetic */ d(VungleWebClient vungleWebClient, Handler handler, WebView webView) {
        this.f37925b = vungleWebClient;
        this.f37926c = handler;
        this.f37927d = webView;
    }

    public final void run() {
        VungleWebClient.m217shouldOverrideUrlLoading$lambda6$lambda1(this.f37925b, this.f37926c, this.f37927d);
    }
}
