package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbfn extends zzatq implements zzbfp {
    zzbfn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public final void zze(zzbfg zzbfg) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbfg);
        zzbh(1, zza);
    }
}
