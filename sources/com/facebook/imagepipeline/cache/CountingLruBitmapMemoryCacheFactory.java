package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class CountingLruBitmapMemoryCacheFactory implements BitmapMemoryCacheFactory {
    public CountingMemoryCache<CacheKey, CloseableImage> create(Supplier<MemoryCacheParams> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, MemoryCache.CacheTrimStrategy cacheTrimStrategy, CountingMemoryCache.EntryStateObserver<CacheKey> entryStateObserver) {
        LruCountingMemoryCache lruCountingMemoryCache = new LruCountingMemoryCache(new ValueDescriptor<CloseableImage>() {
            public int getSizeInBytes(CloseableImage closeableImage) {
                return closeableImage.getSizeInBytes();
            }
        }, cacheTrimStrategy, supplier, entryStateObserver);
        memoryTrimmableRegistry.registerMemoryTrimmable(lruCountingMemoryCache);
        return lruCountingMemoryCache;
    }
}
