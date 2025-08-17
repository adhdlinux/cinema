package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzfkn extends zzatq {
    zzfkn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfkl zze(zzfkj zzfkj) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzfkj);
        Parcel zzbg = zzbg(1, zza);
        zzfkl zzfkl = (zzfkl) zzats.zza(zzbg, zzfkl.CREATOR);
        zzbg.recycle();
        return zzfkl;
    }

    public final zzfku zzf(zzfks zzfks) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzfks);
        Parcel zzbg = zzbg(3, zza);
        zzfku zzfku = (zzfku) zzats.zza(zzbg, zzfku.CREATOR);
        zzbg.recycle();
        return zzfku;
    }

    public final void zzg(zzfkg zzfkg) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzfkg);
        zzbh(2, zza);
    }
}
