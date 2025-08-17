package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;

final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    final Comparator<T> f30499b;

    ComparatorOrdering(Comparator<T> comparator) {
        this.f30499b = (Comparator) Preconditions.l(comparator);
    }

    public int compare(T t2, T t3) {
        return this.f30499b.compare(t2, t3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ComparatorOrdering) {
            return this.f30499b.equals(((ComparatorOrdering) obj).f30499b);
        }
        return false;
    }

    public int hashCode() {
        return this.f30499b.hashCode();
    }

    public String toString() {
        return this.f30499b.toString();
    }
}
