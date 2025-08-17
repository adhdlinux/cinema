package com.chartboost.sdk.impl;

import org.json.JSONObject;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public final d9 f18397a;

    /* renamed from: b  reason: collision with root package name */
    public final d9 f18398b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f18399c;

    /* renamed from: d  reason: collision with root package name */
    public final c4 f18400d;

    /* renamed from: e  reason: collision with root package name */
    public final h7 f18401e;

    public q(c4 c4Var, h7 h7Var, d9 d9Var, d9 d9Var2, boolean z2) {
        this.f18400d = c4Var;
        this.f18401e = h7Var;
        this.f18397a = d9Var;
        if (d9Var2 == null) {
            this.f18398b = d9.NONE;
        } else {
            this.f18398b = d9Var2;
        }
        this.f18399c = z2;
    }

    public static q a(c4 c4Var, h7 h7Var, d9 d9Var, d9 d9Var2, boolean z2) {
        df.a((Object) c4Var, "CreativeType is null");
        df.a((Object) h7Var, "ImpressionType is null");
        df.a((Object) d9Var, "Impression owner is null");
        df.a(d9Var, c4Var, h7Var);
        return new q(c4Var, h7Var, d9Var, d9Var2, z2);
    }

    public boolean b() {
        return d9.NATIVE == this.f18398b;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        me.a(jSONObject, "impressionOwner", this.f18397a);
        me.a(jSONObject, "mediaEventsOwner", this.f18398b);
        me.a(jSONObject, "creativeType", this.f18400d);
        me.a(jSONObject, "impressionType", this.f18401e);
        me.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f18399c));
        return jSONObject;
    }

    public boolean a() {
        return d9.NATIVE == this.f18397a;
    }
}
