package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbjl extends zzatr implements zzbjm {
    public static zzbjm zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
        if (queryLocalInterface instanceof zzbjm) {
            return (zzbjm) queryLocalInterface;
        }
        return new zzbjk(iBinder);
    }
}
