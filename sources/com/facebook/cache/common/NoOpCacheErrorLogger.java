package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class NoOpCacheErrorLogger implements CacheErrorLogger {
    private static NoOpCacheErrorLogger sInstance;

    private NoOpCacheErrorLogger() {
    }

    public static synchronized NoOpCacheErrorLogger getInstance() {
        NoOpCacheErrorLogger noOpCacheErrorLogger;
        synchronized (NoOpCacheErrorLogger.class) {
            if (sInstance == null) {
                sInstance = new NoOpCacheErrorLogger();
            }
            noOpCacheErrorLogger = sInstance;
        }
        return noOpCacheErrorLogger;
    }

    public void logError(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, Throwable th) {
    }
}
