package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbod extends zzatq implements zzbof {
    zzbod(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    public final IObjectWrapper zze() throws RemoteException {
        Parcel zzbg = zzbg(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbg.readStrongBinder());
        zzbg.recycle();
        return asInterface;
    }

    public final boolean zzf() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }
}
