package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

public abstract class LongIterator implements Iterator<Long>, KMappedMarker {
    public /* bridge */ /* synthetic */ Object next() {
        return Long.valueOf(nextLong());
    }

    public abstract long nextLong();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
