package com.google.android.gms.cast.framework;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzah extends zza implements zzaj {
    zzah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.IReconnectionService");
    }

    public final int zze(Intent intent, int i2, int i3) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, intent);
        zza.writeInt(i2);
        zza.writeInt(i3);
        Parcel zzb = zzb(2, zza);
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final IBinder zzf(Intent intent) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, intent);
        Parcel zzb = zzb(3, zza);
        IBinder readStrongBinder = zzb.readStrongBinder();
        zzb.recycle();
        return readStrongBinder;
    }

    public final void zzg() throws RemoteException {
        zzc(1, zza());
    }

    public final void zzh() throws RemoteException {
        zzc(4, zza());
    }
}
