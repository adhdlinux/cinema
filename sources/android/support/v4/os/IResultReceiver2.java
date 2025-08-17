package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface IResultReceiver2 extends IInterface {
    public static final String DESCRIPTOR = "android$support$v4$os$IResultReceiver2".replace('$', '.');

    public static class Default implements IResultReceiver2 {
        public IBinder asBinder() {
            return null;
        }

        public void send(int i2, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IResultReceiver2 {
        static final int TRANSACTION_send = 1;

        private static class Proxy implements IResultReceiver2 {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IResultReceiver2.DESCRIPTOR;
            }

            public void send(int i2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IResultReceiver2.DESCRIPTOR);
                    obtain.writeInt(i2);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IResultReceiver2.DESCRIPTOR);
        }

        public static IResultReceiver2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IResultReceiver2.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IResultReceiver2)) {
                return new Proxy(iBinder);
            }
            return (IResultReceiver2) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            String str = IResultReceiver2.DESCRIPTOR;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                send(parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                return true;
            }
        }
    }

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t2, int i2) {
            if (t2 != null) {
                parcel.writeInt(1);
                t2.writeToParcel(parcel, i2);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void send(int i2, Bundle bundle) throws RemoteException;
}
