package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbye extends zzatr implements zzbyf {
    public zzbye() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            parcel.readString();
            parcel.readString();
            zzats.zzc(parcel);
        } else if (i2 == 2) {
            String readString = parcel.readString();
            zzats.zzc(parcel);
            zzb(readString);
        } else if (i2 != 3) {
            return false;
        } else {
            zzats.zzc(parcel);
            zzc(parcel.readString(), parcel.readString(), (Bundle) zzats.zza(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
