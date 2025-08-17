package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {

    /* renamed from: a  reason: collision with root package name */
    private final RequestCoordinator f17094a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f17095b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Request f17096c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Request f17097d;

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f17098e;

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f17099f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17100g;

    public ThumbnailRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f17098e = requestState;
        this.f17099f = requestState;
        this.f17095b = obj;
        this.f17094a = requestCoordinator;
    }

    private boolean a() {
        RequestCoordinator requestCoordinator = this.f17094a;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    private boolean b() {
        RequestCoordinator requestCoordinator = this.f17094a;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean c() {
        RequestCoordinator requestCoordinator = this.f17094a;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    public void begin() {
        RequestCoordinator.RequestState requestState;
        RequestCoordinator.RequestState requestState2;
        synchronized (this.f17095b) {
            this.f17100g = true;
            try {
                if (!(this.f17098e == RequestCoordinator.RequestState.SUCCESS || this.f17099f == (requestState2 = RequestCoordinator.RequestState.RUNNING))) {
                    this.f17099f = requestState2;
                    this.f17097d.begin();
                }
                if (this.f17100g && this.f17098e != (requestState = RequestCoordinator.RequestState.RUNNING)) {
                    this.f17098e = requestState;
                    this.f17096c.begin();
                }
            } finally {
                this.f17100g = false;
            }
        }
    }

    public boolean canNotifyCleared(Request request) {
        boolean z2;
        synchronized (this.f17095b) {
            if (!a() || !request.equals(this.f17096c) || this.f17098e == RequestCoordinator.RequestState.PAUSED) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean canNotifyStatusChanged(Request request) {
        boolean z2;
        synchronized (this.f17095b) {
            if (!b() || !request.equals(this.f17096c) || isAnyResourceSet()) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean canSetImage(Request request) {
        boolean z2;
        synchronized (this.f17095b) {
            if (!c() || (!request.equals(this.f17096c) && this.f17098e == RequestCoordinator.RequestState.SUCCESS)) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        return z2;
    }

    public void clear() {
        synchronized (this.f17095b) {
            this.f17100g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f17098e = requestState;
            this.f17099f = requestState;
            this.f17097d.clear();
            this.f17096c.clear();
        }
    }

    public void d(Request request, Request request2) {
        this.f17096c = request;
        this.f17097d = request2;
    }

    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.f17095b) {
            RequestCoordinator requestCoordinator2 = this.f17094a;
            if (requestCoordinator2 != null) {
                requestCoordinator = requestCoordinator2.getRoot();
            } else {
                requestCoordinator = this;
            }
        }
        return requestCoordinator;
    }

    public boolean isAnyResourceSet() {
        boolean z2;
        synchronized (this.f17095b) {
            if (!this.f17097d.isAnyResourceSet()) {
                if (!this.f17096c.isAnyResourceSet()) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public boolean isCleared() {
        boolean z2;
        synchronized (this.f17095b) {
            if (this.f17098e == RequestCoordinator.RequestState.CLEARED) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    public boolean isComplete() {
        boolean z2;
        synchronized (this.f17095b) {
            if (this.f17098e == RequestCoordinator.RequestState.SUCCESS) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEquivalentTo(com.bumptech.glide.request.Request r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.bumptech.glide.request.ThumbnailRequestCoordinator
            r1 = 0
            if (r0 == 0) goto L_0x002e
            com.bumptech.glide.request.ThumbnailRequestCoordinator r4 = (com.bumptech.glide.request.ThumbnailRequestCoordinator) r4
            com.bumptech.glide.request.Request r0 = r3.f17096c
            if (r0 != 0) goto L_0x0010
            com.bumptech.glide.request.Request r0 = r4.f17096c
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            com.bumptech.glide.request.Request r0 = r3.f17096c
            com.bumptech.glide.request.Request r2 = r4.f17096c
            boolean r0 = r0.isEquivalentTo(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            com.bumptech.glide.request.Request r0 = r3.f17097d
            if (r0 != 0) goto L_0x0023
            com.bumptech.glide.request.Request r4 = r4.f17097d
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            com.bumptech.glide.request.Request r0 = r3.f17097d
            com.bumptech.glide.request.Request r4 = r4.f17097d
            boolean r4 = r0.isEquivalentTo(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.isEquivalentTo(com.bumptech.glide.request.Request):boolean");
    }

    public boolean isRunning() {
        boolean z2;
        synchronized (this.f17095b) {
            if (this.f17098e == RequestCoordinator.RequestState.RUNNING) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestFailed(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f17095b
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.f17096c     // Catch:{ all -> 0x001e }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001e }
            r2.f17099f = r3     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001e }
            r2.f17098e = r3     // Catch:{ all -> 0x001e }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f17094a     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001c
            r3.onRequestFailed(r2)     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.onRequestFailed(com.bumptech.glide.request.Request):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestSuccess(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f17095b
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.f17097d     // Catch:{ all -> 0x002b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002b }
            r2.f17099f = r3     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002b }
            r2.f17098e = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f17094a     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x001c
            r3.onRequestSuccess(r2)     // Catch:{ all -> 0x002b }
        L_0x001c:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f17099f     // Catch:{ all -> 0x002b }
            boolean r3 = r3.a()     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x0029
            com.bumptech.glide.request.Request r3 = r2.f17097d     // Catch:{ all -> 0x002b }
            r3.clear()     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.onRequestSuccess(com.bumptech.glide.request.Request):void");
    }

    public void pause() {
        synchronized (this.f17095b) {
            if (!this.f17099f.a()) {
                this.f17099f = RequestCoordinator.RequestState.PAUSED;
                this.f17097d.pause();
            }
            if (!this.f17098e.a()) {
                this.f17098e = RequestCoordinator.RequestState.PAUSED;
                this.f17096c.pause();
            }
        }
    }
}
