package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSessionManager.PreacquiredSessionReference f6254b;

    public /* synthetic */ f(DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference) {
        this.f6254b = preacquiredSessionReference;
    }

    public final void run() {
        this.f6254b.e();
    }
}
