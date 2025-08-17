package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.e;
import com.applovin.impl.sdk.v;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private final String f15379a = "TaskManager";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final m f15380b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final v f15381c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f15382d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f15383e;

    /* renamed from: f  reason: collision with root package name */
    private final List<c> f15384f = new ArrayList(5);

    /* renamed from: g  reason: collision with root package name */
    private final Object f15385g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private boolean f15386h;

    public enum a {
        MAIN,
        TIMEOUT,
        BACKGROUND,
        ADVERTISING_INFO_COLLECTION,
        POSTBACKS,
        CACHING_INTERSTITIAL,
        CACHING_INCENTIVIZED,
        CACHING_OTHER,
        REWARD,
        MEDIATION_MAIN,
        MEDIATION_TIMEOUT,
        MEDIATION_BACKGROUND,
        MEDIATION_POSTBACKS,
        MEDIATION_BANNER,
        MEDIATION_INTERSTITIAL,
        MEDIATION_INCENTIVIZED,
        MEDIATION_REWARDED_INTERSTITIAL,
        MEDIATION_REWARD
    }

    private class b implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        private final String f15409b;

        b(String str) {
            this.f15409b = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f15409b + ":" + Utils.shortenKey(o.this.f15380b.z()));
            thread.setDaemon(true);
            thread.setPriority(10);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    if (v.a()) {
                        o.this.f15381c.b("TaskManager", "Caught unhandled exception", th);
                    }
                }
            });
            return thread;
        }
    }

    private static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final m f15411a;

        /* renamed from: b  reason: collision with root package name */
        private final String f15412b;

        /* renamed from: c  reason: collision with root package name */
        private final v f15413c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final a f15414d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final a f15415e;

        c(m mVar, a aVar, a aVar2) {
            this.f15411a = mVar;
            this.f15413c = mVar.A();
            this.f15412b = aVar.e();
            this.f15414d = aVar;
            this.f15415e = aVar2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                java.lang.String r0 = " queue finished task "
                com.applovin.impl.sdk.utils.g.a()     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.m r1 = r6.f15411a     // Catch:{ all -> 0x004a }
                boolean r1 = r1.c()     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0035
                com.applovin.impl.sdk.e.a r1 = r6.f15414d     // Catch:{ all -> 0x004a }
                boolean r1 = r1.g()     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0016
                goto L_0x0035
            L_0x0016:
                boolean r1 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0025
                com.applovin.impl.sdk.v r1 = r6.f15413c     // Catch:{ all -> 0x004a }
                java.lang.String r2 = r6.f15412b     // Catch:{ all -> 0x004a }
                java.lang.String r3 = "Task re-scheduled..."
                r1.c(r2, r3)     // Catch:{ all -> 0x004a }
            L_0x0025:
                com.applovin.impl.sdk.m r1 = r6.f15411a     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.e.o r1 = r1.S()     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.e.a r2 = r6.f15414d     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.e.o$a r3 = r6.f15415e     // Catch:{ all -> 0x004a }
                r4 = 2000(0x7d0, double:9.88E-321)
                r1.a((com.applovin.impl.sdk.e.a) r2, (com.applovin.impl.sdk.e.o.a) r3, (long) r4)     // Catch:{ all -> 0x004a }
                goto L_0x003a
            L_0x0035:
                com.applovin.impl.sdk.e.a r1 = r6.f15414d     // Catch:{ all -> 0x004a }
                r1.run()     // Catch:{ all -> 0x004a }
            L_0x003a:
                boolean r1 = com.applovin.impl.sdk.v.a()
                if (r1 == 0) goto L_0x0081
                com.applovin.impl.sdk.v r1 = r6.f15413c
                java.lang.String r2 = r6.f15412b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                goto L_0x0069
            L_0x004a:
                r1 = move-exception
                boolean r2 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0082 }
                if (r2 == 0) goto L_0x005a
                com.applovin.impl.sdk.v r2 = r6.f15413c     // Catch:{ all -> 0x0082 }
                java.lang.String r3 = r6.f15412b     // Catch:{ all -> 0x0082 }
                java.lang.String r4 = "Task failed execution"
                r2.b(r3, r4, r1)     // Catch:{ all -> 0x0082 }
            L_0x005a:
                boolean r1 = com.applovin.impl.sdk.v.a()
                if (r1 == 0) goto L_0x0081
                com.applovin.impl.sdk.v r1 = r6.f15413c
                java.lang.String r2 = r6.f15412b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
            L_0x0069:
                com.applovin.impl.sdk.e.o$a r4 = r6.f15415e
                r3.append(r4)
                r3.append(r0)
                com.applovin.impl.sdk.e.a r0 = r6.f15414d
                java.lang.String r0 = r0.e()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r1.c(r2, r0)
            L_0x0081:
                return
            L_0x0082:
                r1 = move-exception
                boolean r2 = com.applovin.impl.sdk.v.a()
                if (r2 == 0) goto L_0x00aa
                com.applovin.impl.sdk.v r2 = r6.f15413c
                java.lang.String r3 = r6.f15412b
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                com.applovin.impl.sdk.e.o$a r5 = r6.f15415e
                r4.append(r5)
                r4.append(r0)
                com.applovin.impl.sdk.e.a r0 = r6.f15414d
                java.lang.String r0 = r0.e()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r2.c(r3, r0)
            L_0x00aa:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.e.o.c.run():void");
        }
    }

    public o(m mVar) {
        this.f15380b = mVar;
        this.f15381c = mVar.A();
        this.f15382d = a("auxiliary_operations", ((Integer) mVar.a(com.applovin.impl.sdk.c.b.cd)).intValue());
        this.f15383e = a("shared_thread_pool", ((Integer) mVar.a(com.applovin.impl.sdk.c.b.am)).intValue());
    }

    private ScheduledThreadPoolExecutor a(String str, int i2) {
        return new ScheduledThreadPoolExecutor(i2, new b(str));
    }

    private void a(final Runnable runnable, long j2, boolean z2) {
        if (j2 <= 0) {
            this.f15383e.submit(runnable);
        } else if (z2) {
            e.a(j2, this.f15380b, new Runnable() {
                public void run() {
                    o.this.f15383e.execute(runnable);
                }
            });
        } else {
            this.f15383e.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    private boolean a(c cVar) {
        if (cVar.f15414d.g()) {
            return false;
        }
        synchronized (this.f15385g) {
            if (this.f15386h) {
                return false;
            }
            this.f15384f.add(cVar);
            return true;
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Throwable th) {
                if (v.a()) {
                    this.f15381c.b(aVar.e(), "Task failed execution", th);
                }
            }
        } else if (v.a()) {
            this.f15381c.e("TaskManager", "Attempted to execute null task immediately");
        }
    }

    public void a(a aVar, a aVar2) {
        a(aVar, aVar2, 0);
    }

    public void a(a aVar, a aVar2, long j2) {
        a(aVar, aVar2, j2, false);
    }

    public void a(a aVar, a aVar2, long j2, boolean z2) {
        if (aVar == null) {
            throw new IllegalArgumentException("No task specified");
        } else if (j2 < 0) {
            throw new IllegalArgumentException("Invalid delay (millis) specified: " + j2);
        } else if (!a(new c(this.f15380b, aVar, aVar2))) {
            a((Runnable) aVar, j2, z2);
        } else if (v.a()) {
            this.f15381c.c(aVar.e(), "Task execution delayed until after init");
        }
    }

    public void a(Runnable runnable) {
        this.f15382d.submit(runnable);
    }

    public boolean a() {
        return this.f15386h;
    }

    public Executor b() {
        return this.f15383e;
    }

    public void c() {
        synchronized (this.f15385g) {
            this.f15386h = false;
        }
    }

    public void d() {
        synchronized (this.f15385g) {
            this.f15386h = true;
            for (c next : this.f15384f) {
                a(next.f15414d, next.f15415e);
            }
            this.f15384f.clear();
        }
    }
}
