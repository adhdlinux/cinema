package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

final class WavSeekMap implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    private final WavFormat f25170a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25171b;

    /* renamed from: c  reason: collision with root package name */
    private final long f25172c;

    /* renamed from: d  reason: collision with root package name */
    private final long f25173d;

    /* renamed from: e  reason: collision with root package name */
    private final long f25174e;

    public WavSeekMap(WavFormat wavFormat, int i2, long j2, long j3) {
        this.f25170a = wavFormat;
        this.f25171b = i2;
        this.f25172c = j2;
        long j4 = (j3 - j2) / ((long) wavFormat.f25165e);
        this.f25173d = j4;
        this.f25174e = a(j4);
    }

    private long a(long j2) {
        return Util.R0(j2 * ((long) this.f25171b), 1000000, (long) this.f25170a.f25163c);
    }

    public SeekMap.SeekPoints d(long j2) {
        long r2 = Util.r((((long) this.f25170a.f25163c) * j2) / (((long) this.f25171b) * 1000000), 0, this.f25173d - 1);
        long j3 = this.f25172c + (((long) this.f25170a.f25165e) * r2);
        long a2 = a(r2);
        SeekPoint seekPoint = new SeekPoint(a2, j3);
        if (a2 >= j2 || r2 == this.f25173d - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        long j4 = r2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(a(j4), this.f25172c + (((long) this.f25170a.f25165e) * j4)));
    }

    public boolean f() {
        return true;
    }

    public long h() {
        return this.f25174e;
    }
}
