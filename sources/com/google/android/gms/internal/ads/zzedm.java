package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzedm extends zzbpg {
    final /* synthetic */ zzedn zza;
    private final zzecf zzb;

    /* synthetic */ zzedm(zzedn zzedn, zzecf zzecf, zzedl zzedl) {
        this.zza = zzedn;
        this.zzb = zzecf;
    }

    public final void zze(String str) throws RemoteException {
        ((zzedy) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzedy) this.zzb.zzc).zzh(zze);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzc = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzedy) this.zzb.zzc).zzo();
    }

    public final void zzh(zzbof zzbof) throws RemoteException {
        this.zza.zzd = zzbof;
        ((zzedy) this.zzb.zzc).zzo();
    }
}
