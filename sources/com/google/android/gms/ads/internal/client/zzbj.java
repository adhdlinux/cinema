package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatr;
import com.google.android.gms.internal.ads.zzats;

public abstract class zzbj extends zzatr implements zzbk {
    public zzbj() {
        super("com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzc();
        } else if (i2 != 2) {
            return false;
        } else {
            zzats.zzc(parcel);
            zzb((zze) zzats.zza(parcel, zze.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
