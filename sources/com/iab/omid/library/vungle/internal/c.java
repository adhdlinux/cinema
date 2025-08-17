package com.iab.omid.library.vungle.internal;

import com.iab.omid.library.vungle.adsession.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f31703c = new c();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f31704a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<a> f31705b = new ArrayList<>();

    private c() {
    }

    public static c e() {
        return f31703c;
    }

    public Collection<a> a() {
        return Collections.unmodifiableCollection(this.f31705b);
    }

    public void b(a aVar) {
        this.f31704a.add(aVar);
    }

    public Collection<a> c() {
        return Collections.unmodifiableCollection(this.f31704a);
    }

    public void d(a aVar) {
        boolean g2 = g();
        this.f31704a.remove(aVar);
        this.f31705b.remove(aVar);
        if (g2 && !g()) {
            i.d().f();
        }
    }

    public void f(a aVar) {
        boolean g2 = g();
        this.f31705b.add(aVar);
        if (!g2) {
            i.d().e();
        }
    }

    public boolean g() {
        return this.f31705b.size() > 0;
    }
}
