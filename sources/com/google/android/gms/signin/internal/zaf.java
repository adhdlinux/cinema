package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zaf extends zaa {
    zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zae(int i2) throws RemoteException {
        Parcel zaa = zaa();
        zaa.writeInt(i2);
        zac(7, zaa);
    }

    public final void zaf(IAccountAccessor iAccountAccessor, int i2, boolean z2) throws RemoteException {
        Parcel zaa = zaa();
        zac.zae(zaa, iAccountAccessor);
        zaa.writeInt(i2);
        zac.zac(zaa, z2);
        zac(9, zaa);
    }

    public final void zag(zai zai, zae zae) throws RemoteException {
        Parcel zaa = zaa();
        zac.zad(zaa, zai);
        zac.zae(zaa, zae);
        zac(12, zaa);
    }
}
