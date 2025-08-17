package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;

public final class zzdr extends zzatq implements zzdt {
    zzdr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void zze() throws RemoteException {
        zzbh(4, zza());
    }

    public final void zzf(boolean z2) throws RemoteException {
        Parcel zza = zza();
        int i2 = zzats.zza;
        zza.writeInt(z2 ? 1 : 0);
        zzbh(5, zza);
    }

    public final void zzg() throws RemoteException {
        zzbh(3, zza());
    }

    public final void zzh() throws RemoteException {
        zzbh(2, zza());
    }

    public final void zzi() throws RemoteException {
        zzbh(1, zza());
    }
}
