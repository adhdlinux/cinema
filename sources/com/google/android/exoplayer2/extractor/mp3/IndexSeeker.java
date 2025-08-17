package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.Util;

final class IndexSeeker implements Seeker {

    /* renamed from: a  reason: collision with root package name */
    private final long f24492a;

    /* renamed from: b  reason: collision with root package name */
    private final LongArray f24493b;

    /* renamed from: c  reason: collision with root package name */
    private final LongArray f24494c;

    /* renamed from: d  reason: collision with root package name */
    private long f24495d;

    public IndexSeeker(long j2, long j3, long j4) {
        this.f24495d = j2;
        this.f24492a = j4;
        LongArray longArray = new LongArray();
        this.f24493b = longArray;
        LongArray longArray2 = new LongArray();
        this.f24494c = longArray2;
        longArray.a(0);
        longArray2.a(j3);
    }

    public boolean a(long j2) {
        LongArray longArray = this.f24493b;
        return j2 - longArray.b(longArray.c() - 1) < 100000;
    }

    public long b(long j2) {
        return this.f24493b.b(Util.f(this.f24494c, j2, true, true));
    }

    public void c(long j2, long j3) {
        if (!a(j2)) {
            this.f24493b.a(j2);
            this.f24494c.a(j3);
        }
    }

    public SeekMap.SeekPoints d(long j2) {
        int f2 = Util.f(this.f24493b, j2, true, true);
        SeekPoint seekPoint = new SeekPoint(this.f24493b.b(f2), this.f24494c.b(f2));
        if (seekPoint.f24237a == j2 || f2 == this.f24493b.c() - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i2 = f2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f24493b.b(i2), this.f24494c.b(i2)));
    }

    public long e() {
        return this.f24492a;
    }

    public boolean f() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void g(long j2) {
        this.f24495d = j2;
    }

    public long h() {
        return this.f24495d;
    }
}
