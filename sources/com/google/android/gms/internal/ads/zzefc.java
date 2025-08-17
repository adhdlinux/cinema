package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzefc implements zzeci {
    private final Context zza;
    private final zzdfk zzb;
    /* access modifiers changed from: private */
    public zzbol zzc;
    private final zzbzx zzd;

    public zzefc(Context context, zzdfk zzdfk, zzbzx zzbzx) {
        this.zza = context;
        this.zzb = zzdfk;
        this.zzd = zzbzx;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan, zzefu {
        if (zzezz.zza.zza.zzg.contains(Integer.toString(6))) {
            zzdha zzs = zzdha.zzs(this.zzc);
            if (zzezz.zza.zza.zzg.contains(Integer.toString(zzs.zzc()))) {
                zzdhc zze = this.zzb.zze(new zzcrs(zzezz, zzezn, zzecf.zza), new zzdhm(zzs), new zzdjb((zzboi) null, (zzboh) null, this.zzc));
                ((zzedy) zzecf.zzc).zzc(zze.zzi());
                return zze.zza();
            }
            throw new zzefu(1, "No corresponding native ad listener");
        }
        throw new zzefu(2, "Unified must be used for RTB.");
    }

    public final void zzb(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan {
        try {
            ((zzbpt) zzecf.zzb).zzq(zzezn.zzaa);
            if (this.zzd.zzc < ((Integer) zzba.zzc().zzb(zzbbm.zzbB)).intValue()) {
                ((zzbpt) zzecf.zzb).zzm(zzezn.zzV, zzezn.zzw.toString(), zzezz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzefb(this, zzecf, (zzefa) null), (zzboc) zzecf.zzc);
            } else {
                ((zzbpt) zzecf.zzb).zzn(zzezn.zzV, zzezn.zzw.toString(), zzezz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzefb(this, zzecf, (zzefa) null), (zzboc) zzecf.zzc, zzezz.zza.zza.zzi);
            }
        } catch (RemoteException e2) {
            throw new zzfan(e2);
        }
    }
}
