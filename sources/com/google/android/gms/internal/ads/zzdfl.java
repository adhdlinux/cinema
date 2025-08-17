package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzdfl implements zzgwe {
    private final zzgwr zza;

    public zzdfl(zzgwr zzgwr) {
        this.zza = zzgwr;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        if (((zzdfi) this.zza).zza().zze() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        zzgwm.zzb(set);
        return set;
    }
}
