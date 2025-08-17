package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzj extends zzb implements zzk {
    public zzj() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzc.zzb(parcel);
            zzd((zzg) zzc.zza(parcel, zzg.CREATOR));
        } else if (i2 != 2) {
            return false;
        } else {
            zze();
        }
        return true;
    }
}
