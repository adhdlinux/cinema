package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

public final class zzgea {
    public static final zzgho zza = new zzgdz((zzgdy) null);

    public static zzghu zza(zzfym zzfym) {
        zzfxs zzfxs;
        zzghq zzghq = new zzghq();
        zzghq.zzb(zzfym.zzb());
        for (List it2 : zzfym.zzd()) {
            Iterator it3 = it2.iterator();
            while (true) {
                if (it3.hasNext()) {
                    zzfyi zzfyi = (zzfyi) it3.next();
                    int zzh = zzfyi.zzh() - 2;
                    if (zzh == 1) {
                        zzfxs = zzfxs.zza;
                    } else if (zzh == 2) {
                        zzfxs = zzfxs.zzb;
                    } else if (zzh == 3) {
                        zzfxs = zzfxs.zzc;
                    } else {
                        throw new IllegalStateException("Unknown key status");
                    }
                    int zza2 = zzfyi.zza();
                    String zzf = zzfyi.zzf();
                    if (zzf.startsWith("type.googleapis.com/google.crypto.")) {
                        zzf = zzf.substring(34);
                    }
                    zzghq.zza(zzfxs, zza2, zzf, zzfyi.zzc().name());
                }
            }
        }
        if (zzfym.zza() != null) {
            zzghq.zzc(zzfym.zza().zza());
        }
        try {
            return zzghq.zzd();
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
