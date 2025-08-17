package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzt extends zzb implements zzu {
    public zzt() {
        super("com.google.android.gms.cast.framework.IAppVisibilityListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            IObjectWrapper zzb = zzb();
            parcel2.writeNoException();
            zzc.zze(parcel2, zzb);
        } else if (i2 == 2) {
            zzd();
            parcel2.writeNoException();
        } else if (i2 == 3) {
            zzc();
            parcel2.writeNoException();
        } else if (i2 != 4) {
            return false;
        } else {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }
        return true;
    }
}
