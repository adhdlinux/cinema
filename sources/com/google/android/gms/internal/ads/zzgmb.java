package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzgmb implements zzgna {
    private static final ThreadLocal zza = new zzgma();
    private final SecretKeySpec zzb;
    private final int zzc;
    private final int zzd;

    public zzgmb(byte[] bArr, int i2) throws GeneralSecurityException {
        if (zzgdh.zza(2)) {
            zzgni.zza(bArr.length);
            this.zzb = new SecretKeySpec(bArr, "AES");
            int blockSize = ((Cipher) zza.get()).getBlockSize();
            this.zzd = blockSize;
            if (i2 < 12 || i2 > blockSize) {
                throw new GeneralSecurityException("invalid IV size");
            }
            this.zzc = i2;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.zzc;
        if (length >= i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            int i3 = this.zzc;
            int i4 = length - i3;
            byte[] bArr3 = new byte[i4];
            Cipher cipher = (Cipher) zza.get();
            byte[] bArr4 = new byte[this.zzd];
            System.arraycopy(bArr2, 0, bArr4, 0, this.zzc);
            cipher.init(2, this.zzb, new IvParameterSpec(bArr4));
            if (cipher.doFinal(bArr, i3, i4, bArr3, 0) == i4) {
                return bArr3;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
