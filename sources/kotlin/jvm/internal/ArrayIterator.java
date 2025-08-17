package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

final class ArrayIterator<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private final T[] f40404b;

    /* renamed from: c  reason: collision with root package name */
    private int f40405c;

    public ArrayIterator(T[] tArr) {
        Intrinsics.f(tArr, "array");
        this.f40404b = tArr;
    }

    public boolean hasNext() {
        return this.f40405c < this.f40404b.length;
    }

    public T next() {
        try {
            T[] tArr = this.f40404b;
            int i2 = this.f40405c;
            this.f40405c = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f40405c--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
