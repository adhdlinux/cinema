package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

final class zzeem extends zzbpj {
    private final zzecf zza;

    /* synthetic */ zzeem(zzeen zzeen, zzecf zzecf, zzeel zzeel) {
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
