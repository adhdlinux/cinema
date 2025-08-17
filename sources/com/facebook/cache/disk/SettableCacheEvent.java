package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEvent;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;

@Nullsafe(Nullsafe.Mode.STRICT)
public class SettableCacheEvent implements CacheEvent {
    private static final int MAX_RECYCLED = 5;
    private static final Object RECYCLER_LOCK = new Object();
    private static SettableCacheEvent sFirstRecycledEvent;
    private static int sRecycledCount;
    private CacheKey mCacheKey;
    private long mCacheLimit;
    private long mCacheSize;
    private CacheEventListener.EvictionReason mEvictionReason;
    private IOException mException;
    private long mItemSize;
    private SettableCacheEvent mNextRecycledEvent;
    private String mResourceId;

    private SettableCacheEvent() {
    }

    @ReturnsOwnership
    public static SettableCacheEvent obtain() {
        synchronized (RECYCLER_LOCK) {
            SettableCacheEvent settableCacheEvent = sFirstRecycledEvent;
            if (settableCacheEvent == null) {
                return new SettableCacheEvent();
            }
            sFirstRecycledEvent = settableCacheEvent.mNextRecycledEvent;
            settableCacheEvent.mNextRecycledEvent = null;
            sRecycledCount--;
            return settableCacheEvent;
        }
    }

    private void reset() {
        this.mCacheKey = null;
        this.mResourceId = null;
        this.mItemSize = 0;
        this.mCacheLimit = 0;
        this.mCacheSize = 0;
        this.mException = null;
        this.mEvictionReason = null;
    }

    public CacheKey getCacheKey() {
        return this.mCacheKey;
    }

    public long getCacheLimit() {
        return this.mCacheLimit;
    }

    public long getCacheSize() {
        return this.mCacheSize;
    }

    public CacheEventListener.EvictionReason getEvictionReason() {
        return this.mEvictionReason;
    }

    public IOException getException() {
        return this.mException;
    }

    public long getItemSize() {
        return this.mItemSize;
    }

    public String getResourceId() {
        return this.mResourceId;
    }

    public void recycle() {
        synchronized (RECYCLER_LOCK) {
            if (sRecycledCount < 5) {
                reset();
                sRecycledCount++;
                SettableCacheEvent settableCacheEvent = sFirstRecycledEvent;
                if (settableCacheEvent != null) {
                    this.mNextRecycledEvent = settableCacheEvent;
                }
                sFirstRecycledEvent = this;
            }
        }
    }

    public SettableCacheEvent setCacheKey(CacheKey cacheKey) {
        this.mCacheKey = cacheKey;
        return this;
    }

    public SettableCacheEvent setCacheLimit(long j2) {
        this.mCacheLimit = j2;
        return this;
    }

    public SettableCacheEvent setCacheSize(long j2) {
        this.mCacheSize = j2;
        return this;
    }

    public SettableCacheEvent setEvictionReason(CacheEventListener.EvictionReason evictionReason) {
        this.mEvictionReason = evictionReason;
        return this;
    }

    public SettableCacheEvent setException(IOException iOException) {
        this.mException = iOException;
        return this;
    }

    public SettableCacheEvent setItemSize(long j2) {
        this.mItemSize = j2;
        return this;
    }

    public SettableCacheEvent setResourceId(String str) {
        this.mResourceId = str;
        return this;
    }
}
