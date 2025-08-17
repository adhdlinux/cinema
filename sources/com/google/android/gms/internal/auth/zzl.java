package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.common.api.Status;

public abstract class zzl extends zzb implements zzm {
    public zzl() {
        super("com.google.android.gms.auth.account.data.IGetAccountChangeEventsCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 2) {
            return false;
        }
        zzc.zzb(parcel);
        zzb((Status) zzc.zza(parcel, Status.CREATOR), (AccountChangeEventsResponse) zzc.zza(parcel, AccountChangeEventsResponse.CREATOR));
        return true;
    }
}
