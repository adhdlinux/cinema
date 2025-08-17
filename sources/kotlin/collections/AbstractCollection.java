package kotlin.collections;

import java.util.Collection;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

public abstract class AbstractCollection<E> implements Collection<E>, KMappedMarker {
    protected AbstractCollection() {
    }

    public abstract int a();

    public boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(E e2) {
        if (isEmpty()) {
            return false;
        }
        for (Object a2 : this) {
            if (Intrinsics.a(a2, e2)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return a();
    }

    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.J(this, ", ", "[", "]", 0, (CharSequence) null, new AbstractCollection$toString$1(this), 24, (Object) null);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.f(tArr, "array");
        return CollectionToArray.b(this, tArr);
    }
}
