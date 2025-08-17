package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzah extends zzb implements zzai {
    public zzah() {
        super("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                int readInt = parcel.readInt();
                zzc.zzb(parcel);
                zzk(readInt);
                return true;
            case 2:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                boolean zzf = zzc.zzf(parcel);
                zzc.zzb(parcel);
                zzb((ApplicationMetadata) zzc.zza(parcel, ApplicationMetadata.CREATOR), readString, readString2, zzf);
                return true;
            case 3:
                int readInt2 = parcel.readInt();
                zzc.zzb(parcel);
                zzc(readInt2);
                return true;
            case 4:
                String readString3 = parcel.readString();
                double readDouble = parcel.readDouble();
                boolean zzf2 = zzc.zzf(parcel);
                zzc.zzb(parcel);
                zzn(readString3, readDouble, zzf2);
                return true;
            case 5:
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                zzc.zzb(parcel);
                zzp(readString4, readString5);
                return true;
            case 6:
                String readString6 = parcel.readString();
                byte[] createByteArray = parcel.createByteArray();
                zzc.zzb(parcel);
                zzh(readString6, createByteArray);
                return true;
            case 7:
                int readInt3 = parcel.readInt();
                zzc.zzb(parcel);
                zze(readInt3);
                return true;
            case 8:
                int readInt4 = parcel.readInt();
                zzc.zzb(parcel);
                zzg(readInt4);
                return true;
            case 9:
                int readInt5 = parcel.readInt();
                zzc.zzb(parcel);
                zzd(readInt5);
                return true;
            case 10:
                String readString7 = parcel.readString();
                long readLong = parcel.readLong();
                int readInt6 = parcel.readInt();
                zzc.zzb(parcel);
                zzm(readString7, readLong, readInt6);
                return true;
            case 11:
                String readString8 = parcel.readString();
                long readLong2 = parcel.readLong();
                zzc.zzb(parcel);
                zzl(readString8, readLong2);
                return true;
            case 12:
                zzc.zzb(parcel);
                zzf((zza) zzc.zza(parcel, zza.CREATOR));
                return true;
            case 13:
                zzc.zzb(parcel);
                zzj((zzab) zzc.zza(parcel, zzab.CREATOR));
                return true;
            case 14:
                int readInt7 = parcel.readInt();
                zzc.zzb(parcel);
                zzi(readInt7);
                return true;
            case 15:
                int readInt8 = parcel.readInt();
                zzc.zzb(parcel);
                zzo(readInt8);
                return true;
            default:
                return false;
        }
    }
}
