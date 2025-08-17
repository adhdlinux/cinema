package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbrk extends zzatq implements zzbrm {
    zzbrk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public final void zze(Intent intent) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, intent);
        zzbh(1, zza);
    }

    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeStringArray(strArr);
        zza.writeIntArray(iArr);
        zzats.zzf(zza, iObjectWrapper);
        zzbh(5, zza);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(4, zza);
    }

    public final void zzh() throws RemoteException {
        zzbh(3, zza());
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeString(str2);
        zzbh(2, zza);
    }
}
