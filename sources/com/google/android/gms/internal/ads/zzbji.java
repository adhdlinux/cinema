package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbji extends zzatr implements zzbjj {
    public zzbji() {
        super("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
    }

    public static zzbjj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
        if (queryLocalInterface instanceof zzbjj) {
            return (zzbjj) queryLocalInterface;
        }
        return new zzbjh(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String readString = parcel.readString();
            zzats.zzc(parcel);
            zzf(readString);
        } else if (i2 != 2) {
            return false;
        } else {
            zze();
        }
        parcel2.writeNoException();
        return true;
    }
}
