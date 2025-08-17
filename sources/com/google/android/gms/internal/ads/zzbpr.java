package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbpr extends zzatq implements zzbpt {
    zzbpr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final zzdq zze() throws RemoteException {
        Parcel zzbg = zzbg(5, zza());
        zzdq zzb = zzdp.zzb(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzb;
    }

    public final zzbqh zzf() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        zzbqh zzbqh = (zzbqh) zzats.zza(zzbg, zzbqh.CREATOR);
        zzbg.recycle();
        return zzbqh;
    }

    public final zzbqh zzg() throws RemoteException {
        Parcel zzbg = zzbg(3, zza());
        zzbqh zzbqh = (zzbqh) zzats.zza(zzbg, zzbqh.CREATOR);
        zzbg.recycle();
        return zzbqh;
    }

    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzq zzq, zzbpw zzbpw) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzats.zzd(zza, bundle);
        zzats.zzd(zza, bundle2);
        zzats.zzd(zza, zzq);
        zzats.zzf(zza, zzbpw);
        zzbh(1, zza);
    }

    public final void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpe zzbpe, zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzl);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpe);
        zzats.zzf(zza, zzboc);
        zzbh(23, zza);
    }

    public final void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbph zzbph, zzboc zzboc, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzl);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbph);
        zzats.zzf(zza, zzboc);
        zzats.zzd(zza, zzq);
        zzbh(13, zza);
    }

    public final void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbph zzbph, zzboc zzboc, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzl);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbph);
        zzats.zzf(zza, zzboc);
        zzats.zzd(zza, zzq);
        zzbh(21, zza);
    }

    public final void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpk zzbpk, zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzl);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpk);
        zzats.zzf(zza, zzboc);
        zzbh(14, zza);
    }

    public final void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpn zzbpn, zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzl);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpn);
        zzats.zzf(zza, zzboc);
        zzbh(18, zza);
    }

    public final void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpn zzbpn, zzboc zzboc, zzbef zzbef) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzl);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpn);
        zzats.zzf(zza, zzboc);
        zzats.zzd(zza, zzbef);
        zzbh(22, zza);
    }

    public final void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpq zzbpq, zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzl);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpq);
        zzats.zzf(zza, zzboc);
        zzbh(20, zza);
    }

    public final void zzp(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpq zzbpq, zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzl);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpq);
        zzats.zzf(zza, zzboc);
        zzbh(16, zza);
    }

    public final void zzq(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbh(19, zza);
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        Parcel zzbg = zzbg(24, zza);
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        Parcel zzbg = zzbg(15, zza);
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        Parcel zzbg = zzbg(17, zza);
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }
}
