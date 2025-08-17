package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public abstract class zzbtp extends zzatr implements zzbtq {
    public zzbtp() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzbua zzbua = null;
        if (i2 == 1) {
            zzbtf zzbtf = (zzbtf) zzats.zza(parcel, zzbtf.CREATOR);
            zzats.zzc(parcel);
            parcel2.writeNoException();
            zzats.zze(parcel2, (Parcelable) null);
        } else if (i2 == 2) {
            zzbtf zzbtf2 = (zzbtf) zzats.zza(parcel, zzbtf.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                if (queryLocalInterface instanceof zzbtr) {
                    zzbtr zzbtr = (zzbtr) queryLocalInterface;
                }
            }
            zzats.zzc(parcel);
            parcel2.writeNoException();
        } else if (i2 == 4) {
            zzbue zzbue = (zzbue) zzats.zza(parcel, zzbue.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface2 instanceof zzbua) {
                    zzbua = (zzbua) queryLocalInterface2;
                } else {
                    zzbua = new zzbty(readStrongBinder2);
                }
            }
            zzats.zzc(parcel);
            zzg(zzbue, zzbua);
            parcel2.writeNoException();
        } else if (i2 == 5) {
            zzbue zzbue2 = (zzbue) zzats.zza(parcel, zzbue.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface3 instanceof zzbua) {
                    zzbua = (zzbua) queryLocalInterface3;
                } else {
                    zzbua = new zzbty(readStrongBinder3);
                }
            }
            zzats.zzc(parcel);
            zzf(zzbue2, zzbua);
            parcel2.writeNoException();
        } else if (i2 == 6) {
            zzbue zzbue3 = (zzbue) zzats.zza(parcel, zzbue.CREATOR);
            IBinder readStrongBinder4 = parcel.readStrongBinder();
            if (readStrongBinder4 != null) {
                IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface4 instanceof zzbua) {
                    zzbua = (zzbua) queryLocalInterface4;
                } else {
                    zzbua = new zzbty(readStrongBinder4);
                }
            }
            zzats.zzc(parcel);
            zze(zzbue3, zzbua);
            parcel2.writeNoException();
        } else if (i2 != 7) {
            return false;
        } else {
            String readString = parcel.readString();
            IBinder readStrongBinder5 = parcel.readStrongBinder();
            if (readStrongBinder5 != null) {
                IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface5 instanceof zzbua) {
                    zzbua = (zzbua) queryLocalInterface5;
                } else {
                    zzbua = new zzbty(readStrongBinder5);
                }
            }
            zzats.zzc(parcel);
            zzh(readString, zzbua);
            parcel2.writeNoException();
        }
        return true;
    }
}
