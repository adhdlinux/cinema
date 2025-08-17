package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbkw extends zzatr implements zzbkx {
    public zzbkw() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            parcel.readInt();
            zzats.zzc(parcel);
        }
        parcel2.writeNoException();
        return true;
    }
}
