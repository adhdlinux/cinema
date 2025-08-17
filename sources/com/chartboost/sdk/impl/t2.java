package com.chartboost.sdk.impl;

import com.chartboost.sdk.ChartboostDSP;
import com.chartboost.sdk.impl.h2;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.internal.Libraries.CBUtility;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.Networking.NetworkHelper;
import com.original.tase.model.socket.UserResponces;
import com.unity3d.services.core.di.ServiceProvider;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.trakt5.TraktV2;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class t2 extends l2 {

    /* renamed from: k  reason: collision with root package name */
    public final String f18620k;

    /* renamed from: l  reason: collision with root package name */
    public final String f18621l;

    /* renamed from: m  reason: collision with root package name */
    public final a f18622m;

    /* renamed from: n  reason: collision with root package name */
    public final ea f18623n;

    /* renamed from: o  reason: collision with root package name */
    public final z4 f18624o;

    /* renamed from: p  reason: collision with root package name */
    public JSONObject f18625p;

    /* renamed from: q  reason: collision with root package name */
    public JSONArray f18626q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f18627r;

    public interface a {
        void a(t2 t2Var, CBError cBError);

        void a(t2 t2Var, JSONObject jSONObject);
    }

    public t2(String str, String str2, ea eaVar, i9 i9Var, a aVar, z4 z4Var) {
        this(str, str2, eaVar, i9Var, (String) null, aVar, z4Var);
    }

    public final JSONObject b(int i2, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i2);
            jSONObject.put("message", str);
        } catch (JSONException e2) {
            w7.a("CBRequest", "Error creating JSON", e2);
        }
        return jSONObject;
    }

    public void g() {
        boolean z2;
        a("app", (Object) this.f18623n.f17629h);
        a("model", (Object) this.f18623n.f17622a);
        a("make", (Object) this.f18623n.f17632k);
        a("device_type", (Object) this.f18623n.f17631j);
        a("actual_device_type", (Object) this.f18623n.f17633l);
        a("os", (Object) this.f18623n.f17623b);
        a("country", (Object) this.f18623n.f17624c);
        a("language", (Object) this.f18623n.f17625d);
        a(ServiceProvider.NAMED_SDK, (Object) this.f18623n.f17628g);
        a("user_agent", (Object) lc.f18142b.a());
        a("timestamp", (Object) String.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.f18623n.j().a())));
        a("session", (Object) Integer.valueOf(this.f18623n.i()));
        a("reachability", (Object) this.f18623n.g().b());
        a("is_portrait", (Object) Boolean.valueOf(this.f18623n.b().k()));
        a("scale", (Object) Float.valueOf(this.f18623n.b().h()));
        a("bundle", (Object) this.f18623n.f17626e);
        a("bundle_id", (Object) this.f18623n.f17627f);
        a("carrier", (Object) this.f18623n.f17634m);
        z7 d2 = this.f18623n.d();
        if (d2 != null) {
            a("mediation", (Object) d2.c());
            a("mediation_version", (Object) d2.b());
            a("adapter_version", (Object) d2.a());
        }
        a("timezone", (Object) this.f18623n.f17636o);
        a("connectiontype", (Object) Integer.valueOf(this.f18623n.g().d().c()));
        a("dw", (Object) Integer.valueOf(this.f18623n.b().c()));
        a("dh", (Object) Integer.valueOf(this.f18623n.b().a()));
        a("dpi", (Object) this.f18623n.b().d());
        a("w", (Object) Integer.valueOf(this.f18623n.b().j()));
        a("h", (Object) Integer.valueOf(this.f18623n.b().e()));
        a("commit_hash", (Object) "827fd3ad693d520953527c856c9569f70402c65c");
        i6 c2 = this.f18623n.c();
        if (c2 != null) {
            a(InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY, (Object) c2.b());
            yb e2 = c2.e();
            if (e2 != yb.TRACKING_UNKNOWN) {
                if (e2 == yb.TRACKING_LIMITED) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                a("limit_ad_tracking", (Object) Boolean.valueOf(z2));
            }
            Integer d3 = c2.d();
            if (d3 != null) {
                a("appsetidscope", (Object) d3);
            }
        } else {
            w7.e("CBRequest", "Missing identity in the CB SDK. This will affect ads performance.");
        }
        k9 f2 = this.f18623n.f();
        String f3 = f2.f();
        if (f3 != null) {
            a("consent", (Object) f3);
        }
        a("pidatauseconsent", (Object) f2.d());
        String a2 = this.f18623n.a().a();
        if (!y0.b().a((CharSequence) a2)) {
            a("config_variant", (Object) a2);
        }
        a("privacy", (Object) f2.e());
    }

    public final String h() {
        h3 h3Var = h3.f17831a;
        String a2 = h3Var.a();
        int[] b2 = h3Var.b();
        JSONObject jSONObject = new JSONObject();
        if (a2 != null && a2.length() > 0 && b2 != null && b2.length > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int put : b2) {
                    jSONArray.put(put);
                }
                jSONObject.put("exchangeMode", 2);
                jSONObject.put("bidFloor", 0.01d);
                jSONObject.put("code", a2);
                jSONObject.put("forceCreativeTypes", jSONArray);
            } catch (JSONException unused) {
                return null;
            }
        }
        return jSONObject.toString();
    }

    public String i() {
        String str = "/";
        if (this.f18620k == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f18620k.startsWith(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(this.f18620k);
        return sb.toString();
    }

    public String j() {
        return i();
    }

    public t2(String str, String str2, ea eaVar, i9 i9Var, String str3, a aVar, z4 z4Var) {
        this("POST", str, str2, eaVar, i9Var, str3, aVar, z4Var);
    }

    public void a(String str, Object obj) {
        h2.a(this.f18625p, str, obj);
    }

    public t2(String str, String str2, String str3, ea eaVar, i9 i9Var, String str4, a aVar, z4 z4Var) {
        super(String.valueOf(str), NetworkHelper.a(str2, str3), i9Var, (File) null);
        this.f18627r = false;
        this.f18625p = new JSONObject();
        this.f18620k = str3;
        this.f18623n = eaVar;
        this.f18621l = str4;
        this.f18622m = aVar;
        this.f18624o = z4Var;
    }

    public final void a(p2 p2Var, CBError cBError) {
        Object obj;
        String str;
        h2.a[] aVarArr = new h2.a[5];
        aVarArr[0] = h2.a("endpoint", (Object) i());
        String str2 = "None";
        if (p2Var == null) {
            obj = str2;
        } else {
            obj = Integer.valueOf(p2Var.b());
        }
        aVarArr[1] = h2.a("statuscode", obj);
        if (cBError == null) {
            str = str2;
        } else {
            str = cBError.getError().toString();
        }
        aVarArr[2] = h2.a(MRAIDPresenter.ERROR, (Object) str);
        if (cBError != null) {
            str2 = cBError.getErrorDesc();
        }
        aVarArr[3] = h2.a("errorDescription", (Object) str2);
        aVarArr[4] = h2.a("retryCount", (Object) 0);
        JSONObject a2 = h2.a(aVarArr);
        w7.a("CBRequest", "sendToSessionLogs: " + a2.toString());
    }

    public final void b(String str) {
        this.f18624o.track(d4.a(tb.g.RESPONSE_JSON_SERIALIZATION_ERROR, str));
    }

    public m2 a() {
        String h2;
        g();
        String jSONObject = this.f18625p.toString();
        ea eaVar = this.f18623n;
        String str = eaVar.f17629h;
        String str2 = eaVar.f17630i;
        String a2 = w1.a(String.format(Locale.US, "%s %s\n%s\n%s", new Object[]{c(), j(), str2, jSONObject}));
        HashMap hashMap = new HashMap();
        hashMap.put(TheTvdb.HEADER_ACCEPT, TraktV2.CONTENT_TYPE_JSON);
        hashMap.put("X-Chartboost-Client", CBUtility.b());
        hashMap.put("X-Chartboost-API", "9.7.0");
        hashMap.put("X-Chartboost-App", str);
        hashMap.put("X-Chartboost-Signature", a2);
        if (la.f18112a.g()) {
            String b2 = la.b();
            if (b2.length() > 0) {
                hashMap.put("X-Chartboost-Test", b2);
            }
            String a3 = la.a();
            if (a3 != null) {
                hashMap.put("X-Chartboost-Test", a3);
            }
        }
        if (ChartboostDSP.INSTANCE.isDSP() && (h2 = h()) != null && h2.length() > 0) {
            hashMap.put("X-Chartboost-DspDemoApp", h2);
        }
        return new m2(hashMap, jSONObject.getBytes(), TraktV2.CONTENT_TYPE_JSON);
    }

    public o2 a(p2 p2Var) {
        try {
            JSONObject jSONObject = new JSONObject(new String(p2Var.a()));
            w7.d("CBRequest", "Request " + i() + " succeeded. Response code: " + p2Var.b() + ", body: " + jSONObject.toString(4));
            if (this.f18627r) {
                int optInt = jSONObject.optInt("status");
                String optString = jSONObject.optString("message");
                if (optInt == 404) {
                    return a(optString);
                }
                if (optInt < 200 || optInt > 299) {
                    w7.b("CBRequest", "Request failed due to status code " + optInt + " in message");
                    return a(optInt, optString);
                }
            }
            return o2.a((Object) jSONObject);
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            b(message);
            w7.b("CBRequest", "parseServerResponse: " + e2);
            return a(e2);
        }
    }

    public final o2 a(String str) {
        return o2.a(new CBError(CBError.a.HTTP_NOT_FOUND, b(UserResponces.USER_RESPONCE_FAIL, str).toString()));
    }

    public final o2 a(int i2, String str) {
        return o2.a(new CBError(CBError.a.HTTP_NOT_OK, b(i2, str).toString()));
    }

    public final o2 a(Exception exc) {
        return o2.a(new CBError(CBError.a.MISCELLANEOUS, exc.getLocalizedMessage()));
    }

    public void a(JSONObject jSONObject, p2 p2Var) {
        int b2 = p2Var != null ? p2Var.b() : -1;
        w7.d("CBRequest", "Request success: " + e() + " status: " + b2);
        a aVar = this.f18622m;
        if (!(aVar == null || jSONObject == null)) {
            aVar.a(this, jSONObject);
        }
        a(p2Var, (CBError) null);
    }

    public void a(CBError cBError, p2 p2Var) {
        if (cBError != null) {
            w7.d("CBRequest", "Request failure: " + e() + " status: " + cBError.getErrorDesc());
            a aVar = this.f18622m;
            if (aVar != null) {
                aVar.a(this, cBError);
            }
            a(p2Var, cBError);
        }
    }
}
