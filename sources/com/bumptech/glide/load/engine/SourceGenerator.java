package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {

    /* renamed from: b  reason: collision with root package name */
    private final DecodeHelper<?> f16574b;

    /* renamed from: c  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f16575c;

    /* renamed from: d  reason: collision with root package name */
    private int f16576d;

    /* renamed from: e  reason: collision with root package name */
    private DataCacheGenerator f16577e;

    /* renamed from: f  reason: collision with root package name */
    private Object f16578f;

    /* renamed from: g  reason: collision with root package name */
    private volatile ModelLoader.LoadData<?> f16579g;

    /* renamed from: h  reason: collision with root package name */
    private DataCacheKey f16580h;

    SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f16574b = decodeHelper;
        this.f16575c = fetcherReadyCallback;
    }

    /* JADX INFO: finally extract failed */
    private void e(Object obj) {
        long b2 = LogTime.b();
        try {
            Encoder<X> p2 = this.f16574b.p(obj);
            DataCacheWriter dataCacheWriter = new DataCacheWriter(p2, obj, this.f16574b.k());
            this.f16580h = new DataCacheKey(this.f16579g.f16724a, this.f16574b.o());
            this.f16574b.d().a(this.f16580h, dataCacheWriter);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f16580h + ", data: " + obj + ", encoder: " + p2 + ", duration: " + LogTime.a(b2));
            }
            this.f16579g.f16726c.b();
            this.f16577e = new DataCacheGenerator(Collections.singletonList(this.f16579g.f16724a), this.f16574b, this);
        } catch (Throwable th) {
            this.f16579g.f16726c.b();
            throw th;
        }
    }

    private boolean f() {
        return this.f16576d < this.f16574b.g().size();
    }

    private void j(final ModelLoader.LoadData<?> loadData) {
        this.f16579g.f16726c.e(this.f16574b.l(), new DataFetcher.DataCallback<Object>() {
            public void c(Exception exc) {
                if (SourceGenerator.this.g(loadData)) {
                    SourceGenerator.this.i(loadData, exc);
                }
            }

            public void f(Object obj) {
                if (SourceGenerator.this.g(loadData)) {
                    SourceGenerator.this.h(loadData, obj);
                }
            }
        });
    }

    public void a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f16575c.a(key, exc, dataFetcher, this.f16579g.f16726c.d());
    }

    public boolean b() {
        Object obj = this.f16578f;
        if (obj != null) {
            this.f16578f = null;
            e(obj);
        }
        DataCacheGenerator dataCacheGenerator = this.f16577e;
        if (dataCacheGenerator != null && dataCacheGenerator.b()) {
            return true;
        }
        this.f16577e = null;
        this.f16579g = null;
        boolean z2 = false;
        while (!z2 && f()) {
            List<ModelLoader.LoadData<?>> g2 = this.f16574b.g();
            int i2 = this.f16576d;
            this.f16576d = i2 + 1;
            this.f16579g = g2.get(i2);
            if (this.f16579g != null && (this.f16574b.e().c(this.f16579g.f16726c.d()) || this.f16574b.t(this.f16579g.f16726c.a()))) {
                j(this.f16579g);
                z2 = true;
            }
        }
        return z2;
    }

    public void c() {
        throw new UnsupportedOperationException();
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f16579g;
        if (loadData != null) {
            loadData.f16726c.cancel();
        }
    }

    public void d(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f16575c.d(key, obj, dataFetcher, this.f16579g.f16726c.d(), key);
    }

    /* access modifiers changed from: package-private */
    public boolean g(ModelLoader.LoadData<?> loadData) {
        ModelLoader.LoadData<?> loadData2 = this.f16579g;
        return loadData2 != null && loadData2 == loadData;
    }

    /* access modifiers changed from: package-private */
    public void h(ModelLoader.LoadData<?> loadData, Object obj) {
        DiskCacheStrategy e2 = this.f16574b.e();
        if (obj == null || !e2.c(loadData.f16726c.d())) {
            DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f16575c;
            Key key = loadData.f16724a;
            DataFetcher<Data> dataFetcher = loadData.f16726c;
            fetcherReadyCallback.d(key, obj, dataFetcher, dataFetcher.d(), this.f16580h);
            return;
        }
        this.f16578f = obj;
        this.f16575c.c();
    }

    /* access modifiers changed from: package-private */
    public void i(ModelLoader.LoadData<?> loadData, Exception exc) {
        DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f16575c;
        DataCacheKey dataCacheKey = this.f16580h;
        DataFetcher<Data> dataFetcher = loadData.f16726c;
        fetcherReadyCallback.a(dataCacheKey, exc, dataFetcher, dataFetcher.d());
    }
}
