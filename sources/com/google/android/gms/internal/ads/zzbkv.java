package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbkv extends zzatq implements zzbkx {
    zzbkv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    public final void zze(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzbh(2, zza);
    }

    public final void zzf() throws RemoteException {
        zzbh(1, zza());
    }
}
