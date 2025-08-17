package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;

public interface ICancelToken extends IInterface {

    public static abstract class Stub extends zzb implements ICancelToken {
        public Stub() {
            super("com.google.android.gms.common.internal.ICancelToken");
        }

        public static ICancelToken asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            if (queryLocalInterface instanceof ICancelToken) {
                return (ICancelToken) queryLocalInterface;
            }
            return new zzx(iBinder);
        }

        /* access modifiers changed from: protected */
        public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 2) {
                return false;
            }
            cancel();
            return true;
        }
    }

    void cancel() throws RemoteException;
}
