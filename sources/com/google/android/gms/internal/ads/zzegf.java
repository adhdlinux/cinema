package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

final class zzegf extends zzbpp {
    private final zzecf zza;

    /* synthetic */ zzegf(zzegg zzegg, zzecf zzecf, zzege zzege) {
        this.zza = zzecf;
    }

    public final void zze(String str) throws RemoteException {
        ((zzedy) this.zza.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzedy) this.zza.zzc).zzh(zze);
    }

    public final void zzg() throws RemoteException {
        ((zzedy) this.zza.zzc).zzo();
    }
}
