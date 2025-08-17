package com.vincentbrison.openlibraries.android.dualcache;

import android.content.Context;
import java.io.File;

public class Builder<T> {

    /* renamed from: a  reason: collision with root package name */
    private String f37782a;

    /* renamed from: b  reason: collision with root package name */
    private int f37783b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37784c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f37785d;

    /* renamed from: e  reason: collision with root package name */
    private DualCacheRamMode f37786e = null;

    /* renamed from: f  reason: collision with root package name */
    private CacheSerializer<T> f37787f;

    /* renamed from: g  reason: collision with root package name */
    private int f37788g;

    /* renamed from: h  reason: collision with root package name */
    private DualCacheDiskMode f37789h = null;

    /* renamed from: i  reason: collision with root package name */
    private CacheSerializer<T> f37790i;

    /* renamed from: j  reason: collision with root package name */
    private File f37791j;

    public Builder(String str, int i2) {
        this.f37782a = str;
        this.f37783b = i2;
    }

    private File c(boolean z2, Context context) {
        if (z2) {
            return context.getDir("dualcache" + this.f37782a, 0);
        }
        return new File(context.getCacheDir().getPath() + "/" + "dualcache" + "/" + this.f37782a);
    }

    public DualCache<T> a() {
        if (this.f37786e == null) {
            throw new IllegalStateException("No ram mode set");
        } else if (this.f37789h != null) {
            DualCache dualCache = new DualCache(this.f37783b, new Logger(this.f37784c), this.f37786e, this.f37787f, this.f37785d, (SizeOf) null, this.f37789h, this.f37790i, this.f37788g, this.f37791j);
            boolean equals = dualCache.e().equals(DualCacheRamMode.DISABLE);
            boolean equals2 = dualCache.d().equals(DualCacheDiskMode.DISABLE);
            if (!equals || !equals2) {
                return dualCache;
            }
            throw new IllegalStateException("The ram cache layer and the disk cache layer are disable. You have to use at least one of those layers.");
        } else {
            throw new IllegalStateException("No disk mode set");
        }
    }

    public Builder<T> b() {
        this.f37784c = true;
        return this;
    }

    public Builder<T> d() {
        this.f37786e = DualCacheRamMode.DISABLE;
        return this;
    }

    public Builder<T> e(int i2, File file, CacheSerializer<T> cacheSerializer) {
        this.f37791j = file;
        this.f37789h = DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER;
        this.f37788g = i2;
        this.f37790i = cacheSerializer;
        return this;
    }

    public Builder<T> f(int i2, boolean z2, CacheSerializer<T> cacheSerializer, Context context) {
        return e(i2, c(z2, context), cacheSerializer);
    }
}
