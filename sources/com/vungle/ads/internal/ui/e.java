package com.vungle.ads.internal.ui;

import android.os.Handler;
import android.webkit.WebView;
import com.vungle.ads.internal.ui.view.WebViewAPI;
import kotlinx.serialization.json.JsonObject;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WebViewAPI.MraidDelegate f37928b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37929c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ JsonObject f37930d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Handler f37931e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ VungleWebClient f37932f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WebView f37933g;

    public /* synthetic */ e(WebViewAPI.MraidDelegate mraidDelegate, String str, JsonObject jsonObject, Handler handler, VungleWebClient vungleWebClient, WebView webView) {
        this.f37928b = mraidDelegate;
        this.f37929c = str;
        this.f37930d = jsonObject;
        this.f37931e = handler;
        this.f37932f = vungleWebClient;
        this.f37933g = webView;
    }

    public final void run() {
        VungleWebClient.m219shouldOverrideUrlLoading$lambda6$lambda5$lambda4(this.f37928b, this.f37929c, this.f37930d, this.f37931e, this.f37932f, this.f37933g);
    }
}
