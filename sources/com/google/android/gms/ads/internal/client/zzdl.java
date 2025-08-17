package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;
import java.util.ArrayList;
import java.util.List;

public final class zzdl extends zzatq implements zzdn {
    zzdl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public final Bundle zze() throws RemoteException {
        Parcel zzbg = zzbg(5, zza());
        Bundle bundle = (Bundle) zzats.zza(zzbg, Bundle.CREATOR);
        zzbg.recycle();
        return bundle;
    }

    public final zzu zzf() throws RemoteException {
        Parcel zzbg = zzbg(4, zza());
        zzu zzu = (zzu) zzats.zza(zzbg, zzu.CREATOR);
        zzbg.recycle();
        return zzu;
    }

    public final String zzg() throws RemoteException {
        Parcel zzbg = zzbg(1, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzh() throws RemoteException {
        Parcel zzbg = zzbg(6, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzi() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final List zzj() throws RemoteException {
        Parcel zzbg = zzbg(3, zza());
        ArrayList<zzu> createTypedArrayList = zzbg.createTypedArrayList(zzu.CREATOR);
        zzbg.recycle();
        return createTypedArrayList;
    }
}
