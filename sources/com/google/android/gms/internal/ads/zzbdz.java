package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbdz extends zzatq {
    zzbdz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzbtd zzbtd) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbtd);
        zzbh(1, zza);
    }
}
