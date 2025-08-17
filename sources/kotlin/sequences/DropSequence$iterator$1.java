package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class DropSequence$iterator$1 implements Iterator<T>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private final Iterator<T> f40494b;

    /* renamed from: c  reason: collision with root package name */
    private int f40495c;

    DropSequence$iterator$1(DropSequence<T> dropSequence) {
        this.f40494b = dropSequence.f40492a.iterator();
        this.f40495c = dropSequence.f40493b;
    }

    private final void a() {
        while (this.f40495c > 0 && this.f40494b.hasNext()) {
            this.f40494b.next();
            this.f40495c--;
        }
    }

    public boolean hasNext() {
        a();
        return this.f40494b.hasNext();
    }

    public T next() {
        a();
        return this.f40494b.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
