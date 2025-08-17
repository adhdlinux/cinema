package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: b  reason: collision with root package name */
    private final List<Key> f16370b;

    /* renamed from: c  reason: collision with root package name */
    private final DecodeHelper<?> f16371c;

    /* renamed from: d  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f16372d;

    /* renamed from: e  reason: collision with root package name */
    private int f16373e;

    /* renamed from: f  reason: collision with root package name */
    private Key f16374f;

    /* renamed from: g  reason: collision with root package name */
    private List<ModelLoader<File, ?>> f16375g;

    /* renamed from: h  reason: collision with root package name */
    private int f16376h;

    /* renamed from: i  reason: collision with root package name */
    private volatile ModelLoader.LoadData<?> f16377i;

    /* renamed from: j  reason: collision with root package name */
    private File f16378j;

    DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.c(), decodeHelper, fetcherReadyCallback);
    }

    private boolean a() {
        return this.f16376h < this.f16375g.size();
    }

    public boolean b() {
        while (true) {
            boolean z2 = false;
            if (this.f16375g == null || !a()) {
                int i2 = this.f16373e + 1;
                this.f16373e = i2;
                if (i2 >= this.f16370b.size()) {
                    return false;
                }
                Key key = this.f16370b.get(this.f16373e);
                File b2 = this.f16371c.d().b(new DataCacheKey(key, this.f16371c.o()));
                this.f16378j = b2;
                if (b2 != null) {
                    this.f16374f = key;
                    this.f16375g = this.f16371c.j(b2);
                    this.f16376h = 0;
                }
            } else {
                this.f16377i = null;
                while (!z2 && a()) {
                    List<ModelLoader<File, ?>> list = this.f16375g;
                    int i3 = this.f16376h;
                    this.f16376h = i3 + 1;
                    this.f16377i = list.get(i3).b(this.f16378j, this.f16371c.s(), this.f16371c.f(), this.f16371c.k());
                    if (this.f16377i != null && this.f16371c.t(this.f16377i.f16726c.a())) {
                        this.f16377i.f16726c.e(this.f16371c.l(), this);
                        z2 = true;
                    }
                }
                return z2;
            }
        }
    }

    public void c(Exception exc) {
        this.f16372d.a(this.f16374f, exc, this.f16377i.f16726c, DataSource.DATA_DISK_CACHE);
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f16377i;
        if (loadData != null) {
            loadData.f16726c.cancel();
        }
    }

    public void f(Object obj) {
        this.f16372d.d(this.f16374f, obj, this.f16377i.f16726c, DataSource.DATA_DISK_CACHE, this.f16374f);
    }

    DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f16373e = -1;
        this.f16370b = list;
        this.f16371c = decodeHelper;
        this.f16372d = fetcherReadyCallback;
    }
}
