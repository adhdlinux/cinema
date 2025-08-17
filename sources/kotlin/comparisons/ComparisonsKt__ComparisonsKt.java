package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

class ComparisonsKt__ComparisonsKt {
    public static <T extends Comparable<?>> int a(T t2, T t3) {
        if (t2 == t3) {
            return 0;
        }
        if (t2 == null) {
            return -1;
        }
        if (t3 == null) {
            return 1;
        }
        return t2.compareTo(t3);
    }

    public static <T extends Comparable<? super T>> Comparator<T> b() {
        NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.f40349b;
        Intrinsics.d(naturalOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return naturalOrderComparator;
    }
}
