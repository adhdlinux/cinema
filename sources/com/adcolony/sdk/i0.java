package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import com.adcolony.sdk.e0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

@SuppressLint({"UseSparseArrays"})
class i0 {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<Integer, k0> f13163a = new LinkedHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private int f13164b = 2;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, ArrayList<j0>> f13165c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f13166d = 1;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final LinkedBlockingQueue<f1> f13167e = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f13168f = false;

    /* renamed from: g  reason: collision with root package name */
    private final ScheduledExecutorService f13169g = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: h  reason: collision with root package name */
    private final ExecutorService f13170h = Executors.newSingleThreadExecutor();

    /* renamed from: i  reason: collision with root package name */
    private ScheduledFuture<?> f13171i;

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13172b;

        a(Context context) {
            this.f13172b = context;
        }

        public void run() {
            f1 c2 = a.f().L0().c();
            f1 q2 = c0.q();
            c0.n(c2, "os_name", "android");
            c0.n(q2, "filepath", a.f().O0().c() + "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
            c0.m(q2, "info", c2);
            c0.u(q2, "m_origin", 0);
            c0.u(q2, "m_id", i0.a(i0.this));
            c0.n(q2, "m_type", "Controller.create");
            try {
                l.X(this.f13172b, new h0(q2));
            } catch (RuntimeException e2) {
                e0.a aVar = new e0.a();
                aVar.c(e2.toString() + ": during WebView initialization.").c(" Disabling AdColony.").d(e0.f13113h);
                AdColony.f();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            while (true) {
                try {
                    f1 f1Var = (f1) i0.this.f13167e.poll(60, TimeUnit.SECONDS);
                    if (f1Var != null) {
                        i0.this.m(f1Var);
                    } else {
                        synchronized (i0.this.f13167e) {
                            if (i0.this.f13167e.peek() == null) {
                                boolean unused = i0.this.f13168f = false;
                                return;
                            }
                        }
                    }
                } catch (InterruptedException e2) {
                    new e0.a().c("Native messages thread was interrupted: ").c(e2.toString()).d(e0.f13114i);
                }
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            a.k();
            if (!i0.this.u()) {
                i0.this.x();
            }
        }
    }

    class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f13176b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f1 f13177c;

        d(String str, f1 f1Var) {
            this.f13176b = str;
            this.f13177c = f1Var;
        }

        public void run() {
            i0.this.h(this.f13176b, this.f13177c);
        }
    }

    i0() {
    }

    static /* synthetic */ int a(i0 i0Var) {
        int i2 = i0Var.f13166d;
        i0Var.f13166d = i2 + 1;
        return i2;
    }

    private void e(f1 f1Var) {
        l();
        this.f13167e.add(f1Var);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r4.hasNext() == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        ((com.adcolony.sdk.j0) r4.next()).a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        new com.adcolony.sdk.e0.a().b(r3).d(com.adcolony.sdk.e0.f13114i);
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r3 = new com.adcolony.sdk.h0(r4);
        r4 = r1.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(java.lang.String r3, com.adcolony.sdk.f1 r4) {
        /*
            r2 = this;
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.adcolony.sdk.j0>> r0 = r2.f13165c
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.adcolony.sdk.j0>> r1 = r2.f13165c     // Catch:{ all -> 0x0041 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0041 }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x0041 }
            if (r3 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return
        L_0x000f:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0041 }
            r1.<init>(r3)     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            com.adcolony.sdk.h0 r3 = new com.adcolony.sdk.h0
            r3.<init>(r4)
            java.util.Iterator r4 = r1.iterator()
        L_0x001e:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0040
            java.lang.Object r0 = r4.next()
            com.adcolony.sdk.j0 r0 = (com.adcolony.sdk.j0) r0
            r0.a(r3)     // Catch:{ RuntimeException -> 0x002e }
            goto L_0x001e
        L_0x002e:
            r3 = move-exception
            com.adcolony.sdk.e0$a r4 = new com.adcolony.sdk.e0$a
            r4.<init>()
            com.adcolony.sdk.e0$a r4 = r4.b(r3)
            com.adcolony.sdk.e0 r0 = com.adcolony.sdk.e0.f13114i
            r4.d(r0)
            r3.printStackTrace()
        L_0x0040:
            return
        L_0x0041:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.i0.h(java.lang.String, com.adcolony.sdk.f1):void");
    }

    private void l() {
        if (!this.f13168f) {
            synchronized (this.f13167e) {
                if (!this.f13168f) {
                    this.f13168f = true;
                    new Thread(new b()).start();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void m(f1 f1Var) {
        try {
            String w2 = f1Var.w("m_type");
            int l2 = f1Var.l("m_origin");
            d dVar = new d(w2, f1Var);
            if (l2 >= 2) {
                z0.A(dVar);
            } else {
                this.f13170h.execute(dVar);
            }
        } catch (RejectedExecutionException e2) {
            new e0.a().c("RejectedExecutionException from message dispatcher's dispatchNativeMessage(): ").c(e2.toString()).d(e0.f13114i);
        } catch (JSONException e3) {
            new e0.a().c("JSON error from message dispatcher's dispatchNativeMessage(): ").c(e3.toString()).d(e0.f13114i);
        }
    }

    private void v() {
        if (this.f13171i == null) {
            try {
                this.f13171i = this.f13169g.scheduleAtFixedRate(new c(), 0, 17, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e2) {
                new e0.a().c("Error when scheduling message pumping").c(e2.toString()).d(e0.f13114i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public k0 b(int i2) {
        return this.f13163a.get(Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public k0 c(k0 k0Var) {
        synchronized (this.f13163a) {
            this.f13163a.put(Integer.valueOf(k0Var.getAdcModuleId()), k0Var);
            w();
        }
        return k0Var;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Context a2;
        k f2 = a.f();
        if (!f2.d() && !f2.e() && (a2 = a.a()) != null) {
            l();
            z0.A(new a(a2));
        }
    }

    /* access modifiers changed from: package-private */
    public void i(String str, j0 j0Var) {
        ArrayList arrayList = this.f13165c.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f13165c.put(str, arrayList);
        }
        arrayList.add(j0Var);
    }

    /* access modifiers changed from: package-private */
    public void n(String str, j0 j0Var) {
        synchronized (this.f13165c) {
            ArrayList arrayList = this.f13165c.get(str);
            if (arrayList != null) {
                arrayList.remove(j0Var);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean o(int i2) {
        synchronized (this.f13163a) {
            k0 remove = this.f13163a.remove(Integer.valueOf(i2));
            if (remove == null) {
                return false;
            }
            remove.c();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean p(k0 k0Var) {
        return o(k0Var.getAdcModuleId());
    }

    /* access modifiers changed from: package-private */
    public l q() {
        k0 b2 = b(1);
        if (b2 instanceof l) {
            return (l) b2;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void r(f1 f1Var) {
        try {
            if (f1Var.t("m_id", this.f13166d)) {
                this.f13166d++;
            }
            f1Var.t("m_origin", 0);
            int l2 = f1Var.l("m_target");
            if (l2 == 0) {
                e(f1Var);
                return;
            }
            k0 k0Var = this.f13163a.get(Integer.valueOf(l2));
            if (k0Var != null) {
                k0Var.a(f1Var);
            }
        } catch (JSONException e2) {
            new e0.a().c("JSON error in ADCMessageDispatcher's sendMessage(): ").c(e2.toString()).d(e0.f13114i);
        }
    }

    /* access modifiers changed from: package-private */
    public LinkedHashMap<Integer, k0> s() {
        return this.f13163a;
    }

    /* access modifiers changed from: package-private */
    public int t() {
        int i2 = this.f13164b;
        this.f13164b = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        for (k0 a2 : this.f13163a.values()) {
            if (a2.a()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        if (u()) {
            v();
        }
    }

    /* access modifiers changed from: package-private */
    public void x() {
        ScheduledFuture<?> scheduledFuture = this.f13171i;
        if (scheduledFuture != null) {
            if (!scheduledFuture.isCancelled()) {
                this.f13171i.cancel(false);
            }
            this.f13171i = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void y() {
        synchronized (this.f13163a) {
            ArrayList arrayList = new ArrayList(this.f13163a.values());
            Collections.reverse(arrayList);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((k0) it2.next()).b();
            }
        }
    }
}
