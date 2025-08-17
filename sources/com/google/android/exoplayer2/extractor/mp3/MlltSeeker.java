package com.google.android.exoplayer2.extractor.mp3;

import android.util.Pair;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.Util;

final class MlltSeeker implements Seeker {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f24496a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f24497b;

    /* renamed from: c  reason: collision with root package name */
    private final long f24498c;

    private MlltSeeker(long[] jArr, long[] jArr2, long j2) {
        this.f24496a = jArr;
        this.f24497b = jArr2;
        this.f24498c = j2 == -9223372036854775807L ? Util.F0(jArr2[jArr2.length - 1]) : j2;
    }

    public static MlltSeeker a(long j2, MlltFrame mlltFrame, long j3) {
        int length = mlltFrame.f25435f.length;
        int i2 = length + 1;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        jArr[0] = j2;
        long j4 = 0;
        jArr2[0] = 0;
        for (int i3 = 1; i3 <= length; i3++) {
            int i4 = i3 - 1;
            j2 += (long) (mlltFrame.f25433d + mlltFrame.f25435f[i4]);
            j4 += (long) (mlltFrame.f25434e + mlltFrame.f25436g[i4]);
            jArr[i3] = j2;
            jArr2[i3] = j4;
        }
        return new MlltSeeker(jArr, jArr2, j3);
    }

    private static Pair<Long, Long> c(long j2, long[] jArr, long[] jArr2) {
        double d2;
        int i2 = Util.i(jArr, j2, true, true);
        long j3 = jArr[i2];
        long j4 = jArr2[i2];
        int i3 = i2 + 1;
        if (i3 == jArr.length) {
            return Pair.create(Long.valueOf(j3), Long.valueOf(j4));
        }
        long j5 = jArr[i3];
        long j6 = jArr2[i3];
        if (j5 == j3) {
            d2 = 0.0d;
        } else {
            d2 = (((double) j2) - ((double) j3)) / ((double) (j5 - j3));
        }
        return Pair.create(Long.valueOf(j2), Long.valueOf(((long) (d2 * ((double) (j6 - j4)))) + j4));
    }

    public long b(long j2) {
        return Util.F0(((Long) c(j2, this.f24496a, this.f24497b).second).longValue());
    }

    public SeekMap.SeekPoints d(long j2) {
        Pair<Long, Long> c2 = c(Util.i1(Util.r(j2, 0, this.f24498c)), this.f24497b, this.f24496a);
        return new SeekMap.SeekPoints(new SeekPoint(Util.F0(((Long) c2.first).longValue()), ((Long) c2.second).longValue()));
    }

    public long e() {
        return -1;
    }

    public boolean f() {
        return true;
    }

    public long h() {
        return this.f24498c;
    }
}
