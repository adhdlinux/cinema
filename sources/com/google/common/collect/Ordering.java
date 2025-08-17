package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Map;

public abstract class Ordering<T> implements Comparator<T> {
    protected Ordering() {
    }

    public static <T> Ordering<T> b(Comparator<T> comparator) {
        if (comparator instanceof Ordering) {
            return (Ordering) comparator;
        }
        return new ComparatorOrdering(comparator);
    }

    public static <C extends Comparable> Ordering<C> d() {
        return NaturalOrdering.f30638b;
    }

    public <U extends T> Ordering<U> a(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) Preconditions.l(comparator));
    }

    public <E extends T> ImmutableList<E> c(Iterable<E> iterable) {
        return ImmutableList.y(this, iterable);
    }

    public abstract int compare(T t2, T t3);

    /* access modifiers changed from: package-private */
    public <T2 extends T> Ordering<Map.Entry<T2, ?>> e() {
        return f(Maps.e());
    }

    public <F> Ordering<F> f(Function<F, ? extends T> function) {
        return new ByFunctionOrdering(function, this);
    }

    public <S extends T> Ordering<S> g() {
        return new ReverseOrdering(this);
    }
}
