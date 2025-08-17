package com.google.android.gms.ads.internal.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;

public final class zzbp extends zzatq implements zzbr {
    zzbp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(2, zza);
    }

    public final boolean zzf(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeString(str2);
        Parcel zzbg = zzbg(1, zza);
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }
}
