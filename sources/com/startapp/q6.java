package com.startapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.hermes.intl.Constants;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.components.ComponentLocator;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public abstract class q6 {

    /* renamed from: a  reason: collision with root package name */
    public static final Collection<Integer> f35649a;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L = "android";
    public int M;
    public int N;
    public float O;
    public Boolean P;
    public int Q = 3;
    public String R;
    public String S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public String Y;
    public String Z;

    /* renamed from: a0  reason: collision with root package name */
    public final int f35650a0;

    /* renamed from: b  reason: collision with root package name */
    public String f35651b;

    /* renamed from: b0  reason: collision with root package name */
    public Long f35652b0;

    /* renamed from: c  reason: collision with root package name */
    public String f35653c;

    /* renamed from: c0  reason: collision with root package name */
    public Integer f35654c0;

    /* renamed from: d  reason: collision with root package name */
    public String f35655d = "4.10.0";

    /* renamed from: d0  reason: collision with root package name */
    public Boolean f35656d0;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f35657e = new TreeMap();

    /* renamed from: e0  reason: collision with root package name */
    public Boolean f35658e0;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, ?> f35659f;

    /* renamed from: f0  reason: collision with root package name */
    public Boolean f35660f0;

    /* renamed from: g  reason: collision with root package name */
    public String f35661g;

    /* renamed from: g0  reason: collision with root package name */
    public Boolean f35662g0;

    /* renamed from: h  reason: collision with root package name */
    public yb f35663h;

    /* renamed from: i  reason: collision with root package name */
    public String f35664i;

    /* renamed from: j  reason: collision with root package name */
    public String f35665j;

    /* renamed from: k  reason: collision with root package name */
    public String f35666k;

    /* renamed from: l  reason: collision with root package name */
    public String f35667l;

    /* renamed from: m  reason: collision with root package name */
    public String f35668m;

    /* renamed from: n  reason: collision with root package name */
    public String f35669n;

    /* renamed from: o  reason: collision with root package name */
    public String f35670o;

    /* renamed from: p  reason: collision with root package name */
    public String f35671p;

    /* renamed from: q  reason: collision with root package name */
    public String f35672q;

    /* renamed from: r  reason: collision with root package name */
    public Boolean f35673r;

    /* renamed from: s  reason: collision with root package name */
    public Boolean f35674s;

    /* renamed from: t  reason: collision with root package name */
    public String f35675t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f35676u;

    /* renamed from: v  reason: collision with root package name */
    public int f35677v;

    /* renamed from: w  reason: collision with root package name */
    public String f35678w;

    /* renamed from: x  reason: collision with root package name */
    public String f35679x;

    /* renamed from: y  reason: collision with root package name */
    public String f35680y;

    /* renamed from: z  reason: collision with root package name */
    public String f35681z;

    static {
        ArrayList arrayList = new ArrayList();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            arrayList.add(23);
        }
        if (i2 >= 26) {
            arrayList.add(22);
        }
        if (i2 >= 23) {
            arrayList.add(3);
            arrayList.add(4);
            arrayList.add(7);
            arrayList.add(8);
        }
        f35649a = Collections.unmodifiableCollection(arrayList);
    }

    public q6(int i2) {
        new HashMap();
        this.f35650a0 = i2;
    }

    public void a(String str) {
        this.Z = str;
    }

    public boolean a() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0097, code lost:
        r0 = r0.getActiveNetworkInfo();
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010c A[SYNTHETIC, Splitter:B:41:0x010c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r5, com.startapp.sdk.adsbase.model.AdPreferences r6) {
        /*
            r4 = this;
            com.startapp.hb r0 = com.startapp.hb.f34639a
            java.lang.String r0 = r0.f34640b
            r4.R = r0
            java.lang.String r0 = android.os.Build.MANUFACTURER
            r4.f35668m = r0
            java.lang.String r0 = android.os.Build.MODEL
            r4.f35667l = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r0 = java.lang.Integer.toString(r0)
            r4.f35669n = r0
            if (r6 == 0) goto L_0x001e
            java.lang.String r6 = r6.getAge(r5)
            r4.f35661g = r6
        L_0x001e:
            com.startapp.sdk.components.ComponentLocator r6 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r5)
            com.startapp.jc<com.startapp.md> r6 = r6.f36443q
            java.lang.Object r6 = r6.b()
            com.startapp.md r6 = (com.startapp.md) r6
            java.lang.Object r6 = r6.b()
            com.startapp.ld r6 = (com.startapp.ld) r6
            java.lang.String r6 = r6.f34878a
            r4.f35665j = r6
            int r6 = com.startapp.hc.f34643a
            r6 = 0
            r0 = 0
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = r5.getPackageName()     // Catch:{ all -> 0x0047 }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r0)     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = r1.versionName     // Catch:{ all -> 0x0047 }
            goto L_0x0048
        L_0x0047:
            r1 = r6
        L_0x0048:
            r4.S = r1
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = r5.getPackageName()     // Catch:{ all -> 0x0059 }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r0)     // Catch:{ all -> 0x0059 }
            int r1 = r1.versionCode     // Catch:{ all -> 0x0059 }
            goto L_0x005a
        L_0x0059:
            r1 = 0
        L_0x005a:
            r4.T = r1
            boolean r1 = com.startapp.hc.b((android.content.Context) r5)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r4.f35673r = r1
            android.content.ContentResolver r1 = r5.getContentResolver()     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "adb_enabled"
            int r1 = android.provider.Settings.Global.getInt(r1, r2, r0)     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x0074
            r1 = 1
            goto L_0x0075
        L_0x0074:
            r1 = 0
        L_0x0075:
            r4.U = r1
            boolean r0 = com.startapp.p.a((android.content.Context) r5)     // Catch:{ all -> 0x007c }
            goto L_0x007d
        L_0x007c:
        L_0x007d:
            r4.V = r0
            boolean r0 = com.startapp.hc.c(r5)
            r4.W = r0
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r5.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            if (r0 == 0) goto L_0x00ac
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = com.startapp.hc.a((android.content.Context) r5, (java.lang.String) r1)
            if (r1 == 0) goto L_0x00ac
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            if (r0 == 0) goto L_0x00ac
            boolean r1 = r0.isConnected()
            if (r1 == 0) goto L_0x00ac
            boolean r0 = r0.isRoaming()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x00ad
        L_0x00ac:
            r0 = r6
        L_0x00ad:
            r4.f35674s = r0
            boolean r0 = com.startapp.lb.f(r5)
            r4.X = r0
            android.content.res.Resources r0 = r5.getResources()
            if (r0 == 0) goto L_0x00cd
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            if (r0 == 0) goto L_0x00cd
            int r1 = r0.widthPixels
            r4.M = r1
            int r1 = r0.heightPixels
            r4.N = r1
            float r0 = r0.density
            r4.O = r0
        L_0x00cd:
            com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r5)
            com.startapp.id r1 = r0.m()
            java.lang.Object r1 = r1.b()
            com.startapp.hd r1 = (com.startapp.hd) r1
            java.lang.String r2 = r1.f34645b
            r4.f35670o = r2
            java.lang.String r1 = r1.f34646c
            r4.f35671p = r1
            com.startapp.jc<com.startapp.gd> r1 = r0.f36432f
            java.lang.Object r1 = r1.b()
            com.startapp.gd r1 = (com.startapp.gd) r1
            java.lang.Object r1 = r1.b()
            com.startapp.fd r1 = (com.startapp.fd) r1
            java.lang.String r1 = r1.f34537b
            r4.f35672q = r1
            com.startapp.x6 r0 = r0.d()
            java.lang.String r1 = "USER_CONSENT_PERSONALIZED_ADS_SERVING"
            java.lang.String r1 = r0.getString(r1, r6)
            r4.Y = r1
            java.util.Map<java.lang.String, java.lang.String> r1 = r4.f35657e
            java.lang.String r2 = "sharedPrefsWrappers"
            java.lang.String r6 = r0.getString(r2, r6)
            if (r6 != 0) goto L_0x010c
            goto L_0x012b
        L_0x010c:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x012b }
            r0.<init>(r6)     // Catch:{ JSONException -> 0x012b }
            java.util.Iterator r6 = r0.keys()     // Catch:{ JSONException -> 0x012b }
        L_0x0115:
            boolean r2 = r6.hasNext()     // Catch:{ JSONException -> 0x012b }
            if (r2 == 0) goto L_0x012b
            java.lang.Object r2 = r6.next()     // Catch:{ JSONException -> 0x012b }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x012b }
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x012b }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x012b }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x012b }
            goto L_0x0115
        L_0x012b:
            boolean r5 = com.startapp.lb.e((android.content.Context) r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r4.P = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.q6.b(android.content.Context, com.startapp.sdk.adsbase.model.AdPreferences):void");
    }

    public void c(Context context) {
        boolean z2;
        if (this.f35653c != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            p6 c2 = ComponentLocator.a(context).c();
            String str = c2.f35609c;
            if (str == null) {
                synchronized (c2.f35607a) {
                    str = c2.f35609c;
                    if (str == null) {
                        str = c2.f35608b.getString("c88d4eab540fab77", (String) null);
                    }
                }
            }
            this.f35651b = str;
            String str2 = c2.f35610d;
            if (str2 == null) {
                synchronized (c2.f35607a) {
                    str2 = c2.f35610d;
                    if (str2 == null && (str2 = c2.f35608b.getString("2696a7f502faed4b", (String) null)) == null) {
                        str2 = c2.f35608b.getString("31721150b470a3b9", (String) null);
                    }
                }
            }
            this.f35653c = str2;
        }
        this.f35664i = context.getPackageName();
    }

    public void d(Context context) {
        String str;
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        String num;
        NetworkCapabilities networkCapabilities2;
        int i2 = 0;
        try {
            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager2 != null) {
                if (hc.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    str = "WIFI";
                    if (Build.VERSION.SDK_INT >= 23) {
                        Network a2 = connectivityManager2.getActiveNetwork();
                        if (!(a2 == null || (networkCapabilities2 = connectivityManager2.getNetworkCapabilities(a2)) == null)) {
                            if (!networkCapabilities2.hasTransport(1)) {
                                if (networkCapabilities2.hasTransport(0)) {
                                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                                    if (telephonyManager != null) {
                                        num = Integer.toString(telephonyManager.getNetworkType());
                                    }
                                    str = "e101";
                                }
                            }
                        }
                        str = "e102";
                    } else {
                        NetworkInfo activeNetworkInfo = connectivityManager2.getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            String typeName = activeNetworkInfo.getTypeName();
                            if (typeName.toLowerCase().compareTo(str.toLowerCase()) != 0) {
                                if (typeName.toLowerCase().compareTo("MOBILE".toLowerCase()) == 0) {
                                    TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
                                    if (telephonyManager2 != null) {
                                        num = Integer.toString(telephonyManager2.getNetworkType());
                                    }
                                    str = "e101";
                                }
                            }
                        }
                        str = "e102";
                    }
                    str = num;
                }
                str = "e105";
            } else {
                str = "e100";
            }
        } catch (Exception unused) {
        }
        this.f35675t = str;
        String str2 = ComponentLocator.a(context).t().f35801g;
        this.I = str2;
        this.f35678w = str2;
        r8 e2 = ComponentLocator.a(context).e();
        e2.getClass();
        try {
            if (hc.a(e2.f35764a, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) e2.f35764a.getSystemService("connectivity")) != null) {
                Network[] allNetworks = connectivityManager.getAllNetworks();
                if (allNetworks != null) {
                    int i3 = 0;
                    for (Network network : allNetworks) {
                        if (!(network == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null)) {
                            for (int i4 = 0; i4 <= 8; i4++) {
                                try {
                                    if (networkCapabilities.hasTransport(i4)) {
                                        i3 |= 1 << i4;
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                        }
                    }
                    i2 = i3;
                }
                this.f35677v = i2;
            }
        } catch (Throwable th) {
            y8.a(e2.f35764a, th);
        }
        i2 = -1;
        this.f35677v = i2;
    }

    public void e(Context context) {
        nd ndVar = (nd) ComponentLocator.a(context).s().b();
        if (ndVar.a(7) == 5) {
            this.f35679x = ndVar.b(8);
            this.f35680y = ndVar.b(9);
            this.f35681z = ndVar.b(15);
            this.A = ndVar.b(16);
        }
        int a2 = ndVar.a(10);
        if (!(a2 == 0 || a2 == 2)) {
            this.B = ndVar.b(11);
            this.C = ndVar.b(12);
        }
        this.D = ndVar.b(4);
        this.E = ndVar.b(3);
        this.F = ndVar.b(5);
        boolean z2 = true;
        this.G = ndVar.b(1);
        this.H = ndVar.b(2);
        this.J = ndVar.b(13);
        if (ndVar.a(14) != 1) {
            z2 = false;
        }
        this.f35676u = z2;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0006 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r1, com.startapp.sdk.adsbase.model.AdPreferences r2) {
        /*
            r0 = this;
            r0.c(r1)
            r0.b(r1, r2)     // Catch:{ all -> 0x0006 }
        L_0x0006:
            r0.d(r1)     // Catch:{ all -> 0x000a }
            goto L_0x000e
        L_0x000a:
            r2 = move-exception
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r2)
        L_0x000e:
            r0.e(r1)     // Catch:{ all -> 0x0012 }
            goto L_0x0016
        L_0x0012:
            r2 = move-exception
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r2)
        L_0x0016:
            com.startapp.sdk.components.ComponentLocator r2 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r1)     // Catch:{ all -> 0x0025 }
            com.startapp.qe r2 = r2.p()     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = r2.a((java.lang.Object) r0)     // Catch:{ all -> 0x0025 }
            r0.K = r2     // Catch:{ all -> 0x0025 }
            goto L_0x0029
        L_0x0025:
            r2 = move-exception
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r2)
        L_0x0029:
            r0.a((android.content.Context) r1)     // Catch:{ all -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r2 = move-exception
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r2)
        L_0x0031:
            r0.b(r1)     // Catch:{ all -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r2 = move-exception
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r2)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.q6.a(android.content.Context, com.startapp.sdk.adsbase.model.AdPreferences):void");
    }

    public void a(eb ebVar) throws SDKException {
        Map<String, ?> map = this.f35659f;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                ebVar.a((String) next.getKey(), next.getValue(), false, true);
            }
        }
        ebVar.a("publisherId", (Object) this.f35651b, false, true);
        ebVar.a(InAppPurchaseMetaData.KEY_PRODUCT_ID, (Object) this.f35653c, a(), true);
        ebVar.a("os", (Object) this.L, true, true);
        ebVar.a("sdkVersion", (Object) this.f35655d, false, true);
        ebVar.a("flavor", (Object) 1023, false, true);
        Map<String, String> map2 = this.f35657e;
        if (map2 != null && !map2.isEmpty()) {
            String str = "";
            for (String next2 : this.f35657e.keySet()) {
                str = str + next2 + ":" + this.f35657e.get(next2) + ";";
            }
            ebVar.a("frameworksData", (Object) str.substring(0, str.length() - 1), false, false);
        }
        ebVar.a("packageId", (Object) this.f35664i, false, true);
        ebVar.a("installerPkg", (Object) this.f35665j, false, true);
        ebVar.a("age", (Object) this.f35661g, false, true);
        yb ybVar = this.f35663h;
        if (ybVar != null) {
            ebVar.a("userAdvertisingId", (Object) ybVar.f36967b, false, true);
            boolean z2 = this.f35663h.f36969d;
            if (z2) {
                ebVar.a("limat", (Object) Boolean.valueOf(z2), false, true);
            }
            ebVar.a("advertisingIdSource", (Object) this.f35663h.f36968c, false, true);
        }
        String str2 = this.f35666k;
        if (str2 != null) {
            ebVar.a("duid", (Object) str2, false, true);
        }
        ebVar.a("model", (Object) this.f35667l, false, true);
        ebVar.a("manufacturer", (Object) this.f35668m, false, true);
        ebVar.a("deviceVersion", (Object) this.f35669n, false, true);
        ebVar.a(Constants.LOCALE, (Object) this.f35670o, false, true);
        ebVar.a("localeList", (Object) this.f35671p, false, true);
        ebVar.a("inputLangs", (Object) this.f35672q, false, true);
        ebVar.a("isp", (Object) this.f35679x, false, true);
        ebVar.a("ispName", (Object) this.f35680y, false, true);
        ebVar.a("ispCarrId", (Object) this.f35681z, false, true);
        ebVar.a("ispCarrIdName", (Object) this.A, false, true);
        ebVar.a("netOper", (Object) this.B, false, true);
        ebVar.a("networkOperName", (Object) this.C, false, true);
        ebVar.a("cid", (Object) this.D, false, true);
        ebVar.a("lac", (Object) this.E, false, true);
        ebVar.a("tac", (Object) this.F, false, true);
        ebVar.a("blat", (Object) this.G, false, true);
        ebVar.a("blon", (Object) this.H, false, true);
        ebVar.a("subPublisherId", (Object) null, false, true);
        ebVar.a("subProductId", (Object) null, false, true);
        ebVar.a("retryCount", (Object) null, false, true);
        ebVar.a("roaming", (Object) this.f35674s, false, true);
        ebVar.a("grid", (Object) this.f35675t, false, true);
        if (this.f35676u) {
            ebVar.a("c5g", (Object) "1", false, false);
        }
        int i2 = this.f35677v;
        if (i2 >= 0) {
            ebVar.a("transport", (Object) String.valueOf(i2), false, false);
        }
        ebVar.a("silev", (Object) this.f35678w, false, true);
        ebVar.a("cellSignalLevel", (Object) this.I, false, true);
        ebVar.a("cellTimingAdv", (Object) this.J, false, true);
        ebVar.a("outsource", (Object) this.f35673r, false, true);
        ebVar.a("width", (Object) String.valueOf(this.M), false, true);
        ebVar.a("height", (Object) String.valueOf(this.N), false, true);
        ebVar.a("density", (Object) String.valueOf(this.O), false, true);
        ebVar.a("fgApp", (Object) this.P, false, true);
        ebVar.a("sdkId", (Object) String.valueOf(this.Q), true, true);
        ebVar.a("clientSessionId", (Object) this.R, false, true);
        ebVar.a("appVersion", (Object) this.S, false, true);
        ebVar.a("appCode", (Object) Integer.valueOf(this.T), false, true);
        ebVar.a("timeSinceBoot", (Object) Long.valueOf(SystemClock.elapsedRealtime()), false, true);
        ebVar.a("udbg", (Object) Boolean.valueOf(this.U), false, true);
        ebVar.a("root", (Object) Boolean.valueOf(this.V), false, true);
        ebVar.a("smltr", (Object) Boolean.valueOf(this.W), false, true);
        ebVar.a("isddbg", (Object) Boolean.valueOf(this.X), false, true);
        ebVar.a("pas", (Object) this.Y, false, true);
        ebVar.a("prm", (Object) this.Z, false, false);
        ebVar.a("free", (Object) this.f35652b0, false, false);
        ebVar.a("chr", (Object) this.f35656d0, false, false);
        ebVar.a("blp", (Object) this.f35654c0, false, false);
        ebVar.a("hs", (Object) this.f35658e0, false, false);
        ebVar.a("lpm", (Object) this.f35660f0, false, false);
        ebVar.a("dm", (Object) this.f35662g0, false, false);
        ebVar.a("rsc", (Object) this.K, false, true);
    }

    public void b(Context context) {
        boolean z2;
        try {
            this.f35652b0 = null;
            this.f35652b0 = Long.valueOf(new StatFs(Environment.getRootDirectory().getAbsolutePath()).getFreeBytes());
        } catch (Throwable th) {
            y8.a(context, th);
        }
        boolean z3 = true;
        try {
            this.f35656d0 = null;
            this.f35654c0 = null;
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                if (registerReceiver.hasExtra("status")) {
                    int intExtra = registerReceiver.getIntExtra("status", -1);
                    if (intExtra != 2) {
                        if (intExtra != 5) {
                            z2 = false;
                            this.f35656d0 = Boolean.valueOf(z2);
                        }
                    }
                    z2 = true;
                    this.f35656d0 = Boolean.valueOf(z2);
                }
                if (registerReceiver.hasExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL) && registerReceiver.hasExtra("scale")) {
                    int intExtra2 = registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1);
                    int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                    if (intExtra2 >= 0 && intExtra3 > 0) {
                        this.f35654c0 = Integer.valueOf((intExtra2 * 100) / intExtra3);
                    }
                }
            }
        } catch (Throwable th2) {
            y8.a(context, th2);
        }
        try {
            this.f35658e0 = null;
            Object systemService = context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (systemService instanceof AudioManager) {
                AudioManager audioManager = (AudioManager) systemService;
                if (Build.VERSION.SDK_INT >= 23) {
                    AudioDeviceInfo[] a2 = audioManager.getDevices(2);
                    if (a2 != null) {
                        int length = a2.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                AudioDeviceInfo audioDeviceInfo = a2[i2];
                                if (audioDeviceInfo != null && f35649a.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                        this.f35658e0 = Boolean.valueOf(z3);
                    }
                    z3 = false;
                    this.f35658e0 = Boolean.valueOf(z3);
                }
            }
        } catch (Throwable th3) {
            y8.a(context, th3);
        }
        try {
            this.f35660f0 = null;
            Object systemService2 = context.getSystemService("power");
            if (systemService2 instanceof PowerManager) {
                this.f35660f0 = Boolean.valueOf(((PowerManager) systemService2).isPowerSaveMode());
            }
        } catch (Throwable th4) {
            y8.a(context, th4);
        }
        try {
            this.f35662g0 = null;
            int i3 = context.getResources().getConfiguration().uiMode & 48;
            if (i3 == 32) {
                this.f35662g0 = Boolean.TRUE;
            } else if (i3 == 16) {
                this.f35662g0 = Boolean.FALSE;
            }
        } catch (Throwable th5) {
            y8.a(context, th5);
        }
    }

    public void a(Context context) {
        if (!MetaData.f36379h.l()) {
            yb a2 = ComponentLocator.a(context).a().a();
            this.f35663h = a2;
            if (TextUtils.isEmpty(a2.f36967b) || "0".equals(a2.f36967b)) {
                zd b2 = ComponentLocator.a(context).f36438l.b();
                String str = b2.f37015b;
                if (str == null) {
                    synchronized (b2) {
                        str = b2.f37015b;
                        if (str == null) {
                            str = b2.f37014a.getString("e695c6d894060903", (String) null);
                            if (str == null) {
                                str = UUID.randomUUID().toString();
                                if (!b2.f37014a.edit().putString("e695c6d894060903", str).commit()) {
                                    str = "00000000-0000-0000-0000-000000000000";
                                }
                            }
                            b2.f37015b = str;
                        }
                    }
                }
                this.f35666k = str;
            }
            try {
                this.f35659f = ComponentLocator.a(context).G.b().getAll();
            } catch (Throwable th) {
                y8.a(context, th);
            }
        }
    }
}
