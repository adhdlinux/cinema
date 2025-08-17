package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbjf extends zzatr implements zzbjg {
    public zzbjf() {
        super("com.google.android.gms.ads.internal.h5.client.IH5AdsEventListener");
    }

    public static zzbjg zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsEventListener");
        if (queryLocalInterface instanceof zzbjg) {
            return (zzbjg) queryLocalInterface;
        }
        return new zzbje(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        String readString = parcel.readString();
        zzats.zzc(parcel);
        zzb(readString);
        parcel2.writeNoException();
        return true;
    }
}
