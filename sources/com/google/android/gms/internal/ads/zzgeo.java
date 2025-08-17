package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public abstract class zzgeo {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgeo(Class cls, Class cls2, zzgen zzgen) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgeo zzb(zzgem zzgem, Class cls, Class cls2) {
        return new zzgel(cls, cls2, zzgem);
    }

    public abstract zzgfd zza(zzfyf zzfyf) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
