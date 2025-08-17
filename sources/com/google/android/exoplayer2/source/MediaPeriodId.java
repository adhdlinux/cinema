package com.google.android.exoplayer2.source;

public class MediaPeriodId {

    /* renamed from: a  reason: collision with root package name */
    public final Object f25793a;

    /* renamed from: b  reason: collision with root package name */
    public final int f25794b;

    /* renamed from: c  reason: collision with root package name */
    public final int f25795c;

    /* renamed from: d  reason: collision with root package name */
    public final long f25796d;

    /* renamed from: e  reason: collision with root package name */
    public final int f25797e;

    public MediaPeriodId(Object obj) {
        this(obj, -1);
    }

    public MediaPeriodId a(Object obj) {
        if (this.f25793a.equals(obj)) {
            return this;
        }
        return new MediaPeriodId(obj, this.f25794b, this.f25795c, this.f25796d, this.f25797e);
    }

    public boolean b() {
        return this.f25794b != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaPeriodId)) {
            return false;
        }
        MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
        if (this.f25793a.equals(mediaPeriodId.f25793a) && this.f25794b == mediaPeriodId.f25794b && this.f25795c == mediaPeriodId.f25795c && this.f25796d == mediaPeriodId.f25796d && this.f25797e == mediaPeriodId.f25797e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f25793a.hashCode()) * 31) + this.f25794b) * 31) + this.f25795c) * 31) + ((int) this.f25796d)) * 31) + this.f25797e;
    }

    public MediaPeriodId(Object obj, long j2) {
        this(obj, -1, -1, j2, -1);
    }

    public MediaPeriodId(Object obj, long j2, int i2) {
        this(obj, -1, -1, j2, i2);
    }

    public MediaPeriodId(Object obj, int i2, int i3, long j2) {
        this(obj, i2, i3, j2, -1);
    }

    protected MediaPeriodId(MediaPeriodId mediaPeriodId) {
        this.f25793a = mediaPeriodId.f25793a;
        this.f25794b = mediaPeriodId.f25794b;
        this.f25795c = mediaPeriodId.f25795c;
        this.f25796d = mediaPeriodId.f25796d;
        this.f25797e = mediaPeriodId.f25797e;
    }

    private MediaPeriodId(Object obj, int i2, int i3, long j2, int i4) {
        this.f25793a = obj;
        this.f25794b = i2;
        this.f25795c = i3;
        this.f25796d = j2;
        this.f25797e = i4;
    }
}
