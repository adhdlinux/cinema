package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
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

    public /* synthetic */ void l(byte[] bArr, PlayerId playerId) {
        t.a(this, bArr, playerId);
    }

    public void m(ExoMediaDrm.OnEventListener onEventListener) {
    }

    public void release() {
    }
}
