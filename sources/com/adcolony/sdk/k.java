package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.o;
import com.adcolony.sdk.s;
import com.adcolony.sdk.v;
import com.google.android.gms.common.internal.ImagesContract;
import com.iab.omid.library.adcolony.Omid;
import com.iab.omid.library.adcolony.adsession.Partner;
import com.unity3d.ads.metadata.MediationMetaData;
import com.uwetrottmann.trakt5.TraktV2;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

class k {
    static String Y = "https://adc3-launch.adcolony.com/v4/launch";
    private static volatile String Z = "";
    /* access modifiers changed from: private */
    public boolean A;
    private boolean B;
    /* access modifiers changed from: private */
    public f C = new f();
    /* access modifiers changed from: private */
    public boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    /* access modifiers changed from: private */
    public boolean I;
    /* access modifiers changed from: private */
    public boolean J;
    /* access modifiers changed from: private */
    public boolean K;
    private int L;
    private int M = 1;
    private Application.ActivityLifecycleCallbacks N;
    /* access modifiers changed from: private */
    public Partner O = null;
    /* access modifiers changed from: private */
    public f1 P = new f1();
    private long Q = 500;
    private long R = 500;
    private boolean S;
    private long T = 20000;
    private long U = 300000;
    private long V = 15000;
    private int W;
    /* access modifiers changed from: private */
    public boolean X = false;

    /* renamed from: a  reason: collision with root package name */
    private i0 f13185a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public t f13186b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public t0 f13187c;

    /* renamed from: d  reason: collision with root package name */
    private d f13188d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public r f13189e;

    /* renamed from: f  reason: collision with root package name */
    private w f13190f;

    /* renamed from: g  reason: collision with root package name */
    private x0 f13191g;

    /* renamed from: h  reason: collision with root package name */
    private v0 f13192h;

    /* renamed from: i  reason: collision with root package name */
    private g0 f13193i;

    /* renamed from: j  reason: collision with root package name */
    private q f13194j;

    /* renamed from: k  reason: collision with root package name */
    private m0 f13195k;

    /* renamed from: l  reason: collision with root package name */
    private c f13196l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public z f13197m;

    /* renamed from: n  reason: collision with root package name */
    private AdColonyAdView f13198n;

    /* renamed from: o  reason: collision with root package name */
    private AdColonyInterstitial f13199o;

    /* renamed from: p  reason: collision with root package name */
    private HashMap<String, AdColonyCustomMessageListener> f13200p = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public AdColonyAppOptions f13201q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public h0 f13202r;

    /* renamed from: s  reason: collision with root package name */
    private f1 f13203s;

    /* renamed from: t  reason: collision with root package name */
    private HashMap<String, AdColonyZone> f13204t = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public HashMap<Integer, c1> f13205u = new HashMap<>();

    /* renamed from: v  reason: collision with root package name */
    private String f13206v;

    /* renamed from: w  reason: collision with root package name */
    private String f13207w;

    /* renamed from: x  reason: collision with root package name */
    private String f13208x;

    /* renamed from: y  reason: collision with root package name */
    private String f13209y = "";

    /* renamed from: z  reason: collision with root package name */
    private boolean f13210z;

    class a implements j0 {
        a(k kVar) {
        }

        public void a(h0 h0Var) {
            f1 q2 = c0.q();
            c0.u(q2, "crc32", z0.c(c0.E(h0Var.a(), "data")));
            h0Var.b(q2).e();
        }
    }

    class a0 implements j0 {
        a0() {
        }

        public void a(h0 h0Var) {
            boolean unused = k.this.L(true, true);
        }
    }

    class b implements j0 {
        b(k kVar) {
        }

        public void a(h0 h0Var) {
            int A = c0.A(h0Var.a(), "number");
            f1 q2 = c0.q();
            c0.l(q2, "uuids", z0.e(A));
            h0Var.b(q2).e();
        }
    }

    class b0 implements j0 {
        b0(k kVar) {
        }

        public void a(h0 h0Var) {
            f1 q2 = c0.q();
            c0.n(q2, "sha1", z0.x(c0.E(h0Var.a(), "data")));
            h0Var.b(q2).e();
        }
    }

    class c implements j0 {

        class a implements y<String> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h0 f13213a;

            a(h0 h0Var) {
                this.f13213a = h0Var;
            }

            /* renamed from: b */
            public void a(String str) {
                f1 q2 = c0.q();
                c0.n(q2, "advertiser_id", k.this.x0().H());
                c0.w(q2, "limit_ad_tracking", k.this.x0().a());
                this.f13213a.b(q2).e();
            }

            public void a(Throwable th) {
                new e0.a().c("Device.query_advertiser_info").c(" failed with error: ").c(Log.getStackTraceString(th)).d(e0.f13112g);
            }
        }

        c() {
        }

        public void a(h0 h0Var) {
            k.this.x0().t(a.a(), new a(h0Var));
        }
    }

    class d implements j0 {
        d() {
        }

        public void a(h0 h0Var) {
            s0 c2 = k.this.D0().c();
            k.this.x0().D(c0.E(h0Var.a(), MediationMetaData.KEY_VERSION));
            if (c2 != null) {
                c2.k(k.this.x0().Q());
            }
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            f1 unused = k.this.P = c0.C(h0Var.a(), "signals");
        }
    }

    class f implements j0 {

        class a implements x<o.b> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h0 f13218a;

            a(f fVar, h0 h0Var) {
                this.f13218a = h0Var;
            }

            public void a(o.b bVar) {
                f1 q2 = c0.q();
                if (bVar != null) {
                    c0.m(q2, "odt", bVar.d());
                }
                this.f13218a.b(q2).e();
            }
        }

        f() {
        }

        public void a(h0 h0Var) {
            if (k.this.f()) {
                o0.m().g(new a(this, h0Var), k.this.k0());
                return;
            }
            o.b j2 = o0.m().j();
            f1 q2 = c0.q();
            if (j2 != null) {
                c0.m(q2, "odt", j2.d());
            }
            h0Var.b(q2).e();
        }
    }

    class g implements j0 {
        g(k kVar) {
        }

        public void a(h0 h0Var) {
            o0.m().b();
        }
    }

    class h implements j0 {
        h() {
        }

        public void a(h0 h0Var) {
            k.this.f13197m.c(h0Var);
        }
    }

    class i implements Runnable {
        i() {
        }

        public void run() {
            Context a2 = a.a();
            if (!k.this.K && a2 != null) {
                try {
                    Omid.a(a2.getApplicationContext());
                    boolean unused = k.this.K = true;
                } catch (IllegalArgumentException unused2) {
                    new e0.a().c("IllegalArgumentException when activating Omid").d(e0.f13114i);
                    boolean unused3 = k.this.K = false;
                }
            }
            if (k.this.K && k.this.O == null) {
                try {
                    Partner unused4 = k.this.O = Partner.a("AdColony", "4.8.0");
                } catch (IllegalArgumentException unused5) {
                    new e0.a().c("IllegalArgumentException when creating Omid Partner").d(e0.f13114i);
                    boolean unused6 = k.this.K = false;
                }
            }
        }
    }

    class j implements Runnable {

        class a implements s.a {
            a() {
            }

            public void a(s sVar, h0 h0Var, Map<String, List<String>> map) {
                k.this.B(sVar);
            }
        }

        j() {
        }

        public void run() {
            f1 q2 = c0.q();
            c0.n(q2, ImagesContract.URL, k.Y);
            c0.n(q2, "content_type", TraktV2.CONTENT_TYPE_JSON);
            c0.n(q2, "content", k.this.x0().V().toString());
            c0.n(q2, ImagesContract.URL, k.Y);
            if (k.this.X) {
                f1 q3 = c0.q();
                c0.n(q3, AdActivity.REQUEST_KEY_EXTRA, "la-req-01");
                c0.n(q3, "response", "la-res-01");
                c0.m(q2, "dictionaries_mapping", q3);
            }
            k.this.f13186b.e(new s(new h0("WebServices.post", 0, q2), new a()));
        }
    }

    /* renamed from: com.adcolony.sdk.k$k  reason: collision with other inner class name */
    class C0002k implements v.c {
        C0002k(k kVar) {
        }

        public void a() {
            o0.m().n();
        }
    }

    class l implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13223b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h0 f13224c;

        l(Context context, h0 h0Var) {
            this.f13223b = context;
            this.f13224c = h0Var;
        }

        public void run() {
            j W = j.W(this.f13223b.getApplicationContext(), this.f13224c);
            k.this.f13205u.put(Integer.valueOf(W.getAdc3ModuleId()), W);
        }
    }

    class m implements Runnable {
        m() {
        }

        public void run() {
            if (a.f().N0().o()) {
                k.this.i();
            }
        }
    }

    class n implements s.a {
        n() {
        }

        public void a(s sVar, h0 h0Var, Map<String, List<String>> map) {
            k.this.l();
        }
    }

    class o implements Runnable {
        o() {
        }

        public void run() {
            boolean unused = k.this.j();
        }
    }

    class p implements AdColonyInterstitial.f {
        p() {
        }

        public void a() {
            k.this.N();
        }
    }

    class q implements AdColonyAdView.c {
        q() {
        }

        public void a() {
            k.this.N();
        }
    }

    class r implements x<n0> {
        r(k kVar) {
        }

        public void a(n0 n0Var) {
            o0.m().d(n0Var);
        }
    }

    class t implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b  reason: collision with root package name */
        private final Set<Integer> f13231b = new HashSet();

        t() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (!k.this.f13187c.o()) {
                k.this.f13187c.i(true);
            }
            a.c(activity);
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            a.f12895d = false;
            k.this.f13187c.k(false);
        }

        public void onActivityResumed(Activity activity) {
            ScheduledExecutorService scheduledExecutorService;
            this.f13231b.add(Integer.valueOf(activity.hashCode()));
            a.f12895d = true;
            a.c(activity);
            s0 c2 = k.this.D0().c();
            Context a2 = a.a();
            if (a2 == null || !k.this.f13187c.m() || !(a2 instanceof b) || ((b) a2).f12951e) {
                a.c(activity);
                if (k.this.f13202r != null) {
                    if (!Objects.equals(c0.E(k.this.f13202r.a(), "m_origin"), "")) {
                        k.this.f13202r.b(k.this.f13202r.a()).e();
                    }
                    h0 unused = k.this.f13202r = null;
                }
                boolean unused2 = k.this.A = false;
                k.this.f13187c.p(false);
                if (k.this.D && !k.this.f13187c.o()) {
                    k.this.f13187c.i(true);
                }
                k.this.f13187c.k(true);
                k.this.f13189e.i();
                if (c2 == null || (scheduledExecutorService = c2.f13374b) == null || scheduledExecutorService.isShutdown() || c2.f13374b.isTerminated()) {
                    AdColony.b(activity, a.f().f13201q);
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            k.this.f13187c.l(true);
        }

        public void onActivityStopped(Activity activity) {
            this.f13231b.remove(Integer.valueOf(activity.hashCode()));
            if (this.f13231b.isEmpty()) {
                k.this.f13187c.l(false);
            }
        }
    }

    class u implements j0 {
        u() {
        }

        public void a(h0 h0Var) {
            boolean unused = k.this.X(h0Var);
        }
    }

    class v implements j0 {
        v() {
        }

        public void a(h0 h0Var) {
            k.this.z(h0Var);
        }
    }

    class w implements j0 {
        w() {
        }

        public void a(h0 h0Var) {
            s0 c2 = k.this.D0().c();
            k.this.C.b(true);
            if (k.this.I) {
                f1 q2 = c0.q();
                f1 q3 = c0.q();
                c0.n(q3, "app_version", z0.B());
                c0.m(q2, "app_bundle_info", q3);
                new h0("AdColony.on_update", 1, q2).e();
                boolean unused = k.this.I = false;
            }
            if (k.this.J) {
                new h0("AdColony.on_install", 1).e();
            }
            f1 a2 = h0Var.a();
            if (c2 != null) {
                c2.l(c0.E(a2, "app_session_id"));
            }
            if (AdColonyEventTracker.b()) {
                AdColonyEventTracker.c();
            }
            Integer A = a2.A("base_download_threads");
            if (A != null) {
                k.this.f13186b.d(A.intValue());
            }
            Integer A2 = a2.A("concurrent_requests");
            if (A2 != null) {
                k.this.f13186b.g(A2.intValue());
            }
            Integer A3 = a2.A("threads_keep_alive_time");
            if (A3 != null) {
                k.this.f13186b.h(A3.intValue());
            }
            double z2 = a2.z("thread_pool_scaling_factor");
            if (!Double.isNaN(z2)) {
                k.this.f13186b.c(z2);
            }
            k.this.f13197m.f();
            k.this.k();
        }
    }

    class x implements j0 {
        x() {
        }

        public void a(h0 h0Var) {
            k.this.P(h0Var);
        }
    }

    class y implements j0 {
        y() {
        }

        public void a(h0 h0Var) {
            k.this.g0(h0Var);
        }
    }

    class z implements j0 {
        z() {
        }

        public void a(h0 h0Var) {
            k.this.i0(h0Var);
        }
    }

    k() {
    }

    /* access modifiers changed from: private */
    public void B(s sVar) {
        if (sVar.f13370o) {
            f1 g2 = c0.g(sVar.f13369n, "Parsing launch response");
            c0.n(g2, "sdkVersion", x0().i());
            c0.G(g2, this.f13192h.c() + "026ae9c9824b3e483fa6c71fa88f57ae27816141");
            if (W(g2)) {
                if (D(g2)) {
                    f1 q2 = c0.q();
                    c0.n(q2, ImagesContract.URL, this.f13206v);
                    c0.n(q2, "filepath", this.f13192h.c() + "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
                    this.f13186b.e(new s(new h0("WebServices.download", 0, q2), new n()));
                }
                this.f13203s = g2;
            } else if (!this.E) {
                new e0.a().c("Incomplete or disabled launch server response. ").c("Disabling AdColony until next launch.").d(e0.f13113h);
                R(true);
            }
        } else {
            q();
        }
    }

    private boolean D(f1 f1Var) {
        if (!this.E) {
            return true;
        }
        f1 f1Var2 = this.f13203s;
        if (f1Var2 != null && c0.E(c0.C(f1Var2, "controller"), "sha1").equals(c0.E(c0.C(f1Var, "controller"), "sha1"))) {
            return false;
        }
        new e0.a().c("Controller sha1 does not match, downloading new controller.").d(e0.f13112g);
        return true;
    }

    private boolean J(String str) {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        File file = new File(a2.getFilesDir().getAbsolutePath() + "/adc3/" + "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
        if (file.exists()) {
            return z0.p(str, file);
        }
        return false;
    }

    private boolean K(boolean z2) {
        return L(z2, false);
    }

    /* access modifiers changed from: private */
    public boolean L(boolean z2, boolean z3) {
        if (!a.h()) {
            return false;
        }
        this.H = z3;
        this.E = z2;
        if (z2 && !z3) {
            if (!j()) {
                return false;
            }
            this.H = true;
        }
        i();
        return true;
    }

    /* access modifiers changed from: private */
    public void N() {
        int i2 = this.W - 1;
        this.W = i2;
        if (i2 == 0) {
            n();
        }
    }

    private void O(f1 f1Var) {
        if (!l.I) {
            f1 C2 = c0.C(f1Var, "logging");
            g0.f13135h = c0.a(C2, "send_level", 1);
            g0.f13133f = c0.t(C2, "log_private");
            g0.f13134g = c0.a(C2, "print_level", 3);
            this.f13193i.n(c0.d(C2, "modules"));
            this.f13193i.p(c0.B(C2, "included_fields"));
        }
        f1 C3 = c0.C(f1Var, "metadata");
        x0().u(C3);
        N0().b(c0.A(C3, "session_timeout"));
        Z = c0.E(f1Var, "pie");
        this.f13209y = c0.E(c0.C(f1Var, "controller"), MediationMetaData.KEY_VERSION);
        this.Q = c0.b(C3, "signals_timeout", this.Q);
        this.R = c0.b(C3, "calculate_odt_timeout", this.R);
        this.S = c0.o(C3, "async_odt_query", this.S);
        this.T = c0.b(C3, "ad_request_timeout", this.T);
        this.U = c0.b(C3, "controller_heartbeat_interval", this.U);
        this.V = c0.b(C3, "controller_heartbeat_timeout", this.V);
        this.X = c0.o(C3, "enable_compression", false);
        v.b().c(C3.F("odt_config"), new r(this));
    }

    /* access modifiers changed from: private */
    public void P(h0 h0Var) {
        f1 c2 = this.f13201q.c();
        c0.n(c2, "app_id", this.f13201q.b());
        f1 q2 = c0.q();
        c0.m(q2, "options", c2);
        h0Var.b(q2).e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        new java.io.File(r3.f13192h.c() + "026ae9c9824b3e483fa6c71fa88f57ae27816141").delete();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean W(com.adcolony.sdk.f1 r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "controller"
            com.adcolony.sdk.f1 r1 = com.adcolony.sdk.c0.C(r4, r1)     // Catch:{ Exception -> 0x002f }
            java.lang.String r2 = "url"
            java.lang.String r2 = com.adcolony.sdk.c0.E(r1, r2)     // Catch:{ Exception -> 0x002f }
            r3.f13206v = r2     // Catch:{ Exception -> 0x002f }
            java.lang.String r2 = "sha1"
            java.lang.String r1 = com.adcolony.sdk.c0.E(r1, r2)     // Catch:{ Exception -> 0x002f }
            r3.f13207w = r1     // Catch:{ Exception -> 0x002f }
            java.lang.String r1 = "status"
            java.lang.String r1 = com.adcolony.sdk.c0.E(r4, r1)     // Catch:{ Exception -> 0x002f }
            r3.f13208x = r1     // Catch:{ Exception -> 0x002f }
            r3.O(r4)     // Catch:{ Exception -> 0x002f }
            boolean r4 = com.adcolony.sdk.AdColonyEventTracker.b()     // Catch:{ Exception -> 0x002f }
            if (r4 == 0) goto L_0x0050
            com.adcolony.sdk.AdColonyEventTracker.c()     // Catch:{ Exception -> 0x002f }
            goto L_0x0050
        L_0x002f:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x004f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
            r1.<init>()     // Catch:{ Exception -> 0x004f }
            com.adcolony.sdk.v0 r2 = r3.f13192h     // Catch:{ Exception -> 0x004f }
            java.lang.String r2 = r2.c()     // Catch:{ Exception -> 0x004f }
            r1.append(r2)     // Catch:{ Exception -> 0x004f }
            java.lang.String r2 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r1.append(r2)     // Catch:{ Exception -> 0x004f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x004f }
            r4.<init>(r1)     // Catch:{ Exception -> 0x004f }
            r4.delete()     // Catch:{ Exception -> 0x004f }
            goto L_0x0050
        L_0x004f:
        L_0x0050:
            java.lang.String r4 = r3.f13208x
            java.lang.String r1 = "disable"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0097
            boolean r4 = com.adcolony.sdk.l.I
            if (r4 != 0) goto L_0x0097
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r1.<init>()     // Catch:{ Exception -> 0x007d }
            com.adcolony.sdk.v0 r2 = r3.f13192h     // Catch:{ Exception -> 0x007d }
            java.lang.String r2 = r2.c()     // Catch:{ Exception -> 0x007d }
            r1.append(r2)     // Catch:{ Exception -> 0x007d }
            java.lang.String r2 = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5"
            r1.append(r2)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x007d }
            r4.<init>(r1)     // Catch:{ Exception -> 0x007d }
            r4.delete()     // Catch:{ Exception -> 0x007d }
        L_0x007d:
            com.adcolony.sdk.e0$a r4 = new com.adcolony.sdk.e0$a
            r4.<init>()
            java.lang.String r1 = "Launch server response with disabled status. Disabling AdColony "
            com.adcolony.sdk.e0$a r4 = r4.c(r1)
            java.lang.String r1 = "until next launch."
            com.adcolony.sdk.e0$a r4 = r4.c(r1)
            com.adcolony.sdk.e0 r1 = com.adcolony.sdk.e0.f13112g
            r4.d(r1)
            com.adcolony.sdk.AdColony.f()
            return r0
        L_0x0097:
            java.lang.String r4 = r3.f13206v
            java.lang.String r1 = ""
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x00a9
            java.lang.String r4 = r3.f13208x
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x00c4
        L_0x00a9:
            boolean r4 = com.adcolony.sdk.l.I
            if (r4 != 0) goto L_0x00c4
            com.adcolony.sdk.e0$a r4 = new com.adcolony.sdk.e0$a
            r4.<init>()
            java.lang.String r1 = "Missing controller status or URL. Disabling AdColony until next "
            com.adcolony.sdk.e0$a r4 = r4.c(r1)
            java.lang.String r1 = "launch."
            com.adcolony.sdk.e0$a r4 = r4.c(r1)
            com.adcolony.sdk.e0 r1 = com.adcolony.sdk.e0.f13114i
            r4.d(r1)
            return r0
        L_0x00c4:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.k.W(com.adcolony.sdk.f1):boolean");
    }

    /* access modifiers changed from: private */
    public boolean X(h0 h0Var) {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        try {
            int B2 = h0Var.a().B("id");
            if (B2 > 0) {
                C(B2);
            }
            z0.A(new l(a2, h0Var));
            return true;
        } catch (RuntimeException e2) {
            e0.a aVar = new e0.a();
            aVar.c(e2.toString() + ": during WebView initialization.").c(" Disabling AdColony.").d(e0.f13113h);
            AdColony.f();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        new Thread(new j()).start();
    }

    /* access modifiers changed from: private */
    public void i0(h0 h0Var) {
        AdColonyZone adColonyZone;
        if (!this.B) {
            String E2 = c0.E(h0Var.a(), "zone_id");
            if (this.f13204t.containsKey(E2)) {
                adColonyZone = this.f13204t.get(E2);
            } else {
                AdColonyZone adColonyZone2 = new AdColonyZone(E2);
                this.f13204t.put(E2, adColonyZone2);
                adColonyZone = adColonyZone2;
            }
            adColonyZone.d(h0Var);
        }
    }

    /* access modifiers changed from: private */
    public boolean j() {
        this.f13185a.d();
        return true;
    }

    /* access modifiers changed from: private */
    public void k() {
        f1 q2 = c0.q();
        c0.n(q2, "type", "AdColony.on_configuration_completed");
        e1 e1Var = new e1();
        for (String g2 : c().keySet()) {
            e1Var.g(g2);
        }
        f1 q3 = c0.q();
        c0.l(q3, "zone_ids", e1Var);
        c0.m(q2, "message", q3);
        new h0("CustomMessage.controller_send", 0, q2).e();
    }

    /* access modifiers changed from: private */
    public void l() {
        if (J(this.f13207w) || l.I) {
            if (!this.E && !this.H) {
                z0.A(new o());
            }
            if (this.E && this.H) {
                o();
                return;
            }
            return;
        }
        new e0.a().c("Downloaded controller sha1 does not match, retrying.").d(e0.f13111f);
        q();
    }

    private void m() {
        Application application;
        Context a2 = a.a();
        if (a2 != null && this.N == null) {
            this.N = new t();
            if (a2 instanceof Application) {
                application = (Application) a2;
            } else {
                application = ((Activity) a2).getApplication();
            }
            application.registerActivityLifecycleCallbacks(this.N);
        }
    }

    private void q() {
        if (a.f().N0().o()) {
            int i2 = this.L + 1;
            this.L = i2;
            this.M = Math.min(this.M * i2, 120);
            z0.n(new m(), ((long) this.M) * 1000);
            return;
        }
        new e0.a().c("Max launch server download attempts hit, or AdColony is no longer").c(" active.").d(e0.f13112g);
    }

    /* access modifiers changed from: private */
    public void z(h0 h0Var) {
        C(c0.A(h0Var.a(), "id"));
    }

    /* access modifiers changed from: package-private */
    public r A0() {
        if (this.f13189e == null) {
            this.f13189e = new r();
        }
        return this.f13189e;
    }

    /* access modifiers changed from: package-private */
    public w B0() {
        if (this.f13190f == null) {
            w wVar = new w();
            this.f13190f = wVar;
            wVar.m();
        }
        return this.f13190f;
    }

    /* access modifiers changed from: package-private */
    public boolean C(int i2) {
        this.f13205u.remove(Integer.valueOf(i2));
        return this.f13185a.o(i2);
    }

    /* access modifiers changed from: package-private */
    public g0 D0() {
        if (this.f13193i == null) {
            g0 g0Var = new g0();
            this.f13193i = g0Var;
            g0Var.o();
        }
        return this.f13193i;
    }

    /* access modifiers changed from: package-private */
    public boolean E(k0 k0Var) {
        this.f13205u.remove(Integer.valueOf(k0Var.getModuleId()));
        return this.f13185a.p(k0Var);
    }

    /* access modifiers changed from: package-private */
    public i0 F0() {
        if (this.f13185a == null) {
            i0 i0Var = new i0();
            this.f13185a = i0Var;
            i0Var.d();
        }
        return this.f13185a;
    }

    /* access modifiers changed from: package-private */
    public m0 H0() {
        if (this.f13195k == null) {
            this.f13195k = new m0();
        }
        return this.f13195k;
    }

    /* access modifiers changed from: package-private */
    public Partner J0() {
        return this.O;
    }

    /* access modifiers changed from: package-private */
    public AdColonyAppOptions L0() {
        if (this.f13201q == null) {
            this.f13201q = new AdColonyAppOptions();
        }
        return this.f13201q;
    }

    /* access modifiers changed from: package-private */
    public String M0() {
        return Z;
    }

    /* access modifiers changed from: package-private */
    public t0 N0() {
        if (this.f13187c == null) {
            t0 t0Var = new t0();
            this.f13187c = t0Var;
            t0Var.j();
        }
        return this.f13187c;
    }

    /* access modifiers changed from: package-private */
    public v0 O0() {
        if (this.f13192h == null) {
            v0 v0Var = new v0();
            this.f13192h = v0Var;
            v0Var.k();
        }
        return this.f13192h;
    }

    /* access modifiers changed from: package-private */
    public void R(boolean z2) {
        this.C.b(false);
        this.B = z2;
    }

    /* access modifiers changed from: package-private */
    public d T() {
        if (this.f13188d == null) {
            d dVar = new d();
            this.f13188d = dVar;
            dVar.F();
        }
        return this.f13188d;
    }

    /* access modifiers changed from: package-private */
    public void V(boolean z2) {
        this.A = z2;
    }

    /* access modifiers changed from: package-private */
    public x0 a() {
        if (this.f13191g == null) {
            x0 x0Var = new x0();
            this.f13191g = x0Var;
            x0Var.a();
        }
        return this.f13191g;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, c1> b() {
        return this.f13205u;
    }

    /* access modifiers changed from: package-private */
    public void b0(h0 h0Var) {
        this.f13202r = h0Var;
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, AdColonyZone> c() {
        return this.f13204t;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.B;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.S;
    }

    /* access modifiers changed from: package-private */
    public void f0(boolean z2) {
        this.f13210z = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public boolean g0(h0 h0Var) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.C.c();
    }

    /* access modifiers changed from: package-private */
    public String h0() {
        return this.f13209y;
    }

    /* access modifiers changed from: package-private */
    public long k0() {
        return this.R;
    }

    /* access modifiers changed from: package-private */
    public long m0() {
        return this.U;
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.C.b(false);
        this.f13188d.m();
        Object g2 = this.f13201q.g("force_ad_id");
        if ((g2 instanceof String) && !((String) g2).isEmpty()) {
            p();
        }
        AdColony.b(a.a(), this.f13201q);
        r();
        this.f13204t.clear();
        this.f13185a.d();
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.W = 0;
        for (AdColonyInterstitial next : this.f13188d.z().values()) {
            if (next.D()) {
                this.W++;
                next.d(new p());
            }
        }
        for (AdColonyAdView onDestroyListenerOrCall : this.f13188d.s().values()) {
            this.W++;
            onDestroyListenerOrCall.setOnDestroyListenerOrCall(new q());
        }
        if (this.W == 0) {
            n();
        }
    }

    /* access modifiers changed from: package-private */
    public long o0() {
        return this.V;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f13188d.z()) {
            for (AdColonyInterstitial G2 : this.f13188d.z().values()) {
                G2.G();
            }
            this.f13188d.z().clear();
        }
    }

    /* access modifiers changed from: package-private */
    public AdColonyInterstitial q0() {
        return this.f13199o;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        C(1);
        for (c1 p2 : this.f13205u.values()) {
            this.f13185a.p(p2);
        }
        this.f13205u.clear();
    }

    /* access modifiers changed from: package-private */
    public AdColonyAdView r0() {
        return this.f13198n;
    }

    /* access modifiers changed from: package-private */
    public c t0() {
        return this.f13196l;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        this.f13188d.b();
        n();
    }

    /* access modifiers changed from: package-private */
    public void v(AdColonyAdView adColonyAdView) {
        this.f13198n = adColonyAdView;
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, AdColonyCustomMessageListener> v0() {
        return this.f13200p;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void w(com.adcolony.sdk.AdColonyAppOptions r5, boolean r6) {
        /*
            r4 = this;
            r4.B = r6
            r4.f13201q = r5
            com.adcolony.sdk.i0 r0 = new com.adcolony.sdk.i0
            r0.<init>()
            r4.f13185a = r0
            com.adcolony.sdk.m r0 = new com.adcolony.sdk.m
            r0.<init>()
            com.adcolony.sdk.q r0 = new com.adcolony.sdk.q
            r0.<init>()
            r4.f13194j = r0
            r0.m()
            com.adcolony.sdk.t r0 = new com.adcolony.sdk.t
            r0.<init>()
            r4.f13186b = r0
            r0.b()
            com.adcolony.sdk.t0 r0 = new com.adcolony.sdk.t0
            r0.<init>()
            r4.f13187c = r0
            r0.j()
            com.adcolony.sdk.d r0 = new com.adcolony.sdk.d
            r0.<init>()
            r4.f13188d = r0
            r0.F()
            com.adcolony.sdk.r r0 = new com.adcolony.sdk.r
            r0.<init>()
            r4.f13189e = r0
            com.adcolony.sdk.w r0 = new com.adcolony.sdk.w
            r0.<init>()
            r4.f13190f = r0
            r0.m()
            com.adcolony.sdk.g0 r0 = new com.adcolony.sdk.g0
            r0.<init>()
            r4.f13193i = r0
            r0.o()
            com.adcolony.sdk.v0 r0 = new com.adcolony.sdk.v0
            r0.<init>()
            r4.f13192h = r0
            r0.k()
            com.adcolony.sdk.x0 r0 = new com.adcolony.sdk.x0
            r0.<init>()
            r4.f13191g = r0
            r0.a()
            com.adcolony.sdk.m0 r0 = new com.adcolony.sdk.m0
            r0.<init>()
            r4.f13195k = r0
            com.adcolony.sdk.z r0 = new com.adcolony.sdk.z
            r0.<init>()
            r4.f13197m = r0
            com.adcolony.sdk.m0 r0 = r4.f13195k
            r0.c()
            android.content.Context r0 = com.adcolony.sdk.a.a()
            com.adcolony.sdk.AdColony.b(r0, r5)
            r5 = 0
            r0 = 1
            if (r6 != 0) goto L_0x0135
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.adcolony.sdk.v0 r2 = r4.f13192h
            java.lang.String r2 = r2.c()
            r1.append(r2)
            java.lang.String r2 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.<init>(r1)
            boolean r6 = r6.exists()
            r4.F = r6
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.adcolony.sdk.v0 r3 = r4.f13192h
            java.lang.String r3 = r3.c()
            r1.append(r3)
            java.lang.String r3 = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r6.<init>(r1)
            boolean r6 = r6.exists()
            r4.G = r6
            boolean r1 = r4.F
            if (r1 == 0) goto L_0x00fc
            if (r6 == 0) goto L_0x00fc
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.adcolony.sdk.v0 r1 = r4.f13192h
            java.lang.String r1 = r1.c()
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.adcolony.sdk.f1 r6 = com.adcolony.sdk.c0.z(r6)
            java.lang.String r1 = "sdkVersion"
            java.lang.String r6 = com.adcolony.sdk.c0.E(r6, r1)
            com.adcolony.sdk.q r1 = r4.f13194j
            java.lang.String r1 = r1.i()
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x00fc
            r6 = 1
            goto L_0x00fd
        L_0x00fc:
            r6 = 0
        L_0x00fd:
            r4.E = r6
            com.adcolony.sdk.v r6 = com.adcolony.sdk.v.b()
            com.adcolony.sdk.k$k r1 = new com.adcolony.sdk.k$k
            r1.<init>(r4)
            r6.f(r1)
            boolean r6 = r4.F
            if (r6 == 0) goto L_0x012d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.adcolony.sdk.v0 r1 = r4.f13192h
            java.lang.String r1 = r1.c()
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.adcolony.sdk.f1 r6 = com.adcolony.sdk.c0.z(r6)
            r4.f13203s = r6
            r4.O(r6)
        L_0x012d:
            boolean r6 = r4.E
            r4.K(r6)
            r4.m()
        L_0x0135:
            com.adcolony.sdk.k$u r6 = new com.adcolony.sdk.k$u
            r6.<init>()
            java.lang.String r1 = "Module.load"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$v r6 = new com.adcolony.sdk.k$v
            r6.<init>()
            java.lang.String r1 = "Module.unload"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$w r6 = new com.adcolony.sdk.k$w
            r6.<init>()
            java.lang.String r1 = "AdColony.on_configured"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$x r6 = new com.adcolony.sdk.k$x
            r6.<init>()
            java.lang.String r1 = "AdColony.get_app_info"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$y r6 = new com.adcolony.sdk.k$y
            r6.<init>()
            java.lang.String r1 = "AdColony.v4vc_reward"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$z r6 = new com.adcolony.sdk.k$z
            r6.<init>()
            java.lang.String r1 = "AdColony.zone_info"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$a0 r6 = new com.adcolony.sdk.k$a0
            r6.<init>()
            java.lang.String r1 = "AdColony.probe_launch_server"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$b0 r6 = new com.adcolony.sdk.k$b0
            r6.<init>(r4)
            java.lang.String r1 = "Crypto.sha1"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$a r6 = new com.adcolony.sdk.k$a
            r6.<init>(r4)
            java.lang.String r1 = "Crypto.crc32"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$b r6 = new com.adcolony.sdk.k$b
            r6.<init>(r4)
            java.lang.String r1 = "Crypto.uuid"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$c r6 = new com.adcolony.sdk.k$c
            r6.<init>()
            java.lang.String r1 = "Device.query_advertiser_info"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$d r6 = new com.adcolony.sdk.k$d
            r6.<init>()
            java.lang.String r1 = "AdColony.controller_version"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$e r6 = new com.adcolony.sdk.k$e
            r6.<init>()
            java.lang.String r1 = "AdColony.provide_signals"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$f r6 = new com.adcolony.sdk.k$f
            r6.<init>()
            java.lang.String r1 = "AdColony.odt_calculate"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$g r6 = new com.adcolony.sdk.k$g
            r6.<init>(r4)
            java.lang.String r1 = "AdColony.odt_cache"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.k$h r6 = new com.adcolony.sdk.k$h
            r6.<init>()
            java.lang.String r1 = "AdColony.heartbeat"
            com.adcolony.sdk.a.e(r1, r6)
            com.adcolony.sdk.v0 r6 = r4.f13192h
            int r6 = com.adcolony.sdk.z0.t(r6)
            if (r6 != r0) goto L_0x01df
            r1 = 1
            goto L_0x01e0
        L_0x01df:
            r1 = 0
        L_0x01e0:
            r4.I = r1
            r1 = 2
            if (r6 != r1) goto L_0x01e6
            r5 = 1
        L_0x01e6:
            r4.J = r5
            com.adcolony.sdk.k$i r5 = new com.adcolony.sdk.k$i
            r5.<init>()
            com.adcolony.sdk.z0.A(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.k.w(com.adcolony.sdk.AdColonyAppOptions, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public void x(AdColonyInterstitial adColonyInterstitial) {
        this.f13199o = adColonyInterstitial;
    }

    /* access modifiers changed from: package-private */
    public q x0() {
        if (this.f13194j == null) {
            q qVar = new q();
            this.f13194j = qVar;
            qVar.m();
        }
        return this.f13194j;
    }

    /* access modifiers changed from: package-private */
    public void y(c cVar) {
        this.f13196l = cVar;
    }
}
