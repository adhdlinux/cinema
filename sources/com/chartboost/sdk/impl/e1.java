package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.SurfaceView;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tc;
import com.chartboost.sdk.impl.xc;
import com.chartboost.sdk.impl.zc;
import com.facebook.imageutils.JfifUtil;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;

public final class e1 implements c1 {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f17511a;

    /* renamed from: b  reason: collision with root package name */
    public final Lazy f17512b;

    /* renamed from: c  reason: collision with root package name */
    public final Lazy f17513c;

    /* renamed from: d  reason: collision with root package name */
    public final Lazy f17514d;

    /* renamed from: e  reason: collision with root package name */
    public final Lazy f17515e;

    /* renamed from: f  reason: collision with root package name */
    public final Lazy f17516f;

    /* renamed from: g  reason: collision with root package name */
    public final Lazy f17517g;

    /* renamed from: h  reason: collision with root package name */
    public final Lazy f17518h;

    /* renamed from: i  reason: collision with root package name */
    public final Lazy f17519i;

    /* renamed from: j  reason: collision with root package name */
    public final Lazy f17520j;

    /* renamed from: k  reason: collision with root package name */
    public final Lazy f17521k;

    /* renamed from: l  reason: collision with root package name */
    public final Lazy f17522l;

    /* renamed from: m  reason: collision with root package name */
    public final Lazy f17523m;

    /* renamed from: n  reason: collision with root package name */
    public final Lazy f17524n;

    /* renamed from: o  reason: collision with root package name */
    public final Lazy f17525o;

    /* renamed from: p  reason: collision with root package name */
    public final Lazy f17526p;

    /* renamed from: q  reason: collision with root package name */
    public final Lazy f17527q;

    /* renamed from: r  reason: collision with root package name */
    public final Lazy f17528r;

    /* renamed from: s  reason: collision with root package name */
    public final Lazy f17529s;

    /* renamed from: t  reason: collision with root package name */
    public final Lazy f17530t;

    /* renamed from: u  reason: collision with root package name */
    public final Lazy f17531u;

    /* renamed from: v  reason: collision with root package name */
    public final Lazy f17532v;

    /* renamed from: w  reason: collision with root package name */
    public final Lazy f17533w;

    /* renamed from: x  reason: collision with root package name */
    public final Lazy f17534x;

    /* renamed from: y  reason: collision with root package name */
    public final Lazy f17535y;

    /* renamed from: z  reason: collision with root package name */
    public final Lazy f17536z;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17537a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.chartboost.sdk.impl.xc$b[] r0 = com.chartboost.sdk.impl.xc.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.impl.xc$b r1 = com.chartboost.sdk.impl.xc.b.MEDIA_PLAYER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.chartboost.sdk.impl.xc$b r1 = com.chartboost.sdk.impl.xc.b.EXO_PLAYER     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f17537a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.e1.a.<clinit>():void");
        }
    }

    public static final class a0 extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e1 f17538b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(e1 e1Var) {
            super(0);
            this.f17538b = e1Var;
        }

        /* renamed from: a */
        public final xc.b invoke() {
            xc.b bVar;
            xc c2;
            pa paVar = (pa) this.f17538b.b().get();
            if (paVar == null || (c2 = paVar.c()) == null || (bVar = c2.h()) == null) {
                bVar = xc.b.EXO_PLAYER;
            }
            String b2 = d1.f17398a;
            Log.d(b2, "Video player type: " + bVar);
            return bVar;
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e1 f17539b;

        public static final class a extends Lambda implements Function5 {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e1 f17540b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(e1 e1Var) {
                super(5);
                this.f17540b = e1Var;
            }

            /* renamed from: a */
            public final o0 invoke(Context context, SurfaceView surfaceView, t0 t0Var, bc bcVar, v5 v5Var) {
                Intrinsics.f(context, "cxt");
                Intrinsics.f(surfaceView, "s");
                bc bcVar2 = bcVar;
                Intrinsics.f(bcVar2, "h");
                Intrinsics.f(v5Var, "<anonymous parameter 4>");
                return new o0(context, (l5) null, this.f17540b.v(), surfaceView, t0Var, bcVar2, this.f17540b.D(), 2, (DefaultConstructorMarker) null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(e1 e1Var) {
            super(0);
            this.f17539b = e1Var;
        }

        /* renamed from: a */
        public final Function5 invoke() {
            return new a(this.f17539b);
        }
    }

    public static final class b0 extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final b0 f17541b = new b0();

        public static final class a extends Lambda implements Function3 {

            /* renamed from: b  reason: collision with root package name */
            public static final a f17542b = new a();

            public a() {
                super(3);
            }

            /* renamed from: a */
            public final ad invoke(t0 t0Var, zc.b bVar, bc bcVar) {
                Intrinsics.f(bVar, "vp");
                Intrinsics.f(bcVar, "<anonymous parameter 2>");
                return new ad(t0Var, bVar, (CoroutineDispatcher) null, 4, (DefaultConstructorMarker) null);
            }
        }

        public b0() {
            super(0);
        }

        /* renamed from: a */
        public final Function3 invoke() {
            return a.f17542b;
        }
    }

    public static final class c extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e1 f17543b;

        public static final class a extends Lambda implements Function5 {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e1 f17544b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(e1 e1Var) {
                super(5);
                this.f17544b = e1Var;
            }

            /* renamed from: a */
            public final q0 invoke(Context context, SurfaceView surfaceView, t0 t0Var, bc bcVar, v5 v5Var) {
                Context context2 = context;
                Intrinsics.f(context, "<anonymous parameter 0>");
                Intrinsics.f(surfaceView, "s");
                bc bcVar2 = bcVar;
                Intrinsics.f(bcVar2, "h");
                v5 v5Var2 = v5Var;
                Intrinsics.f(v5Var2, "fc");
                return new q0((MediaPlayer) null, surfaceView, t0Var, bcVar2, this.f17544b.D(), this.f17544b.B(), (CoroutineDispatcher) null, v5Var2, 65, (DefaultConstructorMarker) null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e1 e1Var) {
            super(0);
            this.f17543b = e1Var;
        }

        /* renamed from: a */
        public final Function5 invoke() {
            return new a(this.f17543b);
        }
    }

    public static final class c0 extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e1 f17545b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(e1 e1Var) {
            super(0);
            this.f17545b = e1Var;
        }

        /* renamed from: a */
        public final ed invoke() {
            return new ed(this.f17545b.k(), this.f17545b.d(), (Function1) null, (CoroutineDispatcher) null, 12, (DefaultConstructorMarker) null);
        }
    }

    public static final class d extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f17546b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(z0 z0Var) {
            super(0);
            this.f17546b = z0Var;
        }

        /* renamed from: a */
        public final w0 invoke() {
            return new w0(this.f17546b.getContext(), this.f17546b.c());
        }
    }

    public static final class d0 extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e1 f17547b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f5 f17548c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(e1 e1Var, f5 f5Var) {
            super(0);
            this.f17547b = e1Var;
            this.f17548c = f5Var;
        }

        /* renamed from: a */
        public final gd invoke() {
            return new gd(this.f17547b.h(), this.f17547b.k(), this.f17547b.q(), this.f17547b.j(), this.f17547b.A(), this.f17548c.a());
        }
    }

    public static final class e extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final e f17549b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final c3 invoke() {
            return new c3();
        }
    }

    public static final class f extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f17550b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(z0 z0Var) {
            super(0);
            this.f17550b = z0Var;
        }

        /* renamed from: a */
        public final j4 invoke() {
            return new j4(this.f17550b.getContext(), this.f17550b.i(), this.f17550b.l());
        }
    }

    public static final class g extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f5 f17551b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e1 f17552c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ jb f17553d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(f5 f5Var, e1 e1Var, jb jbVar) {
            super(0);
            this.f17551b = f5Var;
            this.f17552c = e1Var;
            this.f17553d = jbVar;
        }

        /* renamed from: a */
        public final s4 invoke() {
            return new s4(this.f17551b.a(), this.f17552c.j(), this.f17552c.h(), this.f17552c.q(), this.f17552c.b(), this.f17552c.l(), this.f17553d.a());
        }
    }

    public static final class h extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final h f17554b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final j5 invoke() {
            return new j5((i5) null, 1, (DefaultConstructorMarker) null);
        }
    }

    public static final class i extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e1 f17555b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(e1 e1Var) {
            super(0);
            this.f17555b = e1Var;
        }

        /* renamed from: a */
        public final o5 invoke() {
            return new o5(this.f17555b.d());
        }
    }

    public static final class j extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f17556b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e1 f17557c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(z0 z0Var, e1 e1Var) {
            super(0);
            this.f17556b = z0Var;
            this.f17557c = e1Var;
        }

        /* renamed from: a */
        public final v5 invoke() {
            return new v5(this.f17556b.getContext(), this.f17557c.b());
        }
    }

    public static final class k extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f17558b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(z0 z0Var) {
            super(0);
            this.f17558b = z0Var;
        }

        /* renamed from: a */
        public final b6 invoke() {
            return new b6(this.f17558b.getContext());
        }
    }

    public static final class l extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f17559b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e1 f17560c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(z0 z0Var, e1 e1Var) {
            super(0);
            this.f17559b = z0Var;
            this.f17560c = e1Var;
        }

        /* renamed from: a */
        public final b2 invoke() {
            return new b2(this.f17559b.getContext(), this.f17559b.k(), this.f17560c.x(), this.f17559b.a(), (CoroutineDispatcher) null, 16, (DefaultConstructorMarker) null);
        }
    }

    public static final class m extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e1 f17561b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(e1 e1Var) {
            super(0);
            this.f17561b = e1Var;
        }

        /* renamed from: a */
        public final g6 invoke() {
            return new g6(this.f17561b.w(), this.f17561b.u(), (String) null, 4, (DefaultConstructorMarker) null);
        }
    }

    public static final class n extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f17562b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(z0 z0Var) {
            super(0);
            this.f17562b = z0Var;
        }

        /* renamed from: a */
        public final q7 invoke() {
            PackageManager packageManager = this.f17562b.getContext().getPackageManager();
            Intrinsics.e(packageManager, "androidComponent.context.packageManager");
            return new q7(packageManager, (Function0) null, 2, (DefaultConstructorMarker) null);
        }
    }

    public static final class o extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final o f17563b = new o();

        public o() {
            super(0);
        }

        /* renamed from: a */
        public final f8 invoke() {
            return new f8();
        }
    }

    public static final class p extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f5 f17564b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e1 f17565c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ z0 f17566d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ jb f17567e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(f5 f5Var, e1 e1Var, z0 z0Var, jb jbVar) {
            super(0);
            this.f17564b = f5Var;
            this.f17565c = e1Var;
            this.f17566d = z0Var;
            this.f17567e = jbVar;
        }

        /* renamed from: a */
        public final q2 invoke() {
            return new q2(this.f17564b.a(), this.f17565c.y(), this.f17565c.q(), this.f17565c.l(), this.f17566d.h(), this.f17564b.b(), this.f17567e.a());
        }
    }

    public static final class q extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e1 f17568b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ jb f17569c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(e1 e1Var, jb jbVar) {
            super(0);
            this.f17568b = e1Var;
            this.f17569c = jbVar;
        }

        /* renamed from: a */
        public final h9 invoke() {
            return new h9(this.f17568b.f(), this.f17568b.j(), this.f17568b.h(), this.f17568b.n(), this.f17568b.b(), this.f17569c.a());
        }
    }

    public static final class r extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l9 f17570b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(l9 l9Var) {
            super(0);
            this.f17570b = l9Var;
        }

        /* renamed from: a */
        public final j9 invoke() {
            return this.f17570b.a();
        }
    }

    public static final class s extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f17571b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(z0 z0Var) {
            super(0);
            this.f17571b = z0Var;
        }

        /* renamed from: a */
        public final r2 invoke() {
            return new r2(this.f17571b.getContext());
        }
    }

    public static final class t extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f17572b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e1 f17573c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ l9 f17574d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(z0 z0Var, e1 e1Var, l9 l9Var) {
            super(0);
            this.f17572b = z0Var;
            this.f17573c = e1Var;
            this.f17574d = l9Var;
        }

        /* renamed from: a */
        public final da invoke() {
            return new da(this.f17572b.getContext(), this.f17573c.i(), this.f17573c.q(), this.f17573c.b(), this.f17572b.f(), this.f17573c.l(), this.f17573c.m(), this.f17573c.r(), this.f17574d.a(), (Mediation) null, this.f17573c.e());
        }
    }

    public static final class u extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Function1 f17575b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ z0 f17576c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(Function1 function1, z0 z0Var) {
            super(0);
            this.f17575b = function1;
            this.f17576c = z0Var;
        }

        /* renamed from: a */
        public final AtomicReference invoke() {
            return new AtomicReference(this.f17575b.invoke(this.f17576c));
        }
    }

    public static final class v extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z0 f17577b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(z0 z0Var) {
            super(0);
            this.f17577b = z0Var;
        }

        /* renamed from: a */
        public final ta invoke() {
            return new ta(this.f17577b.f());
        }
    }

    public static final class w extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final w f17578b = new w();

        public w() {
            super(0);
        }

        /* renamed from: a */
        public final cb invoke() {
            return new cb();
        }
    }

    public static final class x extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final x f17579b = new x();

        public x() {
            super(0);
        }

        /* renamed from: a */
        public final gb invoke() {
            return new gb();
        }
    }

    public static final class y extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final y f17580b = new y();

        public static final class a extends Lambda implements Function4 {

            /* renamed from: b  reason: collision with root package name */
            public static final a f17581b = new a();

            public a() {
                super(4);
            }

            /* renamed from: a */
            public final tc invoke(rc rcVar, tc.b bVar, CoroutineDispatcher coroutineDispatcher, v5 v5Var) {
                Intrinsics.f(rcVar, "va");
                Intrinsics.f(bVar, "l");
                Intrinsics.f(coroutineDispatcher, "d");
                return new tc(rcVar, bVar, 0.0f, (cb) null, v5Var, coroutineDispatcher, (Function3) null, 76, (DefaultConstructorMarker) null);
            }
        }

        public y() {
            super(0);
        }

        /* renamed from: a */
        public final Function4 invoke() {
            return a.f17581b;
        }
    }

    public static final class z extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e1 f17582b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(e1 e1Var) {
            super(0);
            this.f17582b = e1Var;
        }

        /* renamed from: a */
        public final vc invoke() {
            xc xcVar = new xc(0, 0, 0, 0, 0, 0, 0, (xc.b) null, JfifUtil.MARKER_FIRST_BYTE, (DefaultConstructorMarker) null);
            return new vc(xcVar.b(), xcVar.c(), xcVar.d(), xcVar.e(), xcVar.f(), xcVar.g(), xcVar.a(), this.f17582b.q());
        }
    }

    public e1(z0 z0Var, f5 f5Var, l9 l9Var, Function1 function1, jb jbVar) {
        Intrinsics.f(z0Var, "androidComponent");
        Intrinsics.f(f5Var, "executorComponent");
        Intrinsics.f(l9Var, "privacyComponent");
        Intrinsics.f(function1, "sdkConfigFactory");
        Intrinsics.f(jbVar, "trackerComponent");
        this.f17511a = LazyKt__LazyJVMKt.b(new q(this, jbVar));
        this.f17512b = LazyKt__LazyJVMKt.b(new r(l9Var));
        this.f17513c = LazyKt__LazyJVMKt.b(new t(z0Var, this, l9Var));
        this.f17514d = LazyKt__LazyJVMKt.b(new f(z0Var));
        this.f17515e = LazyKt__LazyJVMKt.b(new p(f5Var, this, z0Var, jbVar));
        this.f17516f = LazyKt__LazyJVMKt.b(x.f17579b);
        this.f17517g = LazyKt__LazyJVMKt.b(new v(z0Var));
        this.f17518h = LazyKt__LazyJVMKt.b(new s(z0Var));
        this.f17519i = LazyKt__LazyJVMKt.b(new l(z0Var, this));
        this.f17520j = LazyKt__LazyJVMKt.b(new j(z0Var, this));
        this.f17521k = LazyKt__LazyJVMKt.b(new u(function1, z0Var));
        this.f17522l = LazyKt__LazyJVMKt.b(o.f17563b);
        this.f17523m = LazyKt__LazyJVMKt.b(new g(f5Var, this, jbVar));
        this.f17524n = LazyKt__LazyJVMKt.b(e.f17549b);
        this.f17525o = LazyKt__LazyJVMKt.b(w.f17578b);
        this.f17526p = LazyKt__LazyJVMKt.b(h.f17554b);
        this.f17527q = LazyKt__LazyJVMKt.b(new i(this));
        this.f17528r = LazyKt__LazyJVMKt.b(new n(z0Var));
        this.f17529s = LazyKt__LazyJVMKt.b(new a0(this));
        this.f17530t = LazyKt__LazyJVMKt.b(new d0(this, f5Var));
        this.f17531u = LazyKt__LazyJVMKt.b(new c0(this));
        this.f17532v = LazyKt__LazyJVMKt.b(new z(this));
        this.f17533w = LazyKt__LazyJVMKt.b(new c(this));
        this.f17534x = LazyKt__LazyJVMKt.b(new b(this));
        this.f17535y = LazyKt__LazyJVMKt.b(b0.f17541b);
        this.f17536z = LazyKt__LazyJVMKt.b(y.f17580b);
        this.A = LazyKt__LazyJVMKt.b(new m(this));
        this.B = LazyKt__LazyJVMKt.b(new k(z0Var));
        this.C = LazyKt__LazyJVMKt.b(new d(z0Var));
    }

    public cb A() {
        return (cb) this.f17525o.getValue();
    }

    public final Function4 B() {
        return (Function4) this.f17536z.getValue();
    }

    public final xc.b C() {
        return (xc.b) this.f17529s.getValue();
    }

    public final Function3 D() {
        return (Function3) this.f17535y.getValue();
    }

    public final dd E() {
        return (dd) this.f17531u.getValue();
    }

    public final dd F() {
        return (dd) this.f17530t.getValue();
    }

    public h9 g() {
        return (h9) this.f17511a.getValue();
    }

    public q2 h() {
        return (q2) this.f17515e.getValue();
    }

    public b2 i() {
        return (b2) this.f17519i.getValue();
    }

    public v5 j() {
        return (v5) this.f17520j.getValue();
    }

    public vc k() {
        return (vc) this.f17532v.getValue();
    }

    public gb l() {
        return (gb) this.f17516f.getValue();
    }

    public c3 m() {
        return (c3) this.f17524n.getValue();
    }

    public q7 o() {
        return (q7) this.f17528r.getValue();
    }

    public dd p() {
        dd ddVar;
        int i2 = a.f17537a[C().ordinal()];
        if (i2 == 1) {
            ddVar = F();
        } else if (i2 == 2) {
            ddVar = E();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String b2 = d1.f17398a;
        Intrinsics.e(b2, "TAG");
        w7.a(b2, "Video repository: " + ddVar);
        return ddVar;
    }

    public r2 q() {
        return (r2) this.f17518h.getValue();
    }

    public ta r() {
        return (ta) this.f17517g.getValue();
    }

    public final Function5 s() {
        return (Function5) this.f17534x.getValue();
    }

    public final Function5 t() {
        return (Function5) this.f17533w.getValue();
    }

    public final w0 u() {
        return (w0) this.C.getValue();
    }

    public o5 v() {
        return (o5) this.f17527q.getValue();
    }

    public final b6 w() {
        return (b6) this.B.getValue();
    }

    public final g6 x() {
        return (g6) this.A.getValue();
    }

    public final f8 y() {
        return (f8) this.f17522l.getValue();
    }

    /* renamed from: z */
    public da n() {
        return (da) this.f17513c.getValue();
    }

    public j9 a() {
        return (j9) this.f17512b.getValue();
    }

    public AtomicReference b() {
        return (AtomicReference) this.f17521k.getValue();
    }

    public Function5 c() {
        int i2 = a.f17537a[C().ordinal()];
        if (i2 == 1) {
            return t();
        }
        if (i2 == 2) {
            return s();
        }
        throw new NoWhenBranchMatchedException();
    }

    public h5 d() {
        return (h5) this.f17526p.getValue();
    }

    public j4 e() {
        return (j4) this.f17514d.getValue();
    }

    public s4 f() {
        return (s4) this.f17523m.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(z0 z0Var, f5 f5Var, l9 l9Var, Function1 function1, jb jbVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z0Var, f5Var, l9Var, (i2 & 8) != 0 ? d1.f17399b : function1, jbVar);
    }
}
