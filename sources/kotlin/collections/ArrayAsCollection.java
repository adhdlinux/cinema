package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

final class ArrayAsCollection<T> implements Collection<T>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private final T[] f40309b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f40310c;

    public ArrayAsCollection(T[] tArr, boolean z2) {
        Intrinsics.f(tArr, "values");
        this.f40309b = tArr;
        this.f40310c = z2;
    }

    public int a() {
        return this.f40309b.length;
    }

    public boolean add(T t2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return ArraysKt___ArraysKt.s(this.f40309b, obj);
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
        return this.f40309b.length == 0;
    }

    public Iterator<T> iterator() {
        return ArrayIteratorKt.a(this.f40309b);
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

    public final Object[] toArray() {
        return CollectionsKt__CollectionsJVMKt.a(this.f40309b, this.f40310c);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.f(tArr, "array");
        return CollectionToArray.b(this, tArr);
    }
}
