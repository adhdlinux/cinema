package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {

    /* renamed from: c  reason: collision with root package name */
    static final Object f40009c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final Object f40010d = new Object();

    /* renamed from: e  reason: collision with root package name */
    static final Object f40011e = new Object();

    /* renamed from: f  reason: collision with root package name */
    static final Object f40012f = new Object();

    /* renamed from: b  reason: collision with root package name */
    final Runnable f40013b;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.f40013b = runnable;
        lazySet(0, disposableContainer);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != f40012f) {
                if (obj == f40010d) {
                    future.cancel(false);
                    return;
                } else if (obj == f40011e) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    public Object call() {
        run();
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r7 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r7.get(r0)
            java.lang.Object r2 = f40012f
            r3 = 0
            if (r1 == r2) goto L_0x0031
            java.lang.Object r2 = f40010d
            if (r1 == r2) goto L_0x0031
            java.lang.Object r4 = f40011e
            if (r1 != r4) goto L_0x0013
            goto L_0x0031
        L_0x0013:
            r5 = 2
            java.lang.Object r5 = r7.get(r5)
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            if (r5 == r6) goto L_0x0020
            r5 = 1
            goto L_0x0021
        L_0x0020:
            r5 = 0
        L_0x0021:
            if (r5 == 0) goto L_0x0024
            r2 = r4
        L_0x0024:
            boolean r0 = r7.compareAndSet(r0, r1, r2)
            if (r0 == 0) goto L_0x0000
            if (r1 == 0) goto L_0x0031
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1
            r1.cancel(r5)
        L_0x0031:
            java.lang.Object r0 = r7.get(r3)
            java.lang.Object r1 = f40012f
            if (r0 == r1) goto L_0x004b
            java.lang.Object r1 = f40009c
            if (r0 == r1) goto L_0x004b
            if (r0 != 0) goto L_0x0040
            goto L_0x004b
        L_0x0040:
            boolean r1 = r7.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0031
            io.reactivex.internal.disposables.DisposableContainer r0 = (io.reactivex.internal.disposables.DisposableContainer) r0
            r0.c(r7)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ScheduledRunnable.dispose():void");
    }

    public boolean isDisposed() {
        Object obj = get(0);
        if (obj == f40009c || obj == f40012f) {
            return true;
        }
        return false;
    }

    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.f40013b.run();
        } catch (Throwable th) {
            lazySet(2, (Object) null);
            Object obj3 = get(0);
            if (!(obj3 == f40009c || !compareAndSet(0, obj3, f40012f) || obj3 == null)) {
                ((DisposableContainer) obj3).c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == f40010d || obj2 == f40011e || compareAndSet(1, obj2, f40012f)) {
                    throw th;
                }
                obj2 = get(1);
                break;
            } while (compareAndSet(1, obj2, f40012f));
            throw th;
        }
        lazySet(2, (Object) null);
        Object obj4 = get(0);
        if (!(obj4 == f40009c || !compareAndSet(0, obj4, f40012f) || obj4 == null)) {
            ((DisposableContainer) obj4).c(this);
        }
        do {
            obj = get(1);
            if (obj == f40010d || obj == f40011e || compareAndSet(1, obj, f40012f)) {
            }
            obj = get(1);
            return;
        } while (compareAndSet(1, obj, f40012f));
    }
}
