package com.google.android.exoplayer2;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.common.collect.ImmutableList;

final class MediaPeriodQueue {

    /* renamed from: a  reason: collision with root package name */
    private final Timeline.Period f23328a = new Timeline.Period();

    /* renamed from: b  reason: collision with root package name */
    private final Timeline.Window f23329b = new Timeline.Window();

    /* renamed from: c  reason: collision with root package name */
    private final AnalyticsCollector f23330c;

    /* renamed from: d  reason: collision with root package name */
    private final HandlerWrapper f23331d;

    /* renamed from: e  reason: collision with root package name */
    private long f23332e;

    /* renamed from: f  reason: collision with root package name */
    private int f23333f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f23334g;

    /* renamed from: h  reason: collision with root package name */
    private MediaPeriodHolder f23335h;

    /* renamed from: i  reason: collision with root package name */
    private MediaPeriodHolder f23336i;

    /* renamed from: j  reason: collision with root package name */
    private MediaPeriodHolder f23337j;

    /* renamed from: k  reason: collision with root package name */
    private int f23338k;

    /* renamed from: l  reason: collision with root package name */
    private Object f23339l;

    /* renamed from: m  reason: collision with root package name */
    private long f23340m;

    public MediaPeriodQueue(AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper) {
        this.f23330c = analyticsCollector;
        this.f23331d = handlerWrapper;
    }

    private static MediaSource.MediaPeriodId A(Timeline timeline, Object obj, long j2, long j3, Timeline.Window window, Timeline.Period period) {
        timeline.l(obj, period);
        timeline.r(period.f23494d, window);
        int f2 = timeline.f(obj);
        Object obj2 = obj;
        while (period.f23495e == 0 && period.f() > 0 && period.t(period.r()) && period.h(0) == -1) {
            int i2 = f2 + 1;
            if (f2 >= window.f23526q) {
                break;
            }
            timeline.k(i2, period, true);
            obj2 = Assertions.e(period.f23493c);
            f2 = i2;
        }
        timeline.l(obj2, period);
        int h2 = period.h(j2);
        if (h2 == -1) {
            return new MediaSource.MediaPeriodId(obj2, j3, period.g(j2));
        }
        return new MediaSource.MediaPeriodId(obj2, h2, period.n(h2), j3);
    }

    private long C(Timeline timeline, Object obj) {
        int f2;
        int i2 = timeline.l(obj, this.f23328a).f23494d;
        Object obj2 = this.f23339l;
        if (obj2 != null && (f2 = timeline.f(obj2)) != -1 && timeline.j(f2, this.f23328a).f23494d == i2) {
            return this.f23340m;
        }
        for (MediaPeriodHolder mediaPeriodHolder = this.f23335h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.j()) {
            if (mediaPeriodHolder.f23305b.equals(obj)) {
                return mediaPeriodHolder.f23309f.f23319a.f25796d;
            }
        }
        for (MediaPeriodHolder mediaPeriodHolder2 = this.f23335h; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.j()) {
            int f3 = timeline.f(mediaPeriodHolder2.f23305b);
            if (f3 != -1 && timeline.j(f3, this.f23328a).f23494d == i2) {
                return mediaPeriodHolder2.f23309f.f23319a.f25796d;
            }
        }
        long j2 = this.f23332e;
        this.f23332e = 1 + j2;
        if (this.f23335h == null) {
            this.f23339l = obj;
            this.f23340m = j2;
        }
        return j2;
    }

    private boolean E(Timeline timeline) {
        MediaPeriodHolder mediaPeriodHolder = this.f23335h;
        if (mediaPeriodHolder == null) {
            return true;
        }
        int f2 = timeline.f(mediaPeriodHolder.f23305b);
        while (true) {
            f2 = timeline.h(f2, this.f23328a, this.f23329b, this.f23333f, this.f23334g);
            while (mediaPeriodHolder.j() != null && !mediaPeriodHolder.f23309f.f23325g) {
                mediaPeriodHolder = mediaPeriodHolder.j();
            }
            MediaPeriodHolder j2 = mediaPeriodHolder.j();
            if (f2 == -1 || j2 == null || timeline.f(j2.f23305b) != f2) {
                boolean z2 = z(mediaPeriodHolder);
                mediaPeriodHolder.f23309f = r(timeline, mediaPeriodHolder.f23309f);
            } else {
                mediaPeriodHolder = j2;
            }
        }
        boolean z22 = z(mediaPeriodHolder);
        mediaPeriodHolder.f23309f = r(timeline, mediaPeriodHolder.f23309f);
        return !z22;
    }

    private boolean d(long j2, long j3) {
        return j2 == -9223372036854775807L || j2 == j3;
    }

    private boolean e(MediaPeriodInfo mediaPeriodInfo, MediaPeriodInfo mediaPeriodInfo2) {
        return mediaPeriodInfo.f23320b == mediaPeriodInfo2.f23320b && mediaPeriodInfo.f23319a.equals(mediaPeriodInfo2.f23319a);
    }

    private MediaPeriodInfo h(PlaybackInfo playbackInfo) {
        return k(playbackInfo.f23377a, playbackInfo.f23378b, playbackInfo.f23379c, playbackInfo.f23394r);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00cc, code lost:
        if (r0.t(r0.r()) != false) goto L_0x00d0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.MediaPeriodInfo i(com.google.android.exoplayer2.Timeline r20, com.google.android.exoplayer2.MediaPeriodHolder r21, long r22) {
        /*
            r19 = this;
            r9 = r19
            r8 = r20
            r10 = r21
            com.google.android.exoplayer2.MediaPeriodInfo r11 = r10.f23309f
            long r0 = r21.l()
            long r2 = r11.f23323e
            long r0 = r0 + r2
            long r6 = r0 - r22
            boolean r0 = r11.f23325g
            r13 = -1
            r14 = 1
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r17 = 0
            if (r0 == 0) goto L_0x00ef
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r11.f23319a
            java.lang.Object r0 = r0.f25793a
            int r1 = r8.f(r0)
            com.google.android.exoplayer2.Timeline$Period r2 = r9.f23328a
            com.google.android.exoplayer2.Timeline$Window r3 = r9.f23329b
            int r0 = r9.f23333f
            boolean r5 = r9.f23334g
            r4 = r0
            r0 = r20
            int r0 = r0.h(r1, r2, r3, r4, r5)
            if (r0 != r13) goto L_0x0038
            return r17
        L_0x0038:
            com.google.android.exoplayer2.Timeline$Period r1 = r9.f23328a
            com.google.android.exoplayer2.Timeline$Period r1 = r8.k(r0, r1, r14)
            int r3 = r1.f23494d
            com.google.android.exoplayer2.Timeline$Period r1 = r9.f23328a
            java.lang.Object r1 = r1.f23493c
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.e(r1)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r11.f23319a
            long r4 = r2.f25796d
            com.google.android.exoplayer2.Timeline$Window r2 = r9.f23329b
            com.google.android.exoplayer2.Timeline$Window r2 = r8.r(r3, r2)
            int r2 = r2.f23525p
            if (r2 != r0) goto L_0x0099
            com.google.android.exoplayer2.Timeline$Window r1 = r9.f23329b
            com.google.android.exoplayer2.Timeline$Period r2 = r9.f23328a
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r12 = 0
            long r6 = java.lang.Math.max(r12, r6)
            r0 = r20
            android.util.Pair r0 = r0.o(r1, r2, r3, r4, r6)
            if (r0 != 0) goto L_0x006e
            return r17
        L_0x006e:
            java.lang.Object r1 = r0.first
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r4 = r0.longValue()
            com.google.android.exoplayer2.MediaPeriodHolder r0 = r21.j()
            if (r0 == 0) goto L_0x008d
            java.lang.Object r2 = r0.f23305b
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x008d
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.f23309f
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.f23319a
            long r2 = r0.f25796d
            goto L_0x0094
        L_0x008d:
            long r2 = r9.f23332e
            r6 = 1
            long r6 = r6 + r2
            r9.f23332e = r6
        L_0x0094:
            r12 = r4
            r17 = r15
            r4 = r2
            goto L_0x009d
        L_0x0099:
            r12 = 0
            r17 = r12
        L_0x009d:
            com.google.android.exoplayer2.Timeline$Window r6 = r9.f23329b
            com.google.android.exoplayer2.Timeline$Period r7 = r9.f23328a
            r0 = r20
            r2 = r12
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = A(r0, r1, r2, r4, r6, r7)
            int r0 = (r17 > r15 ? 1 : (r17 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x00e3
            long r0 = r11.f23321c
            int r3 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r3 == 0) goto L_0x00e3
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r11.f23319a
            java.lang.Object r0 = r0.f25793a
            com.google.android.exoplayer2.Timeline$Period r1 = r9.f23328a
            com.google.android.exoplayer2.Timeline$Period r0 = r8.l(r0, r1)
            int r0 = r0.f()
            if (r0 <= 0) goto L_0x00cf
            com.google.android.exoplayer2.Timeline$Period r0 = r9.f23328a
            int r1 = r0.r()
            boolean r0 = r0.t(r1)
            if (r0 == 0) goto L_0x00cf
            goto L_0x00d0
        L_0x00cf:
            r14 = 0
        L_0x00d0:
            boolean r0 = r2.b()
            if (r0 == 0) goto L_0x00dd
            if (r14 == 0) goto L_0x00dd
            long r0 = r11.f23321c
            r3 = r0
            r5 = r12
            goto L_0x00e6
        L_0x00dd:
            if (r14 == 0) goto L_0x00e3
            long r0 = r11.f23321c
            r5 = r0
            goto L_0x00e4
        L_0x00e3:
            r5 = r12
        L_0x00e4:
            r3 = r17
        L_0x00e6:
            r0 = r19
            r1 = r20
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.k(r1, r2, r3, r5)
            return r0
        L_0x00ef:
            r0 = -1
            r12 = 0
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r10 = r11.f23319a
            java.lang.Object r1 = r10.f25793a
            com.google.android.exoplayer2.Timeline$Period r2 = r9.f23328a
            r8.l(r1, r2)
            boolean r1 = r10.b()
            if (r1 == 0) goto L_0x016b
            int r3 = r10.f25794b
            com.google.android.exoplayer2.Timeline$Period r1 = r9.f23328a
            int r1 = r1.d(r3)
            if (r1 != r0) goto L_0x010c
            return r17
        L_0x010c:
            com.google.android.exoplayer2.Timeline$Period r0 = r9.f23328a
            int r2 = r10.f25795c
            int r4 = r0.o(r3, r2)
            if (r4 >= r1) goto L_0x0126
            java.lang.Object r2 = r10.f25793a
            long r5 = r11.f23321c
            long r10 = r10.f25796d
            r0 = r19
            r1 = r20
            r7 = r10
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.l(r1, r2, r3, r4, r5, r7)
            return r0
        L_0x0126:
            long r0 = r11.f23321c
            int r2 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x014c
            com.google.android.exoplayer2.Timeline$Window r1 = r9.f23329b
            com.google.android.exoplayer2.Timeline$Period r2 = r9.f23328a
            int r3 = r2.f23494d
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r6 = java.lang.Math.max(r12, r6)
            r0 = r20
            android.util.Pair r0 = r0.o(r1, r2, r3, r4, r6)
            if (r0 != 0) goto L_0x0144
            return r17
        L_0x0144:
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
        L_0x014c:
            java.lang.Object r2 = r10.f25793a
            int r3 = r10.f25794b
            long r2 = r9.n(r8, r2, r3)
            java.lang.Object r4 = r10.f25793a
            long r5 = java.lang.Math.max(r2, r0)
            long r11 = r11.f23321c
            long r13 = r10.f25796d
            r0 = r19
            r1 = r20
            r2 = r4
            r3 = r5
            r5 = r11
            r7 = r13
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.m(r1, r2, r3, r5, r7)
            return r0
        L_0x016b:
            com.google.android.exoplayer2.Timeline$Period r0 = r9.f23328a
            int r1 = r10.f25797e
            int r4 = r0.n(r1)
            com.google.android.exoplayer2.Timeline$Period r0 = r9.f23328a
            int r1 = r10.f25797e
            boolean r0 = r0.t(r1)
            if (r0 == 0) goto L_0x018a
            com.google.android.exoplayer2.Timeline$Period r0 = r9.f23328a
            int r1 = r10.f25797e
            int r0 = r0.k(r1, r4)
            r1 = 3
            if (r0 != r1) goto L_0x018a
            r12 = 1
            goto L_0x018b
        L_0x018a:
            r12 = 0
        L_0x018b:
            com.google.android.exoplayer2.Timeline$Period r0 = r9.f23328a
            int r1 = r10.f25797e
            int r0 = r0.d(r1)
            if (r4 == r0) goto L_0x01aa
            if (r12 == 0) goto L_0x0198
            goto L_0x01aa
        L_0x0198:
            java.lang.Object r2 = r10.f25793a
            int r3 = r10.f25797e
            long r5 = r11.f23323e
            long r10 = r10.f25796d
            r0 = r19
            r1 = r20
            r7 = r10
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.l(r1, r2, r3, r4, r5, r7)
            return r0
        L_0x01aa:
            java.lang.Object r0 = r10.f25793a
            int r1 = r10.f25797e
            long r3 = r9.n(r8, r0, r1)
            java.lang.Object r2 = r10.f25793a
            long r5 = r11.f23323e
            long r10 = r10.f25796d
            r0 = r19
            r1 = r20
            r7 = r10
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.m(r1, r2, r3, r5, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaPeriodQueue.i(com.google.android.exoplayer2.Timeline, com.google.android.exoplayer2.MediaPeriodHolder, long):com.google.android.exoplayer2.MediaPeriodInfo");
    }

    private MediaPeriodInfo k(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3) {
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        Timeline timeline2 = timeline;
        timeline.l(mediaPeriodId2.f25793a, this.f23328a);
        if (mediaPeriodId.b()) {
            return l(timeline, mediaPeriodId2.f25793a, mediaPeriodId2.f25794b, mediaPeriodId2.f25795c, j2, mediaPeriodId2.f25796d);
        }
        return m(timeline, mediaPeriodId2.f25793a, j3, j2, mediaPeriodId2.f25796d);
    }

    private MediaPeriodInfo l(Timeline timeline, Object obj, int i2, int i3, long j2, long j3) {
        long j4;
        long j5;
        int i4 = i3;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i2, i4, j3);
        long e2 = timeline.l(mediaPeriodId.f25793a, this.f23328a).e(mediaPeriodId.f25794b, mediaPeriodId.f25795c);
        if (i4 == this.f23328a.n(i2)) {
            j4 = this.f23328a.j();
        } else {
            j4 = 0;
        }
        boolean t2 = this.f23328a.t(mediaPeriodId.f25794b);
        if (e2 == -9223372036854775807L || j4 < e2) {
            j5 = j4;
        } else {
            j5 = Math.max(0, e2 - 1);
        }
        return new MediaPeriodInfo(mediaPeriodId, j5, j2, -9223372036854775807L, e2, t2, false, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
        if (r9.t(r9.r()) != false) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.MediaPeriodInfo m(com.google.android.exoplayer2.Timeline r25, java.lang.Object r26, long r27, long r29, long r31) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            com.google.android.exoplayer2.Timeline$Period r5 = r0.f23328a
            r1.l(r2, r5)
            com.google.android.exoplayer2.Timeline$Period r5 = r0.f23328a
            int r5 = r5.g(r3)
            r6 = 1
            r7 = 0
            r8 = -1
            if (r5 != r8) goto L_0x002d
            com.google.android.exoplayer2.Timeline$Period r9 = r0.f23328a
            int r9 = r9.f()
            if (r9 <= 0) goto L_0x004c
            com.google.android.exoplayer2.Timeline$Period r9 = r0.f23328a
            int r10 = r9.r()
            boolean r9 = r9.t(r10)
            if (r9 == 0) goto L_0x004c
            goto L_0x004a
        L_0x002d:
            com.google.android.exoplayer2.Timeline$Period r9 = r0.f23328a
            boolean r9 = r9.t(r5)
            if (r9 == 0) goto L_0x004c
            com.google.android.exoplayer2.Timeline$Period r9 = r0.f23328a
            long r9 = r9.i(r5)
            com.google.android.exoplayer2.Timeline$Period r11 = r0.f23328a
            long r12 = r11.f23495e
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x004c
            boolean r9 = r11.s(r5)
            if (r9 == 0) goto L_0x004c
            r5 = -1
        L_0x004a:
            r9 = 1
            goto L_0x004d
        L_0x004c:
            r9 = 0
        L_0x004d:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r11 = new com.google.android.exoplayer2.source.MediaSource$MediaPeriodId
            r12 = r31
            r11.<init>(r2, r12, r5)
            boolean r2 = r0.s(r11)
            boolean r22 = r0.u(r1, r11)
            boolean r23 = r0.t(r1, r11, r2)
            if (r5 == r8) goto L_0x006d
            com.google.android.exoplayer2.Timeline$Period r1 = r0.f23328a
            boolean r1 = r1.t(r5)
            if (r1 == 0) goto L_0x006d
            r20 = 1
            goto L_0x006f
        L_0x006d:
            r20 = 0
        L_0x006f:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == r8) goto L_0x007f
            com.google.android.exoplayer2.Timeline$Period r1 = r0.f23328a
            long r14 = r1.i(r5)
        L_0x007c:
            r16 = r14
            goto L_0x0088
        L_0x007f:
            if (r9 == 0) goto L_0x0086
            com.google.android.exoplayer2.Timeline$Period r1 = r0.f23328a
            long r14 = r1.f23495e
            goto L_0x007c
        L_0x0086:
            r16 = r12
        L_0x0088:
            int r1 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x0096
            r14 = -9223372036854775808
            int r1 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r1 != 0) goto L_0x0093
            goto L_0x0096
        L_0x0093:
            r18 = r16
            goto L_0x009c
        L_0x0096:
            com.google.android.exoplayer2.Timeline$Period r1 = r0.f23328a
            long r14 = r1.f23495e
            r18 = r14
        L_0x009c:
            int r1 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x00b3
            int r1 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r1 < 0) goto L_0x00b3
            if (r23 != 0) goto L_0x00aa
            if (r9 != 0) goto L_0x00a9
            goto L_0x00aa
        L_0x00a9:
            r6 = 0
        L_0x00aa:
            long r3 = (long) r6
            long r3 = r18 - r3
            r5 = 0
            long r3 = java.lang.Math.max(r5, r3)
        L_0x00b3:
            r12 = r3
            com.google.android.exoplayer2.MediaPeriodInfo r1 = new com.google.android.exoplayer2.MediaPeriodInfo
            r10 = r1
            r14 = r29
            r21 = r2
            r10.<init>(r11, r12, r14, r16, r18, r20, r21, r22, r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaPeriodQueue.m(com.google.android.exoplayer2.Timeline, java.lang.Object, long, long, long):com.google.android.exoplayer2.MediaPeriodInfo");
    }

    private long n(Timeline timeline, Object obj, int i2) {
        timeline.l(obj, this.f23328a);
        long i3 = this.f23328a.i(i2);
        if (i3 == Long.MIN_VALUE) {
            return this.f23328a.f23495e;
        }
        return i3 + this.f23328a.l(i2);
    }

    private boolean s(MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.b() && mediaPeriodId.f25797e == -1;
    }

    private boolean t(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z2) {
        int f2 = timeline.f(mediaPeriodId.f25793a);
        if (!timeline.r(timeline.j(f2, this.f23328a).f23494d, this.f23329b).f23519j) {
            if (!timeline.v(f2, this.f23328a, this.f23329b, this.f23333f, this.f23334g) || !z2) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean u(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (!s(mediaPeriodId)) {
            return false;
        }
        int i2 = timeline.l(mediaPeriodId.f25793a, this.f23328a).f23494d;
        if (timeline.r(i2, this.f23329b).f23526q == timeline.f(mediaPeriodId.f25793a)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f23330c.D(builder.k(), mediaPeriodId);
    }

    private void x() {
        MediaSource.MediaPeriodId mediaPeriodId;
        ImmutableList.Builder k2 = ImmutableList.k();
        for (MediaPeriodHolder mediaPeriodHolder = this.f23335h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.j()) {
            k2.d(mediaPeriodHolder.f23309f.f23319a);
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.f23336i;
        if (mediaPeriodHolder2 == null) {
            mediaPeriodId = null;
        } else {
            mediaPeriodId = mediaPeriodHolder2.f23309f.f23319a;
        }
        this.f23331d.g(new f1(this, k2, mediaPeriodId));
    }

    public MediaSource.MediaPeriodId B(Timeline timeline, Object obj, long j2) {
        long C = C(timeline, obj);
        timeline.l(obj, this.f23328a);
        timeline.r(this.f23328a.f23494d, this.f23329b);
        boolean z2 = false;
        for (int f2 = timeline.f(obj); f2 >= this.f23329b.f23525p; f2--) {
            boolean z3 = true;
            timeline.k(f2, this.f23328a, true);
            if (this.f23328a.f() <= 0) {
                z3 = false;
            }
            z2 |= z3;
            Timeline.Period period = this.f23328a;
            if (period.h(period.f23495e) != -1) {
                obj = Assertions.e(this.f23328a.f23493c);
            }
            if (z2 && (!z3 || this.f23328a.f23495e != 0)) {
                break;
            }
        }
        return A(timeline, obj, j2, C, this.f23329b, this.f23328a);
    }

    public boolean D() {
        MediaPeriodHolder mediaPeriodHolder = this.f23337j;
        if (mediaPeriodHolder == null || (!mediaPeriodHolder.f23309f.f23327i && mediaPeriodHolder.q() && this.f23337j.f23309f.f23323e != -9223372036854775807L && this.f23338k < 100)) {
            return true;
        }
        return false;
    }

    public boolean F(Timeline timeline, long j2, long j3) {
        MediaPeriodInfo mediaPeriodInfo;
        long j4;
        boolean z2;
        MediaPeriodHolder mediaPeriodHolder = null;
        for (MediaPeriodHolder mediaPeriodHolder2 = this.f23335h; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.j()) {
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder2.f23309f;
            if (mediaPeriodHolder == null) {
                mediaPeriodInfo = r(timeline, mediaPeriodInfo2);
            } else {
                MediaPeriodInfo i2 = i(timeline, mediaPeriodHolder, j2);
                if (i2 == null) {
                    return !z(mediaPeriodHolder);
                }
                if (!e(mediaPeriodInfo2, i2)) {
                    return !z(mediaPeriodHolder);
                }
                mediaPeriodInfo = i2;
            }
            mediaPeriodHolder2.f23309f = mediaPeriodInfo.a(mediaPeriodInfo2.f23321c);
            if (!d(mediaPeriodInfo2.f23323e, mediaPeriodInfo.f23323e)) {
                mediaPeriodHolder2.A();
                long j5 = mediaPeriodInfo.f23323e;
                if (j5 == -9223372036854775807L) {
                    j4 = Clock.MAX_TIME;
                } else {
                    j4 = mediaPeriodHolder2.z(j5);
                }
                if (mediaPeriodHolder2 != this.f23336i || mediaPeriodHolder2.f23309f.f23324f || (j3 != Long.MIN_VALUE && j3 < j4)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z(mediaPeriodHolder2) || z2) {
                    return false;
                }
                return true;
            }
            mediaPeriodHolder = mediaPeriodHolder2;
        }
        return true;
    }

    public boolean G(Timeline timeline, int i2) {
        this.f23333f = i2;
        return E(timeline);
    }

    public boolean H(Timeline timeline, boolean z2) {
        this.f23334g = z2;
        return E(timeline);
    }

    public MediaPeriodHolder b() {
        MediaPeriodHolder mediaPeriodHolder = this.f23335h;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.f23336i) {
            this.f23336i = mediaPeriodHolder.j();
        }
        this.f23335h.t();
        int i2 = this.f23338k - 1;
        this.f23338k = i2;
        if (i2 == 0) {
            this.f23337j = null;
            MediaPeriodHolder mediaPeriodHolder2 = this.f23335h;
            this.f23339l = mediaPeriodHolder2.f23305b;
            this.f23340m = mediaPeriodHolder2.f23309f.f23319a.f25796d;
        }
        this.f23335h = this.f23335h.j();
        x();
        return this.f23335h;
    }

    public MediaPeriodHolder c() {
        boolean z2;
        MediaPeriodHolder mediaPeriodHolder = this.f23336i;
        if (mediaPeriodHolder == null || mediaPeriodHolder.j() == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.g(z2);
        this.f23336i = this.f23336i.j();
        x();
        return this.f23336i;
    }

    public void f() {
        if (this.f23338k != 0) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.i(this.f23335h);
            this.f23339l = mediaPeriodHolder.f23305b;
            this.f23340m = mediaPeriodHolder.f23309f.f23319a.f25796d;
            while (mediaPeriodHolder != null) {
                mediaPeriodHolder.t();
                mediaPeriodHolder = mediaPeriodHolder.j();
            }
            this.f23335h = null;
            this.f23337j = null;
            this.f23336i = null;
            this.f23338k = 0;
            x();
        }
    }

    public MediaPeriodHolder g(RendererCapabilities[] rendererCapabilitiesArr, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        long j2;
        MediaPeriodHolder mediaPeriodHolder = this.f23337j;
        if (mediaPeriodHolder == null) {
            j2 = 1000000000000L;
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodInfo;
        } else {
            j2 = (mediaPeriodHolder.l() + this.f23337j.f23309f.f23323e) - mediaPeriodInfo.f23320b;
        }
        MediaPeriodHolder mediaPeriodHolder2 = new MediaPeriodHolder(rendererCapabilitiesArr, j2, trackSelector, allocator, mediaSourceList, mediaPeriodInfo, trackSelectorResult);
        MediaPeriodHolder mediaPeriodHolder3 = this.f23337j;
        if (mediaPeriodHolder3 != null) {
            mediaPeriodHolder3.w(mediaPeriodHolder2);
        } else {
            this.f23335h = mediaPeriodHolder2;
            this.f23336i = mediaPeriodHolder2;
        }
        this.f23339l = null;
        this.f23337j = mediaPeriodHolder2;
        this.f23338k++;
        x();
        return mediaPeriodHolder2;
    }

    public MediaPeriodHolder j() {
        return this.f23337j;
    }

    public MediaPeriodInfo o(long j2, PlaybackInfo playbackInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.f23337j;
        if (mediaPeriodHolder == null) {
            return h(playbackInfo);
        }
        return i(playbackInfo.f23377a, mediaPeriodHolder, j2);
    }

    public MediaPeriodHolder p() {
        return this.f23335h;
    }

    public MediaPeriodHolder q() {
        return this.f23336i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.MediaPeriodInfo r(com.google.android.exoplayer2.Timeline r19, com.google.android.exoplayer2.MediaPeriodInfo r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r2.f23319a
            boolean r12 = r0.s(r3)
            boolean r13 = r0.u(r1, r3)
            boolean r14 = r0.t(r1, r3, r12)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r4 = r2.f23319a
            java.lang.Object r4 = r4.f25793a
            com.google.android.exoplayer2.Timeline$Period r5 = r0.f23328a
            r1.l(r4, r5)
            boolean r1 = r3.b()
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0035
            int r1 = r3.f25797e
            if (r1 != r4) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            com.google.android.exoplayer2.Timeline$Period r7 = r0.f23328a
            long r7 = r7.i(r1)
            goto L_0x0036
        L_0x0035:
            r7 = r5
        L_0x0036:
            boolean r1 = r3.b()
            if (r1 == 0) goto L_0x0048
            com.google.android.exoplayer2.Timeline$Period r1 = r0.f23328a
            int r5 = r3.f25794b
            int r6 = r3.f25795c
            long r5 = r1.e(r5, r6)
        L_0x0046:
            r9 = r5
            goto L_0x005c
        L_0x0048:
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0055
            r5 = -9223372036854775808
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r9 = r7
            goto L_0x005c
        L_0x0055:
            com.google.android.exoplayer2.Timeline$Period r1 = r0.f23328a
            long r5 = r1.m()
            goto L_0x0046
        L_0x005c:
            boolean r1 = r3.b()
            if (r1 == 0) goto L_0x006c
            com.google.android.exoplayer2.Timeline$Period r1 = r0.f23328a
            int r4 = r3.f25794b
            boolean r1 = r1.t(r4)
            r11 = r1
            goto L_0x007d
        L_0x006c:
            int r1 = r3.f25797e
            if (r1 == r4) goto L_0x007b
            com.google.android.exoplayer2.Timeline$Period r4 = r0.f23328a
            boolean r1 = r4.t(r1)
            if (r1 == 0) goto L_0x007b
            r1 = 1
            r11 = 1
            goto L_0x007d
        L_0x007b:
            r1 = 0
            r11 = 0
        L_0x007d:
            com.google.android.exoplayer2.MediaPeriodInfo r15 = new com.google.android.exoplayer2.MediaPeriodInfo
            long r4 = r2.f23320b
            long r1 = r2.f23321c
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaPeriodQueue.r(com.google.android.exoplayer2.Timeline, com.google.android.exoplayer2.MediaPeriodInfo):com.google.android.exoplayer2.MediaPeriodInfo");
    }

    public boolean v(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.f23337j;
        return mediaPeriodHolder != null && mediaPeriodHolder.f23304a == mediaPeriod;
    }

    public void y(long j2) {
        MediaPeriodHolder mediaPeriodHolder = this.f23337j;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.s(j2);
        }
    }

    public boolean z(MediaPeriodHolder mediaPeriodHolder) {
        boolean z2;
        boolean z3 = false;
        if (mediaPeriodHolder != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (mediaPeriodHolder.equals(this.f23337j)) {
            return false;
        }
        this.f23337j = mediaPeriodHolder;
        while (mediaPeriodHolder.j() != null) {
            mediaPeriodHolder = mediaPeriodHolder.j();
            if (mediaPeriodHolder == this.f23336i) {
                this.f23336i = this.f23335h;
                z3 = true;
            }
            mediaPeriodHolder.t();
            this.f23338k--;
        }
        this.f23337j.w((MediaPeriodHolder) null);
        x();
        return z3;
    }
}
