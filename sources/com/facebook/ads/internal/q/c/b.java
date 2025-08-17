package com.facebook.ads.internal.q.c;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.webkit.WebView;
import com.facebook.ads.internal.settings.AdInternalSettings;

public class b {
    public static String a() {
        String urlPrefix = AdInternalSettings.getUrlPrefix();
        if (TextUtils.isEmpty(urlPrefix)) {
            return "https://www.facebook.com/";
        }
        return String.format("https://www.%s.facebook.com", new Object[]{urlPrefix});
    }

    public static void a(WebView webView) {
        webView.loadUrl("about:blank");
        webView.clearCache(true);
    }

    @TargetApi(21)
    public static void b(WebView webView) {
        webView.getSettings().setMixedContentMode(0);
    }
}
