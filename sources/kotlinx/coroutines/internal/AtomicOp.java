package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class AtomicOp<T> extends OpDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40720a = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile Object _consensus = AtomicKt.f40719a;

    private final Object c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40720a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = AtomicKt.f40719a;
        if (obj2 != obj3) {
            return obj2;
        }
        if (a.a(atomicReferenceFieldUpdater, this, obj3, obj)) {
            return obj;
        }
        return atomicReferenceFieldUpdater.get(this);
    }

    public final Object a(Object obj) {
        Object obj2 = f40720a.get(this);
        if (obj2 == AtomicKt.f40719a) {
            obj2 = c(d(obj));
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(T t2, Object obj);

    public abstract Object d(T t2);
}
