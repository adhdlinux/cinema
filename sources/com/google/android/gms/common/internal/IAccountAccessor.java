package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public interface IAccountAccessor extends IInterface {

    public static abstract class Stub extends zzb implements IAccountAccessor {
        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        public static IAccountAccessor asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof IAccountAccessor) {
                return (IAccountAccessor) queryLocalInterface;
            }
            return new zzw(iBinder);
        }

        /* access modifiers changed from: protected */
        public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 2) {
                return false;
            }
            Account zzb = zzb();
            parcel2.writeNoException();
            zzc.zzd(parcel2, zzb);
            return true;
        }
    }

    Account zzb() throws RemoteException;
}
