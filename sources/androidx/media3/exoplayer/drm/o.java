package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f6268b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f6269c;

    public /* synthetic */ o(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f6268b = eventDispatcher;
        this.f6269c = drmSessionEventListener;
    }

    public final void run() {
        this.f6268b.o(this.f6269c);
    }
}
