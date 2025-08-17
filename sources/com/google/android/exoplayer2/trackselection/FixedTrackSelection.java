package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import java.util.List;

public final class FixedTrackSelection extends BaseTrackSelection {

    /* renamed from: h  reason: collision with root package name */
    private final int f27748h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f27749i;

    public FixedTrackSelection(TrackGroup trackGroup, int i2, int i3) {
        this(trackGroup, i2, i3, 0, (Object) null);
    }

    public int a() {
        return 0;
    }

    public Object e() {
        return this.f27749i;
    }

    public int m() {
        return this.f27748h;
    }

    public void s(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i2, int i3, int i4, Object obj) {
        super(trackGroup, new int[]{i2}, i3);
        this.f27748h = i4;
        this.f27749i = obj;
    }
}
