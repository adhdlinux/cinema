package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbtc extends zzatr implements zzbtd {
    public zzbtc() {
        super("com.google.android.gms.ads.internal.report.IDynamiteErrorEventListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        zzb();
        parcel2.writeNoException();
        return true;
    }
}
