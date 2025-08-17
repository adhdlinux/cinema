package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import com.startapp.y1;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzgme implements zzfxh {
    private static final ThreadLocal zza = new zzgmc();
    private static final ThreadLocal zzb = new zzgmd();
    private final byte[] zzc;
    private final byte[] zzd;
    private final SecretKeySpec zze;
    private final int zzf;

    public zzgme(byte[] bArr, int i2) throws GeneralSecurityException {
        if (!zzgdh.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        } else if (i2 == 12 || i2 == 16) {
            this.zzf = i2;
            zzgni.zza(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.zze = secretKeySpec;
            Cipher cipher = (Cipher) zza.get();
            cipher.init(1, secretKeySpec);
            byte[] zzb2 = zzb(cipher.doFinal(new byte[16]));
            this.zzc = zzb2;
            this.zzd = zzb(zzb2);
        } else {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
    }

    private static byte[] zzb(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i2 = 0;
        while (i2 < 15) {
            byte b2 = bArr[i2];
            int i3 = i2 + 1;
            bArr2[i2] = (byte) (((b2 + b2) ^ ((bArr[i3] & 255) >>> 7)) & JfifUtil.MARKER_FIRST_BYTE);
            i2 = i3;
        }
        byte b3 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & Sdk$SDKError.Reason.INVALID_CONFIG_RESPONSE_VALUE) ^ (b3 + b3));
        return bArr2;
    }

    private final byte[] zzc(Cipher cipher, int i2, byte[] bArr, int i3, int i4) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        int length;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i2;
        if (i4 == 0) {
            return cipher.doFinal(zzd(bArr3, this.zzc));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i5 = 0;
        int i6 = 0;
        while (i4 - i6 > 16) {
            for (int i7 = 0; i7 < 16; i7++) {
                doFinal[i7] = (byte) (doFinal[i7] ^ bArr[(i3 + i6) + i7]);
            }
            doFinal = cipher.doFinal(doFinal);
            i6 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i6 + i3, i3 + i4);
        if (copyOfRange.length == 16) {
            bArr2 = zzd(copyOfRange, this.zzc);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzd, 16);
            while (true) {
                length = copyOfRange.length;
                if (i5 >= length) {
                    break;
                }
                copyOf[i5] = (byte) (copyOf[i5] ^ copyOfRange[i5]);
                i5++;
            }
            copyOf[length] = (byte) (copyOf[length] ^ y1.f36938c);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzd(doFinal, bArr2));
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
        return bArr3;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = (length - this.zzf) - 16;
        if (i2 >= 0) {
            Cipher cipher = (Cipher) zza.get();
            cipher.init(1, this.zze);
            byte[] zzc2 = zzc(cipher, 0, bArr, 0, this.zzf);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr3 = bArr2;
            byte[] zzc3 = zzc(cipher, 1, bArr3, 0, bArr3.length);
            byte[] zzc4 = zzc(cipher, 2, bArr, this.zzf, i2);
            int i3 = length - 16;
            byte b2 = 0;
            for (int i4 = 0; i4 < 16; i4++) {
                b2 = (byte) (b2 | (((bArr[i3 + i4] ^ zzc3[i4]) ^ zzc2[i4]) ^ zzc4[i4]));
            }
            if (b2 == 0) {
                Cipher cipher2 = (Cipher) zzb.get();
                cipher2.init(1, this.zze, new IvParameterSpec(zzc2));
                return cipher2.doFinal(bArr, this.zzf, i2);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
