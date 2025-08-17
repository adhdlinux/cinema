package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzghc {
    @Deprecated
    static final zzglt zza;
    @Deprecated
    static final zzglt zzb;
    @Deprecated
    static final zzglt zzc;

    static {
        new zzggq();
        zzglt zzc2 = zzglt.zzc();
        zza = zzc2;
        zzb = zzc2;
        zzc = zzc2;
        try {
            zza();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzghh.zze();
        zzggi.zzd();
        zzggq.zzh(true);
        if (!zzgdi.zzb()) {
            zzgfu.zzm(true);
        }
    }
}
