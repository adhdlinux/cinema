package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public final class zzbky extends zzatq implements zzbla {
    zzbky(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    public final void zze(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzbh(2, zza);
    }

    public final void zzf(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zze);
        zzbh(3, zza);
    }

    public final void zzg(zzbku zzbku) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbku);
        zzbh(1, zza);
    }
}
