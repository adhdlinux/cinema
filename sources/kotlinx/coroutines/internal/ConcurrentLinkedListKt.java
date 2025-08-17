package kotlinx.coroutines.internal;

public final class ConcurrentLinkedListKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f40721a = new Symbol("CLOSED");

    /* JADX WARNING: type inference failed for: r7v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super S, ? extends S>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S extends kotlinx.coroutines.internal.Segment<S>> java.lang.Object b(S r4, long r5, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super S, ? extends S> r7) {
        /*
        L_0x0000:
            long r0 = r4.f40770d
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x0012
            boolean r0 = r4.h()
            if (r0 == 0) goto L_0x000d
            goto L_0x0012
        L_0x000d:
            java.lang.Object r4 = kotlinx.coroutines.internal.SegmentOrClosed.a(r4)
            return r4
        L_0x0012:
            java.lang.Object r0 = r4.f()
            kotlinx.coroutines.internal.Symbol r1 = f40721a
            if (r0 != r1) goto L_0x0023
            kotlinx.coroutines.internal.Symbol r4 = f40721a
            java.lang.Object r4 = kotlinx.coroutines.internal.SegmentOrClosed.a(r4)
            return r4
        L_0x0023:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r0
            kotlinx.coroutines.internal.Segment r0 = (kotlinx.coroutines.internal.Segment) r0
            if (r0 == 0) goto L_0x002b
        L_0x0029:
            r4 = r0
            goto L_0x0000
        L_0x002b:
            long r0 = r4.f40770d
            r2 = 1
            long r0 = r0 + r2
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.Object r0 = r7.invoke(r0, r4)
            kotlinx.coroutines.internal.Segment r0 = (kotlinx.coroutines.internal.Segment) r0
            boolean r1 = r4.k(r0)
            if (r1 == 0) goto L_0x0000
            boolean r1 = r4.h()
            if (r1 == 0) goto L_0x0029
            r4.j()
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ConcurrentLinkedListKt.b(kotlinx.coroutines.internal.Segment, long, kotlin.jvm.functions.Function2):java.lang.Object");
    }
}
