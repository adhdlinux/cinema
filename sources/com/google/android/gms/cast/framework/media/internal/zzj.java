package com.google.android.gms.cast.framework.media.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzj extends zzb implements zzk {
    public zzj() {
        super("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTaskProgressPublisher");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            zzc.zzb(parcel);
            zzb(readLong, readLong2);
            parcel2.writeNoException();
        } else if (i2 != 2) {
            return false;
        } else {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }
        return true;
    }
}
