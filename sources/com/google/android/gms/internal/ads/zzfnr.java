package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzfnr extends zzatq implements zzfnt {
    zzfnr(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    public final void zze(Bundle bundle, zzfnv zzfnv) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, bundle);
        zzats.zzf(zza, zzfnv);
        zzbi(2, zza);
    }

    public final void zzf(String str, Bundle bundle, zzfnv zzfnv) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzats.zzd(zza, bundle);
        zzats.zzf(zza, zzfnv);
        zzbi(1, zza);
    }

    public final void zzg(Bundle bundle, zzfnv zzfnv) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, bundle);
        zzats.zzf(zza, zzfnv);
        zzbi(3, zza);
    }
}
