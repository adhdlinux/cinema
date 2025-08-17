package androidx.media3.exoplayer.drm;

import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public interface DrmSession {

    public static class DrmSessionException extends IOException {

        /* renamed from: b  reason: collision with root package name */
        public final int f6221b;

        public DrmSessionException(Throwable th, int i2) {
            super(th);
            this.f6221b = i2;
        }
    }

    UUID a();

    boolean b();

    CryptoConfig c();

    Map<String, String> d();

    boolean e(String str);

    void f(DrmSessionEventListener.EventDispatcher eventDispatcher);

    void g(DrmSessionEventListener.EventDispatcher eventDispatcher);

    DrmSessionException getError();

    int getState();
}
