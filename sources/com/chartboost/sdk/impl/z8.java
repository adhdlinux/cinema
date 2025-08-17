package com.chartboost.sdk.impl;

import android.os.Build;
import com.chartboost.sdk.impl.u;
import com.chartboost.sdk.privacy.model.COPPA;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import com.chartboost.sdk.privacy.model.GDPR;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class z8 {

    /* renamed from: j  reason: collision with root package name */
    public static final String f19125j = "z8";

    /* renamed from: k  reason: collision with root package name */
    public static Integer f19126k;

    /* renamed from: l  reason: collision with root package name */
    public static final String f19127l = Build.VERSION.RELEASE;

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f19128a = new JSONObject();

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f19129b = new JSONObject();

    /* renamed from: c  reason: collision with root package name */
    public final JSONArray f19130c = new JSONArray();

    /* renamed from: d  reason: collision with root package name */
    public final JSONObject f19131d = new JSONObject();

    /* renamed from: e  reason: collision with root package name */
    public final JSONObject f19132e = new JSONObject();

    /* renamed from: f  reason: collision with root package name */
    public final JSONObject f19133f = new JSONObject();

    /* renamed from: g  reason: collision with root package name */
    public final ea f19134g;

    /* renamed from: h  reason: collision with root package name */
    public final o f19135h;

    /* renamed from: i  reason: collision with root package name */
    public final q8 f19136i;

    public z8(ea eaVar, o oVar, q8 q8Var) {
        f19126k = eaVar.e();
        this.f19134g = eaVar;
        this.f19135h = oVar;
        this.f19136i = q8Var;
        o();
        l();
        m();
        k();
        n();
        p();
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        Object obj = JSONObject.NULL;
        h2.a(jSONObject, "lat", obj);
        h2.a(jSONObject, "lon", obj);
        h2.a(jSONObject, "country", this.f19134g.f17624c);
        h2.a(jSONObject, "type", 2);
        return jSONObject;
    }

    public final Integer b() {
        ea eaVar = this.f19134g;
        if (eaVar != null) {
            return eaVar.f().b();
        }
        return null;
    }

    public final int c() {
        ea eaVar = this.f19134g;
        if (eaVar == null || eaVar.f().a() == null) {
            return 0;
        }
        return this.f19134g.f().a().intValue();
    }

    public final Collection d() {
        ea eaVar = this.f19134g;
        if (eaVar != null) {
            return eaVar.f().g();
        }
        return new ArrayList();
    }

    public final int e() {
        ea eaVar = this.f19134g;
        if (eaVar == null || eaVar.f().c() == null) {
            return 0;
        }
        return this.f19134g.f().c().intValue();
    }

    public JSONObject f() {
        return this.f19128a;
    }

    public final int g() {
        h8 d2 = this.f19134g.g().d();
        if (d2 != null) {
            return d2.c();
        }
        return 0;
    }

    public final String h() {
        u uVar = this.f19135h.f18267a;
        if (uVar == u.b.f18736g) {
            w7.b(f19125j, "INTERSTITIAL NOT COMPATIBLE WITH OPENRTB");
        } else if (uVar == u.c.f18737g) {
            w7.b(f19125j, "REWARDED_VIDEO NOT COMPATIBLE WITH OPENRTB");
        }
        return this.f19135h.f18267a.b().toLowerCase(Locale.ROOT);
    }

    public final String i() {
        ea eaVar = this.f19134g;
        if (eaVar != null) {
            return eaVar.f().f();
        }
        return null;
    }

    public final Integer j() {
        return Integer.valueOf(this.f19135h.f18267a.f() ? 1 : 0);
    }

    public final void k() {
        h2.a(this.f19131d, "id", this.f19134g.f17629h);
        JSONObject jSONObject = this.f19131d;
        Object obj = JSONObject.NULL;
        h2.a(jSONObject, "name", obj);
        h2.a(this.f19131d, "bundle", this.f19134g.f17627f);
        h2.a(this.f19131d, "storeurl", obj);
        JSONObject jSONObject2 = new JSONObject();
        h2.a(jSONObject2, "id", obj);
        h2.a(jSONObject2, "name", obj);
        h2.a(this.f19131d, "publisher", jSONObject2);
        h2.a(this.f19131d, "cat", obj);
        h2.a(this.f19128a, "app", this.f19131d);
    }

    public final void l() {
        i6 c2 = this.f19134g.c();
        h2.a(this.f19129b, "devicetype", f19126k);
        h2.a(this.f19129b, "w", Integer.valueOf(this.f19134g.b().c()));
        h2.a(this.f19129b, "h", Integer.valueOf(this.f19134g.b().a()));
        h2.a(this.f19129b, "ifa", c2.a());
        h2.a(this.f19129b, "osv", f19127l);
        h2.a(this.f19129b, "lmt", Integer.valueOf(c2.e().b()));
        h2.a(this.f19129b, "connectiontype", Integer.valueOf(g()));
        h2.a(this.f19129b, "os", "Android");
        h2.a(this.f19129b, "geo", a());
        h2.a(this.f19129b, "ip", JSONObject.NULL);
        h2.a(this.f19129b, "language", this.f19134g.f17625d);
        h2.a(this.f19129b, "ua", lc.f18142b.a());
        h2.a(this.f19129b, "make", this.f19134g.f17632k);
        h2.a(this.f19129b, "model", this.f19134g.f17622a);
        h2.a(this.f19129b, "carrier", this.f19134g.f17635n);
        h2.a(this.f19129b, "ext", a(c2, this.f19136i));
        h2.a(this.f19128a, "device", this.f19129b);
    }

    public final void m() {
        JSONObject jSONObject = new JSONObject();
        Object obj = JSONObject.NULL;
        h2.a(jSONObject, "id", obj);
        JSONObject jSONObject2 = new JSONObject();
        h2.a(jSONObject2, "w", this.f19135h.f18269c);
        h2.a(jSONObject2, "h", this.f19135h.f18268b);
        h2.a(jSONObject2, "btype", obj);
        h2.a(jSONObject2, "battr", obj);
        h2.a(jSONObject2, "pos", obj);
        h2.a(jSONObject2, "topframe", obj);
        h2.a(jSONObject2, "api", obj);
        JSONObject jSONObject3 = new JSONObject();
        h2.a(jSONObject3, "placementtype", h());
        h2.a(jSONObject3, "playableonly", obj);
        h2.a(jSONObject3, "allowscustomclosebutton", obj);
        h2.a(jSONObject2, "ext", jSONObject3);
        h2.a(jSONObject, "banner", jSONObject2);
        h2.a(jSONObject, "instl", j());
        h2.a(jSONObject, "tagid", this.f19135h.f18270d);
        h2.a(jSONObject, "displaymanager", "Chartboost-Android-SDK");
        h2.a(jSONObject, "displaymanagerver", this.f19134g.f17628g);
        h2.a(jSONObject, "bidfloor", obj);
        h2.a(jSONObject, "bidfloorcur", "USD");
        h2.a(jSONObject, "secure", 1);
        this.f19130c.put(jSONObject);
        h2.a(this.f19128a, "imp", this.f19130c);
    }

    public final void n() {
        Integer b2 = b();
        if (b2 != null) {
            h2.a(this.f19132e, COPPA.COPPA_STANDARD, b2);
        }
        JSONObject jSONObject = new JSONObject();
        h2.a(jSONObject, GDPR.GDPR_STANDARD, Integer.valueOf(e()));
        for (DataUseConsent dataUseConsent : d()) {
            if (!dataUseConsent.getPrivacyStandard().equals(COPPA.COPPA_STANDARD)) {
                h2.a(jSONObject, dataUseConsent.getPrivacyStandard(), dataUseConsent.getConsent());
            }
        }
        h2.a(this.f19132e, "ext", jSONObject);
        h2.a(this.f19128a, "regs", this.f19132e);
    }

    public final void o() {
        JSONObject jSONObject = this.f19128a;
        Object obj = JSONObject.NULL;
        h2.a(jSONObject, "id", obj);
        h2.a(this.f19128a, "test", obj);
        h2.a(this.f19128a, "cur", new JSONArray().put("USD"));
        h2.a(this.f19128a, "at", 2);
    }

    public final void p() {
        h2.a(this.f19133f, "id", JSONObject.NULL);
        h2.a(this.f19133f, "geo", a());
        String i2 = i();
        if (i2 != null) {
            h2.a(this.f19133f, "consent", i2);
        }
        JSONObject jSONObject = new JSONObject();
        h2.a(jSONObject, "consent", Integer.valueOf(c()));
        h2.a(jSONObject, "impdepth", Integer.valueOf(this.f19135h.f18271e));
        h2.a(this.f19133f, "ext", jSONObject);
        h2.a(this.f19128a, "user", this.f19133f);
    }

    public final JSONObject a(i6 i6Var, q8 q8Var) {
        JSONObject jSONObject = new JSONObject();
        if (i6Var.c() != null) {
            h2.a(jSONObject, "appsetid", i6Var.c());
        }
        if (i6Var.d() != null) {
            h2.a(jSONObject, "appsetidscope", i6Var.d());
        }
        e9 c2 = q8Var.c();
        if (q8Var.g() && c2 != null) {
            h2.a(jSONObject, "omidpn", c2.a());
            h2.a(jSONObject, "omidpv", c2.b());
        }
        return jSONObject;
    }
}
