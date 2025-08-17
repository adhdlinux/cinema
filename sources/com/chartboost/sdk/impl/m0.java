package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.t2;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.internal.Model.CBError;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class m0 implements t2.a, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final q2 f18177a;

    /* renamed from: b  reason: collision with root package name */
    public final ca f18178b;

    /* renamed from: c  reason: collision with root package name */
    public final a5 f18179c;

    /* renamed from: d  reason: collision with root package name */
    public xa f18180d;

    public m0(q2 q2Var, ca caVar, a5 a5Var) {
        Intrinsics.f(q2Var, "networkService");
        Intrinsics.f(caVar, "requestBodyBuilder");
        Intrinsics.f(a5Var, "eventTracker");
        this.f18177a = q2Var;
        this.f18178b = caVar;
        this.f18179c = a5Var;
    }

    public void a(t2 t2Var, JSONObject jSONObject) {
    }

    public final void a(String str, xa xaVar) {
        Intrinsics.f(str, "endpointPath");
        Intrinsics.f(xaVar, "showParams");
        this.f18180d = xaVar;
        t2 t2Var = new t2("https://live.chartboost.com", str, this.f18178b.a(), i9.NORMAL, this, this.f18179c);
        t2Var.f18097i = 1;
        a(t2Var, xaVar);
        this.f18177a.a(t2Var);
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f18179c.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18179c.clearFromStorage(qbVar);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18179c.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f18179c.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f18179c.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18179c.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m41clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18179c.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m42persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18179c.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m43refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f18179c.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m44store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f18179c.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m45track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18179c.track(qbVar);
    }

    public final void a(t2 t2Var, xa xaVar) {
        t2Var.a("cached", (Object) "0");
        t2Var.a("location", (Object) xaVar.c());
        int e2 = xaVar.e();
        if (e2 >= 0) {
            t2Var.a("video_cached", (Object) Integer.valueOf(e2));
        }
        String a2 = xaVar.a();
        if (a2 != null && a2.length() != 0) {
            t2Var.a("ad_id", (Object) a2);
        }
    }

    public void a(t2 t2Var, CBError cBError) {
        String str;
        tb.h hVar = tb.h.REQUEST_ERROR;
        if (cBError == null || (str = cBError.getErrorDesc()) == null) {
            str = "Show failure";
        }
        String str2 = str;
        xa xaVar = this.f18180d;
        xa xaVar2 = null;
        if (xaVar == null) {
            Intrinsics.x("showParams");
            xaVar = null;
        }
        String b2 = xaVar.b();
        xa xaVar3 = this.f18180d;
        if (xaVar3 == null) {
            Intrinsics.x("showParams");
            xaVar3 = null;
        }
        String c2 = xaVar3.c();
        xa xaVar4 = this.f18180d;
        if (xaVar4 == null) {
            Intrinsics.x("showParams");
        } else {
            xaVar2 = xaVar4;
        }
        track((qb) new x4(hVar, str2, b2, c2, xaVar2.d()));
    }
}
