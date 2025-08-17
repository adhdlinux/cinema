package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatr;
import com.google.android.gms.internal.ads.zzats;

public abstract class zzch extends zzatr implements zzci {
    public zzch() {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzats.zzc(parcel);
            zzd((zze) zzats.zza(parcel, zze.CREATOR));
        } else if (i2 == 2) {
            zzf();
        } else if (i2 == 3) {
            zzc();
        } else if (i2 == 4) {
            zze();
        } else if (i2 != 5) {
            return false;
        } else {
            zzb();
        }
        parcel2.writeNoException();
        return true;
    }
}
