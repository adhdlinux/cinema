package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class zzgmi implements zzfxh {
    private final zzgna zza;
    private final zzfye zzb;
    private final int zzc;

    public zzgmi(zzgna zzgna, zzfye zzfye, int i2) {
        this.zza = zzgna;
        this.zzb = zzfye;
        this.zzc = i2;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.zzc;
        if (length >= i2) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, length - i2);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, length - this.zzc, length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
            this.zzb.zza(copyOfRange2, zzgmg.zzb(bArr2, copyOfRange, copyOf));
            return this.zza.zza(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
