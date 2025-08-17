package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class IndexBasedArrayIterator<T> implements Iterator<T> {

    /* renamed from: b  reason: collision with root package name */
    private int f1698b;

    /* renamed from: c  reason: collision with root package name */
    private int f1699c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1700d;

    IndexBasedArrayIterator(int i2) {
        this.f1698b = i2;
    }

    /* access modifiers changed from: protected */
    public abstract T a(int i2);

    /* access modifiers changed from: protected */
    public abstract void b(int i2);

    public final boolean hasNext() {
        return this.f1699c < this.f1698b;
    }

    public T next() {
        if (hasNext()) {
            T a2 = a(this.f1699c);
            this.f1699c++;
            this.f1700d = true;
            return a2;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.f1700d) {
            int i2 = this.f1699c - 1;
            this.f1699c = i2;
            b(i2);
            this.f1698b--;
            this.f1700d = false;
            return;
        }
        throw new IllegalStateException();
    }
}
