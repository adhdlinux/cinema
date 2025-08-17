package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;

public final /* synthetic */ class i {
    public static void a(DrmSession drmSession, DrmSession drmSession2) {
        if (drmSession != drmSession2) {
            if (drmSession2 != null) {
                drmSession2.f((DrmSessionEventListener.EventDispatcher) null);
            }
            if (drmSession != null) {
                drmSession.g((DrmSessionEventListener.EventDispatcher) null);
            }
        }
    }
}
