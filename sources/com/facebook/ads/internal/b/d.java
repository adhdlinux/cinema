package com.facebook.ads.internal.b;

import android.os.Bundle;
import com.facebook.ads.internal.q.a.p;

public class d implements p<Bundle> {

    /* renamed from: a  reason: collision with root package name */
    private c f20036a;

    /* renamed from: b  reason: collision with root package name */
    private final c f20037b;

    /* renamed from: c  reason: collision with root package name */
    private final b f20038c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20039d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20040e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f20041f = false;

    public d(b bVar) {
        this.f20038c = bVar;
        this.f20037b = new c(bVar.f20019b);
        this.f20036a = new c(bVar.f20019b);
    }

    public d(b bVar, Bundle bundle) {
        this.f20038c = bVar;
        this.f20037b = (c) bundle.getSerializable("testStats");
        this.f20036a = (c) bundle.getSerializable("viewableStats");
        this.f20039d = bundle.getBoolean("ended");
        this.f20040e = bundle.getBoolean("passed");
        this.f20041f = bundle.getBoolean("complete");
    }

    private void b() {
        this.f20040e = true;
        c();
    }

    private void c() {
        this.f20041f = true;
        d();
    }

    private void d() {
        this.f20039d = true;
        boolean z2 = this.f20040e;
        this.f20038c.a(this.f20041f, z2, z2 ? this.f20036a : this.f20037b);
    }

    public void a() {
        if (!this.f20039d) {
            this.f20036a.b();
        }
    }

    public void a(double d2, double d3) {
        if (!this.f20039d) {
            this.f20037b.a(d2, d3);
            this.f20036a.a(d2, d3);
            double h2 = this.f20038c.f20022e ? this.f20036a.c().h() : this.f20036a.c().g();
            if (this.f20038c.f20020c >= 0.0d && this.f20037b.c().f() > this.f20038c.f20020c && h2 == 0.0d) {
                c();
            } else if (h2 >= this.f20038c.f20021d) {
                b();
            }
        }
    }

    public Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("viewableStats", this.f20036a);
        bundle.putSerializable("testStats", this.f20037b);
        bundle.putBoolean("ended", this.f20039d);
        bundle.putBoolean("passed", this.f20040e);
        bundle.putBoolean("complete", this.f20041f);
        return bundle;
    }
}
