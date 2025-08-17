package com.bumptech.glide.load.model;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ModelLoader<Model, Data>> f16731a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools$Pool<List<Throwable>> f16732b;

    static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {

        /* renamed from: b  reason: collision with root package name */
        private final List<DataFetcher<Data>> f16733b;

        /* renamed from: c  reason: collision with root package name */
        private final Pools$Pool<List<Throwable>> f16734c;

        /* renamed from: d  reason: collision with root package name */
        private int f16735d = 0;

        /* renamed from: e  reason: collision with root package name */
        private Priority f16736e;

        /* renamed from: f  reason: collision with root package name */
        private DataFetcher.DataCallback<? super Data> f16737f;

        /* renamed from: g  reason: collision with root package name */
        private List<Throwable> f16738g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f16739h;

        MultiFetcher(List<DataFetcher<Data>> list, Pools$Pool<List<Throwable>> pools$Pool) {
            this.f16734c = pools$Pool;
            Preconditions.c(list);
            this.f16733b = list;
        }

        private void g() {
            if (!this.f16739h) {
                if (this.f16735d < this.f16733b.size() - 1) {
                    this.f16735d++;
                    e(this.f16736e, this.f16737f);
                    return;
                }
                Preconditions.d(this.f16738g);
                this.f16737f.c(new GlideException("Fetch failed", (List<Throwable>) new ArrayList(this.f16738g)));
            }
        }

        public Class<Data> a() {
            return this.f16733b.get(0).a();
        }

        public void b() {
            List<Throwable> list = this.f16738g;
            if (list != null) {
                this.f16734c.release(list);
            }
            this.f16738g = null;
            for (DataFetcher<Data> b2 : this.f16733b) {
                b2.b();
            }
        }

        public void c(Exception exc) {
            ((List) Preconditions.d(this.f16738g)).add(exc);
            g();
        }

        public void cancel() {
            this.f16739h = true;
            for (DataFetcher<Data> cancel : this.f16733b) {
                cancel.cancel();
            }
        }

        public DataSource d() {
            return this.f16733b.get(0).d();
        }

        public void e(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            this.f16736e = priority;
            this.f16737f = dataCallback;
            this.f16738g = this.f16734c.acquire();
            this.f16733b.get(this.f16735d).e(priority, this);
            if (this.f16739h) {
                cancel();
            }
        }

        public void f(Data data) {
            if (data != null) {
                this.f16737f.f(data);
            } else {
                g();
            }
        }
    }

    MultiModelLoader(List<ModelLoader<Model, Data>> list, Pools$Pool<List<Throwable>> pools$Pool) {
        this.f16731a = list;
        this.f16732b = pools$Pool;
    }

    public boolean a(Model model) {
        for (ModelLoader<Model, Data> a2 : this.f16731a) {
            if (a2.a(model)) {
                return true;
            }
        }
        return false;
    }

    public ModelLoader.LoadData<Data> b(Model model, int i2, int i3, Options options) {
        ModelLoader.LoadData b2;
        int size = this.f16731a.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i4 = 0; i4 < size; i4++) {
            ModelLoader modelLoader = this.f16731a.get(i4);
            if (modelLoader.a(model) && (b2 = modelLoader.b(model, i2, i3, options)) != null) {
                key = b2.f16724a;
                arrayList.add(b2.f16726c);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData<>(key, new MultiFetcher(arrayList, this.f16732b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f16731a.toArray()) + '}';
    }
}
