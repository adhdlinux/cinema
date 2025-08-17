package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public final class zzbyg extends zzatq implements zzbyi {
    zzbyg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzbym zzbym, zzbyf zzbyf) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzbym);
        zzats.zzf(zza, zzbyf);
        zzbh(1, zza);
    }

    public final void zzf(zzbsr zzbsr) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbsr);
        zzbh(7, zza);
    }

    public final void zzg(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsi) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbsi);
        zzbh(10, zza);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsi) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbsi);
        zzbh(9, zza);
    }

    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(8, zza);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(2, zza);
    }

    public final void zzk(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsi) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbsi);
        zzbh(6, zza);
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsi) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbsi);
        zzbh(5, zza);
    }
}
