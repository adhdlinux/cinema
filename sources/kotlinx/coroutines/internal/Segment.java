package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.internal.Segment;

public abstract class Segment<S extends Segment<S>> extends ConcurrentLinkedListNode<S> implements NotCompleted {

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40769e = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;

    /* renamed from: d  reason: collision with root package name */
    public final long f40770d;

    public Segment(long j2, S s2, int i2) {
        super(s2);
        this.f40770d = j2;
        this.cleanedAndPointers = i2 << 16;
    }

    public boolean h() {
        if (f40769e.get(this) != m() || i()) {
            return false;
        }
        return true;
    }

    public final boolean l() {
        if (f40769e.addAndGet(this, -65536) != m() || i()) {
            return false;
        }
        return true;
    }

    public abstract int m();

    public abstract void n(int i2, Throwable th, CoroutineContext coroutineContext);

    public final void o() {
        if (f40769e.incrementAndGet(this) == m()) {
            j();
        }
    }

    public final boolean p() {
        int i2;
        boolean z2;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f40769e;
        do {
            i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 != m() || i()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 65536 + i2));
        return true;
    }
}
