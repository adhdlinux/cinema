package androidx.media3.exoplayer.source;

import androidx.media3.common.Format;

public final class MediaLoadData {

    /* renamed from: a  reason: collision with root package name */
    public final int f6964a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6965b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f6966c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6967d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f6968e;

    /* renamed from: f  reason: collision with root package name */
    public final long f6969f;

    /* renamed from: g  reason: collision with root package name */
    public final long f6970g;

    public MediaLoadData(int i2) {
        this(i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
    }

    public MediaLoadData(int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
        this.f6964a = i2;
        this.f6965b = i3;
        this.f6966c = format;
        this.f6967d = i4;
        this.f6968e = obj;
        this.f6969f = j2;
        this.f6970g = j3;
    }
}
