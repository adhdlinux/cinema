package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzfzs extends zzgdu {
    zzfzs() {
        super(zzgin.class, new zzfzq(zzgna.class));
    }

    public static final void zzh(zzgin zzgin) throws GeneralSecurityException {
        zzgni.zzb(zzgin.zza(), 0);
        zzgni.zza(zzgin.zzh().zzd());
        zzm(zzgin.zzg());
    }

    /* access modifiers changed from: private */
    public static final void zzm(zzgit zzgit) throws GeneralSecurityException {
        if (zzgit.zza() < 12 || zzgit.zza() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final zzgdt zza() {
        return new zzfzr(this, zzgiq.class);
    }

    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    public final /* synthetic */ zzgqw zzc(zzgoe zzgoe) throws zzgpy {
        return zzgin.zzf(zzgoe, zzgoy.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqw) throws GeneralSecurityException {
        zzh((zzgin) zzgqw);
    }
}
