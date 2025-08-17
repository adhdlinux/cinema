package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzawn extends zzatq {
    zzawn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzawl zzawl) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzawl);
        Parcel zzbg = zzbg(3, zza);
        long readLong = zzbg.readLong();
        zzbg.recycle();
        return readLong;
    }

    public final zzawi zzf(zzawl zzawl) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzawl);
        Parcel zzbg = zzbg(1, zza);
        zzawi zzawi = (zzawi) zzats.zza(zzbg, zzawi.CREATOR);
        zzbg.recycle();
        return zzawi;
    }

    public final zzawi zzg(zzawl zzawl) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzawl);
        Parcel zzbg = zzbg(2, zza);
        zzawi zzawi = (zzawi) zzats.zza(zzbg, zzawi.CREATOR);
        zzbg.recycle();
        return zzawi;
    }
}
