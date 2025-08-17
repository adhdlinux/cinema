package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbga extends zzatq implements zzbgc {
    zzbga(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    public final void zze(zzbu zzbu, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbu);
        zzats.zzf(zza, iObjectWrapper);
        zzbh(1, zza);
    }
}
