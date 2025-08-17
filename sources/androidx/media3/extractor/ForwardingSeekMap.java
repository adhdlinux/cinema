package androidx.media3.extractor;

import androidx.media3.extractor.SeekMap;

public class ForwardingSeekMap implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    private final SeekMap f8034a;

    public ForwardingSeekMap(SeekMap seekMap) {
        this.f8034a = seekMap;
    }

    public SeekMap.SeekPoints d(long j2) {
        return this.f8034a.d(j2);
    }

    public boolean f() {
        return this.f8034a.f();
    }

    public long h() {
        return this.f8034a.h();
    }
}
