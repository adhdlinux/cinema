package com.startapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.startapp.networkTest.controller.LocationController;
import com.startapp.networkTest.enums.AnonymizationLevel;
import com.startapp.w0;
import com.vungle.ads.internal.signals.SignalManager;
import java.util.Set;
import java.util.UUID;

public class x0 {
    private static final String A = "P3INS_PFK_QOE_MANAGER_ENABLED";
    private static final String B = "P3INS_PFK_REGISTRATION_TIMESTAMP";
    private static final String C = "P3INS_PFK_IS_ALREADY_REGISTERED";
    private static final String D = "P3INS_PFK_SEND_REGISTRATION_TIMESTAMP_ENABLED";
    private static final String E = "P3INS_PFK_UPLOAD_EXTRA";
    private static final String F = "P3INS_PFK_VOWIFI_TEST_MANAGER_ENABLED";
    private static final String G = "P3INS_PFK_CT_CRITERIA_SERVER_LIST";
    private static final String H = "P3INS_PFK_LTR_CRITERIA_SERVER_LIST";
    private static final String I = "P3INS_PFK_CDN_CT_SERVER_LIST";
    private static final String J = "P3INS_PFK_CDN_CT_CRITERIA";
    private static final String K = "P3INS_PFK_CDN_LTR_SERVER_LIST";
    private static final String L = "P3INS_PFK_CDN_LTR_CRITERIA";
    private static final String M = "P3INS_PFK_CONNECTIVITY_TEST_CDNCONFIG_LAST_MODIFIED";
    private static final String N = "P3INS_PFK_CONNECTIVITY_TEST_CDNCONFIG_LAST_CHECK";
    private static final String O = "P3INS_PFK_WIFI_SCAN_TIMESTAMP";
    private static final String P = "P3INS_PFK_WIFI_SCAN_ENABLED";
    private static final String Q = "p3inspreferences";

    /* renamed from: a  reason: collision with root package name */
    private static final String f36856a = "p3ins_pfk_ul_params";

    /* renamed from: b  reason: collision with root package name */
    private static final String f36857b = "p3ins_pfk_ul_paramsetid";

    /* renamed from: c  reason: collision with root package name */
    private static final String f36858c = "p3ins_pfk_ul_allowed";

    /* renamed from: d  reason: collision with root package name */
    private static final String f36859d = "p3ins_pfk_db_retry";

    /* renamed from: e  reason: collision with root package name */
    private static final String f36860e = "p3ins_pfk_last_upload_time";

    /* renamed from: f  reason: collision with root package name */
    private static final String f36861f = "p3ins_pfk_guid";

    /* renamed from: g  reason: collision with root package name */
    private static final String f36862g = "P3INS_PFK_GUID_TIMESTAMP";

    /* renamed from: h  reason: collision with root package name */
    private static final String f36863h = "P3INS_PFK_CONNECTIVITY_TEST_ENABLED";

    /* renamed from: i  reason: collision with root package name */
    private static final String f36864i = "P3INS_PFK_CONNECTIVITY_KEEPALIVE_ENABLED";

    /* renamed from: j  reason: collision with root package name */
    private static final String f36865j = "P3INS_PFK_CONNECTIVITY_TEST_TRUSTSTORE_LAST_CHECK";

    /* renamed from: k  reason: collision with root package name */
    private static final String f36866k = "P3INS_PFK_CONNECTIVITY_TEST_TRUSTSTORE_LAST_MODIFIED";

    /* renamed from: l  reason: collision with root package name */
    private static final String f36867l = "P3INS_PFK_CONNECTIVITY_TEST_TIMESTAMP";

    /* renamed from: m  reason: collision with root package name */
    private static final String f36868m = "P3INS_PFK_APPUSAGE_SERVICE_ENABLED";

    /* renamed from: n  reason: collision with root package name */
    private static final String f36869n = "P3INS_PFK_APPUSAGE_LAST_SCREEN_SESSION_COUNTER";

    /* renamed from: o  reason: collision with root package name */
    private static final String f36870o = "P3INS_PFK_APPUSAGE_INSTALLED_APP_SNAPSHOT_ENABLED";

    /* renamed from: p  reason: collision with root package name */
    private static final String f36871p = "P3INS_PFK_APPUSAGE_INSTALLED_APP_SNAPSHOT_INTERVAL";

    /* renamed from: q  reason: collision with root package name */
    private static final String f36872q = "P3INS_PFK_APPUSAGE_INSTALLED_APP_SNAPSHOT_LAST_TIMESTAMP";

    /* renamed from: r  reason: collision with root package name */
    private static final String f36873r = "P3INS_PFK_APPUSAGE_BROWSER_SESSION_TRACKING_ENABLED";

    /* renamed from: s  reason: collision with root package name */
    private static final String f36874s = "P3INS_PFK_VOICEMANAGER_PHONENUMBER_RECORD_TYPE";

    /* renamed from: t  reason: collision with root package name */
    private static final String f36875t = "P3INS_PFK_VOICE_SERVICE_ENABLED";

    /* renamed from: u  reason: collision with root package name */
    private static final String f36876u = "P3INS_PFK_MESSAGING_SERVICE_ENABLED";

    /* renamed from: v  reason: collision with root package name */
    private static final String f36877v = "P3INS_PFK_MESSAGINGMANAGER_PHONENUMBER_RECORD_TYPE";

    /* renamed from: w  reason: collision with root package name */
    private static final String f36878w = "P3INS_PFK_COVERAGE_SERVICE_ENABLED";

    /* renamed from: x  reason: collision with root package name */
    private static final String f36879x = "P3INS_PFK_COVERAGE_SERVICE_TRIGGER_PROVIDER_MODE";

    /* renamed from: y  reason: collision with root package name */
    private static final String f36880y = "P3INS_PFK_TRAFFIC_ANALYZER_ENABLED";

    /* renamed from: z  reason: collision with root package name */
    private static final String f36881z = "P3INS_PFK_LAST_EXPORT_TIME";
    private SharedPreferences R;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f36882a;

        public a(String str) {
            this.f36882a = str;
        }

        public void run() {
            w0.a d2 = w0.d();
            if (d2 != null) {
                d2.a(this.f36882a);
            }
        }
    }

    public x0(Context context) {
        this.R = context.getSharedPreferences(Q, 0);
    }

    private boolean O() {
        return this.R.getBoolean(C, false);
    }

    public boolean A() {
        return this.R.getBoolean(f36876u, w0.b().MESSAGING_SERVICE_ENABLED());
    }

    public boolean B() {
        return this.R.getBoolean(A, w0.b().QOE_MANAGER_ENABLED());
    }

    public long C() {
        return this.R.getLong(B, 0);
    }

    public boolean D() {
        return this.R.getBoolean(D, w0.b().SEND_REGISTRATION_TIMESTAMP_ENABLED());
    }

    public boolean E() {
        return this.R.getBoolean(f36880y, w0.b().TRAFFIC_ANALYZER_ENABLED());
    }

    public long F() {
        return this.R.getLong(f36866k, 0);
    }

    public String G() {
        return this.R.getString(E, "");
    }

    public String H() {
        return this.R.getString(f36857b, "");
    }

    public String I() {
        return this.R.getString(f36856a, "");
    }

    public long J() {
        return this.R.getLong(f36859d, 0);
    }

    public boolean K() {
        return this.R.getBoolean(F, w0.b().VOWIFI_TEST_MANAGER_ENABLED());
    }

    public AnonymizationLevel L() {
        return a(this.R.getString(f36874s, w0.b().VOICEMANAGER_PHONENUMBER_RECORD_TYPE().toString()));
    }

    public boolean M() {
        return this.R.getBoolean(f36875t, w0.b().VOICE_SERVICE_ENABLED());
    }

    public boolean N() {
        return this.R.getBoolean(P, w0.b().WIFI_SCAN_ENABLED());
    }

    public boolean P() {
        return this.R.getBoolean(f36858c, true);
    }

    @SuppressLint({"ApplySharedPref"})
    public void a(long j2) {
        this.R.edit().putLong(f36871p, j2).commit();
    }

    public boolean b() {
        return this.R.getBoolean(f36873r, w0.b().APPUSAGE_BROWSER_SESSION_TRACKING_ENABLED());
    }

    public boolean c() {
        return this.R.getBoolean(f36870o, w0.b().APPUSAGE_MANAGER_INSTALLED_APP_SNAPSHOT_ENABLED());
    }

    @SuppressLint({"ApplySharedPref"})
    public void d(boolean z2) {
        this.R.edit().putBoolean(f36870o, z2).commit();
    }

    public boolean e() {
        return this.R.getBoolean(f36868m, w0.b().APPUSAGE_SERVICE_ENABLED());
    }

    @SuppressLint({"ApplySharedPref"})
    public void f(boolean z2) {
        this.R.edit().putBoolean(f36864i, z2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void g(long j2) {
        this.R.edit().putLong(f36881z, j2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void h(boolean z2) {
        this.R.edit().putBoolean(f36878w, z2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void i(long j2) {
        this.R.edit().putLong(f36860e, j2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void j(boolean z2) {
        this.R.edit().putBoolean(A, z2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void k(long j2) {
        this.R.edit().putLong(B, j2).commit();
    }

    public boolean l() {
        return this.R.getBoolean(f36864i, w0.b().CONNECTIVITY_KEEPALIVE_ENABLED());
    }

    public boolean m() {
        return this.R.getBoolean(f36863h, w0.b().CONNECTIVITY_TEST_ENABLED());
    }

    public boolean n() {
        return this.R.getBoolean(f36878w, w0.b().COVERAGE_MAPPER_SERVICE_ENABLED());
    }

    @SuppressLint({"ApplySharedPref"})
    public void o(boolean z2) {
        this.R.edit().putBoolean(f36875t, z2).commit();
    }

    public String p() {
        return a(false);
    }

    public Set<String> q() {
        return this.R.getStringSet(H, (Set) null);
    }

    public long r() {
        return this.R.getLong(f36872q, 0);
    }

    public long s() {
        return this.R.getLong(f36869n, 1);
    }

    public long t() {
        return this.R.getLong(N, 0);
    }

    public long u() {
        return this.R.getLong(f36867l, 2147483647L);
    }

    public long v() {
        return this.R.getLong(f36881z, 0);
    }

    public long w() {
        return this.R.getLong(f36865j, 0);
    }

    public long x() {
        return this.R.getLong(f36860e, 0);
    }

    public long y() {
        return this.R.getLong(O, 2147483647L);
    }

    public AnonymizationLevel z() {
        return a(this.R.getString(f36877v, w0.b().MESSAGINGMANAGER_PHONENUMBER_RECORD_TYPE().toString()));
    }

    public String a(boolean z2) {
        String string = this.R.getString(f36861f, "");
        boolean z3 = true;
        if (string == null || string.length() == 0) {
            string = a();
        } else {
            long d2 = r2.d();
            long j2 = this.R.getLong(f36862g, 0);
            long GUID_MAX_AGE = w0.b().GUID_MAX_AGE();
            if ((GUID_MAX_AGE != -1 || z2) && (d2 - j2 > GUID_MAX_AGE || z2)) {
                string = a();
            } else {
                z3 = false;
            }
        }
        if (z3) {
            new Handler(Looper.getMainLooper()).post(new o2(new a(string)));
            if (D()) {
                O();
            }
        }
        return string;
    }

    @SuppressLint({"ApplySharedPref"})
    public void b(AnonymizationLevel anonymizationLevel) {
        this.R.edit().putString(f36874s, anonymizationLevel.toString()).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void c(long j2) {
        this.R.edit().putLong(f36872q, j2).commit();
    }

    public long d() {
        return this.R.getLong(f36871p, SignalManager.TWENTY_FOUR_HOURS_MILLIS);
    }

    @SuppressLint({"ApplySharedPref"})
    public void e(boolean z2) {
        this.R.edit().putBoolean(f36868m, z2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void f(long j2) {
        this.R.edit().putLong(f36867l, j2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void g(boolean z2) {
        this.R.edit().putBoolean(f36863h, z2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void h(long j2) {
        this.R.edit().putLong(f36865j, j2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void i(boolean z2) {
        this.R.edit().putBoolean(f36876u, z2).commit();
    }

    public String j() {
        return this.R.getString(L, w0.b().LATENCY_TEST_CRITERIA().name());
    }

    @SuppressLint({"ApplySharedPref"})
    public void k(boolean z2) {
        this.R.edit().putBoolean(D, z2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void l(boolean z2) {
        this.R.edit().putBoolean(f36880y, z2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void m(boolean z2) {
        this.R.edit().putBoolean(f36858c, z2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void n(boolean z2) {
        this.R.edit().putBoolean(F, z2).commit();
    }

    public LocationController.ProviderMode o() {
        return b(this.R.getString(f36879x, w0.b().COVERAGE_MAPPER_SERVICE_TRIGGER_PROVIDER_MODE().toString()));
    }

    @SuppressLint({"ApplySharedPref"})
    public void p(boolean z2) {
        this.R.edit().putBoolean(P, z2).commit();
    }

    private LocationController.ProviderMode b(String str) {
        LocationController.ProviderMode providerMode = LocationController.ProviderMode.Gps;
        if (str.equals(providerMode.toString())) {
            return providerMode;
        }
        LocationController.ProviderMode providerMode2 = LocationController.ProviderMode.GpsAndNetwork;
        if (str.equals(providerMode2.toString())) {
            return providerMode2;
        }
        LocationController.ProviderMode providerMode3 = LocationController.ProviderMode.Network;
        if (str.equals(providerMode3.toString())) {
            return providerMode3;
        }
        LocationController.ProviderMode providerMode4 = LocationController.ProviderMode.Passive;
        if (str.equals(providerMode4.toString())) {
            return providerMode4;
        }
        LocationController.ProviderMode providerMode5 = LocationController.ProviderMode.RailNet;
        if (str.equals(providerMode5.toString())) {
            return providerMode5;
        }
        return null;
    }

    @SuppressLint({"ApplySharedPref"})
    public void c(boolean z2) {
        this.R.edit().putBoolean(f36873r, z2).commit();
    }

    public void d(long j2) {
        this.R.edit().putLong(f36869n, j2).apply();
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void e(String str) {
        this.R.edit().putString(E, str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void f(String str) {
        this.R.edit().putString(f36857b, str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void g(String str) {
        this.R.edit().putString(f36856a, str).commit();
    }

    public String h() {
        return this.R.getString(J, w0.b().CONNECTIVITY_TEST_CRITERIA().name());
    }

    public String[] i() {
        Set<String> stringSet = this.R.getStringSet(I, (Set) null);
        if (stringSet == null || stringSet.isEmpty()) {
            return w0.b().CONNECTIVITY_TEST_HOSTNAME_ARRAY();
        }
        return (String[]) stringSet.toArray(new String[stringSet.size()]);
    }

    @SuppressLint({"ApplySharedPref"})
    public void j(long j2) {
        this.R.edit().putLong(O, j2).commit();
    }

    public String[] k() {
        Set<String> stringSet = this.R.getStringSet(K, (Set) null);
        if (stringSet == null || stringSet.isEmpty()) {
            return w0.b().LATENCY_TEST_HOSTNAME_ARRAY();
        }
        return (String[]) stringSet.toArray(new String[stringSet.size()]);
    }

    @SuppressLint({"ApplySharedPref"})
    public void l(long j2) {
        this.R.edit().putLong(f36866k, j2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void m(long j2) {
        this.R.edit().putLong(f36859d, j2).commit();
    }

    public void c(String str) {
        this.R.edit().putString(J, str).commit();
    }

    public void d(Set<String> set) {
        this.R.edit().putStringSet(H, set).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void e(long j2) {
        this.R.edit().putLong(N, j2).commit();
    }

    public Set<String> f() {
        return this.R.getStringSet(G, (Set) null);
    }

    public long g() {
        return this.R.getLong(M, 0);
    }

    public void c(Set<String> set) {
        this.R.edit().putStringSet(K, set).commit();
    }

    public void d(String str) {
        this.R.edit().putString(L, str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    private void b(boolean z2) {
        this.R.edit().putBoolean(C, z2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void b(long j2) {
        this.R.edit().putLong(M, j2).commit();
    }

    public void b(Set<String> set) {
        this.R.edit().putStringSet(I, set).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    private String a() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        SharedPreferences.Editor edit = this.R.edit();
        edit.putString(f36861f, replace);
        edit.putLong(f36862g, r2.d());
        edit.commit();
        return replace;
    }

    @SuppressLint({"ApplySharedPref"})
    public void a(AnonymizationLevel anonymizationLevel) {
        this.R.edit().putString(f36877v, anonymizationLevel.toString()).commit();
    }

    private AnonymizationLevel a(String str) {
        AnonymizationLevel anonymizationLevel = AnonymizationLevel.Anonymized;
        if (str.equals(anonymizationLevel.toString())) {
            return anonymizationLevel;
        }
        AnonymizationLevel anonymizationLevel2 = AnonymizationLevel.Full;
        if (str.equals(anonymizationLevel2.toString())) {
            return anonymizationLevel2;
        }
        AnonymizationLevel anonymizationLevel3 = AnonymizationLevel.None;
        anonymizationLevel3.toString();
        return anonymizationLevel3;
    }

    public void a(Set<String> set) {
        this.R.edit().putStringSet(G, set).commit();
    }
}
