package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;
import java.util.List;

public abstract class zzf extends zzb implements zzg {
    public zzf() {
        super("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } else if (i2 == 2) {
            IObjectWrapper zze = zze();
            parcel2.writeNoException();
            zzc.zze(parcel2, zze);
        } else if (i2 == 3) {
            List zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeTypedList(zzf);
        } else if (i2 != 4) {
            return false;
        } else {
            int[] zzg = zzg();
            parcel2.writeNoException();
            parcel2.writeIntArray(zzg);
        }
        return true;
    }
}
