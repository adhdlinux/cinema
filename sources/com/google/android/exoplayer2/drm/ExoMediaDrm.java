package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ExoMediaDrm {

    public static final class KeyRequest {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f24094a;

        /* renamed from: b  reason: collision with root package name */
        private final String f24095b;

        /* renamed from: c  reason: collision with root package name */
        private final int f24096c;

        public KeyRequest(byte[] bArr, String str, int i2) {
            this.f24094a = bArr;
            this.f24095b = str;
            this.f24096c = i2;
        }

        public byte[] a() {
            return this.f24094a;
        }

        public String b() {
            return this.f24095b;
        }
    }

    public interface OnEventListener {
        void a(ExoMediaDrm exoMediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2);
    }

    public interface Provider {
        ExoMediaDrm a(UUID uuid);
    }

    public static final class ProvisionRequest {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f24097a;

        /* renamed from: b  reason: collision with root package name */
        private final String f24098b;

        public ProvisionRequest(byte[] bArr, String str) {
            this.f24097a = bArr;
            this.f24098b = str;
        }

        public byte[] a() {
            return this.f24097a;
        }

        public String b() {
            return this.f24098b;
        }
    }

    Map<String, String> a(byte[] bArr);

    ProvisionRequest b();

    byte[] c() throws MediaDrmException;

    void d(byte[] bArr, byte[] bArr2);

    void e(byte[] bArr) throws DeniedByServerException;

    int f();

    CryptoConfig g(byte[] bArr) throws MediaCryptoException;

    boolean h(byte[] bArr, String str);

    void i(byte[] bArr);

    byte[] j(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException;

    KeyRequest k(byte[] bArr, List<DrmInitData.SchemeData> list, int i2, HashMap<String, String> hashMap) throws NotProvisionedException;

    void l(byte[] bArr, PlayerId playerId);

    void m(OnEventListener onEventListener);

    void release();
}
