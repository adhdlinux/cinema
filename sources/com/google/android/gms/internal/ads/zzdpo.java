package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

public final class zzdpo implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzdpo(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdpl zzdpl = (zzdpl) this.zza.zzb();
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        zzdzd zzdzd = (zzdzd) this.zzc.zzb();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
            return new zzdcm(zzdzd, zzfwn);
        }
        return new zzdcm(zzdpl, zzfwn);
    }
}
