package com.google.android.exoplayer2.video;

import java.util.Arrays;

final class FixedFrameRateEstimator {

    /* renamed from: a  reason: collision with root package name */
    private Matcher f28852a = new Matcher();

    /* renamed from: b  reason: collision with root package name */
    private Matcher f28853b = new Matcher();

    /* renamed from: c  reason: collision with root package name */
    private boolean f28854c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f28855d;

    /* renamed from: e  reason: collision with root package name */
    private long f28856e = -9223372036854775807L;

    /* renamed from: f  reason: collision with root package name */
    private int f28857f;

    private static final class Matcher {

        /* renamed from: a  reason: collision with root package name */
        private long f28858a;

        /* renamed from: b  reason: collision with root package name */
        private long f28859b;

        /* renamed from: c  reason: collision with root package name */
        private long f28860c;

        /* renamed from: d  reason: collision with root package name */
        private long f28861d;

        /* renamed from: e  reason: collision with root package name */
        private long f28862e;

        /* renamed from: f  reason: collision with root package name */
        private long f28863f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean[] f28864g = new boolean[15];

        /* renamed from: h  reason: collision with root package name */
        private int f28865h;

        private static int c(long j2) {
            return (int) (j2 % 15);
        }

        public long a() {
            long j2 = this.f28862e;
            if (j2 == 0) {
                return 0;
            }
            return this.f28863f / j2;
        }

        public long b() {
            return this.f28863f;
        }

        public boolean d() {
            long j2 = this.f28861d;
            if (j2 == 0) {
                return false;
            }
            return this.f28864g[c(j2 - 1)];
        }

        public boolean e() {
            return this.f28861d > 15 && this.f28865h == 0;
        }

        public void f(long j2) {
            long j3 = this.f28861d;
            if (j3 == 0) {
                this.f28858a = j2;
            } else if (j3 == 1) {
                long j4 = j2 - this.f28858a;
                this.f28859b = j4;
                this.f28863f = j4;
                this.f28862e = 1;
            } else {
                long j5 = j2 - this.f28860c;
                int c2 = c(j3);
                if (Math.abs(j5 - this.f28859b) <= 1000000) {
                    this.f28862e++;
                    this.f28863f += j5;
                    boolean[] zArr = this.f28864g;
                    if (zArr[c2]) {
                        zArr[c2] = false;
                        this.f28865h--;
                    }
                } else {
                    boolean[] zArr2 = this.f28864g;
                    if (!zArr2[c2]) {
                        zArr2[c2] = true;
                        this.f28865h++;
                    }
                }
            }
            this.f28861d++;
            this.f28860c = j2;
        }

        public void g() {
            this.f28861d = 0;
            this.f28862e = 0;
            this.f28863f = 0;
            this.f28865h = 0;
            Arrays.fill(this.f28864g, false);
        }
    }

    public long a() {
        if (e()) {
            return this.f28852a.a();
        }
        return -9223372036854775807L;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / ((double) this.f28852a.a()));
        }
        return -1.0f;
    }

    public int c() {
        return this.f28857f;
    }

    public long d() {
        if (e()) {
            return this.f28852a.b();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f28852a.e();
    }

    public void f(long j2) {
        this.f28852a.f(j2);
        int i2 = 0;
        if (this.f28852a.e() && !this.f28855d) {
            this.f28854c = false;
        } else if (this.f28856e != -9223372036854775807L) {
            if (!this.f28854c || this.f28853b.d()) {
                this.f28853b.g();
                this.f28853b.f(this.f28856e);
            }
            this.f28854c = true;
            this.f28853b.f(j2);
        }
        if (this.f28854c && this.f28853b.e()) {
            Matcher matcher = this.f28852a;
            this.f28852a = this.f28853b;
            this.f28853b = matcher;
            this.f28854c = false;
            this.f28855d = false;
        }
        this.f28856e = j2;
        if (!this.f28852a.e()) {
            i2 = this.f28857f + 1;
        }
        this.f28857f = i2;
    }

    public void g() {
        this.f28852a.g();
        this.f28853b.g();
        this.f28854c = false;
        this.f28856e = -9223372036854775807L;
        this.f28857f = 0;
    }
}
