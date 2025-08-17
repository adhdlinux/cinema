package com.google.ar.core.dependencies;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class i extends d implements j {
    public i() {
        super("com.google.android.play.core.install.protocol.IInstallServiceCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        if (i2 == 1) {
            e.d(parcel);
            b((Bundle) e.a(parcel, Bundle.CREATOR));
        } else if (i2 == 2) {
            e.d(parcel);
            c((Bundle) e.a(parcel, Bundle.CREATOR));
        } else if (i2 != 3) {
            return false;
        } else {
            Bundle bundle = (Bundle) e.a(parcel, Bundle.CREATOR);
            e.d(parcel);
        }
        return true;
    }
}
