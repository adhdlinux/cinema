package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.TrackGroup;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import java.util.List;

public final class FixedTrackSelection extends BaseTrackSelection {

    /* renamed from: h  reason: collision with root package name */
    private final int f7460h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f7461i;

    public FixedTrackSelection(TrackGroup trackGroup, int i2, int i3) {
        this(trackGroup, i2, i3, 0, (Object) null);
    }

    public int a() {
        return 0;
    }

    public Object e() {
        return this.f7461i;
    }

    public int m() {
        return this.f7460h;
    }

    public void q(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i2, int i3, int i4, Object obj) {
        super(trackGroup, new int[]{i2}, i3);
        this.f7460h = i4;
        this.f7461i = obj;
    }
}
