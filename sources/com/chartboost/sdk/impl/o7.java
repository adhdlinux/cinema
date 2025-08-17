package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.t2;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.internal.Model.CBError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class o7 implements t2.a, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final q2 f18291a;

    /* renamed from: b  reason: collision with root package name */
    public final ca f18292b;

    /* renamed from: c  reason: collision with root package name */
    public final a5 f18293c;

    /* renamed from: d  reason: collision with root package name */
    public y3 f18294d;

    public o7(q2 q2Var, ca caVar, a5 a5Var) {
        Intrinsics.f(q2Var, "networkService");
        Intrinsics.f(caVar, "requestBodyBuilder");
        Intrinsics.f(a5Var, "eventTracker");
        this.f18291a = q2Var;
        this.f18292b = caVar;
        this.f18293c = a5Var;
    }

    public final void a(y3 y3Var) {
        Intrinsics.f(y3Var, "callback");
        this.f18294d = y3Var;
        t2 t2Var = new t2("https://live.chartboost.com", "/api/config", this.f18292b.a(), i9.HIGH, this, this.f18293c);
        t2Var.f18627r = true;
        this.f18291a.a(t2Var);
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f18293c.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18293c.clearFromStorage(qbVar);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18293c.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f18293c.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f18293c.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18293c.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m51clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18293c.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m52persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18293c.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m53refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f18293c.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m54store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f18293c.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m55track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18293c.track(qbVar);
    }

    public void a(t2 t2Var, JSONObject jSONObject) {
        JSONObject a2 = h2.a(jSONObject, "response");
        y3 y3Var = this.f18294d;
        if (y3Var != null) {
            Intrinsics.e(a2, "configJson");
            y3Var.a(a2);
        }
    }

    public void a(t2 t2Var, CBError cBError) {
        String str;
        if (cBError == null || (str = cBError.getErrorDesc()) == null) {
            str = "Config failure";
        }
        track((qb) new x4(tb.e.CONFIG_REQUEST_ERROR, str, (String) null, (String) null, (Mediation) null, 28, (DefaultConstructorMarker) null));
        y3 y3Var = this.f18294d;
        if (y3Var != null) {
            y3Var.a(str);
        }
    }
}
