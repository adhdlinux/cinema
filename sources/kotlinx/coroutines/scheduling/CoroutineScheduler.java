package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.common.time.Clock;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.random.Random;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;

public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f40786i = new Companion((DefaultConstructorMarker) null);

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f40787j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f40788k;

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40789l;

    /* renamed from: m  reason: collision with root package name */
    public static final Symbol f40790m = new Symbol("NOT_IN_STACK");
    private volatile int _isTerminated;

    /* renamed from: b  reason: collision with root package name */
    public final int f40791b;

    /* renamed from: c  reason: collision with root package name */
    public final int f40792c;
    private volatile long controlState;

    /* renamed from: d  reason: collision with root package name */
    public final long f40793d;

    /* renamed from: e  reason: collision with root package name */
    public final String f40794e;

    /* renamed from: f  reason: collision with root package name */
    public final GlobalQueue f40795f;

    /* renamed from: g  reason: collision with root package name */
    public final GlobalQueue f40796g;

    /* renamed from: h  reason: collision with root package name */
    public final ResizableAtomicArray<Worker> f40797h;
    private volatile long parkedWorkersStack;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40798a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[] r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.PARKING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.BLOCKING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.DORMANT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f40798a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.WhenMappings.<clinit>():void");
        }
    }

    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    static {
        Class<CoroutineScheduler> cls = CoroutineScheduler.class;
        f40787j = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack");
        f40788k = AtomicLongFieldUpdater.newUpdater(cls, "controlState");
        f40789l = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated");
    }

    public CoroutineScheduler(int i2, int i3, long j2, String str) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.f40791b = i2;
        this.f40792c = i3;
        this.f40793d = j2;
        this.f40794e = str;
        boolean z5 = true;
        if (i2 >= 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (i3 >= i2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (i3 <= 2097150) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    if (j2 <= 0 ? false : z5) {
                        this.f40795f = new GlobalQueue();
                        this.f40796g = new GlobalQueue();
                        this.f40797h = new ResizableAtomicArray<>((i2 + 1) * 2);
                        this.controlState = ((long) i2) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
    }

    private final Worker A() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f40787j;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            Worker b2 = this.f40797h.b((int) (2097151 & j2));
            if (b2 == null) {
                return null;
            }
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & -2097152;
            int z2 = z(b2);
            if (z2 >= 0) {
                if (f40787j.compareAndSet(this, j2, ((long) z2) | j3)) {
                    b2.r(f40790m);
                    return b2;
                }
            }
        }
    }

    private final void L(long j2, boolean z2) {
        if (!z2 && !q0() && !o0(j2)) {
            q0();
        }
    }

    private final boolean f(Task task) {
        boolean z2 = true;
        if (task.f40824c.b() != 1) {
            z2 = false;
        }
        if (z2) {
            return this.f40796g.a(task);
        }
        return this.f40795f.a(task);
    }

    private final int i() {
        boolean z2;
        synchronized (this.f40797h) {
            if (isTerminated()) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = f40788k;
            long j2 = atomicLongFieldUpdater.get(this);
            int i2 = (int) (j2 & 2097151);
            boolean z3 = false;
            int b2 = RangesKt___RangesKt.b(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (b2 >= this.f40791b) {
                return 0;
            }
            if (i2 >= this.f40792c) {
                return 0;
            }
            int i3 = ((int) (f40788k.get(this) & 2097151)) + 1;
            if (i3 <= 0 || this.f40797h.b(i3) != null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                Worker worker = new Worker(this, i3);
                this.f40797h.c(i3, worker);
                if (i3 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    z3 = true;
                }
                if (z3) {
                    int i4 = b2 + 1;
                    worker.start();
                    return i4;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final Task m0(Worker worker, Task task, boolean z2) {
        if (worker == null || worker.f40802d == WorkerState.TERMINATED) {
            return task;
        }
        if (task.f40824c.b() == 0 && worker.f40802d == WorkerState.BLOCKING) {
            return task;
        }
        worker.f40806h = true;
        return worker.f40800b.a(task, z2);
    }

    private final boolean o0(long j2) {
        if (RangesKt___RangesKt.b(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.f40791b) {
            int i2 = i();
            if (i2 == 1 && this.f40791b > 1) {
                i();
            }
            if (i2 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean p0(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = f40788k.get(coroutineScheduler);
        }
        return coroutineScheduler.o0(j2);
    }

    private final Worker q() {
        Worker worker;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof Worker) {
            worker = (Worker) currentThread;
        } else {
            worker = null;
        }
        if (worker == null || !Intrinsics.a(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    private final boolean q0() {
        Worker A;
        do {
            A = A();
            if (A == null) {
                return false;
            }
        } while (!Worker.j().compareAndSet(A, -1, 0));
        LockSupport.unpark(A);
        return true;
    }

    public static /* synthetic */ void v(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            taskContext = TasksKt.f40833g;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        coroutineScheduler.s(runnable, taskContext, z2);
    }

    private final int z(Worker worker) {
        Object i2 = worker.i();
        while (i2 != f40790m) {
            if (i2 == null) {
                return 0;
            }
            Worker worker2 = (Worker) i2;
            int h2 = worker2.h();
            if (h2 != 0) {
                return h2;
            }
            i2 = worker2.i();
        }
        return -1;
    }

    public final boolean B(Worker worker) {
        long j2;
        int h2;
        if (worker.i() != f40790m) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f40787j;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            h2 = worker.h();
            worker.r(this.f40797h.b((int) (2097151 & j2)));
        } while (!f40787j.compareAndSet(this, j2, ((PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & -2097152) | ((long) h2)));
        return true;
    }

    public final void D(Worker worker, int i2, int i3) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f40787j;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            int i4 = (int) (2097151 & j2);
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & -2097152;
            if (i4 == i2) {
                if (i3 == 0) {
                    i4 = z(worker);
                } else {
                    i4 = i3;
                }
            }
            if (i4 >= 0) {
                if (f40787j.compareAndSet(this, j2, j3 | ((long) i4))) {
                    return;
                }
            }
        }
    }

    public final void E(Task task) {
        AbstractTimeSource a2;
        try {
            task.run();
            a2 = AbstractTimeSourceKt.a();
            if (a2 == null) {
                return;
            }
        } catch (Throwable th) {
            AbstractTimeSource a3 = AbstractTimeSourceKt.a();
            if (a3 != null) {
                a3.e();
            }
            throw th;
        }
        a2.e();
    }

    public final void H(long j2) {
        int i2;
        Task task;
        if (f40789l.compareAndSet(this, 0, 1)) {
            Worker q2 = q();
            synchronized (this.f40797h) {
                i2 = (int) (f40788k.get(this) & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    Worker b2 = this.f40797h.b(i3);
                    Intrinsics.c(b2);
                    Worker worker = b2;
                    if (worker != q2) {
                        while (worker.isAlive()) {
                            LockSupport.unpark(worker);
                            worker.join(j2);
                        }
                        worker.f40800b.f(this.f40796g);
                    }
                    if (i3 == i2) {
                        break;
                    }
                    i3++;
                }
            }
            this.f40796g.b();
            this.f40795f.b();
            while (true) {
                if (q2 != null) {
                    task = q2.g(true);
                    if (task != null) {
                        continue;
                        E(task);
                    }
                }
                task = (Task) this.f40795f.d();
                if (task == null && (task = (Task) this.f40796g.d()) == null) {
                    break;
                }
                E(task);
            }
            if (q2 != null) {
                q2.u(WorkerState.TERMINATED);
            }
            f40787j.set(this, 0);
            f40788k.set(this, 0);
        }
    }

    public void close() {
        H(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
    }

    public void execute(Runnable runnable) {
        v(this, runnable, (TaskContext) null, false, 6, (Object) null);
    }

    public final boolean isTerminated() {
        if (f40789l.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final void j0() {
        if (!q0() && !p0(this, 0, 1, (Object) null)) {
            q0();
        }
    }

    public final Task k(Runnable runnable, TaskContext taskContext) {
        long a2 = TasksKt.f40832f.a();
        if (!(runnable instanceof Task)) {
            return new TaskImpl(runnable, a2, taskContext);
        }
        Task task = (Task) runnable;
        task.f40823b = a2;
        task.f40824c = taskContext;
        return task;
    }

    public final void s(Runnable runnable, TaskContext taskContext, boolean z2) {
        boolean z3;
        long j2;
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        if (a2 != null) {
            a2.d();
        }
        Task k2 = k(runnable, taskContext);
        boolean z4 = false;
        if (k2.f40824c.b() == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            j2 = f40788k.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        } else {
            j2 = 0;
        }
        Worker q2 = q();
        Task m02 = m0(q2, k2, z2);
        if (m02 == null || f(m02)) {
            if (z2 && q2 != null) {
                z4 = true;
            }
            if (z3) {
                L(j2, z4);
            } else if (!z4) {
                j0();
            }
        } else {
            throw new RejectedExecutionException(this.f40794e + " was terminated");
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a2 = this.f40797h.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < a2; i7++) {
            Worker b2 = this.f40797h.b(i7);
            if (b2 != null) {
                int e2 = b2.f40800b.e();
                int i8 = WhenMappings.f40798a[b2.f40802d.ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(e2);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i8 == 3) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(e2);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i8 == 4) {
                    i5++;
                    if (e2 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(e2);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j2 = f40788k.get(this);
        return this.f40794e + '@' + DebugStringsKt.b(this) + "[Pool Size {core = " + this.f40791b + ", max = " + this.f40792c + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f40795f.c() + ", global blocking queue size = " + this.f40796g.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.f40791b - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final class Worker extends Thread {

        /* renamed from: j  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f40799j = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");

        /* renamed from: b  reason: collision with root package name */
        public final WorkQueue f40800b;

        /* renamed from: c  reason: collision with root package name */
        private final Ref$ObjectRef<Task> f40801c;

        /* renamed from: d  reason: collision with root package name */
        public WorkerState f40802d;

        /* renamed from: e  reason: collision with root package name */
        private long f40803e;

        /* renamed from: f  reason: collision with root package name */
        private long f40804f;

        /* renamed from: g  reason: collision with root package name */
        private int f40805g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f40806h;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        private Worker() {
            setDaemon(true);
            this.f40800b = new WorkQueue();
            this.f40801c = new Ref$ObjectRef<>();
            this.f40802d = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f40790m;
            this.f40805g = Random.f40443b.c();
        }

        private final void b(int i2) {
            if (i2 != 0) {
                CoroutineScheduler.f40788k.addAndGet(CoroutineScheduler.this, -2097152);
                if (this.f40802d != WorkerState.TERMINATED) {
                    this.f40802d = WorkerState.DORMANT;
                }
            }
        }

        private final void c(int i2) {
            if (i2 != 0 && u(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.j0();
            }
        }

        private final void d(Task task) {
            int b2 = task.f40824c.b();
            k(b2);
            c(b2);
            CoroutineScheduler.this.E(task);
            b(b2);
        }

        private final Task e(boolean z2) {
            boolean z3;
            Task o2;
            Task o3;
            if (z2) {
                if (m(CoroutineScheduler.this.f40791b * 2) == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 && (o3 = o()) != null) {
                    return o3;
                }
                Task g2 = this.f40800b.g();
                if (g2 != null) {
                    return g2;
                }
                if (!z3 && (o2 = o()) != null) {
                    return o2;
                }
            } else {
                Task o4 = o();
                if (o4 != null) {
                    return o4;
                }
            }
            return v(3);
        }

        private final Task f() {
            Task h2 = this.f40800b.h();
            if (h2 != null) {
                return h2;
            }
            Task task = (Task) CoroutineScheduler.this.f40796g.d();
            if (task == null) {
                return v(1);
            }
            return task;
        }

        public static final AtomicIntegerFieldUpdater j() {
            return f40799j;
        }

        private final void k(int i2) {
            this.f40803e = 0;
            if (this.f40802d == WorkerState.PARKING) {
                this.f40802d = WorkerState.BLOCKING;
            }
        }

        private final boolean l() {
            return this.nextParkedWorker != CoroutineScheduler.f40790m;
        }

        private final void n() {
            if (this.f40803e == 0) {
                this.f40803e = System.nanoTime() + CoroutineScheduler.this.f40793d;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f40793d);
            if (System.nanoTime() - this.f40803e >= 0) {
                this.f40803e = 0;
                w();
            }
        }

        private final Task o() {
            if (m(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.f40795f.d();
                if (task != null) {
                    return task;
                }
                return (Task) CoroutineScheduler.this.f40796g.d();
            }
            Task task2 = (Task) CoroutineScheduler.this.f40796g.d();
            if (task2 != null) {
                return task2;
            }
            return (Task) CoroutineScheduler.this.f40795f.d();
        }

        private final void p() {
            loop0:
            while (true) {
                boolean z2 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f40802d != WorkerState.TERMINATED) {
                    Task g2 = g(this.f40806h);
                    if (g2 != null) {
                        this.f40804f = 0;
                        d(g2);
                    } else {
                        this.f40806h = false;
                        if (this.f40804f == 0) {
                            t();
                        } else if (!z2) {
                            z2 = true;
                        } else {
                            u(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f40804f);
                            this.f40804f = 0;
                        }
                    }
                }
            }
            u(WorkerState.TERMINATED);
        }

        private final boolean s() {
            boolean z2;
            if (this.f40802d == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater a2 = CoroutineScheduler.f40788k;
            while (true) {
                long j2 = a2.get(coroutineScheduler);
                if (((int) ((9223367638808264704L & j2) >> 42)) != 0) {
                    if (CoroutineScheduler.f40788k.compareAndSet(coroutineScheduler, j2, j2 - 4398046511104L)) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                return false;
            }
            this.f40802d = WorkerState.CPU_ACQUIRED;
            return true;
        }

        private final void t() {
            if (!l()) {
                CoroutineScheduler.this.B(this);
                return;
            }
            f40799j.set(this, -1);
            while (l() && f40799j.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.f40802d != WorkerState.TERMINATED) {
                u(WorkerState.PARKING);
                Thread.interrupted();
                n();
            }
        }

        private final Task v(int i2) {
            int i3 = (int) (CoroutineScheduler.f40788k.get(CoroutineScheduler.this) & 2097151);
            if (i3 < 2) {
                return null;
            }
            int m2 = m(i3);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j2 = Long.MAX_VALUE;
            for (int i4 = 0; i4 < i3; i4++) {
                m2++;
                if (m2 > i3) {
                    m2 = 1;
                }
                Worker b2 = coroutineScheduler.f40797h.b(m2);
                if (b2 == null || b2 == this) {
                    int i5 = i2;
                } else {
                    long n2 = b2.f40800b.n(i2, this.f40801c);
                    if (n2 == -1) {
                        Ref$ObjectRef<Task> ref$ObjectRef = this.f40801c;
                        Task task = (Task) ref$ObjectRef.f40429b;
                        ref$ObjectRef.f40429b = null;
                        return task;
                    } else if (n2 > 0) {
                        j2 = Math.min(j2, n2);
                    }
                }
            }
            if (j2 == Clock.MAX_TIME) {
                j2 = 0;
            }
            this.f40804f = j2;
            return null;
        }

        private final void w() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f40797h) {
                if (!coroutineScheduler.isTerminated()) {
                    if (((int) (CoroutineScheduler.f40788k.get(coroutineScheduler) & 2097151)) > coroutineScheduler.f40791b) {
                        if (f40799j.compareAndSet(this, -1, 1)) {
                            int i2 = this.indexInArray;
                            q(0);
                            coroutineScheduler.D(this, i2, 0);
                            int andDecrement = (int) (CoroutineScheduler.f40788k.getAndDecrement(coroutineScheduler) & 2097151);
                            if (andDecrement != i2) {
                                Worker b2 = coroutineScheduler.f40797h.b(andDecrement);
                                Intrinsics.c(b2);
                                Worker worker = b2;
                                coroutineScheduler.f40797h.c(i2, worker);
                                worker.q(i2);
                                coroutineScheduler.D(worker, andDecrement, i2);
                            }
                            coroutineScheduler.f40797h.c(andDecrement, null);
                            Unit unit = Unit.f40298a;
                            this.f40802d = WorkerState.TERMINATED;
                        }
                    }
                }
            }
        }

        public final Task g(boolean z2) {
            if (s()) {
                return e(z2);
            }
            return f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final int m(int i2) {
            int i3 = this.f40805g;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f40805g = i6;
            int i7 = i2 - 1;
            if ((i7 & i2) == 0) {
                return i6 & i7;
            }
            return (i6 & Integer.MAX_VALUE) % i2;
        }

        public final void q(int i2) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f40794e);
            sb.append("-worker-");
            if (i2 == 0) {
                str = "TERMINATED";
            } else {
                str = String.valueOf(i2);
            }
            sb.append(str);
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        public void run() {
            p();
        }

        public final boolean u(WorkerState workerState) {
            boolean z2;
            WorkerState workerState2 = this.f40802d;
            if (workerState2 == WorkerState.CPU_ACQUIRED) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                CoroutineScheduler.f40788k.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f40802d = workerState;
            }
            return z2;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i2) {
            this();
            q(i2);
        }
    }
}
