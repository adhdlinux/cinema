package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public abstract class zzbpv extends zzatr implements zzbpw {
    public zzbpv() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String readString = parcel.readString();
            zzats.zzc(parcel);
            zze(readString);
        } else if (i2 == 2) {
            String readString2 = parcel.readString();
            zzats.zzc(parcel);
            zzf(readString2);
        } else if (i2 != 3) {
            return false;
        } else {
            zzats.zzc(parcel);
            zzg((zze) zzats.zza(parcel, zze.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
