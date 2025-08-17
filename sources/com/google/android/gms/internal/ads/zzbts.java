package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbts extends zzatq implements zzbtu {
    zzbts(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdsService");
    }

    public final void zze(zzbtm zzbtm, zzbtx zzbtx) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbtm);
        zzats.zzf(zza, zzbtx);
        zzbh(3, zza);
    }

    public final void zzf(zzbti zzbti, zzbtx zzbtx) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbti);
        zzats.zzf(zza, zzbtx);
        zzbh(1, zza);
    }
}
