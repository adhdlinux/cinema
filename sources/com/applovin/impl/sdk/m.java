package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.debugger.a;
import com.applovin.impl.mediation.debugger.ui.testmode.b;
import com.applovin.impl.mediation.e;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.a.f;
import com.applovin.impl.sdk.d.c;
import com.applovin.impl.sdk.d.g;
import com.applovin.impl.sdk.e.i;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdService;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.network.d;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.p;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinTargetingData;
import com.applovin.sdk.AppLovinUserSegment;
import com.applovin.sdk.AppLovinUserService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class m {

    /* renamed from: a  reason: collision with root package name */
    protected static Context f15517a;

    /* renamed from: c  reason: collision with root package name */
    private static a f15518c;
    private q A;
    private c B;
    private y C;
    private s D;
    /* access modifiers changed from: private */
    public d E;
    private i F;
    private n G;
    private h H;
    private n I;
    private f J;
    private u K;
    private PostbackServiceImpl L;
    private com.applovin.impl.sdk.network.f M;
    private e N;
    private com.applovin.impl.mediation.f O;
    private e P;
    private MediationServiceImpl Q;
    private h R;
    private a S;
    private w T;
    private com.applovin.impl.mediation.d U;
    private b V;
    /* access modifiers changed from: private */
    public List<MaxAdFormat> W;
    /* access modifiers changed from: private */
    public final Object X = new Object();
    private final AtomicBoolean Y = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public boolean Z = false;
    private boolean aa = false;
    private boolean ab = false;
    private boolean ac = false;
    private int ad = 0;
    private AppLovinSdk.SdkInitializationListener ae;
    private AppLovinSdk.SdkInitializationListener af;
    /* access modifiers changed from: private */
    public AppLovinSdkConfiguration ag;

    /* renamed from: b  reason: collision with root package name */
    protected com.applovin.impl.sdk.c.c f15519b;

    /* renamed from: d  reason: collision with root package name */
    private String f15520d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<Activity> f15521e;

    /* renamed from: f  reason: collision with root package name */
    private long f15522f;

    /* renamed from: g  reason: collision with root package name */
    private AppLovinSdkSettings f15523g;

    /* renamed from: h  reason: collision with root package name */
    private AppLovinUserSegment f15524h;

    /* renamed from: i  reason: collision with root package name */
    private AppLovinTargetingData f15525i;

    /* renamed from: j  reason: collision with root package name */
    private String f15526j;

    /* renamed from: k  reason: collision with root package name */
    private AppLovinAdServiceImpl f15527k;

    /* renamed from: l  reason: collision with root package name */
    private AppLovinNativeAdService f15528l;

    /* renamed from: m  reason: collision with root package name */
    private EventServiceImpl f15529m;

    /* renamed from: n  reason: collision with root package name */
    private UserServiceImpl f15530n;

    /* renamed from: o  reason: collision with root package name */
    private VariableServiceImpl f15531o;

    /* renamed from: p  reason: collision with root package name */
    private AppLovinSdk f15532p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public v f15533q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public o f15534r;

    /* renamed from: s  reason: collision with root package name */
    private com.applovin.impl.sdk.network.b f15535s;

    /* renamed from: t  reason: collision with root package name */
    private g f15536t;

    /* renamed from: u  reason: collision with root package name */
    private o f15537u;

    /* renamed from: v  reason: collision with root package name */
    private com.applovin.impl.sdk.c.e f15538v;

    /* renamed from: w  reason: collision with root package name */
    private l f15539w;

    /* renamed from: x  reason: collision with root package name */
    private p f15540x;

    /* renamed from: y  reason: collision with root package name */
    private c f15541y;

    /* renamed from: z  reason: collision with root package name */
    private r f15542z;

    public static Context M() {
        return f15517a;
    }

    public static a a(Context context) {
        if (f15518c == null) {
            f15518c = new a(context);
        }
        return f15518c;
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (v.a()) {
            for (String i2 : JsonUtils.getList(jSONObject, "error_messages", Collections.emptyList())) {
                v.i("AppLovinSdk", i2);
            }
        }
    }

    private void ao() {
        this.E.a((d.a) new d.a() {
            public void a() {
                if (v.a()) {
                    m.this.f15533q.c("AppLovinSdk", "Connected to internet - re-initializing SDK");
                }
                synchronized (m.this.X) {
                    if (!m.this.Z) {
                        m.this.b();
                    }
                }
                m.this.E.b(this);
            }

            public void b() {
            }
        });
    }

    /* access modifiers changed from: private */
    public List<MaxAdFormat> b(JSONObject jSONObject) {
        List<String> asList = Arrays.asList(JsonUtils.getString(jSONObject, "eaf", "").split(","));
        ArrayList arrayList = new ArrayList(asList.size());
        for (String formatFromString : asList) {
            MaxAdFormat formatFromString2 = MaxAdFormat.formatFromString(formatFromString);
            if (formatFromString2 != null) {
                arrayList.add(formatFromString2);
            }
        }
        return arrayList;
    }

    public v A() {
        return this.f15533q;
    }

    public e B() {
        return this.N;
    }

    public com.applovin.impl.mediation.f C() {
        return this.O;
    }

    public e D() {
        return this.P;
    }

    public MediationServiceImpl E() {
        return this.Q;
    }

    public w F() {
        return this.T;
    }

    public a G() {
        return this.S;
    }

    public h H() {
        return this.R;
    }

    public com.applovin.impl.mediation.d I() {
        return this.U;
    }

    public b J() {
        return this.V;
    }

    public com.applovin.impl.sdk.c.c K() {
        return this.f15519b;
    }

    public Context L() {
        return f15517a;
    }

    public Activity N() {
        WeakReference<Activity> weakReference = this.f15521e;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public long O() {
        return this.f15522f;
    }

    public boolean P() {
        return this.ab;
    }

    public boolean Q() {
        return this.ac;
    }

    public com.applovin.impl.sdk.network.b R() {
        return this.f15535s;
    }

    public o S() {
        return this.f15534r;
    }

    public g T() {
        return this.f15536t;
    }

    public com.applovin.impl.sdk.network.f U() {
        return this.M;
    }

    public o V() {
        return this.f15537u;
    }

    public l W() {
        return this.f15539w;
    }

    public PostbackServiceImpl X() {
        return this.L;
    }

    public AppLovinSdk Y() {
        return this.f15532p;
    }

    public c Z() {
        return this.f15541y;
    }

    public <T> T a(com.applovin.impl.sdk.c.b<T> bVar) {
        return this.f15519b.a(bVar);
    }

    public <T> T a(com.applovin.impl.sdk.c.d<T> dVar) {
        return b(dVar, (Object) null);
    }

    public <T> T a(String str, T t2, Class<?> cls, SharedPreferences sharedPreferences) {
        return com.applovin.impl.sdk.c.e.a(str, t2, (Class) cls, sharedPreferences);
    }

    public void a() {
        synchronized (this.X) {
            if (!this.Z && !this.aa) {
                b();
            }
        }
    }

    public void a(long j2) {
        this.f15539w.a(j2);
    }

    public void a(SharedPreferences sharedPreferences) {
        this.f15538v.a(sharedPreferences);
    }

    public void a(com.applovin.impl.mediation.a.f fVar) {
        if (!this.f15534r.a()) {
            List<String> b2 = b(com.applovin.impl.sdk.c.a.f15179a);
            if (b2.size() > 0 && this.P.b().containsAll(b2)) {
                if (v.a()) {
                    this.f15533q.b("AppLovinSdk", "All required adapters initialized");
                }
                this.f15534r.d();
                j();
            }
        }
    }

    public <T> void a(com.applovin.impl.sdk.c.d<T> dVar, T t2) {
        this.f15538v.a(dVar, t2);
    }

    public <T> void a(com.applovin.impl.sdk.c.d<T> dVar, T t2, SharedPreferences sharedPreferences) {
        this.f15538v.a(dVar, t2, sharedPreferences);
    }

    public void a(final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (!d()) {
            this.ae = sdkInitializationListener;
        } else if (sdkInitializationListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    sdkInitializationListener.onSdkInitialized(m.this.ag);
                }
            });
        }
    }

    public void a(AppLovinSdk appLovinSdk) {
        this.f15532p = appLovinSdk;
    }

    public void a(String str) {
        if (v.a()) {
            v.f("AppLovinSdk", "Setting plugin version: " + str);
        }
        this.f15519b.a((com.applovin.impl.sdk.c.b<?>) com.applovin.impl.sdk.c.b.dz, (Object) str);
    }

    public void a(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        com.applovin.impl.sdk.c.e eVar;
        String str2;
        this.f15520d = str;
        this.f15522f = System.currentTimeMillis();
        this.f15523g = appLovinSdkSettings;
        this.f15524h = new g();
        this.f15525i = new AppLovinTargetingDataImpl();
        this.ag = new SdkConfigurationImpl(this);
        f15517a = context.getApplicationContext();
        if (context instanceof Activity) {
            this.f15521e = new WeakReference<>((Activity) context);
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f15538v = new com.applovin.impl.sdk.c.e(this);
        this.f15519b = new com.applovin.impl.sdk.c.c(this);
        this.f15533q = new v(this);
        if (((Boolean) a(com.applovin.impl.sdk.c.b.br)).booleanValue()) {
            this.f15542z = new r(this);
        }
        this.A = new q(this);
        this.f15541y = new c(this);
        this.f15529m = new EventServiceImpl(this);
        this.f15530n = new UserServiceImpl(this);
        this.f15531o = new VariableServiceImpl(this);
        this.B = new c(this);
        this.f15534r = new o(this);
        this.f15535s = new com.applovin.impl.sdk.network.b(this);
        this.f15536t = new g(this);
        this.J = new f(this);
        this.f15537u = new o(this);
        this.f15527k = new AppLovinAdServiceImpl(this);
        this.f15528l = new AppLovinNativeAdService(this);
        this.C = new y(this);
        this.D = new s(this);
        this.L = new PostbackServiceImpl(this);
        this.M = new com.applovin.impl.sdk.network.f(this);
        this.N = new e(this);
        this.O = new com.applovin.impl.mediation.f(this);
        this.P = new e(this);
        this.Q = new MediationServiceImpl(this);
        this.T = new w(this);
        this.S = new a(this);
        this.R = new h();
        this.U = new com.applovin.impl.mediation.d(this);
        this.f15539w = new l(this);
        this.G = new n(this);
        this.H = new h(this);
        this.V = new b(this);
        this.I = new n(this);
        this.K = new u(this);
        this.F = new i(this);
        this.f15540x = new p(this);
        this.P.a(MaxAdapter.InitializationStatus.INITIALIZING);
        com.applovin.impl.sdk.c.b bVar = com.applovin.impl.sdk.c.b.cZ;
        if (((Boolean) a(bVar)).booleanValue()) {
            this.E = new d(context);
        }
        if (v.a() && TextUtils.isEmpty(str)) {
            v.i("AppLovinSdk", "Unable to find AppLovin SDK key. Please add  meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
            v.i("AppLovinSdk", "Called with an invalid SDK key from: " + Log.getStackTraceString(new Throwable("")));
        }
        if (str.length() != 86 && Utils.isPubInDebugMode(context, this) && v.a()) {
            v.i("AppLovinSdk", "Please double-check that you entered your SDK key correctly (" + str + ") : " + Log.getStackTraceString(new Throwable("")));
        }
        if (Utils.isProguardRulesOmitted() && v.a()) {
            v.i("AppLovinSdk", "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!Utils.hasAndroidCoreJsonLibrary(this) && v.a()) {
            v.i("AppLovinSdk", "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (Utils.isVerboseLoggingEnabled(context)) {
            appLovinSdkSettings.setVerboseLogging(true);
        }
        K().a((com.applovin.impl.sdk.c.b<?>) com.applovin.impl.sdk.c.b.ab, (Object) Boolean.valueOf(appLovinSdkSettings.isVerboseLoggingEnabled()));
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        com.applovin.impl.sdk.c.e eVar2 = this.f15538v;
        com.applovin.impl.sdk.c.d dVar = com.applovin.impl.sdk.c.d.f15215a;
        if (TextUtils.isEmpty((String) eVar2.b(dVar, null, defaultSharedPreferences))) {
            this.ab = true;
            eVar = this.f15538v;
            str2 = Boolean.toString(true);
        } else {
            eVar = this.f15538v;
            str2 = Boolean.toString(false);
        }
        eVar.a(dVar, str2, defaultSharedPreferences);
        com.applovin.impl.sdk.c.e eVar3 = this.f15538v;
        com.applovin.impl.sdk.c.d dVar2 = com.applovin.impl.sdk.c.d.f15216b;
        if (((Boolean) eVar3.b(dVar2, Boolean.FALSE)).booleanValue()) {
            if (v.a()) {
                this.f15533q.b("AppLovinSdk", "Initializing SDK for non-maiden launch");
            }
            this.ac = true;
        } else {
            if (v.a()) {
                this.f15533q.b("AppLovinSdk", "Initializing SDK for maiden launch");
            }
            this.f15538v.a(dVar2, Boolean.TRUE);
        }
        com.applovin.impl.sdk.c.e eVar4 = this.f15538v;
        com.applovin.impl.sdk.c.d dVar3 = com.applovin.impl.sdk.c.d.f15217c;
        String str3 = (String) eVar4.b(dVar3, null);
        if (!StringUtils.isValidString(str3) || AppLovinSdk.VERSION_CODE > Utils.toVersionCode(str3)) {
            this.f15538v.a(dVar3, AppLovinSdk.VERSION);
        }
        boolean a2 = com.applovin.impl.sdk.utils.h.a(L());
        if (!((Boolean) a(com.applovin.impl.sdk.c.b.da)).booleanValue() || a2) {
            b();
        }
        if (((Boolean) a(bVar)).booleanValue() && !a2) {
            if (v.a()) {
                this.f15533q.c("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
            }
            ao();
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    public <T> void a(String str, T t2, SharedPreferences.Editor editor) {
        this.f15538v.a(str, t2, editor);
    }

    public void a(boolean z2) {
        synchronized (this.X) {
            this.Z = false;
            this.aa = z2;
        }
        if (this.f15519b != null && this.f15534r != null) {
            List<String> b2 = b(com.applovin.impl.sdk.c.a.f15179a);
            if (b2.isEmpty()) {
                this.f15534r.d();
                j();
                return;
            }
            long longValue = ((Long) a(com.applovin.impl.sdk.c.a.f15180b)).longValue();
            z zVar = new z(this, true, new Runnable() {
                public void run() {
                    if (!m.this.f15534r.a()) {
                        if (v.a()) {
                            m.this.f15533q.b("AppLovinSdk", "Timing out adapters init...");
                        }
                        m.this.f15534r.d();
                        m.this.j();
                    }
                }
            });
            if (v.a()) {
                v vVar = this.f15533q;
                vVar.b("AppLovinSdk", "Waiting for required adapters to init: " + b2 + " - timing out in " + longValue + "ms...");
            }
            this.f15534r.a(zVar, o.a.MEDIATION_TIMEOUT, longValue, true);
        }
    }

    public boolean a(com.applovin.impl.sdk.c.b<String> bVar, MaxAdFormat maxAdFormat) {
        return c(bVar).contains(maxAdFormat);
    }

    public boolean a(MaxAdFormat maxAdFormat) {
        List<MaxAdFormat> list = this.W;
        return list != null && list.size() > 0 && !this.W.contains(maxAdFormat);
    }

    public r aa() {
        return this.f15542z;
    }

    public q ab() {
        return this.A;
    }

    public c ac() {
        return this.B;
    }

    public y ad() {
        return this.C;
    }

    public s ae() {
        return this.D;
    }

    public a af() {
        return f15518c;
    }

    public i ag() {
        return this.F;
    }

    public n ah() {
        return this.G;
    }

    public h ai() {
        return this.H;
    }

    public AppLovinBroadcastManager aj() {
        return AppLovinBroadcastManager.getInstance(f15517a);
    }

    public n ak() {
        return this.I;
    }

    public f al() {
        return this.J;
    }

    public u am() {
        return this.K;
    }

    public Activity an() {
        Activity a2 = a(f15517a).a();
        if (a2 != null) {
            return a2;
        }
        Activity N2 = N();
        if (N2 != null) {
            return N2;
        }
        return null;
    }

    public <T> T b(com.applovin.impl.sdk.c.d<T> dVar, T t2) {
        return this.f15538v.b(dVar, t2);
    }

    public <T> T b(com.applovin.impl.sdk.c.d<T> dVar, T t2, SharedPreferences sharedPreferences) {
        return this.f15538v.b(dVar, t2, sharedPreferences);
    }

    public List<String> b(com.applovin.impl.sdk.c.b<String> bVar) {
        return this.f15519b.b(bVar);
    }

    public void b() {
        synchronized (this.X) {
            this.Z = true;
            S().c();
            int i2 = this.ad + 1;
            this.ad = i2;
            S().a((com.applovin.impl.sdk.e.a) new i(i2, this, new i.a() {
                public void a(JSONObject jSONObject) {
                    boolean z2 = jSONObject.length() > 0;
                    com.applovin.impl.sdk.utils.h.d(jSONObject, m.this);
                    com.applovin.impl.sdk.utils.h.c(jSONObject, m.this);
                    f.a(m.this);
                    com.applovin.impl.sdk.utils.h.e(jSONObject, m.this);
                    com.applovin.impl.sdk.utils.h.a(jSONObject, z2, m.this);
                    com.applovin.impl.mediation.d.b.a(jSONObject, m.this);
                    com.applovin.impl.mediation.d.b.b(jSONObject, m.this);
                    m.this.G().a(JsonUtils.getBoolean(jSONObject, "smd", Boolean.FALSE).booleanValue(), JsonUtils.getInt(jSONObject, "smd_delay_sec", 2));
                    m mVar = m.this;
                    List unused = mVar.W = mVar.b(jSONObject);
                    com.applovin.impl.sdk.utils.h.f(jSONObject, m.this);
                    m.this.J().a(jSONObject);
                    m.this.a(jSONObject);
                    m.this.S().a((com.applovin.impl.sdk.e.a) new com.applovin.impl.sdk.e.n(m.this));
                }
            }), o.a.MAIN, (long) ((Integer) a(com.applovin.impl.sdk.c.b.dV)).intValue());
        }
    }

    public <T> void b(com.applovin.impl.sdk.c.d<T> dVar) {
        this.f15538v.a(dVar);
    }

    public void b(String str) {
        if (v.a()) {
            v vVar = this.f15533q;
            vVar.b("AppLovinSdk", "Setting user id: " + str);
        }
        if (StringUtils.isValidString(str) && str.length() > Utils.kilobytesToByes(8)) {
            v.i("AppLovinSdk", "Provided user id longer than supported (" + str.length() + " bytes, " + Utils.kilobytesToByes(8) + " maximum)");
        }
        this.f15540x.a(str);
    }

    public List<MaxAdFormat> c(com.applovin.impl.sdk.c.b<String> bVar) {
        return this.f15519b.c(bVar);
    }

    public void c(String str) {
        this.f15526j = str;
        b(com.applovin.impl.sdk.c.d.A);
    }

    public boolean c() {
        boolean z2;
        synchronized (this.X) {
            z2 = this.Z;
        }
        return z2;
    }

    public boolean d() {
        boolean z2;
        synchronized (this.X) {
            z2 = this.aa;
        }
        return z2;
    }

    public boolean e() {
        return "HSrCHRtOan6wp2kwOIGJC1RDtuSrF2mWVbio2aBcMHX9KF3iTJ1lLSzCKP1ZSo5yNolPNw1kCTtWpxELFF4ah1".equalsIgnoreCase(z());
    }

    public boolean f() {
        return StringUtils.containsIgnoreCase(t(), AppLovinMediationProvider.MAX);
    }

    public boolean g() {
        return Utils.checkClassExistence("com.unity3d.player.UnityPlayerActivity");
    }

    public void h() {
        String str = (String) this.f15538v.b(com.applovin.impl.sdk.c.d.f15217c, null);
        if (StringUtils.isValidString(str) && AppLovinSdk.VERSION_CODE < Utils.toVersionCode(str) && v.a()) {
            v.i("AppLovinSdk", "Current version (" + AppLovinSdk.VERSION + ") is older than earlier installed version (" + str + "), which may cause compatibility issues.");
        }
    }

    public void i() {
        this.F.a();
    }

    public void j() {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener = this.ae;
        if (sdkInitializationListener != null) {
            if (d()) {
                this.ae = null;
                this.af = null;
                this.P.a(MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS);
            } else if (this.af != sdkInitializationListener) {
                this.P.a(MaxAdapter.InitializationStatus.INITIALIZED_FAILURE);
                if (((Boolean) a(com.applovin.impl.sdk.c.b.aj)).booleanValue()) {
                    this.ae = null;
                } else {
                    this.af = sdkInitializationListener;
                }
            } else {
                return;
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (v.a()) {
                        m.this.f15533q.b("AppLovinSdk", "Calling back publisher's initialization completion handler...");
                    }
                    sdkInitializationListener.onSdkInitialized(m.this.ag);
                }
            }, Math.max(0, ((Long) a(com.applovin.impl.sdk.c.b.ak)).longValue()));
        }
    }

    public void k() {
        if (v.a()) {
            v.i("AppLovinSdk", "Resetting SDK state...");
        }
        g gVar = this.f15536t;
        com.applovin.impl.sdk.d.f fVar = com.applovin.impl.sdk.d.f.f15308g;
        long b2 = gVar.b(fVar);
        this.f15519b.c();
        this.f15519b.a();
        this.f15536t.a();
        this.f15536t.b(fVar, b2 + 1);
        if (this.Y.compareAndSet(true, false)) {
            b();
        } else {
            this.Y.set(true);
        }
    }

    public void l() {
        this.S.c();
    }

    public String m() {
        return this.f15540x.a();
    }

    public String n() {
        return this.f15540x.b();
    }

    public String o() {
        return this.f15540x.c();
    }

    public AppLovinSdkSettings p() {
        return this.f15523g;
    }

    public AppLovinUserSegment q() {
        return this.f15524h;
    }

    public AppLovinTargetingDataImpl r() {
        return (AppLovinTargetingDataImpl) this.f15525i;
    }

    public AppLovinSdkConfiguration s() {
        return this.ag;
    }

    public String t() {
        String str = (String) a(com.applovin.impl.sdk.c.d.A);
        return StringUtils.isValidString(str) ? str : this.f15526j;
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.f15520d + '\'' + ", enabled=" + this.aa + ", isFirstSession=" + this.ab + '}';
    }

    public AppLovinAdServiceImpl u() {
        return this.f15527k;
    }

    public AppLovinNativeAdService v() {
        return this.f15528l;
    }

    public AppLovinEventService w() {
        return this.f15529m;
    }

    public AppLovinUserService x() {
        return this.f15530n;
    }

    public VariableServiceImpl y() {
        return this.f15531o;
    }

    public String z() {
        return this.f15520d;
    }
}
