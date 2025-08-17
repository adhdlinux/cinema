package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzat extends zzb implements zzau {
    public zzat() {
        super("com.google.android.gms.cast.framework.ISessionProxy");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                IObjectWrapper zzc = zzc();
                parcel2.writeNoException();
                zzc.zze(parcel2, zzc);
                return true;
            case 2:
                zzc.zzb(parcel);
                zzh((Bundle) zzc.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
                zzc.zzb(parcel);
                zzg((Bundle) zzc.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zzf = zzc.zzf(parcel);
                zzc.zzb(parcel);
                zzd(zzf);
                parcel2.writeNoException();
                return true;
            case 5:
                long zzb = zzb();
                parcel2.writeNoException();
                parcel2.writeLong(zzb);
                return true;
            case 6:
                parcel2.writeNoException();
                parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                return true;
            case 7:
                zzc.zzb(parcel);
                zzf((Bundle) zzc.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                zzc.zzb(parcel);
                zze((Bundle) zzc.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                zzc.zzb(parcel);
                zzi((Bundle) zzc.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
