package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

public final class zzfxt {
    private final zzgkp zza;

    private zzfxt(zzgkp zzgkp) {
        this.zza = zzgkp;
    }

    public static zzfxt zzb(String str, byte[] bArr, int i2) {
        zzglq zzglq;
        zzgko zza2 = zzgkp.zza();
        zza2.zzb(str);
        zza2.zzc(zzgoe.zzv(bArr, 0, bArr.length));
        int i3 = i2 - 1;
        if (i3 == 0) {
            zzglq = zzglq.TINK;
        } else if (i3 != 1) {
            zzglq = zzglq.RAW;
        } else {
            zzglq = zzglq.LEGACY;
        }
        zza2.zza(zzglq);
        return new zzfxt((zzgkp) zza2.zzal());
    }

    public final zzfyf zza() throws GeneralSecurityException {
        try {
            zzgkp zze = zzgkp.zze(this.zza.zzax(), zzgoy.zza());
            zzgeg zzc = zzgeg.zzc();
            zzgfb zza2 = zzgfb.zza(zze);
            if (!zzc.zzi(zza2)) {
                return new zzgdx(zza2);
            }
            return zzc.zzb(zza2);
        } catch (IOException e2) {
            throw new GeneralSecurityException("Failed to parse proto", e2);
        }
    }
}
