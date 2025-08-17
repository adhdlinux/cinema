package com.chartboost.sdk.impl;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class w9 implements v9 {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f18899a;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f18900b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c1 f18901c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ jb f18902d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(z0 z0Var, c1 c1Var, jb jbVar) {
            super(0);
            this.f18900b = z0Var;
            this.f18901c = c1Var;
            this.f18902d = jbVar;
        }

        /* renamed from: a */
        public final y9 invoke() {
            return new y9(new k6(this.f18900b.getContext()), this.f18901c.b(), this.f18902d.a());
        }
    }

    public w9(z0 z0Var, c1 c1Var, jb jbVar) {
        Intrinsics.f(z0Var, "androidComponent");
        Intrinsics.f(c1Var, "applicationComponent");
        Intrinsics.f(jbVar, "trackerComponent");
        this.f18899a = LazyKt__LazyJVMKt.b(new a(z0Var, c1Var, jbVar));
    }

    public x9 a() {
        return (x9) this.f18899a.getValue();
    }
}
