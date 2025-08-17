package com.bumptech.glide.load.model;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiModelLoaderFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final Factory f16740e = new Factory();

    /* renamed from: f  reason: collision with root package name */
    private static final ModelLoader<Object, Object> f16741f = new EmptyModelLoader();

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?, ?>> f16742a;

    /* renamed from: b  reason: collision with root package name */
    private final Factory f16743b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Entry<?, ?>> f16744c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools$Pool<List<Throwable>> f16745d;

    private static class EmptyModelLoader implements ModelLoader<Object, Object> {
        EmptyModelLoader() {
        }

        public boolean a(Object obj) {
            return false;
        }

        public ModelLoader.LoadData<Object> b(Object obj, int i2, int i3, Options options) {
            return null;
        }
    }

    private static class Entry<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Model> f16746a;

        /* renamed from: b  reason: collision with root package name */
        final Class<Data> f16747b;

        /* renamed from: c  reason: collision with root package name */
        final ModelLoaderFactory<? extends Model, ? extends Data> f16748c;

        public Entry(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.f16746a = cls;
            this.f16747b = cls2;
            this.f16748c = modelLoaderFactory;
        }

        public boolean a(Class<?> cls) {
            return this.f16746a.isAssignableFrom(cls);
        }

        public boolean b(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f16747b.isAssignableFrom(cls2);
        }
    }

    static class Factory {
        Factory() {
        }

        public <Model, Data> MultiModelLoader<Model, Data> a(List<ModelLoader<Model, Data>> list, Pools$Pool<List<Throwable>> pools$Pool) {
            return new MultiModelLoader<>(list, pools$Pool);
        }
    }

    public MultiModelLoaderFactory(Pools$Pool<List<Throwable>> pools$Pool) {
        this(pools$Pool, f16740e);
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z2) {
        int i2;
        Entry entry = new Entry(cls, cls2, modelLoaderFactory);
        List<Entry<?, ?>> list = this.f16742a;
        if (z2) {
            i2 = list.size();
        } else {
            i2 = 0;
        }
        list.add(i2, entry);
    }

    private <Model, Data> ModelLoader<Model, Data> c(Entry<?, ?> entry) {
        return (ModelLoader) Preconditions.d(entry.f16748c.c(this));
    }

    private static <Model, Data> ModelLoader<Model, Data> f() {
        return f16741f;
    }

    private <Model, Data> ModelLoaderFactory<Model, Data> h(Entry<?, ?> entry) {
        return entry.f16748c;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        a(cls, cls2, modelLoaderFactory, true);
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> d(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z2 = false;
            for (Entry next : this.f16742a) {
                if (this.f16744c.contains(next)) {
                    z2 = true;
                } else if (next.b(cls, cls2)) {
                    this.f16744c.add(next);
                    arrayList.add(c(next));
                    this.f16744c.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                return this.f16743b.a(arrayList, this.f16745d);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z2) {
                return f();
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.f16744c.clear();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model> List<ModelLoader<Model, ?>> e(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Entry next : this.f16742a) {
                if (!this.f16744c.contains(next)) {
                    if (next.a(cls)) {
                        this.f16744c.add(next);
                        arrayList.add(c(next));
                        this.f16744c.remove(next);
                    }
                }
            }
        } catch (Throwable th) {
            this.f16744c.clear();
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized List<Class<?>> g(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Entry next : this.f16742a) {
            if (!arrayList.contains(next.f16747b) && next.a(cls)) {
                arrayList.add(next.f16747b);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> i(Class<Model> cls, Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<Entry<?, ?>> it2 = this.f16742a.iterator();
        while (it2.hasNext()) {
            Entry next = it2.next();
            if (next.b(cls, cls2)) {
                it2.remove();
                arrayList.add(h(next));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> j(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> i2;
        i2 = i(cls, cls2);
        b(cls, cls2, modelLoaderFactory);
        return i2;
    }

    MultiModelLoaderFactory(Pools$Pool<List<Throwable>> pools$Pool, Factory factory) {
        this.f16742a = new ArrayList();
        this.f16744c = new HashSet();
        this.f16745d = pools$Pool;
        this.f16743b = factory;
    }
}
