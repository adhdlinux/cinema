package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import java.util.List;

public interface ExoTrackSelection extends TrackSelection {

    public static final class Definition {

        /* renamed from: a  reason: collision with root package name */
        public final TrackGroup f7457a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f7458b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7459c;

        public Definition(TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0);
        }

        public Definition(TrackGroup trackGroup, int[] iArr, int i2) {
            if (iArr.length == 0) {
                Log.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f7457a = trackGroup;
            this.f7458b = iArr;
            this.f7459c = i2;
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

    void q(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr);

    boolean r(int i2, long j2);

    boolean s(long j2, Chunk chunk, List<? extends MediaChunk> list);
}
