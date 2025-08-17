package com.applovin.impl.adview;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.facebook.ads.AudienceNetworkActivity;

public class t extends h {
    public t(u uVar, Context context) {
        super(context);
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(uVar);
        setWebChromeClient(new WebChromeClient());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
    }

    public void a(String str) {
        loadDataWithBaseURL("/", str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, (String) null, "");
    }
}
