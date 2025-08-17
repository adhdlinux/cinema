package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public abstract class zzges {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzges(Class cls, Class cls2, zzger zzger) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzges zzb(zzgeq zzgeq, Class cls, Class cls2) {
        return new zzgep(cls, cls2, zzgeq);
    }

    public abstract Object zza(zzfxn zzfxn) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
