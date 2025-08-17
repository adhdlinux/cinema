package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final /* synthetic */ class zzgaw implements zzgem {
    public static final /* synthetic */ zzgaw zza = new zzgaw();

    private /* synthetic */ zzgaw() {
    }

    public final zzgfd zza(zzfyf zzfyf) {
        zzglq zzglq;
        zzgav zzgav = (zzgav) zzfyf;
        int i2 = zzgba.zza;
        zzgko zza2 = zzgkp.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzgjh zzc = zzgji.zzc();
        zzc.zza(zzgav.zza());
        zza2.zzc(((zzgji) zzc.zzal()).zzau());
        zzgat zzb = zzgav.zzb();
        if (zzgat.zza.equals(zzb)) {
            zzglq = zzglq.TINK;
        } else if (zzgat.zzb.equals(zzb)) {
            zzglq = zzglq.CRUNCHY;
        } else if (zzgat.zzc.equals(zzb)) {
            zzglq = zzglq.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzb)));
        }
        zza2.zza(zzglq);
        return zzgfb.zza((zzgkp) zza2.zzal());
    }
}
