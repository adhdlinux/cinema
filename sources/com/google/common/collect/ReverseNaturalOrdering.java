package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class ReverseNaturalOrdering extends Ordering<Comparable<?>> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    static final ReverseNaturalOrdering f30663b = new ReverseNaturalOrdering();

    private ReverseNaturalOrdering() {
    }

    public <S extends Comparable<?>> Ordering<S> g() {
        return Ordering.d();
    }

    /* renamed from: h */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        Preconditions.l(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
