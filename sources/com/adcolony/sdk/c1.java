package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adcolony.sdk.b1;
import com.adcolony.sdk.e0;
import com.google.android.gms.common.internal.ImagesContract;
import com.iab.omid.library.adcolony.ScriptInjector;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;

public class c1 extends b1 implements k0 {
    /* access modifiers changed from: private */
    public String A = "";
    private i B;
    private boolean C = true;
    private f1 D = c0.q();
    /* access modifiers changed from: private */
    public boolean E;
    private boolean F;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f13041w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f13042x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public final Object f13043y = new Object();
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public e1 f13044z = c0.c();

    private class a {
        public a() {
        }

        @JavascriptInterface
        public final void dispatch_messages(String str, String str2) {
            if (Intrinsics.a(str2, c1.this.A)) {
                c1.this.N(str);
            }
        }

        @JavascriptInterface
        public final void enable_reverse_messaging(String str) {
            if (Intrinsics.a(str, c1.this.A)) {
                c1.this.f13041w = true;
            }
        }

        @JavascriptInterface
        public final String pull_messages(String str) {
            if (!Intrinsics.a(str, c1.this.A)) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            String str2 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            Object O = c1.this.f13043y;
            c1 c1Var = c1.this;
            synchronized (O) {
                if (c1Var.f13044z.e() > 0) {
                    if (c1Var.getEnableMessages()) {
                        str2 = c1Var.f13044z.toString();
                    }
                    c1Var.f13044z = c0.c();
                }
                Unit unit = Unit.f40298a;
            }
            return str2;
        }

        @JavascriptInterface
        public final void push_messages(String str, String str2) {
            if (Intrinsics.a(str2, c1.this.A)) {
                c1.this.N(str);
            }
        }
    }

    private final class b extends a {
        public b() {
            super();
        }

        @JavascriptInterface
        public final void enable_event_messaging(String str) {
            if (Intrinsics.a(str, c1.this.A)) {
                c1.this.f13042x = true;
            }
        }
    }

    protected class c extends b1.b {
        public c() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new l().a();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new l().c();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return new l().b(str);
        }
    }

    protected class d extends b1.c {
        public d() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new l().a();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new l().c();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return new l().b(str);
        }
    }

    protected class e extends b1.d {
        public e() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new j().a(str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new l().c();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return new l().b(str);
        }
    }

    protected class f extends b1.e {
        public f() {
            super(c1.this);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new j().a(str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new l().c();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return new k().a(webResourceRequest);
        }
    }

    protected class g extends b1.f {
        public g() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new j().a(str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new l().c();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return new k().a(webResourceRequest);
        }
    }

    public static final class h {
        private h() {
        }

        public /* synthetic */ h(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class i {

        /* renamed from: a  reason: collision with root package name */
        private final WebMessagePort[] f13052a;

        public i(WebMessagePort[] webMessagePortArr) {
            this.f13052a = webMessagePortArr;
        }

        public final WebMessagePort a() {
            return (WebMessagePort) ArraysKt___ArraysKt.z(this.f13052a, 1);
        }

        public final WebMessagePort b() {
            return (WebMessagePort) ArraysKt___ArraysKt.z(this.f13052a, 0);
        }
    }

    private final class j {
        public j() {
        }

        public final void a(String str) {
            new l().a();
            if (str != null) {
                c1.this.R(str);
            } else {
                new e0.a().c("ADCWebViewModule: initializeEventMessaging failed due to url = null").d(e0.f13112g);
            }
        }
    }

    private final class k {
        public k() {
        }

        public final boolean a(WebResourceRequest webResourceRequest) {
            boolean z2;
            Uri uri;
            int i2 = 0;
            if (c1.this.getModuleInitialized()) {
                if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    String y2 = c1.this.getClickOverride();
                    if (y2 == null) {
                        uri = null;
                    } else {
                        uri = Uri.parse(y2);
                    }
                    if (uri == null) {
                        uri = webResourceRequest.getUrl();
                    }
                    if (uri != null) {
                        z0.k(new Intent("android.intent.action.VIEW", uri));
                        f1 q2 = c0.q();
                        c1 c1Var = c1.this;
                        c0.n(q2, ImagesContract.URL, uri.toString());
                        c0.n(q2, "ad_session_id", c1Var.getAdSessionId());
                        c parentContainer = c1.this.getParentContainer();
                        if (parentContainer != null) {
                            i2 = parentContainer.I();
                        }
                        new h0("WebView.redirect_detected", i2, q2).e();
                        x0 a2 = a.f().a();
                        c1 c1Var2 = c1.this;
                        a2.b(c1Var2.getAdSessionId());
                        a2.h(c1Var2.getAdSessionId());
                    } else {
                        new e0.a().c(Intrinsics.o("shouldOverrideUrlLoading called with null request url, with ad id: ", c1.this.t())).d(e0.f13114i);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    private final class l {
        public l() {
        }

        public final void a() {
            if (c1.this.getEnableMessages() && !c1.this.getModuleInitialized()) {
                c1.this.A = z0.f();
                f1 h2 = c0.h(c0.q(), c1.this.getInfo());
                c0.n(h2, "message_key", c1.this.A);
                c1 c1Var = c1.this;
                c1Var.l("ADC3_init(" + c1.this.getAdcModuleId() + ',' + h2 + ");");
                c1.this.E = true;
            }
        }

        public final boolean b(String str) {
            int i2 = 0;
            if (!c1.this.getModuleInitialized()) {
                return false;
            }
            String y2 = c1.this.getClickOverride();
            if (y2 != null) {
                str = y2;
            }
            if (str != null) {
                z0.k(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                f1 q2 = c0.q();
                c1 c1Var = c1.this;
                c0.n(q2, ImagesContract.URL, str);
                c0.n(q2, "ad_session_id", c1Var.getAdSessionId());
                c parentContainer = c1.this.getParentContainer();
                if (parentContainer != null) {
                    i2 = parentContainer.I();
                }
                new h0("WebView.redirect_detected", i2, q2).e();
                x0 a2 = a.f().a();
                c1 c1Var2 = c1.this;
                a2.b(c1Var2.getAdSessionId());
                a2.h(c1Var2.getAdSessionId());
                return true;
            }
            new e0.a().c(Intrinsics.o("shouldOverrideUrlLoading called with null request url, with ad id: ", c1.this.t())).d(e0.f13114i);
            return true;
        }

        public final void c() {
            c1.this.E = false;
        }
    }

    public static final class m extends WebMessagePort.WebMessageCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c1 f13056a;

        m(c1 c1Var) {
            this.f13056a = c1Var;
        }

        public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            String a2;
            if (webMessage != null && (a2 = webMessage.getData()) != null) {
                c1 c1Var = this.f13056a;
                List<String> k2 = new Regex(":").k(a2, 2);
                if (k2.size() == 2 && Intrinsics.a(k2.get(0), c1Var.A)) {
                    c1Var.I(k2.get(1));
                }
            }
        }
    }

    static final class n implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c1 f13057b;

        n(c1 c1Var) {
            this.f13057b = c1Var;
        }

        public final void run() {
            this.f13057b.removeJavascriptInterface("NativeLayer");
        }
    }

    static final class o implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c1 f13058b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13059c;

        o(c1 c1Var, String str) {
            this.f13058b = c1Var;
            this.f13059c = str;
        }

        public final void run() {
            if (this.f13058b.getEnableMessages()) {
                c1 c1Var = this.f13058b;
                c1Var.l("NativeLayer.dispatch_messages(ADC3_update(" + this.f13059c + "), '" + this.f13058b.A + "');");
            }
        }
    }

    static {
        new h((DefaultConstructorMarker) null);
    }

    public c1(Context context, int i2, h0 h0Var) {
        super(context, i2, h0Var);
    }

    private final void G(f1 f1Var) {
        a.f().F0().r(f1Var);
    }

    /* access modifiers changed from: private */
    public final void I(String str) {
        G(c0.r(str));
    }

    /* access modifiers changed from: private */
    public final void N(String str) {
        for (f1 G : c0.e(str).i()) {
            G(G);
        }
    }

    /* access modifiers changed from: private */
    public final void R(String str) {
        if (this.B == null) {
            i iVar = new i(createWebMessageChannel());
            WebMessagePort b2 = iVar.b();
            if (b2 != null) {
                b2.setWebMessageCallback(new m(this));
            }
            postWebMessage(new WebMessage("", new WebMessagePort[]{iVar.a()}), Uri.parse(str));
            Unit unit = Unit.f40298a;
            this.B = iVar;
        }
    }

    private final void S(f1 f1Var) {
        WebMessagePort webMessagePort;
        if (this.C) {
            i iVar = this.B;
            if (iVar == null || (webMessagePort = iVar.b()) == null) {
                webMessagePort = null;
            } else {
                e1 c2 = c0.c();
                c2.a(f1Var);
                webMessagePort.postMessage(new WebMessage(c2.toString()));
            }
            if (webMessagePort == null) {
                new e0.a().c("Sending message before event messaging is initialized").d(e0.f13112g);
            }
        }
    }

    private final a T() {
        if (Build.VERSION.SDK_INT >= 23) {
            return new b();
        }
        return new a();
    }

    private final void V() {
        String str = "";
        synchronized (this.f13043y) {
            if (this.f13044z.e() > 0) {
                if (getEnableMessages()) {
                    str = this.f13044z.toString();
                }
                this.f13044z = c0.c();
            }
            Unit unit = Unit.f40298a;
        }
        z0.A(new o(this, str));
    }

    /* access modifiers changed from: private */
    public final String getClickOverride() {
        AdColonyInterstitial interstitial = getInterstitial();
        String n2 = interstitial == null ? null : interstitial.n();
        if (n2 != null) {
            return n2;
        }
        AdColonyAdView adView = getAdView();
        if (adView == null) {
            return null;
        }
        return adView.getClickOverride();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void H(Exception exc) {
        new e0.a().c(exc.getClass().toString()).c(" during metadata injection w/ metadata = ").c(c0.E(getInfo(), "metadata")).d(e0.f13114i);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ String K(f1 f1Var) {
        return c0.E(f1Var, "filepath");
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ String P(f1 f1Var) {
        return Intrinsics.o("file:///", K(f1Var));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean U() {
        return this.F;
    }

    public void a(f1 f1Var) {
        synchronized (this.f13043y) {
            if (this.f13042x) {
                S(f1Var);
                Unit unit = Unit.f40298a;
            } else {
                this.f13044z.a(f1Var);
            }
        }
    }

    public void b() {
        if (a.h() && this.E && !this.f13041w && !this.f13042x) {
            V();
        }
    }

    public void c() {
        if (!getDestroyed()) {
            x();
            z0.A(new n(this));
        }
    }

    public int getAdcModuleId() {
        return getAdc3ModuleId();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean getEnableMessages() {
        return this.C;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ f1 getIab() {
        return this.D;
    }

    /* renamed from: getModuleId */
    public int getAdc3ModuleId() {
        return getWebViewModuleId();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean getModuleInitialized() {
        return this.E;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi21() {
        return new d();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi23() {
        return new e();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi24() {
        return new f();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi26() {
        return new g();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientDefault() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void i(h0 h0Var, int i2, c cVar) {
        f1 a2 = h0Var.a();
        this.C = c0.t(a2, "enable_messages");
        if (this.D.q()) {
            this.D = c0.C(a2, "iab");
        }
        super.i(h0Var, i2, cVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setEnableMessages(boolean z2) {
        this.C = z2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setIab(f1 f1Var) {
        this.D = f1Var;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"AddJavascriptInterface"})
    public /* synthetic */ void u() {
        addJavascriptInterface(T(), "NativeLayer");
        a.f().F0().c(this);
        super.u();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String z(String str, String str2) {
        p0 p0Var;
        if (!this.D.q()) {
            AdColonyInterstitial interstitial = getInterstitial();
            p0 p0Var2 = null;
            if (interstitial != null && !Intrinsics.a(c0.E(getIab(), "ad_type"), MimeTypes.BASE_TYPE_VIDEO)) {
                interstitial.f(getIab());
                p0Var = interstitial.s();
            } else {
                p0Var = null;
            }
            if (p0Var == null) {
                AdColonyAdViewListener adColonyAdViewListener = a.f().T().w().get(getAdSessionId());
                if (adColonyAdViewListener != null) {
                    adColonyAdViewListener.b(new p0(getIab(), getAdSessionId()));
                    p0Var2 = adColonyAdViewListener.f12846b;
                }
            } else {
                p0Var2 = p0Var;
            }
            if (p0Var2 != null && p0Var2.o() == 2) {
                boolean z2 = true;
                this.F = true;
                if (str2.length() <= 0) {
                    z2 = false;
                }
                if (z2) {
                    try {
                        return ScriptInjector.a(a.f().B0().a(str2, false).toString(), str);
                    } catch (IOException e2) {
                        H(e2);
                    }
                }
            }
        }
        return str;
    }

    public boolean a() {
        return !this.f13041w && !this.f13042x;
    }
}
