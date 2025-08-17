package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

public class DiskLruCacheFactory implements DiskCache.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final long f16627a;

    /* renamed from: b  reason: collision with root package name */
    private final CacheDirectoryGetter f16628b;

    public interface CacheDirectoryGetter {
        File a();
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j2) {
        this.f16627a = j2;
        this.f16628b = cacheDirectoryGetter;
    }

    public DiskCache build() {
        File a2 = this.f16628b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return DiskLruCacheWrapper.c(a2, this.f16627a);
        }
        return null;
    }
}
