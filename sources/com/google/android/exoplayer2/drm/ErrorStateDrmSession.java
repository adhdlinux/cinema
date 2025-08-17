package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;
import java.util.UUID;

public final class ErrorStateDrmSession implements DrmSession {

    /* renamed from: a  reason: collision with root package name */
    private final DrmSession.DrmSessionException f24093a;

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.f24093a = (DrmSession.DrmSessionException) Assertions.e(drmSessionException);
    }

    public final UUID a() {
        return C.f22816a;
    }

    public boolean b() {
        return false;
    }

    public CryptoConfig c() {
        return null;
    }

    public Map<String, String> d() {
        return null;
    }

    public boolean e(String str) {
        return false;
    }

    public void f(DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    public void g(DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    public DrmSession.DrmSessionException getError() {
        return this.f24093a;
    }

    public int getState() {
        return 1;
    }
}
