package com.google.ar.core.dependencies;

import android.os.IBinder;
import android.os.IInterface;

public abstract class g extends d implements h {
    public static h b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.install.protocol.IInstallService");
        if (queryLocalInterface instanceof h) {
            return (h) queryLocalInterface;
        }
        return new f(iBinder);
    }
}
