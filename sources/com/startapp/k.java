package com.startapp;

import android.webkit.WebView;

public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebView f34789a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34790b;

    public k(WebView webView, String str) {
        this.f34789a = webView;
        this.f34790b = str;
    }

    public void run() {
        this.f34789a.loadUrl(this.f34790b);
    }
}
