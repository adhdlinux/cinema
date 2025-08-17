package androidx.media3.exoplayer;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;

final class MediaPeriodInfo {

    /* renamed from: a  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f5416a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5417b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5418c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5419d;

    /* renamed from: e  reason: collision with root package name */
    public final long f5420e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5421f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f5422g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f5423h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f5424i;

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
        this.f5416a = mediaPeriodId;
        this.f5417b = j2;
        this.f5418c = j3;
        this.f5419d = j4;
        this.f5420e = j5;
        this.f5421f = z8;
        this.f5422g = z9;
        this.f5423h = z10;
        this.f5424i = z11;
    }

    public MediaPeriodInfo a(long j2) {
        if (j2 == this.f5418c) {
            return this;
        }
        return new MediaPeriodInfo(this.f5416a, this.f5417b, j2, this.f5419d, this.f5420e, this.f5421f, this.f5422g, this.f5423h, this.f5424i);
    }

    public MediaPeriodInfo b(long j2) {
        if (j2 == this.f5417b) {
            return this;
        }
        return new MediaPeriodInfo(this.f5416a, j2, this.f5418c, this.f5419d, this.f5420e, this.f5421f, this.f5422g, this.f5423h, this.f5424i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaPeriodInfo.class != obj.getClass()) {
            return false;
        }
        MediaPeriodInfo mediaPeriodInfo = (MediaPeriodInfo) obj;
        if (this.f5417b == mediaPeriodInfo.f5417b && this.f5418c == mediaPeriodInfo.f5418c && this.f5419d == mediaPeriodInfo.f5419d && this.f5420e == mediaPeriodInfo.f5420e && this.f5421f == mediaPeriodInfo.f5421f && this.f5422g == mediaPeriodInfo.f5422g && this.f5423h == mediaPeriodInfo.f5423h && this.f5424i == mediaPeriodInfo.f5424i && Util.c(this.f5416a, mediaPeriodInfo.f5416a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f5416a.hashCode()) * 31) + ((int) this.f5417b)) * 31) + ((int) this.f5418c)) * 31) + ((int) this.f5419d)) * 31) + ((int) this.f5420e)) * 31) + (this.f5421f ? 1 : 0)) * 31) + (this.f5422g ? 1 : 0)) * 31) + (this.f5423h ? 1 : 0)) * 31) + (this.f5424i ? 1 : 0);
    }
}
