package androidx.media3.exoplayer.drm;

import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import java.util.Map;
import java.util.UUID;

public final class ErrorStateDrmSession implements DrmSession {

    /* renamed from: a  reason: collision with root package name */
    private final DrmSession.DrmSessionException f6229a;

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.f6229a = (DrmSession.DrmSessionException) Assertions.f(drmSessionException);
    }

    public final UUID a() {
        return C.f3930a;
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
        return this.f6229a;
    }

    public int getState() {
        return 1;
    }
}
