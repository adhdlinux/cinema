package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzbnv;
import com.google.android.gms.internal.ads.zzbnw;

public final class zzcj extends zzatq implements zzcl {
    zzcj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    public final zzbnw getAdapterCreator() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        zzbnw zzf = zzbnv.zzf(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzf;
    }

    public final zzen getLiteSdkVersion() throws RemoteException {
        Parcel zzbg = zzbg(1, zza());
        zzen zzen = (zzen) zzats.zza(zzbg, zzen.CREATOR);
        zzbg.recycle();
        return zzen;
    }
}
