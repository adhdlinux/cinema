package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;

@TargetApi(29)
class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f14059a;

    /* renamed from: b  reason: collision with root package name */
    private final WebViewRenderProcessClient f14060b = new WebViewRenderProcessClient() {
        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            if (webView instanceof d) {
                e currentAd = ((d) webView).getCurrentAd();
                f.this.f14059a.ac().a(currentAd).a(b.D).a();
                if (v.a()) {
                    v A = f.this.f14059a.A();
                    A.e("AdWebViewRenderProcessClient", "WebView render process unresponsive for ad: " + currentAd);
                }
            }
        }
    };

    f(m mVar) {
        this.f14059a = mVar;
    }

    /* access modifiers changed from: package-private */
    public WebViewRenderProcessClient a() {
        return this.f14060b;
    }
}
