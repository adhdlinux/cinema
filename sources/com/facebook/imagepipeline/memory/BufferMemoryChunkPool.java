package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
@DoNotStrip
public class BufferMemoryChunkPool extends MemoryChunkPool {
    @DoNotStrip
    public BufferMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    /* access modifiers changed from: protected */
    public BufferMemoryChunk alloc(int i2) {
        return new BufferMemoryChunk(i2);
    }
}
