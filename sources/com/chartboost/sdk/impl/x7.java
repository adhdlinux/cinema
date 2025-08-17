package com.chartboost.sdk.impl;

import com.facebook.react.uimanager.ViewProps;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import org.json.JSONObject;

public final class x7 {

    /* renamed from: a  reason: collision with root package name */
    public final qd f18946a;

    public x7(qd qdVar) {
        this.f18946a = qdVar;
    }

    public void a(s7 s7Var) {
        df.a((Object) s7Var, "InteractionType is null");
        df.a(this.f18946a);
        JSONObject jSONObject = new JSONObject();
        me.a(jSONObject, "interactionType", s7Var);
        this.f18946a.k().a("adUserInteraction", jSONObject);
    }

    public void b() {
        df.a(this.f18946a);
        this.f18946a.k().a("bufferStart");
    }

    public void c() {
        df.a(this.f18946a);
        this.f18946a.k().a("complete");
    }

    public void d() {
        df.a(this.f18946a);
        this.f18946a.k().a("firstQuartile");
    }

    public void e() {
        df.a(this.f18946a);
        this.f18946a.k().a("midpoint");
    }

    public void f() {
        df.a(this.f18946a);
        this.f18946a.k().a("pause");
    }

    public void g() {
        df.a(this.f18946a);
        this.f18946a.k().a("resume");
    }

    public void h() {
        df.a(this.f18946a);
        this.f18946a.k().a("skipped");
    }

    public void i() {
        df.a(this.f18946a);
        this.f18946a.k().a("thirdQuartile");
    }

    public void a() {
        df.a(this.f18946a);
        this.f18946a.k().a("bufferFinish");
    }

    public final void b(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public void c(float f2) {
        b(f2);
        df.a(this.f18946a);
        JSONObject jSONObject = new JSONObject();
        me.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        me.a(jSONObject, "deviceVolume", Float.valueOf(ff.c().b()));
        this.f18946a.k().a("volumeChange", jSONObject);
    }

    public final void a(float f2) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    public static x7 a(p pVar) {
        qd qdVar = (qd) pVar;
        df.a((Object) pVar, "AdSession is null");
        df.f(qdVar);
        df.c(qdVar);
        df.b(qdVar);
        df.h(qdVar);
        x7 x7Var = new x7(qdVar);
        qdVar.k().a(x7Var);
        return x7Var;
    }

    public void a(f9 f9Var) {
        df.a((Object) f9Var, "PlayerState is null");
        df.a(this.f18946a);
        JSONObject jSONObject = new JSONObject();
        me.a(jSONObject, AdOperationMetric.INIT_STATE, f9Var);
        this.f18946a.k().a("playerStateChange", jSONObject);
    }

    public void a(float f2, float f3) {
        a(f2);
        b(f3);
        df.a(this.f18946a);
        JSONObject jSONObject = new JSONObject();
        me.a(jSONObject, "duration", Float.valueOf(f2));
        me.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f3));
        me.a(jSONObject, "deviceVolume", Float.valueOf(ff.c().b()));
        this.f18946a.k().a(ViewProps.START, jSONObject);
    }
}
