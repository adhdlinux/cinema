package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzgfu extends zzgdu {
    private static final zzges zza = zzges.zzb(zzgfr.zza, zzgfq.class, zzggf.class);

    zzgfu() {
        super(zzghy.class, new zzgfs(zzfye.class));
    }

    public static void zzm(boolean z2) throws GeneralSecurityException {
        zzfyp.zze(new zzgfu(), true);
        int i2 = zzgge.zza;
        zzgge.zzc(zzgeg.zzc());
        zzgee.zza().zze(zza);
    }

    /* access modifiers changed from: private */
    public static void zzn(zzgie zzgie) throws GeneralSecurityException {
        if (zzgie.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzgie.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzo(int i2) throws GeneralSecurityException {
        if (i2 != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final zzgdt zza() {
        return new zzgft(this, zzgib.class);
    }

    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    public final /* synthetic */ zzgqw zzc(zzgoe zzgoe) throws zzgpy {
        return zzghy.zze(zzgoe, zzgoy.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqw) throws GeneralSecurityException {
        zzghy zzghy = (zzghy) zzgqw;
        zzgni.zzb(zzghy.zza(), 0);
        zzo(zzghy.zzg().zzd());
        zzn(zzghy.zzf());
    }
}
