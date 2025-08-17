package com.google.android.gms.internal.ads;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzgcg implements zzfxh {
    private static final byte[] zza = new byte[0];
    private final zzgkp zzb;
    private final zzfxh zzc;

    public zzgcg(zzgkp zzgkp, zzfxh zzfxh) {
        this.zzb = zzgkp;
        this.zzc = zzfxh;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i2 = wrap.getInt();
            if (i2 <= 0 || i2 > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i2];
            wrap.get(bArr3, 0, i2);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            byte[] zza2 = this.zzc.zza(bArr3, zza);
            int i3 = zzfyp.zza;
            zzgoe zzgoe = zzgoe.zzb;
            return ((zzfxh) zzfyp.zzc(this.zzb.zzh(), zzgoe.zzv(zza2, 0, zza2.length), zzfxh.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e2) {
            throw new GeneralSecurityException("invalid ciphertext", e2);
        }
    }
}
