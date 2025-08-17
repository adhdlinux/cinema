package androidx.media3.exoplayer.drm;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSessionManager.PreacquiredSessionReference f6255b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f6256c;

    public /* synthetic */ g(DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference, Format format) {
        this.f6255b = preacquiredSessionReference;
        this.f6256c = format;
    }

    public final void run() {
        this.f6255b.d(this.f6256c);
    }
}
