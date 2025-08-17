package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbvl extends zzatq implements zzbvn {
    zzbvl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public final Bundle zzb() throws RemoteException {
        Parcel zzbg = zzbg(9, zza());
        Bundle bundle = (Bundle) zzats.zza(zzbg, Bundle.CREATOR);
        zzbg.recycle();
        return bundle;
    }

    public final zzdn zzc() throws RemoteException {
        Parcel zzbg = zzbg(12, zza());
        zzdn zzb = zzdm.zzb(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbvk zzd() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 11
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbvk
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbvk r1 = (com.google.android.gms.internal.ads.zzbvk) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbvi r2 = new com.google.android.gms.internal.ads.zzbvi
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvl.zzd():com.google.android.gms.internal.ads.zzbvk");
    }

    public final String zze() throws RemoteException {
        throw null;
    }

    public final void zzf(zzl zzl, zzbvu zzbvu) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzl);
        zzats.zzf(zza, zzbvu);
        zzbh(1, zza);
    }

    public final void zzg(zzl zzl, zzbvu zzbvu) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzl);
        zzats.zzf(zza, zzbvu);
        zzbh(14, zza);
    }

    public final void zzh(boolean z2) throws RemoteException {
        Parcel zza = zza();
        int i2 = zzats.zza;
        zza.writeInt(z2 ? 1 : 0);
        zzbh(15, zza);
    }

    public final void zzi(zzdd zzdd) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzdd);
        zzbh(8, zza);
    }

    public final void zzj(zzdg zzdg) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzdg);
        zzbh(13, zza);
    }

    public final void zzk(zzbvq zzbvq) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbvq);
        zzbh(2, zza);
    }

    public final void zzl(zzbwb zzbwb) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbwb);
        zzbh(7, zza);
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(5, zza);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, boolean z2) throws RemoteException {
        throw null;
    }

    public final boolean zzo() throws RemoteException {
        throw null;
    }

    public final void zzp(zzbvv zzbvv) throws RemoteException {
        throw null;
    }
}
