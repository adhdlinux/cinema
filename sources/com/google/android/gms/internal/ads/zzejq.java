package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbe;

public final class zzejq implements zza, zzdcu {
    private zzbe zza;

    public final synchronized void onAdClicked() {
        zzbe zzbe = this.zza;
        if (zzbe != null) {
            try {
                zzbe.zzb();
            } catch (RemoteException e2) {
                zzbzr.zzk("Remote Exception at onAdClicked.", e2);
            }
        }
    }

    public final synchronized void zza(zzbe zzbe) {
        this.zza = zzbe;
    }

    public final synchronized void zzr() {
        zzbe zzbe = this.zza;
        if (zzbe != null) {
            try {
                zzbe.zzb();
            } catch (RemoteException e2) {
                zzbzr.zzk("Remote Exception at onPhysicalClick.", e2);
            }
        }
    }

    public final synchronized void zzs() {
    }
}
