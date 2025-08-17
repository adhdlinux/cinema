package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

public interface ModelLoader<Model, Data> {

    public static class LoadData<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final Key f16724a;

        /* renamed from: b  reason: collision with root package name */
        public final List<Key> f16725b;

        /* renamed from: c  reason: collision with root package name */
        public final DataFetcher<Data> f16726c;

        public LoadData(Key key, DataFetcher<Data> dataFetcher) {
            this(key, Collections.emptyList(), dataFetcher);
        }

        public LoadData(Key key, List<Key> list, DataFetcher<Data> dataFetcher) {
            this.f16724a = (Key) Preconditions.d(key);
            this.f16725b = (List) Preconditions.d(list);
            this.f16726c = (DataFetcher) Preconditions.d(dataFetcher);
        }
    }

    boolean a(Model model);

    LoadData<Data> b(Model model, int i2, int i3, Options options);
}
