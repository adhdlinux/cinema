package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzeen implements zzeci {
    private final Context zza;
    private final zzdeo zzb;

    public zzeen(Context context, zzdeo zzdeo) {
        this.zza = context;
        this.zzb = zzdeo;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan, zzefu {
        zzeeh zzeeh = new zzeeh(zzezn, (zzbpt) zzecf.zzb, AdFormat.INTERSTITIAL);
        zzddo zze = this.zzb.zze(new zzcrs(zzezz, zzezn, zzecf.zza), new zzddr(zzeeh, (zzcez) null));
        zzeeh.zzb(zze.zzc());
        ((zzedy) zzecf.zzc).zzc(zze.zzi());
        return zze.zzg();
    }

    public final void zzb(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan {
        try {
            ((zzbpt) zzecf.zzb).zzq(zzezn.zzaa);
            ((zzbpt) zzecf.zzb).zzl(zzezn.zzV, zzezn.zzw.toString(), zzezz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeem(this, zzecf, (zzeel) null), (zzboc) zzecf.zzc);
        } catch (RemoteException e2) {
            zze.zzb("Remote exception loading a interstitial RTB ad", e2);
            throw new zzfan(e2);
        }
    }
}
