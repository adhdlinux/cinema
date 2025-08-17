package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {

    /* renamed from: b  reason: collision with root package name */
    private final int f30424b;

    /* renamed from: c  reason: collision with root package name */
    private int f30425c;

    protected AbstractIndexedListIterator(int i2, int i3) {
        Preconditions.n(i3, i2);
        this.f30424b = i2;
        this.f30425c = i3;
    }

    /* access modifiers changed from: protected */
    public abstract E a(int i2);

    public final boolean hasNext() {
        return this.f30425c < this.f30424b;
    }

    public final boolean hasPrevious() {
        return this.f30425c > 0;
    }

    public final E next() {
        if (hasNext()) {
            int i2 = this.f30425c;
            this.f30425c = i2 + 1;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f30425c;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.f30425c - 1;
            this.f30425c = i2;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f30425c - 1;
    }
}
