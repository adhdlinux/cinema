package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbem extends zzatq implements zzbeo {
    zzbem(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    public final float zze() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        float readFloat = zzbg.readFloat();
        zzbg.recycle();
        return readFloat;
    }

    public final float zzf() throws RemoteException {
        Parcel zzbg = zzbg(6, zza());
        float readFloat = zzbg.readFloat();
        zzbg.recycle();
        return readFloat;
    }

    public final float zzg() throws RemoteException {
        Parcel zzbg = zzbg(5, zza());
        float readFloat = zzbg.readFloat();
        zzbg.recycle();
        return readFloat;
    }

    public final zzdq zzh() throws RemoteException {
        Parcel zzbg = zzbg(7, zza());
        zzdq zzb = zzdp.zzb(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzb;
    }

    public final IObjectWrapper zzi() throws RemoteException {
        Parcel zzbg = zzbg(4, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbg.readStrongBinder());
        zzbg.recycle();
        return asInterface;
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(3, zza);
    }

    public final boolean zzk() throws RemoteException {
        Parcel zzbg = zzbg(10, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final boolean zzl() throws RemoteException {
        Parcel zzbg = zzbg(8, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final void zzm(zzbfz zzbfz) throws RemoteException {
        throw null;
    }
}
