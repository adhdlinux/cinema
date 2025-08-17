package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.TrackOutput;

public final class BaseMediaChunkOutput implements ChunkExtractor.TrackOutputProvider {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f7195a;

    /* renamed from: b  reason: collision with root package name */
    private final SampleQueue[] f7196b;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.f7195a = iArr;
        this.f7196b = sampleQueueArr;
    }

    public int[] a() {
        int[] iArr = new int[this.f7196b.length];
        int i2 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.f7196b;
            if (i2 >= sampleQueueArr.length) {
                return iArr;
            }
            iArr[i2] = sampleQueueArr[i2].H();
            i2++;
        }
    }

    public void b(long j2) {
        for (SampleQueue b02 : this.f7196b) {
            b02.b0(j2);
        }
    }

    public TrackOutput d(int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = this.f7195a;
            if (i4 >= iArr.length) {
                Log.c("BaseMediaChunkOutput", "Unmatched track of type: " + i3);
                return new DiscardingTrackOutput();
            } else if (i3 == iArr[i4]) {
                return this.f7196b[i4];
            } else {
                i4++;
            }
        }
    }
}
