package com.google.ar.core.dependencies;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class d extends Binder implements IInterface {
    protected d(String str) {
        attachInterface(this, str);
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2, Parcel parcel) throws RemoteException {
        return false;
    }

    public final IBinder asBinder() {
        return this;
    }

    public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i2, parcel, parcel2, i3)) {
            return true;
        }
        return a(i2, parcel);
    }
}
