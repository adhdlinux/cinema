package com.bumptech.glide.load.model;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelLoaderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final MultiModelLoaderFactory f16727a;

    /* renamed from: b  reason: collision with root package name */
    private final ModelLoaderCache f16728b;

    private static class ModelLoaderCache {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, Entry<?>> f16729a = new HashMap();

        private static class Entry<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<ModelLoader<Model, ?>> f16730a;

            public Entry(List<ModelLoader<Model, ?>> list) {
                this.f16730a = list;
            }
        }

        ModelLoaderCache() {
        }

        public void a() {
            this.f16729a.clear();
        }

        public <Model> List<ModelLoader<Model, ?>> b(Class<Model> cls) {
            Entry entry = this.f16729a.get(cls);
            if (entry == null) {
                return null;
            }
            return entry.f16730a;
        }

        public <Model> void c(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (this.f16729a.put(cls, new Entry(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public ModelLoaderRegistry(Pools$Pool<List<Throwable>> pools$Pool) {
        this(new MultiModelLoaderFactory(pools$Pool));
    }

    private static <A> Class<A> b(A a2) {
        return a2.getClass();
    }

    private synchronized <A> List<ModelLoader<A, ?>> e(Class<A> cls) {
        List<ModelLoader<A, ?>> b2;
        b2 = this.f16728b.b(cls);
        if (b2 == null) {
            b2 = Collections.unmodifiableList(this.f16727a.e(cls));
            this.f16728b.c(cls, b2);
        }
        return b2;
    }

    private <Model, Data> void g(List<ModelLoaderFactory<? extends Model, ? extends Data>> list) {
        for (ModelLoaderFactory<? extends Model, ? extends Data> a2 : list) {
            a2.a();
        }
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f16727a.b(cls, cls2, modelLoaderFactory);
        this.f16728b.a();
    }

    public synchronized List<Class<?>> c(Class<?> cls) {
        return this.f16727a.g(cls);
    }

    public <A> List<ModelLoader<A, ?>> d(A a2) {
        List e2 = e(b(a2));
        if (!e2.isEmpty()) {
            int size = e2.size();
            List<ModelLoader<A, ?>> emptyList = Collections.emptyList();
            boolean z2 = true;
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader modelLoader = (ModelLoader) e2.get(i2);
                if (modelLoader.a(a2)) {
                    if (z2) {
                        emptyList = new ArrayList<>(size - i2);
                        z2 = false;
                    }
                    emptyList.add(modelLoader);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a2, e2);
        }
        throw new Registry.NoModelLoaderAvailableException(a2);
    }

    public synchronized <Model, Data> void f(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        g(this.f16727a.j(cls, cls2, modelLoaderFactory));
        this.f16728b.a();
    }

    private ModelLoaderRegistry(MultiModelLoaderFactory multiModelLoaderFactory) {
        this.f16728b = new ModelLoaderCache();
        this.f16727a = multiModelLoaderFactory;
    }
}
