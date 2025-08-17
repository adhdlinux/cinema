package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzaa extends zza implements zzac {
    zzaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastSession");
    }

    public final void zze(boolean z2, int i2) throws RemoteException {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeInt(z2 ? 1 : 0);
        zza.writeInt(0);
        zzc(6, zza);
    }

    public final void zzf(ApplicationMetadata applicationMetadata, String str, String str2, boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, applicationMetadata);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeInt(z2 ? 1 : 0);
        zzc(4, zza);
    }

    public final void zzg(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzc(5, zza);
    }

    public final void zzh(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, (Parcelable) null);
        zzc(1, zza);
    }

    public final void zzi(ConnectionResult connectionResult) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, connectionResult);
        zzc(3, zza);
    }

    public final void zzj(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzc(2, zza);
    }
}
