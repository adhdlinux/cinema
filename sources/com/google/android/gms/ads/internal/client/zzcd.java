package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzatr;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbfb;
import com.google.android.gms.internal.ads.zzbjf;
import com.google.android.gms.internal.ads.zzbjg;
import com.google.android.gms.internal.ads.zzbjj;
import com.google.android.gms.internal.ads.zzbnv;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbrm;
import com.google.android.gms.internal.ads.zzbrt;
import com.google.android.gms.internal.ads.zzbux;
import com.google.android.gms.internal.ads.zzbvn;
import com.google.android.gms.internal.ads.zzbyi;

public abstract class zzcd extends zzatr implements zzce {
    public zzcd() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                String readString = parcel.readString();
                zzbnw zzf = zzbnv.zzf(parcel.readStrongBinder());
                int readInt = parcel.readInt();
                zzats.zzc(parcel);
                zzbu zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzats.zza(parcel, zzq.CREATOR), readString, zzf, readInt);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzd);
                return true;
            case 2:
                String readString2 = parcel.readString();
                zzbnw zzf2 = zzbnv.zzf(parcel.readStrongBinder());
                int readInt2 = parcel.readInt();
                zzats.zzc(parcel);
                zzbu zze = zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzats.zza(parcel, zzq.CREATOR), readString2, zzf2, readInt2);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zze);
                return true;
            case 3:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString3 = parcel.readString();
                zzbnw zzf3 = zzbnv.zzf(parcel.readStrongBinder());
                int readInt3 = parcel.readInt();
                zzats.zzc(parcel);
                zzbq zzb = zzb(asInterface, readString3, zzf3, readInt3);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzb);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzats.zzc(parcel);
                parcel2.writeNoException();
                zzats.zzf(parcel2, (IInterface) null);
                return true;
            case 5:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzats.zzc(parcel);
                zzbev zzi = zzi(asInterface2, asInterface3);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzi);
                return true;
            case 6:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbnw zzf4 = zzbnv.zzf(parcel.readStrongBinder());
                int readInt4 = parcel.readInt();
                zzats.zzc(parcel);
                zzbux zzn = zzn(asInterface4, zzf4, readInt4);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzn);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzats.zzc(parcel);
                parcel2.writeNoException();
                zzats.zzf(parcel2, (IInterface) null);
                return true;
            case 8:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzats.zzc(parcel);
                zzbrt zzm = zzm(asInterface5);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzm);
                return true;
            case 9:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int readInt5 = parcel.readInt();
                zzats.zzc(parcel);
                zzco zzg = zzg(asInterface6, readInt5);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzg);
                return true;
            case 10:
                String readString4 = parcel.readString();
                int readInt6 = parcel.readInt();
                zzats.zzc(parcel);
                zzbu zzf5 = zzf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzats.zza(parcel, zzq.CREATOR), readString4, readInt6);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzf5);
                return true;
            case 11:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzats.zzc(parcel);
                zzbfb zzj = zzj(asInterface7, asInterface8, asInterface9);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzj);
                return true;
            case 12:
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString5 = parcel.readString();
                zzbnw zzf6 = zzbnv.zzf(parcel.readStrongBinder());
                int readInt7 = parcel.readInt();
                zzats.zzc(parcel);
                zzbvn zzo = zzo(asInterface10, readString5, zzf6, readInt7);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzo);
                return true;
            case 13:
                String readString6 = parcel.readString();
                zzbnw zzf7 = zzbnv.zzf(parcel.readStrongBinder());
                int readInt8 = parcel.readInt();
                zzats.zzc(parcel);
                zzbu zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzats.zza(parcel, zzq.CREATOR), readString6, zzf7, readInt8);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzc);
                return true;
            case 14:
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbnw zzf8 = zzbnv.zzf(parcel.readStrongBinder());
                int readInt9 = parcel.readInt();
                zzats.zzc(parcel);
                zzbyi zzp = zzp(asInterface11, zzf8, readInt9);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzp);
                return true;
            case 15:
                IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbnw zzf9 = zzbnv.zzf(parcel.readStrongBinder());
                int readInt10 = parcel.readInt();
                zzats.zzc(parcel);
                zzbrm zzl = zzl(asInterface12, zzf9, readInt10);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzl);
                return true;
            case 16:
                IObjectWrapper asInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbnw zzf10 = zzbnv.zzf(parcel.readStrongBinder());
                int readInt11 = parcel.readInt();
                zzbjg zzc2 = zzbjf.zzc(parcel.readStrongBinder());
                zzats.zzc(parcel);
                zzbjj zzk = zzk(asInterface13, zzf10, readInt11, zzc2);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzk);
                return true;
            case 17:
                IObjectWrapper asInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbnw zzf11 = zzbnv.zzf(parcel.readStrongBinder());
                int readInt12 = parcel.readInt();
                zzats.zzc(parcel);
                zzdj zzh = zzh(asInterface14, zzf11, readInt12);
                parcel2.writeNoException();
                zzats.zzf(parcel2, zzh);
                return true;
            default:
                return false;
        }
    }
}
