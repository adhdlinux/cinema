package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

public abstract class zzq extends zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzr zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        if (queryLocalInterface instanceof zzr) {
            return (zzr) queryLocalInterface;
        }
        return new zzp(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzc.zzb(parcel);
            zze((LocationResult) zzc.zza(parcel, LocationResult.CREATOR));
        } else if (i2 == 2) {
            zzc.zzb(parcel);
            zzd((LocationAvailability) zzc.zza(parcel, LocationAvailability.CREATOR));
        } else if (i2 != 3) {
            return false;
        } else {
            zzf();
        }
        return true;
    }
}
