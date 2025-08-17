package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f24124b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f24125c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Exception f24126d;

    public /* synthetic */ l(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, Exception exc) {
        this.f24124b = eventDispatcher;
        this.f24125c = drmSessionEventListener;
        this.f24126d = exc;
    }

    public final void run() {
        this.f24124b.r(this.f24125c, this.f24126d);
    }
}
