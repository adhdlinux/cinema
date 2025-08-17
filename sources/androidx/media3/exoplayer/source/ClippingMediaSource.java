package androidx.media3.exoplayer.source;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.util.ArrayList;

public final class ClippingMediaSource extends WrappingMediaSource {

    /* renamed from: m  reason: collision with root package name */
    private final long f6830m;

    /* renamed from: n  reason: collision with root package name */
    private final long f6831n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f6832o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f6833p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f6834q;

    /* renamed from: r  reason: collision with root package name */
    private final ArrayList<ClippingMediaPeriod> f6835r;

    /* renamed from: s  reason: collision with root package name */
    private final Timeline.Window f6836s;

    /* renamed from: t  reason: collision with root package name */
    private ClippingTimeline f6837t;

    /* renamed from: u  reason: collision with root package name */
    private IllegalClippingException f6838u;

    /* renamed from: v  reason: collision with root package name */
    private long f6839v;

    /* renamed from: w  reason: collision with root package name */
    private long f6840w;

    private static final class ClippingTimeline extends ForwardingTimeline {

        /* renamed from: f  reason: collision with root package name */
        private final long f6841f;

        /* renamed from: g  reason: collision with root package name */
        private final long f6842g;

        /* renamed from: h  reason: collision with root package name */
        private final long f6843h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f6844i;

        public ClippingTimeline(Timeline timeline, long j2, long j3) throws IllegalClippingException {
            super(timeline);
            long j4;
            long j5;
            boolean z2 = false;
            if (timeline.i() == 1) {
                Timeline.Window n2 = timeline.n(0, new Timeline.Window());
                long max = Math.max(0, j2);
                if (n2.f4382k || max == 0 || n2.f4379h) {
                    if (j3 == Long.MIN_VALUE) {
                        j4 = n2.f4384m;
                    } else {
                        j4 = Math.max(0, j3);
                    }
                    long j6 = n2.f4384m;
                    if (j6 != -9223372036854775807L) {
                        j4 = j4 > j6 ? j6 : j4;
                        if (max > j4) {
                            throw new IllegalClippingException(2);
                        }
                    }
                    this.f6841f = max;
                    this.f6842g = j4;
                    int i2 = (j4 > -9223372036854775807L ? 1 : (j4 == -9223372036854775807L ? 0 : -1));
                    if (i2 == 0) {
                        j5 = -9223372036854775807L;
                    } else {
                        j5 = j4 - max;
                    }
                    this.f6843h = j5;
                    if (n2.f4380i && (i2 == 0 || (j6 != -9223372036854775807L && j4 == j6))) {
                        z2 = true;
                    }
                    this.f6844i = z2;
                    return;
                }
                throw new IllegalClippingException(1);
            }
            throw new IllegalClippingException(0);
        }

        public Timeline.Period g(int i2, Timeline.Period period, boolean z2) {
            long j2;
            this.f6929e.g(0, period, z2);
            long n2 = period.n() - this.f6841f;
            long j3 = this.f6843h;
            if (j3 == -9223372036854775807L) {
                j2 = -9223372036854775807L;
            } else {
                j2 = j3 - n2;
            }
            return period.s(period.f4355a, period.f4356b, 0, j2, n2);
        }

        public Timeline.Window o(int i2, Timeline.Window window, long j2) {
            this.f6929e.o(0, window, 0);
            long j3 = window.f4387p;
            long j4 = this.f6841f;
            window.f4387p = j3 + j4;
            window.f4384m = this.f6843h;
            window.f4380i = this.f6844i;
            long j5 = window.f4383l;
            if (j5 != -9223372036854775807L) {
                long max = Math.max(j5, j4);
                window.f4383l = max;
                long j6 = this.f6842g;
                if (j6 != -9223372036854775807L) {
                    max = Math.min(max, j6);
                }
                window.f4383l = max - this.f6841f;
            }
            long t1 = Util.t1(this.f6841f);
            long j7 = window.f4376e;
            if (j7 != -9223372036854775807L) {
                window.f4376e = j7 + t1;
            }
            long j8 = window.f4377f;
            if (j8 != -9223372036854775807L) {
                window.f4377f = j8 + t1;
            }
            return window;
        }
    }

    public static final class IllegalClippingException extends IOException {

        /* renamed from: b  reason: collision with root package name */
        public final int f6845b;

        public IllegalClippingException(int i2) {
            super("Illegal clipping: " + a(i2));
            this.f6845b = i2;
        }

        private static String a(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j2) {
        this(mediaSource, 0, j2, true, false, true);
    }

    private void W(Timeline timeline) {
        long j2;
        timeline.n(0, this.f6836s);
        long e2 = this.f6836s.e();
        long j3 = Long.MIN_VALUE;
        if (this.f6837t == null || this.f6835r.isEmpty() || this.f6833p) {
            long j4 = this.f6830m;
            long j5 = this.f6831n;
            if (this.f6834q) {
                long c2 = this.f6836s.c();
                j4 += c2;
                j5 += c2;
            }
            this.f6839v = e2 + j4;
            if (this.f6831n != Long.MIN_VALUE) {
                j3 = e2 + j5;
            }
            this.f6840w = j3;
            int size = this.f6835r.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f6835r.get(i2).w(this.f6839v, this.f6840w);
            }
            j2 = j4;
            j3 = j5;
        } else {
            long j6 = this.f6839v - e2;
            if (this.f6831n != Long.MIN_VALUE) {
                j3 = this.f6840w - e2;
            }
            j2 = j6;
        }
        try {
            ClippingTimeline clippingTimeline = new ClippingTimeline(timeline, j2, j3);
            this.f6837t = clippingTimeline;
            A(clippingTimeline);
        } catch (IllegalClippingException e3) {
            this.f6838u = e3;
            for (int i3 = 0; i3 < this.f6835r.size(); i3++) {
                this.f6835r.get(i3).u(this.f6838u);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void B() {
        super.B();
        this.f6838u = null;
        this.f6837t = null;
    }

    /* access modifiers changed from: protected */
    public void S(Timeline timeline) {
        if (this.f6838u == null) {
            W(timeline);
        }
    }

    public void c() throws IOException {
        IllegalClippingException illegalClippingException = this.f6838u;
        if (illegalClippingException == null) {
            super.c();
            return;
        }
        throw illegalClippingException;
    }

    public MediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.f7184k.i(mediaPeriodId, allocator, j2), this.f6832o, this.f6839v, this.f6840w);
        this.f6835r.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    public void l(MediaPeriod mediaPeriod) {
        Assertions.h(this.f6835r.remove(mediaPeriod));
        this.f7184k.l(((ClippingMediaPeriod) mediaPeriod).f6820b);
        if (this.f6835r.isEmpty() && !this.f6833p) {
            W(((ClippingTimeline) Assertions.f(this.f6837t)).f6929e);
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j2, long j3, boolean z2, boolean z3, boolean z4) {
        super((MediaSource) Assertions.f(mediaSource));
        Assertions.a(j2 >= 0);
        this.f6830m = j2;
        this.f6831n = j3;
        this.f6832o = z2;
        this.f6833p = z3;
        this.f6834q = z4;
        this.f6835r = new ArrayList<>();
        this.f6836s = new Timeline.Window();
    }
}
