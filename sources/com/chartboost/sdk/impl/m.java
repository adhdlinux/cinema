package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.l;
import com.chartboost.sdk.impl.t2;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.impl.u;
import com.chartboost.sdk.internal.Model.CBError;
import java.net.URL;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

public final class m implements l, t2.a, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final u f18166a;

    /* renamed from: b  reason: collision with root package name */
    public final v5 f18167b;

    /* renamed from: c  reason: collision with root package name */
    public final ca f18168c;

    /* renamed from: d  reason: collision with root package name */
    public final q2 f18169d;

    /* renamed from: e  reason: collision with root package name */
    public final f0 f18170e;

    /* renamed from: f  reason: collision with root package name */
    public final x8 f18171f;

    /* renamed from: g  reason: collision with root package name */
    public final q8 f18172g;

    /* renamed from: h  reason: collision with root package name */
    public final a5 f18173h;

    /* renamed from: i  reason: collision with root package name */
    public ea f18174i;

    /* renamed from: j  reason: collision with root package name */
    public u7 f18175j;

    /* renamed from: k  reason: collision with root package name */
    public Function1 f18176k;

    public m(u uVar, v5 v5Var, ca caVar, q2 q2Var, f0 f0Var, x8 x8Var, q8 q8Var, a5 a5Var) {
        Intrinsics.f(uVar, "adTraits");
        Intrinsics.f(v5Var, "fileCache");
        Intrinsics.f(caVar, "requestBodyBuilder");
        Intrinsics.f(q2Var, "networkService");
        Intrinsics.f(f0Var, "adUnitParser");
        Intrinsics.f(x8Var, "openRTBAdUnitParser");
        Intrinsics.f(q8Var, "openMeasurementManager");
        Intrinsics.f(a5Var, "eventTracker");
        this.f18166a = uVar;
        this.f18167b = v5Var;
        this.f18168c = caVar;
        this.f18169d = q2Var;
        this.f18170e = f0Var;
        this.f18171f = x8Var;
        this.f18172g = q8Var;
        this.f18173h = a5Var;
    }

    public String a(JSONObject jSONObject, String str, String str2) {
        return l.a.a(this, jSONObject, str, str2);
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f18173h.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18173h.clearFromStorage(qbVar);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18173h.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f18173h.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f18173h.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18173h.track(qbVar);
    }

    public void a(u7 u7Var, Function1 function1) {
        Intrinsics.f(u7Var, "params");
        Intrinsics.f(function1, "callback");
        this.f18175j = u7Var;
        this.f18176k = function1;
        this.f18174i = this.f18168c.a();
        String d2 = u7Var.a().d();
        Integer b2 = u7Var.b();
        int intValue = b2 != null ? b2.intValue() : 0;
        Integer c2 = u7Var.c();
        int intValue2 = c2 != null ? c2.intValue() : 0;
        boolean e2 = u7Var.e();
        ea eaVar = this.f18174i;
        if (eaVar == null) {
            Intrinsics.x("requestBodyFields");
            eaVar = null;
        }
        t2 a2 = a(d2, intValue, intValue2, e2, eaVar, (t2.a) this, this.f18172g);
        a2.f18097i = 1;
        this.f18169d.a(a2);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m36clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18173h.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m37persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18173h.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m38refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f18173h.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m39store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f18173h.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m40track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18173h.track(qbVar);
    }

    public final v a(ea eaVar, JSONObject jSONObject, String str) {
        v a2;
        try {
            u uVar = this.f18166a;
            u.a aVar = u.a.f18735g;
            if (Intrinsics.a(uVar, aVar)) {
                a2 = this.f18171f.a((u) aVar, jSONObject);
            } else if (!eaVar.a().b()) {
                return null;
            } else {
                a2 = this.f18170e.a(jSONObject);
            }
            return a2;
        } catch (Exception e2) {
            tb.a aVar2 = tb.a.GET_RESPONSE_PARSING_ERROR;
            JSONObject jSONObject2 = new JSONObject();
            String message = e2.getMessage();
            if (message == null) {
                message = "no message";
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.e(jSONObject3, "response.toString()");
            track((qb) new d4(aVar2, a(jSONObject2, message, jSONObject3), this.f18166a.b(), str, (Mediation) null, (ib) null, 48, (DefaultConstructorMarker) null));
            return null;
        }
    }

    public final t2 a(String str, int i2, int i3, boolean z2, ea eaVar, t2.a aVar, q8 q8Var) {
        int a2;
        u uVar = this.f18166a;
        if (Intrinsics.a(uVar, u.c.f18737g)) {
            a2 = eaVar.h().e();
        } else if (Intrinsics.a(uVar, u.b.f18736g)) {
            a2 = eaVar.h().d();
        } else {
            a2 = eaVar.h().a();
        }
        int i4 = a2;
        if (Intrinsics.a(this.f18166a, u.a.f18735g)) {
            return a(aVar, i2, i3, str, i4, eaVar, q8Var);
        }
        return a(aVar, str, i4, z2, eaVar, q8Var);
    }

    public final a3 a(t2.a aVar, String str, int i2, boolean z2, ea eaVar, q8 q8Var) {
        a3 a3Var;
        e9 c2;
        String e2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f40434a;
        String format = String.format(this.f18166a.e(), Arrays.copyOf(new Object[]{eaVar.a().c()}, 1));
        Intrinsics.e(format, "format(format, *args)");
        la laVar = la.f18112a;
        if (!laVar.g() || (e2 = laVar.e()) == null || e2.length() == 0) {
            a3Var = new a3(format, eaVar, i9.NORMAL, aVar, this.f18173h);
        } else {
            URL url = new URL(laVar.e());
            a3Var = new a3("POST", url.getProtocol() + "://" + url.getHost(), url.getPath(), eaVar, i9.NORMAL, (String) null, aVar, this.f18173h);
        }
        JSONObject f2 = this.f18167b.f();
        Intrinsics.e(f2, "fileCache.webViewCacheAssets");
        a3Var.b("cache_assets", f2);
        String str2 = str;
        a3Var.b("location", str);
        a3Var.b("imp_depth", Integer.valueOf(i2));
        if (q8Var.g() && (c2 = q8Var.c()) != null) {
            a3Var.c("omidpn", c2.a());
            a3Var.c("omidpv", c2.b());
        }
        a3Var.b("cache", Boolean.valueOf(z2));
        a3Var.f18627r = true;
        return a3Var;
    }

    public final y8 a(t2.a aVar, int i2, int i3, String str, int i4, ea eaVar, q8 q8Var) {
        g8 g8Var;
        String e2;
        la laVar = la.f18112a;
        if (!laVar.g() || (e2 = laVar.e()) == null || e2.length() == 0) {
            g8Var = new g8("https://da.chartboost.com", this.f18166a.e(), eaVar, i9.NORMAL, aVar);
        } else {
            URL url = new URL(laVar.e());
            g8Var = new g8("POST", url.getProtocol() + "://" + url.getHost(), url.getPath(), eaVar, i9.NORMAL, aVar);
        }
        return new y8(g8Var, new o(this.f18166a, Integer.valueOf(i2), Integer.valueOf(i3), str, i4), q8Var, this.f18173h);
    }

    public void a(t2 t2Var, JSONObject jSONObject) {
        if (t2Var == null || jSONObject == null) {
            a("Unexpected response");
            return;
        }
        ea eaVar = this.f18174i;
        Unit unit = null;
        if (eaVar == null) {
            Intrinsics.x("requestBodyFields");
            eaVar = null;
        }
        u7 u7Var = this.f18175j;
        if (u7Var == null) {
            Intrinsics.x("params");
            u7Var = null;
        }
        JSONObject a2 = u7Var.d().a(jSONObject);
        u7 u7Var2 = this.f18175j;
        if (u7Var2 == null) {
            Intrinsics.x("params");
            u7Var2 = null;
        }
        v a3 = a(eaVar, a2, u7Var2.a().d());
        if (a3 != null) {
            a(a3, t2Var);
            unit = Unit.f40298a;
        }
        if (unit == null) {
            a("Error parsing response");
        }
    }

    public final void a(v vVar, t2 t2Var) {
        Function1 function1 = this.f18176k;
        u7 u7Var = null;
        if (function1 == null) {
            Intrinsics.x("callback");
            function1 = null;
        }
        u7 u7Var2 = this.f18175j;
        if (u7Var2 == null) {
            Intrinsics.x("params");
        } else {
            u7Var = u7Var2;
        }
        function1.invoke(new v7(u7Var.a(), vVar, (CBError) null, t2Var.f18096h, t2Var.f18095g));
    }

    public final void a(String str) {
        Function1 function1 = this.f18176k;
        u7 u7Var = null;
        if (function1 == null) {
            Intrinsics.x("callback");
            function1 = null;
        }
        u7 u7Var2 = this.f18175j;
        if (u7Var2 == null) {
            Intrinsics.x("params");
        } else {
            u7Var = u7Var2;
        }
        function1.invoke(new v7(u7Var.a(), (v) null, new CBError(CBError.a.UNEXPECTED_RESPONSE, str), 0, 0, 26, (DefaultConstructorMarker) null));
    }

    public void a(t2 t2Var, CBError cBError) {
        Function1 function1 = this.f18176k;
        u7 u7Var = null;
        if (function1 == null) {
            Intrinsics.x("callback");
            function1 = null;
        }
        u7 u7Var2 = this.f18175j;
        if (u7Var2 == null) {
            Intrinsics.x("params");
        } else {
            u7Var = u7Var2;
        }
        b1 a2 = u7Var.a();
        if (cBError == null) {
            cBError = new CBError(CBError.a.INVALID_RESPONSE, "Error parsing response");
        }
        function1.invoke(new v7(a2, (v) null, cBError, 0, 0, 26, (DefaultConstructorMarker) null));
    }
}
