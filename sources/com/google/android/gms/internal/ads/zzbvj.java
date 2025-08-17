package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbvj extends zzatr implements zzbvk {
    public zzbvj() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public static zzbvk zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
        if (queryLocalInterface instanceof zzbvk) {
            return (zzbvk) queryLocalInterface;
        }
        return new zzbvi(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        } else if (i2 != 2) {
            return false;
        } else {
            int zze = zze();
            parcel2.writeNoException();
            parcel2.writeInt(zze);
        }
        return true;
    }
}
