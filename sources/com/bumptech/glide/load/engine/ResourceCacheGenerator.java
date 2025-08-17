package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: b  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f16553b;

    /* renamed from: c  reason: collision with root package name */
    private final DecodeHelper<?> f16554c;

    /* renamed from: d  reason: collision with root package name */
    private int f16555d;

    /* renamed from: e  reason: collision with root package name */
    private int f16556e = -1;

    /* renamed from: f  reason: collision with root package name */
    private Key f16557f;

    /* renamed from: g  reason: collision with root package name */
    private List<ModelLoader<File, ?>> f16558g;

    /* renamed from: h  reason: collision with root package name */
    private int f16559h;

    /* renamed from: i  reason: collision with root package name */
    private volatile ModelLoader.LoadData<?> f16560i;

    /* renamed from: j  reason: collision with root package name */
    private File f16561j;

    /* renamed from: k  reason: collision with root package name */
    private ResourceCacheKey f16562k;

    ResourceCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f16554c = decodeHelper;
        this.f16553b = fetcherReadyCallback;
    }

    private boolean a() {
        return this.f16559h < this.f16558g.size();
    }

    public boolean b() {
        List<Key> c2 = this.f16554c.c();
        boolean z2 = false;
        if (c2.isEmpty()) {
            return false;
        }
        List<Class<?>> m2 = this.f16554c.m();
        if (m2.isEmpty()) {
            if (File.class.equals(this.f16554c.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f16554c.i() + " to " + this.f16554c.q());
        }
        while (true) {
            if (this.f16558g == null || !a()) {
                int i2 = this.f16556e + 1;
                this.f16556e = i2;
                if (i2 >= m2.size()) {
                    int i3 = this.f16555d + 1;
                    this.f16555d = i3;
                    if (i3 >= c2.size()) {
                        return false;
                    }
                    this.f16556e = 0;
                }
                Key key = c2.get(this.f16555d);
                Class cls = m2.get(this.f16556e);
                Key key2 = key;
                this.f16562k = new ResourceCacheKey(this.f16554c.b(), key2, this.f16554c.o(), this.f16554c.s(), this.f16554c.f(), this.f16554c.r(cls), cls, this.f16554c.k());
                File b2 = this.f16554c.d().b(this.f16562k);
                this.f16561j = b2;
                if (b2 != null) {
                    this.f16557f = key;
                    this.f16558g = this.f16554c.j(b2);
                    this.f16559h = 0;
                }
            } else {
                this.f16560i = null;
                while (!z2 && a()) {
                    List<ModelLoader<File, ?>> list = this.f16558g;
                    int i4 = this.f16559h;
                    this.f16559h = i4 + 1;
                    this.f16560i = list.get(i4).b(this.f16561j, this.f16554c.s(), this.f16554c.f(), this.f16554c.k());
                    if (this.f16560i != null && this.f16554c.t(this.f16560i.f16726c.a())) {
                        this.f16560i.f16726c.e(this.f16554c.l(), this);
                        z2 = true;
                    }
                }
                return z2;
            }
        }
    }

    public void c(Exception exc) {
        this.f16553b.a(this.f16562k, exc, this.f16560i.f16726c, DataSource.RESOURCE_DISK_CACHE);
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f16560i;
        if (loadData != null) {
            loadData.f16726c.cancel();
        }
    }

    public void f(Object obj) {
        this.f16553b.d(this.f16557f, obj, this.f16560i.f16726c, DataSource.RESOURCE_DISK_CACHE, this.f16562k);
    }
}
