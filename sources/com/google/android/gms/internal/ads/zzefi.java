package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzefi extends zzefh {
    private final zzcgu zza;
    private final zzcuo zzb;
    private final zzdat zzc;
    private final zzefr zzd;
    private final zzech zze;

    zzefi(zzcgu zzcgu, zzcuo zzcuo, zzdat zzdat, zzefr zzefr, zzech zzech) {
        this.zza = zzcgu;
        this.zzb = zzcuo;
        this.zzc = zzdat;
        this.zzd = zzefr;
        this.zze = zzech;
    }

    /* access modifiers changed from: protected */
    public final zzfwm zzc(zzfai zzfai, Bundle bundle, zzezn zzezn, zzezz zzezz) {
        zzcuo zzcuo = this.zzb;
        zzcuo.zzi(zzfai);
        zzcuo.zzf(bundle);
        zzcuo.zzg(new zzcui(zzezz, zzezn, this.zzd));
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdj)).booleanValue()) {
            this.zzb.zzd(this.zze);
        }
        zzcoo zzc2 = this.zza.zzc();
        zzc2.zzd(this.zzb.zzj());
        zzc2.zzc(this.zzc);
        zzcsk zzb2 = zzc2.zze().zzb();
        return zzb2.zzi(zzb2.zzj());
    }
}
