package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;

public final class zzaf extends zza implements zzag {
    zzaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.IDiscoveryManager");
    }

    public final IObjectWrapper zze() throws RemoteException {
        Parcel zzb = zzb(5, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }
}
