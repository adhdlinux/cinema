package com.startapp;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface n extends IInterface {

    public static abstract class a extends Binder implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f34947a = 0;

        /* renamed from: com.startapp.n$a$a  reason: collision with other inner class name */
        public static class C0055a implements n {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f34948a;

            public C0055a(IBinder iBinder) {
                this.f34948a = iBinder;
            }

            public Bundle a(Bundle bundle) throws RemoteException {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                    if (!this.f34948a.transact(1, obtain, obtain2, 0)) {
                        int i2 = a.f34947a;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f34948a;
            }
        }
    }

    Bundle a(Bundle bundle) throws RemoteException;
}
