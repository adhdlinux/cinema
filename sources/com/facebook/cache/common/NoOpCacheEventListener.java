package com.facebook.cache.common;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class NoOpCacheEventListener implements CacheEventListener {
    private static NoOpCacheEventListener sInstance;

    private NoOpCacheEventListener() {
    }

    public static synchronized NoOpCacheEventListener getInstance() {
        NoOpCacheEventListener noOpCacheEventListener;
        synchronized (NoOpCacheEventListener.class) {
            if (sInstance == null) {
                sInstance = new NoOpCacheEventListener();
            }
            noOpCacheEventListener = sInstance;
        }
        return noOpCacheEventListener;
    }

    public void onCleared() {
    }

    public void onEviction(CacheEvent cacheEvent) {
    }

    public void onHit(CacheEvent cacheEvent) {
    }

    public void onMiss(CacheEvent cacheEvent) {
    }

    public void onReadException(CacheEvent cacheEvent) {
    }

    public void onWriteAttempt(CacheEvent cacheEvent) {
    }

    public void onWriteException(CacheEvent cacheEvent) {
    }

    public void onWriteSuccess(CacheEvent cacheEvent) {
    }
}
