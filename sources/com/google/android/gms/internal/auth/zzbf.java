package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public abstract class zzbf extends zzb implements zzbg {
    public zzbf() {
        super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzc.zzb(parcel);
            zzb((ProxyResponse) zzc.zza(parcel, ProxyResponse.CREATOR));
        } else if (i2 != 2) {
            return false;
        } else {
            String readString = parcel.readString();
            zzc.zzb(parcel);
            zzc(readString);
        }
        parcel2.writeNoException();
        return true;
    }
}
