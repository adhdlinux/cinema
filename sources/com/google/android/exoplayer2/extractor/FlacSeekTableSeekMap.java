package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class FlacSeekTableSeekMap implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    private final FlacStreamMetadata f24206a;

    /* renamed from: b  reason: collision with root package name */
    private final long f24207b;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata, long j2) {
        this.f24206a = flacStreamMetadata;
        this.f24207b = j2;
    }

    private SeekPoint a(long j2, long j3) {
        return new SeekPoint((j2 * 1000000) / ((long) this.f24206a.f24212e), this.f24207b + j3);
    }

    public SeekMap.SeekPoints d(long j2) {
        long j3;
        Assertions.i(this.f24206a.f24218k);
        FlacStreamMetadata flacStreamMetadata = this.f24206a;
        FlacStreamMetadata.SeekTable seekTable = flacStreamMetadata.f24218k;
        long[] jArr = seekTable.f24220a;
        long[] jArr2 = seekTable.f24221b;
        int i2 = Util.i(jArr, flacStreamMetadata.i(j2), true, false);
        long j4 = 0;
        if (i2 == -1) {
            j3 = 0;
        } else {
            j3 = jArr[i2];
        }
        if (i2 != -1) {
            j4 = jArr2[i2];
        }
        SeekPoint a2 = a(j3, j4);
        if (a2.f24237a == j2 || i2 == jArr.length - 1) {
            return new SeekMap.SeekPoints(a2);
        }
        int i3 = i2 + 1;
        return new SeekMap.SeekPoints(a2, a(jArr[i3], jArr2[i3]));
    }

    public boolean f() {
        return true;
    }

    public long h() {
        return this.f24206a.f();
    }
}
