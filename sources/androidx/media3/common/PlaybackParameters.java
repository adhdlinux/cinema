package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

public final class PlaybackParameters {

    /* renamed from: d  reason: collision with root package name */
    public static final PlaybackParameters f4303d = new PlaybackParameters(1.0f);

    /* renamed from: e  reason: collision with root package name */
    private static final String f4304e = Util.B0(0);

    /* renamed from: f  reason: collision with root package name */
    private static final String f4305f = Util.B0(1);

    /* renamed from: a  reason: collision with root package name */
    public final float f4306a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4307b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4308c;

    public PlaybackParameters(float f2) {
        this(f2, 1.0f);
    }

    public long a(long j2) {
        return j2 * ((long) this.f4308c);
    }

    public PlaybackParameters b(float f2) {
        return new PlaybackParameters(f2, this.f4307b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PlaybackParameters.class != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        if (this.f4306a == playbackParameters.f4306a && this.f4307b == playbackParameters.f4307b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f4306a)) * 31) + Float.floatToRawIntBits(this.f4307b);
    }

    public String toString() {
        return Util.G("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f4306a), Float.valueOf(this.f4307b));
    }

    public PlaybackParameters(float f2, float f3) {
        boolean z2 = true;
        Assertions.a(f2 > 0.0f);
        Assertions.a(f3 <= 0.0f ? false : z2);
        this.f4306a = f2;
        this.f4307b = f3;
        this.f4308c = Math.round(f2 * 1000.0f);
    }
}
