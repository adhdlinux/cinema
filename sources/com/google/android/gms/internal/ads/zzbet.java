package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbet extends zzatq implements zzbev {
    zzbet(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public final IObjectWrapper zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzbg = zzbg(2, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbg.readStrongBinder());
        zzbg.recycle();
        return asInterface;
    }

    public final void zzbs(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzats.zzf(zza, iObjectWrapper);
        zzbh(1, zza);
    }

    public final void zzbt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(6, zza);
    }

    public final void zzbu(zzbeo zzbeo) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbeo);
        zzbh(8, zza);
    }

    public final void zzbv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(9, zza);
    }

    public final void zzbw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(3, zza);
    }

    public final void zzc() throws RemoteException {
        zzbh(4, zza());
    }

    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(7, zza);
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zza.writeInt(i2);
        zzbh(5, zza);
    }
}
