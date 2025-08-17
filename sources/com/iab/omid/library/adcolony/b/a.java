package com.iab.omid.library.adcolony.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f31369c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.adcolony.adsession.a> f31370a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.adcolony.adsession.a> f31371b = new ArrayList<>();

    private a() {
    }

    public static a a() {
        return f31369c;
    }

    public void b(com.iab.omid.library.adcolony.adsession.a aVar) {
        this.f31370a.add(aVar);
    }

    public Collection<com.iab.omid.library.adcolony.adsession.a> c() {
        return Collections.unmodifiableCollection(this.f31370a);
    }

    public void d(com.iab.omid.library.adcolony.adsession.a aVar) {
        boolean g2 = g();
        this.f31371b.add(aVar);
        if (!g2) {
            f.a().c();
        }
    }

    public Collection<com.iab.omid.library.adcolony.adsession.a> e() {
        return Collections.unmodifiableCollection(this.f31371b);
    }

    public void f(com.iab.omid.library.adcolony.adsession.a aVar) {
        boolean g2 = g();
        this.f31370a.remove(aVar);
        this.f31371b.remove(aVar);
        if (g2 && !g()) {
            f.a().d();
        }
    }

    public boolean g() {
        return this.f31371b.size() > 0;
    }
}
