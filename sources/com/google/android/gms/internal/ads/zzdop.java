package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Set;

public final class zzdop implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzdop(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        zzdph zza2 = ((zzdpi) this.zzb).zzb();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeG)).booleanValue()) {
            set = Collections.singleton(new zzdcm(zza2, zzfwn));
        } else {
            set = Collections.emptySet();
        }
        zzgwm.zzb(set);
        return set;
    }
}
