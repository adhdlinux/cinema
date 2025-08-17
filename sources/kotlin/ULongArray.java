package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class ULongArray implements Collection<ULong>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private final long[] f40289b;

    private static final class Iterator implements java.util.Iterator<ULong>, KMappedMarker {

        /* renamed from: b  reason: collision with root package name */
        private final long[] f40290b;

        /* renamed from: c  reason: collision with root package name */
        private int f40291c;

        public Iterator(long[] jArr) {
            Intrinsics.f(jArr, "array");
            this.f40290b = jArr;
        }

        public long a() {
            int i2 = this.f40291c;
            long[] jArr = this.f40290b;
            if (i2 < jArr.length) {
                this.f40291c = i2 + 1;
                return ULong.b(jArr[i2]);
            }
            throw new NoSuchElementException(String.valueOf(this.f40291c));
        }

        public boolean hasNext() {
            return this.f40291c < this.f40290b.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return ULong.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ ULongArray(long[] jArr) {
        this.f40289b = jArr;
    }

    public static final /* synthetic */ ULongArray a(long[] jArr) {
        return new ULongArray(jArr);
    }

    public static long[] b(int i2) {
        return d(new long[i2]);
    }

    public static long[] d(long[] jArr) {
        Intrinsics.f(jArr, "storage");
        return jArr;
    }

    public static boolean g(long[] jArr, long j2) {
        return ArraysKt___ArraysKt.r(jArr, j2);
    }

    public static boolean h(long[] jArr, Collection<ULong> collection) {
        boolean z2;
        Intrinsics.f(collection, "elements");
        Iterable iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object next : iterable) {
            if (!(next instanceof ULong) || !ArraysKt___ArraysKt.r(jArr, ((ULong) next).f())) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.a(jArr, ((ULongArray) obj).r());
    }

    public static final long j(long[] jArr, int i2) {
        return ULong.b(jArr[i2]);
    }

    public static int l(long[] jArr) {
        return jArr.length;
    }

    public static int m(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean n(long[] jArr) {
        return jArr.length == 0;
    }

    public static java.util.Iterator<ULong> o(long[] jArr) {
        return new Iterator(jArr);
    }

    public static final void p(long[] jArr, int i2, long j2) {
        jArr[i2] = j2;
    }

    public static String q(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ULong)) {
            return false;
        }
        return e(((ULong) obj).f());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        return h(this.f40289b, collection);
    }

    public boolean e(long j2) {
        return g(this.f40289b, j2);
    }

    public boolean equals(Object obj) {
        return i(this.f40289b, obj);
    }

    public int hashCode() {
        return m(this.f40289b);
    }

    public boolean isEmpty() {
        return n(this.f40289b);
    }

    public java.util.Iterator<ULong> iterator() {
        return o(this.f40289b);
    }

    /* renamed from: k */
    public int size() {
        return l(this.f40289b);
    }

    public final /* synthetic */ long[] r() {
        return this.f40289b;
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

    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.f(tArr, "array");
        return CollectionToArray.b(this, tArr);
    }

    public String toString() {
        return q(this.f40289b);
    }
}
