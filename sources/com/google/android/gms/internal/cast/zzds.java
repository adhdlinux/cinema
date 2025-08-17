package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzds extends zza {
    zzds(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
    }

    public final void zze() throws RemoteException {
        zzd(3, zza());
    }

    public final void zzf(zzdr zzdr, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzdr);
        zza.writeInt(i2);
        zzd(5, zza);
    }

    public final void zzg(zzdr zzdr, zzdu zzdu, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzdr);
        zzc.zze(zza, zzdu);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, bundle);
        zzd(7, zza);
    }

    public final void zzh(zzdr zzdr, PendingIntent pendingIntent, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzdr);
        zzc.zzc(zza, pendingIntent);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, bundle);
        zzd(8, zza);
    }

    public final void zzi(zzdr zzdr) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzdr);
        zzd(6, zza);
    }
}
