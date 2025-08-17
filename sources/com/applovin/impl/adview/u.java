package com.applovin.impl.adview;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import java.lang.ref.WeakReference;

public class u extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private final v f14136a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<a> f14137b;

    public interface a {
        void a(t tVar);

        void b(t tVar);

        void c(t tVar);
    }

    public u(m mVar) {
        this.f14136a = mVar.A();
    }

    private void a(WebView webView, String str) {
        if (v.a()) {
            v vVar = this.f14136a;
            vVar.c("WebViewButtonClient", "Processing click on ad URL \"" + str + "\"");
        }
        if (str != null && (webView instanceof t)) {
            t tVar = (t) webView;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            a aVar = this.f14137b.get();
            if ("applovin".equalsIgnoreCase(scheme) && "com.applovin.sdk".equalsIgnoreCase(host) && aVar != null) {
                if ("/track_click".equals(path)) {
                    aVar.a(tVar);
                } else if ("/close_ad".equals(path)) {
                    aVar.b(tVar);
                } else if ("/skip_ad".equals(path)) {
                    aVar.c(tVar);
                } else if (v.a()) {
                    v vVar2 = this.f14136a;
                    vVar2.d("WebViewButtonClient", "Unknown URL: " + str);
                    v vVar3 = this.f14136a;
                    vVar3.d("WebViewButtonClient", "Path: " + path);
                }
            }
        }
    }

    public void a(WeakReference<a> weakReference) {
        this.f14137b = weakReference;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a(webView, str);
        return true;
    }
}
