package androidx.media3.extractor.mp3;

import androidx.media3.common.util.LongArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import java.math.RoundingMode;

final class IndexSeeker implements Seeker {

    /* renamed from: a  reason: collision with root package name */
    private final long f8476a;

    /* renamed from: b  reason: collision with root package name */
    private final LongArray f8477b;

    /* renamed from: c  reason: collision with root package name */
    private final LongArray f8478c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8479d;

    /* renamed from: e  reason: collision with root package name */
    private long f8480e;

    public IndexSeeker(long j2, long j3, long j4) {
        long j5 = j2;
        long j6 = j3;
        long j7 = j4;
        this.f8480e = j5;
        this.f8476a = j7;
        LongArray longArray = new LongArray();
        this.f8477b = longArray;
        LongArray longArray2 = new LongArray();
        this.f8478c = longArray2;
        longArray.a(0);
        longArray2.a(j6);
        int i2 = -2147483647;
        if (j5 != -9223372036854775807L) {
            long e12 = Util.e1(j6 - j7, 8, j2, RoundingMode.HALF_UP);
            if (e12 > 0 && e12 <= 2147483647L) {
                i2 = (int) e12;
            }
            this.f8479d = i2;
            return;
        }
        this.f8479d = -2147483647;
    }

    public boolean a(long j2) {
        LongArray longArray = this.f8477b;
        return j2 - longArray.b(longArray.c() - 1) < 100000;
    }

    public long b(long j2) {
        return this.f8477b.b(Util.e(this.f8478c, j2, true, true));
    }

    public void c(long j2, long j3) {
        if (!a(j2)) {
            this.f8477b.a(j2);
            this.f8478c.a(j3);
        }
    }

    public SeekMap.SeekPoints d(long j2) {
        int e2 = Util.e(this.f8477b, j2, true, true);
        SeekPoint seekPoint = new SeekPoint(this.f8477b.b(e2), this.f8478c.b(e2));
        if (seekPoint.f8075a == j2 || e2 == this.f8477b.c() - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i2 = e2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f8477b.b(i2), this.f8478c.b(i2)));
    }

    public long e() {
        return this.f8476a;
    }

    public boolean f() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void g(long j2) {
        this.f8480e = j2;
    }

    public long h() {
        return this.f8480e;
    }

    public int l() {
        return this.f8479d;
    }
}
