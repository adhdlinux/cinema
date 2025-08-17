package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

public final class ConstrainedOnceSequence<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<Sequence<T>> f40491a;

    public ConstrainedOnceSequence(Sequence<? extends T> sequence) {
        Intrinsics.f(sequence, "sequence");
        this.f40491a = new AtomicReference<>(sequence);
    }

    public Iterator<T> iterator() {
        Sequence andSet = this.f40491a.getAndSet((Object) null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
