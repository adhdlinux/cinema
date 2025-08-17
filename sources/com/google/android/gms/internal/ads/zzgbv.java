package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzgbv extends zzgdu {
    zzgbv() {
        super(zzgjr.class, new zzgbt(zzfxh.class));
    }

    public final zzgdt zza() {
        return new zzgbu(this, zzgju.class);
    }

    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    public final /* synthetic */ zzgqw zzc(zzgoe zzgoe) throws zzgpy {
        return zzgjr.zze(zzgoe, zzgoy.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqw) throws GeneralSecurityException {
        zzgjr zzgjr = (zzgjr) zzgqw;
        zzgni.zzb(zzgjr.zza(), 0);
        if (zzgjr.zzf().zzd() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
