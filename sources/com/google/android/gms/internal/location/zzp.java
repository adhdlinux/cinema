package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class zzp extends zzb implements zzq {
    public zzp() {
        super("com.google.android.gms.location.internal.ILocationStatusCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        zzc.zzb(parcel);
        zzb((Status) zzc.zza(parcel, Status.CREATOR), (Location) zzc.zza(parcel, Location.CREATOR));
        return true;
    }
}
