package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public abstract class zzbpm extends zzatr implements zzbpn {
    public zzbpm() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzbol zzb = zzbok.zzb(parcel.readStrongBinder());
            zzats.zzc(parcel);
            zzg(zzb);
        } else if (i2 == 2) {
            String readString = parcel.readString();
            zzats.zzc(parcel);
            zze(readString);
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
