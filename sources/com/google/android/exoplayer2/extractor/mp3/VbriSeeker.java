package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class VbriSeeker implements Seeker {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f24521a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f24522b;

    /* renamed from: c  reason: collision with root package name */
    private final long f24523c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24524d;

    private VbriSeeker(long[] jArr, long[] jArr2, long j2, long j3) {
        this.f24521a = jArr;
        this.f24522b = jArr2;
        this.f24523c = j2;
        this.f24524d = j3;
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
        int i4 = header2.f23840d;
        long j5 = (long) q2;
        if (i4 >= 32000) {
            i2 = 1152;
        } else {
            i2 = 576;
        }
        long R0 = Util.R0(j5, ((long) i2) * 1000000, (long) i4);
        int N = parsableByteArray.N();
        int N2 = parsableByteArray.N();
        int N3 = parsableByteArray.N();
        parsableByteArray2.V(2);
        long j6 = j3 + ((long) header2.f23839c);
        long[] jArr = new long[N];
        long[] jArr2 = new long[N];
        int i5 = 0;
        long j7 = j3;
        while (i5 < N) {
            int i6 = N2;
            jArr[i5] = (((long) i5) * R0) / ((long) N);
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
            jArr = jArr;
            N2 = i7;
            j6 = j8;
        }
        long[] jArr3 = jArr;
        if (!(j4 == -1 || j4 == j7)) {
            Log.i("VbriSeeker", "VBRI data size mismatch: " + j4 + ", " + j7);
        }
        return new VbriSeeker(jArr3, jArr2, R0, j7);
    }

    public long b(long j2) {
        return this.f24521a[Util.i(this.f24522b, j2, true, true)];
    }

    public SeekMap.SeekPoints d(long j2) {
        int i2 = Util.i(this.f24521a, j2, true, true);
        SeekPoint seekPoint = new SeekPoint(this.f24521a[i2], this.f24522b[i2]);
        if (seekPoint.f24237a >= j2 || i2 == this.f24521a.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i3 = i2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f24521a[i3], this.f24522b[i3]));
    }

    public long e() {
        return this.f24524d;
    }

    public boolean f() {
        return true;
    }

    public long h() {
        return this.f24523c;
    }
}
