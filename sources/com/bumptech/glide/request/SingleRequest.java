package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final boolean D = Log.isLoggable("Request", 2);
    private int A;
    private boolean B;
    private RuntimeException C;

    /* renamed from: a  reason: collision with root package name */
    private final String f17061a;

    /* renamed from: b  reason: collision with root package name */
    private final StateVerifier f17062b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f17063c;

    /* renamed from: d  reason: collision with root package name */
    private final RequestListener<R> f17064d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestCoordinator f17065e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f17066f;

    /* renamed from: g  reason: collision with root package name */
    private final GlideContext f17067g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f17068h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<R> f17069i;

    /* renamed from: j  reason: collision with root package name */
    private final BaseRequestOptions<?> f17070j;

    /* renamed from: k  reason: collision with root package name */
    private final int f17071k;

    /* renamed from: l  reason: collision with root package name */
    private final int f17072l;

    /* renamed from: m  reason: collision with root package name */
    private final Priority f17073m;

    /* renamed from: n  reason: collision with root package name */
    private final Target<R> f17074n;

    /* renamed from: o  reason: collision with root package name */
    private final List<RequestListener<R>> f17075o;

    /* renamed from: p  reason: collision with root package name */
    private final TransitionFactory<? super R> f17076p;

    /* renamed from: q  reason: collision with root package name */
    private final Executor f17077q;

    /* renamed from: r  reason: collision with root package name */
    private Resource<R> f17078r;

    /* renamed from: s  reason: collision with root package name */
    private Engine.LoadStatus f17079s;

    /* renamed from: t  reason: collision with root package name */
    private long f17080t;

    /* renamed from: u  reason: collision with root package name */
    private volatile Engine f17081u;

    /* renamed from: v  reason: collision with root package name */
    private Status f17082v;

    /* renamed from: w  reason: collision with root package name */
    private Drawable f17083w;

    /* renamed from: x  reason: collision with root package name */
    private Drawable f17084x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f17085y;

    /* renamed from: z  reason: collision with root package name */
    private int f17086z;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i2, int i3, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        String str;
        if (D) {
            str = String.valueOf(super.hashCode());
        } else {
            str = null;
        }
        this.f17061a = str;
        this.f17062b = StateVerifier.a();
        this.f17063c = obj;
        this.f17066f = context;
        this.f17067g = glideContext;
        this.f17068h = obj2;
        this.f17069i = cls;
        this.f17070j = baseRequestOptions;
        this.f17071k = i2;
        this.f17072l = i3;
        this.f17073m = priority;
        this.f17074n = target;
        this.f17064d = requestListener;
        this.f17075o = list;
        this.f17065e = requestCoordinator;
        this.f17081u = engine;
        this.f17076p = transitionFactory;
        this.f17077q = executor;
        this.f17082v = Status.PENDING;
        if (this.C == null && glideContext.i()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    private void a() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean b() {
        RequestCoordinator requestCoordinator = this.f17065e;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    private boolean c() {
        RequestCoordinator requestCoordinator = this.f17065e;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean d() {
        RequestCoordinator requestCoordinator = this.f17065e;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    private void e() {
        a();
        this.f17062b.c();
        this.f17074n.removeCallback(this);
        Engine.LoadStatus loadStatus = this.f17079s;
        if (loadStatus != null) {
            loadStatus.a();
            this.f17079s = null;
        }
    }

    private Drawable f() {
        if (this.f17083w == null) {
            Drawable k2 = this.f17070j.k();
            this.f17083w = k2;
            if (k2 == null && this.f17070j.j() > 0) {
                this.f17083w = j(this.f17070j.j());
            }
        }
        return this.f17083w;
    }

    private Drawable g() {
        if (this.f17085y == null) {
            Drawable l2 = this.f17070j.l();
            this.f17085y = l2;
            if (l2 == null && this.f17070j.m() > 0) {
                this.f17085y = j(this.f17070j.m());
            }
        }
        return this.f17085y;
    }

    private Drawable h() {
        if (this.f17084x == null) {
            Drawable r2 = this.f17070j.r();
            this.f17084x = r2;
            if (r2 == null && this.f17070j.s() > 0) {
                this.f17084x = j(this.f17070j.s());
            }
        }
        return this.f17084x;
    }

    private boolean i() {
        RequestCoordinator requestCoordinator = this.f17065e;
        return requestCoordinator == null || !requestCoordinator.getRoot().isAnyResourceSet();
    }

    private Drawable j(int i2) {
        Resources.Theme theme;
        if (this.f17070j.x() != null) {
            theme = this.f17070j.x();
        } else {
            theme = this.f17066f.getTheme();
        }
        return DrawableDecoderCompat.a(this.f17067g, i2, theme);
    }

    private void k(String str) {
        Log.v("Request", str + " this: " + this.f17061a);
    }

    private static int l(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * ((float) i2));
    }

    private void m() {
        RequestCoordinator requestCoordinator = this.f17065e;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    private void n() {
        RequestCoordinator requestCoordinator = this.f17065e;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    public static <R> SingleRequest<R> o(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i2, int i3, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest(context, glideContext, obj, obj2, cls, baseRequestOptions, i2, i3, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    /* JADX INFO: finally extract failed */
    private void p(GlideException glideException, int i2) {
        boolean z2;
        this.f17062b.c();
        synchronized (this.f17063c) {
            glideException.k(this.C);
            int g2 = this.f17067g.g();
            if (g2 <= i2) {
                Log.w("Glide", "Load failed for " + this.f17068h + " with size [" + this.f17086z + "x" + this.A + "]", glideException);
                if (g2 <= 4) {
                    glideException.g("Glide");
                }
            }
            this.f17079s = null;
            this.f17082v = Status.FAILED;
            boolean z3 = true;
            this.B = true;
            try {
                List<RequestListener<R>> list = this.f17075o;
                if (list != null) {
                    z2 = false;
                    for (RequestListener<R> onLoadFailed : list) {
                        z2 |= onLoadFailed.onLoadFailed(glideException, this.f17068h, this.f17074n, i());
                    }
                } else {
                    z2 = false;
                }
                RequestListener<R> requestListener = this.f17064d;
                if (requestListener == null || !requestListener.onLoadFailed(glideException, this.f17068h, this.f17074n, i())) {
                    z3 = false;
                }
                if (!z2 && !z3) {
                    r();
                }
                this.B = false;
                m();
            } catch (Throwable th) {
                this.B = false;
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a7 A[Catch:{ all -> 0x00b8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q(com.bumptech.glide.load.engine.Resource<R> r11, R r12, com.bumptech.glide.load.DataSource r13) {
        /*
            r10 = this;
            boolean r6 = r10.i()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r10.f17082v = r0
            r10.f17078r = r11
            com.bumptech.glide.GlideContext r11 = r10.f17067g
            int r11 = r11.g()
            r0 = 3
            if (r11 > r0) goto L_0x006a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Finished loading "
            r11.append(r0)
            java.lang.Class r0 = r12.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r11.append(r0)
            java.lang.String r0 = " from "
            r11.append(r0)
            r11.append(r13)
            java.lang.String r0 = " for "
            r11.append(r0)
            java.lang.Object r0 = r10.f17068h
            r11.append(r0)
            java.lang.String r0 = " with size ["
            r11.append(r0)
            int r0 = r10.f17086z
            r11.append(r0)
            java.lang.String r0 = "x"
            r11.append(r0)
            int r0 = r10.A
            r11.append(r0)
            java.lang.String r0 = "] in "
            r11.append(r0)
            long r0 = r10.f17080t
            double r0 = com.bumptech.glide.util.LogTime.a(r0)
            r11.append(r0)
            java.lang.String r0 = " ms"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            java.lang.String r0 = "Glide"
            android.util.Log.d(r0, r11)
        L_0x006a:
            r11 = 1
            r10.B = r11
            r7 = 0
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r10.f17075o     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x0090
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x00b8 }
            r9 = 0
        L_0x0077:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x0091
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00b8 }
            com.bumptech.glide.request.RequestListener r0 = (com.bumptech.glide.request.RequestListener) r0     // Catch:{ all -> 0x00b8 }
            java.lang.Object r2 = r10.f17068h     // Catch:{ all -> 0x00b8 }
            com.bumptech.glide.request.target.Target<R> r3 = r10.f17074n     // Catch:{ all -> 0x00b8 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b8 }
            r9 = r9 | r0
            goto L_0x0077
        L_0x0090:
            r9 = 0
        L_0x0091:
            com.bumptech.glide.request.RequestListener<R> r0 = r10.f17064d     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x00a3
            java.lang.Object r2 = r10.f17068h     // Catch:{ all -> 0x00b8 }
            com.bumptech.glide.request.target.Target<R> r3 = r10.f17074n     // Catch:{ all -> 0x00b8 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r11 = 0
        L_0x00a4:
            r11 = r11 | r9
            if (r11 != 0) goto L_0x00b2
            com.bumptech.glide.request.transition.TransitionFactory<? super R> r11 = r10.f17076p     // Catch:{ all -> 0x00b8 }
            com.bumptech.glide.request.transition.Transition r11 = r11.build(r13, r6)     // Catch:{ all -> 0x00b8 }
            com.bumptech.glide.request.target.Target<R> r13 = r10.f17074n     // Catch:{ all -> 0x00b8 }
            r13.onResourceReady(r12, r11)     // Catch:{ all -> 0x00b8 }
        L_0x00b2:
            r10.B = r7
            r10.n()
            return
        L_0x00b8:
            r11 = move-exception
            r10.B = r7
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.q(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource):void");
    }

    private void r() {
        Drawable drawable;
        if (c()) {
            if (this.f17068h == null) {
                drawable = g();
            } else {
                drawable = null;
            }
            if (drawable == null) {
                drawable = f();
            }
            if (drawable == null) {
                drawable = h();
            }
            this.f17074n.onLoadFailed(drawable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void begin() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f17063c
            monitor-enter(r0)
            r5.a()     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.f17062b     // Catch:{ all -> 0x00a7 }
            r1.c()     // Catch:{ all -> 0x00a7 }
            long r1 = com.bumptech.glide.util.LogTime.b()     // Catch:{ all -> 0x00a7 }
            r5.f17080t = r1     // Catch:{ all -> 0x00a7 }
            java.lang.Object r1 = r5.f17068h     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x003c
            int r1 = r5.f17071k     // Catch:{ all -> 0x00a7 }
            int r2 = r5.f17072l     // Catch:{ all -> 0x00a7 }
            boolean r1 = com.bumptech.glide.util.Util.r(r1, r2)     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x0027
            int r1 = r5.f17071k     // Catch:{ all -> 0x00a7 }
            r5.f17086z = r1     // Catch:{ all -> 0x00a7 }
            int r1 = r5.f17072l     // Catch:{ all -> 0x00a7 }
            r5.A = r1     // Catch:{ all -> 0x00a7 }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r5.g()     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00a7 }
            r5.p(r2, r1)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x003c:
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.f17082v     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00a7 }
            if (r1 == r2) goto L_0x009f
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00a7 }
            if (r1 != r3) goto L_0x004f
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.f17078r     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00a7 }
            r5.onResourceReady(r1, r2)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x004f:
            com.bumptech.glide.request.SingleRequest$Status r1 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00a7 }
            r5.f17082v = r1     // Catch:{ all -> 0x00a7 }
            int r3 = r5.f17071k     // Catch:{ all -> 0x00a7 }
            int r4 = r5.f17072l     // Catch:{ all -> 0x00a7 }
            boolean r3 = com.bumptech.glide.util.Util.r(r3, r4)     // Catch:{ all -> 0x00a7 }
            if (r3 == 0) goto L_0x0065
            int r3 = r5.f17071k     // Catch:{ all -> 0x00a7 }
            int r4 = r5.f17072l     // Catch:{ all -> 0x00a7 }
            r5.onSizeReady(r3, r4)     // Catch:{ all -> 0x00a7 }
            goto L_0x006a
        L_0x0065:
            com.bumptech.glide.request.target.Target<R> r3 = r5.f17074n     // Catch:{ all -> 0x00a7 }
            r3.getSize(r5)     // Catch:{ all -> 0x00a7 }
        L_0x006a:
            com.bumptech.glide.request.SingleRequest$Status r3 = r5.f17082v     // Catch:{ all -> 0x00a7 }
            if (r3 == r2) goto L_0x0070
            if (r3 != r1) goto L_0x007f
        L_0x0070:
            boolean r1 = r5.c()     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x007f
            com.bumptech.glide.request.target.Target<R> r1 = r5.f17074n     // Catch:{ all -> 0x00a7 }
            android.graphics.drawable.Drawable r2 = r5.h()     // Catch:{ all -> 0x00a7 }
            r1.onLoadStarted(r2)     // Catch:{ all -> 0x00a7 }
        L_0x007f:
            boolean r1 = D     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x009d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r1.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x00a7 }
            long r2 = r5.f17080t     // Catch:{ all -> 0x00a7 }
            double r2 = com.bumptech.glide.util.LogTime.a(r2)     // Catch:{ all -> 0x00a7 }
            r1.append(r2)     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a7 }
            r5.k(r1)     // Catch:{ all -> 0x00a7 }
        L_0x009d:
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x009f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00a7 }
            throw r1     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.begin():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r5.f17081u.k(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f17063c
            monitor-enter(r0)
            r5.a()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.f17062b     // Catch:{ all -> 0x0039 }
            r1.c()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.f17082v     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0039 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return
        L_0x0013:
            r5.e()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.f17078r     // Catch:{ all -> 0x0039 }
            r3 = 0
            if (r1 == 0) goto L_0x001e
            r5.f17078r = r3     // Catch:{ all -> 0x0039 }
            goto L_0x001f
        L_0x001e:
            r1 = r3
        L_0x001f:
            boolean r3 = r5.b()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x002e
            com.bumptech.glide.request.target.Target<R> r3 = r5.f17074n     // Catch:{ all -> 0x0039 }
            android.graphics.drawable.Drawable r4 = r5.h()     // Catch:{ all -> 0x0039 }
            r3.onLoadCleared(r4)     // Catch:{ all -> 0x0039 }
        L_0x002e:
            r5.f17082v = r2     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0038
            com.bumptech.glide.load.engine.Engine r0 = r5.f17081u
            r0.k(r1)
        L_0x0038:
            return
        L_0x0039:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public Object getLock() {
        this.f17062b.c();
        return this.f17063c;
    }

    public boolean isAnyResourceSet() {
        boolean z2;
        synchronized (this.f17063c) {
            if (this.f17082v == Status.COMPLETE) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    public boolean isCleared() {
        boolean z2;
        synchronized (this.f17063c) {
            if (this.f17082v == Status.CLEARED) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    public boolean isComplete() {
        boolean z2;
        synchronized (this.f17063c) {
            if (this.f17082v == Status.COMPLETE) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    public boolean isEquivalentTo(Request request) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int i4;
        int i5;
        int i6;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int i7;
        Request request2 = request;
        if (!(request2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f17063c) {
            i2 = this.f17071k;
            i3 = this.f17072l;
            obj = this.f17068h;
            cls = this.f17069i;
            baseRequestOptions = this.f17070j;
            priority = this.f17073m;
            List<RequestListener<R>> list = this.f17075o;
            if (list != null) {
                i4 = list.size();
            } else {
                i4 = 0;
            }
        }
        SingleRequest singleRequest = (SingleRequest) request2;
        synchronized (singleRequest.f17063c) {
            i5 = singleRequest.f17071k;
            i6 = singleRequest.f17072l;
            obj2 = singleRequest.f17068h;
            cls2 = singleRequest.f17069i;
            baseRequestOptions2 = singleRequest.f17070j;
            priority2 = singleRequest.f17073m;
            List<RequestListener<R>> list2 = singleRequest.f17075o;
            if (list2 != null) {
                i7 = list2.size();
            } else {
                i7 = 0;
            }
        }
        if (i2 == i5 && i3 == i6 && Util.b(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && i4 == i7) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        boolean z2;
        synchronized (this.f17063c) {
            Status status = this.f17082v;
            if (status != Status.RUNNING) {
                if (status != Status.WAITING_FOR_SIZE) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public void onLoadFailed(GlideException glideException) {
        p(glideException, 5);
    }

    public void onResourceReady(Resource<?> resource, DataSource dataSource) {
        Object obj;
        String str;
        this.f17062b.c();
        Resource<?> resource2 = null;
        try {
            synchronized (this.f17063c) {
                try {
                    this.f17079s = null;
                    if (resource == null) {
                        onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.f17069i + " inside, but instead got null."));
                        return;
                    }
                    Object obj2 = resource.get();
                    if (obj2 != null) {
                        if (this.f17069i.isAssignableFrom(obj2.getClass())) {
                            if (!d()) {
                                try {
                                    this.f17078r = null;
                                    this.f17082v = Status.COMPLETE;
                                    this.f17081u.k(resource);
                                    return;
                                } catch (Throwable th) {
                                    resource2 = resource;
                                    th = th;
                                    throw th;
                                }
                            } else {
                                q(resource, obj2, dataSource);
                                return;
                            }
                        }
                    }
                    this.f17078r = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected to receive an object of ");
                    sb.append(this.f17069i);
                    sb.append(" but instead got ");
                    if (obj2 != null) {
                        obj = obj2.getClass();
                    } else {
                        obj = "";
                    }
                    sb.append(obj);
                    sb.append("{");
                    sb.append(obj2);
                    sb.append("} inside Resource{");
                    sb.append(resource);
                    sb.append("}.");
                    if (obj2 != null) {
                        str = "";
                    } else {
                        str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                    }
                    sb.append(str);
                    onLoadFailed(new GlideException(sb.toString()));
                    this.f17081u.k(resource);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            if (resource2 != null) {
                this.f17081u.k(resource2);
            }
            throw th3;
        }
    }

    public void onSizeReady(int i2, int i3) {
        Object obj;
        this.f17062b.c();
        Object obj2 = this.f17063c;
        synchronized (obj2) {
            try {
                boolean z2 = D;
                if (z2) {
                    k("Got onSizeReady in " + LogTime.a(this.f17080t));
                }
                if (this.f17082v == Status.WAITING_FOR_SIZE) {
                    Status status = Status.RUNNING;
                    this.f17082v = status;
                    float w2 = this.f17070j.w();
                    this.f17086z = l(i2, w2);
                    this.A = l(i3, w2);
                    if (z2) {
                        k("finished setup for calling load in " + LogTime.a(this.f17080t));
                    }
                    Status status2 = status;
                    boolean z3 = z2;
                    Status status3 = status2;
                    obj = obj2;
                    try {
                        this.f17079s = this.f17081u.f(this.f17067g, this.f17068h, this.f17070j.v(), this.f17086z, this.A, this.f17070j.u(), this.f17069i, this.f17073m, this.f17070j.i(), this.f17070j.y(), this.f17070j.H(), this.f17070j.D(), this.f17070j.o(), this.f17070j.B(), this.f17070j.A(), this.f17070j.z(), this.f17070j.n(), this, this.f17077q);
                        if (this.f17082v != status3) {
                            this.f17079s = null;
                        }
                        if (z3) {
                            k("finished onSizeReady in " + LogTime.a(this.f17080t));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                obj = obj2;
                throw th;
            }
        }
    }

    public void pause() {
        synchronized (this.f17063c) {
            if (isRunning()) {
                clear();
            }
        }
    }
}
