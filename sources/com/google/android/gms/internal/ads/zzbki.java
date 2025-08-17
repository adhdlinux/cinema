package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbki extends zzatr implements zzbkj {
    public zzbki() {
        super("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    public static zzbkj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
        if (queryLocalInterface instanceof zzbkj) {
            return (zzbkj) queryLocalInterface;
        }
        return new zzbkh(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 2) {
            zzf();
        } else if (i2 != 3) {
            return false;
        } else {
            String readString = parcel.readString();
            zzats.zzc(parcel);
            zze(readString);
        }
        parcel2.writeNoException();
        return true;
    }
}
