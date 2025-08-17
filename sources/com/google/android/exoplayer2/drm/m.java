package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f24127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f24128c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f24129d;

    public /* synthetic */ m(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, int i2) {
        this.f24127b = eventDispatcher;
        this.f24128c = drmSessionEventListener;
        this.f24129d = i2;
    }

    public final void run() {
        this.f24127b.q(this.f24128c, this.f24129d);
    }
}
