package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzbrl extends zzatr implements zzbrm {
    public zzbrl() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzbrm zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        if (queryLocalInterface instanceof zzbrm) {
            return (zzbrm) queryLocalInterface;
        }
        return new zzbrk(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzats.zzc(parcel);
            zze((Intent) zzats.zza(parcel, Intent.CREATOR));
        } else if (i2 == 2) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            zzats.zzc(parcel);
            zzi(asInterface, readString, readString2);
        } else if (i2 == 3) {
            zzh();
        } else if (i2 == 4) {
            IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzats.zzc(parcel);
            zzg(asInterface2);
        } else if (i2 != 5) {
            return false;
        } else {
            String[] createStringArray = parcel.createStringArray();
            int[] createIntArray = parcel.createIntArray();
            IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzats.zzc(parcel);
            zzf(createStringArray, createIntArray, asInterface3);
        }
        parcel2.writeNoException();
        return true;
    }
}
