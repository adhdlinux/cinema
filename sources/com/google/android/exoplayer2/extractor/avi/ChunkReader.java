package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

final class ChunkReader {

    /* renamed from: a  reason: collision with root package name */
    protected final TrackOutput f24326a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24327b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24328c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24329d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24330e;

    /* renamed from: f  reason: collision with root package name */
    private int f24331f;

    /* renamed from: g  reason: collision with root package name */
    private int f24332g;

    /* renamed from: h  reason: collision with root package name */
    private int f24333h;

    /* renamed from: i  reason: collision with root package name */
    private int f24334i;

    /* renamed from: j  reason: collision with root package name */
    private int f24335j;

    /* renamed from: k  reason: collision with root package name */
    private long[] f24336k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f24337l;

    public ChunkReader(int i2, int i3, long j2, int i4, TrackOutput trackOutput) {
        int i5;
        int i6;
        boolean z2 = true;
        if (!(i3 == 1 || i3 == 2)) {
            z2 = false;
        }
        Assertions.a(z2);
        this.f24329d = j2;
        this.f24330e = i4;
        this.f24326a = trackOutput;
        if (i3 == 2) {
            i5 = 1667497984;
        } else {
            i5 = 1651965952;
        }
        this.f24327b = d(i2, i5);
        if (i3 == 2) {
            i6 = d(i2, 1650720768);
        } else {
            i6 = -1;
        }
        this.f24328c = i6;
        this.f24336k = new long[512];
        this.f24337l = new int[512];
    }

    private static int d(int i2, int i3) {
        return (((i2 % 10) + 48) << 8) | ((i2 / 10) + 48) | i3;
    }

    private long e(int i2) {
        return (this.f24329d * ((long) i2)) / ((long) this.f24330e);
    }

    private SeekPoint h(int i2) {
        return new SeekPoint(((long) this.f24337l[i2]) * g(), this.f24336k[i2]);
    }

    public void a() {
        this.f24333h++;
    }

    public void b(long j2) {
        if (this.f24335j == this.f24337l.length) {
            long[] jArr = this.f24336k;
            this.f24336k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.f24337l;
            this.f24337l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.f24336k;
        int i2 = this.f24335j;
        jArr2[i2] = j2;
        this.f24337l[i2] = this.f24334i;
        this.f24335j = i2 + 1;
    }

    public void c() {
        this.f24336k = Arrays.copyOf(this.f24336k, this.f24335j);
        this.f24337l = Arrays.copyOf(this.f24337l, this.f24335j);
    }

    public long f() {
        return e(this.f24333h);
    }

    public long g() {
        return e(1);
    }

    public SeekMap.SeekPoints i(long j2) {
        int g2 = (int) (j2 / g());
        int h2 = Util.h(this.f24337l, g2, true, true);
        if (this.f24337l[h2] == g2) {
            return new SeekMap.SeekPoints(h(h2));
        }
        SeekPoint h3 = h(h2);
        int i2 = h2 + 1;
        if (i2 < this.f24336k.length) {
            return new SeekMap.SeekPoints(h3, h(i2));
        }
        return new SeekMap.SeekPoints(h3);
    }

    public boolean j(int i2) {
        return this.f24327b == i2 || this.f24328c == i2;
    }

    public void k() {
        this.f24334i++;
    }

    public boolean l() {
        return Arrays.binarySearch(this.f24337l, this.f24333h) >= 0;
    }

    public boolean m(ExtractorInput extractorInput) throws IOException {
        int i2 = this.f24332g;
        boolean z2 = false;
        int b2 = i2 - this.f24326a.b(extractorInput, i2, false);
        this.f24332g = b2;
        if (b2 == 0) {
            z2 = true;
        }
        if (z2) {
            if (this.f24331f > 0) {
                TrackOutput trackOutput = this.f24326a;
                long f2 = f();
                boolean l2 = l();
                trackOutput.e(f2, l2 ? 1 : 0, this.f24331f, 0, (TrackOutput.CryptoData) null);
            }
            a();
        }
        return z2;
    }

    public void n(int i2) {
        this.f24331f = i2;
        this.f24332g = i2;
    }

    public void o(long j2) {
        if (this.f24335j == 0) {
            this.f24333h = 0;
            return;
        }
        this.f24333h = this.f24337l[Util.i(this.f24336k, j2, true, true)];
    }
}
