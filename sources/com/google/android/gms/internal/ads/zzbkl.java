package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

public abstract class zzbkl extends zzatr implements zzbkm {
    public zzbkl() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzbkm zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzbkm) {
            return (zzbkm) queryLocalInterface;
        }
        return new zzbkk(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        ArrayList<zzbkf> createTypedArrayList = parcel.createTypedArrayList(zzbkf.CREATOR);
        zzats.zzc(parcel);
        zzb(createTypedArrayList);
        parcel2.writeNoException();
        return true;
    }
}
