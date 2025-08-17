package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbci extends zzatq implements zzbck {
    zzbci(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public final void zze(zzbch zzbch) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbch);
        zzbh(1, zza);
    }
}
