package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class PlaybackParameters implements Bundleable {

    /* renamed from: e  reason: collision with root package name */
    public static final PlaybackParameters f23395e = new PlaybackParameters(1.0f);

    /* renamed from: f  reason: collision with root package name */
    private static final String f23396f = Util.u0(0);

    /* renamed from: g  reason: collision with root package name */
    private static final String f23397g = Util.u0(1);

    /* renamed from: h  reason: collision with root package name */
    public static final Bundleable.Creator<PlaybackParameters> f23398h = new v1();

    /* renamed from: b  reason: collision with root package name */
    public final float f23399b;

    /* renamed from: c  reason: collision with root package name */
    public final float f23400c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23401d;

    public PlaybackParameters(float f2) {
        this(f2, 1.0f);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ PlaybackParameters c(Bundle bundle) {
        return new PlaybackParameters(bundle.getFloat(f23396f, 1.0f), bundle.getFloat(f23397g, 1.0f));
    }

    public long b(long j2) {
        return j2 * ((long) this.f23401d);
    }

    public PlaybackParameters d(float f2) {
        return new PlaybackParameters(f2, this.f23400c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PlaybackParameters.class != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        if (this.f23399b == playbackParameters.f23399b && this.f23400c == playbackParameters.f23400c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f23399b)) * 31) + Float.floatToRawIntBits(this.f23400c);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat(f23396f, this.f23399b);
        bundle.putFloat(f23397g, this.f23400c);
        return bundle;
    }

    public String toString() {
        return Util.C("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f23399b), Float.valueOf(this.f23400c));
    }

    public PlaybackParameters(float f2, float f3) {
        boolean z2 = true;
        Assertions.a(f2 > 0.0f);
        Assertions.a(f3 <= 0.0f ? false : z2);
        this.f23399b = f2;
        this.f23400c = f3;
        this.f23401d = Math.round(f2 * 1000.0f);
    }
}
