package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f6261b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f6262c;

    public /* synthetic */ l(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f6261b = eventDispatcher;
        this.f6262c = drmSessionEventListener;
    }

    public final void run() {
        this.f6261b.s(this.f6262c);
    }
}
