package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final /* synthetic */ class zzfzl implements zzgem {
    public static final /* synthetic */ zzfzl zza = new zzfzl();

    private /* synthetic */ zzfzl() {
    }

    public final zzgfd zza(zzfyf zzfyf) {
        int i2;
        zzglq zzglq;
        zzfzk zzfzk = (zzfzk) zzfyf;
        int i3 = zzfzp.zza;
        zzgko zza2 = zzgkp.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzgij zza3 = zzgik.zza();
        zzgip zzc = zzgiq.zzc();
        zzgis zzc2 = zzgit.zzc();
        zzc2.zza(zzfzk.zzc());
        zzc.zzb((zzgit) zzc2.zzal());
        zzc.zza(zzfzk.zza());
        zza3.zza((zzgiq) zzc.zzal());
        zzgkb zzd = zzgkc.zzd();
        zzgke zzc3 = zzgkf.zzc();
        zzc3.zza(zzfzk.zzd());
        zzfzh zze = zzfzk.zze();
        if (zzfzh.zza.equals(zze)) {
            i2 = 3;
        } else if (zzfzh.zzb.equals(zze)) {
            i2 = 7;
        } else if (zzfzh.zzc.equals(zze)) {
            i2 = 5;
        } else if (zzfzh.zzd.equals(zze)) {
            i2 = 4;
        } else if (zzfzh.zze.equals(zze)) {
            i2 = 6;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zze)));
        }
        zzc3.zzb(i2);
        zzd.zzb((zzgkf) zzc3.zzal());
        zzd.zza(zzfzk.zzb());
        zza3.zzb((zzgkc) zzd.zzal());
        zza2.zzc(((zzgik) zza3.zzal()).zzau());
        zzfzi zzf = zzfzk.zzf();
        if (zzfzi.zza.equals(zzf)) {
            zzglq = zzglq.TINK;
        } else if (zzfzi.zzb.equals(zzf)) {
            zzglq = zzglq.CRUNCHY;
        } else if (zzfzi.zzc.equals(zzf)) {
            zzglq = zzglq.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzf)));
        }
        zza2.zza(zzglq);
        return zzgfb.zza((zzgkp) zza2.zzal());
    }
}
