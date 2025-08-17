package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbvv extends zzatq {
    zzbvv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbvk zzbvk, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbvk);
        zza.writeString(str);
        zza.writeString(str2);
        zzbh(2, zza);
    }
}
