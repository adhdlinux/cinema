package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzavr extends zzatq implements zzavt {
    zzavr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public final zzbu zze() throws RemoteException {
        throw null;
    }

    public final zzdn zzf() throws RemoteException {
        Parcel zzbg = zzbg(5, zza());
        zzdn zzb = zzdm.zzb(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzb;
    }

    public final void zzg(boolean z2) throws RemoteException {
        Parcel zza = zza();
        int i2 = zzats.zza;
        zza.writeInt(z2 ? 1 : 0);
        zzbh(6, zza);
    }

    public final void zzh(zzdg zzdg) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzdg);
        zzbh(7, zza);
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzawa zzawa) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzawa);
        zzbh(4, zza);
    }
}
