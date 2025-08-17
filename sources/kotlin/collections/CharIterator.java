package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

public abstract class CharIterator implements Iterator<Character>, KMappedMarker {
    public abstract char a();

    public /* bridge */ /* synthetic */ Object next() {
        return Character.valueOf(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
