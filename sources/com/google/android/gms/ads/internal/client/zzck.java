package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatr;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzbnw;

public abstract class zzck extends zzatr implements zzcl {
    public zzck() {
        super("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    public static zzcl asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
        if (queryLocalInterface instanceof zzcl) {
            return (zzcl) queryLocalInterface;
        }
        return new zzcj(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzen liteSdkVersion = getLiteSdkVersion();
            parcel2.writeNoException();
            zzats.zze(parcel2, liteSdkVersion);
        } else if (i2 != 2) {
            return false;
        } else {
            zzbnw adapterCreator = getAdapterCreator();
            parcel2.writeNoException();
            zzats.zzf(parcel2, adapterCreator);
        }
        return true;
    }
}
