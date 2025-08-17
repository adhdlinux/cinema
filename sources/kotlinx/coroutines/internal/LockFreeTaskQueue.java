package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class LockFreeTaskQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40751a = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    private volatile Object _cur;

    public LockFreeTaskQueue(boolean z2) {
        this._cur = new LockFreeTaskQueueCore(8, z2);
    }

    public final boolean a(E e2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40751a;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            int a2 = lockFreeTaskQueueCore.a(e2);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                a.a(f40751a, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.i());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40751a;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (!lockFreeTaskQueueCore.d()) {
                a.a(f40751a, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.i());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((LockFreeTaskQueueCore) f40751a.get(this)).f();
    }

    public final E d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40751a;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            E j2 = lockFreeTaskQueueCore.j();
            if (j2 != LockFreeTaskQueueCore.f40755h) {
                return j2;
            }
            a.a(f40751a, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.i());
        }
    }
}
