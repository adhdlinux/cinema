package com.chartboost.sdk.impl;

import android.os.Build;
import com.chartboost.sdk.internal.Libraries.CBUtility;
import com.unity3d.services.core.di.ServiceProvider;
import java.util.Locale;
import org.json.JSONObject;

public class ea {

    /* renamed from: a  reason: collision with root package name */
    public final String f17622a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17623b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17624c;

    /* renamed from: d  reason: collision with root package name */
    public final String f17625d;

    /* renamed from: e  reason: collision with root package name */
    public final String f17626e;

    /* renamed from: f  reason: collision with root package name */
    public final String f17627f;

    /* renamed from: g  reason: collision with root package name */
    public final String f17628g;

    /* renamed from: h  reason: collision with root package name */
    public final String f17629h;

    /* renamed from: i  reason: collision with root package name */
    public final String f17630i;

    /* renamed from: j  reason: collision with root package name */
    public final String f17631j;

    /* renamed from: k  reason: collision with root package name */
    public final String f17632k;

    /* renamed from: l  reason: collision with root package name */
    public final String f17633l;

    /* renamed from: m  reason: collision with root package name */
    public final JSONObject f17634m;

    /* renamed from: n  reason: collision with root package name */
    public final String f17635n;

    /* renamed from: o  reason: collision with root package name */
    public final String f17636o;

    /* renamed from: p  reason: collision with root package name */
    public final Integer f17637p;

    /* renamed from: q  reason: collision with root package name */
    public final b3 f17638q;

    /* renamed from: r  reason: collision with root package name */
    public final k9 f17639r;

    /* renamed from: s  reason: collision with root package name */
    public final ua f17640s;

    /* renamed from: t  reason: collision with root package name */
    public final i6 f17641t;

    /* renamed from: u  reason: collision with root package name */
    public final t9 f17642u;

    /* renamed from: v  reason: collision with root package name */
    public final hb f17643v;

    /* renamed from: w  reason: collision with root package name */
    public final z3 f17644w;

    /* renamed from: x  reason: collision with root package name */
    public final i4 f17645x;

    /* renamed from: y  reason: collision with root package name */
    public final z7 f17646y;

    public ea(String str, String str2, i6 i6Var, t9 t9Var, b3 b3Var, ua uaVar, hb hbVar, k9 k9Var, z3 z3Var, i4 i4Var, z7 z7Var) {
        String str3;
        String str4;
        this.f17641t = i6Var;
        this.f17642u = t9Var;
        this.f17638q = b3Var;
        this.f17640s = uaVar;
        this.f17643v = hbVar;
        this.f17639r = k9Var;
        this.f17629h = str;
        this.f17630i = str2;
        this.f17644w = z3Var;
        this.f17645x = i4Var;
        this.f17646y = z7Var;
        String str5 = Build.PRODUCT;
        if (ServiceProvider.NAMED_SDK.equals(str5) || "google_sdk".equals(str5) || ((str4 = Build.MANUFACTURER) != null && str4.contains("Genymotion"))) {
            this.f17622a = "Android Simulator";
        } else {
            this.f17622a = Build.MODEL;
        }
        String str6 = Build.MANUFACTURER;
        if (str6 == null) {
            str3 = "unknown";
        } else {
            str3 = str6;
        }
        this.f17632k = str3;
        this.f17631j = str6 + " " + Build.MODEL;
        this.f17633l = i4Var.b();
        this.f17623b = "Android " + Build.VERSION.RELEASE;
        this.f17624c = Locale.getDefault().getCountry();
        this.f17625d = Locale.getDefault().getLanguage();
        this.f17628g = "9.7.0";
        this.f17626e = i4Var.i();
        this.f17627f = i4Var.g();
        this.f17635n = b(b3Var);
        this.f17634m = a(b3Var);
        this.f17636o = CBUtility.a();
        this.f17637p = t9Var.a();
    }

    public final JSONObject a(b3 b3Var) {
        if (b3Var != null) {
            return a(b3Var, new d3());
        }
        return new JSONObject();
    }

    public final String b(b3 b3Var) {
        return b3Var != null ? b3Var.d() : "";
    }

    public i6 c() {
        return this.f17641t;
    }

    public z7 d() {
        return this.f17646y;
    }

    public Integer e() {
        return Integer.valueOf(this.f17645x.f());
    }

    public k9 f() {
        return this.f17639r;
    }

    public t9 g() {
        return this.f17642u;
    }

    public ua h() {
        return this.f17640s;
    }

    public int i() {
        ua uaVar = this.f17640s;
        if (uaVar != null) {
            return uaVar.f();
        }
        return -1;
    }

    public hb j() {
        return this.f17643v;
    }

    public i4 b() {
        return this.f17645x;
    }

    public JSONObject a(b3 b3Var, d3 d3Var) {
        if (d3Var != null) {
            return d3Var.a(b3Var);
        }
        return new JSONObject();
    }

    public z3 a() {
        return this.f17644w;
    }
}
