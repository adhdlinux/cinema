package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class WorkQueue {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40836b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40837c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40838d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40839e;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray<Task> f40840a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    static {
        Class<WorkQueue> cls = WorkQueue.class;
        f40836b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f40837c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f40838d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f40839e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    private final Task b(Task task) {
        if (d() == 127) {
            return task;
        }
        boolean z2 = true;
        if (task.f40824c.b() != 1) {
            z2 = false;
        }
        if (z2) {
            f40839e.incrementAndGet(this);
        }
        int i2 = f40837c.get(this) & 127;
        while (this.f40840a.get(i2) != null) {
            Thread.yield();
        }
        this.f40840a.lazySet(i2, task);
        f40837c.incrementAndGet(this);
        return null;
    }

    private final void c(Task task) {
        if (task != null) {
            boolean z2 = true;
            if (task.f40824c.b() != 1) {
                z2 = false;
            }
            if (z2) {
                f40839e.decrementAndGet(this);
            }
        }
    }

    private final int d() {
        return f40837c.get(this) - f40838d.get(this);
    }

    private final Task i() {
        Task andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f40838d;
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 - f40837c.get(this) == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i2, i2 + 1) && (andSet = this.f40840a.getAndSet(i3, (Object) null)) != null) {
                c(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(GlobalQueue globalQueue) {
        Task i2 = i();
        if (i2 == null) {
            return false;
        }
        globalQueue.a(i2);
        return true;
    }

    private final Task k(boolean z2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Task task;
        do {
            atomicReferenceFieldUpdater = f40836b;
            task = (Task) atomicReferenceFieldUpdater.get(this);
            if (task != null) {
                boolean z3 = true;
                if (task.f40824c.b() != 1) {
                    z3 = false;
                }
                if (z3 == z2) {
                }
            }
            int i2 = f40838d.get(this);
            int i3 = f40837c.get(this);
            while (i2 != i3) {
                if (z2 && f40839e.get(this) == 0) {
                    return null;
                }
                i3--;
                Task m2 = m(i3, z2);
                if (m2 != null) {
                    return m2;
                }
            }
            return null;
        } while (!a.a(atomicReferenceFieldUpdater, this, task, (Object) null));
        return task;
    }

    private final Task l(int i2) {
        int i3 = f40838d.get(this);
        int i4 = f40837c.get(this);
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        while (i3 != i4) {
            if (z2 && f40839e.get(this) == 0) {
                return null;
            }
            int i5 = i3 + 1;
            Task m2 = m(i3, z2);
            if (m2 != null) {
                return m2;
            }
            i3 = i5;
        }
        return null;
    }

    private final Task m(int i2, boolean z2) {
        int i3 = i2 & 127;
        Task task = this.f40840a.get(i3);
        if (task != null) {
            boolean z3 = true;
            if (task.f40824c.b() != 1) {
                z3 = false;
            }
            if (z3 == z2 && p1.a.a(this.f40840a, i3, task, (Object) null)) {
                if (z2) {
                    f40839e.decrementAndGet(this);
                }
                return task;
            }
        }
        return null;
    }

    private final long o(int i2, Ref$ObjectRef<Task> ref$ObjectRef) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        T t2;
        boolean z2;
        do {
            atomicReferenceFieldUpdater = f40836b;
            t2 = (Task) atomicReferenceFieldUpdater.get(this);
            if (t2 == null) {
                return -2;
            }
            int i3 = 1;
            if (t2.f40824c.b() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                i3 = 2;
            }
            if ((i3 & i2) == 0) {
                return -2;
            }
            long a2 = TasksKt.f40832f.a() - t2.f40823b;
            long j2 = TasksKt.f40828b;
            if (a2 < j2) {
                return j2 - a2;
            }
        } while (!a.a(atomicReferenceFieldUpdater, this, t2, (Object) null));
        ref$ObjectRef.f40429b = t2;
        return -1;
    }

    public final Task a(Task task, boolean z2) {
        if (z2) {
            return b(task);
        }
        Task task2 = (Task) f40836b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return b(task2);
    }

    public final int e() {
        return f40836b.get(this) != null ? d() + 1 : d();
    }

    public final void f(GlobalQueue globalQueue) {
        Task task = (Task) f40836b.getAndSet(this, (Object) null);
        if (task != null) {
            globalQueue.a(task);
        }
        do {
        } while (j(globalQueue));
    }

    public final Task g() {
        Task task = (Task) f40836b.getAndSet(this, (Object) null);
        return task == null ? i() : task;
    }

    public final Task h() {
        return k(true);
    }

    public final long n(int i2, Ref$ObjectRef<Task> ref$ObjectRef) {
        T t2;
        if (i2 == 3) {
            t2 = i();
        } else {
            t2 = l(i2);
        }
        if (t2 == null) {
            return o(i2, ref$ObjectRef);
        }
        ref$ObjectRef.f40429b = t2;
        return -1;
    }
}
