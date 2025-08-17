package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class UByteArray implements Collection<UByte>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f40279b;

    private static final class Iterator implements java.util.Iterator<UByte>, KMappedMarker {

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f40280b;

        /* renamed from: c  reason: collision with root package name */
        private int f40281c;

        public Iterator(byte[] bArr) {
            Intrinsics.f(bArr, "array");
            this.f40280b = bArr;
        }

        public byte a() {
            int i2 = this.f40281c;
            byte[] bArr = this.f40280b;
            if (i2 < bArr.length) {
                this.f40281c = i2 + 1;
                return UByte.b(bArr[i2]);
            }
            throw new NoSuchElementException(String.valueOf(this.f40281c));
        }

        public boolean hasNext() {
            return this.f40281c < this.f40280b.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return UByte.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ UByteArray(byte[] bArr) {
        this.f40279b = bArr;
    }

    public static final /* synthetic */ UByteArray a(byte[] bArr) {
        return new UByteArray(bArr);
    }

    public static byte[] b(int i2) {
        return d(new byte[i2]);
    }

    public static byte[] d(byte[] bArr) {
        Intrinsics.f(bArr, "storage");
        return bArr;
    }

    public static boolean g(byte[] bArr, byte b2) {
        return ArraysKt___ArraysKt.o(bArr, b2);
    }

    public static boolean h(byte[] bArr, Collection<UByte> collection) {
        boolean z2;
        Intrinsics.f(collection, "elements");
        Iterable iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object next : iterable) {
            if (!(next instanceof UByte) || !ArraysKt___ArraysKt.o(bArr, ((UByte) next).f())) {
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

    public static boolean i(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.a(bArr, ((UByteArray) obj).r());
    }

    public static final byte j(byte[] bArr, int i2) {
        return UByte.b(bArr[i2]);
    }

    public static int l(byte[] bArr) {
        return bArr.length;
    }

    public static int m(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean n(byte[] bArr) {
        return bArr.length == 0;
    }

    public static java.util.Iterator<UByte> o(byte[] bArr) {
        return new Iterator(bArr);
    }

    public static final void p(byte[] bArr, int i2, byte b2) {
        bArr[i2] = b2;
    }

    public static String q(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UByte)) {
            return false;
        }
        return e(((UByte) obj).f());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        return h(this.f40279b, collection);
    }

    public boolean e(byte b2) {
        return g(this.f40279b, b2);
    }

    public boolean equals(Object obj) {
        return i(this.f40279b, obj);
    }

    public int hashCode() {
        return m(this.f40279b);
    }

    public boolean isEmpty() {
        return n(this.f40279b);
    }

    public java.util.Iterator<UByte> iterator() {
        return o(this.f40279b);
    }

    /* renamed from: k */
    public int size() {
        return l(this.f40279b);
    }

    public final /* synthetic */ byte[] r() {
        return this.f40279b;
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
        return q(this.f40279b);
    }
}
