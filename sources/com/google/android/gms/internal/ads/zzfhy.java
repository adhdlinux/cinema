package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.webkit.WebView;

public final class zzfhy extends zzfhx {
    @SuppressLint({"SetJavaScriptEnabled"})
    public zzfhy(WebView webView) {
        if (!webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        zzi(webView);
    }
}
