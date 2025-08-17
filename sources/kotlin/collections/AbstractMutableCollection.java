package kotlin.collections;

import java.util.AbstractCollection;
import java.util.Collection;
import kotlin.jvm.internal.markers.KMappedMarker;

public abstract class AbstractMutableCollection<E> extends AbstractCollection<E> implements Collection<E>, KMappedMarker {
    protected AbstractMutableCollection() {
    }

    public abstract int a();

    public final /* bridge */ int size() {
        return a();
    }
}
