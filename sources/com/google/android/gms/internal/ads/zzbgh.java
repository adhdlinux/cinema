package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzbgh extends zzatr implements zzbgi {
    public zzbgh() {
        super("com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
    }

    public static zzbgi zzc(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
        if (queryLocalInterface instanceof zzbgi) {
            return (zzbgi) queryLocalInterface;
        }
        return new zzbgg(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 2) {
            return false;
        }
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        zzats.zzc(parcel);
        boolean zzb = zzb(asInterface);
        parcel2.writeNoException();
        parcel2.writeInt(zzb ? 1 : 0);
        return true;
    }
}
