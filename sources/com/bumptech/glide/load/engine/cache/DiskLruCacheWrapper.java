package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {

    /* renamed from: a  reason: collision with root package name */
    private final SafeKeyGenerator f16629a;

    /* renamed from: b  reason: collision with root package name */
    private final File f16630b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16631c;

    /* renamed from: d  reason: collision with root package name */
    private final DiskCacheWriteLocker f16632d = new DiskCacheWriteLocker();

    /* renamed from: e  reason: collision with root package name */
    private DiskLruCache f16633e;

    @Deprecated
    protected DiskLruCacheWrapper(File file, long j2) {
        this.f16630b = file;
        this.f16631c = j2;
        this.f16629a = new SafeKeyGenerator();
    }

    public static DiskCache c(File file, long j2) {
        return new DiskLruCacheWrapper(file, j2);
    }

    private synchronized DiskLruCache d() throws IOException {
        if (this.f16633e == null) {
            this.f16633e = DiskLruCache.q0(this.f16630b, 1, 1, this.f16631c);
        }
        return this.f16633e;
    }

    public void a(Key key, DiskCache.Writer writer) {
        DiskLruCache.Editor L;
        String b2 = this.f16629a.b(key);
        this.f16632d.a(b2);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b2 + " for for Key: " + key);
            }
            try {
                DiskLruCache d2 = d();
                if (d2.o0(b2) == null) {
                    L = d2.L(b2);
                    if (L != null) {
                        if (writer.a(L.f(0))) {
                            L.e();
                        }
                        L.b();
                        this.f16632d.b(b2);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + b2);
                }
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            } catch (Throwable th) {
                L.b();
                throw th;
            }
        } finally {
            this.f16632d.b(b2);
        }
    }

    public File b(Key key) {
        String b2 = this.f16629a.b(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b2 + " for for Key: " + key);
        }
        try {
            DiskLruCache.Value o02 = d().o0(b2);
            if (o02 != null) {
                return o02.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }
}
