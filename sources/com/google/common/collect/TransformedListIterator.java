package com.google.common.collect;

import java.util.ListIterator;

abstract class TransformedListIterator<F, T> extends TransformedIterator<F, T> implements ListIterator<T> {
    TransformedListIterator(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> b() {
        return (ListIterator) this.f30675b;
    }

    public void add(T t2) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    public final int nextIndex() {
        return b().nextIndex();
    }

    public final T previous() {
        return a(b().previous());
    }

    public final int previousIndex() {
        return b().previousIndex();
    }

    public void set(T t2) {
        throw new UnsupportedOperationException();
    }
}
