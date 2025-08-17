package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;

public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private int f40525b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f40526c;

    /* renamed from: d  reason: collision with root package name */
    private int f40527d;

    /* renamed from: e  reason: collision with root package name */
    private IntRange f40528e;

    /* renamed from: f  reason: collision with root package name */
    private int f40529f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ DelimitedRangesSequence f40530g;

    DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        this.f40530g = delimitedRangesSequence;
        int f2 = RangesKt___RangesKt.f(delimitedRangesSequence.f40522b, 0, delimitedRangesSequence.f40521a.length());
        this.f40526c = f2;
        this.f40527d = f2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if (r0 < r6.f40530g.f40523c) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r6 = this;
            int r0 = r6.f40527d
            r1 = 0
            if (r0 >= 0) goto L_0x000c
            r6.f40525b = r1
            r0 = 0
            r6.f40528e = r0
            goto L_0x009e
        L_0x000c:
            kotlin.text.DelimitedRangesSequence r0 = r6.f40530g
            int r0 = r0.f40523c
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L_0x0023
            int r0 = r6.f40529f
            int r0 = r0 + r3
            r6.f40529f = r0
            kotlin.text.DelimitedRangesSequence r4 = r6.f40530g
            int r4 = r4.f40523c
            if (r0 >= r4) goto L_0x0031
        L_0x0023:
            int r0 = r6.f40527d
            kotlin.text.DelimitedRangesSequence r4 = r6.f40530g
            java.lang.CharSequence r4 = r4.f40521a
            int r4 = r4.length()
            if (r0 <= r4) goto L_0x0047
        L_0x0031:
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.f40526c
            kotlin.text.DelimitedRangesSequence r4 = r6.f40530g
            java.lang.CharSequence r4 = r4.f40521a
            int r4 = kotlin.text.StringsKt__StringsKt.Q(r4)
            r0.<init>(r1, r4)
            r6.f40528e = r0
            r6.f40527d = r2
            goto L_0x009c
        L_0x0047:
            kotlin.text.DelimitedRangesSequence r0 = r6.f40530g
            kotlin.jvm.functions.Function2 r0 = r0.f40524d
            kotlin.text.DelimitedRangesSequence r4 = r6.f40530g
            java.lang.CharSequence r4 = r4.f40521a
            int r5 = r6.f40527d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.invoke(r4, r5)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L_0x0077
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.f40526c
            kotlin.text.DelimitedRangesSequence r4 = r6.f40530g
            java.lang.CharSequence r4 = r4.f40521a
            int r4 = kotlin.text.StringsKt__StringsKt.Q(r4)
            r0.<init>(r1, r4)
            r6.f40528e = r0
            r6.f40527d = r2
            goto L_0x009c
        L_0x0077:
            java.lang.Object r2 = r0.a()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.b()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.f40526c
            kotlin.ranges.IntRange r4 = kotlin.ranges.RangesKt___RangesKt.j(r4, r2)
            r6.f40528e = r4
            int r2 = r2 + r0
            r6.f40526c = r2
            if (r0 != 0) goto L_0x0099
            r1 = 1
        L_0x0099:
            int r2 = r2 + r1
            r6.f40527d = r2
        L_0x009c:
            r6.f40525b = r3
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence$iterator$1.a():void");
    }

    /* renamed from: b */
    public IntRange next() {
        if (this.f40525b == -1) {
            a();
        }
        if (this.f40525b != 0) {
            IntRange intRange = this.f40528e;
            Intrinsics.d(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f40528e = null;
            this.f40525b = -1;
            return intRange;
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        if (this.f40525b == -1) {
            a();
        }
        if (this.f40525b == 1) {
            return true;
        }
        return false;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
