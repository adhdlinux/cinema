package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChunkIndex implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    public final int f24162a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f24163b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f24164c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f24165d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f24166e;

    /* renamed from: f  reason: collision with root package name */
    private final long f24167f;

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f24163b = iArr;
        this.f24164c = jArr;
        this.f24165d = jArr2;
        this.f24166e = jArr3;
        int length = iArr.length;
        this.f24162a = length;
        if (length > 0) {
            this.f24167f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f24167f = 0;
        }
    }

    public int a(long j2) {
        return Util.i(this.f24166e, j2, true, true);
    }

    public SeekMap.SeekPoints d(long j2) {
        int a2 = a(j2);
        SeekPoint seekPoint = new SeekPoint(this.f24166e[a2], this.f24164c[a2]);
        if (seekPoint.f24237a >= j2 || a2 == this.f24162a - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i2 = a2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f24166e[i2], this.f24164c[i2]));
    }

    public boolean f() {
        return true;
    }

    public long h() {
        return this.f24167f;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f24162a + ", sizes=" + Arrays.toString(this.f24163b) + ", offsets=" + Arrays.toString(this.f24164c) + ", timeUs=" + Arrays.toString(this.f24166e) + ", durationsUs=" + Arrays.toString(this.f24165d) + ")";
    }
}
