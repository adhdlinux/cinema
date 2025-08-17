package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class UIntArray implements Collection<UInt>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private final int[] f40284b;

    private static final class Iterator implements java.util.Iterator<UInt>, KMappedMarker {

        /* renamed from: b  reason: collision with root package name */
        private final int[] f40285b;

        /* renamed from: c  reason: collision with root package name */
        private int f40286c;

        public Iterator(int[] iArr) {
            Intrinsics.f(iArr, "array");
            this.f40285b = iArr;
        }

        public int a() {
            int i2 = this.f40286c;
            int[] iArr = this.f40285b;
            if (i2 < iArr.length) {
                this.f40286c = i2 + 1;
                return UInt.b(iArr[i2]);
            }
            throw new NoSuchElementException(String.valueOf(this.f40286c));
        }

        public boolean hasNext() {
            return this.f40286c < this.f40285b.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return UInt.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ UIntArray(int[] iArr) {
        this.f40284b = iArr;
    }

    public static final /* synthetic */ UIntArray a(int[] iArr) {
        return new UIntArray(iArr);
    }

    public static int[] b(int i2) {
        return d(new int[i2]);
    }

    public static int[] d(int[] iArr) {
        Intrinsics.f(iArr, "storage");
        return iArr;
    }

    public static boolean g(int[] iArr, int i2) {
        return ArraysKt___ArraysKt.q(iArr, i2);
    }

    public static boolean h(int[] iArr, Collection<UInt> collection) {
        boolean z2;
        Intrinsics.f(collection, "elements");
        Iterable iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object next : iterable) {
            if (!(next instanceof UInt) || !ArraysKt___ArraysKt.q(iArr, ((UInt) next).f())) {
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

    public static boolean i(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.a(iArr, ((UIntArray) obj).r());
    }

    public static final int j(int[] iArr, int i2) {
        return UInt.b(iArr[i2]);
    }

    public static int l(int[] iArr) {
        return iArr.length;
    }

    public static int m(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean n(int[] iArr) {
        return iArr.length == 0;
    }

    public static java.util.Iterator<UInt> o(int[] iArr) {
        return new Iterator(iArr);
    }

    public static final void p(int[] iArr, int i2, int i3) {
        iArr[i2] = i3;
    }

    public static String q(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UInt)) {
            return false;
        }
        return e(((UInt) obj).f());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        return h(this.f40284b, collection);
    }

    public boolean e(int i2) {
        return g(this.f40284b, i2);
    }

    public boolean equals(Object obj) {
        return i(this.f40284b, obj);
    }

    public int hashCode() {
        return m(this.f40284b);
    }

    public boolean isEmpty() {
        return n(this.f40284b);
    }

    public java.util.Iterator<UInt> iterator() {
        return o(this.f40284b);
    }

    /* renamed from: k */
    public int size() {
        return l(this.f40284b);
    }

    public final /* synthetic */ int[] r() {
        return this.f40284b;
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
        return q(this.f40284b);
    }
}
