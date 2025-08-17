package com.bumptech.glide.load.engine;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {

    /* renamed from: z  reason: collision with root package name */
    private static final EngineResourceFactory f16485z = new EngineResourceFactory();

    /* renamed from: b  reason: collision with root package name */
    final ResourceCallbacksAndExecutors f16486b;

    /* renamed from: c  reason: collision with root package name */
    private final StateVerifier f16487c;

    /* renamed from: d  reason: collision with root package name */
    private final EngineResource.ResourceListener f16488d;

    /* renamed from: e  reason: collision with root package name */
    private final Pools$Pool<EngineJob<?>> f16489e;

    /* renamed from: f  reason: collision with root package name */
    private final EngineResourceFactory f16490f;

    /* renamed from: g  reason: collision with root package name */
    private final EngineJobListener f16491g;

    /* renamed from: h  reason: collision with root package name */
    private final GlideExecutor f16492h;

    /* renamed from: i  reason: collision with root package name */
    private final GlideExecutor f16493i;

    /* renamed from: j  reason: collision with root package name */
    private final GlideExecutor f16494j;

    /* renamed from: k  reason: collision with root package name */
    private final GlideExecutor f16495k;

    /* renamed from: l  reason: collision with root package name */
    private final AtomicInteger f16496l;

    /* renamed from: m  reason: collision with root package name */
    private Key f16497m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f16498n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f16499o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f16500p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f16501q;

    /* renamed from: r  reason: collision with root package name */
    private Resource<?> f16502r;

    /* renamed from: s  reason: collision with root package name */
    DataSource f16503s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f16504t;

    /* renamed from: u  reason: collision with root package name */
    GlideException f16505u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f16506v;

    /* renamed from: w  reason: collision with root package name */
    EngineResource<?> f16507w;

    /* renamed from: x  reason: collision with root package name */
    private DecodeJob<R> f16508x;

    /* renamed from: y  reason: collision with root package name */
    private volatile boolean f16509y;

    private class CallLoadFailed implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final ResourceCallback f16510b;

        CallLoadFailed(ResourceCallback resourceCallback) {
            this.f16510b = resourceCallback;
        }

        public void run() {
            synchronized (this.f16510b.getLock()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.f16486b.b(this.f16510b)) {
                        EngineJob.this.d(this.f16510b);
                    }
                    EngineJob.this.g();
                }
            }
        }
    }

    private class CallResourceReady implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final ResourceCallback f16512b;

        CallResourceReady(ResourceCallback resourceCallback) {
            this.f16512b = resourceCallback;
        }

        public void run() {
            synchronized (this.f16512b.getLock()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.f16486b.b(this.f16512b)) {
                        EngineJob.this.f16507w.b();
                        EngineJob.this.e(this.f16512b);
                        EngineJob.this.p(this.f16512b);
                    }
                    EngineJob.this.g();
                }
            }
        }
    }

    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public <R> EngineResource<R> a(Resource<R> resource, boolean z2, Key key, EngineResource.ResourceListener resourceListener) {
            return new EngineResource(resource, z2, true, key, resourceListener);
        }
    }

    static final class ResourceCallbackAndExecutor {

        /* renamed from: a  reason: collision with root package name */
        final ResourceCallback f16514a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f16515b;

        ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor) {
            this.f16514a = resourceCallback;
            this.f16515b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.f16514a.equals(((ResourceCallbackAndExecutor) obj).f16514a);
            }
            return false;
        }

        public int hashCode() {
            return this.f16514a.hashCode();
        }
    }

    static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {

        /* renamed from: b  reason: collision with root package name */
        private final List<ResourceCallbackAndExecutor> f16516b;

        ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        private static ResourceCallbackAndExecutor d(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.a());
        }

        /* access modifiers changed from: package-private */
        public void a(ResourceCallback resourceCallback, Executor executor) {
            this.f16516b.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        /* access modifiers changed from: package-private */
        public boolean b(ResourceCallback resourceCallback) {
            return this.f16516b.contains(d(resourceCallback));
        }

        /* access modifiers changed from: package-private */
        public ResourceCallbacksAndExecutors c() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.f16516b));
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.f16516b.clear();
        }

        /* access modifiers changed from: package-private */
        public void e(ResourceCallback resourceCallback) {
            this.f16516b.remove(d(resourceCallback));
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.f16516b.isEmpty();
        }

        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.f16516b.iterator();
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this.f16516b.size();
        }

        ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> list) {
            this.f16516b = list;
        }
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools$Pool<EngineJob<?>> pools$Pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pools$Pool, f16485z);
    }

    private GlideExecutor h() {
        if (this.f16499o) {
            return this.f16494j;
        }
        if (this.f16500p) {
            return this.f16495k;
        }
        return this.f16493i;
    }

    private boolean k() {
        return this.f16506v || this.f16504t || this.f16509y;
    }

    private synchronized void o() {
        if (this.f16497m != null) {
            this.f16486b.clear();
            this.f16497m = null;
            this.f16507w = null;
            this.f16502r = null;
            this.f16506v = false;
            this.f16509y = false;
            this.f16504t = false;
            this.f16508x.w(false);
            this.f16508x = null;
            this.f16505u = null;
            this.f16503s = null;
            this.f16489e.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void a(DecodeJob<?> decodeJob) {
        h().execute(decodeJob);
    }

    public StateVerifier b() {
        return this.f16487c;
    }

    /* access modifiers changed from: package-private */
    public synchronized void c(ResourceCallback resourceCallback, Executor executor) {
        this.f16487c.c();
        this.f16486b.a(resourceCallback, executor);
        boolean z2 = true;
        if (this.f16504t) {
            i(1);
            executor.execute(new CallResourceReady(resourceCallback));
        } else if (this.f16506v) {
            i(1);
            executor.execute(new CallLoadFailed(resourceCallback));
        } else {
            if (this.f16509y) {
                z2 = false;
            }
            Preconditions.a(z2, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* access modifiers changed from: package-private */
    public void d(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onLoadFailed(this.f16505u);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onResourceReady(this.f16507w, this.f16503s);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (!k()) {
            this.f16509y = true;
            this.f16508x.e();
            this.f16491g.c(this, this.f16497m);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        boolean z2;
        EngineResource<?> engineResource;
        synchronized (this) {
            this.f16487c.c();
            Preconditions.a(k(), "Not yet complete!");
            int decrementAndGet = this.f16496l.decrementAndGet();
            if (decrementAndGet >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.a(z2, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                engineResource = this.f16507w;
                o();
            } else {
                engineResource = null;
            }
        }
        if (engineResource != null) {
            engineResource.e();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void i(int i2) {
        EngineResource<?> engineResource;
        Preconditions.a(k(), "Not yet complete!");
        if (this.f16496l.getAndAdd(i2) == 0 && (engineResource = this.f16507w) != null) {
            engineResource.b();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized EngineJob<R> j(Key key, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f16497m = key;
        this.f16498n = z2;
        this.f16499o = z3;
        this.f16500p = z4;
        this.f16501q = z5;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r4.f16491g.b(r4, r1, (com.bumptech.glide.load.engine.EngineResource<?>) null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r0.hasNext() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = r0.next();
        r1.f16515b.execute(new com.bumptech.glide.load.engine.EngineJob.CallLoadFailed(r4, r1.f16514a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bumptech.glide.util.pool.StateVerifier r0 = r4.f16487c     // Catch:{ all -> 0x0066 }
            r0.c()     // Catch:{ all -> 0x0066 }
            boolean r0 = r4.f16509y     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x000f
            r4.o()     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            return
        L_0x000f:
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r0 = r4.f16486b     // Catch:{ all -> 0x0066 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x005e
            boolean r0 = r4.f16506v     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x0056
            r0 = 1
            r4.f16506v = r0     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.Key r1 = r4.f16497m     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r2 = r4.f16486b     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r2 = r2.c()     // Catch:{ all -> 0x0066 }
            int r3 = r2.size()     // Catch:{ all -> 0x0066 }
            int r3 = r3 + r0
            r4.i(r3)     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.EngineJobListener r0 = r4.f16491g
            r3 = 0
            r0.b(r4, r1, r3)
            java.util.Iterator r0 = r2.iterator()
        L_0x0039:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r1
            java.util.concurrent.Executor r2 = r1.f16515b
            com.bumptech.glide.load.engine.EngineJob$CallLoadFailed r3 = new com.bumptech.glide.load.engine.EngineJob$CallLoadFailed
            com.bumptech.glide.request.ResourceCallback r1 = r1.f16514a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0039
        L_0x0052:
            r4.g()
            return
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x005e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.l():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r5.f16491g.b(r5, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r0.hasNext() == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r1 = r0.next();
        r1.f16515b.execute(new com.bumptech.glide.load.engine.EngineJob.CallResourceReady(r5, r1.f16514a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.bumptech.glide.util.pool.StateVerifier r0 = r5.f16487c     // Catch:{ all -> 0x007c }
            r0.c()     // Catch:{ all -> 0x007c }
            boolean r0 = r5.f16509y     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0014
            com.bumptech.glide.load.engine.Resource<?> r0 = r5.f16502r     // Catch:{ all -> 0x007c }
            r0.recycle()     // Catch:{ all -> 0x007c }
            r5.o()     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            return
        L_0x0014:
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r0 = r5.f16486b     // Catch:{ all -> 0x007c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x0074
            boolean r0 = r5.f16504t     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x006c
            com.bumptech.glide.load.engine.EngineJob$EngineResourceFactory r0 = r5.f16490f     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.Resource<?> r1 = r5.f16502r     // Catch:{ all -> 0x007c }
            boolean r2 = r5.f16498n     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.Key r3 = r5.f16497m     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.EngineResource$ResourceListener r4 = r5.f16488d     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.EngineResource r0 = r0.a(r1, r2, r3, r4)     // Catch:{ all -> 0x007c }
            r5.f16507w = r0     // Catch:{ all -> 0x007c }
            r0 = 1
            r5.f16504t = r0     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r1 = r5.f16486b     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r1 = r1.c()     // Catch:{ all -> 0x007c }
            int r2 = r1.size()     // Catch:{ all -> 0x007c }
            int r2 = r2 + r0
            r5.i(r2)     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.Key r0 = r5.f16497m     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.EngineResource<?> r2 = r5.f16507w     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.EngineJobListener r3 = r5.f16491g
            r3.b(r5, r0, r2)
            java.util.Iterator r0 = r1.iterator()
        L_0x004f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r1
            java.util.concurrent.Executor r2 = r1.f16515b
            com.bumptech.glide.load.engine.EngineJob$CallResourceReady r3 = new com.bumptech.glide.load.engine.EngineJob$CallResourceReady
            com.bumptech.glide.request.ResourceCallback r1 = r1.f16514a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x004f
        L_0x0068:
            r5.g()
            return
        L_0x006c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x0074:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x007c:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.m():void");
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.f16501q;
    }

    public void onLoadFailed(GlideException glideException) {
        synchronized (this) {
            this.f16505u = glideException;
        }
        l();
    }

    public void onResourceReady(Resource<R> resource, DataSource dataSource) {
        synchronized (this) {
            this.f16502r = resource;
            this.f16503s = dataSource;
        }
        m();
    }

    /* access modifiers changed from: package-private */
    public synchronized void p(ResourceCallback resourceCallback) {
        boolean z2;
        this.f16487c.c();
        this.f16486b.e(resourceCallback);
        if (this.f16486b.isEmpty()) {
            f();
            if (!this.f16504t) {
                if (!this.f16506v) {
                    z2 = false;
                    if (z2 && this.f16496l.get() == 0) {
                        o();
                    }
                }
            }
            z2 = true;
            o();
        }
    }

    public synchronized void q(DecodeJob<R> decodeJob) {
        GlideExecutor glideExecutor;
        this.f16508x = decodeJob;
        if (decodeJob.C()) {
            glideExecutor = this.f16492h;
        } else {
            glideExecutor = h();
        }
        glideExecutor.execute(decodeJob);
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools$Pool<EngineJob<?>> pools$Pool, EngineResourceFactory engineResourceFactory) {
        this.f16486b = new ResourceCallbacksAndExecutors();
        this.f16487c = StateVerifier.a();
        this.f16496l = new AtomicInteger();
        this.f16492h = glideExecutor;
        this.f16493i = glideExecutor2;
        this.f16494j = glideExecutor3;
        this.f16495k = glideExecutor4;
        this.f16491g = engineJobListener;
        this.f16488d = resourceListener;
        this.f16489e = pools$Pool;
        this.f16490f = engineResourceFactory;
    }
}
