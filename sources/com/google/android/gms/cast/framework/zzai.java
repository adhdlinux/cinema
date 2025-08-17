package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.zzb;

public abstract class zzai extends zzb implements zzaj {
    public static zzaj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.IReconnectionService");
        if (queryLocalInterface instanceof zzaj) {
            return (zzaj) queryLocalInterface;
        }
        return new zzah(iBinder);
    }
}
