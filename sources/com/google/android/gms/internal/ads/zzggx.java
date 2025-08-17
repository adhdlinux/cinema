package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final /* synthetic */ class zzggx implements zzgem {
    public static final /* synthetic */ zzggx zza = new zzggx();

    private /* synthetic */ zzggx() {
    }

    public final zzgfd zza(zzfyf zzfyf) {
        int i2;
        zzglq zzglq;
        zzggw zzggw = (zzggw) zzfyf;
        int i3 = zzghb.zza;
        zzgko zza2 = zzgkp.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzgkb zzd = zzgkc.zzd();
        zzgke zzc = zzgkf.zzc();
        zzc.zza(zzggw.zza());
        zzggt zzd2 = zzggw.zzd();
        if (zzggt.zza.equals(zzd2)) {
            i2 = 3;
        } else if (zzggt.zzb.equals(zzd2)) {
            i2 = 7;
        } else if (zzggt.zzc.equals(zzd2)) {
            i2 = 5;
        } else if (zzggt.zzd.equals(zzd2)) {
            i2 = 4;
        } else if (zzggt.zze.equals(zzd2)) {
            i2 = 6;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zzd2)));
        }
        zzc.zzb(i2);
        zzd.zzb((zzgkf) zzc.zzal());
        zzd.zza(zzggw.zzb());
        zza2.zzc(((zzgkc) zzd.zzal()).zzau());
        zzggu zze = zzggw.zze();
        if (zzggu.zza.equals(zze)) {
            zzglq = zzglq.TINK;
        } else if (zzggu.zzb.equals(zze)) {
            zzglq = zzglq.CRUNCHY;
        } else if (zzggu.zzd.equals(zze)) {
            zzglq = zzglq.RAW;
        } else if (zzggu.zzc.equals(zze)) {
            zzglq = zzglq.LEGACY;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zze)));
        }
        zza2.zza(zzglq);
        return zzgfb.zza((zzgkp) zza2.zzal());
    }
}
