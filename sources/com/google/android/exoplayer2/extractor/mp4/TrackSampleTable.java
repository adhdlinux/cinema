package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class TrackSampleTable {

    /* renamed from: a  reason: collision with root package name */
    public final Track f24693a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24694b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f24695c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f24696d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24697e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f24698f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f24699g;

    /* renamed from: h  reason: collision with root package name */
    public final long f24700h;

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
        this.f24693a = track;
        this.f24695c = jArr;
        this.f24696d = iArr;
        this.f24697e = i2;
        this.f24698f = jArr2;
        this.f24699g = iArr2;
        this.f24700h = j2;
        this.f24694b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j2) {
        for (int i2 = Util.i(this.f24698f, j2, true, false); i2 >= 0; i2--) {
            if ((this.f24699g[i2] & 1) != 0) {
                return i2;
            }
        }
        return -1;
    }

    public int b(long j2) {
        for (int e2 = Util.e(this.f24698f, j2, true, false); e2 < this.f24698f.length; e2++) {
            if ((this.f24699g[e2] & 1) != 0) {
                return e2;
            }
        }
        return -1;
    }
}
