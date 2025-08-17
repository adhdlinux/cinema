package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public abstract class zzavz extends zzatr implements zzawa {
    public zzavz() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzf();
        } else if (i2 == 2) {
            zzc();
        } else if (i2 == 3) {
            zzats.zzc(parcel);
            zzd((zze) zzats.zza(parcel, zze.CREATOR));
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
