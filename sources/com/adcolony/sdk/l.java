package com.adcolony.sdk;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.j;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class l extends j {
    public static final f H = new f((DefaultConstructorMarker) null);
    public static boolean I;

    private final class a extends j.a {
        public a() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new g().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class b extends j.b {
        public b() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new g().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class c extends j.c {
        public c() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new g().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class d extends j.d {
        public d() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new g().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class e extends j.e {
        public e() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new g().a();
            super.onPageFinished(webView, str);
        }
    }

    public static final class f {
        private f() {
        }

        public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final l a(Context context, h0 h0Var) {
            l lVar = new l(context, h0Var, (DefaultConstructorMarker) null);
            lVar.u();
            return lVar;
        }
    }

    private final class g {
        public g() {
        }

        public final void a() {
            if (!l.this.getModuleInitialized()) {
                e1 e1Var = new e1();
                for (AdColonyInterstitial adColonyInterstitial : a.f().T().D()) {
                    f1 f1Var = new f1();
                    c0.n(f1Var, "ad_session_id", adColonyInterstitial.j());
                    c0.n(f1Var, "ad_id", adColonyInterstitial.b());
                    c0.n(f1Var, "zone_id", adColonyInterstitial.x());
                    c0.n(f1Var, "ad_request_id", adColonyInterstitial.v());
                    e1Var.a(f1Var);
                }
                c0.l(l.this.getInfo(), "ads_to_restore", e1Var);
            }
        }
    }

    private l(Context context, h0 h0Var) {
        super(context, 1, h0Var);
    }

    public /* synthetic */ l(Context context, h0 h0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, h0Var);
    }

    public static final l X(Context context, h0 h0Var) {
        return H.a(context, h0Var);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ String K(f1 f1Var) {
        if (I) {
            return "android_asset/ADCController.js";
        }
        return super.K(f1Var);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi21() {
        return new b();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi23() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi24() {
        return new d();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi26() {
        return new e();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientDefault() {
        return new a();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ boolean m(f1 f1Var, String str) {
        if (super.m(f1Var, str)) {
            return true;
        }
        new e0.a().c("Unable to communicate with controller, disabling AdColony.").d(e0.f13113h);
        AdColony.f();
        return true;
    }
}
