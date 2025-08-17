package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

public final class zzcoe implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzcoe(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzcnx zzcnx = (zzcnx) this.zza.zzb();
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        if (((JSONObject) this.zzc.zzb()) == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzdcm(zzcnx, zzfwn));
        }
        zzgwm.zzb(set);
        return set;
    }
}
