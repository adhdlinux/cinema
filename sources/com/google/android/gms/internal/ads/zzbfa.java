package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzbfa extends zzatr implements zzbfb {
    public zzbfa() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public static zzbfb zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        if (queryLocalInterface instanceof zzbfb) {
            return (zzbfb) queryLocalInterface;
        }
        return new zzbez(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzats.zzc(parcel);
            zzc(asInterface);
        } else if (i2 == 2) {
            zzd();
        } else if (i2 != 3) {
            return false;
        } else {
            IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzats.zzc(parcel);
            zzb(asInterface2);
        }
        parcel2.writeNoException();
        return true;
    }
}
