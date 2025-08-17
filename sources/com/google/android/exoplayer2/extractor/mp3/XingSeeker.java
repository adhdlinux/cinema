package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class XingSeeker implements Seeker {

    /* renamed from: a  reason: collision with root package name */
    private final long f24525a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24526b;

    /* renamed from: c  reason: collision with root package name */
    private final long f24527c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24528d;

    /* renamed from: e  reason: collision with root package name */
    private final long f24529e;

    /* renamed from: f  reason: collision with root package name */
    private final long[] f24530f;

    private XingSeeker(long j2, int i2, long j3) {
        this(j2, i2, j3, -1, (long[]) null);
    }

    public static XingSeeker a(long j2, long j3, MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int L;
        long j4 = j2;
        MpegAudioUtil.Header header2 = header;
        int i2 = header2.f23843g;
        int i3 = header2.f23840d;
        int q2 = parsableByteArray.q();
        if ((q2 & 1) != 1 || (L = parsableByteArray.L()) == 0) {
            return null;
        }
        long R0 = Util.R0((long) L, ((long) i2) * 1000000, (long) i3);
        if ((q2 & 6) != 6) {
            return new XingSeeker(j3, header2.f23839c, R0);
        }
        long J = parsableByteArray.J();
        long[] jArr = new long[100];
        for (int i4 = 0; i4 < 100; i4++) {
            jArr[i4] = (long) parsableByteArray.H();
        }
        if (j4 != -1) {
            long j5 = j3 + J;
            if (j4 != j5) {
                Log.i("XingSeeker", "XING data size mismatch: " + j4 + ", " + j5);
            }
        }
        return new XingSeeker(j3, header2.f23839c, R0, J, jArr);
    }

    private long c(int i2) {
        return (this.f24527c * ((long) i2)) / 100;
    }

    public long b(long j2) {
        long j3;
        double d2;
        long j4 = j2 - this.f24525a;
        if (!f() || j4 <= ((long) this.f24526b)) {
            return 0;
        }
        long[] jArr = (long[]) Assertions.i(this.f24530f);
        double d3 = (((double) j4) * 256.0d) / ((double) this.f24528d);
        int i2 = Util.i(jArr, (long) d3, true, true);
        long c2 = c(i2);
        long j5 = jArr[i2];
        int i3 = i2 + 1;
        long c3 = c(i3);
        if (i2 == 99) {
            j3 = 256;
        } else {
            j3 = jArr[i3];
        }
        if (j5 == j3) {
            d2 = 0.0d;
        } else {
            d2 = (d3 - ((double) j5)) / ((double) (j3 - j5));
        }
        return c2 + Math.round(d2 * ((double) (c3 - c2)));
    }

    public SeekMap.SeekPoints d(long j2) {
        double d2;
        if (!f()) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.f24525a + ((long) this.f24526b)));
        }
        long r2 = Util.r(j2, 0, this.f24527c);
        double d3 = (((double) r2) * 100.0d) / ((double) this.f24527c);
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d4 = 256.0d;
            } else {
                int i2 = (int) d3;
                long[] jArr = (long[]) Assertions.i(this.f24530f);
                double d5 = (double) jArr[i2];
                if (i2 == 99) {
                    d2 = 256.0d;
                } else {
                    d2 = (double) jArr[i2 + 1];
                }
                d4 = d5 + ((d3 - ((double) i2)) * (d2 - d5));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(r2, this.f24525a + Util.r(Math.round((d4 / 256.0d) * ((double) this.f24528d)), (long) this.f24526b, this.f24528d - 1)));
    }

    public long e() {
        return this.f24529e;
    }

    public boolean f() {
        return this.f24530f != null;
    }

    public long h() {
        return this.f24527c;
    }

    private XingSeeker(long j2, int i2, long j3, long j4, long[] jArr) {
        this.f24525a = j2;
        this.f24526b = i2;
        this.f24527c = j3;
        this.f24530f = jArr;
        this.f24528d = j4;
        this.f24529e = j4 != -1 ? j2 + j4 : -1;
    }
}
