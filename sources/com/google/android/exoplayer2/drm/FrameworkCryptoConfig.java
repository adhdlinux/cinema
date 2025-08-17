package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.util.Util;
import java.util.UUID;

public final class FrameworkCryptoConfig implements CryptoConfig {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f24099d;

    /* renamed from: a  reason: collision with root package name */
    public final UUID f24100a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f24101b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f24102c;

    static {
        boolean z2;
        if ("Amazon".equals(Util.f28810c)) {
            String str = Util.f28811d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z2 = true;
                f24099d = z2;
            }
        }
        z2 = false;
        f24099d = z2;
    }

    public FrameworkCryptoConfig(UUID uuid, byte[] bArr, boolean z2) {
        this.f24100a = uuid;
        this.f24101b = bArr;
        this.f24102c = z2;
    }
}
