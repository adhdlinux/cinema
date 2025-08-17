package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.List;

public final class zzggi implements zzfyn {
    private static final zzggi zza = new zzggi();

    private zzggi() {
    }

    static void zzd() throws GeneralSecurityException {
        zzfyp.zzf(zza);
    }

    public final Class zza() {
        return zzggf.class;
    }

    public final Class zzb() {
        return zzggf.class;
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzfym zzfym) throws GeneralSecurityException {
        if (zzfym.zza() != null) {
            for (List<zzfyi> it2 : zzfym.zzd()) {
                for (zzfyi zzd : it2) {
                    zzd.zzd();
                }
            }
            return new zzggh(zzfym, (zzggg) null);
        }
        throw new GeneralSecurityException("no primary in primitive set");
    }
}
