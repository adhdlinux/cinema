package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.chartboost.sdk.impl.pa;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class m9 implements l9 {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f18192a;

    /* renamed from: b  reason: collision with root package name */
    public final Lazy f18193b;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f18194b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ jb f18195c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ m9 f18196d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(z0 z0Var, jb jbVar, m9 m9Var) {
            super(0);
            this.f18194b = z0Var;
            this.f18195c = jbVar;
            this.f18196d = m9Var;
        }

        /* renamed from: a */
        public final j9 invoke() {
            SharedPreferences f2 = this.f18194b.f();
            a5 a2 = this.f18195c.a();
            n9 n9Var = new n9(f2, a2);
            j9 j9Var = new j9(new q9(n9Var, a2), new y5(n9Var), new u9(n9Var), new z5(), new a6(n9Var), this.f18196d.b());
            j9Var.a(new pa.b());
            return j9Var;
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f18197b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(z0 z0Var) {
            super(0);
            this.f18197b = z0Var;
        }

        /* renamed from: a */
        public final bb invoke() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f18197b.getContext());
            Intrinsics.e(defaultSharedPreferences, "getDefaultSharedPreferen…androidComponent.context)");
            return new bb(defaultSharedPreferences);
        }
    }

    public m9(z0 z0Var, jb jbVar) {
        Intrinsics.f(z0Var, "androidComponent");
        Intrinsics.f(jbVar, "trackerComponent");
        this.f18192a = LazyKt__LazyJVMKt.b(new a(z0Var, jbVar, this));
        this.f18193b = LazyKt__LazyJVMKt.b(new b(z0Var));
    }

    public j9 a() {
        return (j9) this.f18192a.getValue();
    }

    public bb b() {
        return (bb) this.f18193b.getValue();
    }
}
