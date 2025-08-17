package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbut extends zzatr implements zzbuu {
    public zzbut() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeString(zzc);
        } else if (i2 != 2) {
            return false;
        } else {
            int zzb = zzb();
            parcel2.writeNoException();
            parcel2.writeInt(zzb);
        }
        return true;
    }
}
