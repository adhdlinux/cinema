package androidx.media3.common;

import androidx.media3.common.util.Assertions;

public class FrameInfo {

    /* renamed from: a  reason: collision with root package name */
    public final ColorInfo f4054a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4055b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4056c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4057d;

    /* renamed from: e  reason: collision with root package name */
    public final long f4058e;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private ColorInfo f4059a;

        /* renamed from: b  reason: collision with root package name */
        private int f4060b;

        /* renamed from: c  reason: collision with root package name */
        private int f4061c;

        /* renamed from: d  reason: collision with root package name */
        private float f4062d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        private long f4063e;

        public Builder(ColorInfo colorInfo, int i2, int i3) {
            this.f4059a = colorInfo;
            this.f4060b = i2;
            this.f4061c = i3;
        }

        public FrameInfo a() {
            return new FrameInfo(this.f4059a, this.f4060b, this.f4061c, this.f4062d, this.f4063e);
        }

        public Builder b(float f2) {
            this.f4062d = f2;
            return this;
        }
    }

    private FrameInfo(ColorInfo colorInfo, int i2, int i3, float f2, long j2) {
        boolean z2 = true;
        boolean z3 = i2 > 0;
        Assertions.b(z3, "width must be positive, but is: " + i2);
        z2 = i3 <= 0 ? false : z2;
        Assertions.b(z2, "height must be positive, but is: " + i3);
        this.f4054a = colorInfo;
        this.f4055b = i2;
        this.f4056c = i3;
        this.f4057d = f2;
        this.f4058e = j2;
    }
}
