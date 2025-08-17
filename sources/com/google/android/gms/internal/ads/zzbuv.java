package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbuv extends zzatq {
    zzbuv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbuu zzbuu, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbuu);
        zza.writeString(str);
        zza.writeString(str2);
        zzbh(2, zza);
    }
}
