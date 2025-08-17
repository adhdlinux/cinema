package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatr;
import com.google.android.gms.internal.ads.zzats;

public abstract class zzbm extends zzatr implements zzbn {
    public zzbm() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzats.zzc(parcel);
            zzg((zzl) zzats.zza(parcel, zzl.CREATOR));
            parcel2.writeNoException();
        } else if (i2 == 2) {
            String zze = zze();
            parcel2.writeNoException();
            parcel2.writeString(zze);
        } else if (i2 == 3) {
            boolean zzi = zzi();
            parcel2.writeNoException();
            int i4 = zzats.zza;
            parcel2.writeInt(zzi ? 1 : 0);
        } else if (i2 == 4) {
            String zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        } else if (i2 != 5) {
            return false;
        } else {
            int readInt = parcel.readInt();
            zzats.zzc(parcel);
            zzh((zzl) zzats.zza(parcel, zzl.CREATOR), readInt);
            parcel2.writeNoException();
        }
        return true;
    }
}
