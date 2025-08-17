package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f6263b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f6264c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Exception f6265d;

    public /* synthetic */ m(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, Exception exc) {
        this.f6263b = eventDispatcher;
        this.f6264c = drmSessionEventListener;
        this.f6265d = exc;
    }

    public final void run() {
        this.f6263b.r(this.f6264c, this.f6265d);
    }
}
