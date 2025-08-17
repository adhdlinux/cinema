package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.o;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class d implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a  reason: collision with root package name */
    private o f15245a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f15246b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f15247c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private boolean f15248d;

    /* renamed from: e  reason: collision with root package name */
    private final m f15249e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final WeakReference<a> f15250f;

    /* renamed from: g  reason: collision with root package name */
    private long f15251g;

    public interface a {
        void onAdRefresh();
    }

    public d(m mVar, a aVar) {
        this.f15250f = new WeakReference<>(aVar);
        this.f15249e = mVar;
    }

    private void i() {
        synchronized (this.f15246b) {
            o oVar = this.f15245a;
            if (oVar != null) {
                oVar.b();
            } else {
                if (v.a()) {
                    this.f15249e.A().b("AdRefreshManager", "An ad load is in progress. Will pause refresh once the ad finishes loading.");
                }
                this.f15247c.set(true);
            }
        }
    }

    private void j() {
        synchronized (this.f15246b) {
            o oVar = this.f15245a;
            if (oVar != null) {
                oVar.c();
            } else {
                this.f15247c.set(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        synchronized (this.f15246b) {
            this.f15245a = null;
            if (!((Boolean) this.f15249e.a(com.applovin.impl.sdk.c.a.f15197s)).booleanValue()) {
                this.f15249e.aj().unregisterReceiver(this);
            }
        }
    }

    private void l() {
        if (((Boolean) this.f15249e.a(com.applovin.impl.sdk.c.a.f15196r)).booleanValue()) {
            i();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m() {
        /*
            r4 = this;
            com.applovin.impl.sdk.m r0 = r4.f15249e
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.c.a.f15196r
            java.lang.Object r0 = r0.a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0059
            java.lang.Object r0 = r4.f15246b
            monitor-enter(r0)
            boolean r1 = r4.f15248d     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x002c
            boolean r1 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x002a
            com.applovin.impl.sdk.m r1 = r4.f15249e     // Catch:{ all -> 0x0056 }
            com.applovin.impl.sdk.v r1 = r1.A()     // Catch:{ all -> 0x0056 }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Fullscreen ad dismissed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh."
            r1.b(r2, r3)     // Catch:{ all -> 0x0056 }
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            return
        L_0x002c:
            com.applovin.impl.sdk.m r1 = r4.f15249e     // Catch:{ all -> 0x0056 }
            com.applovin.impl.sdk.y r1 = r1.ad()     // Catch:{ all -> 0x0056 }
            boolean r1 = r1.a()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x004d
            boolean r1 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x004b
            com.applovin.impl.sdk.m r1 = r4.f15249e     // Catch:{ all -> 0x0056 }
            com.applovin.impl.sdk.v r1 = r1.A()     // Catch:{ all -> 0x0056 }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Waiting for the application to enter foreground to resume the timer."
            r1.b(r2, r3)     // Catch:{ all -> 0x0056 }
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            return
        L_0x004d:
            com.applovin.impl.sdk.utils.o r1 = r4.f15245a     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0054
            r1.c()     // Catch:{ all -> 0x0056 }
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            goto L_0x0059
        L_0x0056:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            throw r1
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.d.m():void");
    }

    public void a(long j2) {
        synchronized (this.f15246b) {
            c();
            this.f15251g = j2;
            this.f15245a = o.a(j2, this.f15249e, new Runnable() {
                public void run() {
                    d.this.k();
                    a aVar = (a) d.this.f15250f.get();
                    if (aVar != null) {
                        aVar.onAdRefresh();
                    }
                }
            });
            if (!((Boolean) this.f15249e.a(com.applovin.impl.sdk.c.a.f15197s)).booleanValue()) {
                this.f15249e.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
                this.f15249e.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
                this.f15249e.aj().registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_displayed"));
                this.f15249e.aj().registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_hidden"));
            }
            if (((Boolean) this.f15249e.a(com.applovin.impl.sdk.c.a.f15196r)).booleanValue() && (this.f15249e.ae().b() || this.f15249e.ad().a())) {
                this.f15245a.b();
            }
            if (this.f15247c.compareAndSet(true, false) && ((Boolean) this.f15249e.a(com.applovin.impl.sdk.c.a.f15198t)).booleanValue()) {
                if (v.a()) {
                    this.f15249e.A().b("AdRefreshManager", "Pausing refresh for a previous request.");
                }
                this.f15245a.b();
            }
        }
    }

    public boolean a() {
        boolean z2;
        synchronized (this.f15246b) {
            z2 = this.f15245a != null;
        }
        return z2;
    }

    public long b() {
        long a2;
        synchronized (this.f15246b) {
            o oVar = this.f15245a;
            a2 = oVar != null ? oVar.a() : -1;
        }
        return a2;
    }

    public void c() {
        synchronized (this.f15246b) {
            o oVar = this.f15245a;
            if (oVar != null) {
                oVar.d();
                k();
            }
        }
    }

    public void d() {
        synchronized (this.f15246b) {
            i();
            this.f15248d = true;
        }
    }

    public void e() {
        synchronized (this.f15246b) {
            j();
            this.f15248d = false;
        }
    }

    public boolean f() {
        return this.f15248d;
    }

    public void g() {
        if (((Boolean) this.f15249e.a(com.applovin.impl.sdk.c.a.f15195q)).booleanValue()) {
            i();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        r0 = r9.f15250f.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        r0.onAdRefresh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h() {
        /*
            r9 = this;
            com.applovin.impl.sdk.m r0 = r9.f15249e
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.c.a.f15195q
            java.lang.Object r0 = r0.a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0090
            java.lang.Object r0 = r9.f15246b
            monitor-enter(r0)
            boolean r1 = r9.f15248d     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x002c
            boolean r1 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x002a
            com.applovin.impl.sdk.m r1 = r9.f15249e     // Catch:{ all -> 0x008d }
            com.applovin.impl.sdk.v r1 = r1.A()     // Catch:{ all -> 0x008d }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Application resumed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh."
            r1.b(r2, r3)     // Catch:{ all -> 0x008d }
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return
        L_0x002c:
            com.applovin.impl.sdk.m r1 = r9.f15249e     // Catch:{ all -> 0x008d }
            com.applovin.impl.sdk.s r1 = r1.ae()     // Catch:{ all -> 0x008d }
            boolean r1 = r1.b()     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x004d
            boolean r1 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x004b
            com.applovin.impl.sdk.m r1 = r9.f15249e     // Catch:{ all -> 0x008d }
            com.applovin.impl.sdk.v r1 = r1.A()     // Catch:{ all -> 0x008d }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Waiting for the full screen ad to be dismissed to resume the timer."
            r1.b(r2, r3)     // Catch:{ all -> 0x008d }
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return
        L_0x004d:
            com.applovin.impl.sdk.utils.o r1 = r9.f15245a     // Catch:{ all -> 0x008d }
            r2 = 0
            if (r1 == 0) goto L_0x007c
            long r3 = r9.f15251g     // Catch:{ all -> 0x008d }
            long r5 = r9.b()     // Catch:{ all -> 0x008d }
            long r3 = r3 - r5
            com.applovin.impl.sdk.m r1 = r9.f15249e     // Catch:{ all -> 0x008d }
            com.applovin.impl.sdk.c.b<java.lang.Long> r5 = com.applovin.impl.sdk.c.a.f15194p     // Catch:{ all -> 0x008d }
            java.lang.Object r1 = r1.a(r5)     // Catch:{ all -> 0x008d }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x008d }
            long r5 = r1.longValue()     // Catch:{ all -> 0x008d }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x0077
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0077
            r9.c()     // Catch:{ all -> 0x008d }
            r1 = 1
            r2 = 1
            goto L_0x007c
        L_0x0077:
            com.applovin.impl.sdk.utils.o r1 = r9.f15245a     // Catch:{ all -> 0x008d }
            r1.c()     // Catch:{ all -> 0x008d }
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0090
            java.lang.ref.WeakReference<com.applovin.impl.sdk.d$a> r0 = r9.f15250f
            java.lang.Object r0 = r0.get()
            com.applovin.impl.sdk.d$a r0 = (com.applovin.impl.sdk.d.a) r0
            if (r0 == 0) goto L_0x0090
            r0.onAdRefresh()
            goto L_0x0090
        L_0x008d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            throw r1
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.d.h():void");
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            g();
        } else if ("com.applovin.application_resumed".equals(action)) {
            h();
        } else if ("com.applovin.fullscreen_ad_displayed".equals(action)) {
            l();
        } else if ("com.applovin.fullscreen_ad_hidden".equals(action)) {
            m();
        }
    }
}
