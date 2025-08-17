package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public final /* synthetic */ class zzejy implements zzcvj {
    public final /* synthetic */ zzejm zza;
    public final /* synthetic */ zzbla zzb;

    public /* synthetic */ zzejy(zzejm zzejm, zzbla zzbla) {
        this.zza = zzejm;
        this.zzb = zzbla;
    }

    public final void zza(zze zze) {
        zzejm zzejm = this.zza;
        zzbla zzbla = this.zzb;
        zzejm.zza(zze);
        if (zzbla != null) {
            try {
                zzbla.zzf(zze);
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
            }
        }
        if (zzbla != null) {
            try {
                zzbla.zze(zze.zza);
            } catch (RemoteException e3) {
                zzbzr.zzl("#007 Could not call remote method.", e3);
            }
        }
    }
}
