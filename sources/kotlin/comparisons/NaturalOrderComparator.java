package kotlin.comparisons;

import com.facebook.ads.internal.c.a;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

final class NaturalOrderComparator implements Comparator<Comparable<? super Object>> {

    /* renamed from: b  reason: collision with root package name */
    public static final NaturalOrderComparator f40349b = new NaturalOrderComparator();

    private NaturalOrderComparator() {
    }

    /* renamed from: a */
    public int compare(Comparable<Object> comparable, Comparable<Object> comparable2) {
        Intrinsics.f(comparable, a.f20042a);
        Intrinsics.f(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    public final Comparator<Comparable<Object>> reversed() {
        return ReverseOrderComparator.f40350b;
    }
}
