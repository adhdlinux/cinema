package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;

public final class Track {

    /* renamed from: a  reason: collision with root package name */
    public final int f24659a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24660b;

    /* renamed from: c  reason: collision with root package name */
    public final long f24661c;

    /* renamed from: d  reason: collision with root package name */
    public final long f24662d;

    /* renamed from: e  reason: collision with root package name */
    public final long f24663e;

    /* renamed from: f  reason: collision with root package name */
    public final Format f24664f;

    /* renamed from: g  reason: collision with root package name */
    public final int f24665g;

    /* renamed from: h  reason: collision with root package name */
    public final long[] f24666h;

    /* renamed from: i  reason: collision with root package name */
    public final long[] f24667i;

    /* renamed from: j  reason: collision with root package name */
    public final int f24668j;

    /* renamed from: k  reason: collision with root package name */
    private final TrackEncryptionBox[] f24669k;

    public Track(int i2, int i3, long j2, long j3, long j4, Format format, int i4, TrackEncryptionBox[] trackEncryptionBoxArr, int i5, long[] jArr, long[] jArr2) {
        this.f24659a = i2;
        this.f24660b = i3;
        this.f24661c = j2;
        this.f24662d = j3;
        this.f24663e = j4;
        this.f24664f = format;
        this.f24665g = i4;
        this.f24669k = trackEncryptionBoxArr;
        this.f24668j = i5;
        this.f24666h = jArr;
        this.f24667i = jArr2;
    }

    public TrackEncryptionBox a(int i2) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.f24669k;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i2];
    }
}
