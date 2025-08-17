package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;

public class ConstantBitrateSeekMap implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    private final long f24168a;

    /* renamed from: b  reason: collision with root package name */
    private final long f24169b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24170c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24171d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24172e;

    /* renamed from: f  reason: collision with root package name */
    private final long f24173f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f24174g;

    public ConstantBitrateSeekMap(long j2, long j3, int i2, int i3, boolean z2) {
        this.f24168a = j2;
        this.f24169b = j3;
        this.f24170c = i3 == -1 ? 1 : i3;
        this.f24172e = i2;
        this.f24174g = z2;
        if (j2 == -1) {
            this.f24171d = -1;
            this.f24173f = -9223372036854775807L;
            return;
        }
        this.f24171d = j2 - j3;
        this.f24173f = g(j2, j3, i2);
    }

    private long a(long j2) {
        int i2 = this.f24170c;
        long j3 = (((j2 * ((long) this.f24172e)) / 8000000) / ((long) i2)) * ((long) i2);
        long j4 = this.f24171d;
        if (j4 != -1) {
            j3 = Math.min(j3, j4 - ((long) i2));
        }
        return this.f24169b + Math.max(j3, 0);
    }

    private static long g(long j2, long j3, int i2) {
        return ((Math.max(0, j2 - j3) * 8) * 1000000) / ((long) i2);
    }

    public long c(long j2) {
        return g(j2, this.f24169b, this.f24172e);
    }

    public SeekMap.SeekPoints d(long j2) {
        if (this.f24171d == -1 && !this.f24174g) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.f24169b));
        }
        long a2 = a(j2);
        long c2 = c(a2);
        SeekPoint seekPoint = new SeekPoint(c2, a2);
        if (this.f24171d != -1 && c2 < j2) {
            int i2 = this.f24170c;
            if (((long) i2) + a2 < this.f24168a) {
                long j3 = a2 + ((long) i2);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(c(j3), j3));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public boolean f() {
        return this.f24171d != -1 || this.f24174g;
    }

    public long h() {
        return this.f24173f;
    }
}
