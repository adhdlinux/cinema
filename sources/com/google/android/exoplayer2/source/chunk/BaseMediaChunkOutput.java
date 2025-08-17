package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.util.Log;

public final class BaseMediaChunkOutput implements ChunkExtractor.TrackOutputProvider {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f26058a;

    /* renamed from: b  reason: collision with root package name */
    private final SampleQueue[] f26059b;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.f26058a = iArr;
        this.f26059b = sampleQueueArr;
    }

    public int[] a() {
        int[] iArr = new int[this.f26059b.length];
        int i2 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.f26059b;
            if (i2 >= sampleQueueArr.length) {
                return iArr;
            }
            iArr[i2] = sampleQueueArr[i2].G();
            i2++;
        }
    }

    public void b(long j2) {
        for (SampleQueue a02 : this.f26059b) {
            a02.a0(j2);
        }
    }

    public TrackOutput d(int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = this.f26058a;
            if (i4 >= iArr.length) {
                Log.c("BaseMediaChunkOutput", "Unmatched track of type: " + i3);
                return new DummyTrackOutput();
            } else if (i3 == iArr[i4]) {
                return this.f26059b[i4];
            } else {
                i4++;
            }
        }
    }
}
