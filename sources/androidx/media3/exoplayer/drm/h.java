package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSession f6257b;

    public /* synthetic */ h(DefaultDrmSession defaultDrmSession) {
        this.f6257b = defaultDrmSession;
    }

    public final void run() {
        this.f6257b.g((DrmSessionEventListener.EventDispatcher) null);
    }
}
