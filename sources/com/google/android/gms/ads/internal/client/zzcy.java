package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;

public final class zzcy extends zzatq implements zzda {
    zzcy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
    }

    public final void zze(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zze);
        zzbh(1, zza);
    }
}
