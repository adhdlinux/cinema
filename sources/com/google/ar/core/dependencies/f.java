package com.google.ar.core.dependencies;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public final class f extends c implements h {
    f(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.install.protocol.IInstallService");
    }

    public final void d(String str, List list, Bundle bundle, j jVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        e.b(a2, bundle);
        e.c(a2, jVar);
        c(1, a2);
    }

    public final void e(String str, Bundle bundle, j jVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        e.b(a2, bundle);
        e.c(a2, jVar);
        c(2, a2);
    }
}
