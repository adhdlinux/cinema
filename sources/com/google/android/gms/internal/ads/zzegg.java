package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzegg implements zzeci {
    private final Context zza;
    private final zzdmr zzb;

    public zzegg(Context context, zzdmr zzdmr) {
        this.zza = context;
        this.zzb = zzdmr;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan, zzefu {
        zzeeh zzeeh = new zzeeh(zzezn, (zzbpt) zzecf.zzb, AdFormat.REWARDED);
        zzdmn zze = this.zzb.zze(new zzcrs(zzezz, zzezn, zzecf.zza), new zzdmo(zzeeh));
        zzeeh.zzb(zze.zzc());
        ((zzedy) zzecf.zzc).zzc(zze.zzn());
        return zze.zzk();
    }

    public final void zzb(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan {
        try {
            ((zzbpt) zzecf.zzb).zzq(zzezn.zzaa);
            if (zzezz.zza.zza.zzo.zza == 3) {
                ((zzbpt) zzecf.zzb).zzo(zzezn.zzV, zzezn.zzw.toString(), zzezz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzegf(this, zzecf, (zzege) null), (zzboc) zzecf.zzc);
            } else {
                ((zzbpt) zzecf.zzb).zzp(zzezn.zzV, zzezn.zzw.toString(), zzezz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzegf(this, zzecf, (zzege) null), (zzboc) zzecf.zzc);
            }
        } catch (RemoteException e2) {
            zze.zzb("Remote exception loading a rewarded RTB ad", e2);
        }
    }
}
