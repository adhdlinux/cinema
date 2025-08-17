package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final /* synthetic */ class zzgaf implements zzgem {
    public static final /* synthetic */ zzgaf zza = new zzgaf();

    private /* synthetic */ zzgaf() {
    }

    public final zzgfd zza(zzfyf zzfyf) {
        zzglq zzglq;
        zzgae zzgae = (zzgae) zzfyf;
        int i2 = zzgaj.zza;
        zzgko zza2 = zzgkp.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzgiy zzc = zzgiz.zzc();
        zzgjb zzc2 = zzgjc.zzc();
        zzc2.zza(zzgae.zza());
        zzc.zzb((zzgjc) zzc2.zzal());
        zzc.zza(zzgae.zzb());
        zza2.zzc(((zzgiz) zzc.zzal()).zzau());
        zzgac zzc3 = zzgae.zzc();
        if (zzgac.zza.equals(zzc3)) {
            zzglq = zzglq.TINK;
        } else if (zzgac.zzb.equals(zzc3)) {
            zzglq = zzglq.CRUNCHY;
        } else if (zzgac.zzc.equals(zzc3)) {
            zzglq = zzglq.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzc3)));
        }
        zza2.zza(zzglq);
        return zzgfb.zza((zzgkp) zza2.zzal());
    }
}
