package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;

public final class MediaLoadData {

    /* renamed from: a  reason: collision with root package name */
    public final int f25786a;

    /* renamed from: b  reason: collision with root package name */
    public final int f25787b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f25788c;

    /* renamed from: d  reason: collision with root package name */
    public final int f25789d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f25790e;

    /* renamed from: f  reason: collision with root package name */
    public final long f25791f;

    /* renamed from: g  reason: collision with root package name */
    public final long f25792g;

    public MediaLoadData(int i2) {
        this(i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
    }

    public MediaLoadData(int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
        this.f25786a = i2;
        this.f25787b = i3;
        this.f25788c = format;
        this.f25789d = i4;
        this.f25790e = obj;
        this.f25791f = j2;
        this.f25792g = j3;
    }
}
