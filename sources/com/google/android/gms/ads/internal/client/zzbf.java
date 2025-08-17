package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;

public final class zzbf extends zzatq implements zzbh {
    zzbf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void zzc() throws RemoteException {
        zzbh(6, zza());
    }

    public final void zzd() throws RemoteException {
        zzbh(1, zza());
    }

    public final void zze(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzbh(2, zza);
    }

    public final void zzf(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zze);
        zzbh(8, zza);
    }

    public final void zzg() throws RemoteException {
        zzbh(7, zza());
    }

    public final void zzh() throws RemoteException {
        zzbh(3, zza());
    }

    public final void zzi() throws RemoteException {
        zzbh(4, zza());
    }

    public final void zzj() throws RemoteException {
        zzbh(5, zza());
    }

    public final void zzk() throws RemoteException {
        zzbh(9, zza());
    }
}
