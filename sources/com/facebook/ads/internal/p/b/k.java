package com.facebook.ads.internal.p.b;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

class k {

    /* renamed from: a  reason: collision with root package name */
    private final n f20528a;

    /* renamed from: b  reason: collision with root package name */
    private final a f20529b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f20530c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Object f20531d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final AtomicInteger f20532e;

    /* renamed from: f  reason: collision with root package name */
    private volatile Thread f20533f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f20534g;

    /* renamed from: h  reason: collision with root package name */
    private volatile int f20535h = -1;

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            k.this.e();
        }
    }

    public k(n nVar, a aVar) {
        this.f20528a = (n) j.a(nVar);
        this.f20529b = (a) j.a(aVar);
        this.f20532e = new AtomicInteger();
    }

    private void b() {
        int i2 = this.f20532e.get();
        if (i2 >= 1) {
            this.f20532e.set(0);
            throw new l("Error reading source " + i2 + " times");
        }
    }

    private void b(long j2, long j3) {
        a(j2, j3);
        synchronized (this.f20530c) {
            this.f20530c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z2 = (this.f20533f == null || this.f20533f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f20534g && !this.f20529b.d() && !z2) {
            a aVar = new a();
            this.f20533f = new Thread(aVar, "Source reader for " + this.f20528a);
            this.f20533f.start();
        }
    }

    private void d() {
        synchronized (this.f20530c) {
            try {
                this.f20530c.wait(1000);
            } catch (InterruptedException e2) {
                throw new l("Waiting source data is interrupted!", e2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        r1 = r1 + r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r8 = this;
            r0 = -1
            r1 = 0
            com.facebook.ads.internal.p.b.a r2 = r8.f20529b     // Catch:{ all -> 0x0048 }
            int r1 = r2.a()     // Catch:{ all -> 0x0048 }
            com.facebook.ads.internal.p.b.n r2 = r8.f20528a     // Catch:{ all -> 0x0048 }
            r2.a((int) r1)     // Catch:{ all -> 0x0048 }
            com.facebook.ads.internal.p.b.n r2 = r8.f20528a     // Catch:{ all -> 0x0048 }
            int r2 = r2.a()     // Catch:{ all -> 0x0048 }
            r3 = 8192(0x2000, float:1.14794E-41)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0046 }
        L_0x0017:
            com.facebook.ads.internal.p.b.n r4 = r8.f20528a     // Catch:{ all -> 0x0046 }
            int r4 = r4.a((byte[]) r3)     // Catch:{ all -> 0x0046 }
            if (r4 == r0) goto L_0x0042
            java.lang.Object r5 = r8.f20531d     // Catch:{ all -> 0x0046 }
            monitor-enter(r5)     // Catch:{ all -> 0x0046 }
            boolean r6 = r8.g()     // Catch:{ all -> 0x003f }
            if (r6 == 0) goto L_0x0032
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            r8.h()
            long r0 = (long) r1
            long r2 = (long) r2
            r8.b(r0, r2)
            return
        L_0x0032:
            com.facebook.ads.internal.p.b.a r6 = r8.f20529b     // Catch:{ all -> 0x003f }
            r6.a(r3, r4)     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            int r1 = r1 + r4
            long r4 = (long) r1
            long r6 = (long) r2
            r8.b(r4, r6)     // Catch:{ all -> 0x0046 }
            goto L_0x0017
        L_0x003f:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            throw r0     // Catch:{ all -> 0x0046 }
        L_0x0042:
            r8.f()     // Catch:{ all -> 0x0046 }
            goto L_0x0053
        L_0x0046:
            r0 = move-exception
            goto L_0x004b
        L_0x0048:
            r2 = move-exception
            r0 = r2
            r2 = -1
        L_0x004b:
            java.util.concurrent.atomic.AtomicInteger r3 = r8.f20532e     // Catch:{ all -> 0x005c }
            r3.incrementAndGet()     // Catch:{ all -> 0x005c }
            r8.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x005c }
        L_0x0053:
            r8.h()
            long r0 = (long) r1
            long r2 = (long) r2
            r8.b(r0, r2)
            return
        L_0x005c:
            r0 = move-exception
            r8.h()
            long r3 = (long) r1
            long r1 = (long) r2
            r8.b(r3, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.b.k.e():void");
    }

    private void f() {
        synchronized (this.f20531d) {
            if (!g() && this.f20529b.a() == this.f20528a.a()) {
                this.f20529b.c();
            }
        }
    }

    private boolean g() {
        return Thread.currentThread().isInterrupted() || this.f20534g;
    }

    private void h() {
        try {
            this.f20528a.b();
        } catch (l e2) {
            a((Throwable) new l("Error closing source " + this.f20528a, e2));
        }
    }

    public int a(byte[] bArr, long j2, int i2) {
        m.a(bArr, j2, i2);
        while (!this.f20529b.d() && ((long) this.f20529b.a()) < ((long) i2) + j2 && !this.f20534g) {
            c();
            d();
            b();
        }
        int a2 = this.f20529b.a(bArr, j2, i2);
        if (this.f20529b.d() && this.f20535h != 100) {
            this.f20535h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.f20531d) {
            Log.d("ProxyCache", "Shutdown proxy for " + this.f20528a);
            try {
                this.f20534g = true;
                if (this.f20533f != null) {
                    this.f20533f.interrupt();
                }
                this.f20529b.b();
            } catch (l e2) {
                a((Throwable) e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
    }

    /* access modifiers changed from: protected */
    public void a(long j2, long j3) {
        boolean z2 = true;
        int i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        int i3 = i2 == 0 ? 100 : (int) ((j2 * 100) / j3);
        boolean z3 = i3 != this.f20535h;
        if (i2 < 0) {
            z2 = false;
        }
        if (z2 && z3) {
            a(i3);
        }
        this.f20535h = i3;
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th) {
        if (th instanceof i) {
            Log.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            Log.e("ProxyCache", "ProxyCache error", th);
        }
    }
}
