package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import java.util.Timer;
import java.util.TimerTask;

public class o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f15904a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Timer f15905b;

    /* renamed from: c  reason: collision with root package name */
    private long f15906c;

    /* renamed from: d  reason: collision with root package name */
    private long f15907d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f15908e;

    /* renamed from: f  reason: collision with root package name */
    private long f15909f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Object f15910g = new Object();

    private o(m mVar, Runnable runnable) {
        this.f15904a = mVar;
        this.f15908e = runnable;
    }

    public static o a(long j2, m mVar, Runnable runnable) {
        if (j2 < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j2 + ".");
        } else if (runnable != null) {
            o oVar = new o(mVar, runnable);
            oVar.f15906c = System.currentTimeMillis();
            oVar.f15907d = j2;
            try {
                Timer timer = new Timer();
                oVar.f15905b = timer;
                timer.schedule(oVar.e(), j2);
            } catch (OutOfMemoryError e2) {
                if (v.a()) {
                    mVar.A().b("Timer", "Failed to create timer due to OOM error", e2);
                }
            }
            return oVar;
        } else {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
    }

    private TimerTask e() {
        return new TimerTask() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    r0 = 0
                    com.applovin.impl.sdk.utils.o r1 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x001b }
                    java.lang.Runnable r1 = r1.f15908e     // Catch:{ all -> 0x001b }
                    r1.run()     // Catch:{ all -> 0x001b }
                    com.applovin.impl.sdk.utils.o r1 = com.applovin.impl.sdk.utils.o.this
                    java.lang.Object r1 = r1.f15910g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.o r2 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x0018 }
                    java.util.Timer unused = r2.f15905b = r0     // Catch:{ all -> 0x0018 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    goto L_0x0048
                L_0x0018:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    throw r0
                L_0x001b:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.o r2 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x004c }
                    com.applovin.impl.sdk.m r2 = r2.f15904a     // Catch:{ all -> 0x004c }
                    if (r2 == 0) goto L_0x003b
                    boolean r2 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x004c }
                    if (r2 == 0) goto L_0x003b
                    com.applovin.impl.sdk.utils.o r2 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x004c }
                    com.applovin.impl.sdk.m r2 = r2.f15904a     // Catch:{ all -> 0x004c }
                    com.applovin.impl.sdk.v r2 = r2.A()     // Catch:{ all -> 0x004c }
                    java.lang.String r3 = "Timer"
                    java.lang.String r4 = "Encountered error while executing timed task"
                    r2.b(r3, r4, r1)     // Catch:{ all -> 0x004c }
                L_0x003b:
                    com.applovin.impl.sdk.utils.o r1 = com.applovin.impl.sdk.utils.o.this
                    java.lang.Object r1 = r1.f15910g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.o r2 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x0049 }
                    java.util.Timer unused = r2.f15905b = r0     // Catch:{ all -> 0x0049 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0049 }
                L_0x0048:
                    return
                L_0x0049:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0049 }
                    throw r0
                L_0x004c:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.o r2 = com.applovin.impl.sdk.utils.o.this
                    java.lang.Object r2 = r2.f15910g
                    monitor-enter(r2)
                    com.applovin.impl.sdk.utils.o r3 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x005b }
                    java.util.Timer unused = r3.f15905b = r0     // Catch:{ all -> 0x005b }
                    monitor-exit(r2)     // Catch:{ all -> 0x005b }
                    throw r1
                L_0x005b:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x005b }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.o.AnonymousClass1.run():void");
            }
        };
    }

    public long a() {
        if (this.f15905b == null) {
            return this.f15907d - this.f15909f;
        }
        return this.f15907d - (System.currentTimeMillis() - this.f15906c);
    }

    public void b() {
        synchronized (this.f15910g) {
            Timer timer = this.f15905b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f15909f = Math.max(1, System.currentTimeMillis() - this.f15906c);
                } catch (Throwable th) {
                    this.f15905b = null;
                    throw th;
                }
                this.f15905b = null;
            }
        }
    }

    public void c() {
        synchronized (this.f15910g) {
            long j2 = this.f15909f;
            if (j2 > 0) {
                try {
                    long j3 = this.f15907d - j2;
                    this.f15907d = j3;
                    if (j3 < 0) {
                        this.f15907d = 0;
                    }
                    Timer timer = new Timer();
                    this.f15905b = timer;
                    timer.schedule(e(), this.f15907d);
                    this.f15906c = System.currentTimeMillis();
                } catch (Throwable th) {
                    this.f15909f = 0;
                    throw th;
                }
                this.f15909f = 0;
            }
        }
    }

    public void d() {
        synchronized (this.f15910g) {
            Timer timer = this.f15905b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f15905b = null;
                } catch (Throwable th) {
                    this.f15905b = null;
                    this.f15909f = 0;
                    throw th;
                }
                this.f15909f = 0;
            }
        }
    }
}
