package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final UnitModelLoader<?> f16757a = new UnitModelLoader<>();

    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final Factory<?> f16758a = new Factory<>();

        public static <T> Factory<T> b() {
            return f16758a;
        }

        public void a() {
        }

        public ModelLoader<Model, Model> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.c();
        }
    }

    private static class UnitFetcher<Model> implements DataFetcher<Model> {

        /* renamed from: b  reason: collision with root package name */
        private final Model f16759b;

        UnitFetcher(Model model) {
            this.f16759b = model;
        }

        public Class<Model> a() {
            return this.f16759b.getClass();
        }

        public void b() {
        }

        public void cancel() {
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(Priority priority, DataFetcher.DataCallback<? super Model> dataCallback) {
            dataCallback.f(this.f16759b);
        }
    }

    public static <T> UnitModelLoader<T> c() {
        return f16757a;
    }

    public boolean a(Model model) {
        return true;
    }

    public ModelLoader.LoadData<Model> b(Model model, int i2, int i3, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new UnitFetcher(model));
    }
}
