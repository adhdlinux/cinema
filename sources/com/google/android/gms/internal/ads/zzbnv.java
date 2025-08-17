package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbnv extends zzatr implements zzbnw {
    public zzbnv() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbnw zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzbnw) {
            return (zzbnw) queryLocalInterface;
        }
        return new zzbnu(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String readString = parcel.readString();
            zzats.zzc(parcel);
            zzbnz zzb = zzb(readString);
            parcel2.writeNoException();
            zzats.zzf(parcel2, zzb);
        } else if (i2 == 2) {
            String readString2 = parcel.readString();
            zzats.zzc(parcel);
            boolean zze = zze(readString2);
            parcel2.writeNoException();
            parcel2.writeInt(zze ? 1 : 0);
        } else if (i2 == 3) {
            String readString3 = parcel.readString();
            zzats.zzc(parcel);
            zzbpt zzc = zzc(readString3);
            parcel2.writeNoException();
            zzats.zzf(parcel2, zzc);
        } else if (i2 != 4) {
            return false;
        } else {
            String readString4 = parcel.readString();
            zzats.zzc(parcel);
            boolean zzd = zzd(readString4);
            parcel2.writeNoException();
            parcel2.writeInt(zzd ? 1 : 0);
        }
        return true;
    }
}
