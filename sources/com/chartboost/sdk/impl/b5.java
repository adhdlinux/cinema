package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.qb;
import com.chartboost.sdk.impl.tb;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class b5 implements a5, z4 {

    /* renamed from: a  reason: collision with root package name */
    public Lazy f17282a;

    /* renamed from: b  reason: collision with root package name */
    public Lazy f17283b;

    /* renamed from: c  reason: collision with root package name */
    public Lazy f17284c;

    /* renamed from: d  reason: collision with root package name */
    public Lazy f17285d;

    /* renamed from: e  reason: collision with root package name */
    public Lazy f17286e;

    /* renamed from: f  reason: collision with root package name */
    public Lazy f17287f;

    /* renamed from: g  reason: collision with root package name */
    public Lazy f17288g;

    /* renamed from: h  reason: collision with root package name */
    public final Map f17289h = new LinkedHashMap();

    /* renamed from: i  reason: collision with root package name */
    public final Map f17290i = new LinkedHashMap();

    /* renamed from: j  reason: collision with root package name */
    public final List f17291j = new ArrayList();

    public b5(Lazy lazy, Lazy lazy2, Lazy lazy3, Lazy lazy4, Lazy lazy5, Lazy lazy6, Lazy lazy7) {
        Intrinsics.f(lazy, "config");
        Intrinsics.f(lazy2, "throttler");
        Intrinsics.f(lazy3, "requestBodyBuilder");
        Intrinsics.f(lazy4, "privacyApi");
        Intrinsics.f(lazy5, "environment");
        Intrinsics.f(lazy6, "trackingRequest");
        Intrinsics.f(lazy7, "trackingEventCache");
        this.f17282a = lazy;
        this.f17283b = lazy2;
        this.f17284c = lazy3;
        this.f17285d = lazy4;
        this.f17286e = lazy5;
        this.f17287f = lazy6;
        this.f17288g = lazy7;
    }

    public final String a(ib ibVar) {
        return ibVar.e() + ibVar.d();
    }

    public final void b(qb qbVar) {
        Unit unit;
        if (qbVar != null) {
            try {
                if (((ob) this.f17282a.getValue()).d()) {
                    c(qbVar);
                } else {
                    d(qbVar);
                }
                unit = Unit.f40298a;
            } catch (Exception e2) {
                String a2 = c5.f17327a;
                Intrinsics.e(a2, "TAG");
                w7.a(a2, "Cannot send tracking event: " + e2);
                return;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            String a3 = c5.f17327a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "Cannot save empty event");
        }
    }

    public final void c(qb qbVar) {
        ((rb) this.f17288g.getValue()).a(qbVar, a(), ((ob) this.f17282a.getValue()).e());
        if (qbVar.g() == qb.a.HIGH) {
            a(((rb) this.f17288g.getValue()).a());
        }
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f17290i.remove(a(str2, str));
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m1clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        ((rb) this.f17288g.getValue()).a(qbVar);
    }

    public final void d(qb qbVar) {
        this.f17291j.add(qbVar);
        if (qbVar.g() == qb.a.HIGH) {
            a(((rb) this.f17288g.getValue()).a(this.f17291j, a()));
        }
    }

    public final String e(qb qbVar) {
        return a(qbVar.c(), qbVar.a());
    }

    public final boolean f(qb qbVar) {
        tb f2 = qbVar.f();
        if (f2 == tb.a.START || f2 == tb.h.START) {
            return true;
        }
        return false;
    }

    public final void g(qb qbVar) {
        qbVar.a((ib) this.f17289h.get(e(qbVar)));
        qbVar.a(a(qbVar));
        b(qbVar);
        String a2 = c5.f17327a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "Event: " + qbVar);
        h(qbVar);
    }

    public final void h(qb qbVar) {
        if (f(qbVar)) {
            this.f17290i.put(e(qbVar), qbVar);
        }
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m2persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        qbVar.a((ib) this.f17289h.get(e(qbVar)));
        qbVar.a(a(qbVar));
        String a2 = c5.f17327a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "Persist event: " + qbVar);
        ((rb) this.f17288g.getValue()).a(qbVar, a());
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m3refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f17282a = LazyKt__LazyKt.c(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m4store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f17289h.put(a(ibVar), ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m5track(qb qbVar) {
        Unit unit;
        Intrinsics.f(qbVar, "event");
        ob obVar = (ob) this.f17282a.getValue();
        if (!obVar.g()) {
            String a2 = c5.f17327a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Tracking is disabled");
        } else if (obVar.a().contains(qbVar.f())) {
            String a3 = c5.f17327a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "Event name " + qbVar.f() + " is black-listed");
        } else {
            qb e2 = ((y4) this.f17283b.getValue()).e(qbVar);
            if (e2 != null) {
                g(e2);
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                String a4 = c5.f17327a;
                Intrinsics.e(a4, "TAG");
                w7.a(a4, "Event is throttled " + qbVar);
            }
        }
    }

    public final v4 a() {
        try {
            ea a2 = ((ca) this.f17284c.getValue()).a();
            return ((u4) this.f17286e.getValue()).a(a2.c(), a2.h(), a2.g().c(), (j9) this.f17285d.getValue(), a2.f17629h);
        } catch (Exception e2) {
            String a3 = c5.f17327a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "Cannot create environment data for tracking: " + e2);
            return new v4((String) null, 0, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, false, 0, false, 0, 0, 0, 0, 0, 0, 0, 0, Integer.MAX_VALUE, (DefaultConstructorMarker) null);
        }
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        clearFromStorage(qbVar);
        return qbVar;
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        refresh(obVar);
        return obVar;
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        store(ibVar);
        return ibVar;
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        persist(qbVar);
        return qbVar;
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        track(qbVar);
        return qbVar;
    }

    public final String a(String str, String str2) {
        return str + str2;
    }

    public final float a(qb qbVar) {
        if (!qbVar.h()) {
            return qbVar.b();
        }
        if (!qbVar.m()) {
            return 0.0f;
        }
        try {
            qb qbVar2 = (qb) this.f17290i.remove(e(qbVar));
            if (qbVar2 != null) {
                return ((float) (qbVar.i() - qbVar2.i())) / 1000.0f;
            }
            return -1.0f;
        } catch (Exception e2) {
            String a2 = c5.f17327a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot calculate latency: " + e2);
            return -1.0f;
        }
    }

    public final void a(List list) {
        ((vb) this.f17287f.getValue()).a(((ob) this.f17282a.getValue()).b(), list);
    }
}
