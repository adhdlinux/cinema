package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzgfa implements zzgfd {
    private final String zza;
    private final zzgnk zzb;
    private final zzgoe zzc;
    private final zzgkj zzd;
    private final zzglq zze;
    private final Integer zzf;

    private zzgfa(String str, zzgoe zzgoe, zzgkj zzgkj, zzglq zzglq, Integer num) {
        this.zza = str;
        this.zzb = zzgfm.zza(str);
        this.zzc = zzgoe;
        this.zzd = zzgkj;
        this.zze = zzglq;
        this.zzf = num;
    }

    public static zzgfa zza(String str, zzgoe zzgoe, zzgkj zzgkj, zzglq zzglq, Integer num) throws GeneralSecurityException {
        if (zzglq == zzglq.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzgfa(str, zzgoe, zzgkj, zzglq, num);
    }

    public final zzgkj zzb() {
        return this.zzd;
    }

    public final zzglq zzc() {
        return this.zze;
    }

    public final zzgnk zzd() {
        return this.zzb;
    }

    public final zzgoe zze() {
        return this.zzc;
    }

    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
