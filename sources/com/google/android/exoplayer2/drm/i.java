package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

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
