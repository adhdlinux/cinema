package com.adcolony.sdk;

import com.adcolony.sdk.e0;
import com.adcolony.sdk.s;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class t implements s.a {

    /* renamed from: a  reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f13381a = new LinkedBlockingQueue<>();

    /* renamed from: b  reason: collision with root package name */
    private int f13382b = 4;

    /* renamed from: c  reason: collision with root package name */
    private int f13383c = 16;

    /* renamed from: d  reason: collision with root package name */
    private double f13384d = 1.0d;

    /* renamed from: e  reason: collision with root package name */
    private ThreadPoolExecutor f13385e = new ThreadPoolExecutor(this.f13382b, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, this.f13381a);

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            t tVar = t.this;
            tVar.e(new s(h0Var, tVar));
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            t tVar = t.this;
            tVar.e(new s(h0Var, tVar));
        }
    }

    class c implements j0 {
        c() {
        }

        public void a(h0 h0Var) {
            t tVar = t.this;
            tVar.e(new s(h0Var, tVar));
        }
    }

    t() {
    }

    private void f() {
        int corePoolSize = this.f13385e.getCorePoolSize();
        int size = this.f13381a.size();
        int i2 = this.f13382b;
        if (((double) size) * this.f13384d > ((double) ((corePoolSize - i2) + 1)) && corePoolSize < this.f13383c) {
            this.f13385e.setCorePoolSize(corePoolSize + 1);
        } else if (size == 0 && corePoolSize > i2) {
            this.f13385e.setCorePoolSize(i2);
        }
    }

    public void a(s sVar, h0 h0Var, Map<String, List<String>> map) {
        f1 q2 = c0.q();
        c0.n(q2, ImagesContract.URL, sVar.f13368m);
        c0.w(q2, "success", sVar.f13370o);
        c0.u(q2, "status", sVar.f13372q);
        c0.n(q2, "body", sVar.f13369n);
        c0.u(q2, "size", sVar.f13371p);
        if (map != null) {
            f1 q3 = c0.q();
            for (Map.Entry next : map.entrySet()) {
                String obj = ((List) next.getValue()).toString();
                String substring = obj.substring(1, obj.length() - 1);
                if (next.getKey() != null) {
                    c0.n(q3, (String) next.getKey(), substring);
                }
            }
            c0.m(q2, "headers", q3);
        }
        h0Var.b(q2).e();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f13385e.allowCoreThreadTimeOut(true);
        a.e("WebServices.download", new a());
        a.e("WebServices.get", new b());
        a.e("WebServices.post", new c());
    }

    /* access modifiers changed from: package-private */
    public void c(double d2) {
        this.f13384d = d2;
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        this.f13382b = i2;
        int corePoolSize = this.f13385e.getCorePoolSize();
        int i3 = this.f13382b;
        if (corePoolSize < i3) {
            this.f13385e.setCorePoolSize(i3);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(s sVar) {
        f();
        try {
            this.f13385e.execute(sVar);
        } catch (RejectedExecutionException unused) {
            e0.a c2 = new e0.a().c("RejectedExecutionException: ThreadPoolExecutor unable to ");
            c2.c("execute download for url " + sVar.f13368m).d(e0.f13114i);
            a(sVar, sVar.c(), (Map<String, List<String>>) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        this.f13383c = i2;
        int corePoolSize = this.f13385e.getCorePoolSize();
        int i3 = this.f13383c;
        if (corePoolSize > i3) {
            this.f13385e.setCorePoolSize(i3);
        }
    }

    /* access modifiers changed from: package-private */
    public void h(int i2) {
        this.f13385e.setKeepAliveTime((long) i2, TimeUnit.SECONDS);
    }
}
