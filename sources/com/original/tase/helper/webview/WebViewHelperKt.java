package com.original.tase.helper.webview;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import g1.a;
import kotlin.jvm.internal.Intrinsics;

public final class WebViewHelperKt {
    @SuppressLint({"SetJavaScriptEnabled", "ClickableViewAccessibility"})
    public static final void b(WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient) {
        Intrinsics.f(webView, "<this>");
        Intrinsics.f(webViewClient, "client");
        Intrinsics.f(webChromeClient, "chromeClient");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(webViewClient);
        webView.setWebChromeClient(webChromeClient);
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        webView.setBackgroundColor(0);
        webView.setOnTouchListener(new a());
    }

    /* access modifiers changed from: private */
    public static final boolean c(View view, MotionEvent motionEvent) {
        return true;
    }
}
