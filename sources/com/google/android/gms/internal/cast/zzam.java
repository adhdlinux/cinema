package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzam extends zza implements zzan {
    zzam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
    }

    public final int zze() throws RemoteException {
        Parcel zzb = zzb(7, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final void zzf(String str, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, bundle);
        zzc(1, zza);
    }

    public final void zzg(String str, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, bundle);
        zzc(2, zza);
    }

    public final void zzh(String str, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, bundle);
        zzc(3, zza);
    }

    public final void zzi(String str, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, bundle);
        zzc(4, zza);
    }

    public final void zzj(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, bundle);
        zzc(8, zza);
    }

    public final void zzk(String str, Bundle bundle, int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, bundle);
        zza.writeInt(i2);
        zzc(6, zza);
    }
}
