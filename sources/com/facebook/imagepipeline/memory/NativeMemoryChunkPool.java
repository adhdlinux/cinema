package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
@DoNotStrip
public class NativeMemoryChunkPool extends MemoryChunkPool {
    @DoNotStrip
    public NativeMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    /* access modifiers changed from: protected */
    public NativeMemoryChunk alloc(int i2) {
        return new NativeMemoryChunk(i2);
    }
}
