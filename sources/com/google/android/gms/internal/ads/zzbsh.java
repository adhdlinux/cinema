package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

public abstract class zzbsh extends zzatr implements zzbsi {
    public zzbsh() {
        super("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }

    public static zzbsi zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
        if (queryLocalInterface instanceof zzbsi) {
            return (zzbsi) queryLocalInterface;
        }
        return new zzbsg(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            ArrayList createTypedArrayList = parcel.createTypedArrayList(Uri.CREATOR);
            zzats.zzc(parcel);
            zzf(createTypedArrayList);
        } else if (i2 != 2) {
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
