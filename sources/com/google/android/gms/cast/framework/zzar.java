package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzar extends zzb implements zzas {
    public zzar() {
        super("com.google.android.gms.cast.framework.ISessionProvider");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String readString = parcel.readString();
            zzc.zzb(parcel);
            IObjectWrapper zzb = zzb(readString);
            parcel2.writeNoException();
            zzc.zze(parcel2, zzb);
        } else if (i2 == 2) {
            boolean zzd = zzd();
            parcel2.writeNoException();
            int i4 = zzc.zza;
            parcel2.writeInt(zzd ? 1 : 0);
        } else if (i2 == 3) {
            String zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeString(zzc);
        } else if (i2 != 4) {
            return false;
        } else {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }
        return true;
    }
}
