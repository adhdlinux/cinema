package androidx.media3.extractor;

import androidx.media3.extractor.SeekMap;

public final class SingleSampleSeekMap implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    private final long f8084a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8085b;

    public SingleSampleSeekMap(long j2) {
        this(j2, 0);
    }

    public SeekMap.SeekPoints d(long j2) {
        return new SeekMap.SeekPoints(new SeekPoint(j2, this.f8085b));
    }

    public boolean f() {
        return true;
    }

    public long h() {
        return this.f8084a;
    }

    public SingleSampleSeekMap(long j2, long j3) {
        this.f8084a = j2;
        this.f8085b = j3;
    }
}
