package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public final class zzbnx extends zzatq implements zzbnz {
    zzbnx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void zzA(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzl);
        zza.writeString(str);
        zzats.zzf(zza, zzboc);
        zzbh(28, zza);
    }

    public final void zzB(zzl zzl, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzC(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzl);
        zza.writeString(str);
        zzats.zzf(zza, zzboc);
        zzbh(32, zza);
    }

    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(21, zza);
    }

    public final void zzE() throws RemoteException {
        zzbh(8, zza());
    }

    public final void zzF() throws RemoteException {
        zzbh(9, zza());
    }

    public final void zzG(boolean z2) throws RemoteException {
        Parcel zza = zza();
        int i2 = zzats.zza;
        zza.writeInt(z2 ? 1 : 0);
        zzbh(25, zza);
    }

    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(39, zza);
    }

    public final void zzI() throws RemoteException {
        zzbh(4, zza());
    }

    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(37, zza);
    }

    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(30, zza);
    }

    public final void zzL() throws RemoteException {
        zzbh(12, zza());
    }

    public final boolean zzM() throws RemoteException {
        Parcel zzbg = zzbg(22, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    public final boolean zzN() throws RemoteException {
        Parcel zzbg = zzbg(13, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzboh zzO() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 15
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzboh
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzboh r1 = (com.google.android.gms.internal.ads.zzboh) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzboh r2 = new com.google.android.gms.internal.ads.zzboh
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnx.zzO():com.google.android.gms.internal.ads.zzboh");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzboi zzP() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 16
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzboi
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzboi r1 = (com.google.android.gms.internal.ads.zzboi) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzboi r2 = new com.google.android.gms.internal.ads.zzboi
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnx.zzP():com.google.android.gms.internal.ads.zzboi");
    }

    public final Bundle zze() throws RemoteException {
        throw null;
    }

    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    public final zzdq zzh() throws RemoteException {
        Parcel zzbg = zzbg(26, zza());
        zzdq zzb = zzdp.zzb(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzb;
    }

    public final zzbfl zzi() throws RemoteException {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbof zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 36
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbof
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbof r1 = (com.google.android.gms.internal.ads.zzbof) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbod r2 = new com.google.android.gms.internal.ads.zzbod
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnx.zzj():com.google.android.gms.internal.ads.zzbof");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbol zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 27
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbol
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbol r1 = (com.google.android.gms.internal.ads.zzbol) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzboj r2 = new com.google.android.gms.internal.ads.zzboj
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnx.zzk():com.google.android.gms.internal.ads.zzbol");
    }

    public final zzbqh zzl() throws RemoteException {
        Parcel zzbg = zzbg(33, zza());
        zzbqh zzbqh = (zzbqh) zzats.zza(zzbg, zzbqh.CREATOR);
        zzbg.recycle();
        return zzbqh;
    }

    public final zzbqh zzm() throws RemoteException {
        Parcel zzbg = zzbg(34, zza());
        zzbqh zzbqh = (zzbqh) zzats.zza(zzbg, zzbqh.CREATOR);
        zzbg.recycle();
        return zzbqh;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbg.readStrongBinder());
        zzbg.recycle();
        return asInterface;
    }

    public final void zzo() throws RemoteException {
        zzbh(5, zza());
    }

    public final void zzp(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbvf zzbvf, String str2) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzl);
        zza.writeString((String) null);
        zzats.zzf(zza, zzbvf);
        zza.writeString(str2);
        zzbh(10, zza);
    }

    public final void zzq(IObjectWrapper iObjectWrapper, zzbkj zzbkj, List list) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbkj);
        zza.writeTypedList(list);
        zzbh(31, zza);
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzbvf zzbvf, List list) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbvf);
        zza.writeStringList(list);
        zzbh(23, zza);
    }

    public final void zzs(zzl zzl, String str) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzl);
        zza.writeString(str);
        zzbh(11, zza);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzl);
        zza.writeString(str);
        zzats.zzf(zza, zzboc);
        zzbh(38, zza);
    }

    public final void zzu(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, zzboc zzboc) throws RemoteException {
        throw null;
    }

    public final void zzv(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, String str2, zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzq);
        zzats.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzf(zza, zzboc);
        zzbh(6, zza);
    }

    public final void zzw(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, String str2, zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzq);
        zzats.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzf(zza, zzboc);
        zzbh(35, zza);
    }

    public final void zzx(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzboc zzboc) throws RemoteException {
        throw null;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzl zzl, String str, String str2, zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzf(zza, zzboc);
        zzbh(7, zza);
    }

    public final void zzz(IObjectWrapper iObjectWrapper, zzl zzl, String str, String str2, zzboc zzboc, zzbef zzbef, List list) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzf(zza, zzboc);
        zzats.zzd(zza, zzbef);
        zza.writeStringList(list);
        zzbh(14, zza);
    }
}
