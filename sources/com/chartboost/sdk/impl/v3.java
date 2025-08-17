package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.t2;
import com.chartboost.sdk.internal.Model.CBError;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class v3 implements t2.a {

    /* renamed from: a  reason: collision with root package name */
    public final q2 f18817a;

    /* renamed from: b  reason: collision with root package name */
    public final ca f18818b;

    /* renamed from: c  reason: collision with root package name */
    public final z4 f18819c;

    /* renamed from: d  reason: collision with root package name */
    public w3 f18820d;

    public v3(q2 q2Var, ca caVar, z4 z4Var) {
        Intrinsics.f(q2Var, "networkService");
        Intrinsics.f(caVar, "requestBodyBuilder");
        Intrinsics.f(z4Var, "eventTracker");
        this.f18817a = q2Var;
        this.f18818b = caVar;
        this.f18819c = z4Var;
    }

    public final void a(w3 w3Var, u3 u3Var) {
        Intrinsics.f(u3Var, "params");
        this.f18820d = w3Var;
        t2 t2Var = new t2("https://live.chartboost.com", "/api/video-complete", this.f18818b.a(), i9.NORMAL, this, this.f18819c);
        a(t2Var, u3Var);
        this.f18817a.a(t2Var);
    }

    public final void a(t2 t2Var, u3 u3Var) {
        t2Var.a("location", (Object) u3Var.c());
        t2Var.a("reward", (Object) Integer.valueOf(u3Var.d()));
        t2Var.a("currency-name", (Object) u3Var.e());
        t2Var.a("ad_id", (Object) u3Var.a());
        t2Var.a("force_close", (Object) Boolean.FALSE);
        t2Var.a("cgn", (Object) u3Var.b());
        if (u3Var.g() != null && u3Var.f() != null) {
            float f2 = (float) 1000;
            t2Var.a("total_time", (Object) Float.valueOf(u3Var.f().floatValue() / f2));
            t2Var.a("playback_time", (Object) Float.valueOf(u3Var.g().floatValue() / f2));
            String a2 = x3.f18929a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "TotalDuration: " + u3Var.f() + " PlaybackTime: " + u3Var.g());
        }
    }

    public void a(t2 t2Var, JSONObject jSONObject) {
        JSONObject a2 = h2.a(jSONObject, "response");
        w3 w3Var = this.f18820d;
        if (w3Var != null) {
            w3Var.a(a2);
        }
    }

    public void a(t2 t2Var, CBError cBError) {
        String str;
        if (cBError == null || (str = cBError.getErrorDesc()) == null) {
            str = "Click failure";
        }
        w3 w3Var = this.f18820d;
        if (w3Var != null) {
            w3Var.a(str);
        }
    }
}
