package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;

public final class SinglePeriodTimeline extends Timeline {

    /* renamed from: r  reason: collision with root package name */
    private static final Object f7117r = new Object();

    /* renamed from: s  reason: collision with root package name */
    private static final MediaItem f7118s = new MediaItem.Builder().c("SinglePeriodTimeline").g(Uri.EMPTY).a();

    /* renamed from: e  reason: collision with root package name */
    private final long f7119e;

    /* renamed from: f  reason: collision with root package name */
    private final long f7120f;

    /* renamed from: g  reason: collision with root package name */
    private final long f7121g;

    /* renamed from: h  reason: collision with root package name */
    private final long f7122h;

    /* renamed from: i  reason: collision with root package name */
    private final long f7123i;

    /* renamed from: j  reason: collision with root package name */
    private final long f7124j;

    /* renamed from: k  reason: collision with root package name */
    private final long f7125k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f7126l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f7127m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f7128n;

    /* renamed from: o  reason: collision with root package name */
    private final Object f7129o;

    /* renamed from: p  reason: collision with root package name */
    private final MediaItem f7130p;

    /* renamed from: q  reason: collision with root package name */
    private final MediaItem.LiveConfiguration f7131q;

    public SinglePeriodTimeline(long j2, boolean z2, boolean z3, boolean z4, Object obj, MediaItem mediaItem) {
        this(j2, j2, 0, 0, z2, z3, z4, obj, mediaItem);
    }

    public int b(Object obj) {
        return f7117r.equals(obj) ? 0 : -1;
    }

    public Timeline.Period g(int i2, Timeline.Period period, boolean z2) {
        Object obj;
        Assertions.c(i2, 0, 1);
        if (z2) {
            obj = f7117r;
        } else {
            obj = null;
        }
        return period.s((Object) null, obj, 0, this.f7122h, -this.f7124j);
    }

    public int i() {
        return 1;
    }

    public Object m(int i2) {
        Assertions.c(i2, 0, 1);
        return f7117r;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r1 > r3) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.common.Timeline.Window o(int r25, androidx.media3.common.Timeline.Window r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            androidx.media3.common.util.Assertions.c(r3, r1, r2)
            long r1 = r0.f7125k
            boolean r14 = r0.f7127m
            if (r14 == 0) goto L_0x002e
            boolean r3 = r0.f7128n
            if (r3 != 0) goto L_0x002e
            r3 = 0
            int r5 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x002e
            long r3 = r0.f7123i
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0027
        L_0x0024:
            r16 = r5
            goto L_0x0030
        L_0x0027:
            long r1 = r1 + r27
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x002e
            goto L_0x0024
        L_0x002e:
            r16 = r1
        L_0x0030:
            java.lang.Object r4 = androidx.media3.common.Timeline.Window.f4362q
            androidx.media3.common.MediaItem r5 = r0.f7130p
            java.lang.Object r6 = r0.f7129o
            long r7 = r0.f7119e
            long r9 = r0.f7120f
            long r11 = r0.f7121g
            boolean r13 = r0.f7126l
            androidx.media3.common.MediaItem$LiveConfiguration r15 = r0.f7131q
            long r1 = r0.f7123i
            r18 = r1
            r20 = 0
            r21 = 0
            long r1 = r0.f7124j
            r22 = r1
            r3 = r26
            androidx.media3.common.Timeline$Window r1 = r3.g(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SinglePeriodTimeline.o(int, androidx.media3.common.Timeline$Window, long):androidx.media3.common.Timeline$Window");
    }

    public int p() {
        return 1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SinglePeriodTimeline(long j2, long j3, long j4, long j5, boolean z2, boolean z3, boolean z4, Object obj, MediaItem mediaItem) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j2, j3, j4, j5, z2, z3, false, obj, mediaItem, z4 ? mediaItem.f4081d : null);
    }

    public SinglePeriodTimeline(long j2, long j3, long j4, long j5, long j6, long j7, long j8, boolean z2, boolean z3, boolean z4, Object obj, MediaItem mediaItem, MediaItem.LiveConfiguration liveConfiguration) {
        this.f7119e = j2;
        this.f7120f = j3;
        this.f7121g = j4;
        this.f7122h = j5;
        this.f7123i = j6;
        this.f7124j = j7;
        this.f7125k = j8;
        this.f7126l = z2;
        this.f7127m = z3;
        this.f7128n = z4;
        this.f7129o = obj;
        this.f7130p = (MediaItem) Assertions.f(mediaItem);
        this.f7131q = liveConfiguration;
    }
}
