package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public abstract class zzgek {
    private final zzgnk zza;
    private final Class zzb;

    /* synthetic */ zzgek(zzgnk zzgnk, Class cls, zzgej zzgej) {
        this.zza = zzgnk;
        this.zzb = cls;
    }

    public static zzgek zzb(zzgei zzgei, zzgnk zzgnk, Class cls) {
        return new zzgeh(zzgnk, cls, zzgei);
    }

    public abstract zzfyf zza(zzgfd zzgfd) throws GeneralSecurityException;

    public final zzgnk zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
