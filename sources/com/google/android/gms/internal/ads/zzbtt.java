package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbtt extends zzatr implements zzbtu {
    public zzbtt() {
        super("com.google.android.gms.ads.internal.request.IAdsService");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzbtx zzbtx = null;
        if (i2 == 1) {
            zzbti zzbti = (zzbti) zzats.zza(parcel, zzbti.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (queryLocalInterface instanceof zzbtx) {
                    zzbtx = (zzbtx) queryLocalInterface;
                } else {
                    zzbtx = new zzbtv(readStrongBinder);
                }
            }
            zzats.zzc(parcel);
            zzf(zzbti, zzbtx);
        } else if (i2 == 2) {
            zzbti zzbti2 = (zzbti) zzats.zza(parcel, zzbti.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (queryLocalInterface2 instanceof zzbtx) {
                    zzbtx zzbtx2 = (zzbtx) queryLocalInterface2;
                }
            }
            zzats.zzc(parcel);
        } else if (i2 != 3) {
            return false;
        } else {
            zzbtm zzbtm = (zzbtm) zzats.zza(parcel, zzbtm.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (queryLocalInterface3 instanceof zzbtx) {
                    zzbtx = (zzbtx) queryLocalInterface3;
                } else {
                    zzbtx = new zzbtv(readStrongBinder3);
                }
            }
            zzats.zzc(parcel);
            zze(zzbtm, zzbtx);
        }
        parcel2.writeNoException();
        return true;
    }
}
