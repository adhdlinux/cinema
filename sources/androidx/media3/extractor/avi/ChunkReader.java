package androidx.media3.extractor.avi;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;
import java.util.Arrays;

final class ChunkReader {

    /* renamed from: a  reason: collision with root package name */
    protected final TrackOutput f8170a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8171b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8172c;

    /* renamed from: d  reason: collision with root package name */
    private final long f8173d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8174e;

    /* renamed from: f  reason: collision with root package name */
    private int f8175f;

    /* renamed from: g  reason: collision with root package name */
    private int f8176g;

    /* renamed from: h  reason: collision with root package name */
    private int f8177h;

    /* renamed from: i  reason: collision with root package name */
    private int f8178i;

    /* renamed from: j  reason: collision with root package name */
    private int f8179j;

    /* renamed from: k  reason: collision with root package name */
    private long[] f8180k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f8181l;

    public ChunkReader(int i2, int i3, long j2, int i4, TrackOutput trackOutput) {
        int i5;
        int i6;
        boolean z2 = true;
        if (!(i3 == 1 || i3 == 2)) {
            z2 = false;
        }
        Assertions.a(z2);
        this.f8173d = j2;
        this.f8174e = i4;
        this.f8170a = trackOutput;
        if (i3 == 2) {
            i5 = 1667497984;
        } else {
            i5 = 1651965952;
        }
        this.f8171b = d(i2, i5);
        if (i3 == 2) {
            i6 = d(i2, 1650720768);
        } else {
            i6 = -1;
        }
        this.f8172c = i6;
        this.f8180k = new long[512];
        this.f8181l = new int[512];
    }

    private static int d(int i2, int i3) {
        return (((i2 % 10) + 48) << 8) | ((i2 / 10) + 48) | i3;
    }

    private long e(int i2) {
        return (this.f8173d * ((long) i2)) / ((long) this.f8174e);
    }

    private SeekPoint h(int i2) {
        return new SeekPoint(((long) this.f8181l[i2]) * g(), this.f8180k[i2]);
    }

    public void a() {
        this.f8177h++;
    }

    public void b(long j2) {
        if (this.f8179j == this.f8181l.length) {
            long[] jArr = this.f8180k;
            this.f8180k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.f8181l;
            this.f8181l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.f8180k;
        int i2 = this.f8179j;
        jArr2[i2] = j2;
        this.f8181l[i2] = this.f8178i;
        this.f8179j = i2 + 1;
    }

    public void c() {
        this.f8180k = Arrays.copyOf(this.f8180k, this.f8179j);
        this.f8181l = Arrays.copyOf(this.f8181l, this.f8179j);
    }

    public long f() {
        return e(this.f8177h);
    }

    public long g() {
        return e(1);
    }

    public SeekMap.SeekPoints i(long j2) {
        int g2 = (int) (j2 / g());
        int g3 = Util.g(this.f8181l, g2, true, true);
        if (this.f8181l[g3] == g2) {
            return new SeekMap.SeekPoints(h(g3));
        }
        SeekPoint h2 = h(g3);
        int i2 = g3 + 1;
        if (i2 < this.f8180k.length) {
            return new SeekMap.SeekPoints(h2, h(i2));
        }
        return new SeekMap.SeekPoints(h2);
    }

    public boolean j(int i2) {
        return this.f8171b == i2 || this.f8172c == i2;
    }

    public void k() {
        this.f8178i++;
    }

    public boolean l() {
        return Arrays.binarySearch(this.f8181l, this.f8177h) >= 0;
    }

    public boolean m(ExtractorInput extractorInput) throws IOException {
        int i2 = this.f8176g;
        boolean z2 = false;
        int d2 = i2 - this.f8170a.d(extractorInput, i2, false);
        this.f8176g = d2;
        if (d2 == 0) {
            z2 = true;
        }
        if (z2) {
            if (this.f8175f > 0) {
                TrackOutput trackOutput = this.f8170a;
                long f2 = f();
                boolean l2 = l();
                trackOutput.f(f2, l2 ? 1 : 0, this.f8175f, 0, (TrackOutput.CryptoData) null);
            }
            a();
        }
        return z2;
    }

    public void n(int i2) {
        this.f8175f = i2;
        this.f8176g = i2;
    }

    public void o(long j2) {
        if (this.f8179j == 0) {
            this.f8177h = 0;
            return;
        }
        this.f8177h = this.f8181l[Util.h(this.f8180k, j2, true, true)];
    }
}
