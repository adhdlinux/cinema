package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Longs;

public final class DefaultLivePlaybackSpeedControl implements LivePlaybackSpeedControl {

    /* renamed from: a  reason: collision with root package name */
    private final float f22821a;

    /* renamed from: b  reason: collision with root package name */
    private final float f22822b;

    /* renamed from: c  reason: collision with root package name */
    private final long f22823c;

    /* renamed from: d  reason: collision with root package name */
    private final float f22824d;

    /* renamed from: e  reason: collision with root package name */
    private final long f22825e;

    /* renamed from: f  reason: collision with root package name */
    private final long f22826f;

    /* renamed from: g  reason: collision with root package name */
    private final float f22827g;

    /* renamed from: h  reason: collision with root package name */
    private long f22828h;

    /* renamed from: i  reason: collision with root package name */
    private long f22829i;

    /* renamed from: j  reason: collision with root package name */
    private long f22830j;

    /* renamed from: k  reason: collision with root package name */
    private long f22831k;

    /* renamed from: l  reason: collision with root package name */
    private long f22832l;

    /* renamed from: m  reason: collision with root package name */
    private long f22833m;

    /* renamed from: n  reason: collision with root package name */
    private float f22834n;

    /* renamed from: o  reason: collision with root package name */
    private float f22835o;

    /* renamed from: p  reason: collision with root package name */
    private float f22836p;

    /* renamed from: q  reason: collision with root package name */
    private long f22837q;

    /* renamed from: r  reason: collision with root package name */
    private long f22838r;

    /* renamed from: s  reason: collision with root package name */
    private long f22839s;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private float f22840a = 0.97f;

        /* renamed from: b  reason: collision with root package name */
        private float f22841b = 1.03f;

        /* renamed from: c  reason: collision with root package name */
        private long f22842c = 1000;

        /* renamed from: d  reason: collision with root package name */
        private float f22843d = 1.0E-7f;

        /* renamed from: e  reason: collision with root package name */
        private long f22844e = Util.F0(20);

        /* renamed from: f  reason: collision with root package name */
        private long f22845f = Util.F0(500);

        /* renamed from: g  reason: collision with root package name */
        private float f22846g = 0.999f;

        public DefaultLivePlaybackSpeedControl a() {
            return new DefaultLivePlaybackSpeedControl(this.f22840a, this.f22841b, this.f22842c, this.f22843d, this.f22844e, this.f22845f, this.f22846g);
        }
    }

    private void f(long j2) {
        long j3 = this.f22838r + (this.f22839s * 3);
        if (this.f22833m > j3) {
            float F0 = (float) Util.F0(this.f22823c);
            this.f22833m = Longs.c(j3, this.f22830j, this.f22833m - (((long) ((this.f22836p - 1.0f) * F0)) + ((long) ((this.f22834n - 1.0f) * F0))));
            return;
        }
        long r2 = Util.r(j2 - ((long) (Math.max(0.0f, this.f22836p - 1.0f) / this.f22824d)), this.f22833m, j3);
        this.f22833m = r2;
        long j4 = this.f22832l;
        if (j4 != -9223372036854775807L && r2 > j4) {
            this.f22833m = j4;
        }
    }

    private void g() {
        long j2 = this.f22828h;
        if (j2 != -9223372036854775807L) {
            long j3 = this.f22829i;
            if (j3 != -9223372036854775807L) {
                j2 = j3;
            }
            long j4 = this.f22831k;
            if (j4 != -9223372036854775807L && j2 < j4) {
                j2 = j4;
            }
            long j5 = this.f22832l;
            if (j5 != -9223372036854775807L && j2 > j5) {
                j2 = j5;
            }
        } else {
            j2 = -9223372036854775807L;
        }
        if (this.f22830j != j2) {
            this.f22830j = j2;
            this.f22833m = j2;
            this.f22838r = -9223372036854775807L;
            this.f22839s = -9223372036854775807L;
            this.f22837q = -9223372036854775807L;
        }
    }

    private static long h(long j2, long j3, float f2) {
        return (long) ((((float) j2) * f2) + ((1.0f - f2) * ((float) j3)));
    }

    private void i(long j2, long j3) {
        long j4 = j2 - j3;
        long j5 = this.f22838r;
        if (j5 == -9223372036854775807L) {
            this.f22838r = j4;
            this.f22839s = 0;
            return;
        }
        long max = Math.max(j4, h(j5, j4, this.f22827g));
        this.f22838r = max;
        this.f22839s = h(this.f22839s, Math.abs(j4 - max), this.f22827g);
    }

    public float a(long j2, long j3) {
        if (this.f22828h == -9223372036854775807L) {
            return 1.0f;
        }
        i(j2, j3);
        if (this.f22837q != -9223372036854775807L && SystemClock.elapsedRealtime() - this.f22837q < this.f22823c) {
            return this.f22836p;
        }
        this.f22837q = SystemClock.elapsedRealtime();
        f(j2);
        long j4 = j2 - this.f22833m;
        if (Math.abs(j4) < this.f22825e) {
            this.f22836p = 1.0f;
        } else {
            this.f22836p = Util.p((this.f22824d * ((float) j4)) + 1.0f, this.f22835o, this.f22834n);
        }
        return this.f22836p;
    }

    public long b() {
        return this.f22833m;
    }

    public void c() {
        long j2 = this.f22833m;
        if (j2 != -9223372036854775807L) {
            long j3 = j2 + this.f22826f;
            this.f22833m = j3;
            long j4 = this.f22832l;
            if (j4 != -9223372036854775807L && j3 > j4) {
                this.f22833m = j4;
            }
            this.f22837q = -9223372036854775807L;
        }
    }

    public void d(long j2) {
        this.f22829i = j2;
        g();
    }

    public void e(MediaItem.LiveConfiguration liveConfiguration) {
        this.f22828h = Util.F0(liveConfiguration.f23192b);
        this.f22831k = Util.F0(liveConfiguration.f23193c);
        this.f22832l = Util.F0(liveConfiguration.f23194d);
        float f2 = liveConfiguration.f23195e;
        if (f2 == -3.4028235E38f) {
            f2 = this.f22821a;
        }
        this.f22835o = f2;
        float f3 = liveConfiguration.f23196f;
        if (f3 == -3.4028235E38f) {
            f3 = this.f22822b;
        }
        this.f22834n = f3;
        if (f2 == 1.0f && f3 == 1.0f) {
            this.f22828h = -9223372036854775807L;
        }
        g();
    }

    private DefaultLivePlaybackSpeedControl(float f2, float f3, long j2, float f4, long j3, long j4, float f5) {
        this.f22821a = f2;
        this.f22822b = f3;
        this.f22823c = j2;
        this.f22824d = f4;
        this.f22825e = j3;
        this.f22826f = j4;
        this.f22827g = f5;
        this.f22828h = -9223372036854775807L;
        this.f22829i = -9223372036854775807L;
        this.f22831k = -9223372036854775807L;
        this.f22832l = -9223372036854775807L;
        this.f22835o = f2;
        this.f22834n = f3;
        this.f22836p = 1.0f;
        this.f22837q = -9223372036854775807L;
        this.f22830j = -9223372036854775807L;
        this.f22833m = -9223372036854775807L;
        this.f22838r = -9223372036854775807L;
        this.f22839s = -9223372036854775807L;
    }
}
