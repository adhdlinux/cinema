package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public final class zzboa extends zzatq implements zzboc {
    zzboa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void zze() throws RemoteException {
        zzbh(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzbh(2, zza());
    }

    public final void zzg(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzbh(3, zza);
    }

    public final void zzh(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zze);
        zzbh(23, zza);
    }

    public final void zzi(int i2, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zza.writeString(str);
        zzbh(22, zza);
    }

    public final void zzj(int i2) throws RemoteException {
        throw null;
    }

    public final void zzk(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zze);
        zzbh(24, zza);
    }

    public final void zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbh(21, zza);
    }

    public final void zzm() throws RemoteException {
        zzbh(8, zza());
    }

    public final void zzn() throws RemoteException {
        zzbh(4, zza());
    }

    public final void zzo() throws RemoteException {
        zzbh(6, zza());
    }

    public final void zzp() throws RemoteException {
        zzbh(5, zza());
    }

    public final void zzq(String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbh(9, zza);
    }

    public final void zzr(zzbfl zzbfl, String str) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbfl);
        zza.writeString(str);
        zzbh(10, zza);
    }

    public final void zzs(zzbvg zzbvg) throws RemoteException {
        throw null;
    }

    public final void zzt(zzbvk zzbvk) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbvk);
        zzbh(16, zza);
    }

    public final void zzu() throws RemoteException {
        zzbh(18, zza());
    }

    public final void zzv() throws RemoteException {
        zzbh(11, zza());
    }

    public final void zzw() throws RemoteException {
        zzbh(15, zza());
    }

    public final void zzx() throws RemoteException {
        zzbh(20, zza());
    }

    public final void zzy() throws RemoteException {
        zzbh(13, zza());
    }
}
