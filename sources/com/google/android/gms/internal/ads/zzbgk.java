package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbgk extends zzatr implements zzbgl {
    public zzbgk() {
        super("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
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
