package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzefm extends zzefh {
    private final zzcgu zza;
    private final zzcuo zzb;
    private final zzehv zzc;
    private final zzdat zzd;
    private final zzefr zze;
    private final zzech zzf;

    public zzefm(zzcgu zzcgu, zzcuo zzcuo, zzehv zzehv, zzdat zzdat, zzefr zzefr, zzech zzech) {
        this.zza = zzcgu;
        this.zzb = zzcuo;
        this.zzc = zzehv;
        this.zzd = zzdat;
        this.zze = zzefr;
        this.zzf = zzech;
    }

    /* access modifiers changed from: protected */
    public final zzfwm zzc(zzfai zzfai, Bundle bundle, zzezn zzezn, zzezz zzezz) {
        zzcuo zzcuo = this.zzb;
        zzcuo.zzi(zzfai);
        zzcuo.zzf(bundle);
        zzcuo.zzg(new zzcui(zzezz, zzezn, this.zze));
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdj)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzden zzf2 = this.zza.zzf();
        zzf2.zze(this.zzb.zzj());
        zzf2.zzd(this.zzd);
        zzf2.zzc(this.zzc);
        zzcsk zza2 = zzf2.zzf().zza();
        return zza2.zzi(zza2.zzj());
    }
}
