package com.facebook.cache.common;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface CacheEventListener {

    public enum EvictionReason {
        CACHE_FULL,
        CONTENT_STALE,
        USER_FORCED,
        CACHE_MANAGER_TRIMMED
    }

    void onCleared();

    void onEviction(CacheEvent cacheEvent);

    void onHit(CacheEvent cacheEvent);

    void onMiss(CacheEvent cacheEvent);

    void onReadException(CacheEvent cacheEvent);

    void onWriteAttempt(CacheEvent cacheEvent);

    void onWriteException(CacheEvent cacheEvent);

    void onWriteSuccess(CacheEvent cacheEvent);
}
