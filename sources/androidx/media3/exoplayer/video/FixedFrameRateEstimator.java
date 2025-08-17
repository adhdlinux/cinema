package androidx.media3.exoplayer.video;

import java.util.Arrays;

final class FixedFrameRateEstimator {

    /* renamed from: a  reason: collision with root package name */
    private Matcher f7640a = new Matcher();

    /* renamed from: b  reason: collision with root package name */
    private Matcher f7641b = new Matcher();

    /* renamed from: c  reason: collision with root package name */
    private boolean f7642c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7643d;

    /* renamed from: e  reason: collision with root package name */
    private long f7644e = -9223372036854775807L;

    /* renamed from: f  reason: collision with root package name */
    private int f7645f;

    private static final class Matcher {

        /* renamed from: a  reason: collision with root package name */
        private long f7646a;

        /* renamed from: b  reason: collision with root package name */
        private long f7647b;

        /* renamed from: c  reason: collision with root package name */
        private long f7648c;

        /* renamed from: d  reason: collision with root package name */
        private long f7649d;

        /* renamed from: e  reason: collision with root package name */
        private long f7650e;

        /* renamed from: f  reason: collision with root package name */
        private long f7651f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean[] f7652g = new boolean[15];

        /* renamed from: h  reason: collision with root package name */
        private int f7653h;

        private static int c(long j2) {
            return (int) (j2 % 15);
        }

        public long a() {
            long j2 = this.f7650e;
            if (j2 == 0) {
                return 0;
            }
            return this.f7651f / j2;
        }

        public long b() {
            return this.f7651f;
        }

        public boolean d() {
            long j2 = this.f7649d;
            if (j2 == 0) {
                return false;
            }
            return this.f7652g[c(j2 - 1)];
        }

        public boolean e() {
            return this.f7649d > 15 && this.f7653h == 0;
        }

        public void f(long j2) {
            long j3 = this.f7649d;
            if (j3 == 0) {
                this.f7646a = j2;
            } else if (j3 == 1) {
                long j4 = j2 - this.f7646a;
                this.f7647b = j4;
                this.f7651f = j4;
                this.f7650e = 1;
            } else {
                long j5 = j2 - this.f7648c;
                int c2 = c(j3);
                if (Math.abs(j5 - this.f7647b) <= 1000000) {
                    this.f7650e++;
                    this.f7651f += j5;
                    boolean[] zArr = this.f7652g;
                    if (zArr[c2]) {
                        zArr[c2] = false;
                        this.f7653h--;
                    }
                } else {
                    boolean[] zArr2 = this.f7652g;
                    if (!zArr2[c2]) {
                        zArr2[c2] = true;
                        this.f7653h++;
                    }
                }
            }
            this.f7649d++;
            this.f7648c = j2;
        }

        public void g() {
            this.f7649d = 0;
            this.f7650e = 0;
            this.f7651f = 0;
            this.f7653h = 0;
            Arrays.fill(this.f7652g, false);
        }
    }

    public long a() {
        if (e()) {
            return this.f7640a.a();
        }
        return -9223372036854775807L;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / ((double) this.f7640a.a()));
        }
        return -1.0f;
    }

    public int c() {
        return this.f7645f;
    }

    public long d() {
        if (e()) {
            return this.f7640a.b();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f7640a.e();
    }

    public void f(long j2) {
        this.f7640a.f(j2);
        int i2 = 0;
        if (this.f7640a.e() && !this.f7643d) {
            this.f7642c = false;
        } else if (this.f7644e != -9223372036854775807L) {
            if (!this.f7642c || this.f7641b.d()) {
                this.f7641b.g();
                this.f7641b.f(this.f7644e);
            }
            this.f7642c = true;
            this.f7641b.f(j2);
        }
        if (this.f7642c && this.f7641b.e()) {
            Matcher matcher = this.f7640a;
            this.f7640a = this.f7641b;
            this.f7641b = matcher;
            this.f7642c = false;
            this.f7643d = false;
        }
        this.f7644e = j2;
        if (!this.f7640a.e()) {
            i2 = this.f7645f + 1;
        }
        this.f7645f = i2;
    }

    public void g() {
        this.f7640a.g();
        this.f7641b.g();
        this.f7642c = false;
        this.f7644e = -9223372036854775807L;
        this.f7645f = 0;
    }
}
