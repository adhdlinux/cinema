package com.facebook.imagepipeline.cache;

import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.TimeUnit;

@Nullsafe(Nullsafe.Mode.STRICT)
public class MemoryCacheParams {
    public final int maxCacheEntries;
    public final int maxCacheEntrySize;
    public final int maxCacheSize;
    public final int maxEvictionQueueEntries;
    public final int maxEvictionQueueSize;
    public final long paramsCheckIntervalMs;

    public MemoryCacheParams(int i2, int i3, int i4, int i5, int i6) {
        this(i2, i3, i4, i5, i6, TimeUnit.MINUTES.toMillis(5));
    }

    public MemoryCacheParams(int i2, int i3, int i4, int i5, int i6, long j2) {
        this.maxCacheSize = i2;
        this.maxCacheEntries = i3;
        this.maxEvictionQueueSize = i4;
        this.maxEvictionQueueEntries = i5;
        this.maxCacheEntrySize = i6;
        this.paramsCheckIntervalMs = j2;
    }
}
