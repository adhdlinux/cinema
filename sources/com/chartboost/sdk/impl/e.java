package com.chartboost.sdk.impl;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final z0 f17468a;

    /* renamed from: b  reason: collision with root package name */
    public final Lazy f17469b = LazyKt__LazyJVMKt.b(new a(this));

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f17470b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar) {
            super(0);
            this.f17470b = eVar;
        }

        /* renamed from: a */
        public final d invoke() {
            return new d(this.f17470b.f17468a.h());
        }
    }

    public e(z0 z0Var) {
        Intrinsics.f(z0Var, "androidComponent");
        this.f17468a = z0Var;
    }

    public d a() {
        return (d) this.f17469b.getValue();
    }
}
