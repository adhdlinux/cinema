package androidx.media3.extractor.mp4;

import androidx.media3.common.Format;

public final class Track {

    /* renamed from: a  reason: collision with root package name */
    public final int f8660a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8661b;

    /* renamed from: c  reason: collision with root package name */
    public final long f8662c;

    /* renamed from: d  reason: collision with root package name */
    public final long f8663d;

    /* renamed from: e  reason: collision with root package name */
    public final long f8664e;

    /* renamed from: f  reason: collision with root package name */
    public final Format f8665f;

    /* renamed from: g  reason: collision with root package name */
    public final int f8666g;

    /* renamed from: h  reason: collision with root package name */
    public final long[] f8667h;

    /* renamed from: i  reason: collision with root package name */
    public final long[] f8668i;

    /* renamed from: j  reason: collision with root package name */
    public final int f8669j;

    /* renamed from: k  reason: collision with root package name */
    private final TrackEncryptionBox[] f8670k;

    public Track(int i2, int i3, long j2, long j3, long j4, Format format, int i4, TrackEncryptionBox[] trackEncryptionBoxArr, int i5, long[] jArr, long[] jArr2) {
        this.f8660a = i2;
        this.f8661b = i3;
        this.f8662c = j2;
        this.f8663d = j3;
        this.f8664e = j4;
        this.f8665f = format;
        this.f8666g = i4;
        this.f8670k = trackEncryptionBoxArr;
        this.f8669j = i5;
        this.f8667h = jArr;
        this.f8668i = jArr2;
    }

    public TrackEncryptionBox a(int i2) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.f8670k;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i2];
    }
}
