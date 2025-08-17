package androidx.media3.extractor;

public final class SeekPoint {

    /* renamed from: c  reason: collision with root package name */
    public static final SeekPoint f8074c = new SeekPoint(0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final long f8075a;

    /* renamed from: b  reason: collision with root package name */
    public final long f8076b;

    public SeekPoint(long j2, long j3) {
        this.f8075a = j2;
        this.f8076b = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekPoint.class != obj.getClass()) {
            return false;
        }
        SeekPoint seekPoint = (SeekPoint) obj;
        if (this.f8075a == seekPoint.f8075a && this.f8076b == seekPoint.f8076b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f8075a) * 31) + ((int) this.f8076b);
    }

    public String toString() {
        return "[timeUs=" + this.f8075a + ", position=" + this.f8076b + "]";
    }
}
