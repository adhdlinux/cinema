package com.chartboost.sdk.impl;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class s1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f18539a;

    /* renamed from: b  reason: collision with root package name */
    public final q1 f18540b;

    /* renamed from: c  reason: collision with root package name */
    public final b2 f18541c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f18542d;

    /* renamed from: e  reason: collision with root package name */
    public final q8 f18543e;

    public s1(Context context, q1 q1Var, b2 b2Var, AtomicReference atomicReference, q8 q8Var) {
        Intrinsics.f(context, "context");
        Intrinsics.f(q1Var, "base64Wrapper");
        Intrinsics.f(b2Var, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        Intrinsics.f(atomicReference, "sdkConfiguration");
        Intrinsics.f(q8Var, "openMeasurementManager");
        this.f18539a = context;
        this.f18540b = q1Var;
        this.f18541c = b2Var;
        this.f18542d = atomicReference;
        this.f18543e = q8Var;
    }

    public final String a() {
        int i2;
        j8 b2;
        e9 c2;
        i6 h2 = this.f18541c.h();
        pa paVar = (pa) this.f18542d.get();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token_version", "1.0");
        String c3 = h2.c();
        if (c3 == null) {
            c3 = "";
        }
        jSONObject.put("appSetId", c3);
        Integer d2 = h2.d();
        if (d2 != null) {
            i2 = d2.intValue();
        } else {
            i2 = 0;
        }
        jSONObject.put("appSetIdScope", i2);
        jSONObject.put("package", this.f18539a.getPackageName());
        if (!(paVar == null || (b2 = paVar.b()) == null || !b2.g() || (c2 = this.f18543e.c()) == null)) {
            jSONObject.put("omidpn", c2.a());
            jSONObject.put("omidpv", c2.b());
        }
        q1 q1Var = this.f18540b;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.e(jSONObject2, "json.toString()");
        return q1Var.c(jSONObject2);
    }
}
