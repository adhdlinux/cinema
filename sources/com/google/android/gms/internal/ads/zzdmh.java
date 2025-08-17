package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzdt;

public final class zzdmh extends VideoController.VideoLifecycleCallbacks {
    private final zzdha zza;

    public zzdmh(zzdha zzdha) {
        this.zza = zzdha;
    }

    private static zzdt zza(zzdha zzdha) {
        zzdq zzj = zzdha.zzj();
        if (zzj == null) {
            return null;
        }
        try {
            return zzj.zzi();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void onVideoEnd() {
        zzdt zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zze();
            } catch (RemoteException e2) {
                zzbzr.zzk("Unable to call onVideoEnd()", e2);
            }
        }
    }

    public final void onVideoPause() {
        zzdt zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzg();
            } catch (RemoteException e2) {
                zzbzr.zzk("Unable to call onVideoEnd()", e2);
            }
        }
    }

    public final void onVideoStart() {
        zzdt zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzi();
            } catch (RemoteException e2) {
                zzbzr.zzk("Unable to call onVideoEnd()", e2);
            }
        }
    }
}
