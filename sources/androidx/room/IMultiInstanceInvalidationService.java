package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;

public interface IMultiInstanceInvalidationService extends IInterface {

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationService {

        private static class Proxy implements IMultiInstanceInvalidationService {

            /* renamed from: b  reason: collision with root package name */
            private IBinder f11398b;

            Proxy(IBinder iBinder) {
                this.f11398b = iBinder;
            }

            public void E(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i2) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    if (iMultiInstanceInvalidationCallback != null) {
                        iBinder = iMultiInstanceInvalidationCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i2);
                    this.f11398b.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f11398b;
            }

            public void n(int i2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeInt(i2);
                    obtain.writeStringArray(strArr);
                    this.f11398b.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public int s(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    if (iMultiInstanceInvalidationCallback != null) {
                        iBinder = iMultiInstanceInvalidationCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f11398b.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static IMultiInstanceInvalidationService G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMultiInstanceInvalidationService)) {
                return new Proxy(iBinder);
            }
            return (IMultiInstanceInvalidationService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                int s2 = s(IMultiInstanceInvalidationCallback.Stub.G(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(s2);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                E(IMultiInstanceInvalidationCallback.Stub.G(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                n(parcel.readInt(), parcel.createStringArray());
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
        }
    }

    void E(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i2) throws RemoteException;

    void n(int i2, String[] strArr) throws RemoteException;

    int s(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) throws RemoteException;
}
