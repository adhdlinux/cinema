package com.adcolony.sdk;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adcolony.sdk.c1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public class j extends c1 {
    public static final f G = new f((DefaultConstructorMarker) null);

    protected class a extends c1.c {
        public a() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new g().a();
        }
    }

    protected class b extends c1.d {
        public b() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new g().a();
        }
    }

    protected class c extends c1.e {
        public c() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new g().a();
        }
    }

    protected class d extends c1.f {
        public d() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new g().a();
        }
    }

    protected class e extends c1.g {
        public e() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new g().a();
        }
    }

    public static final class f {
        private f() {
        }

        public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j a(Context context, h0 h0Var) {
            j jVar;
            int t2 = a.f().F0().t();
            if (Intrinsics.a(c0.E(h0Var.a(), "type"), "aurora")) {
                jVar = new e(context, t2, h0Var);
            } else {
                jVar = new j(context, t2, h0Var);
            }
            jVar.u();
            return jVar;
        }
    }

    private final class g {
        public g() {
        }

        public final void a() {
            h0 b2;
            if (!(j.this instanceof l)) {
                f1 q2 = c0.q();
                j jVar = j.this;
                c0.w(q2, "success", true);
                c0.u(q2, "id", jVar.getAdc3ModuleId());
                h0 message = j.this.getMessage();
                if (message != null && (b2 = message.b(q2)) != null) {
                    b2.e();
                }
            }
        }
    }

    protected j(Context context, int i2, h0 h0Var) {
        super(context, i2, h0Var);
    }

    public static final j W(Context context, h0 h0Var) {
        return G.a(context, h0Var);
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
    public /* synthetic */ void setBounds(h0 h0Var) {
        super.setBounds(h0Var);
        f1 q2 = c0.q();
        c0.w(q2, "success", true);
        c0.u(q2, "id", getAdc3ModuleId());
        h0Var.b(q2).e();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void setVisible(h0 h0Var) {
        super.setVisible(h0Var);
        f1 q2 = c0.q();
        c0.w(q2, "success", true);
        c0.u(q2, "id", getAdc3ModuleId());
        h0Var.b(q2).e();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void u() {
        f1 f1Var;
        h0 message = getMessage();
        if (message == null) {
            f1Var = null;
        } else {
            f1Var = message.a();
        }
        if (f1Var == null) {
            f1Var = c0.q();
        }
        setMraidFilepath(c0.E(f1Var, "mraid_filepath"));
        setBaseUrl(c0.E(f1Var, "base_url"));
        setIab(c0.C(f1Var, "iab"));
        setInfo(c0.C(f1Var, "info"));
        setAdSessionId(c0.E(f1Var, "ad_session_id"));
        setMUrl(P(f1Var));
        super.u();
    }
}
