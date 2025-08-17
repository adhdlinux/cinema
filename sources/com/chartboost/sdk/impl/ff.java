package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Handler;
import com.chartboost.sdk.impl.qe;

public class ff implements qe.a, je {

    /* renamed from: f  reason: collision with root package name */
    public static ff f17708f;

    /* renamed from: a  reason: collision with root package name */
    public float f17709a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public final ye f17710b;

    /* renamed from: c  reason: collision with root package name */
    public final be f17711c;

    /* renamed from: d  reason: collision with root package name */
    public ue f17712d;

    /* renamed from: e  reason: collision with root package name */
    public ke f17713e;

    public ff(ye yeVar, be beVar) {
        this.f17710b = yeVar;
        this.f17711c = beVar;
    }

    public static ff c() {
        if (f17708f == null) {
            f17708f = new ff(new ye(), new be());
        }
        return f17708f;
    }

    public final ke a() {
        if (this.f17713e == null) {
            this.f17713e = ke.c();
        }
        return this.f17713e;
    }

    public float b() {
        return this.f17709a;
    }

    public void d() {
        ce.g().a((qe.a) this);
        ce.g().e();
        ac.h().i();
        this.f17712d.c();
    }

    public void e() {
        ac.h().k();
        ce.g().f();
        this.f17712d.d();
    }

    public void a(float f2) {
        this.f17709a = f2;
        for (qd k2 : a().a()) {
            k2.k().a(f2);
        }
    }

    public void a(Context context) {
        this.f17712d = this.f17710b.a(new Handler(), context, this.f17711c.a(), this);
    }

    public void a(boolean z2) {
        if (z2) {
            ac.h().i();
        } else {
            ac.h().g();
        }
    }
}
