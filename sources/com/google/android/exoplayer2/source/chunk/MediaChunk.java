package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;

public abstract class MediaChunk extends Chunk {

    /* renamed from: j  reason: collision with root package name */
    public final long f26129j;

    public MediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, long j2, long j3, long j4) {
        super(dataSource, dataSpec, 1, format, i2, obj, j2, j3);
        Assertions.e(format);
        this.f26129j = j4;
    }

    public long g() {
        long j2 = this.f26129j;
        if (j2 != -1) {
            return 1 + j2;
        }
        return -1;
    }

    public abstract boolean h();
}
