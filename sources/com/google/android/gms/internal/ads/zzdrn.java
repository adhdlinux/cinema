package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

final class zzdrn extends zzbvt {
    final /* synthetic */ zzdrp zza;

    zzdrn(zzdrp zzdrp) {
        this.zza = zzdrp;
    }

    public final void zze(int i2) throws RemoteException {
        zzdrp zzdrp = this.zza;
        zzdrp.zzb.zzm(zzdrp.zza, i2);
    }

    public final void zzf(zze zze) throws RemoteException {
        zzdrp zzdrp = this.zza;
        zzdrp.zzb.zzm(zzdrp.zza, zze.zza);
    }

    public final void zzg() throws RemoteException {
        zzdrp zzdrp = this.zza;
        zzdrp.zzb.zzp(zzdrp.zza);
    }
}
