package com.chartboost.sdk.impl;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class g4 {

    /* renamed from: a  reason: collision with root package name */
    public String f17717a;

    /* renamed from: b  reason: collision with root package name */
    public String f17718b;

    /* renamed from: c  reason: collision with root package name */
    public Application f17719c;

    /* renamed from: d  reason: collision with root package name */
    public final Lazy f17720d = LazyKt__LazyJVMKt.b(new a(this));

    /* renamed from: e  reason: collision with root package name */
    public final Lazy f17721e = LazyKt__LazyJVMKt.b(new b(this));

    /* renamed from: f  reason: collision with root package name */
    public final Lazy f17722f = LazyKt__LazyJVMKt.b(new f(this));

    /* renamed from: g  reason: collision with root package name */
    public final Lazy f17723g = LazyKt__LazyJVMKt.b(c.f17731b);

    /* renamed from: h  reason: collision with root package name */
    public final Lazy f17724h = LazyKt__LazyJVMKt.b(new e(this));

    /* renamed from: i  reason: collision with root package name */
    public final Lazy f17725i = LazyKt__LazyJVMKt.b(d.f17732b);

    /* renamed from: j  reason: collision with root package name */
    public final Lazy f17726j = LazyKt__LazyJVMKt.b(new i(this));

    /* renamed from: k  reason: collision with root package name */
    public final Lazy f17727k = LazyKt__LazyJVMKt.b(new h(this));

    /* renamed from: l  reason: collision with root package name */
    public final Lazy f17728l = LazyKt__LazyJVMKt.b(new g(this));

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g4 f17729b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g4 g4Var) {
            super(0);
            this.f17729b = g4Var;
        }

        /* renamed from: a */
        public final a1 invoke() {
            Context applicationContext = this.f17729b.d().getApplicationContext();
            Intrinsics.e(applicationContext, "application.applicationContext");
            return new a1(applicationContext, this.f17729b.d());
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g4 f17730b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g4 g4Var) {
            super(0);
            this.f17730b = g4Var;
        }

        /* renamed from: a */
        public final e1 invoke() {
            return new e1(this.f17730b.a(), this.f17730b.f(), this.f17730b.j(), (Function1) null, this.f17730b.n(), 8, (DefaultConstructorMarker) null);
        }
    }

    public static final class c extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final c f17731b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final g5 invoke() {
            return new g5();
        }
    }

    public static final class d extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final d f17732b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final x6 invoke() {
            return new x6();
        }
    }

    public static final class e extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g4 f17733b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(g4 g4Var) {
            super(0);
            this.f17733b = g4Var;
        }

        /* renamed from: a */
        public final s8 invoke() {
            return new s8(this.f17733b.a(), this.f17733b.e());
        }
    }

    public static final class f extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g4 f17734b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(g4 g4Var) {
            super(0);
            this.f17734b = g4Var;
        }

        /* renamed from: a */
        public final m9 invoke() {
            return new m9(this.f17734b.a(), this.f17734b.n());
        }
    }

    public static final class g extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g4 f17735b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(g4 g4Var) {
            super(0);
            this.f17735b = g4Var;
        }

        /* renamed from: a */
        public final w9 invoke() {
            return new w9(this.f17735b.a(), this.f17735b.e(), this.f17735b.n());
        }
    }

    public static final class h extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g4 f17736b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(g4 g4Var) {
            super(0);
            this.f17736b = g4Var;
        }

        /* renamed from: a */
        public final sa invoke() {
            return new sa(this.f17736b.a(), this.f17736b.f(), this.f17736b.e(), this.f17736b.i(), this.f17736b.n());
        }
    }

    public static final class i extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g4 f17737b;

        public static final class a extends Lambda implements Function0 {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g4 f17738b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(g4 g4Var) {
                super(0);
                this.f17738b = g4Var;
            }

            /* renamed from: a */
            public final z0 invoke() {
                return this.f17738b.a();
            }
        }

        public static final class b extends Lambda implements Function0 {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g4 f17739b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(g4 g4Var) {
                super(0);
                this.f17739b = g4Var;
            }

            /* renamed from: a */
            public final c1 invoke() {
                return this.f17739b.e();
            }
        }

        public static final class c extends Lambda implements Function0 {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g4 f17740b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(g4 g4Var) {
                super(0);
                this.f17740b = g4Var;
            }

            /* renamed from: a */
            public final j9 invoke() {
                return this.f17740b.j().a();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(g4 g4Var) {
            super(0);
            this.f17737b = g4Var;
        }

        /* renamed from: a */
        public final lb invoke() {
            return new lb(LazyKt__LazyJVMKt.b(new a(this.f17737b)), LazyKt__LazyJVMKt.b(new b(this.f17737b)), LazyKt__LazyJVMKt.b(new c(this.f17737b)));
        }
    }

    public String b() {
        String str = this.f17717a;
        return str != null ? str : "";
    }

    public String c() {
        String str = this.f17718b;
        return str != null ? str : "";
    }

    public final Application d() {
        if (this.f17719c == null) {
            try {
                throw new j3();
            } catch (Exception e2) {
                Log.e("Chartboost", "Missing application. Cannot start Chartboost SDK: " + e2);
            }
        }
        Application application = this.f17719c;
        if (application != null) {
            return application;
        }
        Intrinsics.x("unsafeApplication");
        return null;
    }

    public c1 e() {
        return (c1) this.f17721e.getValue();
    }

    public f5 f() {
        return (f5) this.f17723g.getValue();
    }

    public w6 g() {
        return (w6) this.f17725i.getValue();
    }

    public boolean h() {
        return this.f17719c != null;
    }

    public m8 i() {
        return (m8) this.f17724h.getValue();
    }

    public l9 j() {
        return (l9) this.f17722f.getValue();
    }

    public v9 k() {
        return (v9) this.f17728l.getValue();
    }

    public oa l() {
        return (oa) this.f17727k.getValue();
    }

    public boolean m() {
        return (this.f17717a == null || this.f17718b == null) ? false : true;
    }

    public jb n() {
        return (jb) this.f17726j.getValue();
    }

    public z0 a() {
        return (z0) this.f17720d.getValue();
    }

    public void a(Context context) {
        Intrinsics.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        this.f17719c = (Application) applicationContext;
    }

    public void a(String str, String str2) {
        Intrinsics.f(str, "appId");
        Intrinsics.f(str2, "appSignature");
        this.f17717a = str;
        this.f17718b = str2;
    }
}
