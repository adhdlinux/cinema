package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.SeekMap;

public final class FlacSeekTableSeekMap implements SeekMap {

    /* renamed from: a  reason: collision with root package name */
    private final FlacStreamMetadata f8017a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8018b;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata, long j2) {
        this.f8017a = flacStreamMetadata;
        this.f8018b = j2;
    }

    private SeekPoint a(long j2, long j3) {
        return new SeekPoint((j2 * 1000000) / ((long) this.f8017a.f8023e), this.f8018b + j3);
    }

    public SeekMap.SeekPoints d(long j2) {
        long j3;
        Assertions.j(this.f8017a.f8029k);
        FlacStreamMetadata flacStreamMetadata = this.f8017a;
        FlacStreamMetadata.SeekTable seekTable = flacStreamMetadata.f8029k;
        long[] jArr = seekTable.f8031a;
        long[] jArr2 = seekTable.f8032b;
        int h2 = Util.h(jArr, flacStreamMetadata.i(j2), true, false);
        long j4 = 0;
        if (h2 == -1) {
            j3 = 0;
        } else {
            j3 = jArr[h2];
        }
        if (h2 != -1) {
            j4 = jArr2[h2];
        }
        SeekPoint a2 = a(j3, j4);
        if (a2.f8075a == j2 || h2 == jArr.length - 1) {
            return new SeekMap.SeekPoints(a2);
        }
        int i2 = h2 + 1;
        return new SeekMap.SeekPoints(a2, a(jArr[i2], jArr2[i2]));
    }

    public boolean f() {
        return true;
    }

    public long h() {
        return this.f8017a.f();
    }
}
