package androidx.media3.common;

import androidx.media3.common.util.Util;

public final class VideoSize {

    /* renamed from: e  reason: collision with root package name */
    public static final VideoSize f4483e = new VideoSize(0, 0);

    /* renamed from: f  reason: collision with root package name */
    private static final String f4484f = Util.B0(0);

    /* renamed from: g  reason: collision with root package name */
    private static final String f4485g = Util.B0(1);

    /* renamed from: h  reason: collision with root package name */
    private static final String f4486h = Util.B0(2);

    /* renamed from: i  reason: collision with root package name */
    private static final String f4487i = Util.B0(3);

    /* renamed from: a  reason: collision with root package name */
    public final int f4488a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4489b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4490c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4491d;

    public VideoSize(int i2, int i3) {
        this(i2, i3, 0, 1.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        if (this.f4488a == videoSize.f4488a && this.f4489b == videoSize.f4489b && this.f4490c == videoSize.f4490c && this.f4491d == videoSize.f4491d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((217 + this.f4488a) * 31) + this.f4489b) * 31) + this.f4490c) * 31) + Float.floatToRawIntBits(this.f4491d);
    }

    public VideoSize(int i2, int i3, int i4, float f2) {
        this.f4488a = i2;
        this.f4489b = i3;
        this.f4490c = i4;
        this.f4491d = f2;
    }
}
