package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public final class zzbpo extends zzatq implements zzbpq {
    zzbpo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString("Adapter returned null.");
        zzbh(3, zza);
    }

    public final void zzf(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zze);
        zzbh(4, zza);
    }

    public final void zzg() throws RemoteException {
        zzbh(2, zza());
    }
}
