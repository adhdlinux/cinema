package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.zzb;

public abstract class zzab extends zzb implements zzac {
    public static zzac zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.ICastSession");
        if (queryLocalInterface instanceof zzac) {
            return (zzac) queryLocalInterface;
        }
        return new zzaa(iBinder);
    }
}
