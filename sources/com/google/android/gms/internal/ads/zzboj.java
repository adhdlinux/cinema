package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzboj extends zzatq implements zzbol {
    zzboj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public final boolean zzA() throws RemoteException {
        Parcel zzbg = zzbg(18, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final boolean zzB() throws RemoteException {
        Parcel zzbg = zzbg(17, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final double zze() throws RemoteException {
        Parcel zzbg = zzbg(8, zza());
        double readDouble = zzbg.readDouble();
        zzbg.recycle();
        return readDouble;
    }

    public final float zzf() throws RemoteException {
        Parcel zzbg = zzbg(23, zza());
        float readFloat = zzbg.readFloat();
        zzbg.recycle();
        return readFloat;
    }

    public final float zzg() throws RemoteException {
        Parcel zzbg = zzbg(25, zza());
        float readFloat = zzbg.readFloat();
        zzbg.recycle();
        return readFloat;
    }

    public final float zzh() throws RemoteException {
        Parcel zzbg = zzbg(24, zza());
        float readFloat = zzbg.readFloat();
        zzbg.recycle();
        return readFloat;
    }

    public final Bundle zzi() throws RemoteException {
        Parcel zzbg = zzbg(16, zza());
        Bundle bundle = (Bundle) zzats.zza(zzbg, Bundle.CREATOR);
        zzbg.recycle();
        return bundle;
    }

    public final zzdq zzj() throws RemoteException {
        Parcel zzbg = zzbg(11, zza());
        zzdq zzb = zzdp.zzb(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzb;
    }

    public final zzbej zzk() throws RemoteException {
        Parcel zzbg = zzbg(12, zza());
        zzbej zzj = zzbei.zzj(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzj;
    }

    public final zzber zzl() throws RemoteException {
        Parcel zzbg = zzbg(5, zza());
        zzber zzg = zzbeq.zzg(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzg;
    }

    public final IObjectWrapper zzm() throws RemoteException {
        Parcel zzbg = zzbg(13, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbg.readStrongBinder());
        zzbg.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzbg = zzbg(14, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbg.readStrongBinder());
        zzbg.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzo() throws RemoteException {
        Parcel zzbg = zzbg(15, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbg.readStrongBinder());
        zzbg.recycle();
        return asInterface;
    }

    public final String zzp() throws RemoteException {
        Parcel zzbg = zzbg(7, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzq() throws RemoteException {
        Parcel zzbg = zzbg(4, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzr() throws RemoteException {
        Parcel zzbg = zzbg(6, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzs() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzt() throws RemoteException {
        Parcel zzbg = zzbg(10, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzu() throws RemoteException {
        Parcel zzbg = zzbg(9, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final List zzv() throws RemoteException {
        Parcel zzbg = zzbg(3, zza());
        ArrayList zzb = zzats.zzb(zzbg);
        zzbg.recycle();
        return zzb;
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(20, zza);
    }

    public final void zzx() throws RemoteException {
        zzbh(19, zza());
    }

    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, iObjectWrapper2);
        zzats.zzf(zza, iObjectWrapper3);
        zzbh(21, zza);
    }

    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(22, zza);
    }
}
