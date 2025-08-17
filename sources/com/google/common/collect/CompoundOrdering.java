package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

final class CompoundOrdering<T> extends Ordering<T> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    final Comparator<? super T>[] f30504b;

    CompoundOrdering(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        this.f30504b = new Comparator[]{comparator, comparator2};
    }

    public int compare(T t2, T t3) {
        int i2 = 0;
        while (true) {
            Comparator<? super T>[] comparatorArr = this.f30504b;
            if (i2 >= comparatorArr.length) {
                return 0;
            }
            int compare = comparatorArr[i2].compare(t2, t3);
            if (compare != 0) {
                return compare;
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompoundOrdering) {
            return Arrays.equals(this.f30504b, ((CompoundOrdering) obj).f30504b);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f30504b);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.f30504b) + ")";
    }
}
