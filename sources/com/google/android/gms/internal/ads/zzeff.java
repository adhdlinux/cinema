package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzeff extends zzefh {
    private final zzcgu zza;
    private final zzdff zzb;
    private final zzcuo zzc;
    private final zzdat zzd;
    private final zzefr zze;
    private final zzech zzf;

    public zzeff(zzcgu zzcgu, zzdff zzdff, zzcuo zzcuo, zzdat zzdat, zzefr zzefr, zzech zzech) {
        this.zza = zzcgu;
        this.zzb = zzdff;
        this.zzc = zzcuo;
        this.zzd = zzdat;
        this.zze = zzefr;
        this.zzf = zzech;
    }

    /* access modifiers changed from: protected */
    public final zzfwm zzc(zzfai zzfai, Bundle bundle, zzezn zzezn, zzezz zzezz) {
        zzcuo zzcuo = this.zzc;
        zzcuo.zzi(zzfai);
        zzcuo.zzf(bundle);
        zzcuo.zzg(new zzcui(zzezz, zzezn, this.zze));
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdj)).booleanValue()) {
            this.zzc.zzd(this.zzf);
        }
        zzdfj zzg = this.zza.zzg();
        zzg.zzf(this.zzc.zzj());
        zzg.zze(this.zzd);
        zzg.zzd(this.zzb);
        zzg.zzc(new zzcoy((ViewGroup) null));
        zzcsk zza2 = zzg.zzg().zza();
        return zza2.zzi(zza2.zzj());
    }
}
