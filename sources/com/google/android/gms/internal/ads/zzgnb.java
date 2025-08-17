package com.google.android.gms.internal.ads;

import com.startapp.y1;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class zzgnb implements zzghv {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzgnb(byte[] bArr) throws GeneralSecurityException {
        zzgni.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher zzb2 = zzb();
        zzb2.init(1, secretKeySpec);
        byte[] zza2 = zzghi.zza(zzb2.doFinal(new byte[16]));
        this.zzb = zza2;
        this.zzc = zzghi.zza(zza2);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzgdh.zza(1)) {
            return (Cipher) zzgmq.zza.zza("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public final byte[] zza(byte[] bArr, int i2) throws GeneralSecurityException {
        byte[] bArr2;
        if (i2 <= 16) {
            Cipher zzb2 = zzb();
            zzb2.init(1, this.zza);
            int length = bArr.length;
            int max = Math.max(1, (int) Math.ceil(((double) length) / 16.0d));
            if (max * 16 == length) {
                bArr2 = zzgmg.zzd(bArr, (max - 1) * 16, this.zzb, 0, 16);
            } else {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) * 16, length);
                int length2 = copyOfRange.length;
                if (length2 < 16) {
                    byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                    copyOf[length2] = y1.f36938c;
                    bArr2 = zzgmg.zzc(copyOf, this.zzc);
                } else {
                    throw new IllegalArgumentException("x must be smaller than a block.");
                }
            }
            byte[] bArr3 = new byte[16];
            for (int i3 = 0; i3 < max - 1; i3++) {
                bArr3 = zzb2.doFinal(zzgmg.zzd(bArr3, 0, bArr, i3 * 16, 16));
            }
            return Arrays.copyOf(zzb2.doFinal(zzgmg.zzc(bArr2, bArr3)), i2);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
