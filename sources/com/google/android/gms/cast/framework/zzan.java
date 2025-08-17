package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzan extends zza implements zzao {
    zzan(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISessionManager");
    }

    public final int zze() throws RemoteException {
        Parcel zzb = zzb(8, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final IObjectWrapper zzf() throws RemoteException {
        Parcel zzb = zzb(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzg() throws RemoteException {
        Parcel zzb = zzb(7, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    public final void zzh(zzae zzae) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzae);
        zzc(4, zza);
    }

    public final void zzi(zzaq zzaq) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzaq);
        zzc(2, zza);
    }

    public final void zzj(boolean z2, boolean z3) throws RemoteException {
        Parcel zza = zza();
        int i2 = zzc.zza;
        zza.writeInt(1);
        zza.writeInt(z3 ? 1 : 0);
        zzc(6, zza);
    }

    public final void zzk(zzae zzae) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzae);
        zzc(5, zza);
    }

    public final void zzl(zzaq zzaq) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzaq);
        zzc(3, zza);
    }

    public final void zzm(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, bundle);
        zzc(9, zza);
    }
}
