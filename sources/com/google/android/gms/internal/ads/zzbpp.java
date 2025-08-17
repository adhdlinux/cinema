package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public abstract class zzbpp extends zzatr implements zzbpq {
    public zzbpp() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 2) {
            zzg();
        } else if (i2 == 3) {
            String readString = parcel.readString();
            zzats.zzc(parcel);
            zze(readString);
        } else if (i2 != 4) {
            return false;
        } else {
            zzats.zzc(parcel);
            zzf((zze) zzats.zza(parcel, zze.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
