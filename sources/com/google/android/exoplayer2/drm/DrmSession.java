package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public interface DrmSession {

    public static class DrmSessionException extends IOException {

        /* renamed from: b  reason: collision with root package name */
        public final int f24084b;

        public DrmSessionException(Throwable th, int i2) {
            super(th);
            this.f24084b = i2;
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
