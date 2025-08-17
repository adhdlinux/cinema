package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbfd extends zzatr implements zzbfe {
    public static zzbfe zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (queryLocalInterface instanceof zzbfe) {
            return (zzbfe) queryLocalInterface;
        }
        return new zzbfc(iBinder);
    }
}
