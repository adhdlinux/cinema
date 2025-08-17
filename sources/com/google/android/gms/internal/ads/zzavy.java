package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public final class zzavy extends zzatq implements zzawa {
    zzavy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    public final void zzb() throws RemoteException {
        zzbh(5, zza());
    }

    public final void zzc() throws RemoteException {
        zzbh(2, zza());
    }

    public final void zzd(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zze);
        zzbh(3, zza);
    }

    public final void zze() throws RemoteException {
        zzbh(4, zza());
    }

    public final void zzf() throws RemoteException {
        zzbh(1, zza());
    }
}
