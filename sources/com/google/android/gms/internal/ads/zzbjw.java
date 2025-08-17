package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public abstract class zzbjw extends zzatr implements zzbjx {
    public zzbjw() {
        super("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        zzats.zzc(parcel);
        zzb((ParcelFileDescriptor) zzats.zza(parcel, ParcelFileDescriptor.CREATOR));
        return true;
    }
}
