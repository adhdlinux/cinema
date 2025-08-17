package com.startapp.sdk.components;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.startapp.ad;
import com.startapp.b9;
import com.startapp.bd;
import com.startapp.bf;
import com.startapp.cd;
import com.startapp.ce;
import com.startapp.de;
import com.startapp.e9;
import com.startapp.ed;
import com.startapp.gd;
import com.startapp.ge;
import com.startapp.ha;
import com.startapp.he;
import com.startapp.ia;
import com.startapp.id;
import com.startapp.j3;
import com.startapp.jc;
import com.startapp.je;
import com.startapp.kc;
import com.startapp.kd;
import com.startapp.lc;
import com.startapp.mb;
import com.startapp.mc;
import com.startapp.md;
import com.startapp.nb;
import com.startapp.nc;
import com.startapp.oc;
import com.startapp.od;
import com.startapp.oe;
import com.startapp.p6;
import com.startapp.pc;
import com.startapp.qc;
import com.startapp.qe;
import com.startapp.r8;
import com.startapp.r9;
import com.startapp.rb;
import com.startapp.rc;
import com.startapp.rd;
import com.startapp.s8;
import com.startapp.sc;
import com.startapp.sdk.adsbase.crashreport.ANRRemoteConfig;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.TelephonyMetadata;
import com.startapp.sdk.common.advertisingid.AdvertisingIdResolver;
import com.startapp.sdk.jobs.SchedulerService;
import com.startapp.t8;
import com.startapp.t9;
import com.startapp.tc;
import com.startapp.u8;
import com.startapp.ua;
import com.startapp.uc;
import com.startapp.v8;
import com.startapp.va;
import com.startapp.vc;
import com.startapp.w8;
import com.startapp.wa;
import com.startapp.wc;
import com.startapp.x6;
import com.startapp.xa;
import com.startapp.xc;
import com.startapp.ya;
import com.startapp.yc;
import com.startapp.zc;
import com.startapp.zd;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ComponentLocator {

    /* renamed from: a  reason: collision with root package name */
    public static final kc<ComponentLocator, Context> f36427a = new k();
    public final jc<Executor> A;
    public final jc<Executor> B;
    public final jc<Executor> C;
    public final jc<Executor> D;
    public final jc<va> E;
    public final jc<x6> F;
    public final jc<x6> G;
    public final jc<v8> H;
    public final jc<j3> I;
    public final jc<u8> J;

    /* renamed from: b  reason: collision with root package name */
    public final jc<ya> f36428b;

    /* renamed from: c  reason: collision with root package name */
    public final jc<nb> f36429c;

    /* renamed from: d  reason: collision with root package name */
    public final jc<mb> f36430d;

    /* renamed from: e  reason: collision with root package name */
    public final jc<id> f36431e;

    /* renamed from: f  reason: collision with root package name */
    public final jc<gd> f36432f;

    /* renamed from: g  reason: collision with root package name */
    public final jc<od> f36433g;

    /* renamed from: h  reason: collision with root package name */
    public final jc<rd> f36434h;

    /* renamed from: i  reason: collision with root package name */
    public final jc<AdvertisingIdResolver> f36435i;

    /* renamed from: j  reason: collision with root package name */
    public final jc<qe> f36436j;

    /* renamed from: k  reason: collision with root package name */
    public final jc<s8> f36437k;

    /* renamed from: l  reason: collision with root package name */
    public final jc<zd> f36438l;

    /* renamed from: m  reason: collision with root package name */
    public final jc<ha> f36439m = new g(this);

    /* renamed from: n  reason: collision with root package name */
    public final jc<bf> f36440n;

    /* renamed from: o  reason: collision with root package name */
    public final jc<p6> f36441o;

    /* renamed from: p  reason: collision with root package name */
    public final jc<w8> f36442p;

    /* renamed from: q  reason: collision with root package name */
    public final jc<md> f36443q;

    /* renamed from: r  reason: collision with root package name */
    public final jc<rb> f36444r;

    /* renamed from: s  reason: collision with root package name */
    public final jc<e9> f36445s;

    /* renamed from: t  reason: collision with root package name */
    public final jc<ed> f36446t;

    /* renamed from: u  reason: collision with root package name */
    public final jc<kd> f36447u;

    /* renamed from: v  reason: collision with root package name */
    public final jc<r8> f36448v;

    /* renamed from: w  reason: collision with root package name */
    public final jc<oe> f36449w;

    /* renamed from: x  reason: collision with root package name */
    public final jc<ce> f36450x;

    /* renamed from: y  reason: collision with root package name */
    public final jc<je> f36451y;

    /* renamed from: z  reason: collision with root package name */
    public final jc<va> f36452z;

    public class a extends jc<od> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36453b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ua f36454c;

        public a(Context context, ua uaVar) {
            this.f36453b = context;
            this.f36454c = uaVar;
        }

        public Object a() {
            return new od(this.f36453b, new x6(this.f36453b.getSharedPreferences("StartApp-6d5362e8ecc8a910", 0), (x6.b) null), ComponentLocator.this.g(), this.f36454c);
        }
    }

    public class a0 extends jc<va> {
        public a0(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a("dc");
        }
    }

    public class b extends jc<rd> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36456b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ua f36457c;

        public b(Context context, ua uaVar) {
            this.f36456b = context;
            this.f36457c = uaVar;
        }

        public Object a() {
            return new rd(this.f36456b, ComponentLocator.this.g(), new x6(this.f36456b.getSharedPreferences("StartApp-c5f5846c2a728b2a", 0), (x6.b) null), this.f36457c);
        }
    }

    public class b0 extends jc<x6> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36459b;

        public b0(ComponentLocator componentLocator, Context context) {
            this.f36459b = context;
        }

        public Object a() {
            return new x6(this.f36459b.getSharedPreferences("com.startapp.sdk", 0), (x6.b) null);
        }
    }

    public class c extends jc<AdvertisingIdResolver> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36460b;

        public c(ComponentLocator componentLocator, Context context) {
            this.f36460b = context;
        }

        public Object a() {
            return new AdvertisingIdResolver(this.f36460b, new h0("air"), new lc(this));
        }
    }

    public class c0 extends jc<x6> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36461b;

        public c0(ComponentLocator componentLocator, Context context) {
            this.f36461b = context;
        }

        public Object a() {
            return new x6(this.f36461b.getSharedPreferences("com.startapp.sdk.extras", 0), new bd(this));
        }
    }

    public class d extends jc<qe> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36462b;

        public d(ComponentLocator componentLocator, Context context) {
            this.f36462b = context;
        }

        public Object a() {
            return new qe(this.f36462b, new mc(this));
        }
    }

    public class d0 extends jc<v8> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36463b;

        public d0(ComponentLocator componentLocator, Context context) {
            this.f36463b = context;
        }

        public Object a() {
            return new v8(this.f36463b);
        }
    }

    public class e extends jc<s8> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36464b;

        public e(Context context) {
            this.f36464b = context;
        }

        public Object a() {
            return new s8(this.f36464b, ComponentLocator.this.d());
        }
    }

    public class e0 extends jc<j3> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36466b;

        public e0(ComponentLocator componentLocator, Context context) {
            this.f36466b = context;
        }

        public Object a() {
            return new j3(this.f36466b, new cd(this));
        }
    }

    public class f extends jc<zd> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36467b;

        public f(ComponentLocator componentLocator, Context context) {
            this.f36467b = context;
        }

        public Object a() {
            return new zd(new x6(this.f36467b.getSharedPreferences("StartApp-54ff24db2aee60b9", 0), (x6.b) null));
        }
    }

    public class f0 extends jc<ya> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36468b;

        public f0(ComponentLocator componentLocator, Context context) {
            this.f36468b = context;
        }

        public Object a() {
            return new ya(new x6(this.f36468b.getSharedPreferences("StartApp-c065dea8f7f3a31b", 0), (x6.b) null));
        }
    }

    public class g extends jc<ha> {
        public g(ComponentLocator componentLocator) {
        }

        public Object a() {
            return new ha();
        }
    }

    public static class g0 implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                threadPoolExecutor.getQueue().put(runnable);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public class h extends jc<bf> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36469b;

        public h(ComponentLocator componentLocator, Context context) {
            this.f36469b = context;
        }

        public Object a() {
            return new bf(this.f36469b, new x6(this.f36469b.getSharedPreferences("StartApp-fba1a5307d96ef31", 0), (x6.b) null), ComponentLocator.a(0, 1, "tlp", 5), ComponentLocator.a(this.f36469b).a(), new nc(this));
        }
    }

    public static class h0 implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f36470a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f36471b;

        public h0(String str) {
            this.f36471b = str;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "startapp-" + this.f36471b + "-" + this.f36470a.incrementAndGet());
        }
    }

    public class i extends jc<p6> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36472b;

        public i(ComponentLocator componentLocator, Context context) {
            this.f36472b = context;
        }

        public Object a() {
            return new p6(new x6(this.f36472b.getSharedPreferences("StartApp-790ba54ab8e69f2f", 0), (x6.b) null));
        }
    }

    public class i0 extends jc<nb> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36473b;

        public i0(ComponentLocator componentLocator, Context context) {
            this.f36473b = context;
        }

        public Object a() {
            return new nb(this.f36473b);
        }
    }

    public class j extends jc<w8> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36474b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ jc f36475c;

        public j(Context context, jc jcVar) {
            this.f36474b = context;
            this.f36475c = jcVar;
        }

        public Object a() {
            return new w8(this.f36474b, ComponentLocator.this.a(), ComponentLocator.this.m(), new r9(this.f36474b, new x6(this.f36474b.getSharedPreferences("StartApp-770c613f81fb5b52", 0), (x6.b) null), new t9(this.f36474b, "StartApp-ac51a09f00e0f80c"), (Executor) this.f36475c.b(), new oc(this)), new pc(this));
        }
    }

    public class j0 extends jc<mb> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36477b;

        public j0(Context context) {
            this.f36477b = context;
        }

        public Object a() {
            return new mb(this.f36477b, ComponentLocator.this.u());
        }
    }

    public static class k extends kc<ComponentLocator, Context> {
    }

    public class k0 extends jc<va> {
        public k0(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a("db");
        }
    }

    public class l extends jc<md> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36479b;

        public l(ComponentLocator componentLocator, Context context) {
            this.f36479b = context;
        }

        public Object a() {
            return new md(this.f36479b, new x6(this.f36479b.getSharedPreferences("StartApp-9b9bfdb86df82dad", 0), (x6.b) null), new sc(this));
        }
    }

    public class l0 extends jc<id> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36480b;

        public l0(ComponentLocator componentLocator, Context context) {
            this.f36480b = context;
        }

        public Object a() {
            return new id(this.f36480b);
        }
    }

    public class m extends jc<rb> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36481b;

        public m(ComponentLocator componentLocator, Context context) {
            this.f36481b = context;
        }

        public Object a() {
            return new rb(this.f36481b);
        }
    }

    public class m0 extends jc<gd> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36482b;

        public m0(ComponentLocator componentLocator, Context context) {
            this.f36482b = context;
        }

        public Object a() {
            return new gd(this.f36482b);
        }
    }

    public class n extends jc<e9> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36483b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ jc f36484c;

        public n(Context context, jc jcVar) {
            this.f36483b = context;
            this.f36484c = jcVar;
        }

        public Object a() {
            ua uaVar;
            Executor a2 = ComponentLocator.a(0, 2, "info", 5);
            b9 b9Var = new b9(this.f36483b, "StartApp-d6864f2502af7851");
            va vaVar = (va) this.f36484c.b();
            if (a2 instanceof ThreadPoolExecutor) {
                uaVar = new tc(this, a2);
            } else {
                uaVar = new uc(this);
            }
            return new e9(b9Var, vaVar, a2, uaVar, ComponentLocator.this.e(), new vc(this), new wc(this));
        }
    }

    public class n0 implements ua<TelephonyMetadata> {
        public n0(ComponentLocator componentLocator) {
        }

        public Object call() {
            return MetaData.f36379h.I();
        }
    }

    public class o extends jc<ed> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36486b;

        public o(Context context) {
            this.f36486b = context;
        }

        public Object a() {
            return new ed(this.f36486b, ComponentLocator.this.d(), new x6(this.f36486b.getSharedPreferences("StartApp-dfeaf103310003d9", 0), (x6.b) null), ComponentLocator.this.f(), ComponentLocator.this.g(), new xc(this));
        }
    }

    public class p extends jc<kd> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36488b;

        public p(Context context) {
            this.f36488b = context;
        }

        public Object a() {
            return new kd(this.f36488b, new x6(this.f36488b.getSharedPreferences("StartApp-6cd3cac226013e8e", 0), (x6.b) null), ComponentLocator.this.f(), ComponentLocator.this.g(), new yc(this));
        }
    }

    public class q extends jc<r8> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36490b;

        public q(ComponentLocator componentLocator, Context context) {
            this.f36490b = context;
        }

        public Object a() {
            return new r8(this.f36490b);
        }
    }

    public class r extends jc<oe> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36491b;

        public r(Context context) {
            this.f36491b = context;
        }

        public Object a() {
            return new oe(this.f36491b, ComponentLocator.this.i(), new zc(this));
        }
    }

    public class s extends jc<ce> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36493b;

        public s(ComponentLocator componentLocator, Context context) {
            this.f36493b = context;
        }

        public Object a() {
            Context context = this.f36493b;
            Pair pair = new Pair(new de(context, SchedulerService.class), new he(context));
            return new ce((ge) pair.first, (ge) pair.second);
        }
    }

    public class t extends jc<je> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36494b;

        public t(ComponentLocator componentLocator, Context context) {
            this.f36494b = context;
        }

        public Object a() {
            return new je(this.f36494b, new x6(this.f36494b.getSharedPreferences("StartApp-b36110d5cb803404", 0), (x6.b) null), new ad(this), new Handler(Looper.getMainLooper()));
        }
    }

    public class u extends jc<va> {
        public u(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a("core");
        }
    }

    public class v extends jc<u8> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f36495b;

        public v(ComponentLocator componentLocator, Context context) {
            this.f36495b = context;
        }

        public Object a() {
            long j2;
            boolean z2;
            ANRRemoteConfig e2 = MetaData.f36379h.e();
            if (e2 != null) {
                j2 = e2.c();
            } else {
                j2 = 2000;
            }
            if (e2 == null || !e2.g()) {
                z2 = false;
            } else {
                z2 = true;
            }
            u8 u8Var = new u8(j2, z2);
            if (e2 != null && e2.e()) {
                u8Var.f36652b = new qc(this, e2);
                u8Var.f36651a = new t8(this.f36495b, "com.startapp.", e2.h(), e2.a(), e2.d());
                if (e2.f()) {
                    u8Var.f36654d = new rc(this);
                }
                u8Var.start();
            }
            return u8Var;
        }
    }

    public class w extends jc<Executor> {
        public w(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a(0, 4, "net-api", 10);
        }
    }

    public class x extends jc<Executor> {
        public x(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a(0, 2, "net-media", 10);
        }
    }

    public class y extends jc<Executor> {
        public y(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a(0, 2, "disk", 5);
        }
    }

    public class z extends jc<Executor> {
        public z(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a(0, 4, "generic", 5);
        }
    }

    public ComponentLocator(Context context) {
        this.J = new v(this, context);
        this.f36428b = new f0(this, context);
        this.f36429c = new i0(this, context);
        this.f36430d = new j0(context);
        k0 k0Var = new k0(this);
        this.f36431e = new l0(this, context);
        this.f36432f = new m0(this, context);
        n0 n0Var = new n0(this);
        this.f36433g = new a(context, n0Var);
        this.f36434h = new b(context, n0Var);
        this.f36435i = new c(this, context);
        this.f36436j = new d(this, context);
        this.f36437k = new e(context);
        this.f36438l = new f(this, context);
        this.f36440n = new h(this, context);
        this.f36441o = new i(this, context);
        this.f36442p = new j(context, k0Var);
        this.f36443q = new l(this, context);
        this.f36444r = new m(this, context);
        this.f36445s = new n(context, k0Var);
        this.f36446t = new o(context);
        this.f36447u = new p(context);
        this.f36448v = new q(this, context);
        this.f36449w = new r(context);
        this.f36450x = new s(this, context);
        this.f36451y = new t(this, context);
        this.f36452z = new u(this);
        this.A = new w(this);
        this.B = new x(this);
        this.C = new y(this);
        this.D = new z(this);
        this.E = new a0(this);
        this.F = new b0(this, context);
        this.G = new c0(this, context);
        this.H = new d0(this, context);
        this.I = new e0(this, context);
    }

    public static ComponentLocator a(Context context) {
        kc<ComponentLocator, Context> kcVar = f36427a;
        T t2 = kcVar.f34843a;
        if (t2 == null) {
            synchronized (kcVar) {
                t2 = kcVar.f34843a;
                if (t2 == null) {
                    t2 = new ComponentLocator(ia.b(context));
                    kcVar.f34843a = t2;
                }
            }
        }
        return (ComponentLocator) t2;
    }

    public rb b() {
        return this.f36444r.b();
    }

    public p6 c() {
        return this.f36441o.b();
    }

    public x6 d() {
        return this.F.b();
    }

    public r8 e() {
        return this.f36448v.b();
    }

    public s8 f() {
        return this.f36437k.b();
    }

    public va g() {
        return this.E.b();
    }

    public Executor h() {
        return this.C.b();
    }

    public Executor i() {
        return this.D.b();
    }

    public w8 j() {
        return this.f36442p.b();
    }

    public e9 k() {
        return this.f36445s.b();
    }

    public ce l() {
        return this.f36450x.b();
    }

    public id m() {
        return this.f36431e.b();
    }

    public je n() {
        return this.f36451y.b();
    }

    public Executor o() {
        return this.A.b();
    }

    public qe p() {
        return this.f36436j.b();
    }

    public oe q() {
        return this.f36449w.b();
    }

    public ha r() {
        return this.f36439m.b();
    }

    public od s() {
        return this.f36433g.b();
    }

    public rd t() {
        return this.f36434h.b();
    }

    public nb u() {
        return this.f36429c.b();
    }

    public static ThreadFactory b(String str) {
        return new h0(str);
    }

    public AdvertisingIdResolver a() {
        return this.f36435i.b();
    }

    public static Executor a(int i2, int i3, String str, long j2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, j2, TimeUnit.SECONDS, new LinkedTransferQueue<Runnable>() {
            public boolean offer(Object obj) {
                return tryTransfer((Runnable) obj);
            }
        }, new h0(str), new g0());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static va a(String str) {
        xa xaVar = new xa("startapp-" + str);
        xaVar.start();
        return new wa(new Handler(xaVar.getLooper()));
    }
}
