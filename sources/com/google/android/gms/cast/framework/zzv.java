package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzv extends zzb implements zzw {
    public zzv() {
        super("com.google.android.gms.cast.framework.ICastConnectionController");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            zzc.zzb(parcel);
            zzc(readString, readString2);
            parcel2.writeNoException();
        } else if (i2 == 2) {
            zzc.zzb(parcel);
            zzd(parcel.readString(), (LaunchOptions) zzc.zza(parcel, LaunchOptions.CREATOR));
            parcel2.writeNoException();
        } else if (i2 == 3) {
            String readString3 = parcel.readString();
            zzc.zzb(parcel);
            zze(readString3);
            parcel2.writeNoException();
        } else if (i2 == 4) {
            int readInt = parcel.readInt();
            zzc.zzb(parcel);
            zzb(readInt);
            parcel2.writeNoException();
        } else if (i2 != 5) {
            return false;
        } else {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }
        return true;
    }
}
