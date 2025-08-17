package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

public final class zzdpq implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzdpq(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdqd zzdqd = (zzdqd) this.zza.zzb();
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        zzdzk zzdzk = (zzdzk) this.zzc.zzb();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
            return new zzdcm(zzdzk, zzfwn);
        }
        return new zzdcm(zzdqd, zzfwn);
    }
}
