package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class y4 {

    /* renamed from: a  reason: collision with root package name */
    public int f19061a;

    /* renamed from: b  reason: collision with root package name */
    public int f19062b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f19063c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map f19064d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Set f19065e = new LinkedHashSet();

    public y4(int i2, int i3) {
        this.f19061a = i2;
        this.f19062b = i3;
    }

    public final long a(qb qbVar) {
        Long l2 = (Long) this.f19063c.get(qbVar.f());
        return l2 != null ? l2.longValue() : qbVar.i();
    }

    public final long b(qb qbVar) {
        return (qbVar.i() - a(qbVar)) / ((long) 1000);
    }

    public final int c(qb qbVar) {
        Integer num = (Integer) this.f19064d.get(qbVar.f());
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final void d(qb qbVar) {
        if (!this.f19063c.containsKey(qbVar.f())) {
            this.f19063c.put(qbVar.f(), Long.valueOf(qbVar.i()));
        }
    }

    public final synchronized qb e(qb qbVar) {
        if (qbVar == null) {
            return null;
        }
        d(qbVar);
        if (b(qbVar) > ((long) this.f19062b)) {
            g(qbVar);
        }
        if (this.f19065e.contains(qbVar.f())) {
            return null;
        }
        if (i(qbVar) <= this.f19061a) {
            return qbVar;
        }
        return f(qbVar);
    }

    public final qb f(qb qbVar) {
        m7 m7Var = new m7(tb.e.TOO_MANY_EVENTS, qbVar.f().getValue(), (String) null, (String) null, (Mediation) null, (ib) null, 60, (DefaultConstructorMarker) null);
        this.f19065e.add(qbVar.f());
        return m7Var;
    }

    public final void g(qb qbVar) {
        h(qbVar);
        this.f19064d.remove(qbVar.f());
    }

    public final void h(qb qbVar) {
        this.f19063c.put(qbVar.f(), Long.valueOf(qbVar.i()));
    }

    public final int i(qb qbVar) {
        int c2 = c(qbVar) + 1;
        this.f19064d.put(qbVar.f(), Integer.valueOf(c2));
        return c2;
    }
}
