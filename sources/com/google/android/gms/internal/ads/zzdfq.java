package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzdfq implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;

    public zzdfq(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4, zzgwr zzgwr5, zzgwr zzgwr6) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
        this.zze = zzgwr5;
        this.zzf = zzgwr6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcuo zza2 = ((zzcuy) this.zzb).zza();
        zzdat zza3 = ((zzdbm) this.zzc).zza();
        zzdff zza4 = ((zzdfh) this.zzd).zza();
        zzcxv zza5 = ((zzcpa) this.zze).zzb();
        zzefr zzefr = (zzefr) this.zzf.zzb();
        zzcpx zzd2 = ((zzcgu) this.zza.zzb()).zzd();
        zzd2.zzi(zza2.zzj());
        zzd2.zzf(zza3);
        zzd2.zzd(zza4);
        zzd2.zze(new zzehv((zzbck) null));
        zzd2.zzg(new zzcqv(zza5, (zzdac) null));
        zzd2.zzc(new zzcoy((ViewGroup) null));
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdm)).booleanValue()) {
            zzd2.zzj(zzefy.zzb(zzefr));
        }
        zzcrg zzc2 = zzd2.zzk().zzc();
        zzgwm.zzb(zzc2);
        return zzc2;
    }
}
