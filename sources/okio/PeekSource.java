package okio;

import kotlin.jvm.internal.Intrinsics;

public final class PeekSource implements Source {

    /* renamed from: b  reason: collision with root package name */
    private final BufferedSource f41362b;

    /* renamed from: c  reason: collision with root package name */
    private final Buffer f41363c;

    /* renamed from: d  reason: collision with root package name */
    private Segment f41364d;

    /* renamed from: e  reason: collision with root package name */
    private int f41365e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f41366f;

    /* renamed from: g  reason: collision with root package name */
    private long f41367g;

    public PeekSource(BufferedSource bufferedSource) {
        int i2;
        Intrinsics.f(bufferedSource, "upstream");
        this.f41362b = bufferedSource;
        Buffer c2 = bufferedSource.c();
        this.f41363c = c2;
        Segment segment = c2.f41320b;
        this.f41364d = segment;
        if (segment != null) {
            i2 = segment.f41378b;
        } else {
            i2 = -1;
        }
        this.f41365e = i2;
    }

    public void close() {
        this.f41366f = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r5 == r6.f41378b) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long read(okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            r0 = 0
            r1 = 1
            r2 = 0
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x000f
            r5 = 1
            goto L_0x0010
        L_0x000f:
            r5 = 0
        L_0x0010:
            if (r5 == 0) goto L_0x0087
            boolean r5 = r8.f41366f
            r5 = r5 ^ r1
            if (r5 == 0) goto L_0x007b
            okio.Segment r5 = r8.f41364d
            if (r5 == 0) goto L_0x002a
            okio.Buffer r6 = r8.f41363c
            okio.Segment r6 = r6.f41320b
            if (r5 != r6) goto L_0x002b
            int r5 = r8.f41365e
            kotlin.jvm.internal.Intrinsics.c(r6)
            int r6 = r6.f41378b
            if (r5 != r6) goto L_0x002b
        L_0x002a:
            r0 = 1
        L_0x002b:
            if (r0 == 0) goto L_0x006f
            if (r4 != 0) goto L_0x0030
            return r2
        L_0x0030:
            okio.BufferedSource r0 = r8.f41362b
            long r1 = r8.f41367g
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L_0x0040
            r9 = -1
            return r9
        L_0x0040:
            okio.Segment r0 = r8.f41364d
            if (r0 != 0) goto L_0x0053
            okio.Buffer r0 = r8.f41363c
            okio.Segment r0 = r0.f41320b
            if (r0 == 0) goto L_0x0053
            r8.f41364d = r0
            kotlin.jvm.internal.Intrinsics.c(r0)
            int r0 = r0.f41378b
            r8.f41365e = r0
        L_0x0053:
            okio.Buffer r0 = r8.f41363c
            long r0 = r0.size()
            long r2 = r8.f41367g
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            okio.Buffer r2 = r8.f41363c
            long r4 = r8.f41367g
            r3 = r9
            r6 = r10
            r2.q(r3, r4, r6)
            long r0 = r8.f41367g
            long r0 = r0 + r10
            r8.f41367g = r0
            return r10
        L_0x006f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x007b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0087:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "byteCount < 0: "
            r9.append(r0)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.PeekSource.read(okio.Buffer, long):long");
    }

    public Timeout timeout() {
        return this.f41362b.timeout();
    }
}
