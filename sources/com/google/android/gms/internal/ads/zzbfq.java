package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbfq extends zzatq implements zzbfs {
    zzbfq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public final void zze(zzbfi zzbfi) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbfi);
        zzbh(1, zza);
    }
}
