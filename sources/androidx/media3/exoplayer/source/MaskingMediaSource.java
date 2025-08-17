package androidx.media3.exoplayer.source;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class MaskingMediaSource extends WrappingMediaSource {

    /* renamed from: m  reason: collision with root package name */
    private final boolean f6952m;

    /* renamed from: n  reason: collision with root package name */
    private final Timeline.Window f6953n;

    /* renamed from: o  reason: collision with root package name */
    private final Timeline.Period f6954o;

    /* renamed from: p  reason: collision with root package name */
    private MaskingTimeline f6955p;

    /* renamed from: q  reason: collision with root package name */
    private MaskingMediaPeriod f6956q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f6957r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f6958s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f6959t;

    private static final class MaskingTimeline extends ForwardingTimeline {

        /* renamed from: h  reason: collision with root package name */
        public static final Object f6960h = new Object();

        /* renamed from: f  reason: collision with root package name */
        private final Object f6961f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final Object f6962g;

        private MaskingTimeline(Timeline timeline, Object obj, Object obj2) {
            super(timeline);
            this.f6961f = obj;
            this.f6962g = obj2;
        }

        public static MaskingTimeline u(MediaItem mediaItem) {
            return new MaskingTimeline(new PlaceholderTimeline(mediaItem), Timeline.Window.f4362q, f6960h);
        }

        public static MaskingTimeline v(Timeline timeline, Object obj, Object obj2) {
            return new MaskingTimeline(timeline, obj, obj2);
        }

        public int b(Object obj) {
            Object obj2;
            Timeline timeline = this.f6929e;
            if (f6960h.equals(obj) && (obj2 = this.f6962g) != null) {
                obj = obj2;
            }
            return timeline.b(obj);
        }

        public Timeline.Period g(int i2, Timeline.Period period, boolean z2) {
            this.f6929e.g(i2, period, z2);
            if (Util.c(period.f4356b, this.f6962g) && z2) {
                period.f4356b = f6960h;
            }
            return period;
        }

        public Object m(int i2) {
            Object m2 = this.f6929e.m(i2);
            if (Util.c(m2, this.f6962g)) {
                return f6960h;
            }
            return m2;
        }

        public Timeline.Window o(int i2, Timeline.Window window, long j2) {
            this.f6929e.o(i2, window, j2);
            if (Util.c(window.f4372a, this.f6961f)) {
                window.f4372a = Timeline.Window.f4362q;
            }
            return window;
        }

        public MaskingTimeline t(Timeline timeline) {
            return new MaskingTimeline(timeline, this.f6961f, this.f6962g);
        }
    }

    public static final class PlaceholderTimeline extends Timeline {

        /* renamed from: e  reason: collision with root package name */
        private final MediaItem f6963e;

        public PlaceholderTimeline(MediaItem mediaItem) {
            this.f6963e = mediaItem;
        }

        public int b(Object obj) {
            return obj == MaskingTimeline.f6960h ? 0 : -1;
        }

        public Timeline.Period g(int i2, Timeline.Period period, boolean z2) {
            Integer num;
            Object obj = null;
            if (z2) {
                num = 0;
            } else {
                num = null;
            }
            if (z2) {
                obj = MaskingTimeline.f6960h;
            }
            period.t(num, obj, 0, -9223372036854775807L, 0, AdPlaybackState.f3879g, true);
            return period;
        }

        public int i() {
            return 1;
        }

        public Object m(int i2) {
            return MaskingTimeline.f6960h;
        }

        public Timeline.Window o(int i2, Timeline.Window window, long j2) {
            Timeline.Window window2 = window;
            window.g(Timeline.Window.f4362q, this.f6963e, (Object) null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, (MediaItem.LiveConfiguration) null, 0, -9223372036854775807L, 0, 0, 0);
            Timeline.Window window3 = window;
            window3.f4382k = true;
            return window3;
        }

        public int p() {
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
        this.f6952m = z3;
        this.f6953n = new Timeline.Window();
        this.f6954o = new Timeline.Period();
        Timeline e2 = mediaSource.e();
        if (e2 != null) {
            this.f6955p = MaskingTimeline.v(e2, (Object) null, (Object) null);
            this.f6959t = true;
            return;
        }
        this.f6955p = MaskingTimeline.u(mediaSource.a());
    }

    private Object X(Object obj) {
        if (this.f6955p.f6962g == null || !this.f6955p.f6962g.equals(obj)) {
            return obj;
        }
        return MaskingTimeline.f6960h;
    }

    private Object Y(Object obj) {
        if (this.f6955p.f6962g == null || !obj.equals(MaskingTimeline.f6960h)) {
            return obj;
        }
        return this.f6955p.f6962g;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private boolean a0(long j2) {
        MaskingMediaPeriod maskingMediaPeriod = this.f6956q;
        int b2 = this.f6955p.b(maskingMediaPeriod.f6943b.f6971a);
        if (b2 == -1) {
            return false;
        }
        long j3 = this.f6955p.f(b2, this.f6954o).f4358d;
        if (j3 != -9223372036854775807L && j2 >= j3) {
            j2 = Math.max(0, j3 - 1);
        }
        maskingMediaPeriod.w(j2);
        return true;
    }

    public void B() {
        this.f6958s = false;
        this.f6957r = false;
        super.B();
    }

    /* access modifiers changed from: protected */
    public MediaSource.MediaPeriodId M(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.a(X(mediaPeriodId.f6971a));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void S(androidx.media3.common.Timeline r15) {
        /*
            r14 = this;
            boolean r0 = r14.f6958s
            if (r0 == 0) goto L_0x0019
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r0 = r14.f6955p
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r15 = r0.t(r15)
            r14.f6955p = r15
            androidx.media3.exoplayer.source.MaskingMediaPeriod r15 = r14.f6956q
            if (r15 == 0) goto L_0x00b1
            long r0 = r15.r()
            r14.a0(r0)
            goto L_0x00b1
        L_0x0019:
            boolean r0 = r15.q()
            if (r0 == 0) goto L_0x0036
            boolean r0 = r14.f6959t
            if (r0 == 0) goto L_0x002a
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r0 = r14.f6955p
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r15 = r0.t(r15)
            goto L_0x0032
        L_0x002a:
            java.lang.Object r0 = androidx.media3.common.Timeline.Window.f4362q
            java.lang.Object r1 = androidx.media3.exoplayer.source.MaskingMediaSource.MaskingTimeline.f6960h
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r15 = androidx.media3.exoplayer.source.MaskingMediaSource.MaskingTimeline.v(r15, r0, r1)
        L_0x0032:
            r14.f6955p = r15
            goto L_0x00b1
        L_0x0036:
            androidx.media3.common.Timeline$Window r0 = r14.f6953n
            r1 = 0
            r15.n(r1, r0)
            androidx.media3.common.Timeline$Window r0 = r14.f6953n
            long r2 = r0.c()
            androidx.media3.common.Timeline$Window r0 = r14.f6953n
            java.lang.Object r0 = r0.f4372a
            androidx.media3.exoplayer.source.MaskingMediaPeriod r4 = r14.f6956q
            if (r4 == 0) goto L_0x0074
            long r4 = r4.t()
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r6 = r14.f6955p
            androidx.media3.exoplayer.source.MaskingMediaPeriod r7 = r14.f6956q
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r7 = r7.f6943b
            java.lang.Object r7 = r7.f6971a
            androidx.media3.common.Timeline$Period r8 = r14.f6954o
            r6.h(r7, r8)
            androidx.media3.common.Timeline$Period r6 = r14.f6954o
            long r6 = r6.n()
            long r6 = r6 + r4
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r4 = r14.f6955p
            androidx.media3.common.Timeline$Window r5 = r14.f6953n
            androidx.media3.common.Timeline$Window r1 = r4.n(r1, r5)
            long r4 = r1.c()
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0074
            r12 = r6
            goto L_0x0075
        L_0x0074:
            r12 = r2
        L_0x0075:
            androidx.media3.common.Timeline$Window r9 = r14.f6953n
            androidx.media3.common.Timeline$Period r10 = r14.f6954o
            r11 = 0
            r8 = r15
            android.util.Pair r1 = r8.j(r9, r10, r11, r12)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            boolean r1 = r14.f6959t
            if (r1 == 0) goto L_0x0094
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r0 = r14.f6955p
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r15 = r0.t(r15)
            goto L_0x0098
        L_0x0094:
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r15 = androidx.media3.exoplayer.source.MaskingMediaSource.MaskingTimeline.v(r15, r0, r2)
        L_0x0098:
            r14.f6955p = r15
            androidx.media3.exoplayer.source.MaskingMediaPeriod r15 = r14.f6956q
            if (r15 == 0) goto L_0x00b1
            boolean r0 = r14.a0(r3)
            if (r0 == 0) goto L_0x00b1
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r15 = r15.f6943b
            java.lang.Object r0 = r15.f6971a
            java.lang.Object r0 = r14.Y(r0)
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r15 = r15.a(r0)
            goto L_0x00b2
        L_0x00b1:
            r15 = 0
        L_0x00b2:
            r0 = 1
            r14.f6959t = r0
            r14.f6958s = r0
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r0 = r14.f6955p
            r14.A(r0)
            if (r15 == 0) goto L_0x00c9
            androidx.media3.exoplayer.source.MaskingMediaPeriod r0 = r14.f6956q
            java.lang.Object r0 = androidx.media3.common.util.Assertions.f(r0)
            androidx.media3.exoplayer.source.MaskingMediaPeriod r0 = (androidx.media3.exoplayer.source.MaskingMediaPeriod) r0
            r0.d(r15)
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.MaskingMediaSource.S(androidx.media3.common.Timeline):void");
    }

    public void V() {
        if (!this.f6952m) {
            this.f6957r = true;
            U();
        }
    }

    /* renamed from: W */
    public MaskingMediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j2);
        maskingMediaPeriod.y(this.f7184k);
        if (this.f6958s) {
            maskingMediaPeriod.d(mediaPeriodId.a(Y(mediaPeriodId.f6971a)));
        } else {
            this.f6956q = maskingMediaPeriod;
            if (!this.f6957r) {
                this.f6957r = true;
                U();
            }
        }
        return maskingMediaPeriod;
    }

    public Timeline Z() {
        return this.f6955p;
    }

    public void c() {
    }

    public void l(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).x();
        if (mediaPeriod == this.f6956q) {
            this.f6956q = null;
        }
    }

    public void o(MediaItem mediaItem) {
        if (this.f6959t) {
            this.f6955p = this.f6955p.t(new TimelineWithUpdatedMediaItem(this.f6955p.f6929e, mediaItem));
        } else {
            this.f6955p = MaskingTimeline.u(mediaItem);
        }
        this.f7184k.o(mediaItem);
    }
}
