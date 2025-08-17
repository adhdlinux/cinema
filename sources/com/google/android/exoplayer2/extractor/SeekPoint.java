package com.google.android.exoplayer2.extractor;

public final class SeekPoint {

    /* renamed from: c  reason: collision with root package name */
    public static final SeekPoint f24236c = new SeekPoint(0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final long f24237a;

    /* renamed from: b  reason: collision with root package name */
    public final long f24238b;

    public SeekPoint(long j2, long j3) {
        this.f24237a = j2;
        this.f24238b = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekPoint.class != obj.getClass()) {
            return false;
        }
        SeekPoint seekPoint = (SeekPoint) obj;
        if (this.f24237a == seekPoint.f24237a && this.f24238b == seekPoint.f24238b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f24237a) * 31) + ((int) this.f24238b);
    }

    public String toString() {
        return "[timeUs=" + this.f24237a + ", position=" + this.f24238b + "]";
    }
}
