package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.lang.reflect.Method;

final class AudioTrackPositionTracker {
    private long A;
    private long B;
    private long C;
    private long D;
    private boolean E;
    private long F;
    private long G;

    /* renamed from: a  reason: collision with root package name */
    private final Listener f23708a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f23709b;

    /* renamed from: c  reason: collision with root package name */
    private AudioTrack f23710c;

    /* renamed from: d  reason: collision with root package name */
    private int f23711d;

    /* renamed from: e  reason: collision with root package name */
    private int f23712e;

    /* renamed from: f  reason: collision with root package name */
    private AudioTimestampPoller f23713f;

    /* renamed from: g  reason: collision with root package name */
    private int f23714g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23715h;

    /* renamed from: i  reason: collision with root package name */
    private long f23716i;

    /* renamed from: j  reason: collision with root package name */
    private float f23717j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23718k;

    /* renamed from: l  reason: collision with root package name */
    private long f23719l;

    /* renamed from: m  reason: collision with root package name */
    private long f23720m;

    /* renamed from: n  reason: collision with root package name */
    private Method f23721n;

    /* renamed from: o  reason: collision with root package name */
    private long f23722o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f23723p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f23724q;

    /* renamed from: r  reason: collision with root package name */
    private long f23725r;

    /* renamed from: s  reason: collision with root package name */
    private long f23726s;

    /* renamed from: t  reason: collision with root package name */
    private long f23727t;

    /* renamed from: u  reason: collision with root package name */
    private long f23728u;

    /* renamed from: v  reason: collision with root package name */
    private long f23729v;

    /* renamed from: w  reason: collision with root package name */
    private int f23730w;

    /* renamed from: x  reason: collision with root package name */
    private int f23731x;

    /* renamed from: y  reason: collision with root package name */
    private long f23732y;

    /* renamed from: z  reason: collision with root package name */
    private long f23733z;

    public interface Listener {
        void a(int i2, long j2);

        void b(long j2);

        void c(long j2);

        void d(long j2, long j3, long j4, long j5);

        void e(long j2, long j3, long j4, long j5);
    }

    public AudioTrackPositionTracker(Listener listener) {
        this.f23708a = (Listener) Assertions.e(listener);
        if (Util.f28808a >= 18) {
            try {
                this.f23721n = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f23709b = new long[10];
    }

    private boolean a() {
        if (this.f23715h && ((AudioTrack) Assertions.e(this.f23710c)).getPlayState() == 2 && e() == 0) {
            return true;
        }
        return false;
    }

    private long b(long j2) {
        return (j2 * 1000000) / ((long) this.f23714g);
    }

    private long e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.f23732y;
        if (j2 != -9223372036854775807L) {
            return Math.min(this.B, this.A + ((Util.b0((elapsedRealtime * 1000) - j2, this.f23717j) * ((long) this.f23714g)) / 1000000));
        }
        if (elapsedRealtime - this.f23726s >= 5) {
            v(elapsedRealtime);
            this.f23726s = elapsedRealtime;
        }
        return this.f23727t + (this.f23728u << 32);
    }

    private long f() {
        return b(e());
    }

    private void l(long j2) {
        AudioTimestampPoller audioTimestampPoller = (AudioTimestampPoller) Assertions.e(this.f23713f);
        if (audioTimestampPoller.e(j2)) {
            long c2 = audioTimestampPoller.c();
            long b2 = audioTimestampPoller.b();
            long f2 = f();
            if (Math.abs(c2 - j2) > 5000000) {
                this.f23708a.e(b2, c2, j2, f2);
                audioTimestampPoller.f();
            } else if (Math.abs(b(b2) - f2) > 5000000) {
                this.f23708a.d(b2, c2, j2, f2);
                audioTimestampPoller.f();
            } else {
                audioTimestampPoller.a();
            }
        }
    }

    private void m() {
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.f23720m >= NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
            long f2 = f();
            if (f2 != 0) {
                this.f23709b[this.f23730w] = Util.g0(f2, this.f23717j) - nanoTime;
                this.f23730w = (this.f23730w + 1) % 10;
                int i2 = this.f23731x;
                if (i2 < 10) {
                    this.f23731x = i2 + 1;
                }
                this.f23720m = nanoTime;
                this.f23719l = 0;
                int i3 = 0;
                while (true) {
                    int i4 = this.f23731x;
                    if (i3 >= i4) {
                        break;
                    }
                    this.f23719l += this.f23709b[i3] / ((long) i4);
                    i3++;
                }
            } else {
                return;
            }
        }
        if (!this.f23715h) {
            l(nanoTime);
            n(nanoTime);
        }
    }

    private void n(long j2) {
        Method method;
        if (this.f23724q && (method = this.f23721n) != null && j2 - this.f23725r >= 500000) {
            try {
                long intValue = (((long) ((Integer) Util.j((Integer) method.invoke(Assertions.e(this.f23710c), new Object[0]))).intValue()) * 1000) - this.f23716i;
                this.f23722o = intValue;
                long max = Math.max(intValue, 0);
                this.f23722o = max;
                if (max > 5000000) {
                    this.f23708a.c(max);
                    this.f23722o = 0;
                }
            } catch (Exception unused) {
                this.f23721n = null;
            }
            this.f23725r = j2;
        }
    }

    private static boolean o(int i2) {
        return Util.f28808a < 23 && (i2 == 5 || i2 == 6);
    }

    private void r() {
        this.f23719l = 0;
        this.f23731x = 0;
        this.f23730w = 0;
        this.f23720m = 0;
        this.D = 0;
        this.G = 0;
        this.f23718k = false;
    }

    private void v(long j2) {
        AudioTrack audioTrack = (AudioTrack) Assertions.e(this.f23710c);
        int playState = audioTrack.getPlayState();
        if (playState != 1) {
            long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
            if (this.f23715h) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f23729v = this.f23727t;
                }
                playbackHeadPosition += this.f23729v;
            }
            if (Util.f28808a <= 29) {
                if (playbackHeadPosition != 0 || this.f23727t <= 0 || playState != 3) {
                    this.f23733z = -9223372036854775807L;
                } else if (this.f23733z == -9223372036854775807L) {
                    this.f23733z = j2;
                    return;
                } else {
                    return;
                }
            }
            if (this.f23727t > playbackHeadPosition) {
                this.f23728u++;
            }
            this.f23727t = playbackHeadPosition;
        }
    }

    public int c(long j2) {
        return this.f23712e - ((int) (j2 - (e() * ((long) this.f23711d))));
    }

    public long d(boolean z2) {
        long j2;
        if (((AudioTrack) Assertions.e(this.f23710c)).getPlayState() == 3) {
            m();
        }
        long nanoTime = System.nanoTime() / 1000;
        AudioTimestampPoller audioTimestampPoller = (AudioTimestampPoller) Assertions.e(this.f23713f);
        boolean d2 = audioTimestampPoller.d();
        if (d2) {
            j2 = b(audioTimestampPoller.b()) + Util.b0(nanoTime - audioTimestampPoller.c(), this.f23717j);
        } else {
            if (this.f23731x == 0) {
                j2 = f();
            } else {
                j2 = Util.b0(this.f23719l + nanoTime, this.f23717j);
            }
            if (!z2) {
                j2 = Math.max(0, j2 - this.f23722o);
            }
        }
        if (this.E != d2) {
            this.G = this.D;
            this.F = this.C;
        }
        long j3 = nanoTime - this.G;
        if (j3 < 1000000) {
            long j4 = (j3 * 1000) / 1000000;
            j2 = ((j2 * j4) + ((1000 - j4) * (this.F + Util.b0(j3, this.f23717j)))) / 1000;
        }
        if (!this.f23718k) {
            long j5 = this.C;
            if (j2 > j5) {
                this.f23718k = true;
                this.f23708a.b(System.currentTimeMillis() - Util.i1(Util.g0(Util.i1(j2 - j5), this.f23717j)));
            }
        }
        this.D = nanoTime;
        this.C = j2;
        this.E = d2;
        return j2;
    }

    public void g(long j2) {
        this.A = e();
        this.f23732y = SystemClock.elapsedRealtime() * 1000;
        this.B = j2;
    }

    public boolean h(long j2) {
        return j2 > e() || a();
    }

    public boolean i() {
        return ((AudioTrack) Assertions.e(this.f23710c)).getPlayState() == 3;
    }

    public boolean j(long j2) {
        if (this.f23733z == -9223372036854775807L || j2 <= 0 || SystemClock.elapsedRealtime() - this.f23733z < 200) {
            return false;
        }
        return true;
    }

    public boolean k(long j2) {
        int playState = ((AudioTrack) Assertions.e(this.f23710c)).getPlayState();
        if (this.f23715h) {
            if (playState == 2) {
                this.f23723p = false;
                return false;
            } else if (playState == 1 && e() == 0) {
                return false;
            }
        }
        boolean z2 = this.f23723p;
        boolean h2 = h(j2);
        this.f23723p = h2;
        if (z2 && !h2 && playState != 1) {
            this.f23708a.a(this.f23712e, Util.i1(this.f23716i));
        }
        return true;
    }

    public boolean p() {
        r();
        if (this.f23732y != -9223372036854775807L) {
            return false;
        }
        ((AudioTimestampPoller) Assertions.e(this.f23713f)).g();
        return true;
    }

    public void q() {
        r();
        this.f23710c = null;
        this.f23713f = null;
    }

    public void s(AudioTrack audioTrack, boolean z2, int i2, int i3, int i4) {
        boolean z3;
        long j2;
        this.f23710c = audioTrack;
        this.f23711d = i3;
        this.f23712e = i4;
        this.f23713f = new AudioTimestampPoller(audioTrack);
        this.f23714g = audioTrack.getSampleRate();
        if (!z2 || !o(i2)) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.f23715h = z3;
        boolean x02 = Util.x0(i2);
        this.f23724q = x02;
        if (x02) {
            j2 = b((long) (i4 / i3));
        } else {
            j2 = -9223372036854775807L;
        }
        this.f23716i = j2;
        this.f23727t = 0;
        this.f23728u = 0;
        this.f23729v = 0;
        this.f23723p = false;
        this.f23732y = -9223372036854775807L;
        this.f23733z = -9223372036854775807L;
        this.f23725r = 0;
        this.f23722o = 0;
        this.f23717j = 1.0f;
    }

    public void t(float f2) {
        this.f23717j = f2;
        AudioTimestampPoller audioTimestampPoller = this.f23713f;
        if (audioTimestampPoller != null) {
            audioTimestampPoller.g();
        }
        r();
    }

    public void u() {
        ((AudioTimestampPoller) Assertions.e(this.f23713f)).g();
    }
}
