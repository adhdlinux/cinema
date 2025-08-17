package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzavw;
import com.google.android.gms.internal.ads.zzbck;
import com.google.android.gms.internal.ads.zzbsc;
import com.google.android.gms.internal.ads.zzbsf;
import com.google.android.gms.internal.ads.zzbva;

public final class zzbs extends zzatq implements zzbu {
    zzbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public final void zzA() throws RemoteException {
        zzbh(11, zza());
    }

    public final void zzB() throws RemoteException {
        zzbh(6, zza());
    }

    public final void zzC(zzbe zzbe) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbe);
        zzbh(20, zza);
    }

    public final void zzD(zzbh zzbh) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbh);
        zzbh(7, zza);
    }

    public final void zzE(zzby zzby) throws RemoteException {
        throw null;
    }

    public final void zzF(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzq);
        zzbh(13, zza);
    }

    public final void zzG(zzcb zzcb) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzcb);
        zzbh(8, zza);
    }

    public final void zzH(zzavw zzavw) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzavw);
        zzbh(40, zza);
    }

    public final void zzI(zzw zzw) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzw);
        zzbh(39, zza);
    }

    public final void zzJ(zzci zzci) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzci);
        zzbh(45, zza);
    }

    public final void zzK(zzdu zzdu) throws RemoteException {
        throw null;
    }

    public final void zzL(boolean z2) throws RemoteException {
        Parcel zza = zza();
        int i2 = zzats.zza;
        zza.writeInt(z2 ? 1 : 0);
        zzbh(34, zza);
    }

    public final void zzM(zzbsc zzbsc) throws RemoteException {
        throw null;
    }

    public final void zzN(boolean z2) throws RemoteException {
        Parcel zza = zza();
        int i2 = zzats.zza;
        zza.writeInt(z2 ? 1 : 0);
        zzbh(22, zza);
    }

    public final void zzO(zzbck zzbck) throws RemoteException {
        throw null;
    }

    public final void zzP(zzdg zzdg) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzdg);
        zzbh(42, zza);
    }

    public final void zzQ(zzbsf zzbsf, String str) throws RemoteException {
        throw null;
    }

    public final void zzR(String str) throws RemoteException {
        throw null;
    }

    public final void zzS(zzbva zzbva) throws RemoteException {
        throw null;
    }

    public final void zzT(String str) throws RemoteException {
        throw null;
    }

    public final void zzU(zzfl zzfl) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzfl);
        zzbh(29, zza);
    }

    public final void zzW(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(44, zza);
    }

    public final void zzX() throws RemoteException {
        throw null;
    }

    public final boolean zzY() throws RemoteException {
        Parcel zzbg = zzbg(23, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final boolean zzZ() throws RemoteException {
        throw null;
    }

    public final boolean zzaa(zzl zzl) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzl);
        Parcel zzbg = zzbg(4, zza);
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final void zzab(zzcf zzcf) throws RemoteException {
        throw null;
    }

    public final Bundle zzd() throws RemoteException {
        throw null;
    }

    public final zzq zzg() throws RemoteException {
        Parcel zzbg = zzbg(12, zza());
        zzq zzq = (zzq) zzats.zza(zzbg, zzq.CREATOR);
        zzbg.recycle();
        return zzq;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzbh zzi() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 33
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzbh
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzbh r1 = (com.google.android.gms.ads.internal.client.zzbh) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzbf r2 = new com.google.android.gms.ads.internal.client.zzbf
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbs.zzi():com.google.android.gms.ads.internal.client.zzbh");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzcb zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 32
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzcb
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzcb r1 = (com.google.android.gms.ads.internal.client.zzcb) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzbz r2 = new com.google.android.gms.ads.internal.client.zzbz
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbs.zzj():com.google.android.gms.ads.internal.client.zzcb");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzdn zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 41
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IResponseInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzdn
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzdn r1 = (com.google.android.gms.ads.internal.client.zzdn) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzdl r2 = new com.google.android.gms.ads.internal.client.zzdl
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbs.zzk():com.google.android.gms.ads.internal.client.zzdn");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzdq zzl() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 26
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoController"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzdq
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzdq r1 = (com.google.android.gms.ads.internal.client.zzdq) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzdo r2 = new com.google.android.gms.ads.internal.client.zzdo
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbs.zzl():com.google.android.gms.ads.internal.client.zzdq");
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzbg = zzbg(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbg.readStrongBinder());
        zzbg.recycle();
        return asInterface;
    }

    public final String zzr() throws RemoteException {
        Parcel zzbg = zzbg(31, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    public final String zzs() throws RemoteException {
        throw null;
    }

    public final String zzt() throws RemoteException {
        throw null;
    }

    public final void zzx() throws RemoteException {
        zzbh(2, zza());
    }

    public final void zzy(zzl zzl, zzbk zzbk) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzl);
        zzats.zzf(zza, zzbk);
        zzbh(43, zza);
    }

    public final void zzz() throws RemoteException {
        zzbh(5, zza());
    }
}
