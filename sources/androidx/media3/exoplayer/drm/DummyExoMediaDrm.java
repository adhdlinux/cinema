package androidx.media3.exoplayer.drm;

import android.media.MediaDrmException;
import androidx.media3.common.DrmInitData;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DummyExoMediaDrm implements ExoMediaDrm {
    public Map<String, String> a(byte[] bArr) {
        throw new IllegalStateException();
    }

    public ExoMediaDrm.ProvisionRequest b() {
        throw new IllegalStateException();
    }

    public byte[] c() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    public void d(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    public void e(byte[] bArr) {
        throw new IllegalStateException();
    }

    public int f() {
        return 1;
    }

    public CryptoConfig g(byte[] bArr) {
        throw new IllegalStateException();
    }

    public boolean h(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    public void i(byte[] bArr) {
    }

    public byte[] j(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    public ExoMediaDrm.KeyRequest k(byte[] bArr, List<DrmInitData.SchemeData> list, int i2, HashMap<String, String> hashMap) {
        throw new IllegalStateException();
    }

    public void l(ExoMediaDrm.OnEventListener onEventListener) {
    }

    public /* synthetic */ void m(byte[] bArr, PlayerId playerId) {
        t.a(this, bArr, playerId);
    }

    public void release() {
    }
}
