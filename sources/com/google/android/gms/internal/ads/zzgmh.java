package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class zzgmh implements zzfxh {
    private final zzgda zza;

    public zzgmh(byte[] bArr) throws GeneralSecurityException {
        this.zza = new zzgda(bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length >= 28) {
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            return this.zza.zzb(ByteBuffer.wrap(bArr, 12, length - 12), copyOf, bArr2);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
