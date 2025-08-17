package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzefo extends zzefh {
    private final zzcgu zza;
    private final zzcuo zzb;
    private final zzdat zzc;
    private final zzefr zzd;
    private final zzfaa zze;
    private final zzech zzf;

    public zzefo(zzcgu zzcgu, zzcuo zzcuo, zzdat zzdat, zzfaa zzfaa, zzefr zzefr, zzech zzech) {
        this.zza = zzcgu;
        this.zzb = zzcuo;
        this.zzc = zzdat;
        this.zze = zzfaa;
        this.zzd = zzefr;
        this.zzf = zzech;
    }

    /* access modifiers changed from: protected */
    public final zzfwm zzc(zzfai zzfai, Bundle bundle, zzezn zzezn, zzezz zzezz) {
        zzfaa zzfaa;
        zzcuo zzcuo = this.zzb;
        zzcuo.zzi(zzfai);
        zzcuo.zzf(bundle);
        zzcuo.zzg(new zzcui(zzezz, zzezn, this.zzd));
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdi)).booleanValue() && (zzfaa = this.zze) != null) {
            this.zzb.zzh(zzfaa);
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdj)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzdmq zzh = this.zza.zzh();
        zzh.zzd(this.zzb.zzj());
        zzh.zzc(this.zzc);
        zzcsk zzb2 = zzh.zze().zzb();
        return zzb2.zzi(zzb2.zzj());
    }
}
