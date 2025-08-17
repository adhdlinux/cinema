package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbvi extends zzatq implements zzbvk {
    zzbvi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public final int zze() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        int readInt = zzbg.readInt();
        zzbg.recycle();
        return readInt;
    }

    public final String zzf() throws RemoteException {
        Parcel zzbg = zzbg(1, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }
}
