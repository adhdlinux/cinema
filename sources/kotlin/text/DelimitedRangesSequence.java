package kotlin.text;

import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

final class DelimitedRangesSequence implements Sequence<IntRange> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f40521a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f40522b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f40523c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Function2<CharSequence, Integer, Pair<Integer, Integer>> f40524d;

    public DelimitedRangesSequence(CharSequence charSequence, int i2, int i3, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        Intrinsics.f(charSequence, "input");
        Intrinsics.f(function2, "getNextMatch");
        this.f40521a = charSequence;
        this.f40522b = i2;
        this.f40523c = i3;
        this.f40524d = function2;
    }

    public Iterator<IntRange> iterator() {
        return new DelimitedRangesSequence$iterator$1(this);
    }
}
