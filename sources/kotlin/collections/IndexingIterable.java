package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class IndexingIterable<T> implements Iterable<IndexedValue<? extends T>>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Iterator<T>> f40324b;

    public IndexingIterable(Function0<? extends Iterator<? extends T>> function0) {
        Intrinsics.f(function0, "iteratorFactory");
        this.f40324b = function0;
    }

    public Iterator<IndexedValue<T>> iterator() {
        return new IndexingIterator(this.f40324b.invoke());
    }
}
