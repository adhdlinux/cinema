package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;

final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {
    public ConstantBitrateSeeker(long j2, long j3, MpegAudioUtil.Header header, boolean z2) {
        super(j2, j3, header.f23842f, header.f23839c, z2);
    }

    public long b(long j2) {
        return c(j2);
    }

    public long e() {
        return -1;
    }
}
