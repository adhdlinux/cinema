package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbrr extends zzatq implements zzbrt {
    zzbrr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final boolean zzG() throws RemoteException {
        Parcel zzbg = zzbg(11, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final void zzh(int i2, int i3, Intent intent) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zza.writeInt(i3);
        zzats.zzd(zza, intent);
        zzbh(12, zza);
    }

    public final void zzi() throws RemoteException {
        zzbh(10, zza());
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(13, zza);
    }

    public final void zzl(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, bundle);
        zzbh(1, zza);
    }

    public final void zzm() throws RemoteException {
        zzbh(8, zza());
    }

    public final void zzo() throws RemoteException {
        zzbh(5, zza());
    }

    public final void zzp(int i2, String[] strArr, int[] iArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zza.writeStringArray(strArr);
        zza.writeIntArray(iArr);
        zzbh(15, zza);
    }

    public final void zzq() throws RemoteException {
        zzbh(2, zza());
    }

    public final void zzr() throws RemoteException {
        zzbh(4, zza());
    }

    public final void zzs(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, bundle);
        Parcel zzbg = zzbg(6, zza);
        if (zzbg.readInt() != 0) {
            bundle.readFromParcel(zzbg);
        }
        zzbg.recycle();
    }

    public final void zzt() throws RemoteException {
        zzbh(3, zza());
    }

    public final void zzu() throws RemoteException {
        zzbh(7, zza());
    }

    public final void zzv() throws RemoteException {
        zzbh(14, zza());
    }

    public final void zzx() throws RemoteException {
        zzbh(9, zza());
    }
}
