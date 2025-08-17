package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

abstract class TransformedIterator<F, T> implements Iterator<T> {

    /* renamed from: b  reason: collision with root package name */
    final Iterator<? extends F> f30675b;

    TransformedIterator(Iterator<? extends F> it2) {
        this.f30675b = (Iterator) Preconditions.l(it2);
    }

    /* access modifiers changed from: package-private */
    public abstract T a(F f2);

    public final boolean hasNext() {
        return this.f30675b.hasNext();
    }

    public final T next() {
        return a(this.f30675b.next());
    }

    public final void remove() {
        this.f30675b.remove();
    }
}
