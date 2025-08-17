package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzaz;
import com.google.android.gms.ads.internal.util.zze;

final class zzdyq implements zzfvy {
    final /* synthetic */ zzbtx zza;

    zzdyq(zzdyr zzdyr, zzbtx zzbtx) {
        this.zza = zzbtx;
    }

    public final void zza(Throwable th) {
        try {
            this.zza.zze(zzaz.zzb(th));
        } catch (RemoteException e2) {
            zze.zzb("Ad service can't call client", e2);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zzf((ParcelFileDescriptor) obj);
        } catch (RemoteException e2) {
            zze.zzb("Ad service can't call client", e2);
        }
    }
}
