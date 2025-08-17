package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.pa;
import com.chartboost.sdk.privacy.model.COPPA;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import com.chartboost.sdk.privacy.model.GDPR;
import java.util.List;
import org.json.JSONObject;

public class j9 {

    /* renamed from: a  reason: collision with root package name */
    public final p9 f17992a;

    /* renamed from: b  reason: collision with root package name */
    public final y5 f17993b;

    /* renamed from: c  reason: collision with root package name */
    public final u9 f17994c;

    /* renamed from: d  reason: collision with root package name */
    public final z5 f17995d;

    /* renamed from: e  reason: collision with root package name */
    public final a6 f17996e;

    /* renamed from: f  reason: collision with root package name */
    public final bb f17997f;

    /* renamed from: g  reason: collision with root package name */
    public pa.b f17998g;

    public j9(p9 p9Var, y5 y5Var, u9 u9Var, z5 z5Var, a6 a6Var, bb bbVar) {
        this.f17992a = p9Var;
        this.f17993b = y5Var;
        this.f17994c = u9Var;
        this.f17995d = z5Var;
        this.f17996e = a6Var;
        this.f17997f = bbVar;
    }

    public void a(pa.b bVar) {
        this.f17998g = bVar;
    }

    public void b(String str) {
        u9 u9Var = this.f17994c;
        if (u9Var != null) {
            u9Var.a(str);
        }
    }

    public int c() {
        return d().equals("-1") ^ true ? 1 : 0;
    }

    public String d() {
        DataUseConsent a2 = this.f17993b.a(GDPR.GDPR_STANDARD);
        if (a2 == null) {
            return "-1";
        }
        return (String) a2.getConsent();
    }

    public JSONObject e() {
        List f2 = f();
        z5 z5Var = this.f17995d;
        if (z5Var == null || f2 == null) {
            return null;
        }
        return z5Var.a(f2);
    }

    public List f() {
        pa.b bVar;
        a6 a6Var = this.f17996e;
        if (a6Var == null || (bVar = this.f17998g) == null) {
            return null;
        }
        return a6Var.a(bVar);
    }

    public k9 g() {
        return new k9(Integer.valueOf(a()), f(), Integer.valueOf(c()), b(), e(), d(), this.f17997f.a());
    }

    public void a(DataUseConsent dataUseConsent) {
        p9 p9Var = this.f17992a;
        if (p9Var != null) {
            p9Var.a(dataUseConsent);
        }
    }

    public Integer b() {
        COPPA coppa = (COPPA) a(COPPA.COPPA_STANDARD);
        if (coppa == null) {
            return null;
        }
        if (coppa.getConsent().booleanValue()) {
            return 1;
        }
        return 0;
    }

    public DataUseConsent a(String str) {
        y5 y5Var = this.f17993b;
        if (y5Var != null) {
            return y5Var.a(str);
        }
        return null;
    }

    public int a() {
        return d().equals(GDPR.GDPR_CONSENT.BEHAVIORAL.getValue()) ? 1 : 0;
    }
}
