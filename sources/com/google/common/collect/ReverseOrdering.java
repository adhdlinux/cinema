package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class ReverseOrdering<T> extends Ordering<T> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    final Ordering<? super T> f30664b;

    ReverseOrdering(Ordering<? super T> ordering) {
        this.f30664b = (Ordering) Preconditions.l(ordering);
    }

    public int compare(T t2, T t3) {
        return this.f30664b.compare(t3, t2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.f30664b.equals(((ReverseOrdering) obj).f30664b);
        }
        return false;
    }

    public <S extends T> Ordering<S> g() {
        return this.f30664b;
    }

    public int hashCode() {
        return -this.f30664b.hashCode();
    }

    public String toString() {
        return this.f30664b + ".reverse()";
    }
}
