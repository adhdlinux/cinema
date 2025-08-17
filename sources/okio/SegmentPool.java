package okio;

import java.util.concurrent.atomic.AtomicReference;

public final class SegmentPool {

    /* renamed from: a  reason: collision with root package name */
    public static final SegmentPool f41384a = new SegmentPool();

    /* renamed from: b  reason: collision with root package name */
    private static final int f41385b = 65536;

    /* renamed from: c  reason: collision with root package name */
    private static final Segment f41386c = new Segment(new byte[0], 0, 0, false, false);

    /* renamed from: d  reason: collision with root package name */
    private static final int f41387d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReference<Segment>[] f41388e;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f41387d = highestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i2 = 0; i2 < highestOneBit; i2++) {
            atomicReferenceArr[i2] = new AtomicReference<>();
        }
        f41388e = atomicReferenceArr;
    }

    private SegmentPool() {
    }

    private final AtomicReference<Segment> a() {
        return f41388e[(int) (Thread.currentThread().getId() & (((long) f41387d) - 1))];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        r0 = f41384a.a();
        r2 = f41386c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(okio.Segment r5) {
        /*
            java.lang.String r0 = "segment"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            okio.Segment r0 = r5.f41382f
            r1 = 0
            if (r0 != 0) goto L_0x0010
            okio.Segment r0 = r5.f41383g
            if (r0 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 == 0) goto L_0x0043
            boolean r0 = r5.f41380d
            if (r0 == 0) goto L_0x0018
            return
        L_0x0018:
            okio.SegmentPool r0 = f41384a
            java.util.concurrent.atomic.AtomicReference r0 = r0.a()
            okio.Segment r2 = f41386c
            java.lang.Object r3 = r0.getAndSet(r2)
            okio.Segment r3 = (okio.Segment) r3
            if (r3 != r2) goto L_0x0029
            return
        L_0x0029:
            if (r3 == 0) goto L_0x002e
            int r2 = r3.f41379c
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            int r4 = f41385b
            if (r2 < r4) goto L_0x0037
            r0.set(r3)
            return
        L_0x0037:
            r5.f41382f = r3
            r5.f41378b = r1
            int r2 = r2 + 8192
            r5.f41379c = r2
            r0.set(r5)
            return
        L_0x0043:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Failed requirement."
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.SegmentPool.b(okio.Segment):void");
    }

    public static final Segment c() {
        AtomicReference<Segment> a2 = f41384a.a();
        Segment segment = f41386c;
        Segment andSet = a2.getAndSet(segment);
        if (andSet == segment) {
            return new Segment();
        }
        if (andSet == null) {
            a2.set((Object) null);
            return new Segment();
        }
        a2.set(andSet.f41382f);
        andSet.f41382f = null;
        andSet.f41379c = 0;
        return andSet;
    }
}
