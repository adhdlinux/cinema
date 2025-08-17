package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

public final class EmptySet implements Set, Serializable, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    public static final EmptySet f40321b = new EmptySet();

    private EmptySet() {
    }

    public boolean a(Void voidR) {
        Intrinsics.f(voidR, "element");
        return false;
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int b() {
        return 0;
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

    public boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator iterator() {
        return EmptyIterator.f40318b;
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

    public final /* bridge */ int size() {
        return b();
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
}
