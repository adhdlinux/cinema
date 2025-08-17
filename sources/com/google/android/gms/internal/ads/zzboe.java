package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzboe extends zzatr implements zzbof {
    public zzboe() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    public static zzbof zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
        if (queryLocalInterface instanceof zzbof) {
            return (zzbof) queryLocalInterface;
        }
        return new zzbod(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            IObjectWrapper zze = zze();
            parcel2.writeNoException();
            zzats.zzf(parcel2, zze);
        } else if (i2 != 2) {
            return false;
        } else {
            boolean zzf = zzf();
            parcel2.writeNoException();
            int i4 = zzats.zza;
            parcel2.writeInt(zzf ? 1 : 0);
        }
        return true;
    }
}
