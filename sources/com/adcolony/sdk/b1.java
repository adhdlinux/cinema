package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.adcolony.sdk.e0;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.common.util.UriUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

public class b1 extends WebView {

    /* renamed from: v  reason: collision with root package name */
    public static final g f12961v = new g((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final int f12962b;

    /* renamed from: c  reason: collision with root package name */
    private final h0 f12963c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f12964d;

    /* renamed from: e  reason: collision with root package name */
    private String f12965e = "";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f12966f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f12967g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f12968h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f12969i = "";

    /* renamed from: j  reason: collision with root package name */
    private String f12970j = "";

    /* renamed from: k  reason: collision with root package name */
    private f1 f12971k = c0.q();

    /* renamed from: l  reason: collision with root package name */
    private boolean f12972l;

    /* renamed from: m  reason: collision with root package name */
    private c f12973m;

    /* renamed from: n  reason: collision with root package name */
    private int f12974n;

    /* renamed from: o  reason: collision with root package name */
    private int f12975o;

    /* renamed from: p  reason: collision with root package name */
    private int f12976p;

    /* renamed from: q  reason: collision with root package name */
    private int f12977q;

    /* renamed from: r  reason: collision with root package name */
    private int f12978r;

    /* renamed from: s  reason: collision with root package name */
    private int f12979s;

    /* renamed from: t  reason: collision with root package name */
    private int f12980t;

    /* renamed from: u  reason: collision with root package name */
    private int f12981u;

    private final class a extends WebChromeClient {
        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0062, code lost:
            if (r3 != false) goto L_0x0064;
         */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0056 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00b8  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00bb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onConsoleMessage(android.webkit.ConsoleMessage r9) {
            /*
                r8 = this;
                r0 = 0
                if (r9 != 0) goto L_0x0005
                r1 = r0
                goto L_0x0009
            L_0x0005:
                android.webkit.ConsoleMessage$MessageLevel r1 = r9.messageLevel()
            L_0x0009:
                if (r9 != 0) goto L_0x000d
                r9 = r0
                goto L_0x0011
            L_0x000d:
                java.lang.String r9 = r9.message()
            L_0x0011:
                r2 = 2
                r3 = 0
                r4 = 1
                if (r9 != 0) goto L_0x0017
                goto L_0x0021
            L_0x0017:
                java.lang.String r5 = "Viewport target-densitydpi is not supported."
                boolean r5 = kotlin.text.StringsKt__StringsKt.L(r9, r5, r3, r2, r0)
                if (r5 != r4) goto L_0x0021
                r5 = 1
                goto L_0x0022
            L_0x0021:
                r5 = 0
            L_0x0022:
                if (r5 != 0) goto L_0x0037
                if (r9 != 0) goto L_0x0027
                goto L_0x0031
            L_0x0027:
                java.lang.String r5 = "Viewport argument key \"shrink-to-fit\" not recognized and ignored"
                boolean r5 = kotlin.text.StringsKt__StringsKt.L(r9, r5, r3, r2, r0)
                if (r5 != r4) goto L_0x0031
                r5 = 1
                goto L_0x0032
            L_0x0031:
                r5 = 0
            L_0x0032:
                if (r5 == 0) goto L_0x0035
                goto L_0x0037
            L_0x0035:
                r5 = 0
                goto L_0x0038
            L_0x0037:
                r5 = 1
            L_0x0038:
                android.webkit.ConsoleMessage$MessageLevel r6 = android.webkit.ConsoleMessage.MessageLevel.ERROR
                if (r1 != r6) goto L_0x003e
                r6 = 1
                goto L_0x003f
            L_0x003e:
                r6 = 0
            L_0x003f:
                android.webkit.ConsoleMessage$MessageLevel r7 = android.webkit.ConsoleMessage.MessageLevel.WARNING
                if (r1 != r7) goto L_0x0045
                r1 = 1
                goto L_0x0046
            L_0x0045:
                r1 = 0
            L_0x0046:
                if (r9 != 0) goto L_0x0049
                goto L_0x0053
            L_0x0049:
                java.lang.String r7 = "ADC3_update is not defined"
                boolean r7 = kotlin.text.StringsKt__StringsKt.L(r9, r7, r3, r2, r0)
                if (r7 != r4) goto L_0x0053
                r7 = 1
                goto L_0x0054
            L_0x0053:
                r7 = 0
            L_0x0054:
                if (r7 != 0) goto L_0x0064
                if (r9 != 0) goto L_0x0059
                goto L_0x0062
            L_0x0059:
                java.lang.String r7 = "NativeLayer.dispatch_messages is not a function"
                boolean r2 = kotlin.text.StringsKt__StringsKt.L(r9, r7, r3, r2, r0)
                if (r2 != r4) goto L_0x0062
                r3 = 1
            L_0x0062:
                if (r3 == 0) goto L_0x007d
            L_0x0064:
                com.adcolony.sdk.b1 r2 = com.adcolony.sdk.b1.this
                com.adcolony.sdk.h0 r3 = r2.getMessage()
                if (r3 != 0) goto L_0x006d
                goto L_0x0071
            L_0x006d:
                com.adcolony.sdk.f1 r0 = r3.a()
            L_0x0071:
                if (r0 != 0) goto L_0x0078
                com.adcolony.sdk.f1 r0 = new com.adcolony.sdk.f1
                r0.<init>()
            L_0x0078:
                java.lang.String r3 = "Unable to communicate with AdColony. Please ensure that you have added an exception for our Javascript interface in your ProGuard configuration and that you do not have a faulty proxy enabled on your device."
                r2.m(r0, r3)
            L_0x007d:
                if (r5 != 0) goto L_0x00c0
                if (r1 != 0) goto L_0x0083
                if (r6 == 0) goto L_0x00c0
            L_0x0083:
                com.adcolony.sdk.b1 r0 = com.adcolony.sdk.b1.this
                com.adcolony.sdk.AdColonyInterstitial r0 = r0.getInterstitial()
                if (r0 != 0) goto L_0x008c
                goto L_0x0092
            L_0x008c:
                java.lang.String r0 = r0.b()
                if (r0 != 0) goto L_0x0094
            L_0x0092:
                java.lang.String r0 = "unknown"
            L_0x0094:
                com.adcolony.sdk.e0$a r1 = new com.adcolony.sdk.e0$a
                r1.<init>()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "onConsoleMessage: "
                r2.append(r3)
                r2.append(r9)
                java.lang.String r9 = " with ad id: "
                r2.append(r9)
                r2.append(r0)
                java.lang.String r9 = r2.toString()
                com.adcolony.sdk.e0$a r9 = r1.c(r9)
                if (r6 == 0) goto L_0x00bb
                com.adcolony.sdk.e0 r0 = com.adcolony.sdk.e0.f13114i
                goto L_0x00bd
            L_0x00bb:
                com.adcolony.sdk.e0 r0 = com.adcolony.sdk.e0.f13112g
            L_0x00bd:
                r9.d(r0)
            L_0x00c0:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.b1.a.onConsoleMessage(android.webkit.ConsoleMessage):boolean");
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (jsResult == null) {
                return true;
            }
            jsResult.confirm();
            return true;
        }
    }

    protected class b extends WebViewClient {
        public b() {
        }

        public void onPageFinished(WebView webView, String str) {
            Unit unit;
            f1 q2 = c0.q();
            c0.u(q2, "id", b1.this.f12964d);
            c0.n(q2, ImagesContract.URL, str);
            c parentContainer = b1.this.getParentContainer();
            if (parentContainer == null) {
                unit = null;
            } else {
                c0.n(q2, "ad_session_id", b1.this.getAdSessionId());
                c0.u(q2, "container_id", parentContainer.p());
                new h0("WebView.on_load", parentContainer.I(), q2).e();
                unit = Unit.f40298a;
            }
            if (unit == null) {
                new h0("WebView.on_load", b1.this.getWebViewModuleId(), q2).e();
            }
        }

        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            b1.this.d(i2, str, str2);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean z2 = false;
            if (str != null && StringsKt__StringsJVMKt.s(str, Constants.AD_MRAID_JS_FILE_NAME, false, 2, (Object) null)) {
                z2 = true;
            }
            if (!z2) {
                return null;
            }
            String c2 = b1.this.f12966f;
            Charset charset = h.f13158a;
            if (c2 != null) {
                return new WebResourceResponse("text/javascript", charset.name(), new ByteArrayInputStream(c2.getBytes(charset)));
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    protected class c extends b {
        public c() {
            super();
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url;
            String uri;
            boolean z2 = false;
            if (!(webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (uri = url.toString()) == null || !StringsKt__StringsJVMKt.s(uri, Constants.AD_MRAID_JS_FILE_NAME, false, 2, (Object) null))) {
                z2 = true;
            }
            if (!z2) {
                return null;
            }
            String c2 = b1.this.f12966f;
            Charset charset = h.f13158a;
            if (c2 != null) {
                return new WebResourceResponse("text/javascript", charset.name(), new ByteArrayInputStream(c2.getBytes(charset)));
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return null;
        }
    }

    protected class d extends c {
        public d() {
            super();
        }

        public void onReceivedError(WebView webView, int i2, String str, String str2) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
            r3 = r3.getUrl();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceivedError(android.webkit.WebView r2, android.webkit.WebResourceRequest r3, android.webkit.WebResourceError r4) {
            /*
                r1 = this;
                if (r4 != 0) goto L_0x0003
                return
            L_0x0003:
                com.adcolony.sdk.b1 r2 = com.adcolony.sdk.b1.this
                int r0 = r4.getErrorCode()
                java.lang.CharSequence r4 = r4.getDescription()
                java.lang.String r4 = r4.toString()
                if (r3 != 0) goto L_0x0014
                goto L_0x001a
            L_0x0014:
                android.net.Uri r3 = r3.getUrl()
                if (r3 != 0) goto L_0x001c
            L_0x001a:
                r3 = 0
                goto L_0x0020
            L_0x001c:
                java.lang.String r3 = r3.toString()
            L_0x0020:
                r2.d(r0, r4, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.b1.d.onReceivedError(android.webkit.WebView, android.webkit.WebResourceRequest, android.webkit.WebResourceError):void");
        }
    }

    protected class e extends d {
        public e(b1 b1Var) {
            super();
        }
    }

    protected class f extends e {
        public f() {
            super(b1.this);
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            boolean z2;
            if (renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                b1.this.m(c0.q(), "An error occurred while rendering the ad. Ad closing.");
            }
            return true;
        }
    }

    public static final class g {
        private g() {
        }

        public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b1 a(Context context, h0 h0Var, int i2, c cVar) {
            b1 b1Var;
            int t2 = a.f().F0().t();
            f1 a2 = h0Var.a();
            if (c0.t(a2, "use_mraid_module")) {
                b1Var = new l0(context, t2, h0Var, a.f().F0().t());
            } else if (c0.t(a2, "enable_messages")) {
                b1Var = new c1(context, t2, h0Var);
            } else {
                b1Var = new b1(context, t2, h0Var);
            }
            b1Var.i(h0Var, i2, cVar);
            b1Var.u();
            return b1Var;
        }
    }

    public static final class h implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b1 f12987a;

        static final class a extends Lambda implements Function0<Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ b1 f12988f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ h0 f12989g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b1 b1Var, h0 h0Var) {
                super(0);
                this.f12988f = b1Var;
                this.f12989g = h0Var;
            }

            public final void a() {
                this.f12988f.l(c0.E(this.f12989g.a(), "custom_js"));
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.f40298a;
            }
        }

        h(b1 b1Var) {
            this.f12987a = b1Var;
        }

        public void a(h0 h0Var) {
            b1 b1Var = this.f12987a;
            b1Var.j(h0Var, new a(b1Var, h0Var));
        }
    }

    public static final class i implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b1 f12990a;

        static final class a extends Lambda implements Function0<Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ b1 f12991f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ h0 f12992g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b1 b1Var, h0 h0Var) {
                super(0);
                this.f12991f = b1Var;
                this.f12992g = h0Var;
            }

            public final void a() {
                this.f12991f.setVisible(this.f12992g);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.f40298a;
            }
        }

        i(b1 b1Var) {
            this.f12990a = b1Var;
        }

        public void a(h0 h0Var) {
            b1 b1Var = this.f12990a;
            b1Var.j(h0Var, new a(b1Var, h0Var));
        }
    }

    public static final class j implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b1 f12993a;

        static final class a extends Lambda implements Function0<Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ b1 f12994f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ h0 f12995g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b1 b1Var, h0 h0Var) {
                super(0);
                this.f12994f = b1Var;
                this.f12995g = h0Var;
            }

            public final void a() {
                this.f12994f.setBounds(this.f12995g);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.f40298a;
            }
        }

        j(b1 b1Var) {
            this.f12993a = b1Var;
        }

        public void a(h0 h0Var) {
            b1 b1Var = this.f12993a;
            b1Var.j(h0Var, new a(b1Var, h0Var));
        }
    }

    public static final class k implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b1 f12996a;

        static final class a extends Lambda implements Function0<Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ b1 f12997f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ h0 f12998g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b1 b1Var, h0 h0Var) {
                super(0);
                this.f12997f = b1Var;
                this.f12998g = h0Var;
            }

            public final void a() {
                this.f12997f.setTransparent(c0.t(this.f12998g.a(), "transparent"));
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.f40298a;
            }
        }

        k(b1 b1Var) {
            this.f12996a = b1Var;
        }

        public void a(h0 h0Var) {
            b1 b1Var = this.f12996a;
            b1Var.j(h0Var, new a(b1Var, h0Var));
        }
    }

    static final class l implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ Function0 f12999b;

        l(Function0 function0) {
            this.f12999b = function0;
        }

        public final /* synthetic */ void run() {
            this.f12999b.invoke();
        }
    }

    static final class m implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b1 f13000b;

        public static final class a extends WebViewClient {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b1 f13001a;

            a(b1 b1Var) {
                this.f13001a = b1Var;
            }

            public void onPageFinished(WebView webView, String str) {
                this.f13001a.destroy();
            }
        }

        m(b1 b1Var) {
            this.f13000b = b1Var;
        }

        public final void run() {
            this.f13000b.setWebChromeClient((WebChromeClient) null);
            this.f13000b.setWebViewClient(new a(this.f13000b));
            this.f13000b.clearCache(true);
            this.f13000b.removeAllViews();
            this.f13000b.loadUrl("about:blank");
        }
    }

    protected b1(Context context, int i2, h0 h0Var) {
        super(context);
        this.f12962b = i2;
        this.f12963c = h0Var;
    }

    public static final b1 b(Context context, h0 h0Var, int i2, c cVar) {
        return f12961v.a(context, h0Var, i2, cVar);
    }

    /* access modifiers changed from: private */
    public final void d(int i2, String str, String str2) {
        c cVar = this.f12973m;
        if (cVar != null) {
            f1 q2 = c0.q();
            c0.u(q2, "id", this.f12964d);
            c0.n(q2, "ad_session_id", getAdSessionId());
            c0.u(q2, "container_id", cVar.p());
            c0.u(q2, "code", i2);
            c0.n(q2, MRAIDPresenter.ERROR, str);
            c0.n(q2, ImagesContract.URL, str2);
            new h0("WebView.on_error", cVar.I(), q2).e();
        }
        e0.a c2 = new e0.a().c("onReceivedError: ");
        if (str == null) {
            str = "WebViewErrorMessage: null description";
        }
        c2.c(str).d(e0.f13114i);
    }

    /* access modifiers changed from: private */
    public final void j(h0 h0Var, Function0<Unit> function0) {
        boolean z2;
        String str;
        f1 a2 = h0Var.a();
        if (c0.A(a2, "id") == this.f12964d) {
            int A = c0.A(a2, "container_id");
            c cVar = this.f12973m;
            if (cVar != null && A == cVar.p()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                String E = c0.E(a2, "ad_session_id");
                c cVar2 = this.f12973m;
                if (cVar2 == null) {
                    str = null;
                } else {
                    str = cVar2.b();
                }
                if (Intrinsics.a(E, str)) {
                    z0.A(new l(function0));
                }
            }
        }
    }

    private final void k(Exception exc) {
        new e0.a().c(exc.getClass().toString()).c(" during metadata injection w/ metadata = ").c(c0.E(this.f12971k, "metadata")).d(e0.f13114i);
        c cVar = this.f12973m;
        if (cVar != null) {
            f1 q2 = c0.q();
            c0.n(q2, "id", getAdSessionId());
            new h0("AdSession.on_error", cVar.I(), q2).e();
        }
    }

    private final void p() {
        ArrayList<String> G;
        ArrayList<j0> E;
        c cVar = this.f12973m;
        if (!(cVar == null || (E = cVar.E()) == null)) {
            E.add(a.b("WebView.execute_js", new h(this), true));
            E.add(a.b("WebView.set_visible", new i(this), true));
            E.add(a.b("WebView.set_bounds", new j(this), true));
            E.add(a.b("WebView.set_transparent", new k(this), true));
        }
        c cVar2 = this.f12973m;
        if (cVar2 != null && (G = cVar2.G()) != null) {
            G.add("WebView.execute_js");
            G.add("WebView.set_visible");
            G.add("WebView.set_bounds");
            G.add("WebView.set_transparent");
        }
    }

    private final WebViewClient s() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return getWebViewClientApi26();
        }
        if (i2 >= 24) {
            return getWebViewClientApi24();
        }
        if (i2 >= 23) {
            return getWebViewClientApi23();
        }
        return getWebViewClientApi21();
    }

    /* access modifiers changed from: private */
    public final void setTransparent(boolean z2) {
        setBackgroundColor(z2 ? 0 : -1);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String getAdSessionId() {
        return this.f12969i;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ AdColonyAdView getAdView() {
        return a.f().T().s().get(this.f12969i);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String getBaseUrl() {
        return this.f12968h;
    }

    public final int getCurrentHeight() {
        return this.f12977q;
    }

    public final int getCurrentWidth() {
        return this.f12976p;
    }

    public final int getCurrentX() {
        return this.f12974n;
    }

    public final int getCurrentY() {
        return this.f12975o;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean getDestroyed() {
        return this.f12972l;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ f1 getInfo() {
        return this.f12971k;
    }

    public final int getInitialHeight() {
        return this.f12981u;
    }

    public final int getInitialWidth() {
        return this.f12980t;
    }

    public final int getInitialX() {
        return this.f12978r;
    }

    public final int getInitialY() {
        return this.f12979s;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ AdColonyInterstitial getInterstitial() {
        return a.f().T().z().get(this.f12969i);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String getMUrl() {
        return this.f12967g;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ h0 getMessage() {
        return this.f12963c;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String getMraidFilepath() {
        return this.f12970j;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ c getParentContainer() {
        return this.f12973m;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi21() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi23() {
        return new d();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi24() {
        return new e(this);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi26() {
        return new f();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientDefault() {
        return new b();
    }

    public final int getWebViewModuleId() {
        return this.f12962b;
    }

    public final void h(h0 h0Var) {
        setBounds(h0Var);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void i(h0 h0Var, int i2, c cVar) {
        this.f12964d = i2;
        this.f12973m = cVar;
        f1 a2 = h0Var.a();
        String F = c0.F(a2, ImagesContract.URL);
        if (F == null) {
            F = c0.E(a2, "data");
        }
        this.f12967g = F;
        this.f12968h = c0.E(a2, "base_url");
        this.f12965e = c0.E(a2, "custom_js");
        this.f12969i = c0.E(a2, "ad_session_id");
        this.f12971k = c0.C(a2, "info");
        this.f12970j = c0.E(a2, "mraid_filepath");
        this.f12976p = c0.A(a2, "width");
        this.f12977q = c0.A(a2, "height");
        this.f12974n = c0.A(a2, "x");
        int A = c0.A(a2, "y");
        this.f12975o = A;
        this.f12980t = this.f12976p;
        this.f12981u = this.f12977q;
        this.f12978r = this.f12974n;
        this.f12979s = A;
        w();
        r();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void l(String str) {
        if (this.f12972l) {
            new e0.a().c("Ignoring call to execute_js as WebView has been destroyed.").d(e0.f13108c);
            return;
        }
        try {
            evaluateJavascript(str, (ValueCallback) null);
        } catch (IllegalStateException unused) {
            new e0.a().c("Device reporting incorrect OS version, evaluateJavascript ").c("is not available. Disabling AdColony.").d(e0.f13113h);
            AdColony.f();
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ boolean m(f1 f1Var, String str) {
        b bVar;
        Context a2 = a.a();
        if (a2 instanceof b) {
            bVar = (b) a2;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return false;
        }
        a.f().T().c(bVar, f1Var, str);
        return true;
    }

    public final void o(h0 h0Var, int i2, c cVar) {
        i(h0Var, i2, cVar);
        q();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (motionEvent != null && motionEvent.getAction() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            AdColonyAdView adView = getAdView();
            if (adView != null && !adView.c()) {
                f1 q2 = c0.q();
                c0.n(q2, "ad_session_id", getAdSessionId());
                new h0("WebView.on_first_click", 1, q2).e();
                adView.setUserInteraction(true);
            }
            AdColonyInterstitial interstitial = getInterstitial();
            if (interstitial != null) {
                interstitial.l(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void q() {
        p();
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f12976p, this.f12977q);
        layoutParams.setMargins(getCurrentX(), getCurrentY(), 0, 0);
        layoutParams.gravity = 0;
        c cVar = this.f12973m;
        if (cVar != null) {
            cVar.addView(this, layoutParams);
        }
    }

    public final void r() {
        a.f().T().f(this, this.f12969i, this.f12973m);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setAdSessionId(String str) {
        this.f12969i = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setBaseUrl(String str) {
        this.f12968h = str;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void setBounds(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.f12974n = c0.A(a2, "x");
        this.f12975o = c0.A(a2, "y");
        this.f12976p = c0.A(a2, "width");
        this.f12977q = c0.A(a2, "height");
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(getCurrentX(), getCurrentY(), 0, 0);
            layoutParams2.width = getCurrentWidth();
            layoutParams2.height = getCurrentHeight();
            Unit unit = Unit.f40298a;
            setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setInfo(f1 f1Var) {
        this.f12971k = f1Var;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setMUrl(String str) {
        this.f12967g = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setMraidFilepath(String str) {
        this.f12970j = str;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void setVisible(h0 h0Var) {
        int i2;
        if (c0.t(h0Var.a(), ViewProps.VISIBLE)) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        setVisibility(i2);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String t() {
        AdColonyInterstitial interstitial = getInterstitial();
        if (interstitial != null) {
            String str = interstitial.b() + " : " + interstitial.x();
            return str == null ? "unknown" : str;
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    public /* synthetic */ void u() {
        boolean z2 = true;
        setFocusable(true);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        WebView.setWebContentsDebuggingEnabled(false);
        setWebChromeClient(new a());
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setGeolocationEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccess(true);
        setWebViewClient(s());
        v();
        if (!(this instanceof j)) {
            q();
        }
        if (this.f12965e.length() <= 0) {
            z2 = false;
        }
        if (z2) {
            l(this.f12965e);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void v() {
        if (!StringsKt__StringsJVMKt.G(this.f12967g, UriUtil.HTTP_SCHEME, false, 2, (Object) null) && !StringsKt__StringsJVMKt.G(this.f12967g, "file", false, 2, (Object) null)) {
            loadDataWithBaseURL(this.f12968h, this.f12967g, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, (String) null, (String) null);
        } else if (StringsKt__StringsKt.L(this.f12967g, ".html", false, 2, (Object) null) || !StringsKt__StringsJVMKt.G(this.f12967g, "file", false, 2, (Object) null)) {
            loadUrl(this.f12967g);
        } else {
            String str = this.f12967g;
            loadDataWithBaseURL(str, "<html><script src=\"" + this.f12967g + "\"></script></html>", AudienceNetworkActivity.WEBVIEW_MIME_TYPE, (String) null, (String) null);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void w() {
        boolean z2;
        if (this.f12970j.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            try {
                this.f12966f = a.f().B0().a(this.f12970j, false).toString();
                Regex regex = new Regex("bridge.os_name\\s*=\\s*\"\"\\s*;");
                this.f12966f = regex.j(this.f12966f, "bridge.os_name = \"\";\nvar ADC_DEVICE_INFO = " + this.f12971k + ";\n");
            } catch (IOException e2) {
                k(e2);
            } catch (IllegalArgumentException e3) {
                k(e3);
            } catch (IndexOutOfBoundsException e4) {
                k(e4);
            }
        }
    }

    public final void x() {
        if (!this.f12972l) {
            this.f12972l = true;
            z0.A(new m(this));
        }
    }
}
