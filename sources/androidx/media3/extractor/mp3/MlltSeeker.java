package androidx.media3.extractor.mp3;

import android.util.Pair;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.metadata.id3.MlltFrame;

final class MlltSeeker implements Seeker {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f8481a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f8482b;

    /* renamed from: c  reason: collision with root package name */
    private final long f8483c;

    private MlltSeeker(long[] jArr, long[] jArr2, long j2) {
        this.f8481a = jArr;
        this.f8482b = jArr2;
        this.f8483c = j2 == -9223372036854775807L ? Util.P0(jArr2[jArr2.length - 1]) : j2;
    }

    public static MlltSeeker a(long j2, MlltFrame mlltFrame, long j3) {
        int length = mlltFrame.f8336f.length;
        int i2 = length + 1;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        jArr[0] = j2;
        long j4 = 0;
        jArr2[0] = 0;
        for (int i3 = 1; i3 <= length; i3++) {
            int i4 = i3 - 1;
            j2 += (long) (mlltFrame.f8334d + mlltFrame.f8336f[i4]);
            j4 += (long) (mlltFrame.f8335e + mlltFrame.f8337g[i4]);
            jArr[i3] = j2;
            jArr2[i3] = j4;
        }
        return new MlltSeeker(jArr, jArr2, j3);
    }

    private static Pair<Long, Long> c(long j2, long[] jArr, long[] jArr2) {
        double d2;
        int h2 = Util.h(jArr, j2, true, true);
        long j3 = jArr[h2];
        long j4 = jArr2[h2];
        int i2 = h2 + 1;
        if (i2 == jArr.length) {
            return Pair.create(Long.valueOf(j3), Long.valueOf(j4));
        }
        long j5 = jArr[i2];
        long j6 = jArr2[i2];
        if (j5 == j3) {
            d2 = 0.0d;
        } else {
            d2 = (((double) j2) - ((double) j3)) / ((double) (j5 - j3));
        }
        return Pair.create(Long.valueOf(j2), Long.valueOf(((long) (d2 * ((double) (j6 - j4)))) + j4));
    }

    public long b(long j2) {
        return Util.P0(((Long) c(j2, this.f8481a, this.f8482b).second).longValue());
    }

    public SeekMap.SeekPoints d(long j2) {
        Pair<Long, Long> c2 = c(Util.t1(Util.q(j2, 0, this.f8483c)), this.f8482b, this.f8481a);
        return new SeekMap.SeekPoints(new SeekPoint(Util.P0(((Long) c2.first).longValue()), ((Long) c2.second).longValue()));
    }

    public long e() {
        return -1;
    }

    public boolean f() {
        return true;
    }

    public long h() {
        return this.f8483c;
    }

    public int l() {
        return -2147483647;
    }
}
