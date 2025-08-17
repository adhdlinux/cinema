package com.facebook.ads.internal.q.c;

import android.content.Context;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public abstract class a extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20728a = "a";

    /* renamed from: b  reason: collision with root package name */
    private boolean f20729b;

    public a(Context context) {
        super(context);
        d();
    }

    private void d() {
        setWebChromeClient(a());
        setWebViewClient(b());
        b.b(this);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        try {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        } catch (Exception unused) {
            Log.w(f20728a, "Failed to initialize CookieManager.");
        }
    }

    /* access modifiers changed from: protected */
    public WebChromeClient a() {
        return new WebChromeClient();
    }

    /* access modifiers changed from: protected */
    public WebViewClient b() {
        return new WebViewClient();
    }

    public boolean c() {
        return this.f20729b;
    }

    public void destroy() {
        this.f20729b = true;
        super.destroy();
    }
}
