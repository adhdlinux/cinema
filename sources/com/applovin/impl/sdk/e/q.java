package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.webkit.WebView;
import com.applovin.impl.adview.b;
import com.applovin.impl.adview.d;
import com.applovin.impl.adview.e;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.ads.AudienceNetworkActivity;
import org.json.JSONObject;

public class q extends a implements h.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final com.applovin.impl.sdk.ad.a f15420a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AppLovinAdLoadListener f15421c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public d f15422d;

    private class a extends e {
        private a(m mVar) {
            super((b) null, mVar);
        }

        private boolean a(String str, com.applovin.impl.sdk.c.b<String> bVar) {
            for (String equalsIgnoreCase : q.this.f15333b.b(bVar)) {
                if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public boolean a(WebView webView, String str, boolean z2) {
            if (v.a()) {
                q qVar = q.this;
                qVar.b("Processing click on ad URL \"" + str + "\"");
            }
            if (str == null || !(webView instanceof d)) {
                return true;
            }
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (!a(scheme, com.applovin.impl.sdk.c.b.ca)) {
                return true;
            }
            if (a(host, com.applovin.impl.sdk.c.b.cb)) {
                if (v.a()) {
                    q.this.a("Ad load succeeded");
                }
                if (q.this.f15421c == null) {
                    return true;
                }
                q.this.f15421c.adReceived(q.this.f15420a);
            } else if (a(host, com.applovin.impl.sdk.c.b.cc)) {
                if (v.a()) {
                    q.this.a("Ad load failed");
                }
                if (q.this.f15421c == null) {
                    return true;
                }
                q.this.f15421c.failedToReceiveAd(204);
            } else if (!v.a()) {
                return true;
            } else {
                q.this.d("Unrecognized webview event");
                return true;
            }
            AppLovinAdLoadListener unused = q.this.f15421c = null;
            return true;
        }
    }

    public q(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskProcessJavaScriptTagAd", mVar);
        this.f15420a = new com.applovin.impl.sdk.ad.a(jSONObject, jSONObject2, bVar, mVar);
        this.f15421c = appLovinAdLoadListener;
        mVar.H().a((h.a) this);
    }

    public void a(com.applovin.impl.mediation.a.a aVar) {
        if (aVar.f().equalsIgnoreCase(this.f15420a.N())) {
            this.f15333b.H().b(this);
            AppLovinAdLoadListener appLovinAdLoadListener = this.f15421c;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f15420a);
                this.f15421c = null;
            }
        }
    }

    public void run() {
        if (v.a()) {
            a("Rendering AppLovin ad #" + this.f15420a.getAdIdNumber());
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    q qVar = q.this;
                    q qVar2 = q.this;
                    a aVar = new a(qVar2.f15333b);
                    q qVar3 = q.this;
                    d unused = qVar.f15422d = new d(aVar, qVar3.f15333b, qVar3.f());
                    q.this.f15422d.loadDataWithBaseURL(q.this.f15420a.aw(), q.this.f15420a.b(), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, (String) null, "");
                } catch (Throwable th) {
                    q.this.f15333b.H().b(q.this);
                    if (v.a()) {
                        q.this.a("Failed to initialize WebView", th);
                    }
                    if (q.this.f15421c != null) {
                        q.this.f15421c.failedToReceiveAd(-1);
                        AppLovinAdLoadListener unused2 = q.this.f15421c = null;
                    }
                }
            }
        });
    }
}
