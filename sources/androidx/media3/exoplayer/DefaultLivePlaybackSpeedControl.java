package androidx.media3.exoplayer;

import android.os.SystemClock;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Util;
import com.google.common.primitives.Longs;

public final class DefaultLivePlaybackSpeedControl implements LivePlaybackSpeedControl {

    /* renamed from: a  reason: collision with root package name */
    private final float f5167a;

    /* renamed from: b  reason: collision with root package name */
    private final float f5168b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5169c;

    /* renamed from: d  reason: collision with root package name */
    private final float f5170d;

    /* renamed from: e  reason: collision with root package name */
    private final long f5171e;

    /* renamed from: f  reason: collision with root package name */
    private final long f5172f;

    /* renamed from: g  reason: collision with root package name */
    private final float f5173g;

    /* renamed from: h  reason: collision with root package name */
    private long f5174h;

    /* renamed from: i  reason: collision with root package name */
    private long f5175i;

    /* renamed from: j  reason: collision with root package name */
    private long f5176j;

    /* renamed from: k  reason: collision with root package name */
    private long f5177k;

    /* renamed from: l  reason: collision with root package name */
    private long f5178l;

    /* renamed from: m  reason: collision with root package name */
    private long f5179m;

    /* renamed from: n  reason: collision with root package name */
    private float f5180n;

    /* renamed from: o  reason: collision with root package name */
    private float f5181o;

    /* renamed from: p  reason: collision with root package name */
    private float f5182p;

    /* renamed from: q  reason: collision with root package name */
    private long f5183q;

    /* renamed from: r  reason: collision with root package name */
    private long f5184r;

    /* renamed from: s  reason: collision with root package name */
    private long f5185s;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private float f5186a = 0.97f;

        /* renamed from: b  reason: collision with root package name */
        private float f5187b = 1.03f;

        /* renamed from: c  reason: collision with root package name */
        private long f5188c = 1000;

        /* renamed from: d  reason: collision with root package name */
        private float f5189d = 1.0E-7f;

        /* renamed from: e  reason: collision with root package name */
        private long f5190e = Util.P0(20);

        /* renamed from: f  reason: collision with root package name */
        private long f5191f = Util.P0(500);

        /* renamed from: g  reason: collision with root package name */
        private float f5192g = 0.999f;

        public DefaultLivePlaybackSpeedControl a() {
            return new DefaultLivePlaybackSpeedControl(this.f5186a, this.f5187b, this.f5188c, this.f5189d, this.f5190e, this.f5191f, this.f5192g);
        }
    }

    private void f(long j2) {
        long j3 = this.f5184r + (this.f5185s * 3);
        if (this.f5179m > j3) {
            float P0 = (float) Util.P0(this.f5169c);
            this.f5179m = Longs.c(j3, this.f5176j, this.f5179m - (((long) ((this.f5182p - 1.0f) * P0)) + ((long) ((this.f5180n - 1.0f) * P0))));
            return;
        }
        long q2 = Util.q(j2 - ((long) (Math.max(0.0f, this.f5182p - 1.0f) / this.f5170d)), this.f5179m, j3);
        this.f5179m = q2;
        long j4 = this.f5178l;
        if (j4 != -9223372036854775807L && q2 > j4) {
            this.f5179m = j4;
        }
    }

    private void g() {
        long j2;
        long j3 = this.f5174h;
        if (j3 != -9223372036854775807L) {
            j2 = this.f5175i;
            if (j2 == -9223372036854775807L) {
                long j4 = this.f5177k;
                if (j4 != -9223372036854775807L && j3 < j4) {
                    j3 = j4;
                }
                j2 = this.f5178l;
                if (j2 == -9223372036854775807L || j3 <= j2) {
                    j2 = j3;
                }
            }
        } else {
            j2 = -9223372036854775807L;
        }
        if (this.f5176j != j2) {
            this.f5176j = j2;
            this.f5179m = j2;
            this.f5184r = -9223372036854775807L;
            this.f5185s = -9223372036854775807L;
            this.f5183q = -9223372036854775807L;
        }
    }

    private static long h(long j2, long j3, float f2) {
        return (long) ((((float) j2) * f2) + ((1.0f - f2) * ((float) j3)));
    }

    private void i(long j2, long j3) {
        long j4 = j2 - j3;
        long j5 = this.f5184r;
        if (j5 == -9223372036854775807L) {
            this.f5184r = j4;
            this.f5185s = 0;
            return;
        }
        long max = Math.max(j4, h(j5, j4, this.f5173g));
        this.f5184r = max;
        this.f5185s = h(this.f5185s, Math.abs(j4 - max), this.f5173g);
    }

    public float a(long j2, long j3) {
        if (this.f5174h == -9223372036854775807L) {
            return 1.0f;
        }
        i(j2, j3);
        if (this.f5183q != -9223372036854775807L && SystemClock.elapsedRealtime() - this.f5183q < this.f5169c) {
            return this.f5182p;
        }
        this.f5183q = SystemClock.elapsedRealtime();
        f(j2);
        long j4 = j2 - this.f5179m;
        if (Math.abs(j4) < this.f5171e) {
            this.f5182p = 1.0f;
        } else {
            this.f5182p = Util.o((this.f5170d * ((float) j4)) + 1.0f, this.f5181o, this.f5180n);
        }
        return this.f5182p;
    }

    public long b() {
        return this.f5179m;
    }

    public void c() {
        long j2 = this.f5179m;
        if (j2 != -9223372036854775807L) {
            long j3 = j2 + this.f5172f;
            this.f5179m = j3;
            long j4 = this.f5178l;
            if (j4 != -9223372036854775807L && j3 > j4) {
                this.f5179m = j4;
            }
            this.f5183q = -9223372036854775807L;
        }
    }

    public void d(long j2) {
        this.f5175i = j2;
        g();
    }

    public void e(MediaItem.LiveConfiguration liveConfiguration) {
        this.f5174h = Util.P0(liveConfiguration.f4153a);
        this.f5177k = Util.P0(liveConfiguration.f4154b);
        this.f5178l = Util.P0(liveConfiguration.f4155c);
        float f2 = liveConfiguration.f4156d;
        if (f2 == -3.4028235E38f) {
            f2 = this.f5167a;
        }
        this.f5181o = f2;
        float f3 = liveConfiguration.f4157e;
        if (f3 == -3.4028235E38f) {
            f3 = this.f5168b;
        }
        this.f5180n = f3;
        if (f2 == 1.0f && f3 == 1.0f) {
            this.f5174h = -9223372036854775807L;
        }
        g();
    }

    private DefaultLivePlaybackSpeedControl(float f2, float f3, long j2, float f4, long j3, long j4, float f5) {
        this.f5167a = f2;
        this.f5168b = f3;
        this.f5169c = j2;
        this.f5170d = f4;
        this.f5171e = j3;
        this.f5172f = j4;
        this.f5173g = f5;
        this.f5174h = -9223372036854775807L;
        this.f5175i = -9223372036854775807L;
        this.f5177k = -9223372036854775807L;
        this.f5178l = -9223372036854775807L;
        this.f5181o = f2;
        this.f5180n = f3;
        this.f5182p = 1.0f;
        this.f5183q = -9223372036854775807L;
        this.f5176j = -9223372036854775807L;
        this.f5179m = -9223372036854775807L;
        this.f5184r = -9223372036854775807L;
        this.f5185s = -9223372036854775807L;
    }
}
