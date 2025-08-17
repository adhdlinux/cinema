package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public final class zzbeh extends zzatq implements zzbej {
    zzbeh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public final String zzg() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final List zzh() throws RemoteException {
        Parcel zzbg = zzbg(3, zza());
        ArrayList zzb = zzats.zzb(zzbg);
        zzbg.recycle();
        return zzb;
    }
}
