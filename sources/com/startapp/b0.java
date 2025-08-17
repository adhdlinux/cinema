package com.startapp;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;

public class b0 extends AdSessionStatePublisher {
    @SuppressLint({"SetJavaScriptEnabled"})
    public b0(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
