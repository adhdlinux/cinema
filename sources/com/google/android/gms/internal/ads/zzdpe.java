package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class zzdpe implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;

    public zzdpe(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        String str = (String) this.zza.zzb();
        Context zza2 = ((zzcha) this.zzb).zza();
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        Map zzd2 = ((zzgwi) this.zzd).zzb();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeG)).booleanValue()) {
            zzawz zzawz = new zzawz(new zzaxf(zza2));
            zzawz.zzb(new zzdpf(str));
            set = Collections.singleton(new zzdcm(new zzdph(zzawz, zzd2), zzfwn));
        } else {
            set = Collections.emptySet();
        }
        zzgwm.zzb(set);
        return set;
    }
}
