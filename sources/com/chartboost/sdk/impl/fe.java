package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.ge;
import java.util.HashSet;
import org.json.JSONObject;

public class fe implements ge.b {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f17706a;

    /* renamed from: b  reason: collision with root package name */
    public final oe f17707b;

    public fe(oe oeVar) {
        this.f17707b = oeVar;
    }

    public JSONObject a() {
        return this.f17706a;
    }

    public void b() {
        this.f17707b.b(new te(this));
    }

    public void a(JSONObject jSONObject) {
        this.f17706a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet hashSet, long j2) {
        this.f17707b.b(new af(this, hashSet, jSONObject, j2));
    }

    public void a(JSONObject jSONObject, HashSet hashSet, long j2) {
        this.f17707b.b(new xe(this, hashSet, jSONObject, j2));
    }
}
