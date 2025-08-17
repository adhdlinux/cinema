package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.adcolony.sdk.e0;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import org.joda.time.DateTimeConstants;

@SuppressLint({"ObsoleteSdkInt"})
class q {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final f f13326a = new f();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final f f13327b = new f();

    /* renamed from: c  reason: collision with root package name */
    private String f13328c = "";

    /* renamed from: d  reason: collision with root package name */
    private boolean f13329d;

    /* renamed from: e  reason: collision with root package name */
    private String f13330e = "";

    /* renamed from: f  reason: collision with root package name */
    private f1 f13331f = c0.q();

    /* renamed from: g  reason: collision with root package name */
    private String f13332g = "";

    class a implements j0 {

        /* renamed from: com.adcolony.sdk.q$a$a  reason: collision with other inner class name */
        class C0003a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13333b;

            /* renamed from: com.adcolony.sdk.q$a$a$a  reason: collision with other inner class name */
            class C0004a implements Runnable {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ f1 f13334b;

                C0004a(f1 f1Var) {
                    this.f13334b = f1Var;
                }

                public void run() {
                    C0003a.this.f13333b.b(this.f13334b).e();
                }
            }

            C0003a(a aVar, h0 h0Var) {
                this.f13333b = h0Var;
            }

            public void run() {
                z0.A(new C0004a(a.f().x0().C(2000)));
            }
        }

        a(q qVar) {
        }

        public void a(h0 h0Var) {
            if (!z0.m(new C0003a(this, h0Var))) {
                new e0.a().c("Error retrieving device info, disabling AdColony.").d(e0.f13114i);
                AdColony.f();
            }
        }
    }

    class b implements Callable<f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f13336b;

        b(long j2) {
            this.f13336b = j2;
        }

        /* renamed from: b */
        public f1 call() {
            if (!q.this.n() && this.f13336b > 0) {
                q.this.f13326a.a(this.f13336b);
            }
            return q.this.x();
        }
    }

    class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13338b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ y f13339c;

        c(Context context, y yVar) {
            this.f13338b = context;
            this.f13339c = yVar;
        }

        public void run() {
            boolean z2;
            String str;
            if (a.f12896e) {
                str = "00000000-0000-0000-0000-000000000000";
                z2 = true;
            } else {
                str = null;
                z2 = false;
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f13338b);
                    str = advertisingIdInfo.getId();
                    z2 = advertisingIdInfo.isLimitAdTrackingEnabled();
                } catch (NoClassDefFoundError unused) {
                    new e0.a().c("Google Play Services Ads dependencies are missing.").d(e0.f13111f);
                } catch (NoSuchMethodError unused2) {
                    new e0.a().c("Google Play Services is out of date, please update to GPS 4.0+.").d(e0.f13111f);
                } catch (Exception e2) {
                    new e0.a().c("Query Advertising ID failed with: ").c(Log.getStackTraceString(e2)).d(e0.f13112g);
                }
                if (str == null && Build.MANUFACTURER.equals("Amazon")) {
                    str = q.this.I();
                    z2 = q.this.J();
                }
            }
            if (str == null) {
                new e0.a().c("Advertising ID is not available. ").c("Collecting Android ID instead of Advertising ID.").d(e0.f13111f);
                y yVar = this.f13339c;
                if (yVar != null) {
                    yVar.a(new Throwable("Advertising ID is not available."));
                }
            } else {
                q.this.v(str);
                s0 c2 = a.f().D0().c();
                if (c2 != null) {
                    c2.f13376d.put("advertisingId", q.this.H());
                }
                q.this.E(z2);
                y yVar2 = this.f13339c;
                if (yVar2 != null) {
                    yVar2.a(q.this.H());
                }
            }
            q.this.w(true);
        }
    }

    class d implements Callable<f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f13341b;

        d(long j2) {
            this.f13341b = j2;
        }

        /* renamed from: b */
        public f1 call() {
            if (!q.this.o() && this.f13341b > 0) {
                q.this.f13327b.a(this.f13341b);
            }
            return q.this.B();
        }
    }

    q() {
    }

    /* access modifiers changed from: package-private */
    public void A(boolean z2) {
        this.f13327b.b(z2);
    }

    /* access modifiers changed from: package-private */
    public f1 B() {
        f1 q2 = c0.q();
        c0.n(q2, "app_set_id", M());
        return q2;
    }

    /* access modifiers changed from: package-private */
    public f1 C(long j2) {
        if (j2 <= 0) {
            return c0.h(F(), x(), B());
        }
        ArrayList arrayList = new ArrayList(Collections.singletonList(F()));
        q0 q0Var = new q0();
        if (n()) {
            arrayList.add(x());
        } else {
            q0Var.c(s(j2));
        }
        if (o()) {
            arrayList.add(B());
        } else {
            q0Var.c(z(j2));
        }
        if (!q0Var.d()) {
            arrayList.addAll(q0Var.a());
        }
        return c0.h((f1[]) arrayList.toArray(new f1[0]));
    }

    /* access modifiers changed from: package-private */
    public void D(String str) {
        this.f13332g = str;
    }

    /* access modifiers changed from: package-private */
    public void E(boolean z2) {
        this.f13329d = z2;
    }

    /* access modifiers changed from: package-private */
    public f1 F() {
        f1 q2 = c0.q();
        k f2 = a.f();
        c0.n(q2, "carrier_name", O());
        c0.n(q2, "data_path", f2.O0().f());
        c0.u(q2, "device_api", L());
        Rect Y = Y();
        c0.u(q2, "screen_width", Y.width());
        c0.u(q2, "screen_height", Y.height());
        c0.u(q2, "display_dpi", X());
        c0.n(q2, "device_type", W());
        c0.n(q2, "locale_language_code", a0());
        c0.n(q2, "ln", a0());
        c0.n(q2, "locale_country_code", R());
        c0.n(q2, Constants.LOCALE, R());
        c0.n(q2, "mac_address", b());
        c0.n(q2, "manufacturer", c());
        c0.n(q2, "device_brand", c());
        c0.n(q2, "media_path", f2.O0().h());
        c0.n(q2, "temp_storage_path", f2.O0().j());
        c0.u(q2, "memory_class", d());
        c0.v(q2, "memory_used_mb", e());
        c0.n(q2, "model", f());
        c0.n(q2, "device_model", f());
        c0.n(q2, "sdk_type", "android_native");
        c0.n(q2, "sdk_version", i());
        c0.n(q2, "network_type", f2.H0().h());
        c0.n(q2, "os_version", h());
        c0.n(q2, "os_name", "android");
        c0.n(q2, "platform", "android");
        c0.n(q2, "arch", r());
        c0.n(q2, "user_id", c0.E(f2.L0().c(), "user_id"));
        c0.n(q2, "app_id", f2.L0().b());
        c0.n(q2, "app_bundle_name", z0.v());
        c0.n(q2, "app_bundle_version", z0.B());
        c0.k(q2, "battery_level", N());
        c0.n(q2, "cell_service_country_code", j());
        c0.n(q2, "timezone_ietf", l());
        c0.u(q2, "timezone_gmt_m", k());
        c0.u(q2, "timezone_dst_m", S());
        c0.m(q2, "launch_metadata", b0());
        c0.n(q2, "controller_version", f2.h0());
        c0.u(q2, "current_orientation", g());
        c0.w(q2, "cleartext_permitted", P());
        c0.k(q2, "density", (double) U());
        c0.w(q2, "dark_mode", T());
        c0.n(q2, "adc_alt_id", G());
        e1 c2 = c0.c();
        if (z0.D("com.android.vending")) {
            c2.g("google");
        }
        if (z0.D("com.amazon.venezia")) {
            c2.g("amazon");
        }
        if (z0.D("com.huawei.appmarket")) {
            c2.g("huawei");
        }
        if (z0.D("com.sec.android.app.samsungapps")) {
            c2.g("samsung");
        }
        c0.l(q2, "available_stores", c2);
        return q2;
    }

    /* access modifiers changed from: package-private */
    public String G() {
        return z0.h(a.f().O0());
    }

    /* access modifiers changed from: package-private */
    public String H() {
        return this.f13328c;
    }

    /* access modifiers changed from: package-private */
    public String I() {
        Context a2 = a.a();
        if (a2 == null) {
            return null;
        }
        return Settings.Secure.getString(a2.getContentResolver(), "advertising_id");
    }

    /* access modifiers changed from: package-private */
    public boolean J() {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(a2.getContentResolver(), "limit_ad_tracking") != 0) {
                return true;
            }
            return false;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"HardwareIds"})
    public String K() {
        Context a2 = a.a();
        if (a2 == null) {
            return "";
        }
        return Settings.Secure.getString(a2.getContentResolver(), "android_id");
    }

    /* access modifiers changed from: package-private */
    public int L() {
        return Build.VERSION.SDK_INT;
    }

    public String M() {
        return this.f13330e;
    }

    /* access modifiers changed from: package-private */
    public double N() {
        Context a2 = a.a();
        if (a2 == null) {
            return 0.0d;
        }
        try {
            Intent registerReceiver = a2.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return 0.0d;
            }
            int intExtra = registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra < 0 || intExtra2 < 0) {
                return 0.0d;
            }
            return ((double) intExtra) / ((double) intExtra2);
        } catch (RuntimeException unused) {
            return 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    public String O() {
        Context a2 = a.a();
        String str = "";
        if (a2 == null) {
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) a2.getSystemService("phone");
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkOperatorName();
        }
        if (str.length() == 0) {
            return "unknown";
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public boolean P() {
        if (Build.VERSION.SDK_INT < 23 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String Q() {
        return this.f13332g;
    }

    /* access modifiers changed from: package-private */
    public String R() {
        return Locale.getDefault().getCountry();
    }

    /* access modifiers changed from: package-private */
    public int S() {
        TimeZone timeZone = TimeZone.getDefault();
        if (!timeZone.inDaylightTime(new Date())) {
            return 0;
        }
        return timeZone.getDSTSavings() / DateTimeConstants.MILLIS_PER_MINUTE;
    }

    /* access modifiers changed from: package-private */
    public boolean T() {
        int i2;
        Context a2 = a.a();
        if (a2 == null || Build.VERSION.SDK_INT < 29 || (i2 = a2.getResources().getConfiguration().uiMode & 48) == 16 || i2 != 32) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public float U() {
        Context a2 = a.a();
        if (a2 == null) {
            return 0.0f;
        }
        return a2.getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: package-private */
    public f1 V() {
        if (!n()) {
            try {
                return z0.u(c0.h(F(), s(2000).call()));
            } catch (Exception unused) {
            }
        }
        return z0.u(c0.h(F(), x()));
    }

    /* access modifiers changed from: package-private */
    public String W() {
        return p() ? "tablet" : "phone";
    }

    /* access modifiers changed from: package-private */
    public int X() {
        Context a2 = a.a();
        if (a2 != null) {
            return a2.getResources().getConfiguration().densityDpi;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public Rect Y() {
        Rect rect = new Rect();
        Context a2 = a.a();
        if (a2 == null) {
            return rect;
        }
        try {
            WindowManager windowManager = (WindowManager) a2.getSystemService("window");
            if (windowManager == null) {
                return rect;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (RuntimeException unused) {
            return rect;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r1 = com.adcolony.sdk.s1.a(com.adcolony.sdk.r1.a(r2), (android.view.WindowInsets.Type.navigationBars() | android.view.WindowInsets.Type.displayCutout()) | android.view.WindowInsets.Type.statusBars());
        r1 = new android.graphics.Rect(0, 0, com.adcolony.sdk.p1.a(r2).width() - (r1.right + r1.left), com.adcolony.sdk.p1.a(r2).height() - (r1.top + r1.bottom));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00b7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Rect Z() {
        /*
            r8 = this;
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.content.Context r1 = com.adcolony.sdk.a.a()
            if (r1 == 0) goto L_0x00f7
            java.lang.String r2 = "window"
            java.lang.Object r2 = r1.getSystemService(r2)     // Catch:{ RuntimeException -> 0x00f7 }
            android.view.WindowManager r2 = (android.view.WindowManager) r2     // Catch:{ RuntimeException -> 0x00f7 }
            if (r2 == 0) goto L_0x00f7
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ RuntimeException -> 0x00f7 }
            r4 = 30
            r5 = 0
            if (r3 >= r4) goto L_0x006c
            android.util.DisplayMetrics r3 = new android.util.DisplayMetrics     // Catch:{ RuntimeException -> 0x00f7 }
            r3.<init>()     // Catch:{ RuntimeException -> 0x00f7 }
            android.util.DisplayMetrics r4 = new android.util.DisplayMetrics     // Catch:{ RuntimeException -> 0x00f7 }
            r4.<init>()     // Catch:{ RuntimeException -> 0x00f7 }
            android.view.Display r2 = r2.getDefaultDisplay()     // Catch:{ RuntimeException -> 0x00f7 }
            r2.getMetrics(r3)     // Catch:{ RuntimeException -> 0x00f7 }
            r2.getRealMetrics(r4)     // Catch:{ RuntimeException -> 0x00f7 }
            int r2 = com.adcolony.sdk.z0.K(r1)     // Catch:{ RuntimeException -> 0x00f7 }
            int r1 = com.adcolony.sdk.z0.r(r1)     // Catch:{ RuntimeException -> 0x00f7 }
            int r6 = r4.heightPixels     // Catch:{ RuntimeException -> 0x00f7 }
            int r7 = r3.heightPixels     // Catch:{ RuntimeException -> 0x00f7 }
            int r6 = r6 - r7
            if (r6 > 0) goto L_0x004b
            android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ RuntimeException -> 0x00f7 }
            int r4 = r3.widthPixels     // Catch:{ RuntimeException -> 0x00f7 }
            int r3 = r3.heightPixels     // Catch:{ RuntimeException -> 0x00f7 }
            int r3 = r3 - r2
            r1.<init>(r5, r5, r4, r3)     // Catch:{ RuntimeException -> 0x00f7 }
            goto L_0x00f6
        L_0x004b:
            if (r1 <= 0) goto L_0x0060
            if (r6 > r2) goto L_0x0052
            if (r1 <= r2) goto L_0x0052
            goto L_0x0060
        L_0x0052:
            android.graphics.Rect r6 = new android.graphics.Rect     // Catch:{ RuntimeException -> 0x00f7 }
            int r3 = r3.widthPixels     // Catch:{ RuntimeException -> 0x00f7 }
            int r4 = r4.heightPixels     // Catch:{ RuntimeException -> 0x00f7 }
            int r1 = r1 + r2
            int r4 = r4 - r1
            r6.<init>(r5, r5, r3, r4)     // Catch:{ RuntimeException -> 0x00f7 }
            r0 = r6
            goto L_0x00f7
        L_0x0060:
            android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ RuntimeException -> 0x00f7 }
            int r3 = r3.widthPixels     // Catch:{ RuntimeException -> 0x00f7 }
            int r4 = r4.heightPixels     // Catch:{ RuntimeException -> 0x00f7 }
            int r4 = r4 - r2
            r1.<init>(r5, r5, r3, r4)     // Catch:{ RuntimeException -> 0x00f7 }
            goto L_0x00f6
        L_0x006c:
            android.view.WindowMetrics r2 = r2.getCurrentWindowMetrics()     // Catch:{ RuntimeException -> 0x00f7 }
            android.graphics.Point r3 = new android.graphics.Point     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            r3.<init>()     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            android.graphics.Point r4 = new android.graphics.Point     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            r4.<init>()     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            android.view.Display r1 = r1.getDisplay()     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            r1.getCurrentSizeRange(r3, r4)     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            android.graphics.Rect r1 = r2.getBounds()     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            int r1 = r1.width()     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            android.graphics.Rect r6 = r2.getBounds()     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            int r6 = r6.height()     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            r7 = 2
            if (r1 <= r6) goto L_0x0096
            r1 = 2
            goto L_0x0097
        L_0x0096:
            r1 = 1
        L_0x0097:
            if (r1 != r7) goto L_0x00a3
            android.graphics.Point r1 = new android.graphics.Point     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            int r4 = r4.x     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            int r3 = r3.y     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            r1.<init>(r4, r3)     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            goto L_0x00ac
        L_0x00a3:
            android.graphics.Point r1 = new android.graphics.Point     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            int r3 = r3.x     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            int r4 = r4.y     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            r1.<init>(r3, r4)     // Catch:{ UnsupportedOperationException -> 0x00b7 }
        L_0x00ac:
            android.graphics.Rect r3 = new android.graphics.Rect     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            int r4 = r1.x     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            int r1 = r1.y     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            r3.<init>(r5, r5, r4, r1)     // Catch:{ UnsupportedOperationException -> 0x00b7 }
            r0 = r3
            goto L_0x00f7
        L_0x00b7:
            android.view.WindowInsets r1 = r2.getWindowInsets()     // Catch:{ RuntimeException -> 0x00f7 }
            int r3 = android.view.WindowInsets.Type.navigationBars()     // Catch:{ RuntimeException -> 0x00f7 }
            int r4 = android.view.WindowInsets.Type.displayCutout()     // Catch:{ RuntimeException -> 0x00f7 }
            r3 = r3 | r4
            int r4 = android.view.WindowInsets.Type.statusBars()     // Catch:{ RuntimeException -> 0x00f7 }
            r3 = r3 | r4
            android.graphics.Insets r1 = r1.getInsetsIgnoringVisibility(r3)     // Catch:{ RuntimeException -> 0x00f7 }
            android.graphics.Rect r3 = r2.getBounds()     // Catch:{ RuntimeException -> 0x00f7 }
            int r3 = r3.width()     // Catch:{ RuntimeException -> 0x00f7 }
            int r4 = r1.right     // Catch:{ RuntimeException -> 0x00f7 }
            int r6 = r1.left     // Catch:{ RuntimeException -> 0x00f7 }
            int r4 = r4 + r6
            int r3 = r3 - r4
            android.graphics.Rect r2 = r2.getBounds()     // Catch:{ RuntimeException -> 0x00f7 }
            int r2 = r2.height()     // Catch:{ RuntimeException -> 0x00f7 }
            int r4 = r1.top     // Catch:{ RuntimeException -> 0x00f7 }
            int r1 = r1.bottom     // Catch:{ RuntimeException -> 0x00f7 }
            int r4 = r4 + r1
            int r2 = r2 - r4
            android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ RuntimeException -> 0x00f7 }
            r1.<init>(r5, r5, r3, r2)     // Catch:{ RuntimeException -> 0x00f7 }
        L_0x00f6:
            r0 = r1
        L_0x00f7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.q.Z():android.graphics.Rect");
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f13329d;
    }

    /* access modifiers changed from: package-private */
    public String a0() {
        return Locale.getDefault().getLanguage();
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return "";
    }

    /* access modifiers changed from: package-private */
    public f1 b0() {
        return this.f13331f;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return Build.MANUFACTURER;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        ActivityManager activityManager;
        Context a2 = a.a();
        if (a2 == null || (activityManager = (ActivityManager) a2.getSystemService("activity")) == null) {
            return 0;
        }
        return activityManager.getMemoryClass();
    }

    /* access modifiers changed from: package-private */
    public long e() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / ((long) 1048576);
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return Build.MODEL;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SwitchIntDef"})
    public int g() {
        Context a2 = a.a();
        if (a2 == null) {
            return 2;
        }
        int i2 = a2.getResources().getConfiguration().orientation;
        if (i2 == 1) {
            return 0;
        }
        if (i2 != 2) {
            return 2;
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public String h() {
        return Build.VERSION.RELEASE;
    }

    /* access modifiers changed from: package-private */
    public String i() {
        return "4.8.0";
    }

    /* access modifiers changed from: package-private */
    public String j() {
        TelephonyManager telephonyManager;
        Context a2 = a.a();
        if (a2 == null || (telephonyManager = (TelephonyManager) a2.getSystemService("phone")) == null) {
            return "";
        }
        return telephonyManager.getSimCountryIso();
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return TimeZone.getDefault().getOffset(15) / DateTimeConstants.MILLIS_PER_MINUTE;
    }

    /* access modifiers changed from: package-private */
    public String l() {
        return TimeZone.getDefault().getID();
    }

    /* access modifiers changed from: package-private */
    public void m() {
        w(false);
        A(false);
        a.e("Device.get_info", new a(this));
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.f13326a.c();
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f13327b.c();
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        DisplayMetrics displayMetrics = a2.getResources().getDisplayMetrics();
        float f2 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
        float f3 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
        if (Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= 6.0d) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String r() {
        return System.getProperty("os.arch").toLowerCase(Locale.ENGLISH);
    }

    /* access modifiers changed from: package-private */
    public Callable<f1> s(long j2) {
        return new b(j2);
    }

    /* access modifiers changed from: package-private */
    public void t(Context context, y<String> yVar) {
        if (context != null) {
            if (H().isEmpty()) {
                w(false);
            }
            if (!z0.m(new c(context, yVar))) {
                new e0.a().c("Executing Query Advertising ID failed.").d(e0.f13114i);
                if (yVar != null) {
                    yVar.a(new Throwable("Query Advertising ID failed on execute."));
                }
            } else {
                return;
            }
        } else if (yVar != null) {
            yVar.a(new Throwable("Context cannot be null."));
        }
        w(true);
    }

    /* access modifiers changed from: package-private */
    public void u(f1 f1Var) {
        this.f13331f = f1Var;
    }

    /* access modifiers changed from: package-private */
    public void v(String str) {
        this.f13328c = str;
    }

    /* access modifiers changed from: package-private */
    public void w(boolean z2) {
        this.f13326a.b(z2);
    }

    /* access modifiers changed from: package-private */
    public f1 x() {
        f1 q2 = c0.q();
        String H = H();
        c0.n(q2, "advertiser_id", H);
        c0.w(q2, "limit_tracking", a());
        if (H == null || H.isEmpty()) {
            c0.n(q2, "android_id_sha1", z0.x(K()));
        }
        return q2;
    }

    /* access modifiers changed from: package-private */
    public Callable<f1> z(long j2) {
        return new d(j2);
    }
}
