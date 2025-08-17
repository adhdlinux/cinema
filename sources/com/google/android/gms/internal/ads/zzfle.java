package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzfle extends zzatq implements zzflg {
    zzfle(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    public final void zze(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeString((String) null);
        zzbh(8, zza);
    }

    public final void zzf() throws RemoteException {
        zzbh(3, zza());
    }

    public final void zzg(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzbh(7, zza);
    }

    public final void zzh(int[] iArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeIntArray((int[]) null);
        zzbh(4, zza);
    }

    public final void zzi(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzbh(6, zza);
    }

    public final void zzj(byte[] bArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeByteArray(bArr);
        zzbh(5, zza);
    }
}
