package androidx.media3.extractor;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import java.util.Arrays;

public final class ChunkIndex implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    public final int f7952a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f7953b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f7954c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f7955d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f7956e;

    /* renamed from: f  reason: collision with root package name */
    private final long f7957f;

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f7953b = iArr;
        this.f7954c = jArr;
        this.f7955d = jArr2;
        this.f7956e = jArr3;
        int length = iArr.length;
        this.f7952a = length;
        if (length > 0) {
            this.f7957f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f7957f = 0;
        }
    }

    public int a(long j2) {
        return Util.h(this.f7956e, j2, true, true);
    }

    public SeekMap.SeekPoints d(long j2) {
        int a2 = a(j2);
        SeekPoint seekPoint = new SeekPoint(this.f7956e[a2], this.f7954c[a2]);
        if (seekPoint.f8075a >= j2 || a2 == this.f7952a - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i2 = a2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f7956e[i2], this.f7954c[i2]));
    }

    public boolean f() {
        return true;
    }

    public long h() {
        return this.f7957f;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f7952a + ", sizes=" + Arrays.toString(this.f7953b) + ", offsets=" + Arrays.toString(this.f7954c) + ", timeUs=" + Arrays.toString(this.f7956e) + ", durationsUs=" + Arrays.toString(this.f7955d) + ")";
    }
}
