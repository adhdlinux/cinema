package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzbcg extends zzatr implements zzbch {
    public zzbcg() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String zzb = zzb();
            parcel2.writeNoException();
            parcel2.writeString(zzb);
        } else if (i2 == 2) {
            String zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeString(zzc);
        } else if (i2 == 3) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzats.zzc(parcel);
            zzd(asInterface);
            parcel2.writeNoException();
        } else if (i2 == 4) {
            zze();
            parcel2.writeNoException();
        } else if (i2 != 5) {
            return false;
        } else {
            zzf();
            parcel2.writeNoException();
        }
        return true;
    }
}
