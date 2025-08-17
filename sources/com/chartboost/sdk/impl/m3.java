package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.t2;
import com.chartboost.sdk.internal.Model.CBError;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class m3 implements t2.a {

    /* renamed from: a  reason: collision with root package name */
    public final q2 f18184a;

    /* renamed from: b  reason: collision with root package name */
    public final ca f18185b;

    /* renamed from: c  reason: collision with root package name */
    public final z4 f18186c;

    /* renamed from: d  reason: collision with root package name */
    public n3 f18187d;

    public m3(q2 q2Var, ca caVar, z4 z4Var) {
        Intrinsics.f(q2Var, "networkService");
        Intrinsics.f(caVar, "requestBodyBuilder");
        Intrinsics.f(z4Var, "eventTracker");
        this.f18184a = q2Var;
        this.f18185b = caVar;
        this.f18186c = z4Var;
    }

    public final void a(n3 n3Var, k3 k3Var) {
        Intrinsics.f(k3Var, "params");
        this.f18187d = n3Var;
        t2 t2Var = new t2("https://live.chartboost.com", "/api/click", this.f18185b.a(), i9.NORMAL, this, this.f18186c);
        t2Var.f18627r = true;
        a(t2Var, k3Var);
        this.f18184a.a(t2Var);
    }

    public final void a(t2 t2Var, k3 k3Var) {
        t2Var.a("ad_id", (Object) k3Var.a());
        t2Var.a("to", (Object) k3Var.g());
        t2Var.a("cgn", (Object) k3Var.b());
        t2Var.a("creative", (Object) k3Var.c());
        t2Var.a("location", (Object) k3Var.e());
        if (k3Var.d() == f7.BANNER) {
            t2Var.a("creative", (Object) "");
        } else if (!(k3Var.i() == null || k3Var.h() == null)) {
            float f2 = (float) 1000;
            t2Var.a("total_time", (Object) Float.valueOf(k3Var.h().floatValue() / f2));
            t2Var.a("playback_time", (Object) Float.valueOf(k3Var.i().floatValue() / f2));
            String a2 = o3.f18286a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "TotalDuration: " + k3Var.h() + " PlaybackTime: " + k3Var.i());
        }
        Boolean f3 = k3Var.f();
        if (f3 != null) {
            t2Var.a("retarget_reinstall", (Object) Boolean.valueOf(f3.booleanValue()));
        }
    }

    public void a(t2 t2Var, JSONObject jSONObject) {
        JSONObject a2 = h2.a(jSONObject, "response");
        n3 n3Var = this.f18187d;
        if (n3Var != null) {
            n3Var.a(a2);
        }
    }

    public void a(t2 t2Var, CBError cBError) {
        String str;
        if (cBError == null || (str = cBError.getErrorDesc()) == null) {
            str = "Click failure";
        }
        n3 n3Var = this.f18187d;
        if (n3Var != null) {
            n3Var.a(str);
        }
    }
}
