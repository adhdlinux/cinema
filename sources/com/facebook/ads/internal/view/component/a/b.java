package com.facebook.ads.internal.view.component.a;

import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.a.d;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.component.a;
import com.facebook.ads.internal.view.component.h;
import java.util.HashMap;

public abstract class b extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    static final int f21083a;

    /* renamed from: b  reason: collision with root package name */
    static final int f21084b;

    /* renamed from: c  reason: collision with root package name */
    private final h f21085c;

    /* renamed from: d  reason: collision with root package name */
    private final a f21086d;

    /* renamed from: e  reason: collision with root package name */
    private final c f21087e;

    static {
        float f2 = x.f20694b;
        f21083a = (int) (16.0f * f2);
        f21084b = (int) (f2 * 28.0f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected b(d dVar, d dVar2, boolean z2) {
        super(dVar.a());
        this.f21087e = dVar.b();
        a aVar = new a(dVar.a(), d(), e(), "com.facebook.ads.interstitial.clicked", dVar2, dVar.b(), dVar.c(), dVar.e(), dVar.f());
        this.f21086d = aVar;
        x.a((View) aVar);
        h hVar = new h(getContext(), dVar2, z2, b(), c());
        this.f21085c = hVar;
        x.a((View) hVar);
    }

    public void a(com.facebook.ads.internal.adapters.a.h hVar, String str, double d2) {
        this.f21085c.a(hVar.a().b(), hVar.a().c(), false, !a() && d2 > 0.0d && d2 < 1.0d);
        this.f21086d.a(hVar.b(), str, new HashMap());
    }

    public abstract boolean a();

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return true;
    }

    public c getAdEventManager() {
        return this.f21087e;
    }

    /* access modifiers changed from: protected */
    public a getCtaButton() {
        return this.f21086d;
    }

    /* access modifiers changed from: protected */
    public h getTitleDescContainer() {
        return this.f21085c;
    }
}
