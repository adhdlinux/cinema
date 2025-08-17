package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMultiInstanceInvalidationCallback extends IInterface {

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationCallback {

        private static class Proxy implements IMultiInstanceInvalidationCallback {

            /* renamed from: b  reason: collision with root package name */
            private IBinder f11397b;

            Proxy(IBinder iBinder) {
                this.f11397b = iBinder;
            }

            public IBinder asBinder() {
                return this.f11397b;
            }

            public void c(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    obtain.writeStringArray(strArr);
                    this.f11397b.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static IMultiInstanceInvalidationCallback G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMultiInstanceInvalidationCallback)) {
                return new Proxy(iBinder);
            }
            return (IMultiInstanceInvalidationCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
                c(parcel.createStringArray());
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
                return true;
            }
        }
    }

    void c(String[] strArr) throws RemoteException;
}
