package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzbpg extends zzatr implements zzbph {
    public zzbpg() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzats.zzc(parcel);
            zzg(asInterface);
        } else if (i2 == 2) {
            String readString = parcel.readString();
            zzats.zzc(parcel);
            zze(readString);
        } else if (i2 == 3) {
            zzats.zzc(parcel);
            zzf((zze) zzats.zza(parcel, zze.CREATOR));
        } else if (i2 != 4) {
            return false;
        } else {
            zzbof zzb = zzboe.zzb(parcel.readStrongBinder());
            zzats.zzc(parcel);
            zzh(zzb);
        }
        parcel2.writeNoException();
        return true;
    }
}
