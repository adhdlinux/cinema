package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public interface MemoryCache {

    public interface ResourceRemovedListener {
        void a(Resource<?> resource);
    }

    void a(int i2);

    void b();

    Resource<?> c(Key key, Resource<?> resource);

    Resource<?> d(Key key);

    void e(ResourceRemovedListener resourceRemovedListener);
}
