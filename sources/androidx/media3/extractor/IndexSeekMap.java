package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;

public final class IndexSeekMap implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f8051a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f8052b;

    /* renamed from: c  reason: collision with root package name */
    private final long f8053c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8054d;

    public IndexSeekMap(long[] jArr, long[] jArr2, long j2) {
        boolean z2;
        boolean z3;
        if (jArr.length == jArr2.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        int length = jArr2.length;
        if (length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f8054d = z3;
        if (!z3 || jArr2[0] <= 0) {
            this.f8051a = jArr;
            this.f8052b = jArr2;
        } else {
            int i2 = length + 1;
            long[] jArr3 = new long[i2];
            this.f8051a = jArr3;
            long[] jArr4 = new long[i2];
            this.f8052b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f8053c = j2;
    }

    public SeekMap.SeekPoints d(long j2) {
        if (!this.f8054d) {
            return new SeekMap.SeekPoints(SeekPoint.f8074c);
        }
        int h2 = Util.h(this.f8052b, j2, true, true);
        SeekPoint seekPoint = new SeekPoint(this.f8052b[h2], this.f8051a[h2]);
        if (seekPoint.f8075a == j2 || h2 == this.f8052b.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i2 = h2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f8052b[i2], this.f8051a[i2]));
    }

    public boolean f() {
        return this.f8054d;
    }

    public long h() {
        return this.f8053c;
    }
}
