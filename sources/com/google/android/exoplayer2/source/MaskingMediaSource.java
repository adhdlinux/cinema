package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Util;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class MaskingMediaSource extends WrappingMediaSource {

    /* renamed from: n  reason: collision with root package name */
    private final boolean f25774n;

    /* renamed from: o  reason: collision with root package name */
    private final Timeline.Window f25775o;

    /* renamed from: p  reason: collision with root package name */
    private final Timeline.Period f25776p;

    /* renamed from: q  reason: collision with root package name */
    private MaskingTimeline f25777q;

    /* renamed from: r  reason: collision with root package name */
    private MaskingMediaPeriod f25778r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f25779s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f25780t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f25781u;

    private static final class MaskingTimeline extends ForwardingTimeline {

        /* renamed from: j  reason: collision with root package name */
        public static final Object f25782j = new Object();

        /* renamed from: h  reason: collision with root package name */
        private final Object f25783h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public final Object f25784i;

        private MaskingTimeline(Timeline timeline, Object obj, Object obj2) {
            super(timeline);
            this.f25783h = obj;
            this.f25784i = obj2;
        }

        public static MaskingTimeline y(MediaItem mediaItem) {
            return new MaskingTimeline(new PlaceholderTimeline(mediaItem), Timeline.Window.f23503s, f25782j);
        }

        public static MaskingTimeline z(Timeline timeline, Object obj, Object obj2) {
            return new MaskingTimeline(timeline, obj, obj2);
        }

        public int f(Object obj) {
            Object obj2;
            Timeline timeline = this.f25751g;
            if (f25782j.equals(obj) && (obj2 = this.f25784i) != null) {
                obj = obj2;
            }
            return timeline.f(obj);
        }

        public Timeline.Period k(int i2, Timeline.Period period, boolean z2) {
            this.f25751g.k(i2, period, z2);
            if (Util.c(period.f23493c, this.f25784i) && z2) {
                period.f23493c = f25782j;
            }
            return period;
        }

        public Object q(int i2) {
            Object q2 = this.f25751g.q(i2);
            if (Util.c(q2, this.f25784i)) {
                return f25782j;
            }
            return q2;
        }

        public Timeline.Window s(int i2, Timeline.Window window, long j2) {
            this.f25751g.s(i2, window, j2);
            if (Util.c(window.f23511b, this.f25783h)) {
                window.f23511b = Timeline.Window.f23503s;
            }
            return window;
        }

        public MaskingTimeline x(Timeline timeline) {
            return new MaskingTimeline(timeline, this.f25783h, this.f25784i);
        }
    }

    public static final class PlaceholderTimeline extends Timeline {

        /* renamed from: g  reason: collision with root package name */
        private final MediaItem f25785g;

        public PlaceholderTimeline(MediaItem mediaItem) {
            this.f25785g = mediaItem;
        }

        public int f(Object obj) {
            return obj == MaskingTimeline.f25782j ? 0 : -1;
        }

        public Timeline.Period k(int i2, Timeline.Period period, boolean z2) {
            Integer num;
            Object obj = null;
            if (z2) {
                num = 0;
            } else {
                num = null;
            }
            if (z2) {
                obj = MaskingTimeline.f25782j;
            }
            period.v(num, obj, 0, -9223372036854775807L, 0, AdPlaybackState.f26018h, true);
            return period;
        }

        public int m() {
            return 1;
        }

        public Object q(int i2) {
            return MaskingTimeline.f25782j;
        }

        public Timeline.Window s(int i2, Timeline.Window window, long j2) {
            Timeline.Window window2 = window;
            window.i(Timeline.Window.f23503s, this.f25785g, (Object) null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, (MediaItem.LiveConfiguration) null, 0, -9223372036854775807L, 0, 0, 0);
            Timeline.Window window3 = window;
            window3.f23522m = true;
            return window3;
        }

        public int t() {
            return 1;
        }
    }

    public MaskingMediaSource(MediaSource mediaSource, boolean z2) {
        super(mediaSource);
        boolean z3;
        if (!z2 || !mediaSource.d()) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.f25774n = z3;
        this.f25775o = new Timeline.Window();
        this.f25776p = new Timeline.Period();
        Timeline e2 = mediaSource.e();
        if (e2 != null) {
            this.f25777q = MaskingTimeline.z(e2, (Object) null, (Object) null);
            this.f25781u = true;
            return;
        }
        this.f25777q = MaskingTimeline.y(mediaSource.a());
    }

    private Object X(Object obj) {
        if (this.f25777q.f25784i == null || !this.f25777q.f25784i.equals(obj)) {
            return obj;
        }
        return MaskingTimeline.f25782j;
    }

    private Object Y(Object obj) {
        if (this.f25777q.f25784i == null || !obj.equals(MaskingTimeline.f25782j)) {
            return obj;
        }
        return this.f25777q.f25784i;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private void a0(long j2) {
        MaskingMediaPeriod maskingMediaPeriod = this.f25778r;
        int f2 = this.f25777q.f(maskingMediaPeriod.f25765b.f25793a);
        if (f2 != -1) {
            long j3 = this.f25777q.j(f2, this.f25776p).f23495e;
            if (j3 != -9223372036854775807L && j2 >= j3) {
                j2 = Math.max(0, j3 - 1);
            }
            maskingMediaPeriod.w(j2);
        }
    }

    public void E() {
        this.f25780t = false;
        this.f25779s = false;
        super.E();
    }

    /* access modifiers changed from: protected */
    public MediaSource.MediaPeriodId M(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.c(X(mediaPeriodId.f25793a));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void S(com.google.android.exoplayer2.Timeline r15) {
        /*
            r14 = this;
            boolean r0 = r14.f25780t
            if (r0 == 0) goto L_0x0019
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r0 = r14.f25777q
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r15 = r0.x(r15)
            r14.f25777q = r15
            com.google.android.exoplayer2.source.MaskingMediaPeriod r15 = r14.f25778r
            if (r15 == 0) goto L_0x00ae
            long r0 = r15.q()
            r14.a0(r0)
            goto L_0x00ae
        L_0x0019:
            boolean r0 = r15.u()
            if (r0 == 0) goto L_0x0036
            boolean r0 = r14.f25781u
            if (r0 == 0) goto L_0x002a
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r0 = r14.f25777q
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r15 = r0.x(r15)
            goto L_0x0032
        L_0x002a:
            java.lang.Object r0 = com.google.android.exoplayer2.Timeline.Window.f23503s
            java.lang.Object r1 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.f25782j
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r15 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.z(r15, r0, r1)
        L_0x0032:
            r14.f25777q = r15
            goto L_0x00ae
        L_0x0036:
            com.google.android.exoplayer2.Timeline$Window r0 = r14.f25775o
            r1 = 0
            r15.r(r1, r0)
            com.google.android.exoplayer2.Timeline$Window r0 = r14.f25775o
            long r2 = r0.e()
            com.google.android.exoplayer2.Timeline$Window r0 = r14.f25775o
            java.lang.Object r0 = r0.f23511b
            com.google.android.exoplayer2.source.MaskingMediaPeriod r4 = r14.f25778r
            if (r4 == 0) goto L_0x0074
            long r4 = r4.t()
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r6 = r14.f25777q
            com.google.android.exoplayer2.source.MaskingMediaPeriod r7 = r14.f25778r
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r7 = r7.f25765b
            java.lang.Object r7 = r7.f25793a
            com.google.android.exoplayer2.Timeline$Period r8 = r14.f25776p
            r6.l(r7, r8)
            com.google.android.exoplayer2.Timeline$Period r6 = r14.f25776p
            long r6 = r6.q()
            long r6 = r6 + r4
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r4 = r14.f25777q
            com.google.android.exoplayer2.Timeline$Window r5 = r14.f25775o
            com.google.android.exoplayer2.Timeline$Window r1 = r4.r(r1, r5)
            long r4 = r1.e()
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0074
            r12 = r6
            goto L_0x0075
        L_0x0074:
            r12 = r2
        L_0x0075:
            com.google.android.exoplayer2.Timeline$Window r9 = r14.f25775o
            com.google.android.exoplayer2.Timeline$Period r10 = r14.f25776p
            r11 = 0
            r8 = r15
            android.util.Pair r1 = r8.n(r9, r10, r11, r12)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            boolean r1 = r14.f25781u
            if (r1 == 0) goto L_0x0094
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r0 = r14.f25777q
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r15 = r0.x(r15)
            goto L_0x0098
        L_0x0094:
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r15 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.z(r15, r0, r2)
        L_0x0098:
            r14.f25777q = r15
            com.google.android.exoplayer2.source.MaskingMediaPeriod r15 = r14.f25778r
            if (r15 == 0) goto L_0x00ae
            r14.a0(r3)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r15 = r15.f25765b
            java.lang.Object r0 = r15.f25793a
            java.lang.Object r0 = r14.Y(r0)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r15 = r15.c(r0)
            goto L_0x00af
        L_0x00ae:
            r15 = 0
        L_0x00af:
            r0 = 1
            r14.f25781u = r0
            r14.f25780t = r0
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r0 = r14.f25777q
            r14.D(r0)
            if (r15 == 0) goto L_0x00c6
            com.google.android.exoplayer2.source.MaskingMediaPeriod r0 = r14.f25778r
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.e(r0)
            com.google.android.exoplayer2.source.MaskingMediaPeriod r0 = (com.google.android.exoplayer2.source.MaskingMediaPeriod) r0
            r0.m(r15)
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.MaskingMediaSource.S(com.google.android.exoplayer2.Timeline):void");
    }

    public void V() {
        if (!this.f25774n) {
            this.f25779s = true;
            U();
        }
    }

    /* renamed from: W */
    public MaskingMediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j2);
        maskingMediaPeriod.y(this.f26015l);
        if (this.f25780t) {
            maskingMediaPeriod.m(mediaPeriodId.c(Y(mediaPeriodId.f25793a)));
        } else {
            this.f25778r = maskingMediaPeriod;
            if (!this.f25779s) {
                this.f25779s = true;
                U();
            }
        }
        return maskingMediaPeriod;
    }

    public Timeline Z() {
        return this.f25777q;
    }

    public void c() {
    }

    public void l(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).x();
        if (mediaPeriod == this.f25778r) {
            this.f25778r = null;
        }
    }
}
