package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final /* synthetic */ class zzgbn implements zzgem {
    public static final /* synthetic */ zzgbn zza = new zzgbn();

    private /* synthetic */ zzgbn() {
    }

    public final zzgfd zza(zzfyf zzfyf) {
        zzglq zzglq;
        zzgbm zzgbm = (zzgbm) zzfyf;
        int i2 = zzgbr.zza;
        zzgko zza2 = zzgkp.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzgjn zzc = zzgjo.zzc();
        zzc.zza(zzgbm.zza());
        zza2.zzc(((zzgjo) zzc.zzal()).zzau());
        zzgbk zzb = zzgbm.zzb();
        if (zzgbk.zza.equals(zzb)) {
            zzglq = zzglq.TINK;
        } else if (zzgbk.zzb.equals(zzb)) {
            zzglq = zzglq.CRUNCHY;
        } else if (zzgbk.zzc.equals(zzb)) {
            zzglq = zzglq.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzb)));
        }
        zza2.zza(zzglq);
        return zzgfb.zza((zzgkp) zza2.zzal());
    }
}
