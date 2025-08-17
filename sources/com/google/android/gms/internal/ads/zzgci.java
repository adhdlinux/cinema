package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzgci extends zzgdt {
    final /* synthetic */ zzgcj zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgci(zzgcj zzgcj, Class cls) {
        super(cls);
        this.zza = zzgcj;
    }

    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqw) throws GeneralSecurityException {
        zzglk zzc = zzgll.zzc();
        zzc.zza((zzglo) zzgqw);
        zzc.zzb(0);
        return (zzgll) zzc.zzal();
    }

    public final /* synthetic */ zzgqw zzb(zzgoe zzgoe) throws zzgpy {
        return zzglo.zze(zzgoe, zzgoy.zza());
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqw) throws GeneralSecurityException {
        zzglo zzglo = (zzglo) zzgqw;
        if (zzglo.zzf().isEmpty() || !zzglo.zzg()) {
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
    }
}
