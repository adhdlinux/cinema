package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzcgr extends zzatq implements zzcgt {
    zzcgr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.measurement.IMeasurementManager");
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzcgq zzcgq) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzcgq);
        zzbh(2, zza);
    }
}
