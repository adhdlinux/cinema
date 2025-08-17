package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f6266b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f6267c;

    public /* synthetic */ n(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f6266b = eventDispatcher;
        this.f6267c = drmSessionEventListener;
    }

    public final void run() {
        this.f6266b.p(this.f6267c);
    }
}
