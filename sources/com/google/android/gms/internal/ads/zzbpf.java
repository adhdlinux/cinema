package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbpf extends zzatq implements zzbph {
    zzbpf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
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

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(1, zza);
    }

    public final void zzh(zzbof zzbof) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbof);
        zzbh(4, zza);
    }
}
