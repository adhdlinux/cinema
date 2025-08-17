package com.chartboost.sdk.impl;

import com.applovin.sdk.AppLovinEventParameters;
import com.chartboost.sdk.impl.t2;
import com.unity3d.services.core.di.ServiceProvider;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class a3 extends t2 {

    /* renamed from: s  reason: collision with root package name */
    public final JSONObject f17196s;

    /* renamed from: t  reason: collision with root package name */
    public final JSONObject f17197t;

    /* renamed from: u  reason: collision with root package name */
    public final JSONObject f17198u;

    /* renamed from: v  reason: collision with root package name */
    public final JSONObject f17199v;

    public a3(String str, ea eaVar, i9 i9Var, t2.a aVar, z4 z4Var) {
        this("POST", "https://live.chartboost.com", str, eaVar, i9Var, (String) null, aVar, z4Var);
    }

    public void b(String str, Object obj) {
        h2.a(this.f17199v, str, obj);
        a("ad", (Object) this.f17199v);
    }

    public void c(String str, Object obj) {
        h2.a(this.f17196s, str, obj);
        a(ServiceProvider.NAMED_SDK, (Object) this.f17196s);
    }

    public void g() {
        h2.a(this.f17197t, "app", this.f18623n.f17629h);
        h2.a(this.f17197t, "bundle", this.f18623n.f17626e);
        h2.a(this.f17197t, "bundle_id", this.f18623n.f17627f);
        h2.a(this.f17197t, "session_id", "");
        h2.a(this.f17197t, "ui", -1);
        JSONObject jSONObject = this.f17197t;
        Boolean bool = Boolean.FALSE;
        h2.a(jSONObject, "test_mode", bool);
        a("app", (Object) this.f17197t);
        boolean z2 = false;
        h2.a(this.f17198u, "carrier", h2.a(h2.a("carrier_name", (Object) this.f18623n.f17634m.optString("carrier-name")), h2.a("mobile_country_code", (Object) this.f18623n.f17634m.optString("mobile-country-code")), h2.a("mobile_network_code", (Object) this.f18623n.f17634m.optString("mobile-network-code")), h2.a("iso_country_code", (Object) this.f18623n.f17634m.optString("iso-country-code")), h2.a("phone_type", (Object) Integer.valueOf(this.f18623n.f17634m.optInt("phone-type")))));
        h2.a(this.f17198u, "model", this.f18623n.f17622a);
        h2.a(this.f17198u, "make", this.f18623n.f17632k);
        h2.a(this.f17198u, "device_type", this.f18623n.f17631j);
        h2.a(this.f17198u, "actual_device_type", this.f18623n.f17633l);
        h2.a(this.f17198u, "os", this.f18623n.f17623b);
        h2.a(this.f17198u, "country", this.f18623n.f17624c);
        h2.a(this.f17198u, "language", this.f18623n.f17625d);
        h2.a(this.f17198u, "timestamp", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.f18623n.j().a())));
        h2.a(this.f17198u, "reachability", this.f18623n.g().b());
        h2.a(this.f17198u, "is_portrait", Boolean.valueOf(this.f18623n.b().k()));
        h2.a(this.f17198u, "scale", Float.valueOf(this.f18623n.b().h()));
        h2.a(this.f17198u, "timezone", this.f18623n.f17636o);
        h2.a(this.f17198u, "connectiontype", Integer.valueOf(this.f18623n.g().d().c()));
        h2.a(this.f17198u, "dw", Integer.valueOf(this.f18623n.b().c()));
        h2.a(this.f17198u, "dh", Integer.valueOf(this.f18623n.b().a()));
        h2.a(this.f17198u, "dpi", this.f18623n.b().d());
        h2.a(this.f17198u, "w", Integer.valueOf(this.f18623n.b().j()));
        h2.a(this.f17198u, "h", Integer.valueOf(this.f18623n.b().e()));
        h2.a(this.f17198u, "user_agent", lc.f18142b.a());
        h2.a(this.f17198u, "device_family", "");
        h2.a(this.f17198u, "retina", bool);
        i6 c2 = this.f18623n.c();
        if (c2 != null) {
            h2.a(this.f17198u, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY, c2.b());
            yb e2 = c2.e();
            if (e2 != yb.TRACKING_UNKNOWN) {
                if (e2 == yb.TRACKING_LIMITED) {
                    z2 = true;
                }
                h2.a(this.f17198u, "limit_ad_tracking", Boolean.valueOf(z2));
            }
            Integer d2 = c2.d();
            if (d2 != null) {
                h2.a(this.f17198u, "appsetidscope", d2);
            }
        } else {
            w7.e("CBWebViewRequest", "Missing identity in the CB SDK. This will affect ads performance.");
        }
        k9 f2 = this.f18623n.f();
        String f3 = f2.f();
        if (f3 != null) {
            h2.a(this.f17198u, "consent", f3);
        }
        h2.a(this.f17198u, "pidatauseconsent", f2.d());
        h2.a(this.f17198u, "privacy", f2.e());
        a("device", (Object) this.f17198u);
        h2.a(this.f17196s, ServiceProvider.NAMED_SDK, this.f18623n.f17628g);
        if (this.f18623n.d() != null) {
            h2.a(this.f17196s, "mediation", this.f18623n.d().c());
            h2.a(this.f17196s, "mediation_version", this.f18623n.d().b());
            h2.a(this.f17196s, "adapter_version", this.f18623n.d().a());
        }
        h2.a(this.f17196s, "commit_hash", "827fd3ad693d520953527c856c9569f70402c65c");
        String a2 = this.f18623n.a().a();
        if (!y0.b().a((CharSequence) a2)) {
            h2.a(this.f17196s, "config_variant", a2);
        }
        a(ServiceProvider.NAMED_SDK, (Object) this.f17196s);
        h2.a(this.f17199v, "session", Integer.valueOf(this.f18623n.i()));
        if (this.f17199v.isNull("cache")) {
            h2.a(this.f17199v, "cache", bool);
        }
        if (this.f17199v.isNull(AppLovinEventParameters.REVENUE_AMOUNT)) {
            h2.a(this.f17199v, AppLovinEventParameters.REVENUE_AMOUNT, 0);
        }
        if (this.f17199v.isNull("retry_count")) {
            h2.a(this.f17199v, "retry_count", 0);
        }
        if (this.f17199v.isNull("location")) {
            h2.a(this.f17199v, "location", "");
        }
        a("ad", (Object) this.f17199v);
    }

    public a3(String str, String str2, String str3, ea eaVar, i9 i9Var, String str4, t2.a aVar, z4 z4Var) {
        super(str, str2, str3, eaVar, i9Var, str4, aVar, z4Var);
        this.f17196s = new JSONObject();
        this.f17197t = new JSONObject();
        this.f17198u = new JSONObject();
        this.f17199v = new JSONObject();
    }
}
