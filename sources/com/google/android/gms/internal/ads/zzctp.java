package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

public final class zzctp implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzctp(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdpj zzdpj = (zzdpj) this.zza.zzb();
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        zzdzb zzdzb = (zzdzb) this.zzc.zzb();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
            return new zzdcm(zzdzb, zzfwn);
        }
        return new zzdcm(zzdpj, zzfwn);
    }
}
