package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatq;

public final class zzdb extends zzatq implements zzdd {
    zzdb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }

    public final void zze() throws RemoteException {
        zzbh(1, zza());
    }
}
