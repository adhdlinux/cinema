package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.MediaPeriodHolder;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import com.facebook.common.time.Clock;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

final class MediaPeriodQueue {

    /* renamed from: a  reason: collision with root package name */
    private final Timeline.Period f5425a = new Timeline.Period();

    /* renamed from: b  reason: collision with root package name */
    private final Timeline.Window f5426b = new Timeline.Window();

    /* renamed from: c  reason: collision with root package name */
    private final AnalyticsCollector f5427c;

    /* renamed from: d  reason: collision with root package name */
    private final HandlerWrapper f5428d;

    /* renamed from: e  reason: collision with root package name */
    private final MediaPeriodHolder.Factory f5429e;

    /* renamed from: f  reason: collision with root package name */
    private long f5430f;

    /* renamed from: g  reason: collision with root package name */
    private int f5431g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5432h;

    /* renamed from: i  reason: collision with root package name */
    private MediaPeriodHolder f5433i;

    /* renamed from: j  reason: collision with root package name */
    private MediaPeriodHolder f5434j;

    /* renamed from: k  reason: collision with root package name */
    private MediaPeriodHolder f5435k;

    /* renamed from: l  reason: collision with root package name */
    private int f5436l;

    /* renamed from: m  reason: collision with root package name */
    private Object f5437m;

    /* renamed from: n  reason: collision with root package name */
    private long f5438n;

    /* renamed from: o  reason: collision with root package name */
    private ExoPlayer.PreloadConfiguration f5439o;

    /* renamed from: p  reason: collision with root package name */
    private List<MediaPeriodHolder> f5440p = new ArrayList();

    public MediaPeriodQueue(AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, MediaPeriodHolder.Factory factory, ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.f5427c = analyticsCollector;
        this.f5428d = handlerWrapper;
        this.f5429e = factory;
        this.f5439o = preloadConfiguration;
    }

    private boolean A(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (!y(mediaPeriodId)) {
            return false;
        }
        int i2 = timeline.h(mediaPeriodId.f6971a, this.f5425a).f4357c;
        if (timeline.n(i2, this.f5426b).f4386o == timeline.b(mediaPeriodId.f6971a)) {
            return true;
        }
        return false;
    }

    private static boolean C(Timeline.Period period) {
        int i2;
        int c2 = period.c();
        if (c2 == 0) {
            return false;
        }
        if ((c2 == 1 && period.q(0)) || !period.r(period.o())) {
            return false;
        }
        long j2 = 0;
        if (period.e(0) != -1) {
            return false;
        }
        if (period.f4358d == 0) {
            return true;
        }
        if (period.q(c2 - 1)) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        int i3 = c2 - i2;
        for (int i4 = 0; i4 <= i3; i4++) {
            j2 += period.i(i4);
        }
        if (period.f4358d <= j2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f5427c.E(builder.k(), mediaPeriodId);
    }

    private void E() {
        MediaSource.MediaPeriodId mediaPeriodId;
        ImmutableList.Builder k2 = ImmutableList.k();
        for (MediaPeriodHolder mediaPeriodHolder = this.f5433i; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.k()) {
            k2.d(mediaPeriodHolder.f5406f.f5416a);
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.f5434j;
        if (mediaPeriodHolder2 == null) {
            mediaPeriodId = null;
        } else {
            mediaPeriodId = mediaPeriodHolder2.f5406f.f5416a;
        }
        this.f5428d.g(new j0(this, k2, mediaPeriodId));
    }

    private void G(List<MediaPeriodHolder> list) {
        for (int i2 = 0; i2 < this.f5440p.size(); i2++) {
            this.f5440p.get(i2).v();
        }
        this.f5440p = list;
    }

    private MediaPeriodHolder J(MediaPeriodInfo mediaPeriodInfo) {
        for (int i2 = 0; i2 < this.f5440p.size(); i2++) {
            if (this.f5440p.get(i2).d(mediaPeriodInfo)) {
                return this.f5440p.remove(i2);
            }
        }
        return null;
    }

    private static MediaSource.MediaPeriodId K(Timeline timeline, Object obj, long j2, long j3, Timeline.Window window, Timeline.Period period) {
        timeline.h(obj, period);
        timeline.n(period.f4357c, window);
        int b2 = timeline.b(obj);
        Object obj2 = obj;
        while (C(period) && b2 <= window.f4386o) {
            timeline.g(b2, period, true);
            obj2 = Assertions.f(period.f4356b);
            b2++;
        }
        timeline.h(obj2, period);
        int e2 = period.e(j2);
        if (e2 == -1) {
            return new MediaSource.MediaPeriodId(obj2, j3, period.d(j2));
        }
        return new MediaSource.MediaPeriodId(obj2, e2, period.k(e2), j3);
    }

    private long M(Timeline timeline, Object obj) {
        int b2;
        int i2 = timeline.h(obj, this.f5425a).f4357c;
        Object obj2 = this.f5437m;
        if (obj2 != null && (b2 = timeline.b(obj2)) != -1 && timeline.f(b2, this.f5425a).f4357c == i2) {
            return this.f5438n;
        }
        for (MediaPeriodHolder mediaPeriodHolder = this.f5433i; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.k()) {
            if (mediaPeriodHolder.f5402b.equals(obj)) {
                return mediaPeriodHolder.f5406f.f5416a.f6974d;
            }
        }
        for (MediaPeriodHolder mediaPeriodHolder2 = this.f5433i; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.k()) {
            int b3 = timeline.b(mediaPeriodHolder2.f5402b);
            if (b3 != -1 && timeline.f(b3, this.f5425a).f4357c == i2) {
                return mediaPeriodHolder2.f5406f.f5416a.f6974d;
            }
        }
        long N = N(obj);
        if (N != -1) {
            return N;
        }
        long j2 = this.f5430f;
        this.f5430f = 1 + j2;
        if (this.f5433i == null) {
            this.f5437m = obj;
            this.f5438n = j2;
        }
        return j2;
    }

    private long N(Object obj) {
        for (int i2 = 0; i2 < this.f5440p.size(); i2++) {
            MediaPeriodHolder mediaPeriodHolder = this.f5440p.get(i2);
            if (mediaPeriodHolder.f5402b.equals(obj)) {
                return mediaPeriodHolder.f5406f.f5416a.f6974d;
            }
        }
        return -1;
    }

    private boolean P(Timeline timeline) {
        MediaPeriodHolder mediaPeriodHolder = this.f5433i;
        if (mediaPeriodHolder == null) {
            return true;
        }
        int b2 = timeline.b(mediaPeriodHolder.f5402b);
        while (true) {
            b2 = timeline.d(b2, this.f5425a, this.f5426b, this.f5431g, this.f5432h);
            while (((MediaPeriodHolder) Assertions.f(mediaPeriodHolder)).k() != null && !mediaPeriodHolder.f5406f.f5422g) {
                mediaPeriodHolder = mediaPeriodHolder.k();
            }
            MediaPeriodHolder k2 = mediaPeriodHolder.k();
            if (b2 == -1 || k2 == null || timeline.b(k2.f5402b) != b2) {
                boolean I = I(mediaPeriodHolder);
                mediaPeriodHolder.f5406f = v(timeline, mediaPeriodHolder.f5406f);
            } else {
                mediaPeriodHolder = k2;
            }
        }
        boolean I2 = I(mediaPeriodHolder);
        mediaPeriodHolder.f5406f = v(timeline, mediaPeriodHolder.f5406f);
        return !I2;
    }

    static boolean d(long j2, long j3) {
        return j2 == -9223372036854775807L || j2 == j3;
    }

    private boolean e(MediaPeriodInfo mediaPeriodInfo, MediaPeriodInfo mediaPeriodInfo2) {
        return mediaPeriodInfo.f5417b == mediaPeriodInfo2.f5417b && mediaPeriodInfo.f5416a.equals(mediaPeriodInfo2.f5416a);
    }

    private Pair<Object, Long> h(Timeline timeline, Object obj, long j2) {
        int e2 = timeline.e(timeline.h(obj, this.f5425a).f4357c, this.f5431g, this.f5432h);
        if (e2 == -1) {
            return null;
        }
        return timeline.k(this.f5426b, this.f5425a, e2, -9223372036854775807L, j2);
    }

    private MediaPeriodInfo i(PlaybackInfo playbackInfo) {
        return n(playbackInfo.f5464a, playbackInfo.f5465b, playbackInfo.f5466c, playbackInfo.f5482s);
    }

    private MediaPeriodInfo j(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j2) {
        long j3;
        Object obj;
        long j4;
        long j5;
        MediaPeriodInfo mediaPeriodInfo;
        long j6;
        long N;
        Timeline timeline2 = timeline;
        MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.f5406f;
        int d2 = timeline.d(timeline2.b(mediaPeriodInfo2.f5416a.f6971a), this.f5425a, this.f5426b, this.f5431g, this.f5432h);
        if (d2 == -1) {
            return null;
        }
        int i2 = timeline2.g(d2, this.f5425a, true).f4357c;
        Object f2 = Assertions.f(this.f5425a.f4356b);
        long j7 = mediaPeriodInfo2.f5416a.f6974d;
        if (timeline2.n(i2, this.f5426b).f4385n == d2) {
            mediaPeriodInfo = mediaPeriodInfo2;
            Pair<Object, Long> k2 = timeline.k(this.f5426b, this.f5425a, i2, -9223372036854775807L, Math.max(0, j2));
            if (k2 == null) {
                return null;
            }
            Object obj2 = k2.first;
            long longValue = ((Long) k2.second).longValue();
            MediaPeriodHolder k3 = mediaPeriodHolder.k();
            if (k3 == null || !k3.f5402b.equals(obj2)) {
                N = N(obj2);
                if (N == -1) {
                    N = this.f5430f;
                    this.f5430f = 1 + N;
                }
            } else {
                N = k3.f5406f.f5416a.f6974d;
            }
            j3 = N;
            j4 = -9223372036854775807L;
            obj = obj2;
            j5 = longValue;
        } else {
            mediaPeriodInfo = mediaPeriodInfo2;
            j3 = j7;
            j4 = 0;
            obj = f2;
            j5 = 0;
        }
        MediaSource.MediaPeriodId K = K(timeline, obj, j5, j3, this.f5426b, this.f5425a);
        if (!(j4 == -9223372036854775807L || mediaPeriodInfo.f5418c == -9223372036854775807L)) {
            boolean w2 = w(mediaPeriodInfo.f5416a.f6971a, timeline2);
            if (K.b() && w2) {
                j4 = mediaPeriodInfo.f5418c;
            } else if (w2) {
                j6 = mediaPeriodInfo.f5418c;
                return n(timeline, K, j4, j6);
            }
        }
        j6 = j5;
        return n(timeline, K, j4, j6);
    }

    private MediaPeriodInfo k(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j2) {
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f5406f;
        long m2 = (mediaPeriodHolder.m() + mediaPeriodInfo.f5420e) - j2;
        if (mediaPeriodInfo.f5422g) {
            return j(timeline, mediaPeriodHolder, m2);
        }
        return l(timeline, mediaPeriodHolder, m2);
    }

    private MediaPeriodInfo l(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j2) {
        boolean z2;
        Timeline timeline2 = timeline;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f5406f;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f5416a;
        timeline2.h(mediaPeriodId.f6971a, this.f5425a);
        if (mediaPeriodId.b()) {
            int i2 = mediaPeriodId.f6972b;
            int a2 = this.f5425a.a(i2);
            if (a2 == -1) {
                return null;
            }
            int l2 = this.f5425a.l(i2, mediaPeriodId.f6973c);
            if (l2 < a2) {
                return o(timeline, mediaPeriodId.f6971a, i2, l2, mediaPeriodInfo.f5418c, mediaPeriodId.f6974d);
            }
            long j3 = mediaPeriodInfo.f5418c;
            if (j3 == -9223372036854775807L) {
                Timeline.Window window = this.f5426b;
                Timeline.Period period = this.f5425a;
                Pair<Object, Long> k2 = timeline.k(window, period, period.f4357c, -9223372036854775807L, Math.max(0, j2));
                if (k2 == null) {
                    return null;
                }
                j3 = ((Long) k2.second).longValue();
            }
            long r2 = r(timeline2, mediaPeriodId.f6971a, mediaPeriodId.f6972b);
            return p(timeline, mediaPeriodId.f6971a, Math.max(r2, j3), mediaPeriodInfo.f5418c, mediaPeriodId.f6974d);
        }
        long j4 = j2;
        int i3 = mediaPeriodId.f6975e;
        if (i3 != -1 && this.f5425a.q(i3)) {
            return j(timeline, mediaPeriodHolder, j2);
        }
        int k3 = this.f5425a.k(mediaPeriodId.f6975e);
        if (!this.f5425a.r(mediaPeriodId.f6975e) || this.f5425a.h(mediaPeriodId.f6975e, k3) != 3) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (k3 == this.f5425a.a(mediaPeriodId.f6975e) || z2) {
            return p(timeline, mediaPeriodId.f6971a, r(timeline2, mediaPeriodId.f6971a, mediaPeriodId.f6975e), mediaPeriodInfo.f5420e, mediaPeriodId.f6974d);
        }
        return o(timeline, mediaPeriodId.f6971a, mediaPeriodId.f6975e, k3, mediaPeriodInfo.f5420e, mediaPeriodId.f6974d);
    }

    private MediaPeriodInfo n(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3) {
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        Timeline timeline2 = timeline;
        timeline.h(mediaPeriodId2.f6971a, this.f5425a);
        if (mediaPeriodId.b()) {
            return o(timeline, mediaPeriodId2.f6971a, mediaPeriodId2.f6972b, mediaPeriodId2.f6973c, j2, mediaPeriodId2.f6974d);
        }
        return p(timeline, mediaPeriodId2.f6971a, j3, j2, mediaPeriodId2.f6974d);
    }

    private MediaPeriodInfo o(Timeline timeline, Object obj, int i2, int i3, long j2, long j3) {
        long j4;
        long j5;
        int i4 = i3;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i2, i4, j3);
        long b2 = timeline.h(mediaPeriodId.f6971a, this.f5425a).b(mediaPeriodId.f6972b, mediaPeriodId.f6973c);
        if (i4 == this.f5425a.k(i2)) {
            j4 = this.f5425a.g();
        } else {
            j4 = 0;
        }
        boolean r2 = this.f5425a.r(mediaPeriodId.f6972b);
        if (b2 == -9223372036854775807L || j4 < b2) {
            j5 = j4;
        } else {
            j5 = Math.max(0, b2 - 1);
        }
        return new MediaPeriodInfo(mediaPeriodId, j5, j2, -9223372036854775807L, b2, r2, false, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r10.r(r10.o()) != false) goto L_0x0057;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.media3.exoplayer.MediaPeriodInfo p(androidx.media3.common.Timeline r26, java.lang.Object r27, long r28, long r30, long r32) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            r3 = r28
            androidx.media3.common.Timeline$Period r5 = r0.f5425a
            r1.h(r2, r5)
            androidx.media3.common.Timeline$Period r5 = r0.f5425a
            int r5 = r5.d(r3)
            r6 = 1
            r7 = 0
            r8 = -1
            if (r5 == r8) goto L_0x0022
            androidx.media3.common.Timeline$Period r9 = r0.f5425a
            boolean r9 = r9.q(r5)
            if (r9 == 0) goto L_0x0022
            r9 = 1
            goto L_0x0023
        L_0x0022:
            r9 = 0
        L_0x0023:
            if (r5 != r8) goto L_0x003a
            androidx.media3.common.Timeline$Period r10 = r0.f5425a
            int r10 = r10.c()
            if (r10 <= 0) goto L_0x0059
            androidx.media3.common.Timeline$Period r10 = r0.f5425a
            int r11 = r10.o()
            boolean r10 = r10.r(r11)
            if (r10 == 0) goto L_0x0059
            goto L_0x0057
        L_0x003a:
            androidx.media3.common.Timeline$Period r10 = r0.f5425a
            boolean r10 = r10.r(r5)
            if (r10 == 0) goto L_0x0059
            androidx.media3.common.Timeline$Period r10 = r0.f5425a
            long r10 = r10.f(r5)
            androidx.media3.common.Timeline$Period r12 = r0.f5425a
            long r13 = r12.f4358d
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 != 0) goto L_0x0059
            boolean r10 = r12.p(r5)
            if (r10 == 0) goto L_0x0059
            r5 = -1
        L_0x0057:
            r10 = 1
            goto L_0x005a
        L_0x0059:
            r10 = 0
        L_0x005a:
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r12 = new androidx.media3.exoplayer.source.MediaSource$MediaPeriodId
            r13 = r32
            r12.<init>(r2, r13, r5)
            boolean r2 = r0.y(r12)
            boolean r23 = r0.A(r1, r12)
            boolean r24 = r0.z(r1, r12, r2)
            if (r5 == r8) goto L_0x007c
            androidx.media3.common.Timeline$Period r1 = r0.f5425a
            boolean r1 = r1.r(r5)
            if (r1 == 0) goto L_0x007c
            if (r9 != 0) goto L_0x007c
            r21 = 1
            goto L_0x007e
        L_0x007c:
            r21 = 0
        L_0x007e:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == r8) goto L_0x008e
            if (r9 != 0) goto L_0x008e
            androidx.media3.common.Timeline$Period r1 = r0.f5425a
            long r8 = r1.f(r5)
            goto L_0x0094
        L_0x008e:
            if (r10 == 0) goto L_0x0097
            androidx.media3.common.Timeline$Period r1 = r0.f5425a
            long r8 = r1.f4358d
        L_0x0094:
            r17 = r8
            goto L_0x0099
        L_0x0097:
            r17 = r13
        L_0x0099:
            int r1 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x00a7
            r8 = -9223372036854775808
            int r1 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x00a4
            goto L_0x00a7
        L_0x00a4:
            r19 = r17
            goto L_0x00ad
        L_0x00a7:
            androidx.media3.common.Timeline$Period r1 = r0.f5425a
            long r8 = r1.f4358d
            r19 = r8
        L_0x00ad:
            int r1 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x00c4
            int r1 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r1 < 0) goto L_0x00c4
            if (r24 != 0) goto L_0x00bb
            if (r10 != 0) goto L_0x00ba
            goto L_0x00bb
        L_0x00ba:
            r6 = 0
        L_0x00bb:
            long r3 = (long) r6
            long r3 = r19 - r3
            r5 = 0
            long r3 = java.lang.Math.max(r5, r3)
        L_0x00c4:
            r13 = r3
            androidx.media3.exoplayer.MediaPeriodInfo r1 = new androidx.media3.exoplayer.MediaPeriodInfo
            r11 = r1
            r15 = r30
            r22 = r2
            r11.<init>(r12, r13, r15, r17, r19, r21, r22, r23, r24)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MediaPeriodQueue.p(androidx.media3.common.Timeline, java.lang.Object, long, long, long):androidx.media3.exoplayer.MediaPeriodInfo");
    }

    private MediaPeriodInfo q(Timeline timeline, Object obj, long j2, long j3) {
        MediaSource.MediaPeriodId K = K(timeline, obj, j2, j3, this.f5426b, this.f5425a);
        if (K.b()) {
            return o(timeline, K.f6971a, K.f6972b, K.f6973c, j2, K.f6974d);
        }
        return p(timeline, K.f6971a, j2, -9223372036854775807L, K.f6974d);
    }

    private long r(Timeline timeline, Object obj, int i2) {
        timeline.h(obj, this.f5425a);
        long f2 = this.f5425a.f(i2);
        if (f2 == Long.MIN_VALUE) {
            return this.f5425a.f4358d;
        }
        return f2 + this.f5425a.i(i2);
    }

    private boolean w(Object obj, Timeline timeline) {
        int c2 = timeline.h(obj, this.f5425a).c();
        int o2 = this.f5425a.o();
        if (c2 <= 0 || !this.f5425a.r(o2) || (c2 <= 1 && this.f5425a.f(o2) == Long.MIN_VALUE)) {
            return false;
        }
        return true;
    }

    private boolean y(MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.b() && mediaPeriodId.f6975e == -1;
    }

    private boolean z(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z2) {
        int b2 = timeline.b(mediaPeriodId.f6971a);
        if (!timeline.n(timeline.f(b2, this.f5425a).f4357c, this.f5426b).f4380i) {
            if (!timeline.r(b2, this.f5425a, this.f5426b, this.f5431g, this.f5432h) || !z2) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean B(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.f5435k;
        return mediaPeriodHolder != null && mediaPeriodHolder.f5401a == mediaPeriod;
    }

    public void F(long j2) {
        MediaPeriodHolder mediaPeriodHolder = this.f5435k;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.u(j2);
        }
    }

    public void H() {
        if (!this.f5440p.isEmpty()) {
            G(new ArrayList());
        }
    }

    public boolean I(MediaPeriodHolder mediaPeriodHolder) {
        Assertions.j(mediaPeriodHolder);
        boolean z2 = false;
        if (mediaPeriodHolder.equals(this.f5435k)) {
            return false;
        }
        this.f5435k = mediaPeriodHolder;
        while (mediaPeriodHolder.k() != null) {
            mediaPeriodHolder = (MediaPeriodHolder) Assertions.f(mediaPeriodHolder.k());
            if (mediaPeriodHolder == this.f5434j) {
                this.f5434j = this.f5433i;
                z2 = true;
            }
            mediaPeriodHolder.v();
            this.f5436l--;
        }
        ((MediaPeriodHolder) Assertions.f(this.f5435k)).y((MediaPeriodHolder) null);
        E();
        return z2;
    }

    public MediaSource.MediaPeriodId L(Timeline timeline, Object obj, long j2) {
        long M = M(timeline, obj);
        timeline.h(obj, this.f5425a);
        timeline.n(this.f5425a.f4357c, this.f5426b);
        boolean z2 = false;
        for (int b2 = timeline.b(obj); b2 >= this.f5426b.f4385n; b2--) {
            boolean z3 = true;
            timeline.g(b2, this.f5425a, true);
            if (this.f5425a.c() <= 0) {
                z3 = false;
            }
            z2 |= z3;
            Timeline.Period period = this.f5425a;
            if (period.e(period.f4358d) != -1) {
                obj = Assertions.f(this.f5425a.f4356b);
            }
            if (z2 && (!z3 || this.f5425a.f4358d != 0)) {
                break;
            }
        }
        return K(timeline, obj, j2, M, this.f5426b, this.f5425a);
    }

    public boolean O() {
        MediaPeriodHolder mediaPeriodHolder = this.f5435k;
        if (mediaPeriodHolder == null || (!mediaPeriodHolder.f5406f.f5424i && mediaPeriodHolder.s() && this.f5435k.f5406f.f5420e != -9223372036854775807L && this.f5436l < 100)) {
            return true;
        }
        return false;
    }

    public void Q(Timeline timeline, ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.f5439o = preloadConfiguration;
        x(timeline);
    }

    public boolean R(Timeline timeline, long j2, long j3) {
        MediaPeriodInfo mediaPeriodInfo;
        long j4;
        boolean z2;
        MediaPeriodHolder mediaPeriodHolder = null;
        for (MediaPeriodHolder mediaPeriodHolder2 = this.f5433i; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.k()) {
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder2.f5406f;
            if (mediaPeriodHolder == null) {
                mediaPeriodInfo = v(timeline, mediaPeriodInfo2);
            } else {
                MediaPeriodInfo k2 = k(timeline, mediaPeriodHolder, j2);
                if (k2 == null) {
                    return !I(mediaPeriodHolder);
                }
                if (!e(mediaPeriodInfo2, k2)) {
                    return !I(mediaPeriodHolder);
                }
                mediaPeriodInfo = k2;
            }
            mediaPeriodHolder2.f5406f = mediaPeriodInfo.a(mediaPeriodInfo2.f5418c);
            if (!d(mediaPeriodInfo2.f5420e, mediaPeriodInfo.f5420e)) {
                mediaPeriodHolder2.C();
                long j5 = mediaPeriodInfo.f5420e;
                if (j5 == -9223372036854775807L) {
                    j4 = Clock.MAX_TIME;
                } else {
                    j4 = mediaPeriodHolder2.B(j5);
                }
                if (mediaPeriodHolder2 != this.f5434j || mediaPeriodHolder2.f5406f.f5421f || (j3 != Long.MIN_VALUE && j3 < j4)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (I(mediaPeriodHolder2) || z2) {
                    return false;
                }
                return true;
            }
            mediaPeriodHolder = mediaPeriodHolder2;
        }
        return true;
    }

    public boolean S(Timeline timeline, int i2) {
        this.f5431g = i2;
        return P(timeline);
    }

    public boolean T(Timeline timeline, boolean z2) {
        this.f5432h = z2;
        return P(timeline);
    }

    public MediaPeriodHolder b() {
        MediaPeriodHolder mediaPeriodHolder = this.f5433i;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.f5434j) {
            this.f5434j = mediaPeriodHolder.k();
        }
        this.f5433i.v();
        int i2 = this.f5436l - 1;
        this.f5436l = i2;
        if (i2 == 0) {
            this.f5435k = null;
            MediaPeriodHolder mediaPeriodHolder2 = this.f5433i;
            this.f5437m = mediaPeriodHolder2.f5402b;
            this.f5438n = mediaPeriodHolder2.f5406f.f5416a.f6974d;
        }
        this.f5433i = this.f5433i.k();
        E();
        return this.f5433i;
    }

    public MediaPeriodHolder c() {
        this.f5434j = ((MediaPeriodHolder) Assertions.j(this.f5434j)).k();
        E();
        return (MediaPeriodHolder) Assertions.j(this.f5434j);
    }

    public void f() {
        if (this.f5436l != 0) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.j(this.f5433i);
            this.f5437m = mediaPeriodHolder.f5402b;
            this.f5438n = mediaPeriodHolder.f5406f.f5416a.f6974d;
            while (mediaPeriodHolder != null) {
                mediaPeriodHolder.v();
                mediaPeriodHolder = mediaPeriodHolder.k();
            }
            this.f5433i = null;
            this.f5435k = null;
            this.f5434j = null;
            this.f5436l = 0;
            E();
        }
    }

    public MediaPeriodHolder g(MediaPeriodInfo mediaPeriodInfo) {
        long j2;
        MediaPeriodHolder mediaPeriodHolder = this.f5435k;
        if (mediaPeriodHolder == null) {
            j2 = 1000000000000L;
        } else {
            j2 = (mediaPeriodHolder.m() + this.f5435k.f5406f.f5420e) - mediaPeriodInfo.f5417b;
        }
        MediaPeriodHolder J = J(mediaPeriodInfo);
        if (J == null) {
            J = this.f5429e.a(mediaPeriodInfo, j2);
        } else {
            J.f5406f = mediaPeriodInfo;
            J.z(j2);
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.f5435k;
        if (mediaPeriodHolder2 != null) {
            mediaPeriodHolder2.y(J);
        } else {
            this.f5433i = J;
            this.f5434j = J;
        }
        this.f5437m = null;
        this.f5435k = J;
        this.f5436l++;
        E();
        return J;
    }

    public MediaPeriodHolder m() {
        return this.f5435k;
    }

    public MediaPeriodInfo s(long j2, PlaybackInfo playbackInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.f5435k;
        if (mediaPeriodHolder == null) {
            return i(playbackInfo);
        }
        return k(playbackInfo.f5464a, mediaPeriodHolder, j2);
    }

    public MediaPeriodHolder t() {
        return this.f5433i;
    }

    public MediaPeriodHolder u() {
        return this.f5434j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.MediaPeriodInfo v(androidx.media3.common.Timeline r19, androidx.media3.exoplayer.MediaPeriodInfo r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r2.f5416a
            boolean r12 = r0.y(r3)
            boolean r13 = r0.A(r1, r3)
            boolean r14 = r0.z(r1, r3, r12)
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r4 = r2.f5416a
            java.lang.Object r4 = r4.f6971a
            androidx.media3.common.Timeline$Period r5 = r0.f5425a
            r1.h(r4, r5)
            boolean r1 = r3.b()
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0035
            int r1 = r3.f6975e
            if (r1 != r4) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            androidx.media3.common.Timeline$Period r7 = r0.f5425a
            long r7 = r7.f(r1)
            goto L_0x0036
        L_0x0035:
            r7 = r5
        L_0x0036:
            boolean r1 = r3.b()
            if (r1 == 0) goto L_0x0048
            androidx.media3.common.Timeline$Period r1 = r0.f5425a
            int r5 = r3.f6972b
            int r6 = r3.f6973c
            long r5 = r1.b(r5, r6)
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
            androidx.media3.common.Timeline$Period r1 = r0.f5425a
            long r5 = r1.j()
            goto L_0x0046
        L_0x005c:
            boolean r1 = r3.b()
            if (r1 == 0) goto L_0x006c
            androidx.media3.common.Timeline$Period r1 = r0.f5425a
            int r4 = r3.f6972b
            boolean r1 = r1.r(r4)
            r11 = r1
            goto L_0x007d
        L_0x006c:
            int r1 = r3.f6975e
            if (r1 == r4) goto L_0x007b
            androidx.media3.common.Timeline$Period r4 = r0.f5425a
            boolean r1 = r4.r(r1)
            if (r1 == 0) goto L_0x007b
            r1 = 1
            r11 = 1
            goto L_0x007d
        L_0x007b:
            r1 = 0
            r11 = 0
        L_0x007d:
            androidx.media3.exoplayer.MediaPeriodInfo r15 = new androidx.media3.exoplayer.MediaPeriodInfo
            long r4 = r2.f5417b
            long r1 = r2.f5418c
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MediaPeriodQueue.v(androidx.media3.common.Timeline, androidx.media3.exoplayer.MediaPeriodInfo):androidx.media3.exoplayer.MediaPeriodInfo");
    }

    public void x(Timeline timeline) {
        MediaPeriodHolder mediaPeriodHolder;
        if (this.f5439o.f5270a == -9223372036854775807L || (mediaPeriodHolder = this.f5435k) == null) {
            H();
            return;
        }
        ArrayList arrayList = new ArrayList();
        Pair<Object, Long> h2 = h(timeline, mediaPeriodHolder.f5406f.f5416a.f6971a, 0);
        if (h2 != null && !timeline.n(timeline.h(h2.first, this.f5425a).f4357c, this.f5426b).f()) {
            long N = N(h2.first);
            if (N == -1) {
                N = this.f5430f;
                this.f5430f = 1 + N;
            }
            Timeline timeline2 = timeline;
            MediaPeriodInfo q2 = q(timeline2, h2.first, ((Long) h2.second).longValue(), N);
            MediaPeriodHolder J = J(q2);
            if (J == null) {
                J = this.f5429e.a(q2, (mediaPeriodHolder.m() + mediaPeriodHolder.f5406f.f5420e) - q2.f5417b);
            }
            arrayList.add(J);
        }
        G(arrayList);
    }
}
