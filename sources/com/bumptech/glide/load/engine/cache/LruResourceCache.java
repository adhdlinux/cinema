package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {

    /* renamed from: e  reason: collision with root package name */
    private MemoryCache.ResourceRemovedListener f16636e;

    public LruResourceCache(long j2) {
        super(j2);
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (i2 >= 40) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            m(h() / 2);
        }
    }

    public /* bridge */ /* synthetic */ Resource c(Key key, Resource resource) {
        return (Resource) super.k(key, resource);
    }

    public /* bridge */ /* synthetic */ Resource d(Key key) {
        return (Resource) super.l(key);
    }

    public void e(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f16636e = resourceRemovedListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public int i(Resource<?> resource) {
        if (resource == null) {
            return super.i(null);
        }
        return resource.getSize();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void j(Key key, Resource<?> resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.f16636e;
        if (resourceRemovedListener != null && resource != null) {
            resourceRemovedListener.a(resource);
        }
    }
}
