package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.a.h;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.ads.AudienceNetworkActivity;

public class d extends h {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static WebView f14042c;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final v f14043a;

    /* renamed from: b  reason: collision with root package name */
    private final m f14044b;

    /* renamed from: d  reason: collision with root package name */
    private com.applovin.impl.sdk.d.d f14045d;

    /* renamed from: e  reason: collision with root package name */
    private e f14046e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14047f;

    public d(e eVar, m mVar, Context context) {
        this(eVar, mVar, context, false);
    }

    d(e eVar, m mVar, Context context, boolean z2) {
        super(context);
        if (mVar != null) {
            this.f14044b = mVar;
            this.f14043a = mVar.A();
            setBackgroundColor(0);
            WebSettings settings = getSettings();
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptEnabled(true);
            setWebViewClient(eVar);
            setWebChromeClient(new c(eVar != null ? eVar.a() : null, mVar));
            setVerticalScrollBarEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setScrollBarStyle(33554432);
            if (g.i() && ((Boolean) mVar.a(b.eK)).booleanValue()) {
                setWebViewRenderProcessClient(new f(mVar).a());
            }
            setOnTouchListener(new View.OnTouchListener() {
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (view.hasFocus()) {
                        return false;
                    }
                    view.requestFocus();
                    return false;
                }
            });
            setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (!v.a()) {
                        return true;
                    }
                    d.this.f14043a.b("AdWebView", "Received a LongClick event.");
                    return true;
                }
            });
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    private String a(String str, String str2) {
        if (StringUtils.isValidString(str)) {
            return str.replace("{SOURCE}", str2);
        }
        return null;
    }

    public static void a(final i iVar, final m mVar, final AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                String a2 = i.this.a();
                d.c();
                if (d.f14042c == null) {
                    appLovinPostbackListener.onPostbackFailure(a2, -1);
                    return;
                }
                if (i.this.c() != null) {
                    a2 = StringUtils.appendQueryParameters(a2, i.this.c(), ((Boolean) mVar.a(b.df)).booleanValue());
                }
                String str = "al_firePostback('" + a2 + "');";
                if (g.c()) {
                    d.f14042c.evaluateJavascript(str, (ValueCallback) null);
                } else {
                    d.f14042c.loadUrl("javascript:" + str);
                }
                appLovinPostbackListener.onPostbackSuccess(a2);
            }
        });
    }

    private void a(String str, String str2, String str3, m mVar) {
        String a2 = a(str3, str);
        if (StringUtils.isValidString(a2)) {
            if (v.a()) {
                v vVar = this.f14043a;
                vVar.b("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a2);
            }
            loadDataWithBaseURL(str2, a2, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, (String) null, "");
            return;
        }
        String a3 = a((String) mVar.a(b.eg), str);
        if (StringUtils.isValidString(a3)) {
            if (v.a()) {
                v vVar2 = this.f14043a;
                vVar2.b("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a3);
            }
            loadDataWithBaseURL(str2, a3, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, (String) null, "");
            return;
        }
        if (v.a()) {
            v vVar3 = this.f14043a;
            vVar3.b("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        }
        loadUrl(str);
    }

    private void b(e eVar) {
        Boolean n2;
        Integer a2;
        loadUrl("about:blank");
        int az = this.f14046e.az();
        if (az >= 0) {
            setLayerType(az, (Paint) null);
        }
        if (g.b()) {
            getSettings().setMediaPlaybackRequiresUserGesture(eVar.av());
        }
        if (g.c() && eVar.ax()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        v ay = eVar.ay();
        if (ay != null) {
            WebSettings settings = getSettings();
            WebSettings.PluginState b2 = ay.b();
            if (b2 != null) {
                settings.setPluginState(b2);
            }
            Boolean c2 = ay.c();
            if (c2 != null) {
                settings.setAllowFileAccess(c2.booleanValue());
            }
            Boolean d2 = ay.d();
            if (d2 != null) {
                settings.setLoadWithOverviewMode(d2.booleanValue());
            }
            Boolean e2 = ay.e();
            if (e2 != null) {
                settings.setUseWideViewPort(e2.booleanValue());
            }
            Boolean f2 = ay.f();
            if (f2 != null) {
                settings.setAllowContentAccess(f2.booleanValue());
            }
            Boolean g2 = ay.g();
            if (g2 != null) {
                settings.setBuiltInZoomControls(g2.booleanValue());
            }
            Boolean h2 = ay.h();
            if (h2 != null) {
                settings.setDisplayZoomControls(h2.booleanValue());
            }
            Boolean i2 = ay.i();
            if (i2 != null) {
                settings.setSaveFormData(i2.booleanValue());
            }
            Boolean j2 = ay.j();
            if (j2 != null) {
                settings.setGeolocationEnabled(j2.booleanValue());
            }
            Boolean k2 = ay.k();
            if (k2 != null) {
                settings.setNeedInitialFocus(k2.booleanValue());
            }
            Boolean l2 = ay.l();
            if (l2 != null) {
                settings.setAllowFileAccessFromFileURLs(l2.booleanValue());
            }
            Boolean m2 = ay.m();
            if (m2 != null) {
                settings.setAllowUniversalAccessFromFileURLs(m2.booleanValue());
            }
            if (g.d() && (a2 = ay.a()) != null) {
                settings.setMixedContentMode(a2.intValue());
            }
            if (g.e() && (n2 = ay.n()) != null) {
                settings.setOffscreenPreRaster(n2.booleanValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void c() {
        if (f14042c == null) {
            WebView tryToCreateWebView = Utils.tryToCreateWebView(m.M(), "postbacks");
            f14042c = tryToCreateWebView;
            if (tryToCreateWebView != null) {
                tryToCreateWebView.getSettings().setJavaScriptEnabled(true);
                f14042c.loadData("<html><head>\n<script type=\"text/javascript\">\n    window.al_firePostback = function(postback) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = postback;\n    }, 100);\n};\n</script></head>\n<body></body></html>", AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "UTF-8");
                f14042c.setWebViewClient(new WebViewClient() {
                    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                        if (webView != d.f14042c) {
                            return true;
                        }
                        d.f14042c.destroy();
                        WebView unused = d.f14042c = null;
                        AppLovinSdkUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                d.c();
                            }
                        });
                        return true;
                    }
                });
            }
        }
    }

    public void a(e eVar) {
        v vVar;
        String str;
        v vVar2;
        String str2;
        String str3;
        String aw;
        String str4;
        String str5;
        String str6;
        String aw2;
        m mVar;
        if (!this.f14047f) {
            this.f14046e = eVar;
            try {
                b(eVar);
                if (Utils.isBML(eVar.getSize())) {
                    setVisibility(0);
                }
                if (eVar instanceof a) {
                    a aVar = (a) eVar;
                    String b2 = aVar.b();
                    if (aVar.isOpenMeasurementEnabled()) {
                        b2 = this.f14044b.al().a(b2);
                    }
                    loadDataWithBaseURL(eVar.aw(), b2, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, (String) null, "");
                    if (v.a()) {
                        vVar = this.f14043a;
                        str = "AppLovinAd rendered";
                    } else {
                        return;
                    }
                } else if (eVar instanceof com.applovin.impl.a.a) {
                    com.applovin.impl.a.a aVar2 = (com.applovin.impl.a.a) eVar;
                    com.applovin.impl.a.d aM = aVar2.aM();
                    if (aM != null) {
                        h b3 = aM.b();
                        Uri b4 = b3.b();
                        String uri = b4 != null ? b4.toString() : "";
                        String c2 = b3.c();
                        String aO = aVar2.aO();
                        if (!StringUtils.isValidString(uri)) {
                            if (!StringUtils.isValidString(c2)) {
                                if (v.a()) {
                                    vVar2 = this.f14043a;
                                    str2 = "Unable to load companion ad. No resources provided.";
                                    vVar2.e("AdWebView", str2);
                                    return;
                                }
                                return;
                            }
                        }
                        if (b3.a() == h.a.STATIC) {
                            if (v.a()) {
                                this.f14043a.b("AdWebView", "Rendering WebView for static VAST ad");
                            }
                            loadDataWithBaseURL(eVar.aw(), a((String) this.f14044b.a(b.ef), uri), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, (String) null, "");
                            return;
                        }
                        if (b3.a() == h.a.HTML) {
                            if (StringUtils.isValidString(c2)) {
                                String a2 = a(aO, c2);
                                str3 = StringUtils.isValidString(a2) ? a2 : c2;
                                if (v.a()) {
                                    v vVar3 = this.f14043a;
                                    vVar3.b("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + str3);
                                }
                                aw = eVar.aw();
                                str4 = AudienceNetworkActivity.WEBVIEW_MIME_TYPE;
                                str5 = null;
                                str6 = "";
                            } else if (StringUtils.isValidString(uri)) {
                                if (v.a()) {
                                    this.f14043a.b("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                }
                                aw2 = eVar.aw();
                                mVar = this.f14044b;
                                a(uri, aw2, aO, mVar);
                                return;
                            } else {
                                return;
                            }
                        } else if (b3.a() == h.a.IFRAME) {
                            if (StringUtils.isValidString(uri)) {
                                if (v.a()) {
                                    this.f14043a.b("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                                }
                                aw2 = eVar.aw();
                                mVar = this.f14044b;
                                a(uri, aw2, aO, mVar);
                                return;
                            } else if (StringUtils.isValidString(c2)) {
                                String a3 = a(aO, c2);
                                str3 = StringUtils.isValidString(a3) ? a3 : c2;
                                if (v.a()) {
                                    v vVar4 = this.f14043a;
                                    vVar4.b("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + str3);
                                }
                                aw = eVar.aw();
                                str4 = AudienceNetworkActivity.WEBVIEW_MIME_TYPE;
                                str5 = null;
                                str6 = "";
                            } else {
                                return;
                            }
                        } else if (v.a()) {
                            vVar2 = this.f14043a;
                            str2 = "Failed to render VAST companion ad of invalid type";
                            vVar2.e("AdWebView", str2);
                            return;
                        } else {
                            return;
                        }
                        loadDataWithBaseURL(aw, str3, str4, str5, str6);
                        return;
                    } else if (v.a()) {
                        vVar = this.f14043a;
                        str = "No companion ad provided.";
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                vVar.b("AdWebView", str);
            } catch (Throwable th) {
                String valueOf = eVar != null ? String.valueOf(eVar.getAdIdNumber()) : "null";
                throw new RuntimeException("Unable to render AppLovin ad (" + valueOf + ") - " + th);
            }
        } else if (v.a()) {
            v.i("AdWebView", "Ad can not be loaded in a destroyed webview");
        }
    }

    public void a(String str) {
        a(str, (Runnable) null);
    }

    public void a(String str, Runnable runnable) {
        try {
            if (v.a()) {
                v vVar = this.f14043a;
                vVar.b("AdWebView", "Forwarding \"" + str + "\" to ad template");
            }
            loadUrl(str);
        } catch (Throwable th) {
            if (v.a()) {
                this.f14043a.b("AdWebView", "Unable to forward to template", th);
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void computeScroll() {
    }

    public void destroy() {
        this.f14047f = true;
        super.destroy();
    }

    /* access modifiers changed from: package-private */
    public e getCurrentAd() {
        return this.f14046e;
    }

    public com.applovin.impl.sdk.d.d getStatsManagerHelper() {
        return this.f14045d;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
    }

    public void scrollTo(int i2, int i3) {
    }

    public void setStatsManagerHelper(com.applovin.impl.sdk.d.d dVar) {
        this.f14045d = dVar;
    }
}
