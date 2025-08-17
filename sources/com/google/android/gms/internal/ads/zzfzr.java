package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzfzr extends zzgdt {
    final /* synthetic */ zzfzs zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfzr(zzfzs zzfzs, Class cls) {
        super(cls);
        this.zza = zzfzs;
    }

    public static final zzgin zzf(zzgiq zzgiq) throws GeneralSecurityException {
        zzgim zzc = zzgin.zzc();
        zzc.zzb(zzgiq.zzg());
        byte[] zza2 = zzgng.zza(zzgiq.zza());
        zzc.zza(zzgoe.zzv(zza2, 0, zza2.length));
        zzc.zzc(0);
        return (zzgin) zzc.zzal();
    }

    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqw) throws GeneralSecurityException {
        return zzf((zzgiq) zzgqw);
    }

    public final /* synthetic */ zzgqw zzb(zzgoe zzgoe) throws zzgpy {
        return zzgiq.zzf(zzgoe, zzgoy.zza());
    }

    /* renamed from: zze */
    public final void zzd(zzgiq zzgiq) throws GeneralSecurityException {
        zzgni.zza(zzgiq.zza());
        zzfzs.zzm(zzgiq.zzg());
    }
}
