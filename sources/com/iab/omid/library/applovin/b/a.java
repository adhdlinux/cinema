package com.iab.omid.library.applovin.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f31486a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.applovin.adsession.a> f31487b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.applovin.adsession.a> f31488c = new ArrayList<>();

    private a() {
    }

    public static a a() {
        return f31486a;
    }

    public void a(com.iab.omid.library.applovin.adsession.a aVar) {
        this.f31487b.add(aVar);
    }

    public Collection<com.iab.omid.library.applovin.adsession.a> b() {
        return Collections.unmodifiableCollection(this.f31487b);
    }

    public void b(com.iab.omid.library.applovin.adsession.a aVar) {
        boolean d2 = d();
        this.f31488c.add(aVar);
        if (!d2) {
            f.a().b();
        }
    }

    public Collection<com.iab.omid.library.applovin.adsession.a> c() {
        return Collections.unmodifiableCollection(this.f31488c);
    }

    public void c(com.iab.omid.library.applovin.adsession.a aVar) {
        boolean d2 = d();
        this.f31487b.remove(aVar);
        this.f31488c.remove(aVar);
        if (d2 && !d()) {
            f.a().c();
        }
    }

    public boolean d() {
        return this.f31488c.size() > 0;
    }
}
