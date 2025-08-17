package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatr;
import com.google.android.gms.internal.ads.zzats;

public abstract class zzdf extends zzatr implements zzdg {
    public zzdf() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzdg zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        if (queryLocalInterface instanceof zzdg) {
            return (zzdg) queryLocalInterface;
        }
        return new zzde(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzats.zzc(parcel);
            zze((zzs) zzats.zza(parcel, zzs.CREATOR));
            parcel2.writeNoException();
        } else if (i2 != 2) {
            return false;
        } else {
            boolean zzf = zzf();
            parcel2.writeNoException();
            int i4 = zzats.zza;
            parcel2.writeInt(zzf ? 1 : 0);
        }
        return true;
    }
}
