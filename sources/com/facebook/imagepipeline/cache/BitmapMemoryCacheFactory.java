package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;

public interface BitmapMemoryCacheFactory {
    CountingMemoryCache<CacheKey, CloseableImage> create(Supplier<MemoryCacheParams> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, MemoryCache.CacheTrimStrategy cacheTrimStrategy, CountingMemoryCache.EntryStateObserver<CacheKey> entryStateObserver);
}
