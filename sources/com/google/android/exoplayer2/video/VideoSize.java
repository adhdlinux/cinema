package com.google.android.exoplayer2.video;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;
import w0.n;

public final class VideoSize implements Bundleable {

    /* renamed from: f  reason: collision with root package name */
    public static final VideoSize f28956f = new VideoSize(0, 0);

    /* renamed from: g  reason: collision with root package name */
    private static final String f28957g = Util.u0(0);

    /* renamed from: h  reason: collision with root package name */
    private static final String f28958h = Util.u0(1);

    /* renamed from: i  reason: collision with root package name */
    private static final String f28959i = Util.u0(2);

    /* renamed from: j  reason: collision with root package name */
    private static final String f28960j = Util.u0(3);

    /* renamed from: k  reason: collision with root package name */
    public static final Bundleable.Creator<VideoSize> f28961k = new n();

    /* renamed from: b  reason: collision with root package name */
    public final int f28962b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28963c;

    /* renamed from: d  reason: collision with root package name */
    public final int f28964d;

    /* renamed from: e  reason: collision with root package name */
    public final float f28965e;

    public VideoSize(int i2, int i3) {
        this(i2, i3, 0, 1.0f);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ VideoSize b(Bundle bundle) {
        return new VideoSize(bundle.getInt(f28957g, 0), bundle.getInt(f28958h, 0), bundle.getInt(f28959i, 0), bundle.getFloat(f28960j, 1.0f));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        if (this.f28962b == videoSize.f28962b && this.f28963c == videoSize.f28963c && this.f28964d == videoSize.f28964d && this.f28965e == videoSize.f28965e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((217 + this.f28962b) * 31) + this.f28963c) * 31) + this.f28964d) * 31) + Float.floatToRawIntBits(this.f28965e);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(f28957g, this.f28962b);
        bundle.putInt(f28958h, this.f28963c);
        bundle.putInt(f28959i, this.f28964d);
        bundle.putFloat(f28960j, this.f28965e);
        return bundle;
    }

    public VideoSize(int i2, int i3, int i4, float f2) {
        this.f28962b = i2;
        this.f28963c = i3;
        this.f28964d = i4;
        this.f28965e = f2;
    }
}
