package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

public final class ErrorRequestCoordinator implements RequestCoordinator, Request {

    /* renamed from: a  reason: collision with root package name */
    private final Object f17048a;

    /* renamed from: b  reason: collision with root package name */
    private final RequestCoordinator f17049b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Request f17050c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Request f17051d;

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f17052e;

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f17053f;

    public ErrorRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f17052e = requestState;
        this.f17053f = requestState;
        this.f17048a = obj;
        this.f17049b = requestCoordinator;
    }

    private boolean a(Request request) {
        if (request.equals(this.f17050c) || (this.f17052e == RequestCoordinator.RequestState.FAILED && request.equals(this.f17051d))) {
            return true;
        }
        return false;
    }

    private boolean b() {
        RequestCoordinator requestCoordinator = this.f17049b;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    private boolean c() {
        RequestCoordinator requestCoordinator = this.f17049b;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean d() {
        RequestCoordinator requestCoordinator = this.f17049b;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    public void begin() {
        synchronized (this.f17048a) {
            RequestCoordinator.RequestState requestState = this.f17052e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.f17052e = requestState2;
                this.f17050c.begin();
            }
        }
    }

    public boolean canNotifyCleared(Request request) {
        boolean z2;
        synchronized (this.f17048a) {
            if (!b() || !a(request)) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean canNotifyStatusChanged(Request request) {
        boolean z2;
        synchronized (this.f17048a) {
            if (!c() || !a(request)) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean canSetImage(Request request) {
        boolean z2;
        synchronized (this.f17048a) {
            if (!d() || !a(request)) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        return z2;
    }

    public void clear() {
        synchronized (this.f17048a) {
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f17052e = requestState;
            this.f17050c.clear();
            if (this.f17053f != requestState) {
                this.f17053f = requestState;
                this.f17051d.clear();
            }
        }
    }

    public void e(Request request, Request request2) {
        this.f17050c = request;
        this.f17051d = request2;
    }

    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.f17048a) {
            RequestCoordinator requestCoordinator2 = this.f17049b;
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
        synchronized (this.f17048a) {
            if (!this.f17050c.isAnyResourceSet()) {
                if (!this.f17051d.isAnyResourceSet()) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public boolean isCleared() {
        boolean z2;
        synchronized (this.f17048a) {
            RequestCoordinator.RequestState requestState = this.f17052e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
            if (requestState == requestState2 && this.f17053f == requestState2) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    public boolean isComplete() {
        boolean z2;
        synchronized (this.f17048a) {
            RequestCoordinator.RequestState requestState = this.f17052e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            if (requestState != requestState2) {
                if (this.f17053f != requestState2) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        if (!this.f17050c.isEquivalentTo(errorRequestCoordinator.f17050c) || !this.f17051d.isEquivalentTo(errorRequestCoordinator.f17051d)) {
            return false;
        }
        return true;
    }

    public boolean isRunning() {
        boolean z2;
        synchronized (this.f17048a) {
            RequestCoordinator.RequestState requestState = this.f17052e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                if (this.f17053f != requestState2) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestFailed(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f17048a
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.f17051d     // Catch:{ all -> 0x002b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x001e
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002b }
            r2.f17052e = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f17053f     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x002b }
            if (r3 == r1) goto L_0x001c
            r2.f17053f = r1     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.Request r3 = r2.f17051d     // Catch:{ all -> 0x002b }
            r3.begin()     // Catch:{ all -> 0x002b }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x001e:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002b }
            r2.f17053f = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f17049b     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0029
            r3.onRequestFailed(r2)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ErrorRequestCoordinator.onRequestFailed(com.bumptech.glide.request.Request):void");
    }

    public void onRequestSuccess(Request request) {
        synchronized (this.f17048a) {
            if (request.equals(this.f17050c)) {
                this.f17052e = RequestCoordinator.RequestState.SUCCESS;
            } else if (request.equals(this.f17051d)) {
                this.f17053f = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.f17049b;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
        }
    }

    public void pause() {
        synchronized (this.f17048a) {
            RequestCoordinator.RequestState requestState = this.f17052e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.f17052e = RequestCoordinator.RequestState.PAUSED;
                this.f17050c.pause();
            }
            if (this.f17053f == requestState2) {
                this.f17053f = RequestCoordinator.RequestState.PAUSED;
                this.f17051d.pause();
            }
        }
    }
}
