package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzak extends zza implements zzam {
    zzak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISession");
    }

    public final int zze() throws RemoteException {
        Parcel zzb = zzb(17, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final int zzf() throws RemoteException {
        Parcel zzb = zzb(18, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final IObjectWrapper zzg() throws RemoteException {
        Parcel zzb = zzb(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    public final String zzh() throws RemoteException {
        Parcel zzb = zzb(2, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final String zzi() throws RemoteException {
        Parcel zzb = zzb(3, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final void zzj(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzc(15, zza);
    }

    public final void zzk(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzc(12, zza);
    }

    public final void zzl(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzc(13, zza);
    }

    public final void zzm(boolean z2) throws RemoteException {
        Parcel zza = zza();
        int i2 = zzc.zza;
        zza.writeInt(z2 ? 1 : 0);
        zzc(14, zza);
    }

    public final void zzn(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(11, zza);
    }

    public final void zzo(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzc(16, zza);
    }

    public final boolean zzp() throws RemoteException {
        Parcel zzb = zzb(5, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }

    public final boolean zzq() throws RemoteException {
        Parcel zzb = zzb(6, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }

    public final boolean zzr() throws RemoteException {
        Parcel zzb = zzb(8, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }

    public final boolean zzs() throws RemoteException {
        Parcel zzb = zzb(7, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }

    public final boolean zzt() throws RemoteException {
        Parcel zzb = zzb(9, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }

    public final boolean zzu() throws RemoteException {
        Parcel zzb = zzb(10, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }
}
