package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public final class zzbvo extends zzatq implements zzbvq {
    zzbvo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    public final void zze() throws RemoteException {
        zzbh(7, zza());
    }

    public final void zzf() throws RemoteException {
        zzbh(6, zza());
    }

    public final void zzg() throws RemoteException {
        zzbh(2, zza());
    }

    public final void zzh(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzbh(4, zza);
    }

    public final void zzi(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zze);
        zzbh(5, zza);
    }

    public final void zzj() throws RemoteException {
        zzbh(1, zza());
    }

    public final void zzk(zzbvk zzbvk) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbvk);
        zzbh(3, zza);
    }
}
