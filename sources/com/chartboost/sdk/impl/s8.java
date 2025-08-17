package com.chartboost.sdk.impl;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;

public final class s8 implements m8 {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f18563a;

    /* renamed from: b  reason: collision with root package name */
    public final Lazy f18564b = LazyKt__LazyJVMKt.b(c.f18569b);

    /* renamed from: c  reason: collision with root package name */
    public final Lazy f18565c = LazyKt__LazyJVMKt.b(new a(this));

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s8 f18566b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(s8 s8Var) {
            super(0);
            this.f18566b = s8Var;
        }

        /* renamed from: a */
        public final n8 invoke() {
            return new n8(this.f18566b.a(), this.f18566b.c());
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f18567b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c1 f18568c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(z0 z0Var, c1 c1Var) {
            super(0);
            this.f18567b = z0Var;
            this.f18568c = c1Var;
        }

        /* renamed from: a */
        public final q8 invoke() {
            return new q8(this.f18567b.getContext(), this.f18567b.g(), this.f18567b.j(), this.f18568c.b(), (CoroutineDispatcher) null, 16, (DefaultConstructorMarker) null);
        }
    }

    public static final class c extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final c f18569b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final t8 invoke() {
            return new t8();
        }
    }

    public s8(z0 z0Var, c1 c1Var) {
        Intrinsics.f(z0Var, "androidComponent");
        Intrinsics.f(c1Var, "applicationComponent");
        this.f18563a = LazyKt__LazyJVMKt.b(new b(z0Var, c1Var));
    }

    public q8 a() {
        return (q8) this.f18563a.getValue();
    }

    public n8 b() {
        return (n8) this.f18565c.getValue();
    }

    public t8 c() {
        return (t8) this.f18564b.getValue();
    }
}
