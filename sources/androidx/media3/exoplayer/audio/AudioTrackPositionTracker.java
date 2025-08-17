package androidx.media3.exoplayer.audio;

import android.media.AudioTrack;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
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
    private boolean H;
    private long I;
    private Clock J;

    /* renamed from: a  reason: collision with root package name */
    private final Listener f5685a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f5686b;

    /* renamed from: c  reason: collision with root package name */
    private AudioTrack f5687c;

    /* renamed from: d  reason: collision with root package name */
    private int f5688d;

    /* renamed from: e  reason: collision with root package name */
    private int f5689e;

    /* renamed from: f  reason: collision with root package name */
    private AudioTimestampPoller f5690f;

    /* renamed from: g  reason: collision with root package name */
    private int f5691g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5692h;

    /* renamed from: i  reason: collision with root package name */
    private long f5693i;

    /* renamed from: j  reason: collision with root package name */
    private float f5694j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5695k;

    /* renamed from: l  reason: collision with root package name */
    private long f5696l;

    /* renamed from: m  reason: collision with root package name */
    private long f5697m;

    /* renamed from: n  reason: collision with root package name */
    private Method f5698n;

    /* renamed from: o  reason: collision with root package name */
    private long f5699o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f5700p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f5701q;

    /* renamed from: r  reason: collision with root package name */
    private long f5702r;

    /* renamed from: s  reason: collision with root package name */
    private long f5703s;

    /* renamed from: t  reason: collision with root package name */
    private long f5704t;

    /* renamed from: u  reason: collision with root package name */
    private long f5705u;

    /* renamed from: v  reason: collision with root package name */
    private long f5706v;

    /* renamed from: w  reason: collision with root package name */
    private int f5707w;

    /* renamed from: x  reason: collision with root package name */
    private int f5708x;

    /* renamed from: y  reason: collision with root package name */
    private long f5709y;

    /* renamed from: z  reason: collision with root package name */
    private long f5710z;

    public interface Listener {
        void a(int i2, long j2);

        void b(long j2);

        void c(long j2);

        void d(long j2, long j3, long j4, long j5);

        void e(long j2, long j3, long j4, long j5);
    }

    public AudioTrackPositionTracker(Listener listener) {
        this.f5685a = (Listener) Assertions.f(listener);
        try {
            this.f5698n = AudioTrack.class.getMethod("getLatency", (Class[]) null);
        } catch (NoSuchMethodException unused) {
        }
        this.f5686b = new long[10];
        this.J = Clock.f4616a;
    }

    private boolean b() {
        if (this.f5692h && ((AudioTrack) Assertions.f(this.f5687c)).getPlayState() == 2 && e() == 0) {
            return true;
        }
        return false;
    }

    private long e() {
        long elapsedRealtime = this.J.elapsedRealtime();
        if (this.f5709y == -9223372036854775807L) {
            if (elapsedRealtime - this.f5703s >= 5) {
                w(elapsedRealtime);
                this.f5703s = elapsedRealtime;
            }
            return this.f5704t + this.I + (this.f5705u << 32);
        } else if (((AudioTrack) Assertions.f(this.f5687c)).getPlayState() == 2) {
            return this.A;
        } else {
            return Math.min(this.B, this.A + Util.F(Util.e0(Util.P0(elapsedRealtime) - this.f5709y, this.f5694j), this.f5691g));
        }
    }

    private long f() {
        return Util.b1(e(), this.f5691g);
    }

    private void l(long j2) {
        AudioTimestampPoller audioTimestampPoller = (AudioTimestampPoller) Assertions.f(this.f5690f);
        if (audioTimestampPoller.f(j2)) {
            long d2 = audioTimestampPoller.d();
            long c2 = audioTimestampPoller.c();
            long f2 = f();
            if (Math.abs(d2 - j2) > 5000000) {
                this.f5685a.e(c2, d2, j2, f2);
                audioTimestampPoller.g();
            } else if (Math.abs(Util.b1(c2, this.f5691g) - f2) > 5000000) {
                this.f5685a.d(c2, d2, j2, f2);
                audioTimestampPoller.g();
            } else {
                audioTimestampPoller.a();
            }
        }
    }

    private void m() {
        long nanoTime = this.J.nanoTime() / 1000;
        if (nanoTime - this.f5697m >= NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
            long f2 = f();
            if (f2 != 0) {
                this.f5686b[this.f5707w] = Util.j0(f2, this.f5694j) - nanoTime;
                this.f5707w = (this.f5707w + 1) % 10;
                int i2 = this.f5708x;
                if (i2 < 10) {
                    this.f5708x = i2 + 1;
                }
                this.f5697m = nanoTime;
                this.f5696l = 0;
                int i3 = 0;
                while (true) {
                    int i4 = this.f5708x;
                    if (i3 >= i4) {
                        break;
                    }
                    this.f5696l += this.f5686b[i3] / ((long) i4);
                    i3++;
                }
            } else {
                return;
            }
        }
        if (!this.f5692h) {
            l(nanoTime);
            n(nanoTime);
        }
    }

    private void n(long j2) {
        Method method;
        if (this.f5701q && (method = this.f5698n) != null && j2 - this.f5702r >= 500000) {
            try {
                long intValue = (((long) ((Integer) Util.i((Integer) method.invoke(Assertions.f(this.f5687c), new Object[0]))).intValue()) * 1000) - this.f5693i;
                this.f5699o = intValue;
                long max = Math.max(intValue, 0);
                this.f5699o = max;
                if (max > 5000000) {
                    this.f5685a.c(max);
                    this.f5699o = 0;
                }
            } catch (Exception unused) {
                this.f5698n = null;
            }
            this.f5702r = j2;
        }
    }

    private static boolean o(int i2) {
        return Util.f4714a < 23 && (i2 == 5 || i2 == 6);
    }

    private void r() {
        this.f5696l = 0;
        this.f5708x = 0;
        this.f5707w = 0;
        this.f5697m = 0;
        this.D = 0;
        this.G = 0;
        this.f5695k = false;
    }

    private void w(long j2) {
        AudioTrack audioTrack = (AudioTrack) Assertions.f(this.f5687c);
        int playState = audioTrack.getPlayState();
        if (playState != 1) {
            long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
            if (this.f5692h) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f5706v = this.f5704t;
                }
                playbackHeadPosition += this.f5706v;
            }
            if (Util.f4714a <= 29) {
                if (playbackHeadPosition != 0 || this.f5704t <= 0 || playState != 3) {
                    this.f5710z = -9223372036854775807L;
                } else if (this.f5710z == -9223372036854775807L) {
                    this.f5710z = j2;
                    return;
                } else {
                    return;
                }
            }
            long j3 = this.f5704t;
            if (j3 > playbackHeadPosition) {
                if (this.H) {
                    this.I += j3;
                    this.H = false;
                } else {
                    this.f5705u++;
                }
            }
            this.f5704t = playbackHeadPosition;
        }
    }

    public void a() {
        this.H = true;
        AudioTimestampPoller audioTimestampPoller = this.f5690f;
        if (audioTimestampPoller != null) {
            audioTimestampPoller.b();
        }
    }

    public int c(long j2) {
        return this.f5689e - ((int) (j2 - (e() * ((long) this.f5688d))));
    }

    public long d(boolean z2) {
        long j2;
        if (((AudioTrack) Assertions.f(this.f5687c)).getPlayState() == 3) {
            m();
        }
        long nanoTime = this.J.nanoTime() / 1000;
        AudioTimestampPoller audioTimestampPoller = (AudioTimestampPoller) Assertions.f(this.f5690f);
        boolean e2 = audioTimestampPoller.e();
        if (e2) {
            j2 = Util.b1(audioTimestampPoller.c(), this.f5691g) + Util.e0(nanoTime - audioTimestampPoller.d(), this.f5694j);
        } else {
            if (this.f5708x == 0) {
                j2 = f();
            } else {
                j2 = Util.e0(this.f5696l + nanoTime, this.f5694j);
            }
            if (!z2) {
                j2 = Math.max(0, j2 - this.f5699o);
            }
        }
        if (this.E != e2) {
            this.G = this.D;
            this.F = this.C;
        }
        long j3 = nanoTime - this.G;
        if (j3 < 1000000) {
            long j4 = (j3 * 1000) / 1000000;
            j2 = ((j2 * j4) + ((1000 - j4) * (this.F + Util.e0(j3, this.f5694j)))) / 1000;
        }
        if (!this.f5695k) {
            long j5 = this.C;
            if (j2 > j5) {
                this.f5695k = true;
                this.f5685a.b(this.J.currentTimeMillis() - Util.t1(Util.j0(Util.t1(j2 - j5), this.f5694j)));
            }
        }
        this.D = nanoTime;
        this.C = j2;
        this.E = e2;
        return j2;
    }

    public void g(long j2) {
        this.A = e();
        this.f5709y = Util.P0(this.J.elapsedRealtime());
        this.B = j2;
    }

    public boolean h(long j2) {
        if (j2 > Util.F(d(false), this.f5691g) || b()) {
            return true;
        }
        return false;
    }

    public boolean i() {
        return ((AudioTrack) Assertions.f(this.f5687c)).getPlayState() == 3;
    }

    public boolean j(long j2) {
        if (this.f5710z == -9223372036854775807L || j2 <= 0 || this.J.elapsedRealtime() - this.f5710z < 200) {
            return false;
        }
        return true;
    }

    public boolean k(long j2) {
        int playState = ((AudioTrack) Assertions.f(this.f5687c)).getPlayState();
        if (this.f5692h) {
            if (playState == 2) {
                this.f5700p = false;
                return false;
            } else if (playState == 1 && e() == 0) {
                return false;
            }
        }
        boolean z2 = this.f5700p;
        boolean h2 = h(j2);
        this.f5700p = h2;
        if (z2 && !h2 && playState != 1) {
            this.f5685a.a(this.f5689e, Util.t1(this.f5693i));
        }
        return true;
    }

    public boolean p() {
        r();
        if (this.f5709y == -9223372036854775807L) {
            ((AudioTimestampPoller) Assertions.f(this.f5690f)).h();
            return true;
        }
        this.A = e();
        return false;
    }

    public void q() {
        r();
        this.f5687c = null;
        this.f5690f = null;
    }

    public void s(AudioTrack audioTrack, boolean z2, int i2, int i3, int i4) {
        boolean z3;
        long j2;
        this.f5687c = audioTrack;
        this.f5688d = i3;
        this.f5689e = i4;
        this.f5690f = new AudioTimestampPoller(audioTrack);
        this.f5691g = audioTrack.getSampleRate();
        if (!z2 || !o(i2)) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.f5692h = z3;
        boolean F0 = Util.F0(i2);
        this.f5701q = F0;
        if (F0) {
            j2 = Util.b1((long) (i4 / i3), this.f5691g);
        } else {
            j2 = -9223372036854775807L;
        }
        this.f5693i = j2;
        this.f5704t = 0;
        this.f5705u = 0;
        this.H = false;
        this.I = 0;
        this.f5706v = 0;
        this.f5700p = false;
        this.f5709y = -9223372036854775807L;
        this.f5710z = -9223372036854775807L;
        this.f5702r = 0;
        this.f5699o = 0;
        this.f5694j = 1.0f;
    }

    public void t(float f2) {
        this.f5694j = f2;
        AudioTimestampPoller audioTimestampPoller = this.f5690f;
        if (audioTimestampPoller != null) {
            audioTimestampPoller.h();
        }
        r();
    }

    public void u(Clock clock) {
        this.J = clock;
    }

    public void v() {
        if (this.f5709y != -9223372036854775807L) {
            this.f5709y = Util.P0(this.J.elapsedRealtime());
        }
        ((AudioTimestampPoller) Assertions.f(this.f5690f)).h();
    }
}
