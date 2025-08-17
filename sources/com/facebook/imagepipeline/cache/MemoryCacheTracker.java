package com.facebook.imagepipeline.cache;

public interface MemoryCacheTracker<K> {
    void onCacheHit(K k2);

    void onCacheMiss(K k2);

    void onCachePut(K k2);
}
