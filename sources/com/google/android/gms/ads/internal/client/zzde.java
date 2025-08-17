package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;

public final class zzde extends zzatq implements zzdg {
    zzde(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public final void zze(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzs);
        zzbh(1, zza);
    }

    public final boolean zzf() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }
}
