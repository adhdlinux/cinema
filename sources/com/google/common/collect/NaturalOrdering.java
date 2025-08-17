package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class NaturalOrdering extends Ordering<Comparable<?>> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    static final NaturalOrdering f30638b = new NaturalOrdering();

    private NaturalOrdering() {
    }

    public <S extends Comparable<?>> Ordering<S> g() {
        return ReverseNaturalOrdering.f30663b;
    }

    /* renamed from: h */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        Preconditions.l(comparable);
        Preconditions.l(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
