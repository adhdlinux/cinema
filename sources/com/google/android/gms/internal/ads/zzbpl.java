package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public final class zzbpl extends zzatq implements zzbpn {
    zzbpl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString("Adapter returned null.");
        zzbh(2, zza);
    }

    public final void zzf(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zze);
        zzbh(3, zza);
    }

    public final void zzg(zzbol zzbol) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbol);
        zzbh(1, zza);
    }
}
