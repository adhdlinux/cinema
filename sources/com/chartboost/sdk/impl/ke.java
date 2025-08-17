package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ke {

    /* renamed from: c  reason: collision with root package name */
    public static ke f18080c = new ke();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f18081a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f18082b = new ArrayList();

    public static ke c() {
        return f18080c;
    }

    public Collection a() {
        return Collections.unmodifiableCollection(this.f18082b);
    }

    public Collection b() {
        return Collections.unmodifiableCollection(this.f18081a);
    }

    public boolean d() {
        return this.f18082b.size() > 0;
    }

    public void a(qd qdVar) {
        this.f18081a.add(qdVar);
    }

    public void b(qd qdVar) {
        boolean d2 = d();
        this.f18081a.remove(qdVar);
        this.f18082b.remove(qdVar);
        if (d2 && !d()) {
            ff.c().e();
        }
    }

    public void c(qd qdVar) {
        boolean d2 = d();
        this.f18082b.add(qdVar);
        if (!d2) {
            ff.c().d();
        }
    }
}
