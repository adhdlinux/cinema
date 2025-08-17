package kotlinx.coroutines;

import androidx.concurrent.futures.a;
import com.facebook.common.time.Clock;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40640f;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40641g;

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40642h;
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    private final class DelayedResumeTask extends DelayedTask {

        /* renamed from: d  reason: collision with root package name */
        private final CancellableContinuation<Unit> f40643d;

        public DelayedResumeTask(long j2, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j2);
            this.f40643d = cancellableContinuation;
        }

        public void run() {
            this.f40643d.g(EventLoopImplBase.this, Unit.f40298a);
        }

        public String toString() {
            return super.toString() + this.f40643d;
        }
    }

    private static final class DelayedRunnableTask extends DelayedTask {

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f40645d;

        public DelayedRunnableTask(long j2, Runnable runnable) {
            super(j2);
            this.f40645d = runnable;
        }

        public void run() {
            this.f40645d.run();
        }

        public String toString() {
            return super.toString() + this.f40645d;
        }
    }

    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private volatile Object _heap;

        /* renamed from: b  reason: collision with root package name */
        public long f40646b;

        /* renamed from: c  reason: collision with root package name */
        private int f40647c = -1;

        public DelayedTask(long j2) {
            this.f40646b = j2;
        }

        public void a(ThreadSafeHeap<?> threadSafeHeap) {
            boolean z2;
            if (this._heap != EventLoop_commonKt.f40649a) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public ThreadSafeHeap<?> c() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        /* renamed from: d */
        public int compareTo(DelayedTask delayedTask) {
            int i2 = ((this.f40646b - delayedTask.f40646b) > 0 ? 1 : ((this.f40646b - delayedTask.f40646b) == 0 ? 0 : -1));
            if (i2 > 0) {
                return 1;
            }
            return i2 < 0 ? -1 : 0;
        }

        public final void dispose() {
            DelayedTaskQueue delayedTaskQueue;
            synchronized (this) {
                Object obj = this._heap;
                if (obj != EventLoop_commonKt.f40649a) {
                    if (obj instanceof DelayedTaskQueue) {
                        delayedTaskQueue = (DelayedTaskQueue) obj;
                    } else {
                        delayedTaskQueue = null;
                    }
                    if (delayedTaskQueue != null) {
                        delayedTaskQueue.g(this);
                    }
                    this._heap = EventLoop_commonKt.f40649a;
                    Unit unit = Unit.f40298a;
                }
            }
        }

        public final int e(long j2, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            synchronized (this) {
                if (this._heap == EventLoop_commonKt.f40649a) {
                    return 2;
                }
                synchronized (delayedTaskQueue) {
                    DelayedTask delayedTask = (DelayedTask) delayedTaskQueue.b();
                    if (eventLoopImplBase.L0()) {
                        return 1;
                    }
                    if (delayedTask == null) {
                        delayedTaskQueue.f40648c = j2;
                    } else {
                        long j3 = delayedTask.f40646b;
                        if (j3 - j2 < 0) {
                            j2 = j3;
                        }
                        if (j2 - delayedTaskQueue.f40648c > 0) {
                            delayedTaskQueue.f40648c = j2;
                        }
                    }
                    long j4 = this.f40646b;
                    long j5 = delayedTaskQueue.f40648c;
                    if (j4 - j5 < 0) {
                        this.f40646b = j5;
                    }
                    delayedTaskQueue.a(this);
                    return 0;
                }
            }
        }

        public final boolean f(long j2) {
            return j2 - this.f40646b >= 0;
        }

        public int getIndex() {
            return this.f40647c;
        }

        public void setIndex(int i2) {
            this.f40647c = i2;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f40646b + ']';
        }
    }

    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {

        /* renamed from: c  reason: collision with root package name */
        public long f40648c;

        public DelayedTaskQueue(long j2) {
            this.f40648c = j2;
        }
    }

    static {
        Class<EventLoopImplBase> cls = EventLoopImplBase.class;
        Class<Object> cls2 = Object.class;
        f40640f = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_queue");
        f40641g = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_delayed");
        f40642h = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleted");
    }

    private final void H0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40640f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (a.a(f40640f, this, (Object) null, EventLoop_commonKt.f40650b)) {
                    return;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore) obj).d();
                return;
            } else if (obj != EventLoop_commonKt.f40650b) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                Intrinsics.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                lockFreeTaskQueueCore.a((Runnable) obj);
                if (a.a(f40640f, this, obj, lockFreeTaskQueueCore)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final Runnable I0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40640f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof LockFreeTaskQueueCore) {
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object j2 = lockFreeTaskQueueCore.j();
                if (j2 != LockFreeTaskQueueCore.f40755h) {
                    return (Runnable) j2;
                }
                a.a(f40640f, this, obj, lockFreeTaskQueueCore.i());
            } else if (obj == EventLoop_commonKt.f40650b) {
                return null;
            } else {
                if (a.a(f40640f, this, obj, (Object) null)) {
                    Intrinsics.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean K0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40640f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (L0()) {
                return false;
            }
            if (obj == null) {
                if (a.a(f40640f, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                int a2 = lockFreeTaskQueueCore.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    a.a(f40640f, this, obj, lockFreeTaskQueueCore.i());
                } else if (a2 == 2) {
                    return false;
                }
            } else if (obj == EventLoop_commonKt.f40650b) {
                return false;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                Intrinsics.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                lockFreeTaskQueueCore2.a((Runnable) obj);
                lockFreeTaskQueueCore2.a(runnable);
                if (a.a(f40640f, this, obj, lockFreeTaskQueueCore2)) {
                    return true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean L0() {
        if (f40642h.get(this) != 0) {
            return true;
        }
        return false;
    }

    private final void N0() {
        long j2;
        DelayedTask delayedTask;
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        if (a2 != null) {
            j2 = a2.a();
        } else {
            j2 = System.nanoTime();
        }
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f40641g.get(this);
            if (delayedTaskQueue != null && (delayedTask = (DelayedTask) delayedTaskQueue.i()) != null) {
                E0(j2, delayedTask);
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int Q0(long r4, kotlinx.coroutines.EventLoopImplBase.DelayedTask r6) {
        /*
            r3 = this;
            boolean r0 = r3.L0()
            if (r0 == 0) goto L_0x0008
            r4 = 1
            return r4
        L_0x0008:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f40641g
            java.lang.Object r1 = r0.get(r3)
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r1 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r1
            if (r1 != 0) goto L_0x0025
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r1 = new kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue
            r1.<init>(r4)
            r2 = 0
            androidx.concurrent.futures.a.a(r0, r3, r2, r1)
            java.lang.Object r0 = r0.get(r3)
            kotlin.jvm.internal.Intrinsics.c(r0)
            r1 = r0
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r1 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r1
        L_0x0025:
            int r4 = r6.e(r4, r1, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.Q0(long, kotlinx.coroutines.EventLoopImplBase$DelayedTask):int");
    }

    private final void S0(boolean z2) {
        f40642h.set(this, z2 ? 1 : 0);
    }

    private final boolean T0(DelayedTask delayedTask) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f40641g.get(this);
        return (delayedTaskQueue != null ? (DelayedTask) delayedTaskQueue.e() : null) == delayedTask;
    }

    public DisposableHandle A(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.a(this, j2, runnable, coroutineContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long A0() {
        /*
            r9 = this;
            boolean r0 = r9.B0()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f40641g
            java.lang.Object r0 = r0.get(r9)
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 == 0) goto L_0x0051
            boolean r3 = r0.d()
            if (r3 != 0) goto L_0x0051
            kotlinx.coroutines.AbstractTimeSource r3 = kotlinx.coroutines.AbstractTimeSourceKt.a()
            if (r3 == 0) goto L_0x0024
            long r3 = r3.a()
            goto L_0x0028
        L_0x0024:
            long r3 = java.lang.System.nanoTime()
        L_0x0028:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.b()     // Catch:{ all -> 0x004e }
            r6 = 0
            if (r5 != 0) goto L_0x0032
            monitor-exit(r0)
            goto L_0x0049
        L_0x0032:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r5 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r5     // Catch:{ all -> 0x004e }
            boolean r7 = r5.f(r3)     // Catch:{ all -> 0x004e }
            r8 = 0
            if (r7 == 0) goto L_0x0040
            boolean r5 = r9.K0(r5)     // Catch:{ all -> 0x004e }
            goto L_0x0041
        L_0x0040:
            r5 = 0
        L_0x0041:
            if (r5 == 0) goto L_0x0048
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.h(r8)     // Catch:{ all -> 0x004e }
            r6 = r5
        L_0x0048:
            monitor-exit(r0)
        L_0x0049:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r6 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r6
            if (r6 != 0) goto L_0x0028
            goto L_0x0051
        L_0x004e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0051:
            java.lang.Runnable r0 = r9.I0()
            if (r0 == 0) goto L_0x005b
            r0.run()
            return r1
        L_0x005b:
            long r0 = r9.v0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.A0():long");
    }

    public void J0(Runnable runnable) {
        if (K0(runnable)) {
            F0();
        } else {
            DefaultExecutor.f40623i.J0(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean M0() {
        if (!z0()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f40641g.get(this);
        if (delayedTaskQueue != null && !delayedTaskQueue.d()) {
            return false;
        }
        Object obj = f40640f.get(this);
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                return ((LockFreeTaskQueueCore) obj).g();
            }
            if (obj == EventLoop_commonKt.f40650b) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void O0() {
        f40640f.set(this, (Object) null);
        f40641g.set(this, (Object) null);
    }

    public final void P0(long j2, DelayedTask delayedTask) {
        int Q0 = Q0(j2, delayedTask);
        if (Q0 != 0) {
            if (Q0 == 1) {
                E0(j2, delayedTask);
            } else if (Q0 != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (T0(delayedTask)) {
            F0();
        }
    }

    /* access modifiers changed from: protected */
    public final DisposableHandle R0(long j2, Runnable runnable) {
        long j3;
        long c2 = EventLoop_commonKt.c(j2);
        if (c2 >= 4611686018427387903L) {
            return NonDisposableHandle.f40684b;
        }
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        if (a2 != null) {
            j3 = a2.a();
        } else {
            j3 = System.nanoTime();
        }
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(c2 + j3, runnable);
        P0(j3, delayedRunnableTask);
        return delayedRunnableTask;
    }

    public void k(long j2, CancellableContinuation<? super Unit> cancellableContinuation) {
        long j3;
        long c2 = EventLoop_commonKt.c(j2);
        if (c2 < 4611686018427387903L) {
            AbstractTimeSource a2 = AbstractTimeSourceKt.a();
            if (a2 != null) {
                j3 = a2.a();
            } else {
                j3 = System.nanoTime();
            }
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(c2 + j3, cancellableContinuation);
            P0(j3, delayedResumeTask);
            CancellableContinuationKt.a(cancellableContinuation, delayedResumeTask);
        }
    }

    public final void o0(CoroutineContext coroutineContext, Runnable runnable) {
        J0(runnable);
    }

    public void shutdown() {
        ThreadLocalEventLoop.f40685a.c();
        S0(true);
        H0();
        do {
        } while (A0() <= 0);
        N0();
    }

    /* access modifiers changed from: protected */
    public long v0() {
        DelayedTask delayedTask;
        long j2;
        if (super.v0() == 0) {
            return 0;
        }
        Object obj = f40640f.get(this);
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                if (!((LockFreeTaskQueueCore) obj).g()) {
                    return 0;
                }
            } else if (obj == EventLoop_commonKt.f40650b) {
                return Clock.MAX_TIME;
            } else {
                return 0;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f40641g.get(this);
        if (delayedTaskQueue == null || (delayedTask = (DelayedTask) delayedTaskQueue.e()) == null) {
            return Clock.MAX_TIME;
        }
        long j3 = delayedTask.f40646b;
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        if (a2 != null) {
            j2 = a2.a();
        } else {
            j2 = System.nanoTime();
        }
        return RangesKt___RangesKt.c(j3 - j2, 0);
    }
}
