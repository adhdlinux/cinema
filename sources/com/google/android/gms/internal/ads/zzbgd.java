package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbgd extends zzatq implements zzbgf {
    zzbgd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public final void zze(zzbgo zzbgo) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbgo);
        zzbh(1, zza);
    }
}
