package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class UShortArray implements Collection<UShort>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private final short[] f40295b;

    private static final class Iterator implements java.util.Iterator<UShort>, KMappedMarker {

        /* renamed from: b  reason: collision with root package name */
        private final short[] f40296b;

        /* renamed from: c  reason: collision with root package name */
        private int f40297c;

        public Iterator(short[] sArr) {
            Intrinsics.f(sArr, "array");
            this.f40296b = sArr;
        }

        public short a() {
            int i2 = this.f40297c;
            short[] sArr = this.f40296b;
            if (i2 < sArr.length) {
                this.f40297c = i2 + 1;
                return UShort.b(sArr[i2]);
            }
            throw new NoSuchElementException(String.valueOf(this.f40297c));
        }

        public boolean hasNext() {
            return this.f40297c < this.f40296b.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return UShort.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ UShortArray(short[] sArr) {
        this.f40295b = sArr;
    }

    public static final /* synthetic */ UShortArray a(short[] sArr) {
        return new UShortArray(sArr);
    }

    public static short[] b(int i2) {
        return d(new short[i2]);
    }

    public static short[] d(short[] sArr) {
        Intrinsics.f(sArr, "storage");
        return sArr;
    }

    public static boolean g(short[] sArr, short s2) {
        return ArraysKt___ArraysKt.t(sArr, s2);
    }

    public static boolean h(short[] sArr, Collection<UShort> collection) {
        boolean z2;
        Intrinsics.f(collection, "elements");
        Iterable iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object next : iterable) {
            if (!(next instanceof UShort) || !ArraysKt___ArraysKt.t(sArr, ((UShort) next).f())) {
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

    public static boolean i(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.a(sArr, ((UShortArray) obj).r());
    }

    public static final short j(short[] sArr, int i2) {
        return UShort.b(sArr[i2]);
    }

    public static int l(short[] sArr) {
        return sArr.length;
    }

    public static int m(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean n(short[] sArr) {
        return sArr.length == 0;
    }

    public static java.util.Iterator<UShort> o(short[] sArr) {
        return new Iterator(sArr);
    }

    public static final void p(short[] sArr, int i2, short s2) {
        sArr[i2] = s2;
    }

    public static String q(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UShort)) {
            return false;
        }
        return e(((UShort) obj).f());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        return h(this.f40295b, collection);
    }

    public boolean e(short s2) {
        return g(this.f40295b, s2);
    }

    public boolean equals(Object obj) {
        return i(this.f40295b, obj);
    }

    public int hashCode() {
        return m(this.f40295b);
    }

    public boolean isEmpty() {
        return n(this.f40295b);
    }

    public java.util.Iterator<UShort> iterator() {
        return o(this.f40295b);
    }

    /* renamed from: k */
    public int size() {
        return l(this.f40295b);
    }

    public final /* synthetic */ short[] r() {
        return this.f40295b;
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
        return q(this.f40295b);
    }
}
