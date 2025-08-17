package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzb;
import com.google.android.gms.internal.auth.zzc;

public abstract class zza extends zzb implements zzb {
    public zza() {
        super("com.google.android.gms.auth.account.IWorkAccountCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzc.zzb(parcel);
            zzb((Account) zzc.zza(parcel, Account.CREATOR));
        } else if (i2 != 2) {
            return false;
        } else {
            boolean zzf = zzc.zzf(parcel);
            zzc.zzb(parcel);
            zzc(zzf);
        }
        return true;
    }
}
