package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbjy extends zzatq {
    zzbjy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzbjs zzbjs, zzbjx zzbjx) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbjs);
        zzats.zzf(zza, zzbjx);
        zzbi(2, zza);
    }
}
