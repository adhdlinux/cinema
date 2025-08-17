package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public final class Predicates {

    private static class AndPredicate<T> implements Predicate<T>, Serializable {

        /* renamed from: b  reason: collision with root package name */
        private final List<? extends Predicate<? super T>> f30403b;

        public boolean apply(T t2) {
            for (int i2 = 0; i2 < this.f30403b.size(); i2++) {
                if (!((Predicate) this.f30403b.get(i2)).apply(t2)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (obj instanceof AndPredicate) {
                return this.f30403b.equals(((AndPredicate) obj).f30403b);
            }
            return false;
        }

        public int hashCode() {
            return this.f30403b.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.d("and", this.f30403b);
        }

        private AndPredicate(List<? extends Predicate<? super T>> list) {
            this.f30403b = list;
        }
    }

    private Predicates() {
    }

    public static <T> Predicate<T> b(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new AndPredicate(c((Predicate) Preconditions.l(predicate), (Predicate) Preconditions.l(predicate2)));
    }

    private static <T> List<Predicate<? super T>> c(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return Arrays.asList(new Predicate[]{predicate, predicate2});
    }

    /* access modifiers changed from: private */
    public static String d(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z2 = true;
        for (Object next : iterable) {
            if (!z2) {
                sb.append(',');
            }
            sb.append(next);
            z2 = false;
        }
        sb.append(')');
        return sb.toString();
    }
}
