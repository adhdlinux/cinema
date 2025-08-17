package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Set;

public final class zzchf implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzchf(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzdzf zzdzf = (zzdzf) this.zza.zzb();
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbS)).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
                set = Collections.singleton(new zzdcm(zzdzf, zzfwn));
                zzgwm.zzb(set);
                return set;
            }
        }
        set = Collections.emptySet();
        zzgwm.zzb(set);
        return set;
    }
}
