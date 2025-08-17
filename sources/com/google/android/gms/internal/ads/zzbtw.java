package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzaz;

public abstract class zzbtw extends zzatr implements zzbtx {
    public zzbtw() {
        super("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzats.zzc(parcel);
            zzf((ParcelFileDescriptor) zzats.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i2 != 2) {
            return false;
        } else {
            zzats.zzc(parcel);
            zze((zzaz) zzats.zza(parcel, zzaz.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
