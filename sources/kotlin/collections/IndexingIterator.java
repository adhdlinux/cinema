package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class IndexingIterator<T> implements Iterator<IndexedValue<? extends T>>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private final Iterator<T> f40325b;

    /* renamed from: c  reason: collision with root package name */
    private int f40326c;

    public IndexingIterator(Iterator<? extends T> it2) {
        Intrinsics.f(it2, "iterator");
        this.f40325b = it2;
    }

    /* renamed from: a */
    public final IndexedValue<T> next() {
        int i2 = this.f40326c;
        this.f40326c = i2 + 1;
        if (i2 < 0) {
            CollectionsKt__CollectionsKt.o();
        }
        return new IndexedValue<>(i2, this.f40325b.next());
    }

    public final boolean hasNext() {
        return this.f40325b.hasNext();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
