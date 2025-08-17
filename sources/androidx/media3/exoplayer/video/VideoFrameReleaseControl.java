package androidx.media3.exoplayer.video;

import android.content.Context;
import android.view.Surface;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;

public final class VideoFrameReleaseControl {

    /* renamed from: a  reason: collision with root package name */
    private final FrameTimingEvaluator f7708a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoFrameReleaseHelper f7709b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7710c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7711d;

    /* renamed from: e  reason: collision with root package name */
    private int f7712e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f7713f = -9223372036854775807L;

    /* renamed from: g  reason: collision with root package name */
    private long f7714g;

    /* renamed from: h  reason: collision with root package name */
    private long f7715h = -9223372036854775807L;

    /* renamed from: i  reason: collision with root package name */
    private long f7716i = -9223372036854775807L;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7717j;

    /* renamed from: k  reason: collision with root package name */
    private float f7718k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    private Clock f7719l = Clock.f4616a;

    public static class FrameReleaseInfo {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public long f7720a = -9223372036854775807L;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public long f7721b = -9223372036854775807L;

        /* access modifiers changed from: private */
        public void h() {
            this.f7720a = -9223372036854775807L;
            this.f7721b = -9223372036854775807L;
        }

        public long f() {
            return this.f7720a;
        }

        public long g() {
            return this.f7721b;
        }
    }

    public interface FrameTimingEvaluator {
        boolean D(long j2, long j3, boolean z2);

        boolean y(long j2, long j3);

        boolean z(long j2, long j3, long j4, boolean z2, boolean z3) throws ExoPlaybackException;
    }

    public VideoFrameReleaseControl(Context context, FrameTimingEvaluator frameTimingEvaluator, long j2) {
        this.f7708a = frameTimingEvaluator;
        this.f7710c = j2;
        this.f7709b = new VideoFrameReleaseHelper(context);
    }

    private long b(long j2, long j3, long j4) {
        long j5 = (long) (((double) (j4 - j2)) / ((double) this.f7718k));
        if (this.f7711d) {
            return j5 - (Util.P0(this.f7719l.elapsedRealtime()) - j3);
        }
        return j5;
    }

    private void f(int i2) {
        this.f7712e = Math.min(this.f7712e, i2);
    }

    private boolean s(long j2, long j3, long j4) {
        if (this.f7716i != -9223372036854775807L && !this.f7717j) {
            return false;
        }
        int i2 = this.f7712e;
        if (i2 == 0) {
            return this.f7711d;
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                long P0 = Util.P0(this.f7719l.elapsedRealtime()) - this.f7714g;
                if (!this.f7711d || !this.f7708a.y(j3, P0)) {
                    return false;
                }
                return true;
            }
            throw new IllegalStateException();
        } else if (j2 >= j4) {
            return true;
        } else {
            return false;
        }
    }

    public void a() {
        if (this.f7712e == 0) {
            this.f7712e = 1;
        }
    }

    public int c(long j2, long j3, long j4, long j5, boolean z2, FrameReleaseInfo frameReleaseInfo) throws ExoPlaybackException {
        long j6 = j2;
        long j7 = j3;
        FrameReleaseInfo frameReleaseInfo2 = frameReleaseInfo;
        frameReleaseInfo.h();
        if (this.f7713f == -9223372036854775807L) {
            this.f7713f = j7;
        }
        if (this.f7715h != j6) {
            this.f7709b.h(j6);
            this.f7715h = j6;
        }
        long unused = frameReleaseInfo2.f7720a = b(j3, j4, j2);
        boolean z3 = false;
        if (s(j3, frameReleaseInfo.f7720a, j5)) {
            return 0;
        }
        if (!this.f7711d || j7 == this.f7713f) {
            return 5;
        }
        long nanoTime = this.f7719l.nanoTime();
        long unused2 = frameReleaseInfo2.f7721b = this.f7709b.b((frameReleaseInfo.f7720a * 1000) + nanoTime);
        long unused3 = frameReleaseInfo2.f7720a = (frameReleaseInfo.f7721b - nanoTime) / 1000;
        if (this.f7716i != -9223372036854775807L && !this.f7717j) {
            z3 = true;
        }
        if (this.f7708a.z(frameReleaseInfo.f7720a, j3, j4, z2, z3)) {
            return 4;
        }
        if (this.f7708a.D(frameReleaseInfo.f7720a, j4, z2)) {
            if (z3) {
                return 3;
            }
            return 2;
        } else if (frameReleaseInfo.f7720a > 50000) {
            return 5;
        } else {
            return 1;
        }
    }

    public boolean d(boolean z2) {
        if (z2 && this.f7712e == 3) {
            this.f7716i = -9223372036854775807L;
            return true;
        } else if (this.f7716i == -9223372036854775807L) {
            return false;
        } else {
            if (this.f7719l.elapsedRealtime() < this.f7716i) {
                return true;
            }
            this.f7716i = -9223372036854775807L;
            return false;
        }
    }

    public void e(boolean z2) {
        long j2;
        this.f7717j = z2;
        if (this.f7710c > 0) {
            j2 = this.f7719l.elapsedRealtime() + this.f7710c;
        } else {
            j2 = -9223372036854775807L;
        }
        this.f7716i = j2;
    }

    public void g() {
        f(0);
    }

    public void h(boolean z2) {
        this.f7712e = z2 ? 1 : 0;
    }

    public boolean i() {
        boolean z2;
        if (this.f7712e != 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f7712e = 3;
        this.f7714g = Util.P0(this.f7719l.elapsedRealtime());
        return z2;
    }

    public void j() {
        f(2);
    }

    public void k() {
        this.f7711d = true;
        this.f7714g = Util.P0(this.f7719l.elapsedRealtime());
        this.f7709b.k();
    }

    public void l() {
        this.f7711d = false;
        this.f7716i = -9223372036854775807L;
        this.f7709b.l();
    }

    public void m() {
        this.f7709b.j();
        this.f7715h = -9223372036854775807L;
        this.f7713f = -9223372036854775807L;
        f(1);
        this.f7716i = -9223372036854775807L;
    }

    public void n(int i2) {
        this.f7709b.o(i2);
    }

    public void o(Clock clock) {
        this.f7719l = clock;
    }

    public void p(float f2) {
        this.f7709b.g(f2);
    }

    public void q(Surface surface) {
        this.f7709b.m(surface);
        f(1);
    }

    public void r(float f2) {
        if (f2 != this.f7718k) {
            this.f7718k = f2;
            this.f7709b.i(f2);
        }
    }
}
