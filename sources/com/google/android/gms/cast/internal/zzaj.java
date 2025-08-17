package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;
import java.util.List;

public final class zzaj extends zza {
    zzaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastService");
    }

    public final void zze(IStatusCallback iStatusCallback, String[] strArr, String str, List list) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iStatusCallback);
        zza.writeStringArray(strArr);
        zza.writeString(str);
        zza.writeTypedList((List) null);
        zzd(2, zza);
    }

    public final void zzf(zzaf zzaf, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzaf);
        zza.writeStringArray(strArr);
        zzd(5, zza);
    }

    public final void zzg(zzaf zzaf, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzaf);
        zza.writeStringArray(strArr);
        zzd(7, zza);
    }

    public final void zzh(zzaf zzaf, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzaf);
        zza.writeStringArray(strArr);
        zzd(6, zza);
    }
}
