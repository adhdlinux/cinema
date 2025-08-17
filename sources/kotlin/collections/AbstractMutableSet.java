package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;
import kotlin.jvm.internal.markers.KMappedMarker;

public abstract class AbstractMutableSet<E> extends AbstractSet<E> implements Set<E>, KMappedMarker {
    protected AbstractMutableSet() {
    }

    public abstract int a();

    public final /* bridge */ int size() {
        return a();
    }
}
