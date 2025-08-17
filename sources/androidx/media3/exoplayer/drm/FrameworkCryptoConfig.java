package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import java.util.UUID;

public final class FrameworkCryptoConfig implements CryptoConfig {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f6235d;

    /* renamed from: a  reason: collision with root package name */
    public final UUID f6236a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f6237b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6238c;

    static {
        boolean z2;
        if ("Amazon".equals(Util.f4716c)) {
            String str = Util.f4717d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z2 = true;
                f6235d = z2;
            }
        }
        z2 = false;
        f6235d = z2;
    }

    public FrameworkCryptoConfig(UUID uuid, byte[] bArr, boolean z2) {
        this.f6236a = uuid;
        this.f6237b = bArr;
        this.f6238c = z2;
    }
}
