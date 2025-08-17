package androidx.media3.extractor.mp3;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

final class VbriSeeker implements Seeker {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f8506a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f8507b;

    /* renamed from: c  reason: collision with root package name */
    private final long f8508c;

    /* renamed from: d  reason: collision with root package name */
    private final long f8509d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8510e;

    private VbriSeeker(long[] jArr, long[] jArr2, long j2, long j3, int i2) {
        this.f8506a = jArr;
        this.f8507b = jArr2;
        this.f8508c = j2;
        this.f8509d = j3;
        this.f8510e = i2;
    }

    public static VbriSeeker a(long j2, long j3, MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int i2;
        int i3;
        long j4 = j2;
        MpegAudioUtil.Header header2 = header;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.V(10);
        int q2 = parsableByteArray.q();
        if (q2 <= 0) {
            return null;
        }
        int i4 = header2.f8065d;
        long j5 = (long) q2;
        if (i4 >= 32000) {
            i2 = 1152;
        } else {
            i2 = 576;
        }
        long c12 = Util.c1(j5, ((long) i2) * 1000000, (long) i4);
        int N = parsableByteArray.N();
        int N2 = parsableByteArray.N();
        int N3 = parsableByteArray.N();
        parsableByteArray2.V(2);
        long j6 = j3 + ((long) header2.f8064c);
        long[] jArr = new long[N];
        long[] jArr2 = new long[N];
        int i5 = 0;
        long j7 = j3;
        while (i5 < N) {
            int i6 = N2;
            jArr[i5] = (((long) i5) * c12) / ((long) N);
            long j8 = j6;
            jArr2[i5] = Math.max(j7, j8);
            if (N3 == 1) {
                i3 = parsableByteArray.H();
            } else if (N3 == 2) {
                i3 = parsableByteArray.N();
            } else if (N3 == 3) {
                i3 = parsableByteArray.K();
            } else if (N3 != 4) {
                return null;
            } else {
                i3 = parsableByteArray.L();
            }
            long j9 = (long) i3;
            int i7 = i6;
            j7 += j9 * ((long) i7);
            i5++;
            ParsableByteArray parsableByteArray3 = parsableByteArray;
            N = N;
            N2 = i7;
            j6 = j8;
        }
        if (!(j4 == -1 || j4 == j7)) {
            Log.h("VbriSeeker", "VBRI data size mismatch: " + j4 + ", " + j7);
        }
        return new VbriSeeker(jArr, jArr2, c12, j7, header2.f8067f);
    }

    public long b(long j2) {
        return this.f8506a[Util.h(this.f8507b, j2, true, true)];
    }

    public SeekMap.SeekPoints d(long j2) {
        int h2 = Util.h(this.f8506a, j2, true, true);
        SeekPoint seekPoint = new SeekPoint(this.f8506a[h2], this.f8507b[h2]);
        if (seekPoint.f8075a >= j2 || h2 == this.f8506a.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i2 = h2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f8506a[i2], this.f8507b[i2]));
    }

    public long e() {
        return this.f8509d;
    }

    public boolean f() {
        return true;
    }

    public long h() {
        return this.f8508c;
    }

    public int l() {
        return this.f8510e;
    }
}
