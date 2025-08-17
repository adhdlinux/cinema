package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public final class zzavu extends zzatq implements zzavw {
    zzavu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public final void zzb(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzbh(2, zza);
    }

    public final void zzc(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zze);
        zzbh(3, zza);
    }

    public final void zzd(zzavt zzavt) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzavt);
        zzbh(1, zza);
    }
}
