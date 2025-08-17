package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.p;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.unity3d.services.core.device.MimeTypes;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class o {
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicReference<a> f15728h = new AtomicReference<>();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicReference<b> f15729j = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    private final m f15730a;

    /* renamed from: b  reason: collision with root package name */
    private final v f15731b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f15732c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f15733d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f15734e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Object> f15735f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f15736g;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final AtomicReference<Integer> f15737i = new AtomicReference<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f15743a;

        /* renamed from: b  reason: collision with root package name */
        public String f15744b = "";
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f15745a;

        /* renamed from: b  reason: collision with root package name */
        public final int f15746b;

        public b(String str, int i2) {
            this.f15745a = str;
            this.f15746b = i2;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f15747a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f15748b = -1;
    }

    protected o(m mVar) {
        if (mVar != null) {
            this.f15730a = mVar;
            this.f15731b = mVar.A();
            this.f15732c = mVar.L();
            this.f15733d = q();
            this.f15735f = s();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: private */
    public Integer A() {
        AudioManager audioManager = (AudioManager) this.f15732c.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        return Integer.valueOf((int) (((float) audioManager.getStreamVolume(3)) * ((Float) this.f15730a.a(com.applovin.impl.sdk.c.b.dL)).floatValue()));
    }

    private double B() {
        return ((double) Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d)) / 10.0d;
    }

    private boolean C() {
        SensorManager sensorManager = (SensorManager) this.f15732c.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    private String D() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f15732c.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    private String E() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f15732c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(0, Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!v.a()) {
                return "";
            }
            this.f15731b.b("DataCollector", "Unable to collect mobile country code", th);
            return "";
        }
    }

    private String F() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f15732c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!v.a()) {
                return "";
            }
            this.f15731b.b("DataCollector", "Unable to collect mobile network code", th);
            return "";
        }
    }

    private String G() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f15732c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            if (!v.a()) {
                return "";
            }
            this.f15731b.b("DataCollector", "Unable to collect carrier", th);
            return "";
        }
    }

    private boolean H() {
        try {
            return I() || J();
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean I() {
        String str = Build.TAGS;
        return str != null && str.contains(b("lz}$blpz"));
    }

    private boolean J() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i2 = 0; i2 < 9; i2++) {
            if (new File(b(strArr[i2])).exists()) {
                return true;
            }
        }
        return false;
    }

    private String a(int i2) {
        if (i2 == 1) {
            return "receiver";
        }
        if (i2 == 2) {
            return "speaker";
        }
        if (i2 == 4 || i2 == 3) {
            return "headphones";
        }
        if (i2 == 8) {
            return "bluetootha2dpoutput";
        }
        if (i2 == 13 || i2 == 19 || i2 == 5 || i2 == 6 || i2 == 12 || i2 == 11) {
            return "lineout";
        }
        if (i2 == 9 || i2 == 10) {
            return "hdmioutput";
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01bb A[SYNTHETIC, Splitter:B:54:0x01bb] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.Object> a(java.util.Map<java.lang.String, java.lang.Object> r10, boolean r11) {
        /*
            r9 = this;
            java.lang.String r0 = "lmt"
            java.lang.String r1 = "tm"
            java.lang.String r2 = "fm"
            java.lang.String r3 = "tds"
            java.lang.String r4 = "fs"
            java.lang.String r5 = "DataCollector"
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>(r10)
            android.content.Context r10 = r9.f15732c
            android.graphics.Point r10 = com.applovin.impl.sdk.utils.g.a(r10)
            int r7 = r10.x
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "dx"
            r6.put(r8, r7)
            int r10 = r10.y
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r7 = "dy"
            r6.put(r7, r10)
            if (r11 == 0) goto L_0x0050
            java.util.concurrent.atomic.AtomicReference<com.applovin.impl.sdk.o$a> r10 = f15728h
            java.lang.Object r10 = r10.get()
            com.applovin.impl.sdk.o$a r10 = (com.applovin.impl.sdk.o.a) r10
            if (r10 == 0) goto L_0x003d
            r9.m()
            goto L_0x005a
        L_0x003d:
            boolean r10 = com.applovin.impl.sdk.utils.Utils.isMainThread()
            if (r10 == 0) goto L_0x0050
            com.applovin.impl.sdk.o$a r10 = new com.applovin.impl.sdk.o$a
            r10.<init>()
            java.lang.String r7 = "inc"
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            r6.put(r7, r8)
            goto L_0x005a
        L_0x0050:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.o r10 = r10.V()
            com.applovin.impl.sdk.o$a r10 = r10.k()
        L_0x005a:
            java.lang.String r7 = r10.f15744b
            boolean r8 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r7)
            if (r8 == 0) goto L_0x0067
            java.lang.String r8 = "idfa"
            r6.put(r8, r7)
        L_0x0067:
            boolean r10 = r10.f15743a
            java.lang.String r7 = "dnt"
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r6.put(r7, r10)
            java.util.concurrent.atomic.AtomicReference<com.applovin.impl.sdk.o$b> r10 = f15729j
            java.lang.Object r10 = r10.get()
            com.applovin.impl.sdk.o$b r10 = (com.applovin.impl.sdk.o.b) r10
            com.applovin.impl.sdk.m r7 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.c.b.dq
            java.lang.Object r7 = r7.a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x009e
            if (r10 == 0) goto L_0x009e
            java.lang.String r7 = "idfv"
            java.lang.String r8 = r10.f15745a
            r6.put(r7, r8)
            int r10 = r10.f15746b
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r7 = "idfv_scope"
            r6.put(r7, r10)
        L_0x009e:
            com.applovin.impl.sdk.j$a r10 = com.applovin.impl.sdk.j.b()
            android.content.Context r7 = r9.f15732c
            java.lang.Boolean r10 = r10.a((android.content.Context) r7)
            if (r10 == 0) goto L_0x00af
            java.lang.String r7 = "huc"
            r6.put(r7, r10)
        L_0x00af:
            com.applovin.impl.sdk.j$a r10 = com.applovin.impl.sdk.j.a()
            android.content.Context r7 = r9.f15732c
            java.lang.Boolean r10 = r10.a((android.content.Context) r7)
            if (r10 == 0) goto L_0x00c0
            java.lang.String r7 = "aru"
            r6.put(r7, r10)
        L_0x00c0:
            com.applovin.impl.sdk.j$a r10 = com.applovin.impl.sdk.j.c()
            android.content.Context r7 = r9.f15732c
            java.lang.Boolean r10 = r10.a((android.content.Context) r7)
            if (r10 == 0) goto L_0x00d1
            java.lang.String r7 = "dns"
            r6.put(r7, r10)
        L_0x00d1:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r7 = com.applovin.impl.sdk.c.b.dA
            java.lang.Object r10 = r10.a(r7)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00fb
            com.applovin.impl.sdk.o$c r10 = r9.v()
            int r7 = r10.f15747a
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "act"
            r6.put(r8, r7)
            int r10 = r10.f15748b
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r7 = "acm"
            r6.put(r7, r10)
        L_0x00fb:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r7 = com.applovin.impl.sdk.c.b.dI
            java.lang.Object r10 = r10.a(r7)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x011e
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.y r10 = r10.ad()
            int r10 = r10.b()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r7 = "mtl"
            r6.put(r7, r10)
        L_0x011e:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r7 = com.applovin.impl.sdk.c.b.dK
            java.lang.Object r10 = r10.a(r7)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x013b
            boolean r10 = r9.H()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            java.lang.String r7 = "adr"
            r6.put(r7, r10)
        L_0x013b:
            if (r11 == 0) goto L_0x0146
            java.util.concurrent.atomic.AtomicReference<java.lang.Integer> r10 = r9.f15737i
            java.lang.Object r10 = r10.get()
            java.lang.Integer r10 = (java.lang.Integer) r10
            goto L_0x014a
        L_0x0146:
            java.lang.Integer r10 = r9.A()
        L_0x014a:
            if (r10 == 0) goto L_0x0151
            java.lang.String r11 = "volume"
            r6.put(r11, r10)
        L_0x0151:
            android.content.Context r10 = r9.f15732c     // Catch:{ SettingNotFoundException -> 0x0170 }
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0170 }
            java.lang.String r11 = "screen_brightness"
            int r10 = android.provider.Settings.System.getInt(r10, r11)     // Catch:{ SettingNotFoundException -> 0x0170 }
            float r10 = (float) r10     // Catch:{ SettingNotFoundException -> 0x0170 }
            r11 = 1132396544(0x437f0000, float:255.0)
            float r10 = r10 / r11
            java.lang.String r11 = "sb"
            r7 = 1120403456(0x42c80000, float:100.0)
            float r10 = r10 * r7
            int r10 = (int) r10     // Catch:{ SettingNotFoundException -> 0x0170 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ SettingNotFoundException -> 0x0170 }
            r6.put(r11, r10)     // Catch:{ SettingNotFoundException -> 0x0170 }
            goto L_0x017e
        L_0x0170:
            r10 = move-exception
            boolean r11 = com.applovin.impl.sdk.v.a()
            if (r11 == 0) goto L_0x017e
            com.applovin.impl.sdk.v r11 = r9.f15731b
            java.lang.String r7 = "Unable to collect screen brightness"
            r11.b(r5, r7, r10)
        L_0x017e:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r11 = com.applovin.impl.sdk.c.b.dN
            java.lang.Object r10 = r10.a(r11)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x01aa
            com.applovin.impl.sdk.m r10 = r9.f15730a
            boolean r10 = com.applovin.impl.sdk.utils.Utils.isUserAgentCollectionEnabled(r10)
            if (r10 == 0) goto L_0x01aa
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.ab.b(r10)
            java.lang.String r10 = com.applovin.impl.sdk.ab.a()
            boolean r11 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r10)
            if (r11 == 0) goto L_0x01aa
            java.lang.String r11 = "ua"
            r6.put(r11, r10)
        L_0x01aa:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r11 = com.applovin.impl.sdk.c.b.dC
            java.lang.Object r10 = r10.a(r11)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r11 = -1
            if (r10 == 0) goto L_0x01f6
            java.io.File r10 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x01da }
            long r7 = r10.getFreeSpace()     // Catch:{ all -> 0x01da }
            java.lang.Long r10 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x01da }
            r6.put(r4, r10)     // Catch:{ all -> 0x01da }
            java.io.File r10 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x01da }
            long r7 = r10.getTotalSpace()     // Catch:{ all -> 0x01da }
            java.lang.Long r10 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x01da }
            r6.put(r3, r10)     // Catch:{ all -> 0x01da }
            goto L_0x01f6
        L_0x01da:
            r10 = move-exception
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)
            r6.put(r4, r7)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            r6.put(r3, r4)
            boolean r3 = com.applovin.impl.sdk.v.a()
            if (r3 == 0) goto L_0x01f6
            com.applovin.impl.sdk.v r3 = r9.f15731b
            java.lang.String r4 = "Unable to collect total & free space."
            r3.b(r5, r4, r10)
        L_0x01f6:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r3 = com.applovin.impl.sdk.c.b.dD
            java.lang.Object r10 = r10.a(r3)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0264
            android.content.Context r10 = r9.f15732c
            java.lang.String r3 = "activity"
            java.lang.Object r10 = r10.getSystemService(r3)
            android.app.ActivityManager r10 = (android.app.ActivityManager) r10
            android.app.ActivityManager$MemoryInfo r3 = new android.app.ActivityManager$MemoryInfo
            r3.<init>()
            if (r10 == 0) goto L_0x0264
            r10.getMemoryInfo(r3)     // Catch:{ all -> 0x0241 }
            long r7 = r3.availMem     // Catch:{ all -> 0x0241 }
            java.lang.Long r10 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0241 }
            r6.put(r2, r10)     // Catch:{ all -> 0x0241 }
            long r7 = r3.totalMem     // Catch:{ all -> 0x0241 }
            java.lang.Long r10 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0241 }
            r6.put(r1, r10)     // Catch:{ all -> 0x0241 }
            long r7 = r3.threshold     // Catch:{ all -> 0x0241 }
            java.lang.Long r10 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0241 }
            r6.put(r0, r10)     // Catch:{ all -> 0x0241 }
            java.lang.String r10 = "lm"
            boolean r3 = r3.lowMemory     // Catch:{ all -> 0x0241 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0241 }
            r6.put(r10, r3)     // Catch:{ all -> 0x0241 }
            goto L_0x0264
        L_0x0241:
            r10 = move-exception
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
            r6.put(r2, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            r6.put(r1, r2)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r6.put(r0, r11)
            boolean r11 = com.applovin.impl.sdk.v.a()
            if (r11 == 0) goto L_0x0264
            com.applovin.impl.sdk.v r11 = r9.f15731b
            java.lang.String r0 = "Unable to collect memory info."
            r11.b(r5, r0, r10)
        L_0x0264:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r11 = com.applovin.impl.sdk.c.b.dE
            java.lang.Object r10 = r10.a(r11)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x029b
            java.lang.String r10 = "android.permission.READ_PHONE_STATE"
            android.content.Context r11 = r9.f15732c
            boolean r10 = com.applovin.impl.sdk.utils.g.a(r10, r11)
            if (r10 == 0) goto L_0x029b
            boolean r10 = com.applovin.impl.sdk.utils.g.f()
            if (r10 == 0) goto L_0x029b
            android.content.Context r10 = r9.f15732c
            java.lang.String r11 = "phone"
            java.lang.Object r10 = r10.getSystemService(r11)
            android.telephony.TelephonyManager r10 = (android.telephony.TelephonyManager) r10
            int r10 = r10.getDataNetworkType()
            java.lang.String r11 = "rat"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r6.put(r11, r10)
        L_0x029b:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r11 = com.applovin.impl.sdk.c.b.dB
            java.lang.Object r10 = r10.a(r11)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x02ba
            java.lang.String r10 = r9.y()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x02ba
            java.lang.String r11 = "so"
            r6.put(r11, r10)
        L_0x02ba:
            java.lang.String r10 = "orientation_lock"
            java.lang.String r11 = r9.r()
            r6.put(r10, r11)
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r11 = com.applovin.impl.sdk.c.b.dF
            java.lang.Object r10 = r10.a(r11)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x02e0
            boolean r10 = com.applovin.impl.sdk.utils.Utils.isVPNConnected()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            java.lang.String r11 = "vs"
            r6.put(r11, r10)
        L_0x02e0:
            boolean r10 = com.applovin.impl.sdk.utils.g.d()
            if (r10 == 0) goto L_0x02ff
            android.content.Context r10 = r9.f15732c
            java.lang.String r11 = "power"
            java.lang.Object r10 = r10.getSystemService(r11)
            android.os.PowerManager r10 = (android.os.PowerManager) r10
            if (r10 == 0) goto L_0x02ff
            boolean r10 = r10.isPowerSaveMode()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r11 = "lpm"
            r6.put(r11, r10)
        L_0x02ff:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r11 = com.applovin.impl.sdk.c.b.dO
            java.lang.Object r10 = r10.a(r11)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x032a
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.utils.n r10 = r10.ah()
            if (r10 == 0) goto L_0x032a
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.utils.n r10 = r10.ah()
            float r10 = r10.c()
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            java.lang.String r11 = "da"
            r6.put(r11, r10)
        L_0x032a:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r11 = com.applovin.impl.sdk.c.b.dP
            java.lang.Object r10 = r10.a(r11)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0355
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.utils.n r10 = r10.ah()
            if (r10 == 0) goto L_0x0355
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.utils.n r10 = r10.ah()
            float r10 = r10.b()
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            java.lang.String r11 = "dm"
            r6.put(r11, r10)
        L_0x0355:
            com.applovin.impl.sdk.m r10 = r9.f15730a
            com.applovin.impl.sdk.h r10 = r10.ai()
            int r10 = r10.a()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r11 = "mute_switch"
            r6.put(r11, r10)
            com.applovin.impl.sdk.m r10 = r9.f15730a
            java.lang.String r10 = com.applovin.impl.sdk.utils.h.f(r10)
            java.lang.String r11 = "network"
            r6.put(r11, r10)
            java.lang.String r10 = r9.z()
            boolean r11 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r10)
            if (r11 == 0) goto L_0x0382
            java.lang.String r11 = "kb"
            r6.put(r11, r10)
        L_0x0382:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.o.a(java.util.Map, boolean):java.util.Map");
    }

    public static void a(final Context context) {
        new Thread(new Runnable() {
            public void run() {
                o.f15728h.set(com.applovin.impl.sdk.utils.c.a(context));
            }
        }).start();
    }

    private void a(Map<String, Object> map) {
        if (((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.dG)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(w()));
        }
        if (((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.dH)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(x()));
        }
        if (((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.dN)).booleanValue() && Utils.isUserAgentCollectionEnabled(this.f15730a)) {
            ab.b(this.f15730a);
        }
        if (((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.dM)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.dJ)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(u()));
        }
    }

    private boolean a(String str) {
        try {
            return Settings.Secure.getInt(this.f15732c.getContentResolver(), str) == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    private String b(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = str.charAt(i2);
            for (int i3 = 9; i3 >= 0; i3--) {
                cArr[i2] = (char) (cArr[i2] ^ iArr[i3]);
            }
        }
        return new String(cArr);
    }

    public static void b(final Context context) {
        if (Utils.checkClassExistence("com.google.android.gms.appset.AppSet")) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        AppSet.getClient(context).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() {
                            /* renamed from: a */
                            public void onSuccess(AppSetIdInfo appSetIdInfo) {
                                o.f15729j.set(new b(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                            }
                        });
                    } catch (Throwable unused) {
                        if (v.a()) {
                            v.f("DataCollector", "Could not collect AppSet ID.");
                        }
                    }
                }
            }).start();
        } else if (v.a()) {
            v.f("DataCollector", "Could not collect AppSet ID.");
        }
    }

    private Map<String, String> p() {
        return Utils.stringifyObjectMap(a((Map<String, String>) null, true, false));
    }

    private Map<String, Object> q() {
        HashMap hashMap = new HashMap(32);
        hashMap.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("brand_name", Build.BRAND);
        hashMap.put("hardware", Build.HARDWARE);
        hashMap.put("sim", Boolean.valueOf(AppLovinSdkUtils.isEmulator()));
        hashMap.put("aida", Boolean.valueOf(com.applovin.impl.sdk.utils.c.a()));
        hashMap.put(Constants.LOCALE, Locale.getDefault().toString());
        hashMap.put("model", Build.MODEL);
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("platform", f());
        hashMap.put("revision", Build.DEVICE);
        hashMap.put("tz_offset", Double.valueOf(B()));
        hashMap.put("gy", Boolean.valueOf(C()));
        hashMap.put("country_code", D());
        hashMap.put("mcc", E());
        hashMap.put("mnc", F());
        hashMap.put("carrier", G());
        hashMap.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.f15732c)));
        hashMap.put("tv", Boolean.valueOf(AppLovinSdkUtils.isTv(this.f15732c)));
        DisplayMetrics displayMetrics = this.f15732c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            hashMap.put("adns", Float.valueOf(displayMetrics.density));
            hashMap.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            hashMap.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            hashMap.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            Point a2 = g.a(this.f15732c);
            hashMap.put("screen_size_in", Double.valueOf(Math.sqrt(Math.pow((double) a2.x, 2.0d) + Math.pow((double) a2.y, 2.0d)) / ((double) displayMetrics.xdpi)));
        }
        hashMap.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        a((Map<String, Object>) hashMap);
        return hashMap;
    }

    private String r() {
        int orientation = Utils.getOrientation(this.f15732c);
        return orientation == 1 ? "portrait" : orientation == 2 ? "landscape" : "none";
    }

    private Map<String, Object> s() {
        PackageInfo packageInfo;
        HashMap hashMap = new HashMap(20);
        PackageManager packageManager = this.f15732c.getPackageManager();
        ApplicationInfo applicationInfo = this.f15732c.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        String str = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f15732c.getPackageName(), 0);
            try {
                str = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        hashMap.put("app_name", packageManager.getApplicationLabel(applicationInfo));
        Object obj = "";
        hashMap.put("app_version", packageInfo != null ? packageInfo.versionName : obj);
        hashMap.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        hashMap.put("package_name", applicationInfo.packageName);
        hashMap.put("vz", StringUtils.toShortSHA1Hash(applicationInfo.packageName));
        if (str == null) {
            str = obj;
        }
        hashMap.put("installer_name", str);
        hashMap.put("tg", p.a(this.f15730a));
        hashMap.put("debug", Boolean.valueOf(Utils.isPubInDebugMode(this.f15730a.L(), this.f15730a)));
        hashMap.put("ia", Long.valueOf(lastModified));
        m mVar = this.f15730a;
        d dVar = d.f15218d;
        Long l2 = (Long) mVar.a(dVar);
        if (l2 != null) {
            hashMap.put("ia_v2", l2);
        } else {
            this.f15730a.a(dVar, Long.valueOf(lastModified));
        }
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        hashMap.put("omid_sdk_version", this.f15730a.al().c());
        String userEngagementSdkVersion = Utils.getUserEngagementSdkVersion();
        if (StringUtils.isValidString(userEngagementSdkVersion)) {
            hashMap.put("ue_sdk_version", userEngagementSdkVersion);
        }
        hashMap.put("api_did", this.f15730a.a(com.applovin.impl.sdk.c.b.X));
        if (packageInfo != null) {
            obj = Long.valueOf(packageInfo.firstInstallTime);
        }
        hashMap.put("first_install_v3_ms", obj);
        hashMap.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        hashMap.put("epv", Integer.valueOf(Utils.tryToGetExoPlayerVersionCode()));
        return hashMap;
    }

    private Map<String, Object> t() {
        HashMap hashMap = new HashMap(2);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f15732c);
        String str = (String) this.f15730a.b(d.f15228n, null, defaultSharedPreferences);
        if (StringUtils.isValidString(str)) {
            hashMap.put("IABTCF_TCString", str);
        }
        Object obj = defaultSharedPreferences.getAll().get(d.f15229o.a());
        if ((obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean)) {
            hashMap.put("IABTCF_gdprApplies", obj);
        }
        return hashMap;
    }

    private boolean u() {
        ConnectivityManager connectivityManager;
        if (g.f() && (connectivityManager = (ConnectivityManager) this.f15732c.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th) {
                if (v.a()) {
                    this.f15730a.A().b("DataCollector", "Unable to collect constrained network info.", th);
                }
            }
        }
        return false;
    }

    private c v() {
        c cVar = new c();
        Intent registerReceiver = this.f15732c.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i2 = -1;
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) : -1;
        int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            cVar.f15748b = -1;
        } else {
            cVar.f15748b = (int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f);
        }
        if (registerReceiver != null) {
            i2 = registerReceiver.getIntExtra("status", -1);
        }
        cVar.f15747a = i2;
        return cVar;
    }

    private long w() {
        List asList = Arrays.asList(StringUtils.emptyIfNull(Settings.Secure.getString(this.f15732c.getContentResolver(), "enabled_accessibility_services")).split(":"));
        long j2 = asList.contains("AccessibilityMenuService") ? 256 : 0;
        if (asList.contains("SelectToSpeakService")) {
            j2 |= 512;
        }
        if (asList.contains("SoundAmplifierService")) {
            j2 |= 2;
        }
        if (asList.contains("SpeechToTextAccessibilityService")) {
            j2 |= 128;
        }
        if (asList.contains("SwitchAccessService")) {
            j2 |= 4;
        }
        if ((this.f15732c.getResources().getConfiguration().uiMode & 48) == 32) {
            j2 |= 1024;
        }
        if (a("accessibility_enabled")) {
            j2 |= 8;
        }
        if (a("touch_exploration_enabled")) {
            j2 |= 16;
        }
        if (!g.d()) {
            return j2;
        }
        if (a("accessibility_display_inversion_enabled")) {
            j2 |= 32;
        }
        return a("skip_first_use_hints") ? j2 | 64 : j2;
    }

    private float x() {
        try {
            return Settings.System.getFloat(this.f15732c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e2) {
            if (!v.a()) {
                return -1.0f;
            }
            this.f15731b.b("DataCollector", "Error collecting font scale", e2);
            return -1.0f;
        }
    }

    private String y() {
        AudioManager audioManager = (AudioManager) this.f15732c.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (g.e()) {
            for (AudioDeviceInfo a2 : audioManager.getDevices(2)) {
                String a3 = a(a2.getType());
                if (!TextUtils.isEmpty(a3)) {
                    sb.append(a3);
                    sb.append(",");
                }
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append("headphones");
                sb.append(",");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append("bluetootha2dpoutput");
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sb2 = sb.toString();
        if (v.a() && TextUtils.isEmpty(sb2)) {
            this.f15731b.b("DataCollector", "No sound outputs detected");
        }
        return sb2;
    }

    private String z() {
        if (!g.f()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            LocaleList a2 = this.f15732c.getResources().getConfiguration().getLocales();
            for (int i2 = 0; i2 < a2.size(); i2++) {
                sb.append(a2.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String a() {
        String encodeToString = Base64.encodeToString(new JSONObject(p()).toString().getBytes(Charset.defaultCharset()), 2);
        if (!((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.eq)).booleanValue()) {
            return encodeToString;
        }
        return m.a(encodeToString, this.f15730a.z(), Utils.getServerAdjustedUnixTimestampMillis(this.f15730a));
    }

    public Map<String, Object> a(Map<String, String> map, boolean z2, boolean z3) {
        HashMap hashMap = new HashMap(64);
        Map<String, Object> a2 = a(z2);
        Map<String, Object> h2 = h();
        Map<String, Object> j2 = j();
        Map<String, String> allData = this.f15730a.r().getAllData();
        if (z3) {
            hashMap.put("device_info", a2);
            hashMap.put("app_info", h2);
            if (map != null) {
                hashMap.put("ad_info", map);
            }
            if (j2 != null) {
                hashMap.put("location_info", j2);
            }
            if (!allData.isEmpty()) {
                hashMap.put("targeting_data", allData);
            }
        } else {
            hashMap.putAll(a2);
            hashMap.putAll(h2);
            if (map != null) {
                hashMap.putAll(map);
            }
            if (j2 != null) {
                hashMap.putAll(j2);
            }
            if (!allData.isEmpty()) {
                hashMap.putAll(allData);
            }
        }
        hashMap.put("accept", "custom_size,launch_app,video");
        hashMap.put("format", "json");
        Utils.putObjectForStringIfValid("mediation_provider", this.f15730a.t(), hashMap);
        Utils.putObjectForStringIfValid("plugin_version", (String) this.f15730a.a(com.applovin.impl.sdk.c.b.dz), hashMap);
        if (!((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.ep)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f15730a.z());
        }
        hashMap.putAll(i());
        if (((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.dZ)).booleanValue()) {
            com.applovin.impl.sdk.d.g T = this.f15730a.T();
            hashMap.put("li", Long.valueOf(T.b(f.f15303b)));
            hashMap.put("si", Long.valueOf(T.b(f.f15305d)));
            hashMap.put("pf", Long.valueOf(T.b(f.f15309h)));
            hashMap.put("mpf", Long.valueOf(T.b(f.f15316o)));
            hashMap.put("gpf", Long.valueOf(T.b(f.f15310i)));
            hashMap.put("asoac", Long.valueOf(T.b(f.f15314m)));
        }
        hashMap.put("rid", UUID.randomUUID().toString());
        return hashMap;
    }

    public Map<String, Object> a(boolean z2) {
        HashMap hashMap;
        synchronized (this.f15734e) {
            hashMap = new HashMap(this.f15733d);
        }
        return a(hashMap, z2);
    }

    public Map<String, Object> b() {
        return new HashMap(this.f15733d);
    }

    public Map<String, Object> c() {
        return new HashMap(this.f15735f);
    }

    public Map<String, Object> d() {
        return a(false);
    }

    public void e() {
        synchronized (this.f15734e) {
            a(this.f15733d);
        }
    }

    public String f() {
        return AppLovinSdkUtils.isFireOS(this.f15732c) ? "fireos" : "android";
    }

    public boolean g() {
        return this.f15736g;
    }

    public Map<String, Object> h() {
        HashMap hashMap = new HashMap(this.f15735f);
        hashMap.put("first_install", Boolean.valueOf(this.f15730a.P()));
        hashMap.put("first_install_v2", Boolean.valueOf(!this.f15730a.Q()));
        hashMap.put("test_ads", Boolean.valueOf(this.f15736g));
        if (((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.dr)).booleanValue()) {
            Utils.putObjectForStringIfValid("cuid", this.f15730a.m(), hashMap);
        }
        if (((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.du)).booleanValue()) {
            hashMap.put("compass_random_token", this.f15730a.n());
        }
        if (((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.dw)).booleanValue()) {
            hashMap.put("applovin_random_token", this.f15730a.o());
        }
        String name = this.f15730a.q().getName();
        if (StringUtils.isValidString(name)) {
            hashMap.put("user_segment_name", name);
        }
        hashMap.putAll(t());
        return hashMap;
    }

    public Map<String, Object> i() {
        HashMap hashMap = new HashMap(5);
        hashMap.put("sc", this.f15730a.a(com.applovin.impl.sdk.c.b.ac));
        hashMap.put("sc2", this.f15730a.a(com.applovin.impl.sdk.c.b.ad));
        hashMap.put("sc3", this.f15730a.a(com.applovin.impl.sdk.c.b.ae));
        hashMap.put("server_installed_at", this.f15730a.a(com.applovin.impl.sdk.c.b.af));
        Utils.putObjectForStringIfValid("persisted_data", (String) this.f15730a.a(d.f15240z), hashMap);
        return hashMap;
    }

    public Map<String, Object> j() {
        if (!this.f15730a.p().isLocationCollectionEnabled() || !((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.dW)).booleanValue()) {
            return null;
        }
        HashMap hashMap = new HashMap(4);
        u am = this.f15730a.am();
        boolean b2 = am.b();
        hashMap.put("loc_services_enabled", Boolean.valueOf(b2));
        if (!b2) {
            return hashMap;
        }
        hashMap.put("loc_auth", Boolean.valueOf(am.a()));
        t c2 = am.c();
        if (c2 != null) {
            double a2 = c2.a();
            m mVar = this.f15730a;
            com.applovin.impl.sdk.c.b bVar = com.applovin.impl.sdk.c.b.dY;
            hashMap.put("loc_lat", Utils.formatDoubleValue(a2, ((Integer) mVar.a(bVar)).intValue()));
            hashMap.put("loc_long", Utils.formatDoubleValue(c2.b(), ((Integer) this.f15730a.a(bVar)).intValue()));
        }
        return hashMap;
    }

    public a k() {
        List<String> testDeviceAdvertisingIds;
        a a2 = com.applovin.impl.sdk.utils.c.a(this.f15732c);
        if (a2 == null) {
            return new a();
        }
        if (((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.dp)).booleanValue()) {
            if (a2.f15743a && !((Boolean) this.f15730a.a(com.applovin.impl.sdk.c.b.f0do)).booleanValue()) {
                a2.f15744b = "";
            }
            f15728h.set(a2);
        } else {
            a2 = new a();
        }
        boolean z2 = false;
        if (StringUtils.isValidString(a2.f15744b) && (testDeviceAdvertisingIds = this.f15730a.p().getTestDeviceAdvertisingIds()) != null && testDeviceAdvertisingIds.contains(a2.f15744b)) {
            z2 = true;
        }
        this.f15736g = z2;
        return a2;
    }

    public b l() {
        return f15729j.get();
    }

    public void m() {
        this.f15730a.S().a((com.applovin.impl.sdk.e.a) new com.applovin.impl.sdk.e.f(this.f15730a, new f.a() {
            public void a(a aVar) {
                o.f15728h.set(aVar);
            }
        }), o.a.ADVERTISING_INFO_COLLECTION);
        this.f15730a.S().a((com.applovin.impl.sdk.e.a) new z(this.f15730a, true, new Runnable() {
            public void run() {
                o.this.f15737i.set(o.this.A());
            }
        }), o.a.CACHING_OTHER);
    }
}
