package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;

public abstract class zzdq extends zzb implements zzdr {
    public zzdq() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzc.zzb(parcel);
            zzb(parcel.readInt(), parcel.readInt(), (Surface) zzc.zza(parcel, Surface.CREATOR));
        } else if (i2 == 2) {
            int readInt = parcel.readInt();
            zzc.zzb(parcel);
            zzd(readInt);
        } else if (i2 == 3) {
            zzf();
        } else if (i2 == 4) {
            zzc();
        } else if (i2 != 5) {
            return false;
        } else {
            boolean zzf = zzc.zzf(parcel);
            zzc.zzb(parcel);
            zze(zzf);
        }
        parcel2.writeNoException();
        return true;
    }
}
