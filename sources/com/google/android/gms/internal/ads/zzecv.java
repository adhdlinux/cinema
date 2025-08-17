package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzecv implements zzeci {
    private final Context zza;
    private final zzcop zzb;

    zzecv(Context context, zzcop zzcop) {
        this.zza = context;
        this.zzb = zzcop;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan, zzefu {
        zzeeh zzeeh = new zzeeh(zzezn, (zzbpt) zzecf.zzb, AdFormat.APP_OPEN_AD);
        zzcom zza2 = this.zzb.zza(new zzcrs(zzezz, zzezn, zzecf.zza), new zzddr(zzeeh, (zzcez) null), new zzcon(zzezn.zzab));
        zzeeh.zzb(zza2.zzc());
        ((zzedy) zzecf.zzc).zzc(zza2.zzi());
        return zza2.zza();
    }

    public final void zzb(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan {
        try {
            ((zzbpt) zzecf.zzb).zzq(zzezn.zzaa);
            ((zzbpt) zzecf.zzb).zzi(zzezn.zzV, zzezn.zzw.toString(), zzezz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzecu(zzecf, (zzect) null), (zzboc) zzecf.zzc);
        } catch (RemoteException e2) {
            zze.zzb("Remote exception loading an app open RTB ad", e2);
            throw new zzfan(e2);
        }
    }
}
