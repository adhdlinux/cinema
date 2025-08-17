package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class MediaPeriodInfo {

    /* renamed from: a  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f23319a;

    /* renamed from: b  reason: collision with root package name */
    public final long f23320b;

    /* renamed from: c  reason: collision with root package name */
    public final long f23321c;

    /* renamed from: d  reason: collision with root package name */
    public final long f23322d;

    /* renamed from: e  reason: collision with root package name */
    public final long f23323e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f23324f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f23325g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f23326h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f23327i;

    MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, long j5, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        boolean z7;
        boolean z8 = z2;
        boolean z9 = z3;
        boolean z10 = z4;
        boolean z11 = z5;
        boolean z12 = false;
        if (!z11 || z9) {
            z6 = true;
        } else {
            z6 = false;
        }
        Assertions.a(z6);
        if (!z10 || z9) {
            z7 = true;
        } else {
            z7 = false;
        }
        Assertions.a(z7);
        if (!z8 || (!z9 && !z10 && !z11)) {
            z12 = true;
        }
        Assertions.a(z12);
        this.f23319a = mediaPeriodId;
        this.f23320b = j2;
        this.f23321c = j3;
        this.f23322d = j4;
        this.f23323e = j5;
        this.f23324f = z8;
        this.f23325g = z9;
        this.f23326h = z10;
        this.f23327i = z11;
    }

    public MediaPeriodInfo a(long j2) {
        if (j2 == this.f23321c) {
            return this;
        }
        return new MediaPeriodInfo(this.f23319a, this.f23320b, j2, this.f23322d, this.f23323e, this.f23324f, this.f23325g, this.f23326h, this.f23327i);
    }

    public MediaPeriodInfo b(long j2) {
        if (j2 == this.f23320b) {
            return this;
        }
        return new MediaPeriodInfo(this.f23319a, j2, this.f23321c, this.f23322d, this.f23323e, this.f23324f, this.f23325g, this.f23326h, this.f23327i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaPeriodInfo.class != obj.getClass()) {
            return false;
        }
        MediaPeriodInfo mediaPeriodInfo = (MediaPeriodInfo) obj;
        if (this.f23320b == mediaPeriodInfo.f23320b && this.f23321c == mediaPeriodInfo.f23321c && this.f23322d == mediaPeriodInfo.f23322d && this.f23323e == mediaPeriodInfo.f23323e && this.f23324f == mediaPeriodInfo.f23324f && this.f23325g == mediaPeriodInfo.f23325g && this.f23326h == mediaPeriodInfo.f23326h && this.f23327i == mediaPeriodInfo.f23327i && Util.c(this.f23319a, mediaPeriodInfo.f23319a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f23319a.hashCode()) * 31) + ((int) this.f23320b)) * 31) + ((int) this.f23321c)) * 31) + ((int) this.f23322d)) * 31) + ((int) this.f23323e)) * 31) + (this.f23324f ? 1 : 0)) * 31) + (this.f23325g ? 1 : 0)) * 31) + (this.f23326h ? 1 : 0)) * 31) + (this.f23327i ? 1 : 0);
    }
}
