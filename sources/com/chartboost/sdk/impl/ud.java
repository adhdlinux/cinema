package com.chartboost.sdk.impl;

import android.webkit.WebView;

public class ud extends t {
    public ud(String str, WebView webView) {
        super(str);
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
