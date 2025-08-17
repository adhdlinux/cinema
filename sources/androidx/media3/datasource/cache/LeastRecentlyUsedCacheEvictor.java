package androidx.media3.datasource.cache;

import d.d;
import java.util.TreeSet;

public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {

    /* renamed from: a  reason: collision with root package name */
    private final long f5012a;

    /* renamed from: b  reason: collision with root package name */
    private final TreeSet<CacheSpan> f5013b = new TreeSet<>(new d());

    /* renamed from: c  reason: collision with root package name */
    private long f5014c;

    public LeastRecentlyUsedCacheEvictor(long j2) {
        this.f5012a = j2;
    }

    /* access modifiers changed from: private */
    public static int f(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        long j2 = cacheSpan.f4981g;
        long j3 = cacheSpan2.f4981g;
        if (j2 - j3 == 0) {
            return cacheSpan.compareTo(cacheSpan2);
        }
        if (j2 < j3) {
            return -1;
        }
        return 1;
    }

    private void g(Cache cache, long j2) {
        while (this.f5014c + j2 > this.f5012a && !this.f5013b.isEmpty()) {
            cache.f(this.f5013b.first());
        }
    }

    public void a(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        d(cache, cacheSpan);
        b(cache, cacheSpan2);
    }

    public void b(Cache cache, CacheSpan cacheSpan) {
        this.f5013b.add(cacheSpan);
        this.f5014c += cacheSpan.f4978d;
        g(cache, 0);
    }

    public void c(Cache cache, String str, long j2, long j3) {
        if (j3 != -1) {
            g(cache, j3);
        }
    }

    public void d(Cache cache, CacheSpan cacheSpan) {
        this.f5013b.remove(cacheSpan);
        this.f5014c -= cacheSpan.f4978d;
    }

    public void onCacheInitialized() {
    }

    public boolean requiresCacheSpanTouches() {
        return true;
    }
}
