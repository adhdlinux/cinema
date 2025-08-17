package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzecr implements zzeci {
    private final Context zza;
    private final zzcop zzb;
    private final Executor zzc;

    zzecr(Context context, zzcop zzcop, Executor executor) {
        this.zza = context;
        this.zzb = zzcop;
        this.zzc = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan, zzefu {
        zzcom zza2 = this.zzb.zza(new zzcrs(zzezz, zzezn, zzecf.zza), new zzddr(new zzecq(zzecf), (zzcez) null), new zzcon(zzezn.zzab));
        zza2.zzd().zzm(new zzcnd((zzfbd) zzecf.zzb), this.zzc);
        ((zzedy) zzecf.zzc).zzc(zza2.zzj());
        return zza2.zza();
    }

    public final void zzb(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan {
        ((zzfbd) zzecf.zzb).zzl(this.zza, zzezz.zza.zza.zzd, zzezn.zzw.toString(), (zzboc) zzecf.zzc);
    }
}
