package com.google.android.gms.cast.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzae extends zzb implements zzaf {
    public zzae() {
        super("com.google.android.gms.cast.internal.IBundleCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        zzc.zzb(parcel);
        zzb((Bundle) zzc.zza(parcel, Bundle.CREATOR));
        return true;
    }
}
