package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public abstract class zzbvt extends zzatr implements zzbvu {
    public zzbvt() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzg();
        } else if (i2 == 2) {
            int readInt = parcel.readInt();
            zzats.zzc(parcel);
            zze(readInt);
        } else if (i2 != 3) {
            return false;
        } else {
            zzats.zzc(parcel);
            zzf((zze) zzats.zza(parcel, zze.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
