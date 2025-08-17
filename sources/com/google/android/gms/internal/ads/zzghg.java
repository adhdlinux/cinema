package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

final class zzghg implements zzfye {
    private final zzfym zza;
    private final zzgho zzb;
    private final zzgho zzc;

    /* synthetic */ zzghg(zzfym zzfym, zzghf zzghf) {
        zzgho zzgho;
        this.zza = zzfym;
        if (zzfym.zzf()) {
            zzghp zzb2 = zzged.zza().zzb();
            zzghu zza2 = zzgea.zza(zzfym);
            this.zzb = zzb2.zza(zza2, "mac", "compute");
            zzgho = zzb2.zza(zza2, "mac", "verify");
        } else {
            zzgho = zzgea.zza;
            this.zzb = zzgho;
        }
        this.zzc = zzgho;
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzfyi zzfyi : this.zza.zze(copyOf)) {
                if (zzfyi.zzc().equals(zzglq.LEGACY)) {
                    bArr3 = zzgmg.zzb(bArr2, zzghh.zzb);
                } else {
                    bArr3 = bArr2;
                }
                try {
                    ((zzfye) zzfyi.zze()).zza(copyOfRange, bArr3);
                    zzfyi.zza();
                    return;
                } catch (GeneralSecurityException e2) {
                    zzghh.zza.logp(Level.INFO, "com.google.crypto.tink.mac.MacWrapper$WrappedMac", "verifyMac", "tag prefix matches a key, but cannot verify: ".concat(e2.toString()));
                }
            }
            for (zzfyi zzfyi2 : this.zza.zze(zzfxm.zza)) {
                try {
                    ((zzfye) zzfyi2.zze()).zza(bArr, bArr2);
                    zzfyi2.zza();
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("invalid MAC");
        }
        throw new GeneralSecurityException("tag too short");
    }
}
