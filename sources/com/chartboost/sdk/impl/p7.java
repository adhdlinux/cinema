package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.t2;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.internal.Model.CBError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class p7 implements t2.a, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final q2 f18354a;

    /* renamed from: b  reason: collision with root package name */
    public final ca f18355b;

    /* renamed from: c  reason: collision with root package name */
    public final a5 f18356c;

    public p7(q2 q2Var, ca caVar, a5 a5Var) {
        Intrinsics.f(q2Var, "networkService");
        Intrinsics.f(caVar, "requestBodyBuilder");
        Intrinsics.f(a5Var, "eventTracker");
        this.f18354a = q2Var;
        this.f18355b = caVar;
        this.f18356c = a5Var;
    }

    public final void a() {
        t2 t2Var = new t2("https://live.chartboost.com", "/api/install", this.f18355b.a(), i9.NORMAL, this, this.f18356c);
        t2Var.f18627r = true;
        this.f18354a.a(t2Var);
    }

    public void a(t2 t2Var, JSONObject jSONObject) {
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f18356c.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18356c.clearFromStorage(qbVar);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18356c.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f18356c.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f18356c.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18356c.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m56clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18356c.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m57persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18356c.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m58refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f18356c.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m59store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f18356c.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m60track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18356c.track(qbVar);
    }

    public void a(t2 t2Var, CBError cBError) {
        String str;
        if (cBError == null || (str = cBError.getErrorDesc()) == null) {
            str = "Install failure";
        }
        track((qb) new x4(tb.e.INSTALL_REQUEST_ERROR, str, (String) null, (String) null, (Mediation) null, 28, (DefaultConstructorMarker) null));
    }
}
