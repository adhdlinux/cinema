package com.bumptech.glide.load.engine;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {

    /* renamed from: f  reason: collision with root package name */
    private static final Pools$Pool<LockedResource<?>> f16548f = FactoryPools.d(20, new FactoryPools.Factory<LockedResource<?>>() {
        /* renamed from: a */
        public LockedResource<?> create() {
            return new LockedResource<>();
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private final StateVerifier f16549b = StateVerifier.a();

    /* renamed from: c  reason: collision with root package name */
    private Resource<Z> f16550c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16551d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16552e;

    LockedResource() {
    }

    private void c(Resource<Z> resource) {
        this.f16552e = false;
        this.f16551d = true;
        this.f16550c = resource;
    }

    static <Z> LockedResource<Z> d(Resource<Z> resource) {
        LockedResource<Z> lockedResource = (LockedResource) Preconditions.d(f16548f.acquire());
        lockedResource.c(resource);
        return lockedResource;
    }

    private void e() {
        this.f16550c = null;
        f16548f.release(this);
    }

    public Class<Z> a() {
        return this.f16550c.a();
    }

    public StateVerifier b() {
        return this.f16549b;
    }

    /* access modifiers changed from: package-private */
    public synchronized void f() {
        this.f16549b.c();
        if (this.f16551d) {
            this.f16551d = false;
            if (this.f16552e) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public Z get() {
        return this.f16550c.get();
    }

    public int getSize() {
        return this.f16550c.getSize();
    }

    public synchronized void recycle() {
        this.f16549b.c();
        this.f16552e = true;
        if (!this.f16551d) {
            this.f16550c.recycle();
            e();
        }
    }
}
