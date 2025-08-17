package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Log;
import java.util.List;

public interface ExoTrackSelection extends TrackSelection {

    public static final class Definition {

        /* renamed from: a  reason: collision with root package name */
        public final TrackGroup f27745a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f27746b;

        /* renamed from: c  reason: collision with root package name */
        public final int f27747c;

        public Definition(TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0);
        }

        public Definition(TrackGroup trackGroup, int[] iArr, int i2) {
            if (iArr.length == 0) {
                Log.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f27745a = trackGroup;
            this.f27746b = iArr;
            this.f27747c = i2;
        }
    }

    public interface Factory {
        ExoTrackSelection[] a(Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline);
    }

    int a();

    void d(float f2);

    void disable();

    Object e();

    void enable();

    void f();

    void i(boolean z2);

    int j(long j2, List<? extends MediaChunk> list);

    int k();

    Format l();

    int m();

    void n();

    boolean o(int i2, long j2);

    boolean p(int i2, long j2);

    boolean q(long j2, Chunk chunk, List<? extends MediaChunk> list);

    void s(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr);
}
