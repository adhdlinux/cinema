package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzegy implements zzeci {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzdmr zzc;

    public zzegy(Context context, Executor executor, zzdmr zzdmr) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdmr;
    }

    /* access modifiers changed from: private */
    public static final void zze(zzezz zzezz, zzezn zzezn, zzecf zzecf) {
        try {
            ((zzfbd) zzecf.zzb).zzk(zzezz.zza.zza.zzd, zzezn.zzw.toString());
        } catch (Exception e2) {
            zzbzr.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzecf.zza)), e2);
        }
    }

    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan, zzefu {
        zzdmn zze = this.zzc.zze(new zzcrs(zzezz, zzezn, zzecf.zza), new zzdmo(new zzegu(zzecf)));
        zze.zzd().zzm(new zzcnd((zzfbd) zzecf.zzb), this.zzb);
        zzcwn zze2 = zze.zze();
        zzcve zzb2 = zze.zzb();
        ((zzedz) zzecf.zzc).zzc(new zzegx(this, zze.zza(), zzb2, zze2, zze.zzg()));
        return zze.zzk();
    }

    public final void zzb(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan {
        if (!((zzfbd) zzecf.zzb).zzC()) {
            ((zzedz) zzecf.zzc).zzd(new zzegw(this, zzezz, zzezn, zzecf));
            ((zzfbd) zzecf.zzb).zzh(this.zza, zzezz.zza.zza.zzd, (String) null, (zzbvf) zzecf.zzc, zzezn.zzw.toString());
            return;
        }
        zze(zzezz, zzezn, zzecf);
    }
}
