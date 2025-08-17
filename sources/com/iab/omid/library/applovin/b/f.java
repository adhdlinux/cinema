package com.iab.omid.library.applovin.b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.applovin.a.c;
import com.iab.omid.library.applovin.a.d;
import com.iab.omid.library.applovin.a.e;
import com.iab.omid.library.applovin.adsession.a;
import com.iab.omid.library.applovin.b.b;
import com.iab.omid.library.applovin.walking.TreeWalker;

public class f implements c, b.a {

    /* renamed from: a  reason: collision with root package name */
    private static f f31503a;

    /* renamed from: b  reason: collision with root package name */
    private float f31504b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private final e f31505c;

    /* renamed from: d  reason: collision with root package name */
    private final com.iab.omid.library.applovin.a.b f31506d;

    /* renamed from: e  reason: collision with root package name */
    private d f31507e;

    /* renamed from: f  reason: collision with root package name */
    private a f31508f;

    public f(e eVar, com.iab.omid.library.applovin.a.b bVar) {
        this.f31505c = eVar;
        this.f31506d = bVar;
    }

    public static f a() {
        if (f31503a == null) {
            f31503a = new f(new e(), new com.iab.omid.library.applovin.a.b());
        }
        return f31503a;
    }

    private a e() {
        if (this.f31508f == null) {
            this.f31508f = a.a();
        }
        return this.f31508f;
    }

    public void a(float f2) {
        this.f31504b = f2;
        for (a adSessionStatePublisher : e().c()) {
            adSessionStatePublisher.getAdSessionStatePublisher().a(f2);
        }
    }

    public void a(Context context) {
        this.f31507e = this.f31505c.a(new Handler(), context, this.f31506d.a(), this);
    }

    public void a(boolean z2) {
        if (z2) {
            TreeWalker.getInstance().a();
        } else {
            TreeWalker.getInstance().c();
        }
    }

    public void b() {
        b.a().a((b.a) this);
        b.a().b();
        TreeWalker.getInstance().a();
        this.f31507e.a();
    }

    public void c() {
        TreeWalker.getInstance().b();
        b.a().c();
        this.f31507e.b();
    }

    public float d() {
        return this.f31504b;
    }
}
