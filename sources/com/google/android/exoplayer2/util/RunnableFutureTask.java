package com.google.android.exoplayer2.util;

import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class RunnableFutureTask<R, E extends Exception> implements RunnableFuture<R> {

    /* renamed from: b  reason: collision with root package name */
    private final ConditionVariable f28774b = new ConditionVariable();

    /* renamed from: c  reason: collision with root package name */
    private final ConditionVariable f28775c = new ConditionVariable();

    /* renamed from: d  reason: collision with root package name */
    private final Object f28776d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private Exception f28777e;

    /* renamed from: f  reason: collision with root package name */
    private R f28778f;

    /* renamed from: g  reason: collision with root package name */
    private Thread f28779g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f28780h;

    protected RunnableFutureTask() {
    }

    private R e() throws ExecutionException {
        if (this.f28780h) {
            throw new CancellationException();
        } else if (this.f28777e == null) {
            return this.f28778f;
        } else {
            throw new ExecutionException(this.f28777e);
        }
    }

    public final void a() {
        this.f28775c.c();
    }

    public final void b() {
        this.f28774b.c();
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f28776d
            monitor-enter(r0)
            boolean r1 = r3.f28780h     // Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x002c
            com.google.android.exoplayer2.util.ConditionVariable r1 = r3.f28775c     // Catch:{ all -> 0x002f }
            boolean r1 = r1.e()     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0010
            goto L_0x002c
        L_0x0010:
            r1 = 1
            r3.f28780h = r1     // Catch:{ all -> 0x002f }
            r3.c()     // Catch:{ all -> 0x002f }
            java.lang.Thread r2 = r3.f28779g     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x0020
            if (r4 == 0) goto L_0x002a
            r2.interrupt()     // Catch:{ all -> 0x002f }
            goto L_0x002a
        L_0x0020:
            com.google.android.exoplayer2.util.ConditionVariable r4 = r3.f28774b     // Catch:{ all -> 0x002f }
            r4.f()     // Catch:{ all -> 0x002f }
            com.google.android.exoplayer2.util.ConditionVariable r4 = r3.f28775c     // Catch:{ all -> 0x002f }
            r4.f()     // Catch:{ all -> 0x002f }
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r1
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            r4 = 0
            return r4
        L_0x002f:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.RunnableFutureTask.cancel(boolean):boolean");
    }

    /* access modifiers changed from: protected */
    public abstract R d() throws Exception;

    public final R get() throws ExecutionException, InterruptedException {
        this.f28775c.a();
        return e();
    }

    public final boolean isCancelled() {
        return this.f28780h;
    }

    public final boolean isDone() {
        return this.f28775c.e();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f28776d
            monitor-enter(r0)
            boolean r1 = r4.f28780h     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            return
        L_0x0009:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0057 }
            r4.f28779g = r1     // Catch:{ all -> 0x0057 }
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            com.google.android.exoplayer2.util.ConditionVariable r0 = r4.f28774b
            r0.f()
            r0 = 0
            java.lang.Object r1 = r4.d()     // Catch:{ Exception -> 0x0030 }
            r4.f28778f = r1     // Catch:{ Exception -> 0x0030 }
            java.lang.Object r1 = r4.f28776d
            monitor-enter(r1)
            com.google.android.exoplayer2.util.ConditionVariable r2 = r4.f28775c     // Catch:{ all -> 0x002b }
            r2.f()     // Catch:{ all -> 0x002b }
            r4.f28779g = r0     // Catch:{ all -> 0x002b }
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x002b }
            monitor-exit(r1)     // Catch:{ all -> 0x002b }
            goto L_0x0041
        L_0x002b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002b }
            throw r0
        L_0x002e:
            r1 = move-exception
            goto L_0x0045
        L_0x0030:
            r1 = move-exception
            r4.f28777e = r1     // Catch:{ all -> 0x002e }
            java.lang.Object r1 = r4.f28776d
            monitor-enter(r1)
            com.google.android.exoplayer2.util.ConditionVariable r2 = r4.f28775c     // Catch:{ all -> 0x0042 }
            r2.f()     // Catch:{ all -> 0x0042 }
            r4.f28779g = r0     // Catch:{ all -> 0x0042 }
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0042 }
            monitor-exit(r1)     // Catch:{ all -> 0x0042 }
        L_0x0041:
            return
        L_0x0042:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0042 }
            throw r0
        L_0x0045:
            java.lang.Object r2 = r4.f28776d
            monitor-enter(r2)
            com.google.android.exoplayer2.util.ConditionVariable r3 = r4.f28775c     // Catch:{ all -> 0x0054 }
            r3.f()     // Catch:{ all -> 0x0054 }
            r4.f28779g = r0     // Catch:{ all -> 0x0054 }
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0054 }
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r1
        L_0x0054:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r0
        L_0x0057:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.RunnableFutureTask.run():void");
    }

    public final R get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f28775c.b(TimeUnit.MILLISECONDS.convert(j2, timeUnit))) {
            return e();
        }
        throw new TimeoutException();
    }
}
