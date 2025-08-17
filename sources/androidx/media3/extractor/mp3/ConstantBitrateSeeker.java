package androidx.media3.extractor.mp3;

import androidx.media3.extractor.ConstantBitrateSeekMap;
import androidx.media3.extractor.MpegAudioUtil;

final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {

    /* renamed from: h  reason: collision with root package name */
    private final int f8474h;

    /* renamed from: i  reason: collision with root package name */
    private final long f8475i;

    public ConstantBitrateSeeker(long j2, long j3, MpegAudioUtil.Header header, boolean z2) {
        this(j2, j3, header.f8067f, header.f8064c, z2);
    }

    public long b(long j2) {
        return c(j2);
    }

    public long e() {
        return this.f8475i;
    }

    public int l() {
        return this.f8474h;
    }

    public ConstantBitrateSeeker(long j2, long j3, int i2, int i3, boolean z2) {
        super(j2, j3, i2, i3, z2);
        this.f8474h = i2;
        this.f8475i = j2 == -1 ? -1 : j2;
    }
}
