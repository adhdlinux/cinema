package androidx.media3.extractor.wav;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

final class WavSeekMap implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    private final WavFormat f9594a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9595b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9596c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9597d;

    /* renamed from: e  reason: collision with root package name */
    private final long f9598e;

    public WavSeekMap(WavFormat wavFormat, int i2, long j2, long j3) {
        this.f9594a = wavFormat;
        this.f9595b = i2;
        this.f9596c = j2;
        long j4 = (j3 - j2) / ((long) wavFormat.f9589e);
        this.f9597d = j4;
        this.f9598e = a(j4);
    }

    private long a(long j2) {
        return Util.c1(j2 * ((long) this.f9595b), 1000000, (long) this.f9594a.f9587c);
    }

    public SeekMap.SeekPoints d(long j2) {
        long q2 = Util.q((((long) this.f9594a.f9587c) * j2) / (((long) this.f9595b) * 1000000), 0, this.f9597d - 1);
        long j3 = this.f9596c + (((long) this.f9594a.f9589e) * q2);
        long a2 = a(q2);
        SeekPoint seekPoint = new SeekPoint(a2, j3);
        if (a2 >= j2 || q2 == this.f9597d - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        long j4 = q2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(a(j4), this.f9596c + (((long) this.f9594a.f9589e) * j4)));
    }

    public boolean f() {
        return true;
    }

    public long h() {
        return this.f9598e;
    }
}
