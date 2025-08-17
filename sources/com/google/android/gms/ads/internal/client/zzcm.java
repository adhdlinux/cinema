package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzbkf;
import com.google.android.gms.internal.ads.zzbkm;
import com.google.android.gms.internal.ads.zzbnw;
import java.util.ArrayList;
import java.util.List;

public final class zzcm extends zzatq implements zzco {
    zzcm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final float zze() throws RemoteException {
        Parcel zzbg = zzbg(7, zza());
        float readFloat = zzbg.readFloat();
        zzbg.recycle();
        return readFloat;
    }

    public final String zzf() throws RemoteException {
        Parcel zzbg = zzbg(9, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final List zzg() throws RemoteException {
        Parcel zzbg = zzbg(13, zza());
        ArrayList<zzbkf> createTypedArrayList = zzbg.createTypedArrayList(zzbkf.CREATOR);
        zzbg.recycle();
        return createTypedArrayList;
    }

    public final void zzh(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbh(10, zza);
    }

    public final void zzi() throws RemoteException {
        zzbh(15, zza());
    }

    public final void zzj(boolean z2) throws RemoteException {
        Parcel zza = zza();
        int i2 = zzats.zza;
        zza.writeInt(z2 ? 1 : 0);
        zzbh(17, zza);
    }

    public final void zzk() throws RemoteException {
        zzbh(1, zza());
    }

    public final void zzl(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zzats.zzf(zza, iObjectWrapper);
        zzbh(6, zza);
    }

    public final void zzm(zzda zzda) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzda);
        zzbh(16, zza);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzbh(5, zza);
    }

    public final void zzo(zzbnw zzbnw) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbnw);
        zzbh(11, zza);
    }

    public final void zzp(boolean z2) throws RemoteException {
        Parcel zza = zza();
        int i2 = zzats.zza;
        zza.writeInt(z2 ? 1 : 0);
        zzbh(4, zza);
    }

    public final void zzq(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzbh(2, zza);
    }

    public final void zzr(String str) throws RemoteException {
        throw null;
    }

    public final void zzs(zzbkm zzbkm) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbkm);
        zzbh(12, zza);
    }

    public final void zzt(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbh(18, zza);
    }

    public final void zzu(zzff zzff) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzff);
        zzbh(14, zza);
    }

    public final boolean zzv() throws RemoteException {
        Parcel zzbg = zzbg(8, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }
}
