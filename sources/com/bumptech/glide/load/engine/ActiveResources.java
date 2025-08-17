package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class ActiveResources {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f16358a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f16359b;

    /* renamed from: c  reason: collision with root package name */
    final Map<Key, ResourceWeakReference> f16360c;

    /* renamed from: d  reason: collision with root package name */
    private final ReferenceQueue<EngineResource<?>> f16361d;

    /* renamed from: e  reason: collision with root package name */
    private EngineResource.ResourceListener f16362e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f16363f;

    static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {

        /* renamed from: a  reason: collision with root package name */
        final Key f16367a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f16368b;

        /* renamed from: c  reason: collision with root package name */
        Resource<?> f16369c;

        ResourceWeakReference(Key key, EngineResource<?> engineResource, ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z2) {
            super(engineResource, referenceQueue);
            Resource<?> resource;
            this.f16367a = (Key) Preconditions.d(key);
            if (!engineResource.d() || !z2) {
                resource = null;
            } else {
                resource = (Resource) Preconditions.d(engineResource.c());
            }
            this.f16369c = resource;
            this.f16368b = engineResource.d();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f16369c = null;
            clear();
        }
    }

    ActiveResources(boolean z2) {
        this(z2, Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() {
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(Key key, EngineResource<?> engineResource) {
        ResourceWeakReference put = this.f16360c.put(key, new ResourceWeakReference(key, engineResource, this.f16361d, this.f16358a));
        if (put != null) {
            put.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        while (!this.f16363f) {
            try {
                c((ResourceWeakReference) this.f16361d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(ResourceWeakReference resourceWeakReference) {
        synchronized (this) {
            this.f16360c.remove(resourceWeakReference.f16367a);
            if (resourceWeakReference.f16368b) {
                Resource<?> resource = resourceWeakReference.f16369c;
                if (resource != null) {
                    this.f16362e.d(resourceWeakReference.f16367a, new EngineResource(resource, true, false, resourceWeakReference.f16367a, this.f16362e));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void d(Key key) {
        ResourceWeakReference remove = this.f16360c.remove(key);
        if (remove != null) {
            remove.a();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bumptech.glide.load.engine.EngineResource<?> e(com.bumptech.glide.load.Key r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<com.bumptech.glide.load.Key, com.bumptech.glide.load.engine.ActiveResources$ResourceWeakReference> r0 = r1.f16360c     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.ActiveResources$ResourceWeakReference r2 = (com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference) r2     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x000e
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x000e:
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.EngineResource r0 = (com.bumptech.glide.load.engine.EngineResource) r0     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.c(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return r0
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.ActiveResources.e(com.bumptech.glide.load.Key):com.bumptech.glide.load.engine.EngineResource");
    }

    /* access modifiers changed from: package-private */
    public void f(EngineResource.ResourceListener resourceListener) {
        synchronized (resourceListener) {
            synchronized (this) {
                this.f16362e = resourceListener;
            }
        }
    }

    ActiveResources(boolean z2, Executor executor) {
        this.f16360c = new HashMap();
        this.f16361d = new ReferenceQueue<>();
        this.f16358a = z2;
        this.f16359b = executor;
        executor.execute(new Runnable() {
            public void run() {
                ActiveResources.this.b();
            }
        });
    }
}
