package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodTimeline extends Timeline {

    /* renamed from: t  reason: collision with root package name */
    private static final Object f25946t = new Object();

    /* renamed from: u  reason: collision with root package name */
    private static final MediaItem f25947u = new MediaItem.Builder().d("SinglePeriodTimeline").i(Uri.EMPTY).a();

    /* renamed from: g  reason: collision with root package name */
    private final long f25948g;

    /* renamed from: h  reason: collision with root package name */
    private final long f25949h;

    /* renamed from: i  reason: collision with root package name */
    private final long f25950i;

    /* renamed from: j  reason: collision with root package name */
    private final long f25951j;

    /* renamed from: k  reason: collision with root package name */
    private final long f25952k;

    /* renamed from: l  reason: collision with root package name */
    private final long f25953l;

    /* renamed from: m  reason: collision with root package name */
    private final long f25954m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f25955n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f25956o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f25957p;

    /* renamed from: q  reason: collision with root package name */
    private final Object f25958q;

    /* renamed from: r  reason: collision with root package name */
    private final MediaItem f25959r;

    /* renamed from: s  reason: collision with root package name */
    private final MediaItem.LiveConfiguration f25960s;

    public SinglePeriodTimeline(long j2, boolean z2, boolean z3, boolean z4, Object obj, MediaItem mediaItem) {
        this(j2, j2, 0, 0, z2, z3, z4, obj, mediaItem);
    }

    public int f(Object obj) {
        return f25946t.equals(obj) ? 0 : -1;
    }

    public Timeline.Period k(int i2, Timeline.Period period, boolean z2) {
        Object obj;
        Assertions.c(i2, 0, 1);
        if (z2) {
            obj = f25946t;
        } else {
            obj = null;
        }
        return period.u((Object) null, obj, 0, this.f25951j, -this.f25953l);
    }

    public int m() {
        return 1;
    }

    public Object q(int i2) {
        Assertions.c(i2, 0, 1);
        return f25946t;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r1 > r3) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.Timeline.Window s(int r25, com.google.android.exoplayer2.Timeline.Window r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            com.google.android.exoplayer2.util.Assertions.c(r3, r1, r2)
            long r1 = r0.f25954m
            boolean r14 = r0.f25956o
            if (r14 == 0) goto L_0x002e
            boolean r3 = r0.f25957p
            if (r3 != 0) goto L_0x002e
            r3 = 0
            int r5 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x002e
            long r3 = r0.f25952k
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
            java.lang.Object r4 = com.google.android.exoplayer2.Timeline.Window.f23503s
            com.google.android.exoplayer2.MediaItem r5 = r0.f25959r
            java.lang.Object r6 = r0.f25958q
            long r7 = r0.f25948g
            long r9 = r0.f25949h
            long r11 = r0.f25950i
            boolean r13 = r0.f25955n
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r15 = r0.f25960s
            long r1 = r0.f25952k
            r18 = r1
            r20 = 0
            r21 = 0
            long r1 = r0.f25953l
            r22 = r1
            r3 = r26
            com.google.android.exoplayer2.Timeline$Window r1 = r3.i(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SinglePeriodTimeline.s(int, com.google.android.exoplayer2.Timeline$Window, long):com.google.android.exoplayer2.Timeline$Window");
    }

    public int t() {
        return 1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SinglePeriodTimeline(long j2, long j3, long j4, long j5, boolean z2, boolean z3, boolean z4, Object obj, MediaItem mediaItem) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j2, j3, j4, j5, z2, z3, false, obj, mediaItem, z4 ? mediaItem.f23131e : null);
    }

    public SinglePeriodTimeline(long j2, long j3, long j4, long j5, long j6, long j7, long j8, boolean z2, boolean z3, boolean z4, Object obj, MediaItem mediaItem, MediaItem.LiveConfiguration liveConfiguration) {
        this.f25948g = j2;
        this.f25949h = j3;
        this.f25950i = j4;
        this.f25951j = j5;
        this.f25952k = j6;
        this.f25953l = j7;
        this.f25954m = j8;
        this.f25955n = z2;
        this.f25956o = z3;
        this.f25957p = z4;
        this.f25958q = obj;
        this.f25959r = (MediaItem) Assertions.e(mediaItem);
        this.f25960s = liveConfiguration;
    }
}
