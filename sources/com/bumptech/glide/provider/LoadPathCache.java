package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LoadPathCache {

    /* renamed from: c  reason: collision with root package name */
    private static final LoadPath<?, ?, ?> f17010c = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), (Pools$Pool<List<Throwable>>) null)), (Pools$Pool<List<Throwable>>) null);

    /* renamed from: a  reason: collision with root package name */
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> f17011a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<MultiClassKey> f17012b = new AtomicReference<>();

    private MultiClassKey b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        MultiClassKey andSet = this.f17012b.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new MultiClassKey();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath;
        MultiClassKey b2 = b(cls, cls2, cls3);
        synchronized (this.f17011a) {
            loadPath = this.f17011a.get(b2);
        }
        this.f17012b.set(b2);
        return loadPath;
    }

    public boolean c(LoadPath<?, ?, ?> loadPath) {
        return f17010c.equals(loadPath);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, LoadPath<?, ?, ?> loadPath) {
        synchronized (this.f17011a) {
            ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = this.f17011a;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = f17010c;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }
}
