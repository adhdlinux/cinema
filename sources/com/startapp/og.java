package com.startapp;

import android.webkit.WebView;
import java.lang.ref.WeakReference;

public class og extends WeakReference<WebView> {
    public og(WebView webView) {
        super(webView);
    }
}
