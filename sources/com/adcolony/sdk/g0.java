package com.adcolony.sdk;

import android.util.Log;
import com.applovin.sdk.AppLovinEventTypes;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class g0 {

    /* renamed from: f  reason: collision with root package name */
    static boolean f13133f = false;

    /* renamed from: g  reason: collision with root package name */
    static int f13134g = 3;

    /* renamed from: h  reason: collision with root package name */
    static int f13135h = 1;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public f1 f13136a = c0.q();

    /* renamed from: b  reason: collision with root package name */
    private e1 f13137b = null;

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f13138c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<Runnable> f13139d = new ConcurrentLinkedQueue();

    /* renamed from: e  reason: collision with root package name */
    s0 f13140e;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            g0.this.m(c0.A(h0Var.a(), "module"), 0, c0.E(h0Var.a(), "message"), true);
        }
    }

    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f13142b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13143c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f13144d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f13145e;

        b(int i2, String str, int i3, boolean z2) {
            this.f13142b = i2;
            this.f13143c = str;
            this.f13144d = i3;
            this.f13145e = z2;
        }

        public void run() {
            g0.this.e(this.f13142b, this.f13143c, this.f13144d);
            int i2 = 0;
            while (i2 <= this.f13143c.length() / 4000) {
                int i3 = i2 * 4000;
                i2++;
                int min = Math.min(i2 * 4000, this.f13143c.length());
                if (this.f13144d == 3) {
                    g0 g0Var = g0.this;
                    if (g0Var.j(c0.C(g0Var.f13136a, Integer.toString(this.f13142b)), 3, this.f13145e)) {
                        Log.d("AdColony [TRACE]", this.f13143c.substring(i3, min));
                    }
                }
                if (this.f13144d == 2) {
                    g0 g0Var2 = g0.this;
                    if (g0Var2.j(c0.C(g0Var2.f13136a, Integer.toString(this.f13142b)), 2, this.f13145e)) {
                        Log.i("AdColony [INFO]", this.f13143c.substring(i3, min));
                    }
                }
                if (this.f13144d == 1) {
                    g0 g0Var3 = g0.this;
                    if (g0Var3.j(c0.C(g0Var3.f13136a, Integer.toString(this.f13142b)), 1, this.f13145e)) {
                        Log.w("AdColony [WARNING]", this.f13143c.substring(i3, min));
                    }
                }
                if (this.f13144d == 0) {
                    g0 g0Var4 = g0.this;
                    if (g0Var4.j(c0.C(g0Var4.f13136a, Integer.toString(this.f13142b)), 0, this.f13145e)) {
                        Log.e("AdColony [ERROR]", this.f13143c.substring(i3, min));
                    }
                }
                if (this.f13144d == -1 && g0.f13134g >= -1) {
                    Log.e("AdColony [FATAL]", this.f13143c.substring(i3, min));
                }
            }
        }
    }

    class c implements j0 {
        c(g0 g0Var) {
        }

        public void a(h0 h0Var) {
            g0.f13134g = c0.A(h0Var.a(), AppLovinEventTypes.USER_COMPLETED_LEVEL);
        }
    }

    class d implements j0 {
        d() {
        }

        public void a(h0 h0Var) {
            g0.this.m(c0.A(h0Var.a(), "module"), 3, c0.E(h0Var.a(), "message"), false);
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            g0.this.m(c0.A(h0Var.a(), "module"), 3, c0.E(h0Var.a(), "message"), true);
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            g0.this.m(c0.A(h0Var.a(), "module"), 2, c0.E(h0Var.a(), "message"), false);
        }
    }

    class g implements j0 {
        g() {
        }

        public void a(h0 h0Var) {
            g0.this.m(c0.A(h0Var.a(), "module"), 2, c0.E(h0Var.a(), "message"), true);
        }
    }

    class h implements j0 {
        h() {
        }

        public void a(h0 h0Var) {
            g0.this.m(c0.A(h0Var.a(), "module"), 1, c0.E(h0Var.a(), "message"), false);
        }
    }

    class i implements j0 {
        i() {
        }

        public void a(h0 h0Var) {
            g0.this.m(c0.A(h0Var.a(), "module"), 1, c0.E(h0Var.a(), "message"), true);
        }
    }

    class j implements j0 {
        j() {
        }

        public void a(h0 h0Var) {
            g0.this.m(c0.A(h0Var.a(), "module"), 0, c0.E(h0Var.a(), "message"), false);
        }
    }

    g0() {
    }

    private Runnable d(int i2, int i3, String str, boolean z2) {
        return new b(i2, str, i3, z2);
    }

    /* access modifiers changed from: private */
    public void e(int i2, String str, int i3) {
        if (this.f13140e != null) {
            if (i3 == 3 && i(c0.C(this.f13136a, Integer.toString(i2)), 3)) {
                this.f13140e.e(str);
            } else if (i3 == 2 && i(c0.C(this.f13136a, Integer.toString(i2)), 2)) {
                this.f13140e.i(str);
            } else if (i3 == 1 && i(c0.C(this.f13136a, Integer.toString(i2)), 1)) {
                this.f13140e.j(str);
            } else if (i3 == 0 && i(c0.C(this.f13136a, Integer.toString(i2)), 0)) {
                this.f13140e.h(str);
            }
        }
    }

    private boolean k(Runnable runnable) {
        try {
            ExecutorService executorService = this.f13138c;
            if (executorService == null || executorService.isShutdown() || this.f13138c.isTerminated()) {
                return false;
            }
            this.f13138c.submit(runnable);
            return true;
        } catch (RejectedExecutionException unused) {
            Log.e("ADCLogError", "Internal error when submitting log to executor service.");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public f1 a(e1 e1Var) {
        f1 q2 = c0.q();
        for (int i2 = 0; i2 < e1Var.e(); i2++) {
            f1 f2 = c0.f(e1Var, i2);
            c0.m(q2, Integer.toString(c0.A(f2, "id")), f2);
        }
        return q2;
    }

    /* access modifiers changed from: package-private */
    public s0 c() {
        return this.f13140e;
    }

    /* access modifiers changed from: package-private */
    public void f(int i2, String str, boolean z2) {
        m(0, i2, str, z2);
    }

    /* access modifiers changed from: package-private */
    public void h(HashMap<String, Object> hashMap) {
        try {
            s0 s0Var = new s0(new d0(new URL("https://wd.adcolony.com/logs")), Executors.newSingleThreadScheduledExecutor(), hashMap);
            this.f13140e = s0Var;
            s0Var.d(5, TimeUnit.SECONDS);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean i(f1 f1Var, int i2) {
        int A = c0.A(f1Var, "send_level");
        if (f1Var.q()) {
            A = f13135h;
        }
        if (A < i2 || A == 4) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean j(f1 f1Var, int i2, boolean z2) {
        int A = c0.A(f1Var, "print_level");
        boolean t2 = c0.t(f1Var, "log_private");
        if (f1Var.q()) {
            A = f13134g;
            t2 = f13133f;
        }
        if ((!z2 || t2) && A != 4 && A >= i2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public e1 l() {
        return this.f13137b;
    }

    /* access modifiers changed from: package-private */
    public void m(int i2, int i3, String str, boolean z2) {
        if (!k(d(i2, i3, str, z2))) {
            synchronized (this.f13139d) {
                this.f13139d.add(d(i2, i3, str, z2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n(e1 e1Var) {
        this.f13136a = a(e1Var);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        a.e("Log.set_log_level", new c(this));
        a.e("Log.public.trace", new d());
        a.e("Log.private.trace", new e());
        a.e("Log.public.info", new f());
        a.e("Log.private.info", new g());
        a.e("Log.public.warning", new h());
        a.e("Log.private.warning", new i());
        a.e("Log.public.error", new j());
        a.e("Log.private.error", new a());
    }

    /* access modifiers changed from: package-private */
    public void p(e1 e1Var) {
        if (e1Var != null) {
            e1Var.g(AppLovinEventTypes.USER_COMPLETED_LEVEL);
            e1Var.g("message");
        }
        this.f13137b = e1Var;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        ExecutorService executorService = this.f13138c;
        if (executorService == null || executorService.isShutdown() || this.f13138c.isTerminated()) {
            this.f13138c = Executors.newSingleThreadExecutor();
        }
        synchronized (this.f13139d) {
            while (!this.f13139d.isEmpty()) {
                k(this.f13139d.poll());
            }
        }
    }
}
