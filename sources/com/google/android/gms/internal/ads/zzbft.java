package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbft extends zzatq implements zzbfv {
    zzbft(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void zze(zzbfl zzbfl, String str) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbfl);
        zza.writeString(str);
        zzbh(1, zza);
    }
}
