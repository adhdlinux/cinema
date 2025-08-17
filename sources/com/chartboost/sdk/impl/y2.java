package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.internal.Libraries.CBUtility;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.File;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public abstract class y2 implements a5 {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G = -1;
    public boolean H = true;
    public int I = -1;
    public g9 J = g9.PLAYING;
    public kd K;
    public int L = 1;
    public int M = 1;
    public int N = 1;
    public int O = 1;
    public float P;
    public float Q;
    public float R;
    public final f4 S = new b(this);

    /* renamed from: a  reason: collision with root package name */
    public final Context f19032a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19033b;

    /* renamed from: c  reason: collision with root package name */
    public final y7 f19034c;

    /* renamed from: d  reason: collision with root package name */
    public final String f19035d;

    /* renamed from: e  reason: collision with root package name */
    public final bc f19036e;

    /* renamed from: f  reason: collision with root package name */
    public final v5 f19037f;

    /* renamed from: g  reason: collision with root package name */
    public final q2 f19038g;

    /* renamed from: h  reason: collision with root package name */
    public final w2 f19039h;

    /* renamed from: i  reason: collision with root package name */
    public final Mediation f19040i;

    /* renamed from: j  reason: collision with root package name */
    public final String f19041j;

    /* renamed from: k  reason: collision with root package name */
    public final p8 f19042k;

    /* renamed from: l  reason: collision with root package name */
    public final k0 f19043l;

    /* renamed from: m  reason: collision with root package name */
    public final d7 f19044m;

    /* renamed from: n  reason: collision with root package name */
    public final od f19045n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ a5 f19046o;

    /* renamed from: p  reason: collision with root package name */
    public String f19047p;

    /* renamed from: q  reason: collision with root package name */
    public long f19048q;

    /* renamed from: r  reason: collision with root package name */
    public long f19049r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f19050s;

    /* renamed from: t  reason: collision with root package name */
    public int f19051t;

    /* renamed from: u  reason: collision with root package name */
    public int f19052u;

    /* renamed from: v  reason: collision with root package name */
    public int f19053v;

    /* renamed from: w  reason: collision with root package name */
    public int f19054w;

    /* renamed from: x  reason: collision with root package name */
    public int f19055x;

    /* renamed from: y  reason: collision with root package name */
    public int f19056y;

    /* renamed from: z  reason: collision with root package name */
    public int f19057z;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19058a;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.chartboost.sdk.impl.oc[] r0 = com.chartboost.sdk.impl.oc.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.impl.oc r1 = com.chartboost.sdk.impl.oc.START     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.chartboost.sdk.impl.oc r1 = com.chartboost.sdk.impl.oc.RESUME     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.chartboost.sdk.impl.oc r1 = com.chartboost.sdk.impl.oc.PAUSE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.chartboost.sdk.impl.oc r1 = com.chartboost.sdk.impl.oc.BUFFER_START     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.chartboost.sdk.impl.oc r1 = com.chartboost.sdk.impl.oc.BUFFER_END     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.chartboost.sdk.impl.oc r1 = com.chartboost.sdk.impl.oc.QUARTILE1     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.chartboost.sdk.impl.oc r1 = com.chartboost.sdk.impl.oc.MIDPOINT     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.chartboost.sdk.impl.oc r1 = com.chartboost.sdk.impl.oc.QUARTILE3     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.chartboost.sdk.impl.oc r1 = com.chartboost.sdk.impl.oc.COMPLETED     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.chartboost.sdk.impl.oc r1 = com.chartboost.sdk.impl.oc.SKIP     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.chartboost.sdk.impl.oc r1 = com.chartboost.sdk.impl.oc.VOLUME_CHANGE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                f19058a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.y2.a.<clinit>():void");
        }
    }

    public static final class c extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y2 f19060b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(y2 y2Var) {
            super(0);
            this.f19060b = y2Var;
        }

        public final void a() {
            if (!this.f19060b.A()) {
                w7.a("CBViewProtocol", "Webview seems to be taking more time loading the html content, so closing the view.");
                this.f19060b.a((tb) tb.h.TIMEOUT_EVENT, "");
                this.f19060b.f19045n.a();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public y2(Context context, String str, y7 y7Var, String str2, bc bcVar, v5 v5Var, q2 q2Var, w2 w2Var, Mediation mediation, String str3, p8 p8Var, k0 k0Var, d7 d7Var, od odVar, a5 a5Var) {
        y7 y7Var2 = y7Var;
        String str4 = str2;
        bc bcVar2 = bcVar;
        v5 v5Var2 = v5Var;
        p8 p8Var2 = p8Var;
        k0 k0Var2 = k0Var;
        d7 d7Var2 = d7Var;
        od odVar2 = odVar;
        a5 a5Var2 = a5Var;
        Intrinsics.f(context, "context");
        Intrinsics.f(str, "location");
        Intrinsics.f(y7Var2, "adUnitMType");
        Intrinsics.f(str4, "adTypeTraitsName");
        Intrinsics.f(bcVar2, "uiPoster");
        Intrinsics.f(v5Var2, "fileCache");
        Intrinsics.f(p8Var2, "openMeasurementImpressionCallback");
        Intrinsics.f(k0Var2, "adUnitRendererCallback");
        Intrinsics.f(d7Var2, "impressionInterface");
        Intrinsics.f(odVar2, "webViewTimeoutInterface");
        Intrinsics.f(a5Var2, "eventTracker");
        this.f19032a = context;
        this.f19033b = str;
        this.f19034c = y7Var2;
        this.f19035d = str4;
        this.f19036e = bcVar2;
        this.f19037f = v5Var2;
        this.f19038g = q2Var;
        this.f19039h = w2Var;
        this.f19040i = mediation;
        this.f19041j = str3;
        this.f19042k = p8Var2;
        this.f19043l = k0Var2;
        this.f19044m = d7Var2;
        this.f19045n = odVar2;
        this.f19046o = a5Var2;
    }

    public final boolean A() {
        return this.f19050s;
    }

    public final boolean B() {
        return this.J == g9.PLAYING;
    }

    public final void C() {
        this.R = 0.0f;
    }

    public abstract void D();

    public void E() {
        Context context;
        this.f19050s = true;
        this.f19049r = System.currentTimeMillis();
        w7.a("CBViewProtocol", "Total web view load response time " + ((this.f19049r - this.f19048q) / ((long) 1000)));
        kd kdVar = this.K;
        if (kdVar != null && (context = kdVar.getContext()) != null) {
            b(context);
            a(context);
            f();
        }
    }

    public void F() {
        z2 webView;
        w2 w2Var;
        kd kdVar = this.K;
        if (kdVar != null && (webView = kdVar.getWebView()) != null && (w2Var = this.f19039h) != null) {
            w2Var.a(webView, this.f19033b, this.f19035d);
            webView.onPause();
        }
    }

    public void G() {
        z2 webView;
        w2 w2Var;
        kd kdVar = this.K;
        if (kdVar != null && (webView = kdVar.getWebView()) != null && (w2Var = this.f19039h) != null) {
            w2Var.b(webView, this.f19033b, this.f19035d);
            webView.onResume();
        }
    }

    public final CBError.CBImpressionError H() {
        File file = this.f19037f.a().f18887a;
        if (file == null) {
            w7.b("CBViewProtocol", "External Storage path is unavailable or media not mounted");
            return CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW;
        }
        this.f19047p = AdPayload.FILE_SCHEME + file.getAbsolutePath() + '/';
        String str = this.f19041j;
        if (str == null || str.length() != 0) {
            return null;
        }
        w7.b("CBViewProtocol", "Empty template being passed in the response");
        return CBError.CBImpressionError.ERROR_DISPLAYING_VIEW;
    }

    public final void I() {
        this.f19036e.a(15000, new c(this));
    }

    public final void J() {
        Activity activity;
        kd kdVar = this.K;
        if (kdVar != null) {
            activity = kdVar.getActivity();
        } else {
            activity = null;
        }
        if (activity != null && !CBUtility.a(activity)) {
            int requestedOrientation = activity.getRequestedOrientation();
            int i2 = this.G;
            if (requestedOrientation != i2) {
                activity.setRequestedOrientation(i2);
            }
            this.H = true;
            this.I = -1;
        }
    }

    public final void K() {
        this.R = 1.0f;
    }

    public abstract kd a(Context context, Activity activity);

    public final String a(int i2) {
        return i2 != -1 ? i2 != 0 ? i2 != 1 ? MRAIDPresenter.ERROR : "portrait" : "landscape" : "none";
    }

    public final void c(long j2) {
        this.f19048q = j2;
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f19046o.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19046o.clearFromStorage(qbVar);
    }

    public final void d(int i2) {
        this.M = i2;
    }

    public final void e(int i2) {
        this.L = i2;
    }

    public final void f() {
        kd kdVar = this.K;
        if (kdVar == null || !this.f19050s) {
            this.C = this.f19056y;
            this.D = this.f19057z;
            this.E = this.A;
            this.F = this.B;
            return;
        }
        int[] iArr = new int[2];
        kdVar.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1] - this.f19055x;
        int width = kdVar.getWidth();
        int height = kdVar.getHeight();
        this.f19056y = i2;
        this.f19057z = i3;
        int i4 = width + i2;
        this.A = i4;
        int i5 = height + i3;
        this.B = i5;
        this.C = i2;
        this.D = i3;
        this.E = i4;
        this.F = i5;
        w7.a("CBViewProtocol", "CalculatePosition: defaultXPos: " + this.f19056y + " , currentXPos: " + this.C);
    }

    public void g() {
        this.f19042k.e();
        kd kdVar = this.K;
        if (kdVar != null) {
            kdVar.a();
            kdVar.removeAllViews();
        }
        this.K = null;
    }

    public final String h() {
        return this.f19035d;
    }

    public final Context i() {
        return this.f19032a;
    }

    public final String j() {
        f();
        return a(this.C, this.D, this.E, this.F);
    }

    public final f4 k() {
        return this.S;
    }

    public final String l() {
        f();
        return a(this.f19056y, this.f19057z, this.A, this.B);
    }

    public final int m() {
        return this.N;
    }

    public final int n() {
        return this.O;
    }

    public final String o() {
        return this.f19033b;
    }

    public final String p() {
        String jSONObject = h2.a(h2.a("width", (Object) Integer.valueOf(this.f19053v)), h2.a("height", (Object) Integer.valueOf(this.f19054w))).toString();
        Intrinsics.e(jSONObject, "jsonObject(\n            …ght)\n        ).toString()");
        return jSONObject;
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19046o.persist(qbVar);
    }

    public final int q() {
        return this.M;
    }

    public final int r() {
        return this.L;
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f19046o.refresh(obVar);
    }

    public final p8 s() {
        return this.f19042k;
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f19046o.store(ibVar);
    }

    public final String t() {
        String jSONObject = h2.a(h2.a("allowOrientationChange", (Object) Boolean.valueOf(this.H)), h2.a("forceOrientation", (Object) a(this.I))).toString();
        Intrinsics.e(jSONObject, "load.toString()");
        return jSONObject;
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19046o.track(qbVar);
    }

    public final String u() {
        String jSONObject = h2.a(h2.a("width", (Object) Integer.valueOf(this.f19051t)), h2.a("height", (Object) Integer.valueOf(this.f19052u))).toString();
        Intrinsics.e(jSONObject, "jsonObject(\n            …ght)\n        ).toString()");
        return jSONObject;
    }

    public final w2 v() {
        return this.f19039h;
    }

    public final bc w() {
        return this.f19036e;
    }

    public final float x() {
        return this.P;
    }

    public final float y() {
        return this.Q;
    }

    public final kd z() {
        return this.K;
    }

    public final void b(int i2) {
        this.N = i2;
    }

    public final void c(int i2) {
        this.O = i2;
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m81clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19046o.clearFromStorage(qbVar);
    }

    public final void d(String str) {
        q2 q2Var;
        if (str == null || str.length() == 0 || (q2Var = this.f19038g) == null) {
            w7.a("CBViewProtocol", "###### Sending VAST Tracking Event Failed: " + str);
            return;
        }
        q2Var.a(new l2("GET", str, i9.NORMAL, (File) null));
        w7.a("CBViewProtocol", "###### Sending VAST Tracking Event: " + str);
    }

    public final void e() {
        int i2;
        kd kdVar = this.K;
        Activity activity = null;
        Context context = kdVar != null ? kdVar.getContext() : null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity != null && !CBUtility.a(activity)) {
            int i3 = this.I;
            if (i3 != 0) {
                i2 = 1;
                if (i3 != 1) {
                    i2 = this.H ? -1 : activity.getResources().getConfiguration().orientation;
                }
            } else {
                i2 = 0;
            }
            activity.setRequestedOrientation(i2);
        }
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m82persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19046o.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m83refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f19046o.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m84store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f19046o.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m85track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19046o.track(qbVar);
    }

    public final void a(float f2) {
        this.P = f2;
    }

    public final void b(float f2) {
        this.Q = f2;
    }

    public final CBError.CBImpressionError c(String str) {
        Intrinsics.f(str, MRAIDPresenter.ERROR);
        a((tb) tb.h.WEBVIEW_ERROR, str);
        w7.b("CBViewProtocol", str);
        this.f19050s = true;
        return CBError.CBImpressionError.WEB_VIEW_CLIENT_RECEIVED_ERROR;
    }

    public static final class b implements f4 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y2 f19059a;

        public b(y2 y2Var) {
            this.f19059a = y2Var;
        }

        public void a() {
            this.f19059a.c(System.currentTimeMillis());
            y2 y2Var = this.f19059a;
            y2Var.G = y2Var.i() instanceof Activity ? ((Activity) this.f19059a.i()).getRequestedOrientation() : -1;
        }

        public void b() {
            this.f19059a.I();
        }

        public void c() {
            z2 z2Var;
            kd z2 = this.f19059a.z();
            if (z2 != null) {
                z2Var = z2.getWebView();
            } else {
                z2Var = null;
            }
            if (this.f19059a.f19034c != y7.VIDEO && z2Var != null) {
                p8 s2 = this.f19059a.s();
                y7 a2 = this.f19059a.f19034c;
                List emptyList = Collections.emptyList();
                Intrinsics.e(emptyList, "emptyList()");
                s2.a(a2, z2Var, emptyList);
            }
        }

        public void d() {
            this.f19059a.E();
        }

        public void a(String str) {
            Intrinsics.f(str, "message");
            this.f19059a.c(str);
        }

        public void a(View view) {
            Intrinsics.f(view, "obstructionView");
            this.f19059a.s().a(view);
        }
    }

    public final CBError.CBImpressionError a(ViewGroup viewGroup) {
        if (this.K == null) {
            if ((viewGroup != null ? viewGroup.getContext() : null) == null) {
                return CBError.CBImpressionError.ERROR_CREATING_VIEW;
            }
            Context context = viewGroup.getContext();
            Intrinsics.e(context, "hostView.context");
            this.K = a(context, (Activity) null);
        }
        return null;
    }

    public final void b(Context context) {
        Intrinsics.f(context, "context");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f19051t = displayMetrics.widthPixels;
        this.f19052u = displayMetrics.heightPixels;
    }

    public final int b(String str) {
        Intrinsics.f(str, "name");
        if (Intrinsics.a(str, "portrait")) {
            return 1;
        }
        return Intrinsics.a(str, "landscape") ? 0 : -1;
    }

    public final CBError.CBImpressionError a(CBImpressionActivity cBImpressionActivity) {
        Intrinsics.f(cBImpressionActivity, "activity");
        if (this.K == null) {
            Context applicationContext = cBImpressionActivity.getApplicationContext();
            Intrinsics.e(applicationContext, "activity.applicationContext");
            this.K = a(applicationContext, (Activity) cBImpressionActivity);
        }
        this.f19043l.a(this.f19032a);
        return null;
    }

    public final void a(tb tbVar, String str) {
        Intrinsics.f(tbVar, "name");
        if (str == null) {
            str = "no message";
        }
        track((qb) new d4(tbVar, str, this.f19035d, this.f19033b, this.f19040i, (ib) null, 32, (DefaultConstructorMarker) null));
    }

    public final void a(Context context) {
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            Intrinsics.e(window, "window");
            this.f19055x = a(window);
            if (this.f19051t == 0 || this.f19052u == 0) {
                b(context);
            }
            int width = rect.width();
            int i2 = this.f19052u - this.f19055x;
            if (width != this.f19053v || i2 != this.f19054w) {
                this.f19053v = width;
                this.f19054w = i2;
            }
        }
    }

    public final int a(Window window) {
        return window.findViewById(16908290).getTop();
    }

    public final void a(boolean z2, String str) {
        Intrinsics.f(str, "forceOrientation");
        this.H = z2;
        this.I = b(str);
        e();
    }

    public final String a(int i2, int i3, int i4, int i5) {
        String jSONObject = h2.a(h2.a("x", (Object) Integer.valueOf(i2)), h2.a("y", (Object) Integer.valueOf(i3)), h2.a("width", (Object) Integer.valueOf(i4)), h2.a("height", (Object) Integer.valueOf(i5))).toString();
        Intrinsics.e(jSONObject, "jsonObject(\n            …ht),\n        ).toString()");
        return jSONObject;
    }

    public final void a(float f2, float f3) {
        float f4 = (float) 4;
        float f5 = f2 / f4;
        float f6 = f2 / ((float) 2);
        float f7 = (f2 * ((float) 3)) / f4;
        if (f3 >= f5 && f3 < f6) {
            a(oc.QUARTILE1);
        } else if (f3 >= f6 && f3 < f7) {
            a(oc.MIDPOINT);
        } else if (f3 >= f7) {
            a(oc.QUARTILE3);
        }
    }

    public final void a(oc ocVar) {
        Intrinsics.f(ocVar, "event");
        w7.a("CBViewProtocol", "sendWebViewVastOmEvent: " + ocVar.name());
        if (this.f19034c == y7.VIDEO) {
            p8 p8Var = this.f19042k;
            switch (a.f19058a[ocVar.ordinal()]) {
                case 1:
                    p8Var.a(this.P, this.R);
                    return;
                case 2:
                    if (this.J == g9.PAUSED) {
                        p8Var.b();
                        return;
                    }
                    return;
                case 3:
                    p8Var.c();
                    return;
                case 4:
                    p8Var.a(true);
                    return;
                case 5:
                    p8Var.a(false);
                    return;
                case 6:
                    p8Var.a(r9.FIRST);
                    return;
                case 7:
                    p8Var.a(r9.MIDDLE);
                    return;
                case 8:
                    p8Var.a(r9.THIRD);
                    return;
                case 9:
                    p8Var.a();
                    return;
                case 10:
                    p8Var.f();
                    return;
                case 11:
                    p8Var.a(this.R);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(g9 g9Var) {
        Intrinsics.f(g9Var, "newState");
        this.J = g9Var;
    }

    public final void a(List list) {
        z2 webView;
        Intrinsics.f(list, "verificationScriptResourceList");
        kd kdVar = this.K;
        if (kdVar != null && (webView = kdVar.getWebView()) != null) {
            this.f19042k.a(this.f19034c, webView, list);
        }
    }
}
