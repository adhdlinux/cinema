package androidx.media3.common;

import android.view.Surface;
import androidx.media3.common.util.Assertions;

public final class SurfaceInfo {

    /* renamed from: a  reason: collision with root package name */
    public final Surface f4342a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4343b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4344c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4345d;

    public SurfaceInfo(Surface surface, int i2, int i3) {
        this(surface, i2, i3, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurfaceInfo)) {
            return false;
        }
        SurfaceInfo surfaceInfo = (SurfaceInfo) obj;
        if (this.f4343b == surfaceInfo.f4343b && this.f4344c == surfaceInfo.f4344c && this.f4345d == surfaceInfo.f4345d && this.f4342a.equals(surfaceInfo.f4342a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f4342a.hashCode() * 31) + this.f4343b) * 31) + this.f4344c) * 31) + this.f4345d;
    }

    public SurfaceInfo(Surface surface, int i2, int i3, int i4) {
        Assertions.b(i4 == 0 || i4 == 90 || i4 == 180 || i4 == 270, "orientationDegrees must be 0, 90, 180, or 270");
        this.f4342a = surface;
        this.f4343b = i2;
        this.f4344c = i3;
        this.f4345d = i4;
    }
}
