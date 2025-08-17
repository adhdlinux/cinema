package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzgcn extends zzgdu {
    zzgcn() {
        super(zzglw.class, new zzgcl(zzfxh.class));
    }

    public final zzgdt zza() {
        return new zzgcm(this, zzglz.class);
    }

    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    public final /* synthetic */ zzgqw zzc(zzgoe zzgoe) throws zzgpy {
        return zzglw.zze(zzgoe, zzgoy.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqw) throws GeneralSecurityException {
        zzglw zzglw = (zzglw) zzgqw;
        zzgni.zzb(zzglw.zza(), 0);
        if (zzglw.zzf().zzd() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
