package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class EncodedCountingMemoryCacheFactory {
    public static CountingMemoryCache<CacheKey, PooledByteBuffer> get(Supplier<MemoryCacheParams> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry) {
        LruCountingMemoryCache lruCountingMemoryCache = new LruCountingMemoryCache(new ValueDescriptor<PooledByteBuffer>() {
            public int getSizeInBytes(PooledByteBuffer pooledByteBuffer) {
                return pooledByteBuffer.size();
            }
        }, new NativeMemoryCacheTrimStrategy(), supplier, (CountingMemoryCache.EntryStateObserver) null);
        memoryTrimmableRegistry.registerMemoryTrimmable(lruCountingMemoryCache);
        return lruCountingMemoryCache;
    }
}
