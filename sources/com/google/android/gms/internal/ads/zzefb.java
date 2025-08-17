package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

final class zzefb extends zzbpm {
    final /* synthetic */ zzefc zza;
    private final zzecf zzb;

    /* synthetic */ zzefb(zzefc zzefc, zzecf zzecf, zzefa zzefa) {
        this.zza = zzefc;
        this.zzb = zzecf;
    }

    public final void zze(String str) throws RemoteException {
        ((zzedy) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzedy) this.zzb.zzc).zzh(zze);
    }

    public final void zzg(zzbol zzbol) throws RemoteException {
        this.zza.zzc = zzbol;
        ((zzedy) this.zzb.zzc).zzo();
    }
}
