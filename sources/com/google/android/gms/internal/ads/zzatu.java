package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzatu extends zzatr implements zzatv {
    public static zzatv zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        if (queryLocalInterface instanceof zzatv) {
            return (zzatv) queryLocalInterface;
        }
        return new zzatt(iBinder);
    }
}
