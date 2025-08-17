package com.chartboost.sdk.impl;

import android.view.ViewGroup;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class x6 implements w6 {

    /* renamed from: a  reason: collision with root package name */
    public final Function2 f18936a = new d(this);

    /* renamed from: b  reason: collision with root package name */
    public final Function1 f18937b = a.f18941b;

    /* renamed from: c  reason: collision with root package name */
    public final Function1 f18938c = c.f18943b;

    /* renamed from: d  reason: collision with root package name */
    public final Function1 f18939d = b.f18942b;

    /* renamed from: e  reason: collision with root package name */
    public final Function2 f18940e = e.f18945b;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18941b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final p6 invoke(y6 y6Var) {
            Intrinsics.f(y6Var, "impressionDependency");
            return new p6(y6Var.b(), y6Var.p(), y6Var.l(), y6Var.e(), y6Var.f(), y6Var.n(), y6Var.k(), y6Var.o(), y6Var.c());
        }
    }

    public static final class b extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final b f18942b = new b();

        public b() {
            super(1);
        }

        /* renamed from: a */
        public final u6 invoke(y6 y6Var) {
            Intrinsics.f(y6Var, "impressionDependency");
            return new u6(y6Var.b(), y6Var.a(), y6Var.g(), y6Var.c());
        }
    }

    public static final class c extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final c f18943b = new c();

        public c() {
            super(1);
        }

        /* renamed from: a */
        public final z6 invoke(y6 y6Var) {
            Intrinsics.f(y6Var, "impressionDependency");
            return new z6(y6Var.b(), y6Var.m(), y6Var.a(), y6Var.c(), y6Var.j(), y6Var.d(), y6Var.h(), y6Var.o(), y6Var.i());
        }
    }

    public static final class d extends Lambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x6 f18944b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(x6 x6Var) {
            super(2);
            this.f18944b = x6Var;
        }

        /* renamed from: a */
        public final e2 invoke(y6 y6Var, ViewGroup viewGroup) {
            Intrinsics.f(y6Var, "impressionDependency");
            return new e2(y6Var, (s6) this.f18944b.f18937b.invoke(y6Var), (b7) this.f18944b.f18938c.invoke(y6Var), (t6) this.f18944b.f18939d.invoke(y6Var), (l7) this.f18944b.f18940e.invoke(y6Var, viewGroup));
        }
    }

    public static final class e extends Lambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public static final e f18945b = new e();

        public e() {
            super(2);
        }

        /* renamed from: a */
        public final i7 invoke(y6 y6Var, ViewGroup viewGroup) {
            Intrinsics.f(y6Var, "impressionDependency");
            return new i7(y6Var.d(), y6Var.q(), y6Var.h(), viewGroup, y6Var.c(), y6Var.j(), y6Var.k());
        }
    }

    public Function2 a() {
        return this.f18936a;
    }
}
