package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbto extends zzatq implements zzbtq {
    zzbto(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zze(zzbue zzbue, zzbua zzbua) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbue);
        zzats.zzf(zza, zzbua);
        zzbh(6, zza);
    }

    public final void zzf(zzbue zzbue, zzbua zzbua) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbue);
        zzats.zzf(zza, zzbua);
        zzbh(5, zza);
    }

    public final void zzg(zzbue zzbue, zzbua zzbua) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbue);
        zzats.zzf(zza, zzbua);
        zzbh(4, zza);
    }

    public final void zzh(String str, zzbua zzbua) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzats.zzf(zza, zzbua);
        zzbh(7, zza);
    }
}
