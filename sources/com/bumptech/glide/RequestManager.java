package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RequestManager implements ComponentCallbacks2, LifecycleListener {

    /* renamed from: n  reason: collision with root package name */
    private static final RequestOptions f16164n = ((RequestOptions) RequestOptions.f0(Bitmap.class).K());

    /* renamed from: o  reason: collision with root package name */
    private static final RequestOptions f16165o = ((RequestOptions) RequestOptions.f0(GifDrawable.class).K());

    /* renamed from: p  reason: collision with root package name */
    private static final RequestOptions f16166p = ((RequestOptions) ((RequestOptions) RequestOptions.g0(DiskCacheStrategy.f16456c).S(Priority.LOW)).Z(true));

    /* renamed from: b  reason: collision with root package name */
    protected final Glide f16167b;

    /* renamed from: c  reason: collision with root package name */
    protected final Context f16168c;

    /* renamed from: d  reason: collision with root package name */
    final Lifecycle f16169d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestTracker f16170e;

    /* renamed from: f  reason: collision with root package name */
    private final RequestManagerTreeNode f16171f;

    /* renamed from: g  reason: collision with root package name */
    private final TargetTracker f16172g;

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f16173h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f16174i;

    /* renamed from: j  reason: collision with root package name */
    private final ConnectivityMonitor f16175j;

    /* renamed from: k  reason: collision with root package name */
    private final CopyOnWriteArrayList<RequestListener<Object>> f16176k;

    /* renamed from: l  reason: collision with root package name */
    private RequestOptions f16177l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f16178m;

    private class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {

        /* renamed from: a  reason: collision with root package name */
        private final RequestTracker f16180a;

        RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.f16180a = requestTracker;
        }

        public void a(boolean z2) {
            if (z2) {
                synchronized (RequestManager.this) {
                    this.f16180a.e();
                }
            }
        }
    }

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.g(), context);
    }

    private void p(Target<?> target) {
        boolean o2 = o(target);
        Request request = target.getRequest();
        if (!o2 && !this.f16167b.p(target) && request != null) {
            target.setRequest((Request) null);
            request.clear();
        }
    }

    public <ResourceType> RequestBuilder<ResourceType> a(Class<ResourceType> cls) {
        return new RequestBuilder<>(this.f16167b, this, cls, this.f16168c);
    }

    public RequestBuilder<Bitmap> b() {
        return a(Bitmap.class).a(f16164n);
    }

    public RequestBuilder<Drawable> c() {
        return a(Drawable.class);
    }

    public void d(Target<?> target) {
        if (target != null) {
            p(target);
        }
    }

    /* access modifiers changed from: package-private */
    public List<RequestListener<Object>> e() {
        return this.f16176k;
    }

    /* access modifiers changed from: package-private */
    public synchronized RequestOptions f() {
        return this.f16177l;
    }

    /* access modifiers changed from: package-private */
    public <T> TransitionOptions<?, T> g(Class<T> cls) {
        return this.f16167b.i().e(cls);
    }

    public RequestBuilder<Drawable> h(String str) {
        return c().u0(str);
    }

    public synchronized void i() {
        this.f16170e.c();
    }

    public synchronized void j() {
        i();
        for (RequestManager i2 : this.f16171f.a()) {
            i2.i();
        }
    }

    public synchronized void k() {
        this.f16170e.d();
    }

    public synchronized void l() {
        this.f16170e.f();
    }

    /* access modifiers changed from: protected */
    public synchronized void m(RequestOptions requestOptions) {
        this.f16177l = (RequestOptions) ((RequestOptions) requestOptions.clone()).b();
    }

    /* access modifiers changed from: package-private */
    public synchronized void n(Target<?> target, Request request) {
        this.f16172g.c(target);
        this.f16170e.g(request);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean o(Target<?> target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f16170e.a(request)) {
            return false;
        }
        this.f16172g.d(target);
        target.setRequest((Request) null);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public synchronized void onDestroy() {
        this.f16172g.onDestroy();
        for (Target<?> d2 : this.f16172g.b()) {
            d(d2);
        }
        this.f16172g.a();
        this.f16170e.b();
        this.f16169d.a(this);
        this.f16169d.a(this.f16175j);
        this.f16174i.removeCallbacks(this.f16173h);
        this.f16167b.s(this);
    }

    public void onLowMemory() {
    }

    public synchronized void onStart() {
        l();
        this.f16172g.onStart();
    }

    public synchronized void onStop() {
        k();
        this.f16172g.onStop();
    }

    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.f16178m) {
            j();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f16170e + ", treeNode=" + this.f16171f + "}";
    }

    RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.f16172g = new TargetTracker();
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                RequestManager requestManager = RequestManager.this;
                requestManager.f16169d.b(requestManager);
            }
        };
        this.f16173h = r02;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f16174i = handler;
        this.f16167b = glide;
        this.f16169d = lifecycle;
        this.f16171f = requestManagerTreeNode;
        this.f16170e = requestTracker;
        this.f16168c = context;
        ConnectivityMonitor a2 = connectivityMonitorFactory.a(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        this.f16175j = a2;
        if (Util.o()) {
            handler.post(r02);
        } else {
            lifecycle.b(this);
        }
        lifecycle.b(a2);
        this.f16176k = new CopyOnWriteArrayList<>(glide.i().c());
        m(glide.i().d());
        glide.o(this);
    }
}
