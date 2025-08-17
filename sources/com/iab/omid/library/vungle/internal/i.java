package com.iab.omid.library.vungle.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.vungle.adsession.a;
import com.iab.omid.library.vungle.devicevolume.b;
import com.iab.omid.library.vungle.devicevolume.c;
import com.iab.omid.library.vungle.devicevolume.e;
import com.iab.omid.library.vungle.internal.d;
import com.iab.omid.library.vungle.walking.TreeWalker;

public class i implements d.a, c {

    /* renamed from: f  reason: collision with root package name */
    private static i f31721f;

    /* renamed from: a  reason: collision with root package name */
    private float f31722a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private final e f31723b;

    /* renamed from: c  reason: collision with root package name */
    private final b f31724c;

    /* renamed from: d  reason: collision with root package name */
    private com.iab.omid.library.vungle.devicevolume.d f31725d;

    /* renamed from: e  reason: collision with root package name */
    private c f31726e;

    public i(e eVar, b bVar) {
        this.f31723b = eVar;
        this.f31724c = bVar;
    }

    private c a() {
        if (this.f31726e == null) {
            this.f31726e = c.e();
        }
        return this.f31726e;
    }

    public static i d() {
        if (f31721f == null) {
            f31721f = new i(new e(), new b());
        }
        return f31721f;
    }

    public void a(float f2) {
        this.f31722a = f2;
        for (a m2 : a().a()) {
            m2.m().b(f2);
        }
    }

    public void a(boolean z2) {
        if (z2) {
            TreeWalker.p().q();
        } else {
            TreeWalker.p().o();
        }
    }

    public void b(Context context) {
        this.f31725d = this.f31723b.a(new Handler(), context, this.f31724c.a(), this);
    }

    public float c() {
        return this.f31722a;
    }

    public void e() {
        b.k().b(this);
        b.k().i();
        TreeWalker.p().q();
        this.f31725d.d();
    }

    public void f() {
        TreeWalker.p().s();
        b.k().j();
        this.f31725d.e();
    }
}
