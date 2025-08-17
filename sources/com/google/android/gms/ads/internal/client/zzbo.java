package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbfp;
import com.google.android.gms.internal.ads.zzbfs;
import com.google.android.gms.internal.ads.zzbfv;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzbkr;
import com.google.android.gms.internal.ads.zzbla;

public final class zzbo extends zzatq implements zzbq {
    zzbo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzbn zze() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 1
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbg(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoader"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzbn
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.ads.internal.client.zzbn r1 = (com.google.android.gms.ads.internal.client.zzbn) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.ads.internal.client.zzbl r2 = new com.google.android.gms.ads.internal.client.zzbl
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbo.zze():com.google.android.gms.ads.internal.client.zzbn");
    }

    public final void zzf(zzbfp zzbfp) throws RemoteException {
        throw null;
    }

    public final void zzg(zzbfs zzbfs) throws RemoteException {
        throw null;
    }

    public final void zzh(String str, zzbfy zzbfy, zzbfv zzbfv) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzats.zzf(zza, zzbfy);
        zzats.zzf(zza, zzbfv);
        zzbh(5, zza);
    }

    public final void zzi(zzbla zzbla) throws RemoteException {
        throw null;
    }

    public final void zzj(zzbgc zzbgc, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbgc);
        zzats.zzd(zza, zzq);
        zzbh(8, zza);
    }

    public final void zzk(zzbgf zzbgf) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbgf);
        zzbh(10, zza);
    }

    public final void zzl(zzbh zzbh) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbh);
        zzbh(2, zza);
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, adManagerAdViewOptions);
        zzbh(15, zza);
    }

    public final void zzn(zzbkr zzbkr) throws RemoteException {
        throw null;
    }

    public final void zzo(zzbef zzbef) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbef);
        zzbh(6, zza);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        throw null;
    }

    public final void zzq(zzcf zzcf) throws RemoteException {
        throw null;
    }
}
