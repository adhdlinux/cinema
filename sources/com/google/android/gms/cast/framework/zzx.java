package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;
import java.util.Map;

public final class zzx extends zza implements zzz {
    zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastContext");
    }

    public final int zze() throws RemoteException {
        Parcel zzb = zzb(13, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final Bundle zzf() throws RemoteException {
        Parcel zzb = zzb(1, zza());
        Bundle bundle = (Bundle) zzc.zza(zzb, Bundle.CREATOR);
        zzb.recycle();
        return bundle;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.cast.framework.zzag zzg() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 6
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.cast.framework.IDiscoveryManager"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.cast.framework.zzag
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.cast.framework.zzag r1 = (com.google.android.gms.cast.framework.zzag) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.cast.framework.zzaf r2 = new com.google.android.gms.cast.framework.zzaf
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.zzx.zzg():com.google.android.gms.cast.framework.zzag");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.cast.framework.zzao zzh() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 5
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.cast.framework.ISessionManager"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.cast.framework.zzao
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.cast.framework.zzao r1 = (com.google.android.gms.cast.framework.zzao) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.cast.framework.zzan r2 = new com.google.android.gms.cast.framework.zzan
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.zzx.zzh():com.google.android.gms.cast.framework.zzao");
    }

    public final void zzi(zzu zzu) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzu);
        zzc(3, zza);
    }

    public final void zzj(boolean z2) throws RemoteException {
        Parcel zza = zza();
        int i2 = zzc.zza;
        zza.writeInt(0);
        zzc(14, zza);
    }

    public final void zzk(String str, Map map) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeMap(map);
        zzc(11, zza);
    }
}
