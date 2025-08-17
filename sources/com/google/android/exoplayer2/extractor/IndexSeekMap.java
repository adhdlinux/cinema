package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class IndexSeekMap implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f24227a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f24228b;

    /* renamed from: c  reason: collision with root package name */
    private final long f24229c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f24230d;

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
        this.f24230d = z3;
        if (!z3 || jArr2[0] <= 0) {
            this.f24227a = jArr;
            this.f24228b = jArr2;
        } else {
            int i2 = length + 1;
            long[] jArr3 = new long[i2];
            this.f24227a = jArr3;
            long[] jArr4 = new long[i2];
            this.f24228b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f24229c = j2;
    }

    public SeekMap.SeekPoints d(long j2) {
        if (!this.f24230d) {
            return new SeekMap.SeekPoints(SeekPoint.f24236c);
        }
        int i2 = Util.i(this.f24228b, j2, true, true);
        SeekPoint seekPoint = new SeekPoint(this.f24228b[i2], this.f24227a[i2]);
        if (seekPoint.f24237a == j2 || i2 == this.f24228b.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i3 = i2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f24228b[i3], this.f24227a[i3]));
    }

    public boolean f() {
        return this.f24230d;
    }

    public long h() {
        return this.f24229c;
    }
}
