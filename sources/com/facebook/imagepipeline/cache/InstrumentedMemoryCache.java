package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class InstrumentedMemoryCache<K, V> implements MemoryCache<K, V> {
    private final MemoryCache<K, V> mDelegate;
    private final MemoryCacheTracker mTracker;

    public InstrumentedMemoryCache(MemoryCache<K, V> memoryCache, MemoryCacheTracker memoryCacheTracker) {
        this.mDelegate = memoryCache;
        this.mTracker = memoryCacheTracker;
    }

    public CloseableReference<V> cache(K k2, CloseableReference<V> closeableReference) {
        this.mTracker.onCachePut(k2);
        return this.mDelegate.cache(k2, closeableReference);
    }

    public boolean contains(Predicate<K> predicate) {
        return this.mDelegate.contains(predicate);
    }

    public CloseableReference<V> get(K k2) {
        CloseableReference<V> closeableReference = this.mDelegate.get(k2);
        if (closeableReference == null) {
            this.mTracker.onCacheMiss(k2);
        } else {
            this.mTracker.onCacheHit(k2);
        }
        return closeableReference;
    }

    public int getCount() {
        return this.mDelegate.getCount();
    }

    public String getDebugData() {
        return this.mDelegate.getDebugData();
    }

    public int getSizeInBytes() {
        return this.mDelegate.getSizeInBytes();
    }

    public void probe(K k2) {
        this.mDelegate.probe(k2);
    }

    public int removeAll(Predicate<K> predicate) {
        return this.mDelegate.removeAll(predicate);
    }

    public void trim(MemoryTrimType memoryTrimType) {
        this.mDelegate.trim(memoryTrimType);
    }

    public boolean contains(K k2) {
        return this.mDelegate.contains(k2);
    }
}
