package androidx.media3.datasource.cache;

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
        void a(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2);

        void b(Cache cache, CacheSpan cacheSpan);

        void d(Cache cache, CacheSpan cacheSpan);
    }

    File a(String str, long j2, long j3) throws CacheException;

    ContentMetadata b(String str);

    CacheSpan c(String str, long j2, long j3) throws CacheException;

    CacheSpan d(String str, long j2, long j3) throws InterruptedException, CacheException;

    void e(File file, long j2) throws CacheException;

    void f(CacheSpan cacheSpan);

    void g(CacheSpan cacheSpan);

    void h(String str, ContentMetadataMutations contentMetadataMutations) throws CacheException;
}
