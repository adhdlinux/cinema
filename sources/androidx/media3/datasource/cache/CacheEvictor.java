package androidx.media3.datasource.cache;

import androidx.media3.datasource.cache.Cache;

public interface CacheEvictor extends Cache.Listener {
    void c(Cache cache, String str, long j2, long j3);

    void onCacheInitialized();

    boolean requiresCacheSpanTouches();
}
