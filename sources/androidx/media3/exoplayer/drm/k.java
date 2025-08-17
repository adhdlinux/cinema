package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f6258b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f6259c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f6260d;

    public /* synthetic */ k(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, int i2) {
        this.f6258b = eventDispatcher;
        this.f6259c = drmSessionEventListener;
        this.f6260d = i2;
    }

    public final void run() {
        this.f6258b.q(this.f6259c, this.f6260d);
    }
}
