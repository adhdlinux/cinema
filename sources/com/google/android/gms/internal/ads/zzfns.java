package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzfns extends zzatr implements zzfnt {
    public static zzfnt zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.lmd.protocol.ILmdOverlayService");
        if (queryLocalInterface instanceof zzfnt) {
            return (zzfnt) queryLocalInterface;
        }
        return new zzfnr(iBinder);
    }
}
