package com.chartboost.sdk.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

public class q2 {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f18421a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f18422b;

    /* renamed from: c  reason: collision with root package name */
    public final f8 f18423c;

    /* renamed from: d  reason: collision with root package name */
    public final r2 f18424d;

    /* renamed from: e  reason: collision with root package name */
    public final gb f18425e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f18426f;

    /* renamed from: g  reason: collision with root package name */
    public final String f18427g = i3.f17882b.b();

    /* renamed from: h  reason: collision with root package name */
    public final z4 f18428h;

    public q2(Executor executor, f8 f8Var, r2 r2Var, gb gbVar, Handler handler, Executor executor2, z4 z4Var) {
        this.f18421a = executor2;
        this.f18422b = executor;
        this.f18423c = f8Var;
        this.f18424d = r2Var;
        this.f18425e = gbVar;
        this.f18426f = handler;
        this.f18428h = z4Var;
    }

    public void a(l2 l2Var) {
        w7.d("CBRequest", "Execute request: " + l2Var.e());
        this.f18421a.execute(new e8(this.f18422b, this.f18423c, this.f18424d, this.f18425e, this.f18426f, l2Var, this.f18428h));
    }

    public String a() {
        return this.f18427g;
    }
}
