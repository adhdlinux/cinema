package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbyk extends zzatr implements zzbyl {
    public static zzbyl zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
        if (queryLocalInterface instanceof zzbyl) {
            return (zzbyl) queryLocalInterface;
        }
        return new zzbyj(iBinder);
    }
}
