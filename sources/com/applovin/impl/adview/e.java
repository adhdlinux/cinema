package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.a.d;
import com.applovin.impl.a.l;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.a;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinWebViewActivity;

public class e extends WebViewClient {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f14054a;

    /* renamed from: b  reason: collision with root package name */
    private final v f14055b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final b f14056c;

    public e(b bVar, m mVar) {
        this.f14054a = mVar;
        this.f14055b = mVar.A();
        this.f14056c = bVar;
    }

    private void a(PointF pointF) {
        this.f14056c.a(pointF);
    }

    private void a(Uri uri, d dVar) {
        String str;
        v vVar;
        final String queryParameter = uri.getQueryParameter("n");
        if (StringUtils.isValidString(queryParameter)) {
            String queryParameter2 = uri.getQueryParameter("load_type");
            if ("external".equalsIgnoreCase(queryParameter2)) {
                if (v.a()) {
                    v vVar2 = this.f14055b;
                    vVar2.b("AdWebView", "Loading new page externally: " + queryParameter);
                }
                Utils.openUri(dVar.getContext(), Uri.parse(queryParameter), this.f14054a);
                j.c(this.f14056c.g(), (AppLovinAd) this.f14056c.p(), this.f14056c.r());
                return;
            } else if ("internal".equalsIgnoreCase(queryParameter2)) {
                if (v.a()) {
                    v vVar3 = this.f14055b;
                    vVar3.b("AdWebView", "Loading new page in WebView: " + queryParameter);
                }
                dVar.loadUrl(queryParameter);
                String queryParameter3 = uri.getQueryParameter("bg_color");
                if (StringUtils.isValidString(queryParameter3)) {
                    dVar.setBackgroundColor(Color.parseColor(queryParameter3));
                    return;
                }
                return;
            } else if ("in_app".equalsIgnoreCase(queryParameter2)) {
                if (v.a()) {
                    v vVar4 = this.f14055b;
                    vVar4.b("AdWebView", "Loading new page in slide-up webview: " + queryParameter);
                }
                this.f14054a.af().a(new a() {
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            ((AppLovinWebViewActivity) activity).loadUrl(queryParameter, (AppLovinWebViewActivity.EventListener) null);
                            j.a(e.this.f14056c.g(), (AppLovinAd) e.this.f14056c.p(), e.this.f14056c.r());
                        }
                    }

                    public void onActivityDestroyed(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            j.b(e.this.f14056c.g(), (AppLovinAd) e.this.f14056c.p(), e.this.f14056c.r());
                            e.this.f14054a.af().b(this);
                        }
                    }
                });
                Intent intent = new Intent(this.f14054a.L(), AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f14054a.z());
                intent.setFlags(268435456);
                this.f14054a.L().startActivity(intent);
                return;
            } else if (v.a()) {
                vVar = this.f14055b;
                str = "Could not find load type in original uri";
            } else {
                return;
            }
        } else if (v.a()) {
            vVar = this.f14055b;
            str = "Could not find url to load from query in original uri";
        } else {
            return;
        }
        vVar.e("AdWebView", str);
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.e eVar) {
        String queryParameter = uri.getQueryParameter("n");
        if (URLUtil.isValidUrl(queryParameter)) {
            String appendQueryParameter = StringUtils.appendQueryParameter(queryParameter, "clcode", eVar.getClCode());
            this.f14054a.U().a(h.o().c(appendQueryParameter).a(false).c(Boolean.parseBoolean(uri.getQueryParameter("fire_from_webview"))).a());
        } else if (v.a()) {
            v vVar = this.f14055b;
            vVar.e("AdWebView", "Could not find postback url to fire from query in original uri: " + uri);
        }
    }

    private void a(com.applovin.impl.a.a aVar, d dVar) {
        d aM = aVar.aM();
        if (aM != null) {
            l.a(aM.c(), this.f14056c.q());
            a(dVar, aM.a());
        }
    }

    private void a(d dVar, Uri uri) {
        com.applovin.impl.sdk.ad.e currentAd = dVar.getCurrentAd();
        AppLovinAdView r2 = this.f14056c.r();
        if (r2 != null && currentAd != null) {
            com.applovin.impl.sdk.d.d statsManagerHelper = dVar.getStatsManagerHelper();
            if (statsManagerHelper != null) {
                statsManagerHelper.b();
            }
            if (currentAd instanceof com.applovin.impl.a.a) {
                ((com.applovin.impl.a.a) currentAd).o().o();
            }
            this.f14056c.a(currentAd, r2, uri, dVar.getAndClearLastClickLocation());
        } else if (v.a()) {
            v vVar = this.f14055b;
            vVar.e("AdWebView", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
        }
    }

    private void b() {
        this.f14056c.l();
    }

    private void c() {
        this.f14056c.k();
    }

    /* access modifiers changed from: protected */
    public b a() {
        return this.f14056c;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0252, code lost:
        if (r6.aN() != false) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0152, code lost:
        if (r6.aN() != false) goto L_0x0125;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.webkit.WebView r11, java.lang.String r12, boolean r13) {
        /*
            r10 = this;
            com.applovin.impl.adview.b r0 = r10.f14056c
            r1 = 1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = com.applovin.impl.sdk.v.a()
            java.lang.String r2 = "AdWebView"
            if (r0 == 0) goto L_0x0029
            com.applovin.impl.sdk.v r0 = r10.f14055b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Processing click on ad URL \""
            r3.append(r4)
            r3.append(r12)
            java.lang.String r4 = "\""
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.c(r2, r3)
        L_0x0029:
            if (r12 == 0) goto L_0x0257
            boolean r0 = r11 instanceof com.applovin.impl.adview.d
            if (r0 == 0) goto L_0x0257
            android.net.Uri r0 = android.net.Uri.parse(r12)
            com.applovin.impl.adview.d r11 = (com.applovin.impl.adview.d) r11
            java.lang.String r3 = r0.getScheme()
            java.lang.String r4 = r0.getHost()
            java.lang.String r5 = r0.getPath()
            com.applovin.impl.adview.b r6 = r10.f14056c
            com.applovin.impl.sdk.ad.e r6 = r6.p()
            if (r6 != 0) goto L_0x0057
            boolean r11 = com.applovin.impl.sdk.v.a()
            if (r11 == 0) goto L_0x0056
            com.applovin.impl.sdk.v r11 = r10.f14055b
            java.lang.String r12 = "Unable to process click, ad not found!"
            r11.e(r2, r12)
        L_0x0056:
            return r1
        L_0x0057:
            android.graphics.PointF r7 = r11.getLastClickLocation()
            android.graphics.PointF r8 = new android.graphics.PointF
            r8.<init>()
            boolean r7 = r7.equals(r8)
            r7 = r7 ^ r1
            boolean r8 = r6.J()
            r9 = 0
            if (r8 == 0) goto L_0x0070
            if (r7 == 0) goto L_0x0070
            r13 = 1
            goto L_0x0079
        L_0x0070:
            boolean r8 = r6.K()
            if (r8 == 0) goto L_0x0079
            if (r7 != 0) goto L_0x0079
            r13 = 0
        L_0x0079:
            java.lang.String r8 = "applovin"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0217
            java.lang.String r8 = "com.applovin.sdk"
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x0217
            java.lang.String r13 = "/adservice/close_ad"
            boolean r13 = r13.equals(r5)
            if (r13 == 0) goto L_0x00b9
            com.applovin.impl.sdk.m r11 = r10.f14054a
            com.applovin.sdk.AppLovinSdkSettings r11 = r11.p()
            java.util.Map r11 = r11.getExtraParameters()
            java.lang.String r13 = "enable_close_url_ad_value"
            java.lang.Object r11 = r11.get(r13)
            java.lang.String r11 = (java.lang.String) r11
            boolean r13 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r11)
            if (r13 == 0) goto L_0x00b4
            boolean r11 = java.lang.Boolean.parseBoolean(r11)
            if (r11 == 0) goto L_0x00b4
            java.lang.String r11 = "close_url"
            r6.setMaxAdValue(r11, r12)
        L_0x00b4:
            r10.b()
            goto L_0x0257
        L_0x00b9:
            java.lang.String r13 = "/adservice/expand_ad"
            boolean r13 = r13.equals(r5)
            if (r13 == 0) goto L_0x00da
            boolean r12 = r6.I()
            if (r12 == 0) goto L_0x00d1
            if (r7 != 0) goto L_0x00d1
            com.applovin.impl.sdk.v r11 = r10.f14055b
            java.lang.String r12 = "Skipping expand command without user interaction"
        L_0x00cd:
            r11.e(r2, r12)
            return r9
        L_0x00d1:
            android.graphics.PointF r11 = r11.getAndClearLastClickLocation()
            r10.a((android.graphics.PointF) r11)
            goto L_0x0257
        L_0x00da:
            java.lang.String r13 = "/adservice/contract_ad"
            boolean r13 = r13.equals(r5)
            if (r13 == 0) goto L_0x00e7
            r10.c()
            goto L_0x0257
        L_0x00e7:
            java.lang.String r13 = "/adservice/no_op"
            boolean r13 = r13.equals(r5)
            if (r13 == 0) goto L_0x00f0
            return r1
        L_0x00f0:
            java.lang.String r13 = "/adservice/load_url"
            boolean r13 = r13.equals(r5)
            if (r13 == 0) goto L_0x010a
            boolean r12 = r6.I()
            if (r12 == 0) goto L_0x0105
            if (r7 != 0) goto L_0x0105
            com.applovin.impl.sdk.v r11 = r10.f14055b
            java.lang.String r12 = "Skipping URL load command without user interaction"
            goto L_0x00cd
        L_0x0105:
            r10.a((android.net.Uri) r0, (com.applovin.impl.adview.d) r11)
            goto L_0x0257
        L_0x010a:
            java.lang.String r13 = "/adservice/track_click_now"
            boolean r3 = r13.equals(r5)
            if (r3 == 0) goto L_0x0133
            boolean r12 = r6.I()
            if (r12 == 0) goto L_0x011f
            if (r7 != 0) goto L_0x011f
            com.applovin.impl.sdk.v r11 = r10.f14055b
            java.lang.String r12 = "Skipping click tracking command without user interaction"
            goto L_0x00cd
        L_0x011f:
            boolean r12 = r6 instanceof com.applovin.impl.a.a
            if (r12 == 0) goto L_0x012a
            com.applovin.impl.a.a r6 = (com.applovin.impl.a.a) r6
        L_0x0125:
            r10.a((com.applovin.impl.a.a) r6, (com.applovin.impl.adview.d) r11)
            goto L_0x0257
        L_0x012a:
            android.net.Uri r12 = android.net.Uri.parse(r13)
            r10.a((com.applovin.impl.adview.d) r11, (android.net.Uri) r12)
            goto L_0x0257
        L_0x0133:
            java.lang.String r13 = "/adservice/deeplink"
            boolean r13 = r13.equals(r5)
            if (r13 == 0) goto L_0x015a
            boolean r12 = r6.I()
            if (r12 == 0) goto L_0x0148
            if (r7 != 0) goto L_0x0148
            com.applovin.impl.sdk.v r11 = r10.f14055b
            java.lang.String r12 = "Skipping deep link plus command without user interaction"
            goto L_0x00cd
        L_0x0148:
            boolean r12 = r6 instanceof com.applovin.impl.a.a
            if (r12 == 0) goto L_0x0155
            com.applovin.impl.a.a r6 = (com.applovin.impl.a.a) r6
            boolean r12 = r6.aN()
            if (r12 == 0) goto L_0x0155
        L_0x0154:
            goto L_0x0125
        L_0x0155:
            r10.a((com.applovin.impl.adview.d) r11, (android.net.Uri) r0)
            goto L_0x0257
        L_0x015a:
            java.lang.String r11 = "/adservice/postback"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0167
            r10.a((android.net.Uri) r0, (com.applovin.impl.sdk.ad.e) r6)
            goto L_0x0257
        L_0x0167:
            com.applovin.impl.adview.b r11 = r10.f14056c
            com.applovin.impl.adview.g r11 = r11.h()
            if (r11 == 0) goto L_0x01e4
            java.lang.String r11 = "/video_began"
            boolean r11 = r11.equals(r5)
            r12 = 0
            if (r11 == 0) goto L_0x018e
            java.lang.String r11 = "duration"
            java.lang.String r11 = r0.getQueryParameter(r11)
            double r11 = com.applovin.impl.sdk.utils.Utils.tryParseDouble(r11, r12)
            com.applovin.impl.adview.b r13 = r10.f14056c
            com.applovin.impl.adview.g r13 = r13.h()
            r13.a(r11)
            goto L_0x0257
        L_0x018e:
            java.lang.String r11 = "/video_completed"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x01a1
            com.applovin.impl.adview.b r11 = r10.f14056c
            com.applovin.impl.adview.g r11 = r11.h()
            r11.a_()
            goto L_0x0257
        L_0x01a1:
            java.lang.String r11 = "/video_progress"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x01be
            java.lang.String r11 = "percent_viewed"
            java.lang.String r11 = r0.getQueryParameter(r11)
            double r11 = com.applovin.impl.sdk.utils.Utils.tryParseDouble(r11, r12)
            com.applovin.impl.adview.b r13 = r10.f14056c
            com.applovin.impl.adview.g r13 = r13.h()
            r13.b(r11)
            goto L_0x0257
        L_0x01be:
            java.lang.String r11 = "/video_waiting"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x01d1
            com.applovin.impl.adview.b r11 = r10.f14056c
            com.applovin.impl.adview.g r11 = r11.h()
            r11.b_()
            goto L_0x0257
        L_0x01d1:
            java.lang.String r11 = "/video_resumed"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0257
            com.applovin.impl.adview.b r11 = r10.f14056c
            com.applovin.impl.adview.g r11 = r11.h()
            r11.c()
            goto L_0x0257
        L_0x01e4:
            boolean r11 = com.applovin.impl.sdk.v.a()
            if (r11 == 0) goto L_0x0257
            com.applovin.impl.sdk.v r11 = r10.f14055b
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Unknown URL: "
            r13.append(r0)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r11.d(r2, r12)
            com.applovin.impl.sdk.v r11 = r10.f14055b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Path: "
            r12.append(r13)
            r12.append(r5)
            java.lang.String r12 = r12.toString()
            r11.d(r2, r12)
            goto L_0x0257
        L_0x0217:
            if (r13 == 0) goto L_0x0256
            java.util.List r12 = r6.aA()
            java.util.List r13 = r6.aB()
            boolean r5 = r12.isEmpty()
            if (r5 != 0) goto L_0x022d
            boolean r12 = r12.contains(r3)
            if (r12 == 0) goto L_0x023a
        L_0x022d:
            boolean r12 = r13.isEmpty()
            if (r12 != 0) goto L_0x0248
            boolean r12 = r13.contains(r4)
            if (r12 == 0) goto L_0x023a
            goto L_0x0248
        L_0x023a:
            boolean r11 = com.applovin.impl.sdk.v.a()
            if (r11 == 0) goto L_0x0257
            com.applovin.impl.sdk.v r11 = r10.f14055b
            java.lang.String r12 = "URL is not whitelisted - bypassing click"
            r11.e(r2, r12)
            goto L_0x0257
        L_0x0248:
            boolean r12 = r6 instanceof com.applovin.impl.a.a
            if (r12 == 0) goto L_0x0155
            com.applovin.impl.a.a r6 = (com.applovin.impl.a.a) r6
            boolean r12 = r6.aN()
            if (r12 == 0) goto L_0x0155
            goto L_0x0154
        L_0x0256:
            return r9
        L_0x0257:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.e.a(android.webkit.WebView, java.lang.String, boolean):boolean");
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        if (v.a()) {
            v vVar = this.f14055b;
            vVar.c("AdWebView", "Loaded resource: " + str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        b bVar = this.f14056c;
        if (bVar != null) {
            bVar.a(webView);
        }
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        b bVar = this.f14056c;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e p2 = bVar.p();
            String str3 = "Received error with error code: " + i2 + " with description \\'" + str + "\\' for URL: " + str2;
            if (p2 != null) {
                this.f14054a.ac().a(p2).a(b.f15282z, str3).a();
            }
            if (v.a()) {
                this.f14055b.e("AdWebView", str3 + " for ad: " + p2);
            }
        }
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        b bVar = this.f14056c;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e p2 = bVar.p();
            this.f14054a.ac().a(p2).a(b.A).a();
            if (v.a()) {
                v vVar = this.f14055b;
                vVar.e("AdWebView", "Received HTTP error: " + webResourceResponse + "for url: " + webResourceRequest.getUrl() + " and ad: " + p2);
            }
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        b bVar = this.f14056c;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e p2 = bVar.p();
            String str = "Received SSL error: " + sslError;
            this.f14054a.ac().a(p2).a(b.C, str).a();
            if (v.a()) {
                this.f14055b.e("AdWebView", str + " for ad: " + p2);
            }
        }
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (this.f14056c == null) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (v.a()) {
            v.i("AdWebView", "Render process gone for ad: " + this.f14056c.p() + ". Process did crash: " + renderProcessGoneDetail.didCrash());
        }
        com.applovin.impl.sdk.ad.e p2 = this.f14056c.p();
        if (p2 != null) {
            this.f14054a.ac().a(p2).a(b.B).a();
        }
        if (!((Boolean) this.f14054a.a(com.applovin.impl.sdk.c.b.eF)).booleanValue()) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (renderProcessGoneDetail.didCrash() && ((Boolean) this.f14054a.a(com.applovin.impl.sdk.c.b.eH)).booleanValue()) {
            String valueOf = p2 != null ? String.valueOf(p2.getAdIdNumber()) : "null";
            throw new RuntimeException("Render process crashed. This is likely caused by a crash in an AppLovin ad with ID: " + valueOf);
        } else if (webView == null || !webView.equals(this.f14056c.s())) {
            return true;
        } else {
            this.f14056c.f();
            AppLovinAdSize b2 = this.f14056c.b();
            if (!Utils.isBML(b2)) {
                return true;
            }
            this.f14056c.a(b2);
            this.f14056c.e();
            return true;
        }
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean hasGesture = ((Boolean) this.f14054a.a(com.applovin.impl.sdk.c.b.bE)).booleanValue() ? webResourceRequest.hasGesture() : true;
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return a(webView, url.toString(), hasGesture);
        }
        if (!v.a()) {
            return false;
        }
        this.f14055b.e("AdWebView", "No url found for request");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return a(webView, str, true);
    }
}
