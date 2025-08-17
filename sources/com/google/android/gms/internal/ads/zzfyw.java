package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

final class zzfyw implements zzfxh {
    private final zzfym zza;
    private final zzgho zzb;
    private final zzgho zzc;

    /* synthetic */ zzfyw(zzfym zzfym, zzfyv zzfyv) {
        zzgho zzgho;
        this.zza = zzfym;
        if (zzfym.zzf()) {
            zzghp zzb2 = zzged.zza().zzb();
            zzghu zza2 = zzgea.zza(zzfym);
            this.zzb = zzb2.zza(zza2, "aead", "encrypt");
            zzgho = zzb2.zza(zza2, "aead", "decrypt");
        } else {
            zzgho = zzgea.zza;
            this.zzb = zzgho;
        }
        this.zzc = zzgho;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzfyi zzfyi : this.zza.zze(copyOf)) {
                try {
                    byte[] zza2 = ((zzfxh) zzfyi.zze()).zza(copyOfRange, bArr2);
                    zzfyi.zza();
                    int length2 = copyOfRange.length;
                    return zza2;
                } catch (GeneralSecurityException e2) {
                    zzfyx.zza.logp(Level.INFO, "com.google.crypto.tink.aead.AeadWrapper$WrappedAead", "decrypt", "ciphertext prefix matches a key, but cannot decrypt: ".concat(e2.toString()));
                }
            }
        }
        for (zzfyi zzfyi2 : this.zza.zze(zzfxm.zza)) {
            try {
                byte[] zza3 = ((zzfxh) zzfyi2.zze()).zza(bArr, bArr2);
                zzfyi2.zza();
                return zza3;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
