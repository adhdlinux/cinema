package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class TransformingSequence$iterator$1 implements Iterator<R>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private final Iterator<T> f40510b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ TransformingSequence<T, R> f40511c;

    TransformingSequence$iterator$1(TransformingSequence<T, R> transformingSequence) {
        this.f40511c = transformingSequence;
        this.f40510b = transformingSequence.f40508a.iterator();
    }

    public boolean hasNext() {
        return this.f40510b.hasNext();
    }

    public R next() {
        return this.f40511c.f40509b.invoke(this.f40510b.next());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
