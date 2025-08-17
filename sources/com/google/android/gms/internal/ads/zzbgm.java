package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzbgm extends zzatq implements zzbgo {
    zzbgm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    public final void zzA() throws RemoteException {
        zzbh(28, zza());
    }

    public final void zzB(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, bundle);
        zzbh(17, zza);
    }

    public final void zzC() throws RemoteException {
        zzbh(27, zza());
    }

    public final void zzD(zzcs zzcs) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzcs);
        zzbh(26, zza);
    }

    public final void zzE(zzdg zzdg) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzdg);
        zzbh(32, zza);
    }

    public final void zzF(zzbgl zzbgl) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbgl);
        zzbh(21, zza);
    }

    public final boolean zzG() throws RemoteException {
        Parcel zzbg = zzbg(30, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final boolean zzH() throws RemoteException {
        Parcel zzbg = zzbg(24, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final boolean zzI(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, bundle);
        Parcel zzbg = zzbg(16, zza);
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final double zze() throws RemoteException {
        Parcel zzbg = zzbg(8, zza());
        double readDouble = zzbg.readDouble();
        zzbg.recycle();
        return readDouble;
    }

    public final Bundle zzf() throws RemoteException {
        Parcel zzbg = zzbg(20, zza());
        Bundle bundle = (Bundle) zzats.zza(zzbg, Bundle.CREATOR);
        zzbg.recycle();
        return bundle;
    }

    public final zzdn zzg() throws RemoteException {
        Parcel zzbg = zzbg(31, zza());
        zzdn zzb = zzdm.zzb(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzb;
    }

    public final zzdq zzh() throws RemoteException {
        Parcel zzbg = zzbg(11, zza());
        zzdq zzb = zzdp.zzb(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbej zzi() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 14
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IAttributionInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbej
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbej r1 = (com.google.android.gms.internal.ads.zzbej) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbeh r2 = new com.google.android.gms.internal.ads.zzbeh
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgm.zzi():com.google.android.gms.internal.ads.zzbej");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbeo zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 29
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbeo
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbeo r1 = (com.google.android.gms.internal.ads.zzbeo) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbem r2 = new com.google.android.gms.internal.ads.zzbem
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgm.zzj():com.google.android.gms.internal.ads.zzbeo");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzber zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 5
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzber
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzber r1 = (com.google.android.gms.internal.ads.zzber) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzbep r2 = new com.google.android.gms.internal.ads.zzbep
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgm.zzk():com.google.android.gms.internal.ads.zzber");
    }

    public final IObjectWrapper zzl() throws RemoteException {
        Parcel zzbg = zzbg(19, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbg.readStrongBinder());
        zzbg.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzm() throws RemoteException {
        Parcel zzbg = zzbg(18, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbg.readStrongBinder());
        zzbg.recycle();
        return asInterface;
    }

    public final String zzn() throws RemoteException {
        Parcel zzbg = zzbg(7, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzo() throws RemoteException {
        Parcel zzbg = zzbg(4, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzp() throws RemoteException {
        Parcel zzbg = zzbg(6, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzq() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzr() throws RemoteException {
        Parcel zzbg = zzbg(12, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzs() throws RemoteException {
        Parcel zzbg = zzbg(10, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzt() throws RemoteException {
        Parcel zzbg = zzbg(9, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final List zzu() throws RemoteException {
        Parcel zzbg = zzbg(3, zza());
        ArrayList zzb = zzats.zzb(zzbg);
        zzbg.recycle();
        return zzb;
    }

    public final List zzv() throws RemoteException {
        Parcel zzbg = zzbg(23, zza());
        ArrayList zzb = zzats.zzb(zzbg);
        zzbg.recycle();
        return zzb;
    }

    public final void zzw() throws RemoteException {
        zzbh(22, zza());
    }

    public final void zzx() throws RemoteException {
        zzbh(13, zza());
    }

    public final void zzy(zzcw zzcw) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzcw);
        zzbh(25, zza);
    }

    public final void zzz(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, bundle);
        zzbh(15, zza);
    }
}
