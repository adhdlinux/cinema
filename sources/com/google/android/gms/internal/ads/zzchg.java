package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Set;

public final class zzchg implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzchg(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzdse zzdse = (zzdse) this.zza.zzb();
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbz)).booleanValue()) {
            set = Collections.singleton(new zzdcm(zzdse, zzfwn));
        } else {
            set = Collections.emptySet();
        }
        zzgwm.zzb(set);
        return set;
    }
}
