package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbfw extends zzatq implements zzbfy {
    zzbfw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public final void zze(zzbfl zzbfl) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbfl);
        zzbh(1, zza);
    }
}
