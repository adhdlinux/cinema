package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzegc implements zzeci {
    private final Context zza;
    private final Executor zzb;
    private final zzdmr zzc;

    public zzegc(Context context, Executor executor, zzdmr zzdmr) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdmr;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan, zzefu {
        zzdmn zze = this.zzc.zze(new zzcrs(zzezz, zzezn, zzecf.zza), new zzdmo(new zzegb(zzecf)));
        zze.zzd().zzm(new zzcnd((zzfbd) zzecf.zzb), this.zzb);
        ((zzedy) zzecf.zzc).zzc(zze.zzm());
        return zze.zzk();
    }

    public final void zzb(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan {
        try {
            zzfai zzfai = zzezz.zza.zza;
            if (zzfai.zzo.zza == 3) {
                ((zzfbd) zzecf.zzb).zzr(this.zza, zzfai.zzd, zzezn.zzw.toString(), (zzboc) zzecf.zzc);
            } else {
                ((zzfbd) zzecf.zzb).zzq(this.zza, zzfai.zzd, zzezn.zzw.toString(), (zzboc) zzecf.zzc);
            }
        } catch (Exception e2) {
            zzbzr.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzecf.zza)), e2);
        }
    }
}
