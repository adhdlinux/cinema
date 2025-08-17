package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbu;
import java.util.concurrent.Executor;

public final class zzeej implements zzeci {
    private final Context zza;
    private final zzdeo zzb;
    private final zzbzx zzc;
    private final Executor zzd;

    public zzeej(Context context, zzbzx zzbzx, zzdeo zzdeo, Executor executor) {
        this.zza = context;
        this.zzc = zzbzx;
        this.zzb = zzdeo;
        this.zzd = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan, zzefu {
        zzddo zze = this.zzb.zze(new zzcrs(zzezz, zzezn, zzecf.zza), new zzddr(new zzeei(this, zzecf), (zzcez) null));
        zze.zzd().zzm(new zzcnd((zzfbd) zzecf.zzb), this.zzd);
        ((zzedy) zzecf.zzc).zzc(zze.zzj());
        return zze.zzg();
    }

    public final void zzb(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan {
        ((zzfbd) zzecf.zzb).zzo(this.zza, zzezz.zza.zza.zzd, zzezn.zzw.toString(), zzbu.zzl(zzezn.zzt), (zzboc) zzecf.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzecf zzecf, boolean z2, Context context, zzcvt zzcvt) throws zzdev {
        try {
            ((zzfbd) zzecf.zzb).zzv(z2);
            if (this.zzc.zzc < ((Integer) zzba.zzc().zzb(zzbbm.zzaE)).intValue()) {
                ((zzfbd) zzecf.zzb).zzx();
            } else {
                ((zzfbd) zzecf.zzb).zzy(context);
            }
        } catch (zzfan e2) {
            zzbzr.zzi("Cannot show interstitial.");
            throw new zzdev(e2.getCause());
        }
    }
}
