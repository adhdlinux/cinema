package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public abstract class zzbob extends zzatr implements zzboc {
    public zzbob() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzboc zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if (queryLocalInterface instanceof zzboc) {
            return (zzboc) queryLocalInterface;
        }
        return new zzboa(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                int readInt = parcel.readInt();
                zzats.zzc(parcel);
                zzg(readInt);
                break;
            case 4:
                zzn();
                break;
            case 5:
                zzp();
                break;
            case 6:
                zzo();
                break;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (queryLocalInterface instanceof zzbog) {
                        zzbog zzbog = (zzbog) queryLocalInterface;
                    }
                }
                zzats.zzc(parcel);
                break;
            case 8:
                zzm();
                break;
            case 9:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                zzats.zzc(parcel);
                zzq(readString, readString2);
                break;
            case 10:
                zzbfk.zzb(parcel.readStrongBinder());
                parcel.readString();
                zzats.zzc(parcel);
                break;
            case 11:
                zzv();
                break;
            case 12:
                parcel.readString();
                zzats.zzc(parcel);
                break;
            case 13:
                zzy();
                break;
            case 14:
                zzats.zzc(parcel);
                zzs((zzbvg) zzats.zza(parcel, zzbvg.CREATOR));
                break;
            case 15:
                zzw();
                break;
            case 16:
                zzbvk zzb = zzbvj.zzb(parcel.readStrongBinder());
                zzats.zzc(parcel);
                zzt(zzb);
                break;
            case 17:
                int readInt2 = parcel.readInt();
                zzats.zzc(parcel);
                zzj(readInt2);
                break;
            case 18:
                zzu();
                break;
            case 19:
                Bundle bundle = (Bundle) zzats.zza(parcel, Bundle.CREATOR);
                zzats.zzc(parcel);
                break;
            case 20:
                zzx();
                break;
            case 21:
                String readString3 = parcel.readString();
                zzats.zzc(parcel);
                zzl(readString3);
                break;
            case 22:
                int readInt3 = parcel.readInt();
                String readString4 = parcel.readString();
                zzats.zzc(parcel);
                zzi(readInt3, readString4);
                break;
            case 23:
                zzats.zzc(parcel);
                zzh((zze) zzats.zza(parcel, zze.CREATOR));
                break;
            case 24:
                zzats.zzc(parcel);
                zzk((zze) zzats.zza(parcel, zze.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
