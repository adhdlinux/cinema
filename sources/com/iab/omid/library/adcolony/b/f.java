package com.iab.omid.library.adcolony.b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.adcolony.a.c;
import com.iab.omid.library.adcolony.a.d;
import com.iab.omid.library.adcolony.a.e;
import com.iab.omid.library.adcolony.adsession.a;
import com.iab.omid.library.adcolony.b.b;
import com.iab.omid.library.adcolony.walking.TreeWalker;

public class f implements c, b.a {

    /* renamed from: f  reason: collision with root package name */
    private static f f31386f;

    /* renamed from: a  reason: collision with root package name */
    private float f31387a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private final e f31388b;

    /* renamed from: c  reason: collision with root package name */
    private final com.iab.omid.library.adcolony.a.b f31389c;

    /* renamed from: d  reason: collision with root package name */
    private d f31390d;

    /* renamed from: e  reason: collision with root package name */
    private a f31391e;

    public f(e eVar, com.iab.omid.library.adcolony.a.b bVar) {
        this.f31388b = eVar;
        this.f31389c = bVar;
    }

    public static f a() {
        if (f31386f == null) {
            f31386f = new f(new e(), new com.iab.omid.library.adcolony.a.b());
        }
        return f31386f;
    }

    private a f() {
        if (this.f31391e == null) {
            this.f31391e = a.a();
        }
        return this.f31391e;
    }

    public void a(float f2) {
        this.f31387a = f2;
        for (a v2 : f().e()) {
            v2.v().b(f2);
        }
    }

    public void a(boolean z2) {
        if (z2) {
            TreeWalker.p().c();
        } else {
            TreeWalker.p().k();
        }
    }

    public void b(Context context) {
        this.f31390d = this.f31388b.a(new Handler(), context, this.f31389c.a(), this);
    }

    public void c() {
        b.a().c(this);
        b.a().e();
        TreeWalker.p().c();
        this.f31390d.a();
    }

    public void d() {
        TreeWalker.p().h();
        b.a().f();
        this.f31390d.c();
    }

    public float e() {
        return this.f31387a;
    }
}
