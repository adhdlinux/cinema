package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f24122b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f24123c;

    public /* synthetic */ k(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f24122b = eventDispatcher;
        this.f24123c = drmSessionEventListener;
    }

    public final void run() {
        this.f24122b.s(this.f24123c);
    }
}
