package com.startapp.sdk.adsbase;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.startapp.be;
import com.startapp.bf;
import com.startapp.ce;
import com.startapp.d7;
import com.startapp.d8;
import com.startapp.d9;
import com.startapp.da;
import com.startapp.e7;
import com.startapp.ea;
import com.startapp.f7;
import com.startapp.fe;
import com.startapp.hb;
import com.startapp.hc;
import com.startapp.ia;
import com.startapp.je;
import com.startapp.ke;
import com.startapp.l2;
import com.startapp.lb;
import com.startapp.networkTest.startapp.NetworkTester;
import com.startapp.o6;
import com.startapp.oe;
import com.startapp.p6;
import com.startapp.pe;
import com.startapp.qe;
import com.startapp.ra;
import com.startapp.rb;
import com.startapp.re;
import com.startapp.sb;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.adsbase.remoteconfig.MotionMetadata;
import com.startapp.sdk.cachedservice.BackgroundService;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.insight.NetworkTestsMetaData;
import com.startapp.sdk.jobs.JobRequest;
import com.startapp.t7;
import com.startapp.tb;
import com.startapp.u7;
import com.startapp.u8;
import com.startapp.v6;
import com.startapp.w6;
import com.startapp.wd;
import com.startapp.x6;
import com.startapp.xb;
import com.startapp.xd;
import com.startapp.y8;
import com.startapp.yd;
import com.startapp.z8;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StartAppSDKInternal implements u7 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36218a = "StartAppSDKInternal";

    /* renamed from: b  reason: collision with root package name */
    public static final Object f36219b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static volatile InitState f36220c = InitState.UNSET;
    public boolean A = false;
    public v6 B = null;
    public t7 C;
    public bf D;
    public boolean E;
    public boolean F;

    /* renamed from: d  reason: collision with root package name */
    public SDKAdPreferences f36221d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36222e = true;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f36223f = hc.a();

    /* renamed from: g  reason: collision with root package name */
    public boolean f36224g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36225h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f36226i = false;

    /* renamed from: j  reason: collision with root package name */
    public long f36227j;

    /* renamed from: k  reason: collision with root package name */
    public Application f36228k;

    /* renamed from: l  reason: collision with root package name */
    public HashMap<Integer, Integer> f36229l = new HashMap<>();

    /* renamed from: m  reason: collision with root package name */
    public Object f36230m;

    /* renamed from: n  reason: collision with root package name */
    public Activity f36231n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f36232o = false;

    /* renamed from: p  reason: collision with root package name */
    public boolean f36233p = true;

    /* renamed from: q  reason: collision with root package name */
    public boolean f36234q = false;

    /* renamed from: r  reason: collision with root package name */
    public boolean f36235r = false;

    /* renamed from: s  reason: collision with root package name */
    public Map<String, String> f36236s;

    /* renamed from: t  reason: collision with root package name */
    public Bundle f36237t = null;

    /* renamed from: u  reason: collision with root package name */
    public AdPreferences f36238u;

    /* renamed from: v  reason: collision with root package name */
    public CacheKey f36239v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f36240w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f36241x = false;

    /* renamed from: y  reason: collision with root package name */
    public boolean f36242y = false;

    /* renamed from: z  reason: collision with root package name */
    public boolean f36243z = false;

    public enum InitState {
        UNSET,
        IMPLICIT,
        EXPLICIT
    }

    public static class a implements d9 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ xb f36248a;

        public a(xb xbVar) {
            this.f36248a = xbVar;
        }

        public void a(y8 y8Var, int i2) {
            xb xbVar = this.f36248a;
            if (xbVar != null) {
                boolean z2 = true;
                if (i2 != 1) {
                    z2 = false;
                }
                xbVar.a(Boolean.valueOf(z2));
            }
        }
    }

    public static class c {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static final StartAppSDKInternal f36252a = new StartAppSDKInternal();
    }

    public StartAppSDKInternal() {
        Map<Activity, Integer> map = lb.f34876a;
    }

    public static void a(StartAppSDKInternal startAppSDKInternal, Context context, String str, String str2, SDKAdPreferences sDKAdPreferences, boolean z2) {
        startAppSDKInternal.getClass();
        ComponentLocator a2 = ComponentLocator.a(context);
        u8 b2 = a2.J.b();
        InitState initState = f36220c;
        InitState initState2 = InitState.EXPLICIT;
        if (initState != initState2) {
            boolean a3 = ComponentLocator.a(context).c().a();
            if (TextUtils.isEmpty(str2)) {
                if (lb.f(context) || hc.c(context)) {
                    throw new IllegalArgumentException("\n+-------------------------------------------------------------+\n|                S   T   A   R   T   A   P   P                |\n| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |\n| Invalid App ID passed to init, please provide valid App ID  |\n|                                                             |\n|   https://support.start.io/hc/en-us/articles/360014774799   |\n+-------------------------------------------------------------+\n");
                }
                Log.w("StartAppSDK", new IllegalArgumentException("\n+-------------------------------------------------------------+\n|                S   T   A   R   T   A   P   P                |\n| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |\n| Invalid App ID passed to init, please provide valid App ID  |\n|                                                             |\n|   https://support.start.io/hc/en-us/articles/360014774799   |\n+-------------------------------------------------------------+\n"));
            }
            p6 c2 = ComponentLocator.a(context).c();
            c2.getClass();
            if (str != null) {
                str = str.trim();
            }
            if (str2 != null) {
                str2 = str2.trim();
            }
            synchronized (c2.f35607a) {
                c2.f35609c = str;
                c2.f35610d = str2;
                c2.f35608b.edit().putString("c88d4eab540fab77", str).putString("2696a7f502faed4b", str2).commit();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new e7(context), 3000);
            startAppSDKInternal.f36221d = sDKAdPreferences;
            ra.b(context, "shared_prefs_sdk_ad_prefs", sDKAdPreferences);
            startAppSDKInternal.a(z2);
            if (f36220c == InitState.IMPLICIT && !a3) {
                startAppSDKInternal.b(context, MetaDataRequest.RequestReason.LAUNCH);
            } else if (f36220c == InitState.UNSET) {
                startAppSDKInternal.a(context, MetaDataRequest.RequestReason.LAUNCH);
            }
            f36220c = initState2;
            try {
                a2.q().a((int) UserVerificationMethods.USER_VERIFY_HANDPRINT);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean c() {
        boolean z2;
        synchronized (f36219b) {
            z2 = f36220c == InitState.EXPLICIT;
        }
        return z2;
    }

    public static void f(Context context) {
        if (context != null) {
            a(context, false, (xb) null);
        }
    }

    public boolean b() {
        return this.f36235r;
    }

    public final void d(Context context) {
        Application application;
        Context a2 = ia.a(context);
        if (a2 instanceof Application) {
            application = (Application) a2;
        } else if (context instanceof Application) {
            application = (Application) context;
        } else if (context instanceof Activity) {
            application = ((Activity) context).getApplication();
        } else {
            application = context instanceof Service ? ((Service) context).getApplication() : null;
        }
        if (application != null && this.C == null) {
            t7 t7Var = new t7(this);
            this.C = t7Var;
            application.registerActivityLifecycleCallbacks(t7Var);
            try {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = ComponentLocator.a(context).q().f35579f;
                if (activityLifecycleCallbacks != null) {
                    application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                    return;
                }
                throw new RuntimeException();
            } catch (Throwable unused) {
            }
        }
    }

    public final void e(Context context) {
        AdPreferences adPreferences;
        CacheKey cacheKey;
        if (this.f36240w && !AdsCommonMetaData.f36186h.K()) {
            d8 d8Var = d8.f34354a;
            AdPreferences adPreferences2 = this.f36238u;
            if (adPreferences2 != null) {
                adPreferences = new AdPreferences(adPreferences2);
            } else {
                adPreferences = new AdPreferences();
            }
            AdPreferences.Placement placement = AdPreferences.Placement.INAPP_RETURN;
            if (d8Var.a(placement)) {
                cacheKey = d8Var.a(context, (StartAppAd) null, placement, adPreferences, (AdEventListener) null, false, 0);
            } else {
                cacheKey = null;
            }
            this.f36239v = cacheKey;
        }
    }

    public final void g(Context context) {
        x6 d2 = ComponentLocator.a(context).d();
        int i2 = d2.getInt("shared_prefs_app_version_id", -1);
        int i3 = hc.f34643a;
        int i4 = 0;
        try {
            i4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
        }
        if (i2 > 0 && i4 > i2) {
            this.f36235r = true;
        }
        x6.a a2 = d2.edit();
        a2.a("shared_prefs_app_version_id", Integer.valueOf(i4));
        a2.f36915a.putInt("shared_prefs_app_version_id", i4);
        a2.apply();
    }

    public final void h(Context context) {
        ComponentLocator a2 = ComponentLocator.a(context);
        x6.a a3 = a2.d().edit();
        Boolean bool = Boolean.FALSE;
        a3.a("periodicInfoEventPaused", bool);
        a3.f36915a.putBoolean("periodicInfoEventPaused", false);
        a3.a("periodicMetadataPaused", bool);
        a3.f36915a.putBoolean("periodicMetadataPaused", false);
        a3.apply();
        b bVar = new b(context, a2);
        if (MetaData.f36379h.f36382k) {
            bVar.a((MetaDataRequest.RequestReason) null, false);
        } else {
            MetaData.f36379h.a((da) bVar);
        }
    }

    public void b(Context context, MetaDataRequest.RequestReason requestReason) {
        hb.f34639a.a(context, requestReason);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c4, code lost:
        if (r9.contains(r0) != false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e5, code lost:
        if (r0.isEmpty() == false) goto L_0x00e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.content.Context r14) {
        /*
            r13 = this;
            java.lang.String r0 = "com.android.chrome"
            java.lang.String r1 = "android.support.customtabs.action.CustomTabsService"
            r2 = 1
            r3 = 0
            r4 = 0
            android.content.pm.PackageManager r5 = r14.getPackageManager()     // Catch:{ all -> 0x00c7 }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = "android.intent.action.VIEW"
            java.lang.String r8 = "http://www.example.com"
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ all -> 0x00c7 }
            r6.<init>(r7, r8)     // Catch:{ all -> 0x00c7 }
            android.content.pm.ResolveInfo r7 = r5.resolveActivity(r6, r3)     // Catch:{ all -> 0x00c7 }
            if (r7 == 0) goto L_0x0023
            android.content.pm.ActivityInfo r7 = r7.activityInfo     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = r7.packageName     // Catch:{ all -> 0x00c7 }
            goto L_0x0024
        L_0x0023:
            r7 = r4
        L_0x0024:
            java.util.List r8 = r5.queryIntentActivities(r6, r3)     // Catch:{ all -> 0x00c7 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x00c7 }
            r9.<init>()     // Catch:{ all -> 0x00c7 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00c7 }
        L_0x0031:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x00c7 }
            if (r10 == 0) goto L_0x005a
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x00c7 }
            android.content.pm.ResolveInfo r10 = (android.content.pm.ResolveInfo) r10     // Catch:{ all -> 0x00c7 }
            android.content.Intent r11 = new android.content.Intent     // Catch:{ all -> 0x00c7 }
            r11.<init>()     // Catch:{ all -> 0x00c7 }
            r11.setAction(r1)     // Catch:{ all -> 0x00c7 }
            android.content.pm.ActivityInfo r12 = r10.activityInfo     // Catch:{ all -> 0x00c7 }
            java.lang.String r12 = r12.packageName     // Catch:{ all -> 0x00c7 }
            r11.setPackage(r12)     // Catch:{ all -> 0x00c7 }
            android.content.pm.ResolveInfo r11 = r5.resolveService(r11, r3)     // Catch:{ all -> 0x00c7 }
            if (r11 == 0) goto L_0x0031
            android.content.pm.ActivityInfo r10 = r10.activityInfo     // Catch:{ all -> 0x00c7 }
            java.lang.String r10 = r10.packageName     // Catch:{ all -> 0x00c7 }
            r9.add(r10)     // Catch:{ all -> 0x00c7 }
            goto L_0x0031
        L_0x005a:
            boolean r5 = r9.isEmpty()     // Catch:{ all -> 0x00c7 }
            if (r5 == 0) goto L_0x0062
            goto L_0x00cb
        L_0x0062:
            int r5 = r9.size()     // Catch:{ all -> 0x00c7 }
            if (r5 != r2) goto L_0x006f
            java.lang.Object r0 = r9.get(r3)     // Catch:{ all -> 0x00c7 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00c7 }
            goto L_0x00cc
        L_0x006f:
            boolean r5 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00c7 }
            if (r5 != 0) goto L_0x00c0
            android.content.pm.PackageManager r5 = r14.getPackageManager()     // Catch:{ all -> 0x00b1 }
            r8 = 64
            java.util.List r5 = r5.queryIntentActivities(r6, r8)     // Catch:{ all -> 0x00b1 }
            if (r5 == 0) goto L_0x00b5
            int r6 = r5.size()     // Catch:{ all -> 0x00b1 }
            if (r6 != 0) goto L_0x0088
            goto L_0x00b5
        L_0x0088:
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x00b1 }
        L_0x008c:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x00b1 }
            if (r6 == 0) goto L_0x00b5
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x00b1 }
            android.content.pm.ResolveInfo r6 = (android.content.pm.ResolveInfo) r6     // Catch:{ all -> 0x00b1 }
            android.content.IntentFilter r8 = r6.filter     // Catch:{ all -> 0x00b1 }
            if (r8 != 0) goto L_0x009d
            goto L_0x008c
        L_0x009d:
            int r10 = r8.countDataAuthorities()     // Catch:{ all -> 0x00b1 }
            if (r10 == 0) goto L_0x008c
            int r8 = r8.countDataPaths()     // Catch:{ all -> 0x00b1 }
            if (r8 != 0) goto L_0x00aa
            goto L_0x008c
        L_0x00aa:
            android.content.pm.ActivityInfo r6 = r6.activityInfo     // Catch:{ all -> 0x00b1 }
            if (r6 != 0) goto L_0x00af
            goto L_0x008c
        L_0x00af:
            r5 = 1
            goto L_0x00b6
        L_0x00b1:
            r5 = move-exception
            com.startapp.y8.a((android.content.Context) r14, (java.lang.Throwable) r5)     // Catch:{ all -> 0x00c7 }
        L_0x00b5:
            r5 = 0
        L_0x00b6:
            if (r5 != 0) goto L_0x00c0
            boolean r5 = r9.contains(r7)     // Catch:{ all -> 0x00c7 }
            if (r5 == 0) goto L_0x00c0
            r0 = r7
            goto L_0x00cc
        L_0x00c0:
            boolean r5 = r9.contains(r0)     // Catch:{ all -> 0x00c7 }
            if (r5 == 0) goto L_0x00cb
            goto L_0x00cc
        L_0x00c7:
            r0 = move-exception
            com.startapp.y8.a((android.content.Context) r14, (java.lang.Throwable) r0)
        L_0x00cb:
            r0 = r4
        L_0x00cc:
            if (r0 != 0) goto L_0x00cf
            goto L_0x00e8
        L_0x00cf:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r1)
            r4.setPackage(r0)
            android.content.pm.PackageManager r0 = r14.getPackageManager()
            java.util.List r0 = r0.queryIntentServices(r4, r3)
            if (r0 == 0) goto L_0x00e8
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r2 = 0
        L_0x00e9:
            com.startapp.sdk.components.ComponentLocator r14 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r14)
            com.startapp.x6 r14 = r14.d()
            com.startapp.x6$a r14 = r14.edit()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            java.lang.String r1 = "chromeTabs"
            r14.a((java.lang.String) r1, r0)
            android.content.SharedPreferences$Editor r0 = r14.f36915a
            r0.putBoolean(r1, r2)
            r14.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.StartAppSDKInternal.b(android.content.Context):void");
    }

    public SDKAdPreferences c(Context context) {
        if (this.f36221d == null) {
            SDKAdPreferences sDKAdPreferences = (SDKAdPreferences) ra.a(context, "shared_prefs_sdk_ad_prefs", SDKAdPreferences.class);
            if (sDKAdPreferences == null) {
                this.f36221d = new SDKAdPreferences();
            } else {
                this.f36221d = sDKAdPreferences;
            }
        }
        return this.f36221d;
    }

    public boolean d() {
        return this.f36233p;
    }

    public static StartAppSDKInternal a() {
        return c.f36252a;
    }

    public static void a(Context context, Runnable runnable) {
        ComponentLocator a2 = ComponentLocator.a(context);
        if (a2.f36428b.b().f36965a.getBoolean("0115fe86041c10c0", true)) {
            a2.f36452z.b().execute(runnable);
        } else {
            o6.a(runnable);
        }
    }

    public static void a(Context context) {
        ComponentLocator a2 = ComponentLocator.a(context);
        u8 b2 = a2.J.b();
        w6 w6Var = new w6(context);
        String str = w6Var.f36815b;
        if (!TextUtils.isEmpty(str)) {
            StartAppSDKInternal startAppSDKInternal = c.f36252a;
            boolean z2 = w6Var.f36816c;
            startAppSDKInternal.getClass();
            Context b3 = ia.b(context);
            a(b3, (Runnable) new d7(startAppSDKInternal, b3, (String) null, str, (SDKAdPreferences) null, z2));
            if (!w6Var.f36817d) {
                StartAppAd.disableSplash();
            }
            if (a2.d().getBoolean("shared_prefs_first_init", true)) {
                y8 y8Var = new y8(z8.f36995b);
                y8Var.f36954d = "ManifestInit";
                y8Var.a(context);
            }
        } else if (f36220c == InitState.UNSET) {
            f36220c = InitState.IMPLICIT;
            c.f36252a.a(context, a2.c().a() ? MetaDataRequest.RequestReason.LAUNCH : MetaDataRequest.RequestReason.IMPLICIT_LAUNCH);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0084, code lost:
        if (r4 != false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0096, code lost:
        if (r5 == false) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r1.f36420d.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009d, code lost:
        d(r8);
        com.startapp.sdk.adsbase.remoteconfig.MetaData.c(r8);
        r1 = com.startapp.lb.f34876a;
        com.startapp.sdk.adsbase.AdsCommonMetaData.a(r8);
        com.startapp.sdk.ads.banner.BannerMetaData.a(r8);
        com.startapp.sdk.ads.splash.SplashMetaData.a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b0, code lost:
        if (r7.f36222e == false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b2, code lost:
        com.startapp.sdk.adsbase.cache.CacheMetaData.a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b5, code lost:
        com.startapp.sdk.adsbase.adinformation.AdInformationMetaData.a(r8);
        com.startapp.sdk.adsbase.SimpleTokenUtils.c(r8);
        com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h.a((com.startapp.da) r0.f());
        r0.f36446t.b().e();
        r0.f36447u.b().e();
        r0.s().e();
        com.startapp.p.f35598b = new java.net.CookieManager(new com.startapp.ec(r8), java.net.CookiePolicy.ACCEPT_ALL);
        g(r8);
        b(r8, r9);
        b(r8);
        h(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ff, code lost:
        if (com.startapp.hc.a() == false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0103, code lost:
        if ((r8 instanceof android.app.Application) == false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0105, code lost:
        r9 = (android.app.Application) r8;
        r7.f36228k = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r0 = r7.f36230m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x010c, code lost:
        if (r0 == null) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010e, code lost:
        r9.unregisterActivityLifecycleCallbacks((android.app.Application.ActivityLifecycleCallbacks) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0114, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        com.startapp.y8.a(r8, r9);
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0091 A[Catch:{ all -> 0x012a, all -> 0x0043, all -> 0x0133 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r8, com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest.RequestReason r9) {
        /*
            r7 = this;
            double r0 = java.lang.Math.random()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0011
            java.lang.String r0 = f36218a
            java.lang.String r1 = "!SDK-VERSION-STRING!:com.startapp.startappsdk:inapp-sdk:4.10.0"
            android.util.Log.i(r0, r1)
        L_0x0011:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            java.lang.Thread r1 = r1.getThread()
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0023
            r0 = 1
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            r7.E = r0
            com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r8)     // Catch:{ all -> 0x0133 }
            com.startapp.jc<com.startapp.v8> r1 = r0.H     // Catch:{ all -> 0x0133 }
            java.lang.Object r1 = r1.b()     // Catch:{ all -> 0x0133 }
            com.startapp.v8 r1 = (com.startapp.v8) r1     // Catch:{ all -> 0x0133 }
            r1.getClass()     // Catch:{ all -> 0x0133 }
            java.lang.Thread$UncaughtExceptionHandler r4 = java.lang.Thread.getDefaultUncaughtExceptionHandler()     // Catch:{ all -> 0x0043 }
            boolean r5 = r4 instanceof com.startapp.v8     // Catch:{ all -> 0x0043 }
            if (r5 != 0) goto L_0x0049
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r1)     // Catch:{ all -> 0x0043 }
            r1.f36733b = r4     // Catch:{ all -> 0x0043 }
            goto L_0x0049
        L_0x0043:
            r4 = move-exception
            android.content.Context r1 = r1.f36732a     // Catch:{ all -> 0x0133 }
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0133 }
        L_0x0049:
            com.startapp.e9 r1 = r0.k()     // Catch:{ all -> 0x0133 }
            r1.a()     // Catch:{ all -> 0x0133 }
            java.lang.String r1 = "android.permission.INTERNET"
            boolean r1 = com.startapp.hc.a((android.content.Context) r8, (java.lang.String) r1)     // Catch:{ all -> 0x0133 }
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = com.startapp.hc.a((android.content.Context) r8, (java.lang.String) r1)     // Catch:{ all -> 0x0133 }
            if (r1 != 0) goto L_0x0065
        L_0x0060:
            java.lang.String r1 = "Please grant the mandatory permissions : INTERNET & ACCESS_NETWORK_STATE, SDK could not be initialized."
            com.startapp.lb.a((android.content.Context) r8, (boolean) r3, (java.lang.String) r1, (boolean) r3)     // Catch:{ all -> 0x0133 }
        L_0x0065:
            boolean r1 = com.startapp.lb.d((android.content.Context) r8)     // Catch:{ all -> 0x0133 }
            r1 = r1 ^ r3
            r7.f36233p = r1     // Catch:{ all -> 0x0133 }
            com.startapp.sdk.common.advertisingid.AdvertisingIdResolver r1 = r0.a()     // Catch:{ all -> 0x0133 }
            r1.getClass()     // Catch:{ all -> 0x0133 }
            java.util.concurrent.locks.Lock r4 = r1.f36420d     // Catch:{ all -> 0x0087 }
            boolean r4 = r4.tryLock()     // Catch:{ all -> 0x0087 }
            if (r4 == 0) goto L_0x0083
            r1.b()     // Catch:{ all -> 0x0080 }
            r4 = 1
            goto L_0x0084
        L_0x0080:
            r4 = move-exception
            r5 = 1
            goto L_0x0089
        L_0x0083:
            r4 = 0
        L_0x0084:
            if (r4 == 0) goto L_0x009d
            goto L_0x0098
        L_0x0087:
            r4 = move-exception
            r5 = 0
        L_0x0089:
            r6 = 16
            boolean r6 = r1.a((int) r6)     // Catch:{ all -> 0x012a }
            if (r6 == 0) goto L_0x0096
            android.content.Context r6 = r1.f36417a     // Catch:{ all -> 0x012a }
            com.startapp.y8.a((android.content.Context) r6, (java.lang.Throwable) r4)     // Catch:{ all -> 0x012a }
        L_0x0096:
            if (r5 == 0) goto L_0x009d
        L_0x0098:
            java.util.concurrent.locks.Lock r1 = r1.f36420d     // Catch:{ all -> 0x0133 }
            r1.unlock()     // Catch:{ all -> 0x0133 }
        L_0x009d:
            r7.d(r8)     // Catch:{ all -> 0x0133 }
            com.startapp.sdk.adsbase.remoteconfig.MetaData.c(r8)     // Catch:{ all -> 0x0133 }
            java.util.Map<android.app.Activity, java.lang.Integer> r1 = com.startapp.lb.f34876a     // Catch:{ all -> 0x0133 }
            com.startapp.sdk.adsbase.AdsCommonMetaData.a((android.content.Context) r8)     // Catch:{ all -> 0x0133 }
            com.startapp.sdk.ads.banner.BannerMetaData.a(r8)     // Catch:{ all -> 0x0133 }
            com.startapp.sdk.ads.splash.SplashMetaData.a(r8)     // Catch:{ all -> 0x0133 }
            boolean r1 = r7.f36222e     // Catch:{ all -> 0x0133 }
            if (r1 == 0) goto L_0x00b5
            com.startapp.sdk.adsbase.cache.CacheMetaData.a(r8)     // Catch:{ all -> 0x0133 }
        L_0x00b5:
            com.startapp.sdk.adsbase.adinformation.AdInformationMetaData.a(r8)     // Catch:{ all -> 0x0133 }
            com.startapp.sdk.adsbase.SimpleTokenUtils.c(r8)     // Catch:{ all -> 0x0133 }
            com.startapp.s8 r1 = r0.f()     // Catch:{ all -> 0x0133 }
            com.startapp.sdk.adsbase.remoteconfig.MetaData r4 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h     // Catch:{ all -> 0x0133 }
            r4.a((com.startapp.da) r1)     // Catch:{ all -> 0x0133 }
            com.startapp.jc<com.startapp.ed> r1 = r0.f36446t     // Catch:{ all -> 0x0133 }
            java.lang.Object r1 = r1.b()     // Catch:{ all -> 0x0133 }
            com.startapp.ed r1 = (com.startapp.ed) r1     // Catch:{ all -> 0x0133 }
            r1.e()     // Catch:{ all -> 0x0133 }
            com.startapp.jc<com.startapp.kd> r1 = r0.f36447u     // Catch:{ all -> 0x0133 }
            java.lang.Object r1 = r1.b()     // Catch:{ all -> 0x0133 }
            com.startapp.kd r1 = (com.startapp.kd) r1     // Catch:{ all -> 0x0133 }
            r1.e()     // Catch:{ all -> 0x0133 }
            com.startapp.od r0 = r0.s()     // Catch:{ all -> 0x0133 }
            r0.e()     // Catch:{ all -> 0x0133 }
            java.net.CookieManager r0 = new java.net.CookieManager     // Catch:{ all -> 0x0133 }
            com.startapp.ec r1 = new com.startapp.ec     // Catch:{ all -> 0x0133 }
            r1.<init>(r8)     // Catch:{ all -> 0x0133 }
            java.net.CookiePolicy r4 = java.net.CookiePolicy.ACCEPT_ALL     // Catch:{ all -> 0x0133 }
            r0.<init>(r1, r4)     // Catch:{ all -> 0x0133 }
            com.startapp.p.f35598b = r0     // Catch:{ all -> 0x0133 }
            r7.g(r8)     // Catch:{ all -> 0x0133 }
            r7.b(r8, r9)     // Catch:{ all -> 0x0133 }
            r7.b(r8)     // Catch:{ all -> 0x0133 }
            r7.h(r8)     // Catch:{ all -> 0x0133 }
            boolean r9 = com.startapp.hc.a()     // Catch:{ all -> 0x0133 }
            if (r9 == 0) goto L_0x0124
            boolean r9 = r8 instanceof android.app.Application     // Catch:{ all -> 0x0133 }
            if (r9 == 0) goto L_0x0124
            r9 = r8
            android.app.Application r9 = (android.app.Application) r9     // Catch:{ all -> 0x0133 }
            r7.f36228k = r9     // Catch:{ all -> 0x0133 }
            java.lang.Object r0 = r7.f36230m     // Catch:{ all -> 0x0114 }
            if (r0 == 0) goto L_0x0118
            android.app.Application$ActivityLifecycleCallbacks r0 = (android.app.Application.ActivityLifecycleCallbacks) r0     // Catch:{ all -> 0x0114 }
            r9.unregisterActivityLifecycleCallbacks(r0)     // Catch:{ all -> 0x0114 }
            goto L_0x0118
        L_0x0114:
            r9 = move-exception
            com.startapp.y8.a((android.content.Context) r8, (java.lang.Throwable) r9)     // Catch:{ all -> 0x0133 }
        L_0x0118:
            android.app.Application r9 = r7.f36228k     // Catch:{ all -> 0x0133 }
            com.startapp.g7 r0 = new com.startapp.g7     // Catch:{ all -> 0x0133 }
            r0.<init>()     // Catch:{ all -> 0x0133 }
            r9.registerActivityLifecycleCallbacks(r0)     // Catch:{ all -> 0x0133 }
            r7.f36230m = r0     // Catch:{ all -> 0x0133 }
        L_0x0124:
            java.lang.String r9 = "StartApp SDK initialized"
            com.startapp.lb.a((android.content.Context) r8, (boolean) r2, (java.lang.String) r9, (boolean) r3)     // Catch:{ all -> 0x0133 }
            goto L_0x0137
        L_0x012a:
            r9 = move-exception
            if (r5 == 0) goto L_0x0132
            java.util.concurrent.locks.Lock r0 = r1.f36420d     // Catch:{ all -> 0x0133 }
            r0.unlock()     // Catch:{ all -> 0x0133 }
        L_0x0132:
            throw r9     // Catch:{ all -> 0x0133 }
        L_0x0133:
            r9 = move-exception
            com.startapp.y8.a((android.content.Context) r8, (java.lang.Throwable) r9)
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.StartAppSDKInternal.a(android.content.Context, com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest$RequestReason):void");
    }

    public class b implements da {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f36249a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ComponentLocator f36250b;

        public b(Context context, ComponentLocator componentLocator) {
            this.f36249a = context;
            this.f36250b = componentLocator;
        }

        public void a(MetaDataRequest.RequestReason requestReason, boolean z2) {
            StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.this;
            Context context = this.f36249a;
            startAppSDKInternal.getClass();
            ce l2 = ComponentLocator.a(context).l();
            Class<ea> cls = ea.class;
            boolean z3 = false;
            int i2 = 1;
            if (MetaData.f36379h.S()) {
                fe.a aVar = new fe.a(cls);
                aVar.f34539d = Long.valueOf(((long) MetaData.f36379h.x()) * 60000);
                aVar.f36521b = JobRequest.Network.f36517b;
                l2.a(new fe(aVar));
            } else {
                l2.a(JobRequest.a((Class<? extends be>[]) new Class[]{cls}));
            }
            StartAppSDKInternal startAppSDKInternal2 = StartAppSDKInternal.this;
            Context context2 = this.f36249a;
            startAppSDKInternal2.getClass();
            ce l3 = ComponentLocator.a(context2).l();
            Class<tb> cls2 = tb.class;
            if (MetaData.f36379h.R()) {
                fe.a aVar2 = new fe.a(cls2);
                aVar2.f34539d = Long.valueOf(((long) MetaData.f36379h.b(context2)) * 60000);
                aVar2.f36521b = JobRequest.Network.f36517b;
                l3.a(new fe(aVar2));
            } else {
                l3.a(JobRequest.a((Class<? extends be>[]) new Class[]{cls2}));
            }
            StartAppSDKInternal startAppSDKInternal3 = StartAppSDKInternal.this;
            Context context3 = this.f36249a;
            startAppSDKInternal3.getClass();
            ce l4 = ComponentLocator.a(context3).l();
            MetaData metaData = MetaData.f36379h;
            Class<sb> cls3 = sb.class;
            if (!metaData.R() || !metaData.Q()) {
                l4.a(JobRequest.a((Class<? extends be>[]) new Class[]{cls3}));
            } else {
                long millis = TimeUnit.SECONDS.toMillis((long) metaData.a(context3));
                fe.a aVar3 = new fe.a(cls3);
                aVar3.f34539d = Long.valueOf(millis);
                aVar3.f36521b = JobRequest.Network.f36517b;
                aVar3.f36522c = true;
                l4.a(new fe(aVar3));
            }
            StartAppSDKInternal startAppSDKInternal4 = StartAppSDKInternal.this;
            Context context4 = this.f36249a;
            startAppSDKInternal4.getClass();
            ComponentLocator a2 = ComponentLocator.a(context4);
            x6 d2 = a2.d();
            if (d2.getBoolean("shared_prefs_first_init", true)) {
                x6.a a3 = d2.edit();
                a3.a("totalSessions", 0);
                a3.f36915a.putInt("totalSessions", 0);
                long currentTimeMillis = System.currentTimeMillis();
                a3.a("firstSessionTime", Long.valueOf(currentTimeMillis));
                a3.f36915a.putLong("firstSessionTime", currentTimeMillis);
                a3.apply();
                a2.o().execute(new f7(startAppSDKInternal4, context4, a2, d2));
            }
            StartAppSDKInternal.f(this.f36249a);
            StartAppSDKInternal.this.getClass();
            Context context5 = this.f36249a;
            if (ComponentLocator.a(context5).f().c()) {
                NetworkTestsMetaData v2 = MetaData.f36379h.v();
                ce l5 = ComponentLocator.a(context5).l();
                boolean z4 = hc.a(context5, "android.permission.ACCESS_FINE_LOCATION") || hc.a(context5, "android.permission.ACCESS_COARSE_LOCATION");
                Class<yd> cls4 = yd.class;
                if (v2 == null || !v2.n() || !z4) {
                    l5.a(JobRequest.a((Class<? extends be>[]) new Class[]{cls4}));
                    NetworkTester.stopListening();
                    BackgroundService.a(context5, false);
                } else {
                    if (Math.random() < v2.j()) {
                        l2.a((l2.a) new xd(context5));
                    }
                    try {
                        BackgroundService.a(context5, v2.o());
                        NetworkTester.Config config = new NetworkTester.Config();
                        config.PROJECT_ID = v2.k();
                        config.CONNECTIVITY_TEST_HOSTNAME = v2.c();
                        config.CONNECTIVITY_TEST_FILENAME = v2.b();
                        config.CONNECTIVITY_TEST_ENABLED = v2.l();
                        config.NIR_COLLECT_CELLINFO = v2.p();
                        config.CT_COLLECT_CELLINFO = v2.m();
                        config.CONNECTIVITY_TEST_CDNCONFIG_URL = v2.a();
                        config.GEOIP_URL = v2.e();
                        wd wdVar = new wd(ia.b(context5));
                        NetworkTester.init(context5, config);
                        NetworkTester.setOnConnectivityLatencyListener(wdVar);
                        NetworkTester.setOnNetworkInfoListener(wdVar);
                        NetworkTester.startListening(v2.d(), v2.f());
                        fe.a aVar4 = new fe.a(cls4);
                        aVar4.f34539d = Long.valueOf(v2.d());
                        aVar4.f36521b = JobRequest.Network.f36517b;
                        l5.a(new fe(aVar4));
                    } catch (Throwable th) {
                        y8.a(context5, th);
                    }
                }
            }
            StartAppSDKInternal startAppSDKInternal5 = StartAppSDKInternal.this;
            Context context6 = this.f36249a;
            if (startAppSDKInternal5.D == null) {
                bf b2 = ComponentLocator.a(context6).f36440n.b();
                startAppSDKInternal5.D = b2;
                b2.b();
            }
            oe q2 = this.f36250b.q();
            q2.getClass();
            try {
                if (!q2.b()) {
                    q2.f35576c.execute(new pe(q2));
                }
            } catch (Throwable th2) {
                y8.a(q2.f35575b, th2);
            }
            qe p2 = this.f36250b.p();
            List<re> a4 = p2.a();
            if (p2.a(1024)) {
                y8 y8Var = new y8(z8.f36995b);
                y8Var.f36954d = "RSC init";
                StringBuilder sb = new StringBuilder();
                sb.append("targets: ");
                sb.append(a4 != null ? Integer.valueOf(a4.size()) : null);
                y8Var.f36955e = sb.toString();
                y8Var.a(p2.f35723a);
            }
            je n2 = this.f36250b.n();
            MotionMetadata a5 = n2.a();
            if (a5 != null) {
                if (Math.random() < a5.k()) {
                    z3 = true;
                }
                n2.f34781g = z3;
            }
            n2.f34779e.post(new ke(n2));
            rb b3 = this.f36250b.b();
            if (!z2) {
                i2 = 2;
            }
            b3.a(i2, StartAppSDKInternal.this.E);
        }

        public void a(MetaDataRequest.RequestReason requestReason) {
            this.f36250b.b().a(0, StartAppSDKInternal.this.E);
        }
    }

    public static void a(Context context, boolean z2, xb xbVar) {
        y8 y8Var = new y8(z8.f37002i);
        y8Var.f36960j = z2;
        y8Var.a(context, (d9) new a(xbVar));
    }

    public final boolean a(Activity activity) {
        return this.A || activity.getClass().getName().equals(lb.c((Context) activity));
    }

    public boolean a(String str) {
        String str2;
        Map<String, String> map = this.f36236s;
        if (map == null) {
            str2 = null;
        } else {
            str2 = map.get(str);
        }
        return str2 != null;
    }

    public void a(boolean z2) {
        if (!z2 || !hc.a()) {
            this.f36240w = false;
            d8.f34354a.b(AdPreferences.Placement.INAPP_RETURN);
            return;
        }
        this.f36240w = true;
    }
}
