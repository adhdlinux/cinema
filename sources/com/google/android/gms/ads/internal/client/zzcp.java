package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;

public final class zzcp extends zzatq {
    zzcp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel zzbg = zzbg(1, zza);
        IBinder readStrongBinder = zzbg.readStrongBinder();
        zzbg.recycle();
        return readStrongBinder;
    }
}
