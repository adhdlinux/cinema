package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

public final class EmptyList implements List, Serializable, RandomAccess, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    public static final EmptyList f40319b = new EmptyList();

    private EmptyList() {
    }

    public boolean a(Void voidR) {
        Intrinsics.f(voidR, "element");
        return false;
    }

    public /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public Void get(int i2) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i2 + '.');
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        return a((Void) obj);
    }

    public boolean containsAll(Collection collection) {
        Intrinsics.f(collection, "elements");
        return collection.isEmpty();
    }

    public int d() {
        return 0;
    }

    public int e(Void voidR) {
        Intrinsics.f(voidR, "element");
        return -1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    public int g(Void voidR) {
        Intrinsics.f(voidR, "element");
        return -1;
    }

    public int hashCode() {
        return 1;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        return e((Void) obj);
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator iterator() {
        return EmptyIterator.f40318b;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        return g((Void) obj);
    }

    public ListIterator listIterator() {
        return EmptyIterator.f40318b;
    }

    public /* bridge */ /* synthetic */ Object remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return d();
    }

    public List subList(int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3);
    }

    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.f(tArr, "array");
        return CollectionToArray.b(this, tArr);
    }

    public String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public ListIterator listIterator(int i2) {
        if (i2 == 0) {
            return EmptyIterator.f40318b;
        }
        throw new IndexOutOfBoundsException("Index: " + i2);
    }
}
