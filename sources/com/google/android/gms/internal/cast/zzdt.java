package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzdt extends zzb implements zzdu {
    public zzdt() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        int readInt = parcel.readInt();
        zzc.zzb(parcel);
        zzb(readInt);
        return true;
    }
}
