package androidx.media3.extractor.mp4;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

final class TrackSampleTable {

    /* renamed from: a  reason: collision with root package name */
    public final Track f8694a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8695b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f8696c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f8697d;

    /* renamed from: e  reason: collision with root package name */
    public final int f8698e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f8699f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f8700g;

    /* renamed from: h  reason: collision with root package name */
    public final long f8701h;

    public TrackSampleTable(Track track, long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (iArr.length == jArr2.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (jArr.length == jArr2.length) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.a(z3);
        Assertions.a(iArr2.length == jArr2.length ? true : z4);
        this.f8694a = track;
        this.f8696c = jArr;
        this.f8697d = iArr;
        this.f8698e = i2;
        this.f8699f = jArr2;
        this.f8700g = iArr2;
        this.f8701h = j2;
        this.f8695b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j2) {
        for (int h2 = Util.h(this.f8699f, j2, true, false); h2 >= 0; h2--) {
            if ((this.f8700g[h2] & 1) != 0) {
                return h2;
            }
        }
        return -1;
    }

    public int b(long j2) {
        for (int d2 = Util.d(this.f8699f, j2, true, false); d2 < this.f8699f.length; d2++) {
            if ((this.f8700g[d2] & 1) != 0) {
                return d2;
            }
        }
        return -1;
    }
}
