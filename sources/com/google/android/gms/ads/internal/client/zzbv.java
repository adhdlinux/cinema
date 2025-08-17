package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzbnw;

public final class zzbv extends zzatq {
    zzbv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbnw zzbnw, int i2, int i3) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzq);
        zza.writeString(str);
        zzats.zzf(zza, zzbnw);
        zza.writeInt(ModuleDescriptor.MODULE_VERSION);
        zza.writeInt(i3);
        Parcel zzbg = zzbg(2, zza);
        IBinder readStrongBinder = zzbg.readStrongBinder();
        zzbg.recycle();
        return readStrongBinder;
    }
}
