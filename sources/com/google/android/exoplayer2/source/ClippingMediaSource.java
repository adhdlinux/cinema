package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;

public final class ClippingMediaSource extends WrappingMediaSource {

    /* renamed from: n  reason: collision with root package name */
    private final long f25706n;

    /* renamed from: o  reason: collision with root package name */
    private final long f25707o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f25708p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f25709q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f25710r;

    /* renamed from: s  reason: collision with root package name */
    private final ArrayList<ClippingMediaPeriod> f25711s;

    /* renamed from: t  reason: collision with root package name */
    private final Timeline.Window f25712t;

    /* renamed from: u  reason: collision with root package name */
    private ClippingTimeline f25713u;

    /* renamed from: v  reason: collision with root package name */
    private IllegalClippingException f25714v;

    /* renamed from: w  reason: collision with root package name */
    private long f25715w;

    /* renamed from: x  reason: collision with root package name */
    private long f25716x;

    private static final class ClippingTimeline extends ForwardingTimeline {

        /* renamed from: h  reason: collision with root package name */
        private final long f25717h;

        /* renamed from: i  reason: collision with root package name */
        private final long f25718i;

        /* renamed from: j  reason: collision with root package name */
        private final long f25719j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f25720k;

        public ClippingTimeline(Timeline timeline, long j2, long j3) throws IllegalClippingException {
            super(timeline);
            long j4;
            long j5;
            boolean z2 = false;
            if (timeline.m() == 1) {
                Timeline.Window r2 = timeline.r(0, new Timeline.Window());
                long max = Math.max(0, j2);
                if (r2.f23522m || max == 0 || r2.f23518i) {
                    if (j3 == Long.MIN_VALUE) {
                        j4 = r2.f23524o;
                    } else {
                        j4 = Math.max(0, j3);
                    }
                    long j6 = r2.f23524o;
                    if (j6 != -9223372036854775807L) {
                        j4 = j4 > j6 ? j6 : j4;
                        if (max > j4) {
                            throw new IllegalClippingException(2);
                        }
                    }
                    this.f25717h = max;
                    this.f25718i = j4;
                    int i2 = (j4 > -9223372036854775807L ? 1 : (j4 == -9223372036854775807L ? 0 : -1));
                    if (i2 == 0) {
                        j5 = -9223372036854775807L;
                    } else {
                        j5 = j4 - max;
                    }
                    this.f25719j = j5;
                    if (r2.f23519j && (i2 == 0 || (j6 != -9223372036854775807L && j4 == j6))) {
                        z2 = true;
                    }
                    this.f25720k = z2;
                    return;
                }
                throw new IllegalClippingException(1);
            }
            throw new IllegalClippingException(0);
        }

        public Timeline.Period k(int i2, Timeline.Period period, boolean z2) {
            long j2;
            this.f25751g.k(0, period, z2);
            long q2 = period.q() - this.f25717h;
            long j3 = this.f25719j;
            if (j3 == -9223372036854775807L) {
                j2 = -9223372036854775807L;
            } else {
                j2 = j3 - q2;
            }
            return period.u(period.f23492b, period.f23493c, 0, j2, q2);
        }

        public Timeline.Window s(int i2, Timeline.Window window, long j2) {
            this.f25751g.s(0, window, 0);
            long j3 = window.f23527r;
            long j4 = this.f25717h;
            window.f23527r = j3 + j4;
            window.f23524o = this.f25719j;
            window.f23519j = this.f25720k;
            long j5 = window.f23523n;
            if (j5 != -9223372036854775807L) {
                long max = Math.max(j5, j4);
                window.f23523n = max;
                long j6 = this.f25718i;
                if (j6 != -9223372036854775807L) {
                    max = Math.min(max, j6);
                }
                window.f23523n = max - this.f25717h;
            }
            long i12 = Util.i1(this.f25717h);
            long j7 = window.f23515f;
            if (j7 != -9223372036854775807L) {
                window.f23515f = j7 + i12;
            }
            long j8 = window.f23516g;
            if (j8 != -9223372036854775807L) {
                window.f23516g = j8 + i12;
            }
            return window;
        }
    }

    public static final class IllegalClippingException extends IOException {

        /* renamed from: b  reason: collision with root package name */
        public final int f25721b;

        public IllegalClippingException(int i2) {
            super("Illegal clipping: " + a(i2));
            this.f25721b = i2;
        }

        private static String a(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j2, long j3, boolean z2, boolean z3, boolean z4) {
        super((MediaSource) Assertions.e(mediaSource));
        boolean z5;
        if (j2 >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.a(z5);
        this.f25706n = j2;
        this.f25707o = j3;
        this.f25708p = z2;
        this.f25709q = z3;
        this.f25710r = z4;
        this.f25711s = new ArrayList<>();
        this.f25712t = new Timeline.Window();
    }

    private void W(Timeline timeline) {
        long j2;
        timeline.r(0, this.f25712t);
        long g2 = this.f25712t.g();
        long j3 = Long.MIN_VALUE;
        if (this.f25713u == null || this.f25711s.isEmpty() || this.f25709q) {
            long j4 = this.f25706n;
            long j5 = this.f25707o;
            if (this.f25710r) {
                long e2 = this.f25712t.e();
                j4 += e2;
                j5 += e2;
            }
            this.f25715w = g2 + j4;
            if (this.f25707o != Long.MIN_VALUE) {
                j3 = g2 + j5;
            }
            this.f25716x = j3;
            int size = this.f25711s.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f25711s.get(i2).w(this.f25715w, this.f25716x);
            }
            j2 = j4;
            j3 = j5;
        } else {
            long j6 = this.f25715w - g2;
            if (this.f25707o != Long.MIN_VALUE) {
                j3 = this.f25716x - g2;
            }
            j2 = j6;
        }
        try {
            ClippingTimeline clippingTimeline = new ClippingTimeline(timeline, j2, j3);
            this.f25713u = clippingTimeline;
            D(clippingTimeline);
        } catch (IllegalClippingException e3) {
            this.f25714v = e3;
            for (int i3 = 0; i3 < this.f25711s.size(); i3++) {
                this.f25711s.get(i3).u(this.f25714v);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void E() {
        super.E();
        this.f25714v = null;
        this.f25713u = null;
    }

    /* access modifiers changed from: protected */
    public void S(Timeline timeline) {
        if (this.f25714v == null) {
            W(timeline);
        }
    }

    public void c() throws IOException {
        IllegalClippingException illegalClippingException = this.f25714v;
        if (illegalClippingException == null) {
            super.c();
            return;
        }
        throw illegalClippingException;
    }

    public MediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.f26015l.f(mediaPeriodId, allocator, j2), this.f25708p, this.f25715w, this.f25716x);
        this.f25711s.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    public void l(MediaPeriod mediaPeriod) {
        Assertions.g(this.f25711s.remove(mediaPeriod));
        this.f26015l.l(((ClippingMediaPeriod) mediaPeriod).f25696b);
        if (this.f25711s.isEmpty() && !this.f25709q) {
            W(((ClippingTimeline) Assertions.e(this.f25713u)).f25751g);
        }
    }
}
