package androidx.media3.extractor;

import androidx.media3.extractor.SeekMap;

public class ConstantBitrateSeekMap implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    private final long f7958a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7959b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7960c;

    /* renamed from: d  reason: collision with root package name */
    private final long f7961d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7962e;

    /* renamed from: f  reason: collision with root package name */
    private final long f7963f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f7964g;

    public ConstantBitrateSeekMap(long j2, long j3, int i2, int i3, boolean z2) {
        this.f7958a = j2;
        this.f7959b = j3;
        this.f7960c = i3 == -1 ? 1 : i3;
        this.f7962e = i2;
        this.f7964g = z2;
        if (j2 == -1) {
            this.f7961d = -1;
            this.f7963f = -9223372036854775807L;
            return;
        }
        this.f7961d = j2 - j3;
        this.f7963f = g(j2, j3, i2);
    }

    private long a(long j2) {
        int i2 = this.f7960c;
        long j3 = (((j2 * ((long) this.f7962e)) / 8000000) / ((long) i2)) * ((long) i2);
        long j4 = this.f7961d;
        if (j4 != -1) {
            j3 = Math.min(j3, j4 - ((long) i2));
        }
        return this.f7959b + Math.max(j3, 0);
    }

    private static long g(long j2, long j3, int i2) {
        return ((Math.max(0, j2 - j3) * 8) * 1000000) / ((long) i2);
    }

    public long c(long j2) {
        return g(j2, this.f7959b, this.f7962e);
    }

    public SeekMap.SeekPoints d(long j2) {
        if (this.f7961d == -1 && !this.f7964g) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.f7959b));
        }
        long a2 = a(j2);
        long c2 = c(a2);
        SeekPoint seekPoint = new SeekPoint(c2, a2);
        if (this.f7961d != -1 && c2 < j2) {
            int i2 = this.f7960c;
            if (((long) i2) + a2 < this.f7958a) {
                long j3 = a2 + ((long) i2);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(c(j3), j3));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public boolean f() {
        return this.f7961d != -1 || this.f7964g;
    }

    public long h() {
        return this.f7963f;
    }
}
