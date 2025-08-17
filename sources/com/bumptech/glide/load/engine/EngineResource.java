package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

class EngineResource<Z> implements Resource<Z> {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f16526b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16527c;

    /* renamed from: d  reason: collision with root package name */
    private final Resource<Z> f16528d;

    /* renamed from: e  reason: collision with root package name */
    private final ResourceListener f16529e;

    /* renamed from: f  reason: collision with root package name */
    private final Key f16530f;

    /* renamed from: g  reason: collision with root package name */
    private int f16531g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f16532h;

    interface ResourceListener {
        void d(Key key, EngineResource<?> engineResource);
    }

    EngineResource(Resource<Z> resource, boolean z2, boolean z3, Key key, ResourceListener resourceListener) {
        this.f16528d = (Resource) Preconditions.d(resource);
        this.f16526b = z2;
        this.f16527c = z3;
        this.f16530f = key;
        this.f16529e = (ResourceListener) Preconditions.d(resourceListener);
    }

    public Class<Z> a() {
        return this.f16528d.a();
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        if (!this.f16532h) {
            this.f16531g++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* access modifiers changed from: package-private */
    public Resource<Z> c() {
        return this.f16528d;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f16526b;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        boolean z2;
        synchronized (this) {
            int i2 = this.f16531g;
            if (i2 > 0) {
                z2 = true;
                int i3 = i2 - 1;
                this.f16531g = i3;
                if (i3 != 0) {
                    z2 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z2) {
            this.f16529e.d(this.f16530f, this);
        }
    }

    public Z get() {
        return this.f16528d.get();
    }

    public int getSize() {
        return this.f16528d.getSize();
    }

    public synchronized void recycle() {
        if (this.f16531g > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f16532h) {
            this.f16532h = true;
            if (this.f16527c) {
                this.f16528d.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f16526b + ", listener=" + this.f16529e + ", key=" + this.f16530f + ", acquired=" + this.f16531g + ", isRecycled=" + this.f16532h + ", resource=" + this.f16528d + '}';
    }
}
