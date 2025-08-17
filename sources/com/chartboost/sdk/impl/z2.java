package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

public class z2 extends WebView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z2(Context context) {
        super(context);
        Intrinsics.f(context, "context");
    }

    public final void a() {
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(true);
            settings.setAllowContentAccess(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setAllowContentAccess(true);
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setBuiltInZoomControls(false);
            settings.setDisplayZoomControls(false);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        super.setWebChromeClient(webChromeClient);
        a();
    }
}
