package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;

final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    final Function<F, ? extends T> f30472b;

    /* renamed from: c  reason: collision with root package name */
    final Ordering<T> f30473c;

    ByFunctionOrdering(Function<F, ? extends T> function, Ordering<T> ordering) {
        this.f30472b = (Function) Preconditions.l(function);
        this.f30473c = (Ordering) Preconditions.l(ordering);
    }

    public int compare(F f2, F f3) {
        return this.f30473c.compare(this.f30472b.apply(f2), this.f30472b.apply(f3));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        if (!this.f30472b.equals(byFunctionOrdering.f30472b) || !this.f30473c.equals(byFunctionOrdering.f30473c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.b(this.f30472b, this.f30473c);
    }

    public String toString() {
        return this.f30473c + ".onResultOf(" + this.f30472b + ")";
    }
}
