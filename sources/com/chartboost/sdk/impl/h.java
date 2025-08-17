package com.chartboost.sdk.impl;

import android.os.Handler;
import com.chartboost.sdk.Mediation;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final Function0 f17788a;

    /* renamed from: b  reason: collision with root package name */
    public final Mediation f17789b;

    /* renamed from: c  reason: collision with root package name */
    public final i3 f17790c;

    /* renamed from: d  reason: collision with root package name */
    public final Lazy f17791d;

    /* renamed from: e  reason: collision with root package name */
    public final y f17792e;

    /* renamed from: f  reason: collision with root package name */
    public final h0 f17793f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f17794g;

    /* renamed from: h  reason: collision with root package name */
    public final Lazy f17795h;

    /* renamed from: i  reason: collision with root package name */
    public final ScheduledExecutorService f17796i;

    /* renamed from: j  reason: collision with root package name */
    public final ta f17797j;

    /* renamed from: k  reason: collision with root package name */
    public final q1 f17798k;

    /* renamed from: l  reason: collision with root package name */
    public final d f17799l;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f17800b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ u f17801c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h hVar, u uVar) {
            super(0);
            this.f17800b = hVar;
            this.f17801c = uVar;
        }

        /* renamed from: a */
        public final e0 invoke() {
            return new e0(this.f17800b.f17790c.a(), this.f17800b.f17790c.d(), this.f17801c, this.f17800b.f17790c.j(), this.f17800b.f17790c.h(), this.f17800b.f17789b, this.f17800b.f17790c.f(), this.f17800b.f17790c.m());
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f17802b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(h hVar) {
            super(0);
            this.f17802b = hVar;
        }

        /* renamed from: a */
        public final AtomicReference invoke() {
            return this.f17802b.f17790c.d().b();
        }
    }

    public h(u uVar, Function0 function0, Mediation mediation, i3 i3Var) {
        Intrinsics.f(uVar, "adType");
        Intrinsics.f(function0, "get");
        Intrinsics.f(i3Var, "dependencyContainer");
        this.f17788a = function0;
        this.f17789b = mediation;
        this.f17790c = i3Var;
        this.f17791d = LazyKt__LazyJVMKt.b(new a(this, uVar));
        this.f17792e = b().b();
        this.f17793f = b().c();
        this.f17794g = i3Var.a().h();
        this.f17795h = LazyKt__LazyJVMKt.b(new b(this));
        this.f17796i = i3Var.e().a();
        this.f17797j = i3Var.d().r();
        this.f17798k = i3Var.a().a();
        this.f17799l = new e(i3Var.a()).a();
    }

    public final AtomicReference c() {
        return (AtomicReference) this.f17795h.getValue();
    }

    public final Object a() {
        return ((Function9) this.f17788a.invoke()).invoke(this.f17792e, this.f17793f, this.f17794g, c(), this.f17796i, this.f17799l, this.f17797j, this.f17798k, this.f17790c.m().a());
    }

    public final e0 b() {
        return (e0) this.f17791d.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(u uVar, Function0 function0, Mediation mediation, i3 i3Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(uVar, function0, mediation, (i2 & 8) != 0 ? i3.f17882b : i3Var);
    }
}
