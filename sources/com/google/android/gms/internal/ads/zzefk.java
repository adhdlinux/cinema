package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzefk extends zzefh {
    private final zzcgu zza;
    private final zzcuo zzb;
    private final zzehv zzc;
    private final zzdat zzd;
    private final zzdff zze;
    private final zzcxv zzf;
    private final ViewGroup zzg;
    private final zzdac zzh;
    private final zzefr zzi;
    private final zzech zzj;

    public zzefk(zzcgu zzcgu, zzcuo zzcuo, zzehv zzehv, zzdat zzdat, zzdff zzdff, zzcxv zzcxv, ViewGroup viewGroup, zzdac zzdac, zzefr zzefr, zzech zzech) {
        this.zza = zzcgu;
        this.zzb = zzcuo;
        this.zzc = zzehv;
        this.zzd = zzdat;
        this.zze = zzdff;
        this.zzf = zzcxv;
        this.zzg = viewGroup;
        this.zzh = zzdac;
        this.zzi = zzefr;
        this.zzj = zzech;
    }

    /* access modifiers changed from: protected */
    public final zzfwm zzc(zzfai zzfai, Bundle bundle, zzezn zzezn, zzezz zzezz) {
        zzcuo zzcuo = this.zzb;
        zzcuo.zzi(zzfai);
        zzcuo.zzf(bundle);
        zzcuo.zzg(new zzcui(zzezz, zzezn, this.zzi));
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdj)).booleanValue()) {
            this.zzb.zzd(this.zzj);
        }
        zzcpx zzd2 = this.zza.zzd();
        zzd2.zzi(this.zzb.zzj());
        zzd2.zzf(this.zzd);
        zzd2.zze(this.zzc);
        zzd2.zzd(this.zze);
        zzd2.zzg(new zzcqv(this.zzf, this.zzh));
        zzd2.zzc(new zzcoy(this.zzg));
        zzcsk zzd3 = zzd2.zzk().zzd();
        return zzd3.zzi(zzd3.zzj());
    }
}
