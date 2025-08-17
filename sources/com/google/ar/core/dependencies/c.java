package com.google.ar.core.dependencies;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class c implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f30323a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30324b;

    protected c(IBinder iBinder, String str) {
        this.f30323a = iBinder;
        this.f30324b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f30324b);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f30323a;
    }

    /* access modifiers changed from: protected */
    public final Parcel b(int i2, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f30323a.transact(i2, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void c(int i2, Parcel parcel) throws RemoteException {
        try {
            this.f30323a.transact(i2, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
