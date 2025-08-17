package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class InstrumentedMemoryCacheBitmapMemoryCacheFactory {
    public static InstrumentedMemoryCache<CacheKey, CloseableImage> get(MemoryCache<CacheKey, CloseableImage> memoryCache, final ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.registerBitmapMemoryCache(memoryCache);
        return new InstrumentedMemoryCache<>(memoryCache, new MemoryCacheTracker<CacheKey>() {
            public void onCacheHit(CacheKey cacheKey) {
                imageCacheStatsTracker.onBitmapCacheHit(cacheKey);
            }

            public void onCacheMiss(CacheKey cacheKey) {
                imageCacheStatsTracker.onBitmapCacheMiss(cacheKey);
            }

            public void onCachePut(CacheKey cacheKey) {
                imageCacheStatsTracker.onBitmapCachePut(cacheKey);
            }
        });
    }
}
