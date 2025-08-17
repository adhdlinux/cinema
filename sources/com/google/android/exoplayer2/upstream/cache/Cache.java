package com.google.android.exoplayer2.upstream.cache;

import java.io.File;
import java.io.IOException;

public interface Cache {

    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(Throwable th) {
            super(th);
        }

        public CacheException(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface Listener {
        void onSpanAdded(Cache cache, CacheSpan cacheSpan);

        void onSpanRemoved(Cache cache, CacheSpan cacheSpan);

        void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2);
    }

    File a(String str, long j2, long j3) throws CacheException;

    ContentMetadata b(String str);

    CacheSpan c(String str, long j2, long j3) throws CacheException;

    CacheSpan d(String str, long j2, long j3) throws InterruptedException, CacheException;

    void e(File file, long j2) throws CacheException;

    void f(String str, ContentMetadataMutations contentMetadataMutations) throws CacheException;

    long g(String str, long j2, long j3);

    long h(String str, long j2, long j3);

    void i(CacheSpan cacheSpan);

    void j(CacheSpan cacheSpan);

    void k(String str);
}
