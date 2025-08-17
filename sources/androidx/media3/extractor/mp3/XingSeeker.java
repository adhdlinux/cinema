package androidx.media3.extractor.mp3;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

final class XingSeeker implements Seeker {

    /* renamed from: a  reason: collision with root package name */
    private final long f8517a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8518b;

    /* renamed from: c  reason: collision with root package name */
    private final long f8519c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8520d;

    /* renamed from: e  reason: collision with root package name */
    private final long f8521e;

    /* renamed from: f  reason: collision with root package name */
    private final long f8522f;

    /* renamed from: g  reason: collision with root package name */
    private final long[] f8523g;

    private XingSeeker(long j2, int i2, long j3, int i3) {
        this(j2, i2, j3, i3, -1, (long[]) null);
    }

    public static XingSeeker a(XingFrame xingFrame, long j2) {
        long[] jArr;
        long a2 = xingFrame.a();
        if (a2 == -9223372036854775807L) {
            return null;
        }
        long j3 = xingFrame.f8513c;
        if (j3 == -1 || (jArr = xingFrame.f8516f) == null) {
            MpegAudioUtil.Header header = xingFrame.f8511a;
            return new XingSeeker(j2, header.f8064c, a2, header.f8067f);
        }
        MpegAudioUtil.Header header2 = xingFrame.f8511a;
        return new XingSeeker(j2, header2.f8064c, a2, header2.f8067f, j3, jArr);
    }

    private long c(int i2) {
        return (this.f8519c * ((long) i2)) / 100;
    }

    public long b(long j2) {
        long j3;
        double d2;
        long j4 = j2 - this.f8517a;
        if (!f() || j4 <= ((long) this.f8518b)) {
            return 0;
        }
        long[] jArr = (long[]) Assertions.j(this.f8523g);
        double d3 = (((double) j4) * 256.0d) / ((double) this.f8521e);
        int h2 = Util.h(jArr, (long) d3, true, true);
        long c2 = c(h2);
        long j5 = jArr[h2];
        int i2 = h2 + 1;
        long c3 = c(i2);
        if (h2 == 99) {
            j3 = 256;
        } else {
            j3 = jArr[i2];
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
            return new SeekMap.SeekPoints(new SeekPoint(0, this.f8517a + ((long) this.f8518b)));
        }
        long q2 = Util.q(j2, 0, this.f8519c);
        double d3 = (((double) q2) * 100.0d) / ((double) this.f8519c);
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d4 = 256.0d;
            } else {
                int i2 = (int) d3;
                long[] jArr = (long[]) Assertions.j(this.f8523g);
                double d5 = (double) jArr[i2];
                if (i2 == 99) {
                    d2 = 256.0d;
                } else {
                    d2 = (double) jArr[i2 + 1];
                }
                d4 = d5 + ((d3 - ((double) i2)) * (d2 - d5));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(q2, this.f8517a + Util.q(Math.round((d4 / 256.0d) * ((double) this.f8521e)), (long) this.f8518b, this.f8521e - 1)));
    }

    public long e() {
        return this.f8522f;
    }

    public boolean f() {
        return this.f8523g != null;
    }

    public long h() {
        return this.f8519c;
    }

    public int l() {
        return this.f8520d;
    }

    private XingSeeker(long j2, int i2, long j3, int i3, long j4, long[] jArr) {
        this.f8517a = j2;
        this.f8518b = i2;
        this.f8519c = j3;
        this.f8520d = i3;
        this.f8521e = j4;
        this.f8523g = jArr;
        this.f8522f = j4 != -1 ? j2 + j4 : -1;
    }
}
