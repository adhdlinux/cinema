package com.adcolony.sdk;

import android.util.Log;
import com.adcolony.sdk.f0;
import com.applovin.sdk.AppLovinEventTypes;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

class s0 {

    /* renamed from: a  reason: collision with root package name */
    d0 f13373a;

    /* renamed from: b  reason: collision with root package name */
    ScheduledExecutorService f13374b;

    /* renamed from: c  reason: collision with root package name */
    List<f0> f13375c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    HashMap<String, Object> f13376d;

    /* renamed from: e  reason: collision with root package name */
    private b0 f13377e = new b0("adcolony_android", "4.8.0", "Production");

    class a implements Runnable {
        a() {
        }

        public void run() {
            s0.this.c();
        }
    }

    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f0 f13379b;

        b(f0 f0Var) {
            this.f13379b = f0Var;
        }

        public void run() {
            s0.this.f13375c.add(this.f13379b);
        }
    }

    s0(d0 d0Var, ScheduledExecutorService scheduledExecutorService, HashMap<String, Object> hashMap) {
        this.f13373a = d0Var;
        this.f13374b = scheduledExecutorService;
        this.f13376d = hashMap;
    }

    private synchronized f1 a(f0 f0Var) throws JSONException {
        f1 f1Var;
        f1Var = new f1((Map<?, ?>) this.f13376d);
        f1Var.f("environment", f0Var.b().a());
        f1Var.f(AppLovinEventTypes.USER_COMPLETED_LEVEL, f0Var.f());
        f1Var.f("message", f0Var.g());
        f1Var.f("clientTimestamp", f0Var.h());
        f1 f1Var2 = new f1(a.f().L0().e());
        f1 f1Var3 = new f1(a.f().L0().h());
        f1Var.f("mediation_network", c0.E(f1Var2, "name"));
        f1Var.f("mediation_network_version", c0.E(f1Var2, MediationMetaData.KEY_VERSION));
        f1Var.f("plugin", c0.E(f1Var3, "name"));
        f1Var.f("plugin_version", c0.E(f1Var3, MediationMetaData.KEY_VERSION));
        e1 l2 = a.f().D0().l();
        if (l2 == null || l2.d("batteryInfo")) {
            f1Var.m("batteryInfo", a.f().x0().N());
        }
        if (l2 != null) {
            f1Var.h(l2);
        }
        return f1Var;
    }

    /* access modifiers changed from: package-private */
    public String b(b0 b0Var, List<f0> list) throws JSONException {
        f1 f1Var = new f1();
        f1Var.f("index", b0Var.b());
        f1Var.f("environment", b0Var.a());
        f1Var.f(MediationMetaData.KEY_VERSION, b0Var.c());
        e1 e1Var = new e1();
        for (f0 a2 : list) {
            e1Var.a(a(a2));
        }
        f1Var.d("logs", e1Var);
        return f1Var.toString();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List<com.adcolony.sdk.f0> r0 = r2.f13375c     // Catch:{ IOException -> 0x0024, JSONException -> 0x001e }
            int r0 = r0.size()     // Catch:{ IOException -> 0x0024, JSONException -> 0x001e }
            if (r0 <= 0) goto L_0x0029
            com.adcolony.sdk.b0 r0 = r2.f13377e     // Catch:{ IOException -> 0x0024, JSONException -> 0x001e }
            java.util.List<com.adcolony.sdk.f0> r1 = r2.f13375c     // Catch:{ IOException -> 0x0024, JSONException -> 0x001e }
            java.lang.String r0 = r2.b(r0, r1)     // Catch:{ IOException -> 0x0024, JSONException -> 0x001e }
            com.adcolony.sdk.d0 r1 = r2.f13373a     // Catch:{ IOException -> 0x0024, JSONException -> 0x001e }
            r1.a(r0)     // Catch:{ IOException -> 0x0024, JSONException -> 0x001e }
            java.util.List<com.adcolony.sdk.f0> r0 = r2.f13375c     // Catch:{ IOException -> 0x0024, JSONException -> 0x001e }
            r0.clear()     // Catch:{ IOException -> 0x0024, JSONException -> 0x001e }
            goto L_0x0029
        L_0x001c:
            r0 = move-exception
            goto L_0x002b
        L_0x001e:
            java.util.List<com.adcolony.sdk.f0> r0 = r2.f13375c     // Catch:{ all -> 0x001c }
            r0.clear()     // Catch:{ all -> 0x001c }
            goto L_0x0029
        L_0x0024:
            java.util.List<com.adcolony.sdk.f0> r0 = r2.f13375c     // Catch:{ all -> 0x001c }
            r0.clear()     // Catch:{ all -> 0x001c }
        L_0x0029:
            monitor-exit(r2)     // Catch:{ all -> 0x001c }
            return
        L_0x002b:
            monitor-exit(r2)     // Catch:{ all -> 0x001c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.s0.c():void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void d(long j2, TimeUnit timeUnit) {
        try {
            if (!this.f13374b.isShutdown() && !this.f13374b.isTerminated()) {
                this.f13374b.scheduleAtFixedRate(new a(), j2, j2, timeUnit);
            }
        } catch (RuntimeException unused) {
            Log.e("ADCLogError", "Internal error when submitting remote log to executor service");
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public synchronized void e(String str) {
        g(new f0.a().a(3).b(this.f13377e).c(str).d());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4.f13374b.shutdownNow();
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void f() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.ScheduledExecutorService r0 = r4.f13374b     // Catch:{ all -> 0x004a }
            r0.shutdown()     // Catch:{ all -> 0x004a }
            java.util.concurrent.ScheduledExecutorService r0 = r4.f13374b     // Catch:{ InterruptedException -> 0x003c }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x003c }
            r2 = 1
            boolean r0 = r0.awaitTermination(r2, r1)     // Catch:{ InterruptedException -> 0x003c }
            if (r0 != 0) goto L_0x0048
            java.util.concurrent.ScheduledExecutorService r0 = r4.f13374b     // Catch:{ InterruptedException -> 0x003c }
            r0.shutdownNow()     // Catch:{ InterruptedException -> 0x003c }
            java.util.concurrent.ScheduledExecutorService r0 = r4.f13374b     // Catch:{ InterruptedException -> 0x003c }
            boolean r0 = r0.awaitTermination(r2, r1)     // Catch:{ InterruptedException -> 0x003c }
            if (r0 != 0) goto L_0x0048
            java.io.PrintStream r0 = java.lang.System.err     // Catch:{ InterruptedException -> 0x003c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x003c }
            r1.<init>()     // Catch:{ InterruptedException -> 0x003c }
            java.lang.Class<com.adcolony.sdk.s0> r2 = com.adcolony.sdk.s0.class
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ InterruptedException -> 0x003c }
            r1.append(r2)     // Catch:{ InterruptedException -> 0x003c }
            java.lang.String r2 = ": ScheduledExecutorService did not terminate"
            r1.append(r2)     // Catch:{ InterruptedException -> 0x003c }
            java.lang.String r1 = r1.toString()     // Catch:{ InterruptedException -> 0x003c }
            r0.println(r1)     // Catch:{ InterruptedException -> 0x003c }
            goto L_0x0048
        L_0x003c:
            java.util.concurrent.ScheduledExecutorService r0 = r4.f13374b     // Catch:{ all -> 0x004a }
            r0.shutdownNow()     // Catch:{ all -> 0x004a }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x004a }
            r0.interrupt()     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r4)
            return
        L_0x004a:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.s0.f():void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void g(f0 f0Var) {
        try {
            if (!this.f13374b.isShutdown() && !this.f13374b.isTerminated()) {
                this.f13374b.submit(new b(f0Var));
            }
        } catch (RejectedExecutionException unused) {
            Log.e("ADCLogError", "Internal error when submitting remote log to executor service");
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public synchronized void h(String str) {
        g(new f0.a().a(0).b(this.f13377e).c(str).d());
    }

    /* access modifiers changed from: package-private */
    public synchronized void i(String str) {
        g(new f0.a().a(2).b(this.f13377e).c(str).d());
    }

    /* access modifiers changed from: package-private */
    public synchronized void j(String str) {
        g(new f0.a().a(1).b(this.f13377e).c(str).d());
    }

    /* access modifiers changed from: package-private */
    public synchronized void k(String str) {
        this.f13376d.put("controllerVersion", str);
    }

    /* access modifiers changed from: package-private */
    public synchronized void l(String str) {
        this.f13376d.put(JsonStorageKeyNames.SESSION_ID_KEY, str);
    }
}
