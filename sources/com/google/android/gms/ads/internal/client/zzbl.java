package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;

public final class zzbl extends zzatq implements zzbn {
    zzbl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final String zze() throws RemoteException {
        throw null;
    }

    public final String zzf() throws RemoteException {
        throw null;
    }

    public final void zzg(zzl zzl) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzl);
        zzbh(1, zza);
    }

    public final void zzh(zzl zzl, int i2) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzl);
        zza.writeInt(i2);
        zzbh(5, zza);
    }

    public final boolean zzi() throws RemoteException {
        Parcel zzbg = zzbg(3, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }
}
