package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzatr;
import com.google.android.gms.internal.ads.zzats;

public abstract class zzbq extends zzatr implements zzbr {
    public zzbq() {
        super("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            zzats.zzc(parcel);
            boolean zzf = zzf(asInterface, readString, readString2);
            parcel2.writeNoException();
            parcel2.writeInt(zzf ? 1 : 0);
        } else if (i2 != 2) {
            return false;
        } else {
            IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzats.zzc(parcel);
            zze(asInterface2);
            parcel2.writeNoException();
        }
        return true;
    }
}
