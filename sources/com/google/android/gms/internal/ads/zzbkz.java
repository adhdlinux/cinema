package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbkz extends zzatr implements zzbla {
    public static zzbla zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
        if (queryLocalInterface instanceof zzbla) {
            return (zzbla) queryLocalInterface;
        }
        return new zzbky(iBinder);
    }
}
