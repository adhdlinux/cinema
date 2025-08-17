package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.media3.common.DrmInitData;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.analytics.PlayerId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ExoMediaDrm {

    public static final class KeyRequest {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f6230a;

        /* renamed from: b  reason: collision with root package name */
        private final String f6231b;

        /* renamed from: c  reason: collision with root package name */
        private final int f6232c;

        public KeyRequest(byte[] bArr, String str, int i2) {
            this.f6230a = bArr;
            this.f6231b = str;
            this.f6232c = i2;
        }

        public byte[] a() {
            return this.f6230a;
        }

        public String b() {
            return this.f6231b;
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
        private final byte[] f6233a;

        /* renamed from: b  reason: collision with root package name */
        private final String f6234b;

        public ProvisionRequest(byte[] bArr, String str) {
            this.f6233a = bArr;
            this.f6234b = str;
        }

        public byte[] a() {
            return this.f6233a;
        }

        public String b() {
            return this.f6234b;
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

    void l(OnEventListener onEventListener);

    void m(byte[] bArr, PlayerId playerId);

    void release();
}
