package com.bumptech.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class GlideBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, TransitionOptions<?, ?>> f16112a = new ArrayMap();

    /* renamed from: b  reason: collision with root package name */
    private Engine f16113b;

    /* renamed from: c  reason: collision with root package name */
    private BitmapPool f16114c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayPool f16115d;

    /* renamed from: e  reason: collision with root package name */
    private MemoryCache f16116e;

    /* renamed from: f  reason: collision with root package name */
    private GlideExecutor f16117f;

    /* renamed from: g  reason: collision with root package name */
    private GlideExecutor f16118g;

    /* renamed from: h  reason: collision with root package name */
    private DiskCache.Factory f16119h;

    /* renamed from: i  reason: collision with root package name */
    private MemorySizeCalculator f16120i;

    /* renamed from: j  reason: collision with root package name */
    private ConnectivityMonitorFactory f16121j;

    /* renamed from: k  reason: collision with root package name */
    private int f16122k = 4;

    /* renamed from: l  reason: collision with root package name */
    private Glide.RequestOptionsFactory f16123l = new Glide.RequestOptionsFactory() {
        public RequestOptions build() {
            return new RequestOptions();
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private RequestManagerRetriever.RequestManagerFactory f16124m;

    /* renamed from: n  reason: collision with root package name */
    private GlideExecutor f16125n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f16126o;

    /* renamed from: p  reason: collision with root package name */
    private List<RequestListener<Object>> f16127p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f16128q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f16129r;

    /* access modifiers changed from: package-private */
    public Glide a(Context context) {
        Context context2 = context;
        if (this.f16117f == null) {
            this.f16117f = GlideExecutor.g();
        }
        if (this.f16118g == null) {
            this.f16118g = GlideExecutor.e();
        }
        if (this.f16125n == null) {
            this.f16125n = GlideExecutor.c();
        }
        if (this.f16120i == null) {
            this.f16120i = new MemorySizeCalculator.Builder(context2).a();
        }
        if (this.f16121j == null) {
            this.f16121j = new DefaultConnectivityMonitorFactory();
        }
        if (this.f16114c == null) {
            int b2 = this.f16120i.b();
            if (b2 > 0) {
                this.f16114c = new LruBitmapPool((long) b2);
            } else {
                this.f16114c = new BitmapPoolAdapter();
            }
        }
        if (this.f16115d == null) {
            this.f16115d = new LruArrayPool(this.f16120i.a());
        }
        if (this.f16116e == null) {
            this.f16116e = new LruResourceCache((long) this.f16120i.d());
        }
        if (this.f16119h == null) {
            this.f16119h = new InternalCacheDiskCacheFactory(context2);
        }
        if (this.f16113b == null) {
            this.f16113b = new Engine(this.f16116e, this.f16119h, this.f16118g, this.f16117f, GlideExecutor.h(), this.f16125n, this.f16126o);
        }
        List<RequestListener<Object>> list = this.f16127p;
        if (list == null) {
            this.f16127p = Collections.emptyList();
        } else {
            this.f16127p = Collections.unmodifiableList(list);
        }
        return new Glide(context, this.f16113b, this.f16116e, this.f16114c, this.f16115d, new RequestManagerRetriever(this.f16124m), this.f16121j, this.f16122k, this.f16123l, this.f16112a, this.f16127p, this.f16128q, this.f16129r);
    }

    /* access modifiers changed from: package-private */
    public void b(RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.f16124m = requestManagerFactory;
    }
}
