package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public abstract class zzgdn {
    private final zzgnk zza;
    private final Class zzb;

    /* synthetic */ zzgdn(zzgnk zzgnk, Class cls, zzgdm zzgdm) {
        this.zza = zzgnk;
        this.zzb = cls;
    }

    public static zzgdn zzb(zzgdl zzgdl, zzgnk zzgnk, Class cls) {
        return new zzgdk(zzgnk, cls, zzgdl);
    }

    public abstract zzfxn zza(zzgfd zzgfd, zzfyq zzfyq) throws GeneralSecurityException;

    public final zzgnk zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
