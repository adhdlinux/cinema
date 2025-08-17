package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.internal.zzh;
import com.google.android.gms.cast.framework.media.internal.zzi;
import com.google.android.gms.cast.framework.media.internal.zzk;
import com.google.android.gms.cast.framework.zzab;
import com.google.android.gms.cast.framework.zzac;
import com.google.android.gms.cast.framework.zzaj;
import com.google.android.gms.cast.framework.zzal;
import com.google.android.gms.cast.framework.zzam;
import com.google.android.gms.cast.framework.zzau;
import com.google.android.gms.cast.framework.zzw;
import com.google.android.gms.cast.framework.zzy;
import com.google.android.gms.cast.framework.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public final class zzai extends zza implements zzaj {
    zzai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
    }

    public final zzz zze(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzal zzal, Map map) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zzc(zza, castOptions);
        zzc.zze(zza, zzal);
        zza.writeMap(map);
        Parcel zzb = zzb(1, zza);
        zzz zzb2 = zzy.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    public final zzac zzf(CastOptions castOptions, IObjectWrapper iObjectWrapper, zzw zzw) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, castOptions);
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, zzw);
        Parcel zzb = zzb(3, zza);
        zzac zzb2 = zzab.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    public final zzaj zzg(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, iObjectWrapper2);
        zzc.zze(zza, iObjectWrapper3);
        Parcel zzb = zzb(5, zza);
        zzaj zzb2 = com.google.android.gms.cast.framework.zzai.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    public final zzam zzh(String str, String str2, zzau zzau) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zze(zza, zzau);
        Parcel zzb = zzb(2, zza);
        zzam zzb2 = zzal.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    public final zzi zzi(IObjectWrapper iObjectWrapper, zzk zzk, int i2, int i3, boolean z2, long j2, int i4, int i5, int i6) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, zzk);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zza.writeInt(0);
        zza.writeLong(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        zza.writeInt(5);
        zza.writeInt(333);
        zza.writeInt(10000);
        Parcel zzb = zzb(6, zza);
        zzi zzb2 = zzh.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }
}
