package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbcj extends zzatr implements zzbck {
    public static zzbck zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
        if (queryLocalInterface instanceof zzbck) {
            return (zzbck) queryLocalInterface;
        }
        return new zzbci(iBinder);
    }
}
