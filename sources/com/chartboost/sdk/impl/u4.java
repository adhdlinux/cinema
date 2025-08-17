package com.chartboost.sdk.impl;

import android.app.Application;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.LocaleList;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import com.chartboost.sdk.internal.Libraries.CBUtility;
import com.chartboost.sdk.privacy.model.CCPA;
import com.chartboost.sdk.privacy.model.COPPA;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import com.chartboost.sdk.privacy.model.GDPR;
import com.chartboost.sdk.privacy.model.LGPD;
import com.unity3d.services.core.device.MimeTypes;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class u4 {

    /* renamed from: a  reason: collision with root package name */
    public final Application f18753a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18754b;

    /* renamed from: c  reason: collision with root package name */
    public final Locale f18755c;

    public enum a {
        BUILTIN_SPEAKER(0),
        WIRED_HEADPHONES(1),
        BLUETOOTH_A2DP(2),
        OTHER(3);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f18761b;

        /* access modifiers changed from: public */
        a(int i2) {
            this.f18761b = i2;
        }

        public final int b() {
            return this.f18761b;
        }
    }

    public u4(Application application) {
        String str;
        Locale locale;
        Intrinsics.f(application, "app");
        this.f18753a = application;
        try {
            str = CBUtility.a();
            Intrinsics.e(str, "{\n        CBUtility.getCurrentTimezone()\n    }");
        } catch (Exception e2) {
            String a2 = w4.f18886a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot retrieve timezone: " + e2);
            str = "Cannot retrieve timezone";
        }
        this.f18754b = str;
        try {
            locale = Locale.getDefault();
        } catch (Exception e3) {
            String a3 = w4.f18886a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "Cannot retrieve locale: " + e3);
            locale = null;
        }
        this.f18755c = locale;
    }

    public final v4 a(i6 i6Var, ua uaVar, String str, j9 j9Var, String str2) {
        String str3;
        String str4;
        String str5;
        Object consent;
        Object consent2;
        j9 j9Var2 = j9Var;
        Intrinsics.f(j9Var2, "privacyApi");
        b d2 = d();
        if (uaVar == null || (str3 = uaVar.c()) == null) {
            str3 = "session not ready";
        }
        String str6 = str3;
        int f2 = uaVar != null ? uaVar.f() : -1;
        String str7 = str2 == null ? "App was not init yet" : str2;
        DataUseConsent a2 = j9Var2.a(GDPR.GDPR_STANDARD);
        Object consent3 = a2 != null ? a2.getConsent() : null;
        String str8 = consent3 instanceof String ? (String) consent3 : null;
        if (str8 == null) {
            str8 = "gdpr not available";
        }
        String str9 = str8;
        DataUseConsent a3 = j9Var2.a(CCPA.CCPA_STANDARD);
        Object consent4 = a3 != null ? a3.getConsent() : null;
        String str10 = consent4 instanceof String ? (String) consent4 : null;
        if (str10 == null) {
            str10 = "ccpa not available";
        }
        String str11 = str10;
        DataUseConsent a4 = j9Var2.a(COPPA.COPPA_STANDARD);
        if (a4 == null || (consent2 = a4.getConsent()) == null || (str4 = consent2.toString()) == null) {
            str4 = "coppa not available";
        }
        String str12 = str4;
        DataUseConsent a5 = j9Var2.a(LGPD.LGPD_STANDARD);
        if (a5 == null || (consent = a5.getConsent()) == null || (str5 = consent.toString()) == null) {
            str5 = "lgpd not available";
        }
        String a6 = a(i6Var);
        String str13 = Build.MANUFACTURER;
        Intrinsics.e(str13, "MANUFACTURER");
        String str14 = Build.MODEL;
        Intrinsics.e(str14, "MODEL");
        String str15 = "Android " + Build.VERSION.RELEASE;
        String g2 = g();
        Locale locale = this.f18755c;
        String country = locale != null ? locale.getCountry() : null;
        return new v4(str6, f2, str7, "9.7.0", false, str9, str11, str12, str5, a6, str13, str14, str15, g2, country == null ? "Cannot retrieve country" : country, h(), this.f18754b, str == null ? "connection type not provided" : str, f(), d2.a(), d2.b(), b(), i(), a(), e(), c(), uaVar != null ? uaVar.d() : 0, uaVar != null ? uaVar.e() : 0, uaVar != null ? uaVar.a() : 0, uaVar != null ? uaVar.b() : -1, 0, 1073741824, (DefaultConstructorMarker) null);
    }

    public final int b() {
        try {
            Object systemService = this.f18753a.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            return (int) ((((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3))) * ((float) 100));
        } catch (Exception e2) {
            String a2 = w4.f18886a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot create environment audio for tracking: " + e2);
            return -1;
        }
    }

    public final long c() {
        try {
            Runtime runtime = Runtime.getRuntime();
            return (runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory())) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        } catch (Exception e2) {
            String a2 = w4.f18886a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot create environment runtime for tracking: " + e2);
            return -1;
        }
    }

    public final b d() {
        boolean z2;
        int i2 = Build.VERSION.SDK_INT;
        try {
            Object systemService = this.f18753a.getSystemService("batterymanager");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.os.BatteryManager");
            BatteryManager batteryManager = (BatteryManager) systemService;
            int intProperty = batteryManager.getIntProperty(4);
            if (i2 >= 23) {
                z2 = batteryManager.isCharging();
            } else {
                z2 = false;
            }
            return new b(intProperty, z2);
        } catch (Exception e2) {
            String a2 = w4.f18886a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot create environment device battery for tracking: " + e2);
            return new b(0, false, 3, (DefaultConstructorMarker) null);
        }
    }

    public final long e() {
        try {
            return new StatFs(this.f18753a.getCacheDir() + "/.chartboost").getAvailableBytes();
        } catch (Exception e2) {
            String a2 = w4.f18886a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot create environment device storage for tracking: " + e2);
            return -1;
        }
    }

    public final String f() {
        try {
            String b2 = CBUtility.b(this.f18753a);
            Intrinsics.e(b2, "{\n            CBUtility.…onAsString(app)\n        }");
            return b2;
        } catch (Exception e2) {
            String a2 = w4.f18886a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot retrieve orientation: " + e2);
            return "Cannot retrieve orientation";
        }
    }

    public final String g() {
        return StringsKt__StringsJVMKt.t("Amazon", Build.MANUFACTURER, true) ? "Amazon" : "Android";
    }

    public final String h() {
        String str;
        String str2 = "Cannot retrieve language";
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                str2 = LocaleList.getDefault().get(0).getLanguage();
            } catch (Exception e2) {
                String a2 = w4.f18886a;
                Intrinsics.e(a2, "TAG");
                w7.a(a2, "Cannot retrieve language: " + e2);
            }
            Intrinsics.e(str2, "{\n            try {\n    …\"\n            }\n        }");
            return str2;
        }
        Locale locale = this.f18755c;
        if (locale != null) {
            str = locale.getLanguage();
        } else {
            str = null;
        }
        if (str == null) {
            return str2;
        }
        return str;
    }

    public final boolean i() {
        try {
            Object systemService = this.f18753a.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            if (((AudioManager) systemService).getRingerMode() != 2) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            String a2 = w4.f18886a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot create environment audio for tracking: " + e2);
            return false;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f18762a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f18763b;

        public b(int i2, boolean z2) {
            this.f18762a = i2;
            this.f18763b = z2;
        }

        public final int a() {
            return this.f18762a;
        }

        public final boolean b() {
            return this.f18763b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f18762a == bVar.f18762a && this.f18763b == bVar.f18763b;
        }

        public int hashCode() {
            int i2 = this.f18762a * 31;
            boolean z2 = this.f18763b;
            if (z2) {
                z2 = true;
            }
            return i2 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "DeviceBattery(batteryLevel=" + this.f18762a + ", isCharging=" + this.f18763b + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? false : z2);
        }
    }

    public final int b(AudioManager audioManager) {
        AudioDeviceInfo audioDeviceInfo = audioManager.getDevices(2)[0];
        Integer valueOf = audioDeviceInfo != null ? Integer.valueOf(audioDeviceInfo.getType()) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            return a.BUILTIN_SPEAKER.b();
        }
        if (valueOf != null && valueOf.intValue() == 4) {
            return a.WIRED_HEADPHONES.b();
        }
        if (valueOf != null && valueOf.intValue() == 8) {
            return a.BLUETOOTH_A2DP.b();
        }
        return a.OTHER.b();
    }

    public final String a(i6 i6Var) {
        if (i6Var != null) {
            String a2 = i6Var.a();
            if (a2 == null) {
                a2 = i6Var.f();
            }
            return a2 == null ? "unknown" : a2;
        }
    }

    public final int a() {
        try {
            Object systemService = this.f18753a.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            if (Build.VERSION.SDK_INT >= 23) {
                return b(audioManager);
            }
            return a(audioManager);
        } catch (Exception e2) {
            String a2 = w4.f18886a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot create environment audio output for tracking: " + e2);
            return a.OTHER.b();
        }
    }

    public final int a(AudioManager audioManager) {
        if (audioManager.isSpeakerphoneOn()) {
            return a.BUILTIN_SPEAKER.b();
        }
        return a.OTHER.b();
    }
}
