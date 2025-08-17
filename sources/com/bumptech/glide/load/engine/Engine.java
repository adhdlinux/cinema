package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f16459i = Log.isLoggable("Engine", 2);

    /* renamed from: a  reason: collision with root package name */
    private final Jobs f16460a;

    /* renamed from: b  reason: collision with root package name */
    private final EngineKeyFactory f16461b;

    /* renamed from: c  reason: collision with root package name */
    private final MemoryCache f16462c;

    /* renamed from: d  reason: collision with root package name */
    private final EngineJobFactory f16463d;

    /* renamed from: e  reason: collision with root package name */
    private final ResourceRecycler f16464e;

    /* renamed from: f  reason: collision with root package name */
    private final LazyDiskCacheProvider f16465f;

    /* renamed from: g  reason: collision with root package name */
    private final DecodeJobFactory f16466g;

    /* renamed from: h  reason: collision with root package name */
    private final ActiveResources f16467h;

    static class DecodeJobFactory {

        /* renamed from: a  reason: collision with root package name */
        final DecodeJob.DiskCacheProvider f16468a;

        /* renamed from: b  reason: collision with root package name */
        final Pools$Pool<DecodeJob<?>> f16469b = FactoryPools.d(150, new FactoryPools.Factory<DecodeJob<?>>() {
            /* renamed from: a */
            public DecodeJob<?> create() {
                DecodeJobFactory decodeJobFactory = DecodeJobFactory.this;
                return new DecodeJob<>(decodeJobFactory.f16468a, decodeJobFactory.f16469b);
            }
        });

        /* renamed from: c  reason: collision with root package name */
        private int f16470c;

        DecodeJobFactory(DecodeJob.DiskCacheProvider diskCacheProvider) {
            this.f16468a = diskCacheProvider;
        }

        /* access modifiers changed from: package-private */
        public <R> DecodeJob<R> a(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z2, boolean z3, boolean z4, Options options, DecodeJob.Callback<R> callback) {
            DecodeJob decodeJob = (DecodeJob) Preconditions.d(this.f16469b.acquire());
            int i4 = this.f16470c;
            int i5 = i4;
            this.f16470c = i4 + 1;
            return decodeJob.n(glideContext, obj, engineKey, key, i2, i3, cls, cls2, priority, diskCacheStrategy, map, z2, z3, z4, options, callback, i5);
        }
    }

    static class EngineJobFactory {

        /* renamed from: a  reason: collision with root package name */
        final GlideExecutor f16472a;

        /* renamed from: b  reason: collision with root package name */
        final GlideExecutor f16473b;

        /* renamed from: c  reason: collision with root package name */
        final GlideExecutor f16474c;

        /* renamed from: d  reason: collision with root package name */
        final GlideExecutor f16475d;

        /* renamed from: e  reason: collision with root package name */
        final EngineJobListener f16476e;

        /* renamed from: f  reason: collision with root package name */
        final EngineResource.ResourceListener f16477f;

        /* renamed from: g  reason: collision with root package name */
        final Pools$Pool<EngineJob<?>> f16478g = FactoryPools.d(150, new FactoryPools.Factory<EngineJob<?>>() {
            /* renamed from: a */
            public EngineJob<?> create() {
                EngineJobFactory engineJobFactory = EngineJobFactory.this;
                return new EngineJob(engineJobFactory.f16472a, engineJobFactory.f16473b, engineJobFactory.f16474c, engineJobFactory.f16475d, engineJobFactory.f16476e, engineJobFactory.f16477f, engineJobFactory.f16478g);
            }
        });

        EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener) {
            this.f16472a = glideExecutor;
            this.f16473b = glideExecutor2;
            this.f16474c = glideExecutor3;
            this.f16475d = glideExecutor4;
            this.f16476e = engineJobListener;
            this.f16477f = resourceListener;
        }

        /* access modifiers changed from: package-private */
        public <R> EngineJob<R> a(Key key, boolean z2, boolean z3, boolean z4, boolean z5) {
            return ((EngineJob) Preconditions.d(this.f16478g.acquire())).j(key, z2, z3, z4, z5);
        }
    }

    private static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {

        /* renamed from: a  reason: collision with root package name */
        private final DiskCache.Factory f16480a;

        /* renamed from: b  reason: collision with root package name */
        private volatile DiskCache f16481b;

        LazyDiskCacheProvider(DiskCache.Factory factory) {
            this.f16480a = factory;
        }

        public DiskCache a() {
            if (this.f16481b == null) {
                synchronized (this) {
                    if (this.f16481b == null) {
                        this.f16481b = this.f16480a.build();
                    }
                    if (this.f16481b == null) {
                        this.f16481b = new DiskCacheAdapter();
                    }
                }
            }
            return this.f16481b;
        }
    }

    public class LoadStatus {

        /* renamed from: a  reason: collision with root package name */
        private final EngineJob<?> f16482a;

        /* renamed from: b  reason: collision with root package name */
        private final ResourceCallback f16483b;

        LoadStatus(ResourceCallback resourceCallback, EngineJob<?> engineJob) {
            this.f16483b = resourceCallback;
            this.f16482a = engineJob;
        }

        public void a() {
            synchronized (Engine.this) {
                this.f16482a.p(this.f16483b);
            }
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z2) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, (Jobs) null, (EngineKeyFactory) null, (ActiveResources) null, (EngineJobFactory) null, (DecodeJobFactory) null, (ResourceRecycler) null, z2);
    }

    private EngineResource<?> e(Key key) {
        Resource<?> d2 = this.f16462c.d(key);
        if (d2 == null) {
            return null;
        }
        if (d2 instanceof EngineResource) {
            return (EngineResource) d2;
        }
        return new EngineResource<>(d2, true, true, key, this);
    }

    private EngineResource<?> g(Key key) {
        EngineResource<?> e2 = this.f16467h.e(key);
        if (e2 != null) {
            e2.b();
        }
        return e2;
    }

    private EngineResource<?> h(Key key) {
        EngineResource<?> e2 = e(key);
        if (e2 != null) {
            e2.b();
            this.f16467h.a(key, e2);
        }
        return e2;
    }

    private EngineResource<?> i(EngineKey engineKey, boolean z2, long j2) {
        if (!z2) {
            return null;
        }
        EngineResource<?> g2 = g(engineKey);
        if (g2 != null) {
            if (f16459i) {
                j("Loaded resource from active resources", j2, engineKey);
            }
            return g2;
        }
        EngineResource<?> h2 = h(engineKey);
        if (h2 == null) {
            return null;
        }
        if (f16459i) {
            j("Loaded resource from cache", j2, engineKey);
        }
        return h2;
    }

    private static void j(String str, long j2, Key key) {
        Log.v("Engine", str + " in " + LogTime.a(j2) + "ms, key: " + key);
    }

    private <R> LoadStatus l(GlideContext glideContext, Object obj, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z2, boolean z3, Options options, boolean z4, boolean z5, boolean z6, boolean z7, ResourceCallback resourceCallback, Executor executor, EngineKey engineKey, long j2) {
        ResourceCallback resourceCallback2 = resourceCallback;
        Executor executor2 = executor;
        EngineKey engineKey2 = engineKey;
        long j3 = j2;
        EngineJob<?> a2 = this.f16460a.a(engineKey2, z7);
        if (a2 != null) {
            a2.c(resourceCallback2, executor2);
            if (f16459i) {
                j("Added to existing load", j3, engineKey2);
            }
            return new LoadStatus(resourceCallback2, a2);
        }
        EngineJob a3 = this.f16463d.a(engineKey, z4, z5, z6, z7);
        EngineJob engineJob = a3;
        EngineKey engineKey3 = engineKey2;
        DecodeJob<R> a4 = this.f16466g.a(glideContext, obj, engineKey, key, i2, i3, cls, cls2, priority, diskCacheStrategy, map, z2, z3, z7, options, a3);
        this.f16460a.c(engineKey3, engineJob);
        EngineJob engineJob2 = engineJob;
        EngineKey engineKey4 = engineKey3;
        ResourceCallback resourceCallback3 = resourceCallback;
        engineJob2.c(resourceCallback3, executor);
        engineJob2.q(a4);
        if (f16459i) {
            j("Started new load", j2, engineKey4);
        }
        return new LoadStatus(resourceCallback3, engineJob2);
    }

    public void a(Resource<?> resource) {
        this.f16464e.a(resource, true);
    }

    public synchronized void b(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource) {
        if (engineResource != null) {
            if (engineResource.d()) {
                this.f16467h.a(key, engineResource);
            }
        }
        this.f16460a.d(key, engineJob);
    }

    public synchronized void c(EngineJob<?> engineJob, Key key) {
        this.f16460a.d(key, engineJob);
    }

    public void d(Key key, EngineResource<?> engineResource) {
        this.f16467h.d(key);
        if (engineResource.d()) {
            this.f16462c.c(key, engineResource);
        } else {
            this.f16464e.a(engineResource, false);
        }
    }

    public <R> LoadStatus f(GlideContext glideContext, Object obj, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z2, boolean z3, Options options, boolean z4, boolean z5, boolean z6, boolean z7, ResourceCallback resourceCallback, Executor executor) {
        long b2 = f16459i ? LogTime.b() : 0;
        EngineKey a2 = this.f16461b.a(obj, key, i2, i3, map, cls, cls2, options);
        synchronized (this) {
            EngineResource<?> i4 = i(a2, z4, b2);
            if (i4 == null) {
                LoadStatus l2 = l(glideContext, obj, key, i2, i3, cls, cls2, priority, diskCacheStrategy, map, z2, z3, options, z4, z5, z6, z7, resourceCallback, executor, a2, b2);
                return l2;
            }
            resourceCallback.onResourceReady(i4, DataSource.MEMORY_CACHE);
            return null;
        }
    }

    public void k(Resource<?> resource) {
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).e();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Jobs jobs, EngineKeyFactory engineKeyFactory, ActiveResources activeResources, EngineJobFactory engineJobFactory, DecodeJobFactory decodeJobFactory, ResourceRecycler resourceRecycler, boolean z2) {
        this.f16462c = memoryCache;
        DiskCache.Factory factory2 = factory;
        LazyDiskCacheProvider lazyDiskCacheProvider = new LazyDiskCacheProvider(factory);
        this.f16465f = lazyDiskCacheProvider;
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z2) : activeResources;
        this.f16467h = activeResources2;
        activeResources2.f(this);
        this.f16461b = engineKeyFactory == null ? new EngineKeyFactory() : engineKeyFactory;
        this.f16460a = jobs == null ? new Jobs() : jobs;
        this.f16463d = engineJobFactory == null ? new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this) : engineJobFactory;
        this.f16466g = decodeJobFactory == null ? new DecodeJobFactory(lazyDiskCacheProvider) : decodeJobFactory;
        this.f16464e = resourceRecycler == null ? new ResourceRecycler() : resourceRecycler;
        memoryCache.e(this);
    }
}
